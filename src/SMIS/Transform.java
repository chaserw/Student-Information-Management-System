package 学生信息管理系统;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Transform {
	public static String DateTostr(Date d){
		String sdate = null;
		sdate=(new SimpleDateFormat("yyyy-MM-dd")).format(d);
		return sdate;
	}
	
	public static java.sql.Date strToDate(String strDate) {  
        String str = strDate;  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");  
        java.util.Date d = null;  
        try {  
            d = format.parse(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        java.sql.Date date = new java.sql.Date(d.getTime());  
        return date;  
    }  
}
