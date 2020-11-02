package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import controller.Page;
import tools.JdbcUtil;
import vo.User;

public class UserDao {
	
	public User getUser(String userName) {
		JdbcUtil db = new JdbcUtil();
		Connection conn = db.getConn();
		User user = new User();
		String sql = "select * from t_user where userName=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,userName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user.setUserName(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setChrName(rs.getString(3));
				user.setRole(rs.getString(4));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}
	
	public ArrayList<User> query(User user, Page page) {
		ArrayList<User> list = new ArrayList<User>(); // 存放查询结果的集合
		StringBuffer condition = new StringBuffer();// 查询条件
		if (user.getUserName() != null && !"".equals(user.getUserName())) { // 判断是否有该查询条件
			condition.append(" and userName like '%")
					.append(user.getUserName()).append("%'");
		}
		if (user.getChrName() != null && !"".equals(user.getChrName())) { //
			condition.append(" and chrName like '%").append(user.getChrName())
					.append("%'");
		}
		if (user.getMail() != null && !"".equals(user.getMail())) { //
			condition.append(" and mail like '%").append(user.getMail())
					.append("%'");
		}
		if (user.getPovi() != null
				&& !"".equals(user.getPovi())) { //
			condition.append(" and provinceName like '%")
					.append(user.getPovi()).append("%'");
		}
		if (user.getCity() != null && !"".equals(user.getCity())) { //
			condition.append(" and cityName like '%")
					.append(user.getCity()).append("%'");
		}

		int begin = page.getPageSize() * (page.getPageNumber() - 1);
		String sql = "select userName,password,chrName,mail,A.provinceCode provinceCode,";
		sql = sql + " B.provinceName provinceName,A.cityCode cityCode,C.cityName cityName ";
		sql = sql + " from t_user A left join t_province B ";
		sql = sql + " on A.provinceCode = B.provinceCode left join t_city C on A.cityCode = C.cityCode ";
		sql = sql + " where  1=1 ";
		sql = sql + condition + " order by " + page.getSort() + " "
				+ page.getSortOrder() + " limit " + begin + ","
				+ page.getPageSize();

		System.out.println(sql);
		// DatabaseConnection类封装了数据库驱动加载和连接
		JdbcUtil dbc = new JdbcUtil();
		Connection con = dbc.getConn();
		try {
			Statement stm = (Statement) con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				User userResult = new User();
				userResult.setUserName(rs.getString("userName"));
				userResult.setPassword(rs.getString("password"));
				userResult.setChrName(rs.getString("chrName"));
				userResult.setMail(rs.getString("mail"));
				userResult.setPoviCode(rs.getString("provinceCode"));
				userResult.setPovi(rs.getString("provinceName"));
				userResult.setCityCode(rs.getString("cityCode"));
				userResult.setCity(rs.getString("cityName"));
				list.add(userResult);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public int count(User user, Page page) {
		
		return 0;
	}
	
	public boolean delete(String ids) {
		
		return false;
	}
	
	public boolean update(User user) {
		
		return false;
	}
	
	public boolean insert(User user) {
		
		return false;	
	}
}

