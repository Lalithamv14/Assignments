package week3.day2day6;

import java.util.ArrayList;
import java.util.List;

public class printDuplicates {

	public static void main(String[] args) {
		int[] data = {4,3,6,8,29,1,2,4,7,8};
		int length=data.length;
		
		List<Integer>listvalues=new ArrayList<Integer>();
		for(int i=0;i<length-1;i++)
		{
			listvalues.add(data[i]);
			int count=1;
			for(int j=i+1;j<data.length;j++)
			{
				if(data[i]==data[j])
					{count++;
			}
			
		}
		if(count>1)
		{
			System.out.println("Duplicates:"+data[i]);
		}

	}

	}
}
