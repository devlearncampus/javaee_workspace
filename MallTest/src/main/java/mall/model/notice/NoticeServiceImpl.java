package mall.model.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import mall.domain.Notice;
import mall.exception.NoticeException;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService{

	//@Qualifier("mybatisNoticeDAO") //스프링 컨테이너가 보유한 여러 인스턴 중 원하는 아이디를??
	@Qualifier("hibernateNoticeDAO")
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Transactional
	public List selectAll() {
		log.debug("service의 selectAll() 도달");
		return noticeDAO.selectAll(); //DAO의 메서드 호출
	}

	@Override
	public Notice select(int notice_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void regist(Notice notice) throws NoticeException{
		noticeDAO.insert(notice); //다형성으로 동작!!!
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
