package com.uday.starter;

import java.io.File;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		ArrayList<String> arraylist=new ArrayList<>();
		//ArrayList<File> files = new ArrayList<>();
		if (args.length>0)
			for(String arg:args)
			{
				arraylist.add(arg);
				//files.add();
			}
		else
			arraylist.add(".");
			arraylist.add("ulog");
		File files = new File(arraylist.get(0));
		
		//Log log = new Log();
	}
	
}
