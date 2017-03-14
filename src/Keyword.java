

public class Keyword {
	public String name;
	public int count;
	public double weight;

	/*public Keyword(String name, int count,double weight) {
		this.name = name;
		this.count = count;
		this.weight = weight;
	}*/

	public Keyword(String name2, int count2, double weight2) {
		// TODO Auto-generated constructor stub
		
		this.name = name2;
		this.count = count2;
		this.weight = weight2;
	}

	@Override
	public String toString() {
		return "[" + name + "," + count + "," + weight + "]";
	}
}
