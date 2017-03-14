

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleSearch {

	private String querystr;
	private String content;
	
	public GoogleSearch(String querystr)
	{
		this.querystr=querystr;
	}
	
	private String fetchContent() throws IOException
	{
		
	
             
		URL url= new URL("https://www.google.com.tw/search?q="+querystr+"&num=30&oe=utf8"); 
		
		URLConnection conn=url.openConnection(); //url obj return connection
		conn.setRequestProperty("user-agent", "Chrome/47.0.2526.80");
		InputStream in=   conn.getInputStream(); //no readline fuction ,it should be use buffer reader
		
		InputStreamReader in1 =new InputStreamReader(in, "UTF-8");
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(in));// Reader: binary to string
		
		BufferedReader br = new BufferedReader(in1);
	
		
		//content1 =URLDecoder.decode(urlStr, "UTF-8");
	
		String retVal=""; //return the stream value
		
		String line=null;
		
		
		while((line= br.readLine())!=null) //eof =null , null jump
		{
			retVal = retVal+ line +"\n";  // retval concat
			
		}
		
		
		//System.out.println(retVal);
		return retVal;
		
	}
	public HashMap<String, String> getResults() throws IOException
	{
		
		 HashMap<String, String> retVal=new HashMap<>();
		if(content==null)
		{
		 content=fetchContent();	
		}
		
		Document doc= Jsoup.parse(content);
		
		Elements divGs=doc.select("div.g"); //select a group wich node == div class g
		
		//System.out.println(divGs.html());
		//System.out.println("=============================");
		
		int i=0;
		for(Element divG: divGs)
		{
			try
			{
				Element h3Rs=divG.select("h3.r").get(0); //h3 having class==r
				
				//System.out.println(i);
				//System.out.println(h3Rs.html());
				Element aTag=h3Rs.select("a").get(0); //取出atag的東西
				//System.out.println(aTag.html());
				String title=aTag.text();
				
				
				String url=aTag.attr("href"); // att which has herf
				
				if(!title.contains("搜尋結果"))
				{
				retVal.put(title, url);
				}
				//System.out.println(title+url);
			}
			
			catch(IndexOutOfBoundsException ex)
			{
				//.. do noting
			}
		
			
		}
		/*commands:*/
		//"div" ".g" "div.g"(是div & class ==g)
		//"#abc" ,id="abc"
		//"[herfabc]" links: having abc
		return retVal;
	}
}
