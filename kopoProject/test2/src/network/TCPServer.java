package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String args[]){
		ServerSocket s1 = null;
		Socket s2;
		// 172.20.30.214
		OutputStream os1;
		DataOutputStream os2;
		InputStream is1;
		DataInputStream is2;
		
		try {
			s1 = new ServerSocket(5432);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true){
			try {
				System.out.println("클라이언트 대기중 ..");
				s2 = s1.accept();
				System.out.println("클라이언트 접속 성공");

				os1 = s2.getOutputStream();
				os2 = new DataOutputStream(os1);
				os2.writeUTF("Welcom to connect to TCP Server!" + "(server -> client)");

				is1 = s2.getInputStream();
				is2 = new DataInputStream(is1);
				String st = new String(is2.readUTF());
				System.out.println(st);
				
				String answer = new String();
				int count=0;
				
				do{

					count++;
					st = new String(is2.readUTF());
					
					if(st.contains("안녕")){
						answer = st + "님 환영합니다";
					}else if(st.contains("반가워")){
						answer = "제가 더 반가워요 ^^";
					}else{
						answer = "뭐라시는지 모르겠어요";
					}
					
					os2.writeUTF(answer);
					System.out.println("대답 전송" + count);
					
				}while(st.equals("1") == false);
				
				

				is1.close();
				is2.close();
				os1.close();
				os2.close();
				s2.close();

//				s1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
