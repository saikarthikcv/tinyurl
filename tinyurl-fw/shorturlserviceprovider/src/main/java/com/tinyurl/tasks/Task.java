package com.tinyurl.tasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tinyurl.tasks.interfaces.ITask;

public class Task {

	public String decideTheTaskAndDo(String urlPath){
		ITask t=null;
		String s=null;
	    String pattern = "createshorturl?q=(\\s*)";
	    Pattern r = Pattern.compile(pattern);
	    Matcher m = r.matcher(urlPath);
		if(m.find()){
			s = m.group(1);
			t=new BuildShortURL();
		}else{
			t=new MapOriginalString();
		}
		return t.doTask(s);
	}
	
}
