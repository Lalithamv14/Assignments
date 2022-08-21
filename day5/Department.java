package week3.day5;

public class Department extends Students {
	

	public void getStudentInfo(int id, String name)
	{
		
		super.getStudentInfo(id, name);
		System.out.println("sudent id : 58");
		System.out.println("Student name : abc");
	}
	public static void main(String[] args) {
	  Department call=new Department();
	 
	  call.getStudentInfo(123);
	call.getStudentInfo(25, "Lalitha");
	call.getStudentInfo("xyx@gmail.com", 987456);
	
	  
	  
	  

	}

}
