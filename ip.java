import java.io.*;

public class ip{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enetr the header:");
        String input = br.readLine();
        
        String IPVer = input.substring(0,1);
        if(IPVer.equals("4"))
            System.out.println("IP Version: 4");
        if(IPVer.equals("6"))
            System.out.println("IP Version: 6");
        
        String h_len = input.substring(1,2);
        System.out.println("Header Length: " + (4 * Integer.parseInt(h_len,16)));
        
        String s_type = input.substring(2,4);
        String s_t_bin = Integer.toBinaryString(Integer.parseInt(s_type,16));
        while(s_t_bin.length() < 8)
            s_t_bin = "0" + s_t_bin;
        System.out.println("Precedence: " + Integer.parseInt(s_t_bin.substring(0,3),2));
        if(s_t_bin.charAt(3) == '1')
            System.out.println("Minimize Delay Requested");
        if(s_t_bin.charAt(4) == '1')
            System.out.println("Maximize Throughput Requested");
        if(s_t_bin.charAt(5) == '1')
            System.out.println("Maximize Reliability Requested");
        if(s_t_bin.charAt(6) == '1')
            System.out.println("Minimize Cost Requested");
        
        String tot_len = input.substring(4,8);
        System.out.println("Total Length: " + Integer.parseInt(tot_len,16) + " Bytes");
        
        String id = input.substring(8,12);
        System.out.println("Identification: " + Integer.parseInt(id,16));
        
        String flag = input.substring(12,13);
        String flag_bin = Integer.toBinaryString(Integer.parseInt(flag,16));
        
        flag_bin=flag_bin+"00";
        System.out.println("Unused Flag: "+flag_bin.charAt(0));
        System.out.println("Do not fragment Flag: "+flag_bin.charAt(1));
        System.out.println("More fragment Flag: "+flag_bin.charAt(2));
        
        String frag = input.substring(13,16);
        System.out.println("Fragmentation Offset: " + (Integer.parseInt(frag,16)));
        
        String ttl = input.substring(16,18);
        System.out.println("Time to live: " + Integer.parseInt(ttl,16) + " Hops");
        
        String protocol = input.substring(18,20);
        System.out.print("Protocol: ");
        if(Integer.parseInt(protocol,16) == 1)
            System.out.println("ICMP 1");
        if(Integer.parseInt(protocol,16) == 2)
            System.out.println("IGMP 2");
        if(Integer.parseInt(protocol,16) == 89)
            System.out.println("OSPF 89");
        if(Integer.parseInt(protocol,16) == 6)
            System.out.println("TCP 6");
        if(Integer.parseInt(protocol,16) == 17)
            System.out.println("UDP 17");
        
        String checksum = input.substring(20,24);
        System.out.println("Header Checksum: " + Integer.parseInt(checksum,16));
        
        String s_ip = input.substring(24,32);
        String s_ip_bin = Long.toBinaryString(Long.parseLong(s_ip,16));
        while(s_ip_bin.length() < 32)
            s_ip_bin = "0" + s_ip_bin;
        System.out.print("Source IP Address: ");
        System.out.print(Integer.parseInt(s_ip_bin.substring(0,8),2) + ".");
        System.out.print(Integer.parseInt(s_ip_bin.substring(8,16),2) + ".");
        System.out.print(Integer.parseInt(s_ip_bin.substring(16,24),2) + ".");
        System.out.println(Integer.parseInt(s_ip_bin.substring(24,32),2));
        
        String d_ip = input.substring(32,40);
        String d_ip_bin = Long.toBinaryString(Long.parseLong(d_ip,16));
        while(d_ip_bin.length() < 32)
            d_ip_bin = "0" + d_ip_bin;
        System.out.print("Destination IP Address: ");
        System.out.print(Integer.parseInt(d_ip_bin.substring(0,8),2) + ".");
        System.out.print(Integer.parseInt(d_ip_bin.substring(8,16),2) + ".");
        System.out.print(Integer.parseInt(d_ip_bin.substring(16,24),2) + ".");
        System.out.println(Integer.parseInt(d_ip_bin.substring(24,32),2));
    }
    
}


/*
Output:
Please enter the Hex Dump:
4500005400035850200600007C4E0302B40E0F02
IP Version: 4
Header Length: 20
Precedence: 0
Total Length: 84 Bytes
Identification: 3
Do not Fragment Packet
No more Fragments pending
Fragmentation Offset: 49772
Time to live: 32 Hops
Protocol: TCP
Header Checksum: 0
Source IP Address: 124.78.3.2
Destination IP Address: 180.14.15.2
*/