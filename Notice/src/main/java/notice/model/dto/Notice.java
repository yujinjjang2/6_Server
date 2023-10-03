package notice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드 매개변수 생성자
public class Notice {
	
	private int noticeNo;
	private int managerNo;
	private String noticeTitle;
	private String noticeDetail;
	private String noticeUploadDate;
	private String preTitle;
	private String nextTitle;

}
