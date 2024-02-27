package tw.com.jeff.init;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class insertAirline {
	public static void main(String[] args) { // 插入資料的sql語句
		

		String sql = "insert into airline(airlineid,airlinename) values (?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			
			
			conn = DbUtil.getConnection();
			
			
			
			pstmt = conn.prepareStatement(sql);
			
			
			// 讀取xml檔案
			Document doc = new SAXReader().read(new File("C:/Airline_CHT.xml"));
			
			// 選擇xml檔案的節點
			List<?> itemList = doc.selectNodes("//T");
			// 遍歷讀出的xml中的節點
			for (Iterator<?> iter = itemList.iterator(); iter.hasNext();) {
				Element el = (Element) iter.next(); 
				// 讀取節點內容
				String 航空公司代碼 = el.selectSingleNode("C").getText();
				String 航空公司名稱 = el.selectSingleNode("D").getText();
				// 遍歷TURNOS節點中的內容
				
				pstmt.setString(1, 航空公司代碼);
				pstmt.setString(2, 航空公司名稱);
				
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			System.out.print("將XML匯入資料庫成功");
		} catch (Exception e) {
			System.out.println("wrong");
			e.printStackTrace();
		} finally {
			try {
				DbUtil.close(pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				DbUtil.close(conn);
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	}
}

