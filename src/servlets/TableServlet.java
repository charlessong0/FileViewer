package servlets;

import jsputil.CreateFixedTable;

public class TableServlet {
	public String getTable() throws Exception {
		CreateFixedTable cft = new CreateFixedTable("C:\\Users\\znsong\\Documents\\My Received Files\\structureFixed.xml", "C:\\Users\\znsong\\Documents\\My Received Files\\KXCV00P.GB.GLOBAL.BIN.RANGE.G3586V00.txt");
		return cft.createTable(1, 20);
	}

}
