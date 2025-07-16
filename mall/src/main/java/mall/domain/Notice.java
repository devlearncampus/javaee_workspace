package mall.domain;

import lombok.Data;

@Data 
public class Notice {
	private int notice_id;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int hit;
	
}
