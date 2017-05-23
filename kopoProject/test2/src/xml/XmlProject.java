package xml;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlProject {
	public static void main(String[] args) {
		try {
			// 오라클 DB에 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.136.128:1521:orasparta", "SCOTT", "tiger");
			
			// 자동 commit 기능 해제
			conn.setAutoCommit(false);
			// 작업 처리를 위한 Statement 객체 생성
			Statement stmt = conn.createStatement();

			// 반복 횟수 처리를 위한 변수 생성
			int count = 1;

			// SELECT 문을 보내 값을 ResultSet 변수에 받아온다
			ResultSet rs = stmt.executeQuery("SELECT SIDO, COUNT(DONG) FROM ZIPCODE"
											+ " GROUP BY SIDO");

			// Document 및 XML 트리 생성
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Node root = document.createElement("zipcode");
			document.appendChild(root);
			
			while (rs.next()) {
				// 처리 상황 확인하는 출력문
				System.out.println(rs.getString(1) + " " + rs.getInt(2) + "\n");

				// zipcode 테이블에서 받아온 값을 xml 형식에 맞게 넣어준다
				Element address = document.createElement("address");
				address.setAttribute("id", String.valueOf(count));
				address.setAttribute("sido", rs.getNString(1));
				root.appendChild(address);
				{
					Element sido = document.createElement("sido");
					sido.appendChild(document.createTextNode(rs.getString(1)));
					address.appendChild(sido);
				}
				{
					Element dongCount = document.createElement("dongCount");
					dongCount.appendChild(document.createTextNode(String.valueOf(rs.getInt(2))));
					address.appendChild(dongCount);
				}

				count++;
			}

			// Document 저장
			DOMSource xmlDOM = new DOMSource(document);
			StreamResult xmlFile = new StreamResult(new File("c:\\xml\\dongCount.xml"));
			TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlFile);
			
			// 작업이 끝난 후에 객체를 전부 종료해 준다
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
