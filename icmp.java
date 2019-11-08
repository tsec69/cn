import java.io.*;
import java.lang.*;

class icmp
{
	public static void main(String args[]) throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String header, str;
		System.out.println("Enter the hexadecimal dump: ");
		header = br.readLine();
		
		System.out.println("\nType: " + Integer.parseInt(header.substring(0, 2), 16));
		System.out.println("Code: " + Integer.parseInt(header.substring(2, 4), 16));
		System.out.println("Checksum: " + Integer.parseInt(header.substring(4, 8), 16));
		System.out.println("Rest of Header: " + Integer.parseInt(header.substring(8, 16), 16));
		System.out.println("Data Section: " + (Integer.parseInt(header.substring(16, 24), 16)));
	}
}
//05 32 0017 500207FF CB840000
//05320017500207FF00CB8400