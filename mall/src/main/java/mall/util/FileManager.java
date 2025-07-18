package mall.util;

import java.io.File;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import mall.exception.UploadException;

//이 객체의 존재가 없다면, 컨트롤러가 '업로드' 라는 모델 영역의 업무를 수행하게 되므로
//업로드 수행을 전담할 수 있는 모델 객체를 정의한다 .
//이 객체는, DAO도 아니며, Service도 아니며, Controller 도 아니므로 , 스프링의 기본 컴포넌트
//이외의 컴포넌트로 등록하면 된다. 
@Component // ComponentScan의 대상이 될 수 있다. 따라서 자동으로 인스턴스 올라온다 
@Slf4j
public class FileManager{
	
	public void save(MultipartFile photo ,String savePath, String filename) throws UploadException{
		//3단계: 일 시키기
		//메모리에 올라온 이미지정보를 디스크에 저장
		//파일의 경로를 개발자가 정해놓지 말고, 애플리케이션으로부터 경로를 동적으로 얻어오는 방법 
																					 //애플리케이션과 생명을 같이함
		String ext= filename.substring(filename.lastIndexOf(".")+1, filename.length());
		log.debug("확장자 "+ext);
		
		//파일명을  유일성을 보장하기 위한 방법은 상당히 많다 
		//해시값, 현재날짜, db pk 값 
		long time = System.currentTimeMillis();
		String newName= time+"."+ext;
		File file = new File(savePath, newName);//저장될 파일 
		
		try {
			photo.transferTo(file);
			log.debug(file.getAbsolutePath());//업로드된 결과 디렉토리 확인차 
		} catch (Exception e) {
			e.printStackTrace();
			throw new UploadException("파일저장 실패", e);
		}		
	}
}





