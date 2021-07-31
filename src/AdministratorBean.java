package keijiban;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministratorBean {
	private String ID;
	private String pass;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	public static boolean CheckAdminPass(String ID, String pass) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean check = false;
		try {
			conn = new ResourceFinder().getConnectionpuser();
			st = conn.prepareStatement("SELECT pass FROM admin WHERE admin_id=?");
			st.setString(1, ID);
			rs = st.executeQuery();
			while (rs.next()) {
				if (pass.equals(rs.getString("pass"))) {
					check = true;
				}
			}
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}
}
