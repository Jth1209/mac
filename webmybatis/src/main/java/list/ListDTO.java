package list;

public class ListDTO {
	private int num;
	private String writer;
	private String title;
	private String content;
	private String regtime;
	private String hits;
	
	public ListDTO(int num, String writer, String title, String content, String regtime, String hits) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regtime = regtime;
		this.hits = hits;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public String getHits() {
		return hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}
	
}
