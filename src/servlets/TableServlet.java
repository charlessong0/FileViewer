package servlets;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.FileSample;
import objects.Table;
import jsputil.CreateFixedTable;
import jsputil.ResultUtil;

public class TableServlet extends HttpServlet {
	private CreateFixedTable cft;
	private ResultUtil ru = new ResultUtil();
	private FileSample fs;
	private RequestDispatcher dispatcher;
	public String finalPath = "";
	public String table = "";
	public String header = "";
	public String tailer = "";

	
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		finalPath = request.getParameter("finalPath");
		System.out.println(finalPath);
		
		if (finalPath.equals("C:\\Users\\znsong\\Workspaces\\MyEclipse Professional 2014\\.metadata\\.me_tcat7\\webapps\\FileViewer\\uploadFolder\\KXCV00P.GB.GLOBAL.BIN.RANGE.G3586V00_.txt")){
			dispatcher = request.getRequestDispatcher("/fixedTable.jsp"); 
			dispatcher.forward(request, response);
		}
		else if (finalPath.equals("C:\\Users\\znsong\\Workspaces\\MyEclipse Professional 2014\\.metadata\\.me_tcat7\\webapps\\FileViewer\\uploadFolder\\US-eBay-EOM-Fees@ebay.com.TRR-20140702.01.008_.CSV")) {
			dispatcher = request.getRequestDispatcher("/csvTable.jsp"); 
			dispatcher.forward(request, response);
		}
		else if (finalPath.equals("C:\\Users\\znsong\\Workspaces\\MyEclipse Professional 2014\\.metadata\\.me_tcat7\\webapps\\FileViewer\\uploadFolder\\MVX5N5KZ9CTX8_receipt_2014-05-15-446 - Copy_.csv")) {
			dispatcher = request.getRequestDispatcher("/csvTable2.jsp"); 
			dispatcher.forward(request, response);
		}
		
		else {
			dispatcher = request.getRequestDispatcher("/error.jsp");  
			dispatcher.forward(request, response);
		}
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String temp = request.getParameter("finalPath");
		//System.out.println(temp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		
	}
	
	public String getTable() throws Exception {
		cft = new CreateFixedTable("C:\\Users\\znsong\\Documents\\My Received Files\\structureFixed.xml", "C:\\Users\\znsong\\Documents\\My Received Files\\KXCV00P.GB.GLOBAL.BIN.RANGE.G3586V00.txt");
		fs = cft.getFileSample();
		return cft.createTable(1, 1000);
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
