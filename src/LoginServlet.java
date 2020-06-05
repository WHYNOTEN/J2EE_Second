import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得输入流
        PrintWriter out = response.getWriter();
        // 从请求对象中获得指定参数的值
        String strName = request.getParameter("txtName");
        String strPwd = request.getParameter("txtPwd");
        //定义数据库操作所需对象
        Connection conn=null;
        Statement stmt;
        ResultSet rs;
        PreparedStatement psmt;
        // 数据库链接需要的参数
        String driver="com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://49.234.222.244:3306/J2EE";
        String user = "root";
        String pwd = "990130";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            String sql = "select * from USER where username=? and pwd=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1,strName);
            psmt.setString(2,strPwd);
            rs = psmt.executeQuery();
            if(rs.next())
            {
                //设置cookie
                Cookie cooUsername = new Cookie("username",strName);
                cooUsername.setMaxAge(60*60*24*7);
                response.addCookie(cooUsername);
                Cookie cooPwd = new Cookie("pwd",strPwd);
                cooPwd.setMaxAge(60*60*24*7);
                response.addCookie(cooPwd);

                HttpSession session = request.getSession(true);
                session.setAttribute("username",strName);
                session.setAttribute("pwd",strPwd);

                String path = request.getContextPath();
                String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
                String page = basepath+"/page/Online.jsp";
                response.sendRedirect(page);
            }
            else
            {
                out.println("错误的用户名和密码！");
            }
            psmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
