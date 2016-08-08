import java.io.File;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		ArrayList<String> extnlist=new ArrayList<>();
		if(args.length<1){
			System.out.println("atleast 2 arguments expected !");
			return;
		}
		String home = args[0];
			for(int i=1;i<args.length;i++)
			{
				extnlist.add(args[i]);
				//files.add();
			}
			for (String extn:extnlist)
			{
				Log log = new Log(home,extn);
				log.processFiles();
		
	}
	

		}
	}

