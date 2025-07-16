package malltest.shop.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="bio")
public class Bio {
	@Id
	
	private int bio_id;
	private String blood;
	private int height;
	private int weight;
	
	@OneToOne
	@JoinColumn(name="staff_id")	
	private Staff staff;
	
}
