// MIT License
//
// Copyright (c) 2016 Uday Krishna
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public  class Log {
final String movedir="logs";
private String path;
private ArrayList<String> tags ;
private String extn;
//private ArrayList<String> g_filenames;

Log(String path,String extn){
this.path=path;
this.extn=extn;
//this.g_filenames=findFiles();
}
public void setTags(List<String> tags){
	this.tags.addAll(tags);
}
public void processFiles(){
	mergeFiles(findFiles());
	moveFiles(findFiles());
	createFiles();
}
private ArrayList<String> findFiles(){
	ArrayList<String> filenames = new ArrayList<>();
	File files = new File(path); // using to get all files in the path
	for(String filename:files.list()){
		String [] namesplit = filename.split("\\.");
		System.out.println("checking extension of : "+filename);
		if (namesplit.length<1)
			continue;
		if(namesplit[namesplit.length-1].equals(extn)) // checking the extension
			 filenames.add(filename);
	}
	return filenames;
		}
public  void moveFiles(ArrayList<String> filenames){
	String movedir = this.movedir;
	for(String filename:filenames){
		File moveable = new File(path+"\\"+filename);
		File dir = new File(path+"\\"+movedir);
		if(!dir.exists()){
			Boolean creation = dir.mkdir();
			System.out.println("Directory created: "+creation); // create a directory if it does not exists
			if(!creation){
				System.out.println("Error");
				return;}
		}
		Integer i= new Integer(0);
		if(new File(path+"\\"+movedir+"\\"+moveable.getName()).exists())
			while(new File(path+"\\"+movedir+"\\"+addin(i.toString(),moveable.getName())).exists())
			{i++;moveable.renameTo(new File(path+"\\"+movedir+"\\"+addin(i.toString(),moveable.getName())));} // moving file
		else
			moveable.renameTo(new File(path+"\\"+movedir+"\\"+moveable.getName())); // moving file
		System.out.println("Moved File !");
			}
		}

public void mergeFiles(ArrayList<String> filenames){
	if (filenames.size()<=1)
		return;
	String c_filename=filenames.get(0);
	Integer i = new Integer(0);
	while (new File(path+"\\"+c_filename).exists())
	{i++;c_filename=addin(i.toString(),c_filename);}
	String addin = addin("_all",c_filename);
	File file = new File(path+"\\"+addin);
	FileWriter filew = null;
	try {
		filew=new FileWriter(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("could not create all file");
		e.printStackTrace();
	}
	for(String filename:filenames){
		try {File read_file = new File(path+"\\"+filename);
			FileReader filer=new FileReader(read_file);
			filew.write("<"+filename+">");
			filew.write(System.getProperty("line.separator")+System.getProperty("line.separator"));			int c;
			while((c=filer.read())!=-1)
				filew.write(c);
			filer.close();
			read_file.delete();
			filew.write(System.getProperty("line.separator")+System.getProperty("line.separator"));
			filew.write("</"+filename+">");
			filew.write(System.getProperty("line.separator")+System.getProperty("line.separator"));			
			System.out.println("merged: "+filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("could not read file: "+filename);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("could not append file: "+filename);
			e.printStackTrace();
		}
		finally
		{
			//filer.close();
		}
	}
	try {
		filew.close();
		System.out.println("Merging Complete !");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
public void createFiles(){
	Date now=new Date();
	SimpleDateFormat ft = new SimpleDateFormat("EE.ddMMyyyy.hhmma");
	String filename = ft.format(now)+"."+extn;
	Integer i =new Integer(0);
	String c_filename=filename;
	while (new File(path+"\\"+c_filename).exists())
		{i++;c_filename=addin(i.toString(),filename);}
	File newlog=new File(path+"\\"+c_filename);
	try{
		newlog.createNewFile();
		System.out.println("Made a new file !");}
	catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
}
public String addin(String addword,String filename){
	ArrayList<String> temp = new ArrayList<>();
	String addin = "";
	String [] allfile=filename.split("\\.");
	for (int i=0;i<allfile.length;i++){
		if(i==allfile.length-1){
			temp.add(addword+".");
			temp.add(allfile[i]);
		}
		else
			temp.add(allfile[i]);
	}
	for (String comp:temp){
		addin=addin+comp;
	}
	return addin;
}
public void display(){
	//System.out.println("filename: "+this.filename+"\n created on: "+created.toString());
	}
}
