package week3.day2day6;

public class ChangeOddIndex {

	public static void main(String[] args) {
		 
		 
		 
		 String test="changeme";
		       char[] characters= test.toCharArray();
		       for(int i=0; i<characters.length; i++)
		       {
		    	   
				char c=characters[i];
		    	   
				if(i%2==0)
		    	   {
		  c=Character.toUpperCase(c);
		    	   }
		 System.out.print(c);
		 
		       }
		  
		    	 
		       }
}
