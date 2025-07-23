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
	public void save(Product product, String savePath) throws UploadException{
		//MultipartFile 변수와 html 이름이 동일하면 매핑됨 
		MultipartFile[] photo=product.getPhoto();
		log.debug("업로드 한 파일의 수는 "+photo.length);
		
		List imgList = new ArrayList();
		
		try {
			for(int i=0;i<photo.length;i++) {
				//확장자 구하기 (원본 업로드 이미지 정보 추츨)
				log.debug("원본 파일명은 "+photo[i].getOriginalFilename());
				String  ori=photo[i].getOriginalFilename();
				
				String ext =ori.substring(ori.lastIndexOf(".")+1, ori.length());
				
				//개발자가 원하는 파일명 생성하기 
				try {
					Thread.sleep(10); //연산 속도가 너무 빠르면, 파일명이 중복될 수 있으므로..일부러 지연.. 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				long time=System.currentTimeMillis(); //23758297829
				String filename=time+"."+ext;
				
				//생성한 파일명을 DB 저장하기 위해 Product 의 imgList 에 보관해놓자
				ProductImg productImg = new ProductImg();
				productImg.setFilename(filename);//이미지명 저장
				imgList.add(productImg);
				product.setImgList(imgList); //리스트 대입 
				
				//realPath를 사용하려면, 앱의 전반적인 전역적 정보를 가진 객체인 ServletContext가 필요함 
				
				File file = new File(savePath+File.separator+filename);
				log.debug("업로드된 이미지가 생성된 경로는 "+savePath);
				
				photo[i].transferTo(file); //메모리상의 파일 정보가, 실제 디스크상으로 존재하게 되는 시점!!
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UploadException("파일 업로드 실패", e);
		}
		
	}
}





