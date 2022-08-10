package week1.day2;

public class PrimeNumber {

	public static void main(String[] args) {
		
int input=13;
boolean flag=false;
int m=input/2;
int i;
	for(i=2;i<=m;i++)
	{
		if(input%i==0)
		{
			flag=true;
			break;
	}
}


if(flag==false)
{
	System.out.println(input+ " is a prime number");
}
else
{
	System.out.println(input+ " is not a prime number");
}

	
	

	}
}


