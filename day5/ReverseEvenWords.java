package week3.day5;

public class ReverseEvenWords {
	
	public static void main(String[] args) {
		String test="Hi how are you";
		String s[]=test.split(" ");
		
		for(int i=0;i<s.length;i++)
		{
			if(i%2==0)
			{
	char[] charArray=s[i].toCharArray();
	for(int j=charArray.length-1;j>=0;j--)
		
	{
        System.out.print(charArray[j]);
	    }
	System.out.print("  ");
}
		
			else
			{
				System.out.println(s[i]);
			}
		}
	}
}
		


