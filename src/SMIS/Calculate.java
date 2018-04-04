package 学生信息管理系统;

import java.math.BigDecimal;

public class Calculate {
	
	public static double calculatepoi(int i){
		if(i >= 90){
			return 4.0;
		}else if(i >= 85){
			return 3.7;
		}else if(i >= 82){
			return 3.3;
		}else if(i >= 78){
			return 3.0;
		}else if(i >= 75){
			return 2.7;
		}else if(i >= 72){
			return 2.3;
		}else if(i >= 68){
			return 2.0;
		}else if(i >= 64){
			return 1.5;
		}else if(i >= 60){
			return 1.0;
		}else{
			return 0;
		}
	}
	
	public static double calculatecre(double c[]){
		double sum = 0;
		for(int i = 0; i < MysqlConn.counter; i++){
			sum += c[i];
		}
		return sum;
	}
	
	public static double calculateGPA(double c[],double p[]){
		double GPA = 0, t = 0, sum = 0;
		for(int i = 0; i < MysqlConn.counter; i++){
			t += c[i] * p[i];
			sum += c[i];
		}
		GPA = t / sum;
		BigDecimal bg = new BigDecimal(GPA);  
        GPA = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return GPA;
	}
}
