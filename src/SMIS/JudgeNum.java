package 学生信息管理系统;

public class JudgeNum {
	
	public static boolean judge(String s,int len){
		for(int i = 0; i < len; i++){
			if(!Character.isDigit(s.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	public static boolean judge(String s){
		try{
			Float.valueOf(s);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/*public static void main(String [] args){
		String s = "00256320";
		if(judge(s,s.length())){
			System.out.print("is num");
		}else{
			System.out.print("is not num");
		}
	}*/
}
