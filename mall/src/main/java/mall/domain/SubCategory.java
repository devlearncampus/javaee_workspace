package mall.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="subcategory")
public class SubCategory {
	@Id
	private int subcategory_id;
	private String sub_name;
	
	@OneToOne
	@JoinColumn(name="topcategory_id")
	private TopCategory topcategory;
	
}










