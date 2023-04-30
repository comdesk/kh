package temp42;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TTT {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:/Temp/TTT.data");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		try(fos; oos) {
			Parent parent = new Parent();
			
			oos.writeObject(parent);
		} //try-with-resources
	} //main

} //end class









