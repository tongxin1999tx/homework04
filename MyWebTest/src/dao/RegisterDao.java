package dao;

import java.sql.Connection;
import java.sql.Statement;

import tools.JdbcUtil;

import vo.User;

public class RegisterDao {

    public boolean add(User user) {
        //�����ݲ������ݿ��SQL���
        String sql = "insert into t_user (username,password,mail,povi,city) values('"+ user.getUserName() + "','"+ user.getPassword() +"','"+ user.getMail() +"','"+user.getPovi() +"','"+ user.getCity() +"')";
        // �������ݿ�����
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