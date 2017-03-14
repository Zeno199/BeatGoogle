

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) throws IOException
	{
		 System.out.println("This is Beat Google: type your keyword:");
		 
		 Scanner scanner=new Scanner(System.in);
		 int i=0;
		 while(scanner.hasNextLine())
		 {
			
			
			 String querystr=scanner.nextLine();
			 
			 ArrayList<Keyword> keywords= new ArrayList<>();
			 keywords.add(new Keyword("����", 2, 2.0)); //create your count
			 keywords.add(new Keyword(querystr, 4, 2.0));
			 keywords.add(new Keyword("�ȹC", 2, 2.0));
			 keywords.add(new Keyword("���]", 2, 2.0));
			 keywords.add(new Keyword("���J", 2, 2.0));
			 keywords.add(new Keyword("���I", 2, 2.0));
			 keywords.add(new Keyword("����", 2, 2.0));
			 keywords.add(new Keyword("�W��", 2, 2.0));
			 keywords.add(new Keyword("�ۥѦ�", 2, 2.0));
			 keywords.add(new Keyword("�[��", 2, 2.0));
			 keywords.add(new Keyword("��q", 2, 2.0));
			 keywords.add(new Keyword("�\�U", 2, 2.0));
			 keywords.add(new Keyword("�s��", 2, 2.0));
			 keywords.add(new Keyword("�ȩ�", 2, 2.0));
			 keywords.add(new Keyword("��{", 2, 2.0));
			 keywords.add(new Keyword("��C", 2, 2.0));
			 keywords.add(new Keyword("����", 2, 2.0));
			 
			 
			 
				BeatGoogle beatGoogle=new BeatGoogle(keywords);
		
				ArrayList<Website> resultsWebsites=beatGoogle.query(querystr);//ONY CARE ROOT SCRE
				
				for(Website res: resultsWebsites)
				{
					System.out.println(res.title );
					System.out.println("Link:"+" "+res.url.substring(7));
					System.out.println();
				}
				
			System.out.println("This is Beat Google: type your keyword:");
		 }
		
	}
}
