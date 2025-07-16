package mall.spring.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/*
 스프링의 고전적 설정을 담당하는 xml 을 대신하는 java class
*/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"mall.admin.controller, mall.notice.model"})
public class AdminWebConfig {

	/*하위 컨트롤러가 3,4단계를 수행한 후, DispatcherServlet 에게 정확한 파일명을 알려주는게 아니라
	 * 파일의 일부 단서만 반환한다(ModelAndView에 심어서), 따라서 이 객체를 넘겨받은 DispatcherServlet
	 * 은 일부 단서를 직접 해석하지 않고, View에 대한 해석을 담당하는 전담객체에 맡긴다..
	 * 이 View 영역을 전담하는 객체들을 가리켜 스프링에서는 ViewResolver 라 한다. 
	 * JSP 사용시 주로 사용되는 ViewResolver 는 InternalResourceViewResolver
	 * 
	 * 예시)  하위컨트롤러가    notice/list 를 심어서 보내면 -- >  /WEB-INF/views/   notice/list   .jsp
	 * */	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	//어떤 데이터베이스를 사용할지를 선택
	public DataSource dataSource() throws NamingException{
		JndiTemplate jndi=new JndiTemplate();
		return jndi.lookup("java:comp/env/jndi/mysql", DataSource.class);
	}
	
	/*--------------------------------------------------------------
	Mybatis 관련 
	--------------------------------------------------------------*/
	//스프링을 사용하는 이유는 기업용 애플리케이션 개발 시, 개발자가 일일이 처리해야 하는 반복된 작업을 대신 해주기 
	//때문, 스프링 이전 시대에는 이 작업을 EJB 기술이었음. 
	//규모가 큰 작업에서 개발자들의 반복된 작업을 대신하는 대표적 업무(트랜잭션 처리, 로깅, 보안 처리...)
	//JDBC 사용 시 데이터 소스가 결정되었다면, 그 다음은 적절한 트랜잭션 매니저를 등록해야 함 
	//사용 기술이 JDBC 기반 :  DataSourceTransactionManager 객체를 등록해야 하고, 
	//사용 기술이 Mybatis 기반 :  DataSourceTransactionManager 객체를 등록해야 하고,
	//사용 기술이 Hibernate 기반 : HibernateTransactionManager 객체를 등록해야 함..
	//이 객체를 등록한 이후부터는, 
	//1) 트랜잭션 개발자가 직접 처리하지 않아도 알아서 처리 (commit, rollback 호출하지 않음) 
	//2) 어떠한 기술을 사용하더라도, 코드에 변함이 없음(일관 된 코드)
	
	//Mybatis에 사용할 트랜잭션 매니저 선택
	@Bean 
	public PlatformTransactionManager platformTransactionManager(SqlSessionFactory sqlSessionFactory) {
		return new DataSourceTransactionManager(sqlSessionFactory.getConfiguration().getEnvironment().getDataSource());
	}
	
	//Mybatis의 SqlSession이 모여져 있는, SqlSessionFactory 를 빈으로 등록 
	@Bean 
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mall/mybatis/mybatis-config.xml")); //mybatis 설정파일 위치
		
		//SqlSessionFactoryBean 에게 사용할 DB를 알려줘야 함
		sqlSessionFactoryBean.setDataSource(dataSource());
		
		return sqlSessionFactoryBean.getObject();
	}
	
	//SqlSessionFactoryBean 으로 부터 쿼리문을 수행하는 객체의 원래 명칭은 SqlSession 이지만, mybatis-spring에서는 
	//이 객체를 랩핑한 객체인 SqlSessionTemplte 객체를 사용해야 함
	//결론: 순수 mybatis 에서의 SqlSessionFactory 는 mybatis-spring 명칭이 SqlSessionFactoryBean 으로 바뀌고
	//       순수 mybatis 에서의 SqlSession 는 SqlSessionTemplate 으로 명칭 바뀐것임..
	//DAO가 사용할 SqlSessionTemplte 등록 
	@Bean 
	public SqlSessionTemplate sqlSessionTemplate() throws Exception{
		return new SqlSessionTemplate(sqlSessionFactory());
	}
}


























