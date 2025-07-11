package myframework.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * Mybatis 프레임웍의 설정은 java 클래스가 아닌 xml 문서로 구성되어 있다..
 * 하지만 xml은 프로그래밍 언어가 아니므로, java를 이용하여 xml을 해석해야 한다..
 * 아래의 클래스는 설정 xml 을 읽어들여, 쿼리 수행에 필요한 객체를 얻기 위한 설정 객체이다
 * Mybatis는 사실 내부적으로 개발자 대신 JDBC 를 제어하고 있다..하지만 mybatis를 사용할 경우
 * 개발자는 더이상 jdbc를 직접 제어하지 않는다. 대신 쿼리를 수행해주는 mybatis가 제공하는 객체를
 * 사용해야 한다. SqlSession 이라 한다~~ 따라서 이 객체는 db와의 CRUD를 담당하는 DAO가
 * 취득하면 된다..
 * */
public class MybatisConfig {
	private static MybatisConfig instance;
	private SqlSessionFactory sqlSessionFactory;
	
	private MybatisConfig() {
		//패키지라 할지라도 대상 자원이 java 클래스가 아니면, 일반 디렉토리 취급해야 한다..
		String resource = "myframework/mybatis/mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public static MybatisConfig getInstance() {
		if(instance==null) {
			instance = new MybatisConfig();
		}
		return instance;
	}
	
	//SqlSession 을 반환하는 메서드 정의 
	//SqlSession 은 쿼리문을 수행해주는 객체 (Connection, PreparedStateme, ResultSet 숨겨져 잇음)
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
}









