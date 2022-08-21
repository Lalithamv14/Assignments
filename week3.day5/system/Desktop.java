package system;

public class Desktop extends Computer{

public void desktopsize()	
	{
		System.out.println("Desktop size is 29 to 30 inches");
	}
	
	public static void main(String[] args) {
		Desktop call=new Desktop();
		call.computerModel();
		call.desktopsize();
		
	}
}
