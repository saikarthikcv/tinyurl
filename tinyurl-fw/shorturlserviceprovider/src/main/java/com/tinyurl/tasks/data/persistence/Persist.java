package com.tinyurl.tasks.data.persistence;

public class Persist implements Runnable{
	private String originalURL=null;
	private String shortURL=null;
	
	public void run() {
		//use these two variables which are set while creating this thread
		
		//do database operation to fill the latest record,which is out of scope of the question
	}

	public void setOriginalURL(String originalurl) {
		this.originalURL = originalurl;
	}

	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}

}
