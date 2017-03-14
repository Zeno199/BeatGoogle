

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;





public class HW3 {
	
	
	private String urlStr;
	
	private String content;
	
	private String content1;

	
	
	public HW3(String urlStr) {
		this.urlStr=urlStr;
	}
	public String getContent()
	{
		return content;
	}
	private String fetchContent() throws IOException
	{
		
	
             
		URL url= new URL(this.urlStr); 
		
		URLConnection conn=url.openConnection(); //url obj return connection
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

	public int countKeyword(String keyword) throws IOException
	{
		if(content==null) //no connect
		{
			
			content =fetchContent(); //retrun string , it means connect
	
			/* indexOf: means the place of String , retrun the posistion in the string ex: abc finds "bc" return 1 */
			
			/*public int indexOf(String str, int fromIndex) : specifies the index ,
			 *  next = last first position+ keyword length ,let it not last at the
			 same place*/
		}
		
		int retVal=0;
		int fromIdx=0;
		int found=-1; //fist key word position
		
		while((found=content.indexOf(keyword,fromIdx))!=-1)
		{
			
			retVal++; //find
			
			fromIdx= found+keyword.length(); //last position+ key length , if it can't find , it return -1
		}
		
		
		return retVal;
	}
}
