package com.tibame.ball.common;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MoneyFmtUtils {
	/**
	 * 將整數轉化為金額，返回兩位小數點
	 * @param money
	 * @return String
	 */
	public static String moneyFormatToStr(Integer money) {
		if(money == null) {
			return null;
		}
		DecimalFormat mFmt = new DecimalFormat("###,###,###,##0.00");
		return mFmt.format(money);
	}
	/**
	 * 將小數轉化成金額，返回兩位小數
	 * @param money
	 * @return
	 */
	public static String moneyFormatToStr(Double money) {
		if(money == null) {
			return null;
		}
		DecimalFormat mFmt = new DecimalFormat("###,###,###,##0.00");
		//向下取整數，取消四捨五入
		mFmt.setRoundingMode(RoundingMode.DOWN);
		return mFmt.format(money);
	}
	/**
	 * 將字符串類型的數字轉化為銀行金額格式
	 * @param money
	 * @return
	 */
	public static String moneyFormatToStr(String money) {
		if(money == null || money == "") {
			return null;
		}
		return moneyFormatToStr(Double.parseDouble(money));
	}
	
	public static void main(String[] args) {
		System.out.println(moneyFormatToStr("12345"));
		System.out.println(moneyFormatToStr(2412));
		System.out.println(moneyFormatToStr(2312324.12));
		System.out.println(moneyFormatToStr(231232.412));
		System.out.println(moneyFormatToStr(231232412));
		
	}
}
