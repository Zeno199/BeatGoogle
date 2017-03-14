

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
			 keywords.add(new Keyword("飯店", 2, 2.0)); //create your count
			 keywords.add(new Keyword(querystr, 4, 2.0));
			 keywords.add(new Keyword("旅遊", 2, 2.0));
			 keywords.add(new Keyword("旅館", 2, 2.0));
			 keywords.add(new Keyword("民宿", 2, 2.0));
			 keywords.add(new Keyword("景點", 2, 2.0));
			 keywords.add(new Keyword("美食", 2, 2.0));
			 keywords.add(new Keyword("名勝", 2, 2.0));
			 keywords.add(new Keyword("自由行", 2, 2.0));
			 keywords.add(new Keyword("觀光", 2, 2.0));
			 keywords.add(new Keyword("交通", 2, 2.0));
			 keywords.add(new Keyword("餐廳", 2, 2.0));
			 keywords.add(new Keyword("酒店", 2, 2.0));
			 keywords.add(new Keyword("旅店", 2, 2.0));
			 keywords.add(new Keyword("行程", 2, 2.0));
			 keywords.add(new Keyword("日遊", 2, 2.0));
			 keywords.add(new Keyword("租車", 2, 2.0));
			 
			 
			 
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
