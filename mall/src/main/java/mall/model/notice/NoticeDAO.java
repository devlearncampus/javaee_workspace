package mall.model.notice;

import java.util.List;

import mall.domain.Notice;

/*
 * HibernateNoticeDAO 이건,  MybatisNoticeDAO, JdbcNoticeDAO 이건 상관없는 Noticeㅇ를 대상으로 한 
 * DAO들의 최상위 DAO 정의  
 * */
public interface NoticeDAO {
	public List selectAll();
	public Notice select(int notice_id);
	public void insert(Notice notice);
	public void update(Notice notice);
	public void delete(int notice_id);
	
}






