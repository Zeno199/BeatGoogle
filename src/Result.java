public class Result {
	private String Title;
	private String URL;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}

	public String getUrl() {
		return URL;
	}

	public void setUrl(String url) {
		this.URL = url;
	}

	public Result(String title, String url) {
		super();
		this.Title = title;
		this.URL = url;
	}

	public Result() {
		super();
	}

}
