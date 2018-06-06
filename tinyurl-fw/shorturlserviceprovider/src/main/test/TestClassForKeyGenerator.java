package com.unique.generator;

public class TestClassForKeyGenerator {

	public static void main(String args[]){
		KeyGenerator k = new KeyGenerator();
		String shorturl = k.createShortURL(500000);
		int testi = k.getIdFromShortURL(shorturl);
		System.out.println(testi+" should be 500000.");
	}
	
}
