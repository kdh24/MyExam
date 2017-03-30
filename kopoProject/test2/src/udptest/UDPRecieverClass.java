package udptest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPRecieverClass extends Thread{
	DatagramSocket data_Socket = null;
//	final int port = 10002;	// 포트 번호를 final 변수로 선언
	// 생성자
	public UDPRecieverClass(DatagramSocket socket) {
		this.data_Socket = socket;
	}
	
	@Override
	public void run() {

		try {
//			DatagramSocket data_Socket = new DatagramSocket(port);

			byte[] In_bf = new byte[512]; // 입력 받는 내용 저장 배열
			DatagramPacket data_Packet = new DatagramPacket(In_bf, In_bf.length);
			data_Socket.receive(data_Packet); // Data_Packet을 Data_Socket에 저장한다.
			InetAddress Add = data_Packet.getAddress();	// 주소 확인
			int Out_port = data_Packet.getPort();	// 포트 확인
			String R_Str1 = new String(data_Packet.getData()); //Data_Packet의 실제 데이터를 문자열로 변환한다
			System.out.println("받음 > " + R_Str1);

			data_Socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
