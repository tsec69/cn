import java.util.*;

class tcp1{
	public static void main(String[] args) {
		System.out.println("Enter the TCP header in hex");
		Scanner sc=new Scanner(System.in);
		String hex=sc.next();
		System.out.println("Source port: "+Integer.parseInt(hex.substring(0,4),16));
		System.out.println("Destination port: "+Integer.parseInt(hex.substring(4,8),16));
		System.out.println("Sequence number: "+Integer.parseInt(hex.substring(8,16),16));
		System.out.println("Acknowledgement number: "+Integer.parseInt(hex.substring(16,24),16));
		System.out.println("Header length: "+Integer.parseInt(hex.substring(24,25),16));
		int fb=Integer.parseInt(hex.substring(25,28));
		System.out.println("URG ACK PSH RST SYN FIN");
		for(int i=5;i>=0;i--) {
			System.out.print("  "+((fb>>i)&1)+" ");
		}
		System.out.println("\nWindow size: "+Integer.parseInt(hex.substring(28,32),16)+"bytes");
		System.out.println("Checksum: "+Integer.parseInt(hex.substring(32,36),16));
		System.out.println("Urgent pointer: "+Integer.parseInt(hex.substring(36,40),16));
	}
}

/*
Output: 
Please enter the Hex Dump:
053200170000000100000000500207FF00000000
Source Port: 1330
Destination Port: 23
Sequence Number: 1
Acknowledgement Number: 0
Header Length: 20 Bytes
Sender is attempting to Synchronize Sequence Numbers
Window Size: 2047 Bytes
Header Checksum: 0
Urgent Pointer: 0
*/
