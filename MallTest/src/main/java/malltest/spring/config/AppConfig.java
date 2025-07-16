package malltest.spring.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.SessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "malltest.shop.model" )
public class AppConfig {

	//DataSource 등록 ( Mybatis, Hibernate 동일 ) 
	public DataSource dataSource() throws NamingException{
		JndiTemplate jndi=new JndiTemplate();
		return jndi.lookup("java:comp/env/jdbc/mysql", DataSource.class);
	}  		
	
	
	/*------------------------------------------------------------------------
	Mybatis 관련  
	------------------------------------------------------------------------*/
	
	//트랜잭션 매니저 등록
	@Bean
	public PlatformTransactionManager platformTransactionManager(SqlSessionFactory sqlSessionFactory) {		
		return new DataSourceTransactionManager(sqlSessionFactory.getConfiguration().getEnvironment().getDataSource());
	}
	
	//SqlSessionFactoryBean 등록
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("malltest/mybatis/mybatis-config.xml"));
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean.getObject();
	}
	
	
	//DAO가 사용할 SqlSessionTemplate 등록
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception{		
		return new SqlSessionTemplate(sqlSessionFactory());
	}

	/*------------------------------------------------------------------------
	Hibernate 관련  
	------------------------------------------------------------------------*/
    @Bean
    public LocalSessionFactoryBean sessionFactory() throws NamingException {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());

        factoryBean.setConfigLocation(new ClassPathResource("malltest/hibernate/hibernate.cfg.xml"));

        return factoryBean;
    }

    @Primary
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }	
}






