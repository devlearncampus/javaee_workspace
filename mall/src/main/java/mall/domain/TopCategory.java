package mall.domain;

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
}
