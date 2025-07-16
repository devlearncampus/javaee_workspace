package mall.notice.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import mall.domain.Notice;

//애플리케이션 설계 분야에서 CRUD 를 수행하는 역할을 가리켜 repository
//@EnableWebMvc 에의 @Controller, @Repository, @Service, @Component 등을 찾아 인스턴스
//생성하여 싱글턴으로관리 
@Slf4j
@Repository
public class MybatisNoticeDAO implements NoticeDAO{

	@Override
	public List selectAll() {
		log.debug("DAO의 selectAll() 도달");
		return null;
	}

	@Override
	public Notice select(int notice_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Notice notice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Notice notice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int notice_id) {
		// TODO Auto-generated method stub
		
	}

}
