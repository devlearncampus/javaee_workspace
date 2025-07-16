package mall.notice.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mall.domain.Notice;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService{

	@Qualifier("mybatisNoticeDAO") //스프링 컨테이너가 보유한 여러 인스턴 중 원하는 아이디를?? 
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List selectAll() {
		log.debug("service의 selectAll() 도달");
		noticeDAO.selectAll(); //DAO의 메서드 호출
		return null;
	}

	@Override
	public Notice select(int notice_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void regist(Notice notice) {
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
