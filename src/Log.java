import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public  class Log {
final String movedir="logs";
private String path;
private ArrayList<String> tags ;
private String extn;

Log(String path,String extn){
this.path=path;
this.extn=extn;
}
public void setTags(List<String> tags){
	this.tags.addAll(tags);
}
public void processFiles(){
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
private  void moveFiles(ArrayList<String> filenames){
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
		moveable.renameTo(new File(path+"\\"+movedir+"\\"+moveable.getName())); // moving file
		System.out.println("Moved File !");
			}
		}
		
public void mergeFiles(){
	ArrayList<String> filenames=findFiles();
	for(String filename:filenames){
		
	}
	}
public void createFiles(){
	Date now=new Date();
	SimpleDateFormat ft = new SimpleDateFormat("EE.ddMMyyyy.hhmma");
	String filename = ft.format(now)+"."+extn;
	File newlog=new File(path+"\\"+filename);
	try{
		newlog.createNewFile();}
	catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
}
public void display(){
	//System.out.println("filename: "+this.filename+"\n created on: "+created.toString());
	}
}
