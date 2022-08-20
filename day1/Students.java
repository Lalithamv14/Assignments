package week3.day1;

public class Students {
	public void getStudentInfo(int id)
	{
		System.out.println("Student id is " + id);
		
	}
    public void getStudentInfo(int id,String name) 
    {
    	System.out.println("Student id:  " + id +    "  Student Name: " + name);
    }
    public void getStudentInfo(String email,int phone)
    {
    	System.out.println("Student email : " + email +  "  Student phone number : " + phone);
    }
}
