package DataBase;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysql_Conn {
    private Statement statement;
    private Connection con;
    public void Connect() {
        String driver="com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://49.234.222.244:3306/J2EE";
        String user = "root";
        String pwd = "990130";
        try{
            Class.forName(driver);
            this.con = DriverManager.getConnection(url,user,pwd);
            if(!con.isClosed())
            {
                this.statement = this.con.createStatement();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void Close_All() throws SQLException {
        this.statement.close();
        this.con.close();
    }
    public Boolean Search(String user,String pwd) throws SQLException {
        String sql = "select * from USER where username="+"\'"+user+"\'";
        ResultSet rs = this.statement.executeQuery(sql);
        String passwd = rs.getNString("pwd");
        if(passwd==pwd)
        {
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
}
