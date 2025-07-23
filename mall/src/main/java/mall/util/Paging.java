package mall.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

//Component Scan의 대상이 되어 메모리에 인스턴스 생성됨
@Slf4j
@Component //개발자가 정의한 컴포넌트, (Controller, Service, Repository 외의 컴포넌트)
@Data
public class Paging {
	private int totalRecord;
	private int pageSize=10;
	private int totalPage;
	private int blockSize=10;
	private int currentPage=1;
	private int firstPage;
	private int lastPage;
	private int curPos;
	private int num;
	
	public void init(List list, HttpServletRequest request) {
		totalRecord=list.size();
		totalPage = (int)Math.ceil((float)totalRecord/pageSize) ; 
		if(request.getParameter("currentPage") !=null) {
			currentPage= Integer.parseInt(request.getParameter("currentPage"));
		}
		firstPage = currentPage - (currentPage-1)%blockSize;
		lastPage  = firstPage + (blockSize-1);
		curPos = (currentPage-1)*pageSize;
		num = totalRecord-curPos;
		
		log.debug("totalRecord="+totalRecord);
		log.debug("totalPage="+totalPage);
		log.debug("currentPage="+currentPage);
		log.debug("firstPage="+firstPage);
		log.debug("lastPage="+lastPage);
		log.debug("curPos="+curPos);
		log.debug("num="+num);
	}
}





