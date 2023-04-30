package temp41;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import lombok.Cleanup;

public class TTT {

	public static void main(String[] args) throws IOException {
		@Cleanup FileOutputStream fos = new FileOutputStream("C:/Temp/dataoutput.txt");
		
		@Cleanup DataOutputStream dos = new DataOutputStream(fos);
		
		dos.write(77);
		dos.writeInt(77);
		
	} //main

} //end class




