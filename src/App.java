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
			{	//TODO: pass extension-list instead of extension so that all the finding files thing is not repeated.
				Log log = new Log(home,extn);
				log.processFiles();

	}


		}
	}
