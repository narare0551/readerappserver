package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Member;

public class JoinDao {
	private static JoinDao instance = new JoinDao();
	
	private JoinDao() {}
		
	public static JoinDao getInstance() {
		return instance;
	}
	
	public boolean overappedId(String id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps, rs);
		}
		return flag;
	}
	
	public boolean overappedFcode(String fCode) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from family where f_code=?";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, fCode);
			rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps, rs);
		}
		return flag;
	}
	
	public String CheckFcode(String fCode) {
		String cName = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select c_name from family where f_code=?";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, fCode);
			rs = ps.executeQuery();
			if (rs.next()) {
				cName = rs.getString("c_name");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps, rs);
		}
		return cName;
	}
	
	public boolean addFcode(String fCode,String cName) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into family(f_code, c_name) "
				+ "values(?,?)";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, fCode);
			ps.setString(2, cName);
			int n = ps.executeUpdate();
			if (n == 1) {
				flag = true;
				System.out.println("fcode????????????");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps);
		}
		return flag;
	}
	
	public boolean insert(Member member) {
		System.out.println("insert????????????. ");
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into member(id,pw, name, serial_num) "
				+ "values(?, ?, ?, ?)";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getId());

			ps.setString(2, member.getPw());
			ps.setString(3, member.getName());
			ps.setString(4, member.getSerial_num());

			
			int n = ps.executeUpdate();
			if (n == 1) {
				flag = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps);
		}
		return flag;
	}
	
	public int login(String id, String pw) {
		System.out.println("joinDao.login??????");
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select pw from member where id=?";		
		try {
			conn = DBconn.getConnection();
			
			ps = conn.prepareStatement(sql);
			System.out.println("ps");
			System.out.println(ps);
			
			ps.setString(1, id);
			rs = ps.executeQuery();
			System.out.println("rs");
			System.out.println(rs);
			if (rs.next()) {
				if (pw.equals(rs.getString(1))) {
					n = 1;
				} else {
					n = 0;
				}
			} else {
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps, rs);
		}
		return n;
	}
}
