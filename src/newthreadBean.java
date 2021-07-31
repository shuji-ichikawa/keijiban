package keijiban;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

public class newthreadBean {
	private int thread_id;
	private String title;
	private String name;
	private String contents;
	private Timestamp time;

	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getThread_id() {
		return thread_id;
	}
	public void setThread_id(int thread_id) {
		this.thread_id = thread_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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

	public static void insertData(ArrayList<newthreadBean> newthreadlist) {
		Connection conn = null;
		newthreadBean newthreadbean = null;
		PreparedStatement st = null;
		try {
			conn = new ResourceFinder().getConnectionpuser();
			for(int i = 0; i < newthreadlist.size(); i++) {
				newthreadbean = (newthreadBean)newthreadlist.get(i);
				st = conn.prepareStatement("INSERT INTO thread(title,name,contents,time) VALUES(?,?,?,now())");
				st.setString(1, newthreadbean.title);
				st.setString(2, newthreadbean.name);
				st.setString(3, newthreadbean.contents);
				st.executeUpdate();
				st.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static ArrayList<newthreadBean> selectAllList(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<newthreadBean> newthreadlist = new ArrayList<newthreadBean>();
		try {
			conn = new ResourceFinder().getConnectionpuser();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM thread");
			while(rs.next()) {
				newthreadBean newthreadbean = new newthreadBean();
				newthreadbean.setThread_id(rs.getInt("thread_id"));
				newthreadbean.setTitle(rs.getString("title"));
				newthreadbean.setName(rs.getString("name"));
				newthreadbean.setContents(rs.getString("contents"));
				newthreadbean.setTime(rs.getTimestamp("time"));
				newthreadlist.add(newthreadbean);
			}
			st.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newthreadlist;
	}


	public static ArrayList<newthreadBean> selectList(int thread_id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<newthreadBean> newthreadlist = new ArrayList<newthreadBean>();
		try {
			conn = new ResourceFinder().getConnectionpuser();
			st = conn.prepareStatement("SELECT * FROM thread where thread_id = ?");
			st.setInt(1, thread_id);
			rs = st.executeQuery();
			rs.next();
			newthreadBean newthreadbean = new  newthreadBean();
			newthreadbean.setThread_id(rs.getInt("thread_id"));
			newthreadbean.setTitle(rs.getString("title"));
			newthreadbean.setName(rs.getString("name"));
			newthreadbean.setContents(rs.getString("contents"));
			newthreadbean.setTime(rs.getTimestamp("time"));
			newthreadlist.add(newthreadbean);
			st.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newthreadlist;
	}

	public static void deletelist(int thread_id) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = new ResourceFinder().getConnectionpuser();
				st = conn.prepareStatement("delete from thread where thread_id=?");
				st.setInt(1, thread_id);
				st.executeUpdate();
				st.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}


