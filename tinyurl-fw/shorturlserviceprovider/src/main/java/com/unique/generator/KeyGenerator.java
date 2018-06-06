package com.unique.generator;

public class KeyGenerator {

	public String createShortURL(int n){
		return generateBase62(n);
	}
	
	private String generateBase62(int n){
		String map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder shortUrl = new StringBuilder();
		while(n>0){
			shortUrl.append(map.charAt(n%62));
			n=n/62;
		}
		return shortUrl.toString();
	}
	
	public int getIdFromShortURL(String s){
		return calculateIdFromShortURL(s);
	}

	private int calculateIdFromShortURL(String s) {
		int id=0;
		for(int i=s.length()-1;i>=0;i--){
			if('a' <= s.charAt(i) && s.charAt(i) <= 'z'){
				id=id*62 + s.charAt(i) - 'a';
			}
			if('A' <= s.charAt(i) && s.charAt(i) <= 'Z'){
				id=id*62 + s.charAt(i) - 'A' + 26;
			}
			if('0' <= s.charAt(i) && s.charAt(i) <= '9'){
				id=id*62 + s.charAt(i) - '0' + 52;
			}
		}
		return id;
	}
	
}
