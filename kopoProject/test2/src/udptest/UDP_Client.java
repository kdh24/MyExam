package udptest;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class UDP_Client {

	public static void main(String[] args) {
		Scanner myin = new Scanner(System.in);
		
		//연결할 대상의 ip, 포트 번호를 입력 받음.
		System.out.println("연결할 대상의 ip 주소를 입력하세요 :");
		String ip = myin.nextLine();
//		System.out.println("연결할 포트를 입력하세요 :");
		int port = 10002;
//		myin.nextLine();
		
		try{
			//소켓, 주소
			DatagramSocket data_Socket = new DatagramSocket();
			InetAddress ia = InetAddress.getByName(ip);
			
			while(true){
			//보낼 내용을 입력 받음
			String input = myin.nextLine();
			byte[] Out_bf = new byte[512];
			Out_bf = input.getBytes(); 
			
			//데이터페킷 선언
			DatagramPacket data_Packet = new DatagramPacket(Out_bf, Out_bf.length, ia, port);
			
			//Data_Packet 내용을 전송함.
			data_Socket.send(data_Packet);
			data_Packet = new DatagramPacket(Out_bf, Out_bf.length);
			
			//서버로부터 내용을 전송 받음
			byte[] In_bf = new byte[512];
			data_Packet = new DatagramPacket(In_bf, In_bf.length, ia, port);
			data_Socket.receive(data_Packet);
			
			//전송 받은 내용을 출력.
			String str = new String(data_Packet.getData());
			System.out.println("수신 : "+str);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
