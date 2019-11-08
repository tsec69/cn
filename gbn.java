import java.util.*;
import java.io.*;
public class gbn{
	public static void sendPackets(int start, int winsize){
		int k=start;
		for(int i = 0; i<winsize; i++){
			System.out.println("\nPacket " + (k%(winsize+1)) + " sent");
			k++;
}
	}


	

	public static void main(String[] args) throws IOException {
		int bits;
		int frameSize;
		System.out.print("Enter number of bits in the sequence: ");
		bits = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		System.out.println("Number of bits: " + bits);
		frameSize = (( (int) Math.pow(2, bits) ) - 1);
		System.out.println("Frame size: " + frameSize);
		
		int senderWindowStart = 0;
		sendPackets(senderWindowStart, frameSize);
		//checkProgress(senderWindowEnd);			
		for(int i = 0; i<frameSize; i++) {
			System.out.print("Has packet " + i + " been received?(y/n): ");
			String ans = new BufferedReader(new InputStreamReader(System.in)).readLine();			
			if(ans.equals("y") || ans.equals("Y")) {
				System.out.println("Packet " + i + " received");
				if(i==frameSize-1){
				System.out.print("Packets received: ");
				for(int j=0;j<=i;j++){
				System.out.print(j+" ");
			}
			}
}
			else {
				System.out.print("Packets received: ");
				for(int j=0;j<i;j++){
				System.out.print(j+" ");
				}
			sendPackets(i,frameSize);				
			}	

	}
}
}