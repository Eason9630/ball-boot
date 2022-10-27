package com.tibame.ball.member.vo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tibame.ball.common.Result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member", catalog = "ball")
public class MemberVO extends Result implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	private String nickname;
	private LocalDate birthday;
	@Column(name = "img",columnDefinition = "longblob")
	private String base64img;
//	@Transient
//	private byte[] img;
//	public byte[] getImg() {
//		return img;
//	}
//	public void setImg(byte[] img) {
//		this.img = img;
//	}
}
	
