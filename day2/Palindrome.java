package week1.day2;

public class Palindrome {

	public static void main(String[] args) {
		int n=121;
		int rem;
		int sum=0;
		 int temp=n;
		
		
		while(n>0)
		{
			rem=n%10;
			sum=(sum*10)+rem;
			n=n/10;
		}
		if(temp==sum)
		
		System.out.println( temp+"is a palindrome");
		
		
		else
		
			System.out.println(temp+" is not a palindrome");
		
	}

}
