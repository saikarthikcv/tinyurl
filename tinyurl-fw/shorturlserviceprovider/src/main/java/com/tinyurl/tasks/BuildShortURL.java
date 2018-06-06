package com.tinyurl.tasks;

import com.tinyurl.tasks.data.Cache;
import com.tinyurl.tasks.interfaces.ITask;

public class BuildShortURL implements ITask {

	public String doTask(String s) {
		return Cache.getInstance().put(s);
	}

}
