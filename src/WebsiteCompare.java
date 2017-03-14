

import java.util.Comparator;

public class WebsiteCompare  implements Comparator<Website>{

	@Override
	public int compare(Website o1, Website o2) 
	{ 
		//System.out.println("d");
		if(o1.globalscore<o2.globalscore)
			return -1;
		if(o1.globalscore==o2.globalscore)
			return 0;
		else
			return 1;
		// TODO Auto-generated m

	}

}
