package mall.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="topcategory")
public class TopCategory {
	@Id
	private int topcategory_id;
	private String top_name;
	
	//자식인 SubCategory 리스트 
	private List<SubCategory> subList;   // 1:多 관계이므로, 자식을 collection 으로 수집
															//만일 자식도 부모를 같이 참조할 경우, 무한 루프 조심..
}








