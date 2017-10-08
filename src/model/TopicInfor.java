package model;

public class TopicInfor {
	private String id;
	private String title;
	private String author;
	private String createtime;
	private String header;
	public TopicInfor() {
	}

	public TopicInfor(String id, String title, String author, String createtime, String header) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.createtime = createtime;
		this.header = header;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	

}
