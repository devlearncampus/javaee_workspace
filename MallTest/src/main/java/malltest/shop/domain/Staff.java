package malltest.shop.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="staff")
public class Staff {
	@Id
	private int staff_id;
	
	private String name;
	private int sal;
	private String email;
	
}
