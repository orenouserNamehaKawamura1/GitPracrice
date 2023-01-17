package util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class GenerateHashedPw {
    /** パスワードを安全にするためのアルゴリズム */
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
    /** ストレッチング回数 */
    private static final int ITERATION_COUNT = 10000;
    /** 生成される鍵の長さ */
    private static final int KEY_LENGTH = 256;

    //引数で受け取った文字列をソルトとしてbyte配列に変換
    private static byte[] getHashedSalt(String salt) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        messageDigest.update(salt.getBytes());
        return messageDigest.digest();
    }

    public static String getSafetyPassword(String password, String salt) {

        char[] passCharAry = password.toCharArray();

        //ユーザIDをソルトとしてbyte配列に変換
        byte[] hashedSalt = getHashedSalt(salt);

        /*第1引数：パスワード
		  第2引数：ソルト
		  第3引数：ストレッチング回数
		  第4引数：生成文字列長
        */
        PBEKeySpec keySpec = new PBEKeySpec(passCharAry, hashedSalt, ITERATION_COUNT, KEY_LENGTH);

        //秘密鍵生成のアルゴリズムを定義
        SecretKeyFactory skf;
        try {
	            skf = SecretKeyFactory.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        //秘密鍵の生成
        SecretKey secretKey;
        try {
            secretKey = skf.generateSecret(keySpec);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        byte[] passByteAry = secretKey.getEncoded();

        // 生成されたバイト配列を16進数の文字列に変換
        StringBuilder sb = new StringBuilder(64);
        for (byte b : passByteAry) {
            sb.append(String.format("%02x", b & 0xff));		//16進数2桁0埋めでbyte bと11111111のANDを取る
        }
        return sb.toString();
    }
    public static void main(String[] args) {
    	String pw = "morijyobi";
    	String salt = "omjy70lPN1";
    	String hashedpw = GenerateHashedPw.getSafetyPassword(pw, salt);
    	System.out.println(hashedpw);
    }
}
