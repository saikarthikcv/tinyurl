package com.tinyurl.tasks.data;

import java.util.HashMap;

import com.tinyurl.tasks.data.persistence.Persist;
import com.unique.generator.KeyGenerator;

public class Cache {

	private int originalUrlTotal=0;
	private HashMap<String,String> originalToShortURL=new HashMap<String,String>();
	
	private static Cache cache=null;
	
	public static Cache getInstance()
    {
        if (cache == null){
        	cache = new Cache();
        	
        	//Here there are few things to be done. It is out of scope of the question. So i am writing comments.
        	/*
        	 * We will have a table called mapper, with original url, short url for persistent
        	 * This table will be loaded in originalToShortURL variable where key is shortURL and value is original URL
        	 * and using originalToShortURL.size() , value should be filled in originalUrlTotal*/
        }
        return cache;
    }
	
	public String get(String shorturl){
		if(originalToShortURL.get(shorturl)!=null){
			return originalToShortURL.get(shorturl);
		}
		return null;
	}
	
	public String put(String originalurl){
		//at this point of time, we will have to query with this originalurl to the mapper table as if exists, we can return the already generated base62 number, or continue;
		KeyGenerator k = new KeyGenerator();
		String shortURL = k.createShortURL(++originalUrlTotal);
		originalToShortURL.put(shortURL,originalurl);
		
		Persist p = new Persist();
		p.setOriginalURL(originalurl);
		p.setShortURL(shortURL);
		Thread t = new Thread(p);
		t.run();
		
		return shortURL;
	}
	
}
