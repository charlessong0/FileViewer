package servlets;

import objects.FileSample;
import objects.Table;
import jsputil.CreateFixedTable;
import jsputil.ResultUtil;

public class TableServlet {
	private CreateFixedTable cft;
	private ResultUtil ru = new ResultUtil();
	private FileSample fs;
	public String getTable() throws Exception {
		cft = new CreateFixedTable("C:\\Users\\znsong\\Documents\\My Received Files\\structureFixed.xml", "C:\\Users\\znsong\\Documents\\My Received Files\\KXCV00P.GB.GLOBAL.BIN.RANGE.G3586V00.txt");
		fs = cft.getFileSample();
		return cft.createTable(1, 2000);
	}
	
	public String getHeader() throws Exception {
		return cft.createHeaderTable();
	}
	
	public String getTailer() throws Exception {
		return cft.createTailerTable();
	}
	
	public String getSearchTitle() {
		Table table = fs.getTable();
		return ru.createTitleSelection(table);
	}

}
