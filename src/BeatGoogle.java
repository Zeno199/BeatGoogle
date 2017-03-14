

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public class BeatGoogle {

	private ArrayList<Keyword> keywords;
	public ArrayList<Website> roots; //10 roots
	 public  BeatGoogle(ArrayList<Keyword> keywords)
	 {
		 this.keywords=keywords;

	 }
	 
	 public ArrayList <Website> query(String searchword) throws IOException
	 {
		 
		 
		 String title;
		 String url;
		 //call google
		
		 
		 GoogleSearch gSearch=new GoogleSearch(searchword);
		 Map<String,String> titleurlmap= gSearch.getResults(); //title, url
		 // create website trr base on gglge search result
		 roots=new ArrayList<>();
		 for(Entry<String, String>entry :titleurlmap.entrySet()) //Map visit :entry
		 {
			 String titleString=entry.getKey();
			 String urlString=entry.getValue();
			 Website root=new Website(titleString, urlString);
			 roots.add(root);
			 root.grows(keywords);
			 root.evaluate();
			
		 }
		 
		 Collections.sort(roots, new WebsiteCompare());
		
		
		 return roots;
	 }
}
