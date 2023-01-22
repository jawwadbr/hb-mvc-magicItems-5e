package com.jawbr.util;

public class lineBreaksToDB {

	public static String saveLineBreak(String descr) {
		return descr.replaceAll("<br>", "\n");
	}
}
