package udptest;

import java.net.*;
import java.io.*;
import java.lang.*;

public class UDP_Server {

	public static void main(String[] args) {
		final int port = 10002;	// 포트 번호를 final 변수로 선언
		
		try{
			DatagramSocket Data_Socket = new DatagramSocket(port);

			
			while(true){
				try{
					byte[] In_bf = new byte[512]; // 입력 받는 내용 저장 배열
					DatagramPacket Data_Packet = new DatagramPacket(In_bf, In_bf.length);
					Data_Socket.receive(Data_Packet); // Data_Packet을 Data_Socket에 저장한다.
					InetAddress Add = Data_Packet.getAddress();	// 주소 확인
					int Out_port = Data_Packet.getPort();	// 포트 확인
					
					
					
					String R_Str1 = new String(Data_Packet.getData()); //Data_Packet의 실제 데이터를 문자열로 변환한다
					String R_Str2 = new String(R_Str1.trim());			//앞뒤 공백을 제거
					System.out.println("주소:"+Add+ "  포트 번호:"+ + Out_port);
					System.out.println("수신된 메시지(Client->Server): " + R_Str2);
					
					
					
					
					byte[] Out_bf = new byte[512];	// 보낼 내용 저장 배열
					if(R_Str2.contains("국")){	// 받은 내용 중에 문자열을 비교하여 해당 문자가 들어가 있으면 if문 실행.
						Out_bf = "수육 국밥을 추천한다!".getBytes();
					}
					else if(R_Str2.contains("고기")){
						Out_bf = "삼겹살 먹으로 갈까?".getBytes();
					}
					else if(R_Str2.contains("분식")){
						Out_bf = "떡순튀가 최고지!".getBytes();
					}
					else if(R_Str2.contains("음료")){
						Out_bf = "콜라나 먹어".getBytes();
					}
					else if(R_Str2.contains("정크")){
						Out_bf = "맥도날드 고고".getBytes();
					}
					else if(R_Str2.contains("술")){
						Out_bf = "참이슬 미만 잡".getBytes();
					}
					else if(R_Str2.contains("막걸리")){
						Out_bf = "비오는 날엔 막걸리가 최고지".getBytes();
					}
					else if(R_Str2.contains("곱창")){
						Out_bf = "막창은 달구지가 최고야".getBytes();
					}
					else if(R_Str2.contains("치킨")){
						Out_bf = "아 치맥하고싶다.".getBytes();
					}
					else if(R_Str2.contains("닭")){
						Out_bf = "닭다리나 뜯으로 갑시다!".getBytes();
					}
					else{
						Out_bf = "음식 이야기만 해!".getBytes();
					}
					
					Data_Packet = new DatagramPacket(Out_bf, Out_bf.length, Add, Out_port);	// 클라이언트에게 전송할 데이터 페킷
					Data_Socket.send(Data_Packet);	// 클라이언트에게 데이터 페킷을 전송.
					
				}catch(IOException e){}
			}
		}catch(IOException e){}
	}

}
