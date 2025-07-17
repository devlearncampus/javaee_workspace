package mall.domain;

import javax.persistence.Column;
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
	
	@Column(name = "regdate", insertable = false, updatable = false)
	private String regdate;
	private int hit;
	
}
