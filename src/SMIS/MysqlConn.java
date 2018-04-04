package 学生信息管理系统;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.Spring;

//数据库连接程序
public class MysqlConn {
	//JDBC驱动名及数据库URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL ="jdbc:mysql://localhost:3306/SCIS";
	
	//数据库登录名及密码
	static final String USER = "root";
	static final String PASS = "tiger";
	
	//设定用户名和密码
	static String userword;
	static String pawd;
	
	static String teaid = null;
	static String teaname = null;
	static Date teabirth = null;
	static String protitle = null;
	static String cname = null;
	static String cno = null;
	
	static String stuid = null;
	static String stuname = null;
	static String stusex = null;
	static Date stubirth = null;
	static String stutel = null;
	static String stuacademy = null;//学院
	static String stuclass = null;
	static String stuadd = null;
	
	static int stugrade = 0;
	static double stupoint = 0;
	static double stucredit = 0;
	
	static int counter = 0;
	
	static String [] stu_id = new String[10];
	static String [] stu_name = new String[10];
	static String [] stu_sex = new String[10];
	static Date [] stu_birth = new Date[10];
	static String [] stu_tel = new String[10];
	static String [] stu_academy = new String[10];
	static String [] stu_class = new String[10];
	static String [] stu_add = new String[10];
	
	static int [] stu_grade = new int[10];
	static double [] stu_point = new double[10];
	
	static String [] c_no = new String[10];
	static String [] ct_name = new String[10];
	static String [] c_name = new String[10];
	static double [] credit = new double[10];
	
