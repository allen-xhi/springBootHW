package tw.com.jeff.home.view;
  
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import tw.com.jeff.model.TripBean;
import tw.com.jeff.ticket.model.FlightOrderBean;





public class MultipleTripsExcelView extends AbstractXlsView  {
	
	Sheet sheet;	
	String sheetName = "sheet 1";
	HSSFFont chiTextFont = null;
	HSSFFont engTextFont = null;
	HSSFFont titleFont = null;
	int rowCount = 0;
	int colCount = 0;
	short fontSize = 16;
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		rowCount = 0;
		colCount = 0;
		setSheetProperties(workbook);
        createExcelHeaders(workbook);
		populateExcelCells(model, workbook);

	}

	private void setSheetProperties(Workbook workbook) {
		// 由 workbook產生Sheet物件
		sheet = workbook.createSheet(sheetName);
		// 由 workbook產生HSSFont物件
		chiTextFont= (HSSFFont)workbook.createFont();
		// 設定字型名稱
		chiTextFont.setFontName("新細明體");
		// 設定字號		
		chiTextFont.setFontHeightInPoints(fontSize);
		//--------------------------------------
		// 由 workbook產生HSSFont物件
		engTextFont= (HSSFFont)workbook.createFont();
		// 設定字型名稱
		engTextFont.setFontName("Arial");
		// 設定字號
		engTextFont.setFontHeightInPoints(fontSize);
		
		
		titleFont = chiTextFont;
	}

	private void populateExcelCells(Map<String, Object> model, Workbook workbook) {
		Sheet sheet = workbook.getSheet(sheetName);
		
		HSSFCellStyle styleCenter = (HSSFCellStyle)workbook.createCellStyle();
		styleCenter.setFont(engTextFont);
		
		styleCenter.setFillForegroundColor(IndexedColors.WHITE.index);
		styleCenter.setFillPattern(CellStyle.SOLID_FOREGROUND);
		styleCenter.setAlignment(CellStyle.ALIGN_CENTER);
		
		styleCenter.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		styleCenter.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		styleCenter.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		styleCenter.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		
		CellStyle styleName = workbook.createCellStyle();
		styleName.setFillForegroundColor(IndexedColors.WHITE.index);
		styleName.setFillPattern(CellStyle.SOLID_FOREGROUND);
		styleName.setAlignment(CellStyle.ALIGN_CENTER);
		styleName.setFont(chiTextFont);
		
		styleName.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		styleName.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		styleName.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		styleName.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		
		
		
		
		CellStyle styleRight = workbook.createCellStyle();
		styleRight.setFillForegroundColor(IndexedColors.WHITE.index);
		styleRight.setFillPattern(CellStyle.SOLID_FOREGROUND);
		styleRight.setAlignment(CellStyle.ALIGN_RIGHT);
		styleRight.setFont(engTextFont);
		
		styleRight.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		styleRight.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		styleRight.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		styleRight.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);

		
        HSSFCellStyle styleDate = (HSSFCellStyle)workbook.createCellStyle();
		
		CreationHelper createHelper = workbook.getCreationHelper();
		styleDate.setDataFormat(
		    createHelper.createDataFormat().getFormat("yyyy/mm/dd"));
		styleDate.setFont(engTextFont);
		styleDate.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		styleDate.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		styleDate.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		styleDate.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		styleDate.setAlignment(CellStyle.ALIGN_CENTER);
		
        List<FlightOrderBean> tb = (List<FlightOrderBean>) model.get("allTrip");
        
		Set<String> set = model.keySet();
		Row row = null;
		Cell cell = null;
		for(FlightOrderBean m : tb) {
			colCount = 0;
			row = sheet.createRow(rowCount++);
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleCenter);
			cell.setCellValue(m.getContactorEmail());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleName);
			cell.setCellValue(m.getAdultPrice());
				
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleDate);
			cell.setCellValue(m.getContactorTel());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleDate);
			cell.setCellValue(m.getContactorFirstName());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleDate);
			cell.setCellValue(m.getContactorLastName());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleDate);
			cell.setCellValue(m.getOrderCode());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleDate);
			cell.setCellValue(m.getOrderDate());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleDate);
			cell.setCellValue(m.getAdultEquipFare());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleDate);
			cell.setCellValue(m.getAdultTax());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleDate);
			cell.setCellValue(m.getCabin());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleDate);
			cell.setCellValue(m.getChildCount());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleDate);
			cell.setCellValue(m.getChildEquipFare());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleDate);
			cell.setCellValue(m.getChildPrice());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleDate);
			cell.setCellValue(m.getChildTax());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleDate);
			cell.setCellValue(m.getFlightOrderID());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleDate);
			cell.setCellValue(m.getOrderStatusID());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleDate);
			cell.setCellValue(m.getOrderTotalAmount());
		}
		
		int columnCount = sheet.getRow(0).getLastCellNum();
		for (int i=0; i < columnCount; i++){
			sheet.autoSizeColumn(i);
		}
	}

	private void createExcelHeaders(Workbook workbook) {
		String[] labels = {"ContactorEmail", "AdultPrice", "ContactorTel","ContactorFirstName","ContactorLastName","OrderCode"
		,"OrderDate","AdultEquipFare","AdultTax","Cabin","ChildCount","ChildEquipFare","ChildPrice"	,"ChildTax","FlightOrderID"
		,"OrderStatusID","OrderTotalAmount"};
		
		
		
		CellStyle titleStyle = workbook.createCellStyle();
		
		titleStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
		titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
		titleStyle.setFont(titleFont);
		
		titleStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		titleStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		titleStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		titleStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		
		
		// 建立Excel表的標頭
		Row row = null;
		Cell cell = null;
		row = sheet.createRow(rowCount++);
		colCount = 0;
		// Create header cells
		for(int n =0; n < labels.length; n++) {
			cell = row.createCell(colCount++);
			cell.setCellStyle(titleStyle);
			cell.setCellValue(labels[n]);
		}
	}

}
