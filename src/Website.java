

import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.omg.CORBA.PUBLIC_MEMBER;

public class Website {
	public Website parent;
	public ArrayList<Website>children;
	public String title;
	public String url;//??
	//public String conternt; //fetchcontent
	public int localscore;
	public int globalscore;
	public HW3 counter;// hw3
	
	public Website(String title, String url)
	{
		this.title=title;
		this.url=url;
		this.children=new ArrayList<>(); //not null
		counter=new HW3(url);
	}
	
	public void appendchild(Website child)
	{
		this.children.add(child); //this=parent w1.ac(w2)
		child.parent=this.parent;
	} //become children
	
	public void evaluate() //grow and count local scre and global 
	{
		for(Website child : children)
		{	
			child.evaluate();
			this.globalscore+=child.globalscore;
		}
		this.globalscore +=this.localscore;
	}
	public void grows(ArrayList<Keyword> keywords)
	{
		for(Keyword k: keywords)
		{
			try
			{
				this.localscore +=counter.countKeyword(k.name)*k.weight;	
			}
			catch(IOException ex)
			{
				return; //webproblem , dont'do
			}
			
		}
		if(getDepth()==2)
		{
			return ;
		}
		
		Document doc=Jsoup.parse(counter.getContent());
		Elements links =doc.select("a[href]");
		for(Element link: links)
		{
			String herf=link.attr("href"); //must herf need
			String title="--UNKNOW--";
			if(link.text()!=null) //hyper has words
			{
				title=link.text();
			}
			if(herf.startsWith("http")) //http begin 
			{
				Website childWebsite =new Website(title, herf);
				this.appendchild(childWebsite);
				childWebsite.grows(keywords);
				if(this.children.size()==3)
				{
					break;
				}
			}
		}
				
	}
	
	public int getDepth()
	{	
		int retVal=0;
		Website  curr=this;
		while(curr.parent!=null)
		{
			retVal++;
			curr=curr.parent;
		}
		return retVal;
	}
	
	
}
