package model;

public class RelyInfor {
	private String id;
	private String title;
	private String deply_author;
	private String reply_content;
	private String reply_date;
	private String topic_id;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public RelyInfor() {}
	
	public RelyInfor(String title,String id, String deply_author, String reply_content, String reply_date, String topic_id) {
		this.id = id;
		this.deply_author = deply_author;
		this.reply_content = reply_content;
		this.reply_date = reply_date;
		this.topic_id = topic_id;
		this.title = title;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeply_author() {
		return deply_author;
	}
	public void setDeply_author(String deply_author) {
		this.deply_author = deply_author;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_date() {
		return reply_date;
	}
	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}
	public String getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(String topic_id) {
		this.topic_id = topic_id;
	}
	
}
