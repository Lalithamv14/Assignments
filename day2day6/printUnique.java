package week3.day2day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class printUnique {

	public static void main(String[] args) {
		String str="lalitha";
		char[] c =str.toCharArray();
		Set<Character>ch=new HashSet<Character>();
		for(Character data :c) {
			ch.add(data);
		}
		System.out.println(ch);
		
		List<Character>list=new ArrayList<Character>(ch);
		for(int i=0;i<list.size();i++)
		{ int count=0;
			for(int j=0; j<c.length;j++)
			{
				if(list.get(i)==c[j])
				{
				count++;
			}
		}
		if(count==1)
		{
			System.out.println(list.get(i));
		}
		}
	}

}