	static String [] tea_id = new String[10];
	static String [] tea_name = new String[10];
	static Date [] tea_birth = new Date[10];
	static String [] tea_protitle = new String[10];
	
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	//连接数据库
	public static void ConnectSQL() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("The SQL is connected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 判断用户是否存在
	public static boolean queryadm(String id) {
		// 创建火箭车
		try {
			ps = conn.prepareStatement("select * from 管理员 where ID = ?");
			// 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式
			ps.setString(1, id);
			// ResultSet结果集,大家可以把ResultSet理解成返回一张表行的结果集
			rs = ps.executeQuery();
			// 循环取出
			if (rs.next()) {
				pawd = rs.getString("password");
				return true;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
	
	public static boolean querytea(String id) {
		// 创建火箭车
		try {
			ps = conn.prepareStatement("select * from 教师 where ID = ?");
			// 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式
			ps.setString(1, id);
			// ResultSet结果集,大家可以把ResultSet理解成返回一张表行的结果集
			rs = ps.executeQuery();
			// 循环取出
			if (rs.next()) {
				pawd = rs.getString("ID");
				return true;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
	
	public static boolean querystu(String id) {
		// 创建火箭车
		try {
			ps = conn.prepareStatement("select * from 学生 where ID = ?");
			// 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式
			ps.setString(1, id);
			// ResultSet结果集,大家可以把ResultSet理解成返回一张表行的结果集
			rs = ps.executeQuery();
			// 循环取出
			if (rs.next()) {
				pawd = rs.getString("ID");
				return true;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
	
	//获取学生信息
	public static void getdatastu() {
		
		// 创建火箭车
		try {
			ps = conn.prepareStatement("select * from 学生");
			// ResultSet结果集,大家可以把ResultSet理解成返回一张表行的结果集
			rs = ps.executeQuery();
			counter = 0;
			while(rs.next())	
			{
				stu_id[counter] = rs.getString("ID");
				stu_name[counter] = rs.getString("Sname");
				stu_sex[counter] = rs.getString("Ssex");
				stu_birth[counter] = rs.getDate("Sbirth");
				stu_tel[counter] = rs.getString("Stel");
				stu_academy[counter] = rs.getString("Sacademy");//学院
				stu_class[counter] = rs.getString("Sclass");
				stu_add[counter] = rs.getString("Saddress");
				counter++;
			}
	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void getdatastu(String s) {
		
		// 创建火箭车
		try {
			ps = conn.prepareStatement("select * from 成绩,课程 where Sno = ? and 成绩.Cno = 课程.Cno");
			ps.setString(1, s);
			// ResultSet结果集,大家可以把ResultSet理解成返回一张表行的结果集
			rs = ps.executeQuery();
			counter = 0;
			while(rs.next())	
			{
				c_name[counter] = rs.getString("Cname");
				stu_grade[counter] = rs.getInt("Grade");
				credit[counter] = rs.getDouble("Ccredit");
				stu_point[counter] = rs.getDouble("Point");
				counter++;
			}
	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void getdatagra() {
		try {
			ps = conn.prepareStatement("select * from 成绩,课程,学生,教师 where 成绩.Sno = 学生.ID and 成绩.Cno = 课程.Cno and 教师.Cno = 课程.Cno");
			rs = ps.executeQuery();
			
			counter = 0;
			while(rs.next())	
			{
				stu_name[counter] = rs.getString("Sname");
				c_name[counter] = rs.getString("Cname");
				ct_name[counter] = rs.getString("Tname");
				stu_grade[counter] = rs.getInt("Grade");
				stu_point[counter] = rs.getDouble("Point");
				credit[counter] = rs.getDouble("Ccredit");
				counter++;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void getdatatea(){
		try {
			ps = conn.prepareStatement("select * from 教师,课程 where 课程.Cno = 教师.Cno");
			rs = ps.executeQuery();
			counter = 0;
			while(rs.next()){
				tea_id[counter] = rs.getString("ID");
				tea_name[counter] = rs.getString("Tname");
				tea_birth[counter] = rs.getDate("Tbirth");
				tea_protitle[counter] = rs.getString("Tprotitle");
				c_name[counter] = rs.getString("Cname");
				counter++;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//获取教师信息
		public static void getdatatea(String id) {
			
			// 创建火箭车
			try {
				ps = conn.prepareStatement("select * from 教师,课程 where ID = ? and 课程.Cno = 教师.Cno ");
				// 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式
				ps.setString(1, id);
				// ResultSet结果集,大家可以把ResultSet理解成返回一张表行的结果集
				rs = ps.executeQuery();
				if(rs.next())	
				{
					teaid = rs.getString("ID");
					teaname = rs.getString("Tname");
					teabirth = rs.getDate("Tbirth");
					protitle = rs.getString("Tprotitle");//职称
					cno = rs.getString("Cno");
					cname = rs.getString("Cname");
				}
		
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	//插入学生信息
	public static void insertstu() {
		try{
			ps = conn.prepareStatement("insert into 学生 values ('"+stuid+"','"+stuname+"','"+stusex+"','"+stubirth+"','"+stutel+"','"+stuacademy+"','"+stuclass+"','"+stuadd+"')");
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "学生记录添加成功!", "提示消息", JOptionPane.INFORMATION_MESSAGE);
				
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "数据添加异常!", "提示消息", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
		
	}

	public static void updatestu(String stuid2,String stuname2,String stusex2, Date stubirth2, String stutel2, String stuacademy2, String stuclass2, String stuadd2) {
		// TODO Auto-generated method stub
		try{
			ps = conn.prepareStatement("update 学生 set Sname = ?, Ssex = ?, Sbirth = ?, Stel = ?, Sacademy = ?, Sclass = ?, Saddress = ? where ID = ? ");
			ps.setString(1, stuname2);
			ps.setString(2, stusex2);		//可能出问题的地方
			ps.setDate(3, stubirth2);
			ps.setString(4, stutel2);
			ps.setString(5, stuacademy2);
			ps.setString(6, stuclass2);
			ps.setString(7, stuadd2);
			ps.setString(8, stuid2);
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "学生记录修改成功!", "提示消息", JOptionPane.INFORMATION_MESSAGE);
			
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "数据修改失败!", "提示消息", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}

	public static void deletestu(String stuid2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("delete from 学生 where ID = ? ");
			ps.setString(1, stuid2);
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "学生记录删除成功!", "提示消息", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e1){
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "数据删除失败!", "提示消息", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}

	public static void inserttea() {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("insert into 教师 values ('"+teaid+"','"+teaname+"','"+teabirth+"','"+protitle+"','"+cno+"')");
			System.out.println("cno:"+cno);
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "教师记录添加成功!", "提示消息", JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception e){
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "数据添加异常!", "提示消息", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public static void updatetea(String teaid2, String teaname2, Date teabirth2, String protitle2, String cno2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("update 教师 set Tname = ?,Tbirth = ?,Tprotitle = ?,Cno = ? where ID = ? ");
			ps.setString(1, teaname2);
			ps.setDate(2, teabirth2);
			ps.setString(3, protitle2);
			ps.setString(4, cno2);
			ps.setString(5, teaid2);
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "教师记录修改成功!", "提示消息", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "数据修改失败!", "提示消息", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public static void deletetea(String teaid2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("delete from 教师 where ID = ? ");
			ps.setString(1, teaid2);
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "教师记录删除成功!", "提示消息", JOptionPane.INFORMATION_MESSAGE);
			
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "数据删除失败!", "提示消息", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}
	
	public static void querygra(String cname2){
		try {
			ps = conn.prepareStatement("select * from 学生,课程,成绩 where Cname = ? and 课程.Cno = 成绩.Cno and 学生.ID = 成绩.Sno");
			ps.setString(1, cname2);
			rs = ps.executeQuery();
			counter = 0;
			while(rs.next()){
				stu_id[counter] = rs.getString("Sno");
				stu_name[counter] = rs.getString("Sname");
				stu_grade[counter] = rs.getInt("Grade");
				stu_point[counter] = rs.getDouble("Point");
				counter++;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertgra(String stuid2, String cno2, int stugrade2, double stupoint2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("insert into 成绩 values ('"+stuid2+"','"+cno2+"','"+stugrade2+"','"+stupoint2+"')");
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "成绩录入成功!", "提示消息", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "数据添加异常!", "提示消息", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	//查询成绩表中某课程成绩是否已经存在
	public static boolean querycou(String stuid2,String cname2){
		try {
			ps = conn.prepareStatement("select Grade from 课程,成绩 where Sno = ? and Cname = ? and 课程.Cno = 成绩.Cno");
			ps.setString(1, stuid2);
			ps.setString(2, cname2);
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public static void updategra(String stuid2, String cno2, int stugrade2, double stupoint2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("update 成绩 set Grade = ?, Point = ? where Sno = ? and Cno = ? ");
			ps.setInt(1, stugrade2);
			ps.setDouble(2, stupoint2);
			ps.setString(3, stuid2);
			ps.setString(4, cno2);
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "成绩修改成功!", "提示消息", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "数据修改失败!", "提示消息", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public static void query_gra(String stuid2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("select * from 课程,成绩,教师 where Sno = ? and 课程.Cno = 成绩.Cno and 课程.Cno = 教师.Cno");
			ps.setString(1, stuid2);
			rs = ps.executeQuery();
			counter = 0;
			while(rs.next()){
				c_name[counter] = rs.getString("Cname");
				ct_name[counter] = rs.getString("Tname");
				stu_grade[counter] = rs.getInt("Grade");
				credit[counter] = rs.getDouble("Ccredit");
				stu_point[counter] = rs.getDouble("Point");
				counter++;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void getdatacou() {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("select * from 课程 ");
			rs = ps.executeQuery();
			counter = 0;
			while(rs.next()){
				c_no[counter] = rs.getString("Cno");
				c_name[counter] = rs.getString("Cname");
				credit[counter] = rs.getDouble("Ccredit");
				counter++;
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static boolean querycou(String text) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("select Cno from 课程 where Cno = ?");
			ps.setString(1, text);
			rs = ps.executeQuery();
			
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public static void insertcou(String cno2, String cname2, double stucredit2) {
		// TODO Auto-generated method stub
		try{
			ps = conn.prepareStatement("insert into 课程 values ('"+ cno2 +"','"+ cname2 +"','"+stucredit2+"')");
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "课程信息添加成功!", "提示消息", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "课程信息添加失败!", "提示消息", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void updatecou(String cno2, String cname2, double stucredit2) {
		// TODO Auto-generated method stub
		try{
			ps = conn.prepareStatement("update 课程 set Cname = ?, Ccredit = ? where Cno = ?");
			ps.setString(1, cname2);
			ps.setDouble(2, stucredit2);
			ps.setString(3, cno2);
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "课程信息修改成功!", "提示消息", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "课程信息修改失败!", "提示消息", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void deletecou(String cno2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("delete from 课程 where Cno = ?");
			ps.setString(1, cno2);
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "课程删除成功!", "提示消息", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "课程删除失败!", "提示消息", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void getdatacou(String cname2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("select Cno from 课程 where Cname = ?");
			//System.out.println("cname"+cname2);
			ps.setString(1, cname2);
			rs = ps.executeQuery();
			
			if(rs.next()){
				//System.out.println("found");
				cno = rs.getString("Cno");
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
