package mall.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import mall.domain.Product;
import mall.domain.ProductImg;
import mall.exception.UploadException;

//이 객체의 존재가 없다면, 컨트롤러가 '업로드' 라는 모델 영역의 업무를 수행하게 되므로
//업로드 수행을 전담할 수 있는 모델 객체를 정의한다 .
//이 객체는, DAO도 아니며, Service도 아니며, Controller 도 아니므로 , 스프링의 기본 컴포넌트
//이외의 컴포넌트로 등록하면 된다. 
@Component // ComponentScan의 대상이 될 수 있다. 따라서 자동으로 인스턴스 올라온다 
@Slf4j
public class FileManager{
	
	public void save(Product product , String savePath) throws UploadException{
		
		//디렉토리 생성 (상품의 pk값을 이용)
		File directory = new File(savePath, "p_"+product.getProduct_id());
		MultipartFile[] photo=product.getPhoto();
		
		List productImgList = new ArrayList();
		
		log.debug("업로드 할 이미지 수는 "+photo.length);
		
		for(int i=0;i<photo.length;i++) {
			String filename=photo[i].getOriginalFilename();
			
			String ext= filename.substring(filename.lastIndexOf(".")+1, filename.length());
			log.debug("확장자 "+ext);
			
			//파일명을  유일성을 보장하기 위한 방법은 상당히 많다 
			//해시값, 현재날짜, db pk 값 
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			long time = System.currentTimeMillis();
			String newName= time+"."+ext;
			File file = new File(directory.getAbsolutePath()+File.separator+newName);//저장될 파일 
			
			ProductImg productImg = new ProductImg();
			productImg.setFilename(newName);
			productImgList.add(productImg);
			
			try {
				photo[i].transferTo(file);
				log.debug(file.getAbsolutePath());//업로드된 결과 디렉토리 확인차 
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new UploadException("파일 저장 실패", e);
			}		
		}
		product.setImgList(productImgList);
	}
	
	//상품 디렉토리에 소속된 이미지 삭제  
	public void remove(Product product, String savePath){
		File directory = new File(savePath, "p_"+product.getProduct_id());
		
		if (directory.exists() && directory.isDirectory()) { //디렉토리 라
		    File[] files = directory.listFiles();//파일 목록 얻기 
		    
		    if (files != null) { //파일이 존재한다면 
		        for (File file : files) {
		            boolean deleted = file.delete(); //파일 삭제 
		            log.debug(file.getName() + " 삭제됨? " + deleted);
		        }
		    }
		    
		    boolean result = directory.delete();  // 이제 비어있으니 삭제됨		    
		    //log.debug("디렉토리 삭제 결과: " + result);
		    
		    if(result==false) {
		    	log.warn("파일 삭제 실패, 체크요망 "+ directory.getAbsolutePath());
		    }
		}
		
	}
}





