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
		
		//파일의 수가 복수개 이므로, 상품마다 1:1 대응하는 디렉토리를 생성하자 
		File directory=new File(savePath, "p_"+product.getProduct_id());   //p_7  , p_23
		
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
				
				File file = new File(directory.getAbsolutePath() +File.separator+filename);
				log.debug("업로드된 이미지가 생성된 경로는 "+savePath);
				
				photo[i].transferTo(file); //메모리상의 파일 정보가, 실제 디스크상으로 존재하게 되는 시점!!
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UploadException("파일 업로드 실패", e);
		}
		
	}
	
	//상품 이미지 삭제 (지정한 상품의 디렉토리 및 그 안의 파일들..)
	//savePath ~~~~ /data/p_pk값
	public void remove(Product product, String savePath) {
		//디렉토리를 지우기 위해서는 , 그 안에 파일들이 먼저 지워져야 함 
		//1) 조사 대상 디렉토리를 지정 
		File directory = new File(savePath, "p_"+product.getProduct_id());
		
		//디렉토리가 실제로 존재할 경우 그 안의 파일부터 지우기 
		if(directory.exists() && directory.isDirectory()) {
			//이 하위에 파일들이 존재하는지 그 목록을 얻자
			File[] files=directory.listFiles();
			
			if(files !=null) { //파일이 존재한다면.. 
				//파일의 수 만큼 삭제 
				for(File file : files) {
					boolean deleted=file.delete();//파일 삭제 후 그  결과 반환 !!!
					log.debug(file.getName()+" 를 삭제한 결과 "+deleted);
				}
			}
			
			//파일이 모두 삭제되었으므로, 디렉토리도 삭제 
			boolean result=directory.delete();
			
			if(result==false) {
				log.warn("디렉토리 삭제 실패 "+directory.getAbsolutePath());
			}
		}
	}
	
}




















