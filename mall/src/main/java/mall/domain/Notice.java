package mall.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data 
@Entity
@Table(name="notice")
public class Notice {
	@Id
	private int notice_id;
	
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int hit;
	
}
