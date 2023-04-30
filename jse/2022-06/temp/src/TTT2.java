
public class TTT2 {
	
	{
		System.out.println("1");
	} //User-defined block
		
	public static void main(String[] args) {
		{ 	
			int temp = 10;
			System.out.println("2");
			{
				{
					{System.out.println("3");}
				}
			} System.out.println("4");
		}
		{
			
		}
		{System.out.println("5");}
	} //main
} //end class
