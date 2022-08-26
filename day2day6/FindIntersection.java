package week3.day2day6;

public class FindIntersection {

	public static void main(String[] args) {

int[] input= {3,2,11,4,6,7};	
int[] input1= {1,2,8,4,9,7};
for(int i=0;i<input.length;i++)
{
	for(int j=0;j<input1.length;j++)
	{
		if(input[i]==input1[j])
		{
			System.out.println("The Intersection number is " + input[i]);
		}
	}
}


	}

}
