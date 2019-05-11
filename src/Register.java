import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class Register extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		 /**
		  *第二步 
		  * 加载jdbc驱动器
		  */
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载失败");
			e.printStackTrace();
		}
		 /**
		  *第三步
		  * 连接jdbc驱动器
		  */
		 try {
			 
			Connection con= (Connection) DriverManager.getConnection
					 ("jdbc:mysql://127.0.0.1:3306/studb","root","");
			System.out.println("创建加载成功");	
			String u=request.getParameter("use");
		     String p=request.getParameter("pas");
			Statement sta=(Statement) con.createStatement();
			int n=sta.executeUpdate("insert studentinfo values ('"+u+"','"+p+"')");
			System.out.println("更新"+n+"条");
			
	  	//第四步	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("创建加载失败");
			e.printStackTrace();
		}
	}

		
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
