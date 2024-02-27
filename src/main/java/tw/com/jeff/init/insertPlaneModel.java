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

public class insertPlaneModel {
	public static void main(String[] args) { // 插入資料的sql語句
		

		String sql = "insert into planemodel(planemodelid,planemodelname) values (?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			
			
			conn = DbUtil.getConnection();
			
			
			
			pstmt = conn.prepareStatement(sql);
			
			
			// 讀取xml檔案
			Document doc = new SAXReader().read(new File("C:/AirlineEquipment_Itinerary_CHT.XML"));
			
			// 選擇xml檔案的節點
			List<?> itemList = doc.selectNodes("//T");
			// 遍歷讀出的xml中的節點
			for (Iterator<?> iter = itemList.iterator(); iter.hasNext();) {
				Element el = (Element) iter.next(); 
				// 讀取節點內容
				String 飛機型號代碼 = el.selectSingleNode("C").getText();
				String 飛機型號 = el.selectSingleNode("D").getText();
				// 遍歷TURNOS節點中的內容
				
				pstmt.setString(1, 飛機型號代碼);
				pstmt.setString(2, 飛機型號);
				
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


