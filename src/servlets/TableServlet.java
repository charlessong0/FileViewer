package servlets;

import jsputil.CreateFixedTable;

public class TableServlet {
	private CreateFixedTable cft;
	public String getTable() throws Exception {
		cft = new CreateFixedTable("C:\\Users\\znsong\\Documents\\My Received Files\\structureFixed.xml", "C:\\Users\\znsong\\Documents\\My Received Files\\KXCV00P.GB.GLOBAL.BIN.RANGE.G3586V00.txt");
		return cft.createTable(1, 2000);
	}
	
	public String getHeader() throws Exception {
		return cft.createHeaderTable();
	}
	
	public String getTailer() throws Exception {
		return cft.createTailerTable();
	}

}
