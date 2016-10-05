package com.LibraryManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//�������ݿ�����
public class DbUtil {
	
	public static final String URL = "jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=UTF-8";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    
    private static Connection conn = null;
    static{
        try {
            //1.������������
            Class.forName("com.mysql.jdbc.Driver");
            //2. ������ݿ�����
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }

}
