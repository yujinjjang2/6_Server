package edu.kh.project.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok 다운로드 및 lib > lombok.jar 파일 넣기 -> 두 단계 모두 진행해야 import 가능!
@Getter
@Setter
@ToString
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드 매개변수 생성자
public class Member {
	
	// lombok 라이브러리 : getter/setter, 생성자, toString() 자동완성 라이브러리
	
	
	private int memberNo;
	private String memberEmail;
	private String memberPw;
	private String memberNickname;
	private String memberTel;
	private String memberAddress;
	private String profileImage;
	private String enrollDate;
	private String memberDeleteFlag;
	private int authority;
	
	

}
