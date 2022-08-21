package student;

import department.Department;

public class Student extends Department {
	public void studentName()
	{
		System.out.println("Student name : Lalitha");
	}
	public void studentDept()
	{
	System.out.println("Department : Computer Science");	
	}
	public void studentId()
	{
		System.out.println("Student ID : 2022");
	}

	public static void main(String[] args) {
		Student call=new Student();
		call.collegeName();
		call.collegeName();
		call.collegeRank();
		call.departmentName();
		call.studentName();
		call.studentDept();
		call.studentId();

	}

}
