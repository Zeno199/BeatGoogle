

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class Echo
 */
@WebServlet("/Echo")
public class Echo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Echo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		
		
		
		String key =new String(request.getParameter("input1").getBytes("iso-8859-1"), "UTF-8");
		
		//String key;
		
		
			//key="你";
		


	
		
		
		//Buffereader b= new Buffereader(); 
		
		 ArrayList<Keyword> keywords=new ArrayList<>();
		 keywords.add(new Keyword(key, 4, 12.0));
		 keywords.add(new Keyword("日遊", 2, 10.0));
		 keywords.add(new Keyword("旅遊", 2, 10.0));
		 keywords.add(new Keyword("觀光", 2, 10.0));
		 keywords.add(new Keyword("自由行", 2, 10.0));
		 keywords.add(new Keyword("遊記", 2, 8.0));
		 keywords.add(new Keyword("旅館", 2, 6.0));
		 keywords.add(new Keyword("民宿", 2, 6.0));
		 keywords.add(new Keyword("酒店", 2, 6.0));
		 keywords.add(new Keyword("旅店", 2, 6.0));
		 keywords.add(new Keyword("飯店", 2, 6.0)); //create your count
		 keywords.add(new Keyword("美食", 2, 4.0));
		 keywords.add(new Keyword("租車", 2, 4.0));
		 keywords.add(new Keyword("名勝", 2, 4.0));
		 keywords.add(new Keyword("景點", 2, 4.0));
		 keywords.add(new Keyword("交通", 2, 4.0));
		 keywords.add(new Keyword("餐廳", 2, 4.0));
		 keywords.add(new Keyword("行程", 2, 4.0));
		 
		
         
		 
		 BeatGoogle beatGoogle=new BeatGoogle(keywords);
		 
		 ArrayList<Website> resultsWebsites=beatGoogle.query(key);
	
		 ArrayList<Result> list1=new ArrayList<>();
		 for(int i=0;i<10;i++)
			{
				list1.add(new Result(resultsWebsites.get(i).title," " +resultsWebsites.get(i).url.substring(7))) ;
				//System.out.println("Link:"+" "+res.url.substring(7));res.titleres.title
				//System.out.println();
			}
		 //Website res: resultsWebsites
		 //ArrayList<Output> list =new ArrayList<>();;
		// list.add(new Output("s","http://abc.com"));
//		StringBuffer buffer = new StringBuffer();
//		buffer.append("<html><head></head><body><table>");
//		for (Result result : list) {
//			buffer.append("<tr>");
//			buffer.append("<td>"+result.getTitle()+"</td>");
//			buffer.append("<td>"+result.getUrl()+"</td>");
//			buffer.append("</tr>");
//		}
//		buffer.append("</table></body></html>");
		
		
		//response.getWriter().println(new GsonBuilder().setPrettyPrinting().create().toJson(list));
		
			//response.getWriter().println(key);
		 response.getWriter().println(new GsonBuilder().setPrettyPrinting().create().toJson(list1));
	
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/*private ArrayList<Result> mock(String s){
		ArrayList<Result> list = new ArrayList<>();
		String a=s;
		list.add(new Result("s","http://abc.com"));
		list.add(new Result("B","http://abc.com"));
		list.add(new Result("C","http://abc.com"));
		list.add(new Result("D","http://abc.com"));
		return list;
	}*/

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
