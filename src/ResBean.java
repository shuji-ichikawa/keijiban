package keijiban;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ResBean {
	private int No;
	private int No2;
	private String reply_id;
	private int thread_id;
	private String name;
	private String contents;
	private Timestamp time;

	public int getNo2() {
		return No2;
	}
	public void setNo2(int no2) {
		No2 = no2;
	}
	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		No = no;
	}
	public String getReply_id() {
		return reply_id;
	}
	public void setReply_id(String reply_id) {
		this.reply_id = reply_id;
	}
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

	public static void insertData(ResBean resbean) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = new ResourceFinder().getConnectionpuser();
			st = conn.prepareStatement("INSERT INTO comment(No,reply_id,name,contents,thread_id,time) VALUES(?,?,?,?,?,now())");
			st.setInt(1, resbean.getNo());
			st.setString(2, resbean.getReply_id());
			st.setString(3, resbean.getName());
			st.setString(4, resbean.getContents());
			st.setInt(5, resbean.getThread_id());
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

	public static List<ResBean> selectAllList(int thread_id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<ResBean> reslist = new ArrayList<ResBean>();
		try {
			conn = new ResourceFinder().getConnectionpuser();
			st = conn.prepareStatement("SELECT thread_id, No, reply_id, name, contents, time FROM comment where thread_id=?");
			st.setInt(1, thread_id);
			rs = st.executeQuery();

			while (rs.next()) {
			ResBean resbean = new  ResBean();
			resbean.setThread_id(rs.getInt("thread_id"));
			resbean.setNo(rs.getInt("No"));
			resbean.setReply_id(rs.getString("reply_id"));
			resbean.setName(rs.getString("name"));
			resbean.setContents(rs.getString("contents"));
			resbean.setTime(rs.getTimestamp("time"));
			reslist.add(resbean);
			}
			rs.close();
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
		return reslist;
	}

	public static List<ResBean> selectAllList2(int thread_id, int No2) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<ResBean> replylist = new ArrayList<ResBean>();
		try {
			conn = new ResourceFinder().getConnectionpuser();
			st = conn.prepareStatement("SELECT No, reply_id, name, contents, time FROM comment where thread_id=? && No=?");
			st.setInt(1, thread_id);
			st.setInt(2, No2);
			rs = st.executeQuery();

			while (rs.next()) {
			ResBean resbean = new  ResBean();
			resbean.setNo(rs.getInt("No"));
			resbean.setReply_id(rs.getString("reply_id"));
			resbean.setName(rs.getString("name"));
			resbean.setContents(rs.getString("contents"));
			resbean.setTime(rs.getTimestamp("time"));
			replylist.add(resbean);
			}
			rs.close();
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
		return replylist;
	}

	public static void deletelist(int thread_id, int No) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = new ResourceFinder().getConnectionpuser();
				st = conn.prepareStatement("UPDATE comment set reply_id=?,name=?,contents=? where thread_id = ? and No = ?");
				st.setString(1, "");
				st.setString(2, "");
				st.setString(3, "※コメントは削除されました。");
				st.setInt(4, thread_id);
				st.setInt(5, No);
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
