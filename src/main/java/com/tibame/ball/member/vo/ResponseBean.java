package com.tibame.ball.member.vo;

import java.io.Serializable;
/*
 * 伺服器返回給客戶端的統一數據分裝ResponseBean
 */
public class ResponseBean<T> implements Serializable{
	private static final long serialVersionUID = 1L;

	/*
	 * 判斷伺服器不是異常
	 */
	private Boolean flag;
	
	/*
	 * 伺服器對應的數據
	 */
	private T dateT;
	/*
	 * 伺服器對應的錯誤訊息
	 */
	private String errString;
	
	public ResponseBean(){
		
	}
	public ResponseBean(Boolean flag){
		this.flag = flag;
	}
	public ResponseBean(T dateT){
		this.dateT = dateT;
	}
	
	
	public ResponseBean(T dateT, String errString) {
		super();
		this.dateT = dateT;
		this.errString = errString;
	}
	public ResponseBean(Boolean flag, T dateT, String errString) {
		super();
		this.flag = flag;
		this.dateT = dateT;
		this.errString = errString;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public T getDateT() {
		return dateT;
	}
	public void setDateT(T dateT) {
		this.dateT = dateT;
	}
	public String getErrString() {
		return errString;
	}
	public void setErrString(String errString) {
		this.errString = errString;
	}
	@Override
	public String toString() {
		return "ResponseBean [flag=" + flag + ", dateT=" + dateT + ", errString=" + errString + "]";
	}
	
	
}
