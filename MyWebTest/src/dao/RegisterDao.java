package dao;

import java.sql.Connection;
import java.sql.Statement;

import tools.JdbcUtil;

import vo.User;

public class RegisterDao {

    public boolean add(User user) {
        //将数据插入数据库的SQL语句
        String sql = "insert into t_user (username,password,mail,povi,city) values('"+ user.getUserName() + "','"+ user.getPassword() +"','"+ user.getMail() +"','"+user.getPovi() +"','"+ user.getCity() +"')";
        // 创建数据库链接
        JdbcUtil db = new JdbcUtil();
		Connection conn = db.getConn();
        Statement state = null;
        boolean f = false;
        int a = 0;

        try {
            state = conn.createStatement();
            a=state.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (a > 0) {
            f = true;
        }
        return f;

}


}