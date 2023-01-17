package util;

import java.util.Random;

public class GenerateSalt {

	/**
	 * 引数で受け取った数字の桁数分のランダムな文字列を生成する。
	 * @param len 生成するランダムな文字列の桁数
	 * @return ランダムな文字列
	 */
	public static String getSalt(int len){
		Random rnd = new Random();

		final String CHARACTORS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len; i++){
			sb.append(CHARACTORS.charAt(rnd.nextInt(CHARACTORS.length())));
		}

		return sb.toString();
	}
	public static void main(String[] args) {
		String salt = GenerateSalt.getSalt(10);
		System.out.println(salt);
	}
}
