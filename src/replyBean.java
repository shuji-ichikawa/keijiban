package keijiban;

public class replyBean {
	private int No;
	private int thread_id;
	private String reply_id;
	private String name;
	private String contents;

	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		No = no;
	}
	public int getThread_id() {
		return thread_id;
	}
	public void setThread_id(int thread_id) {
		this.thread_id = thread_id;
	}
	public String getReply_id() {
		return reply_id;
	}
	public void setReply_id(String reply_id) {
		this.reply_id = reply_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}


}
