package week1.day2;

public class FindIntersection {

	public static void main(String[] args) {
		int[]number1= {3,2,11,4,6,7};
		int[]number2={1,2,8,4,9,7};
		
		for(int i=0;i<number1.length;i++)
		{
			for(int j=0;j<number2.length;j++)
			{
				if(number1[i]==number2[j])
				{
					
					System.out.println("Intersection element is"+number2[j]);
				}
			}
		}
		
	
		
			
		}

	}


