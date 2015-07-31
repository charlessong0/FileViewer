package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.FileTypeMapping;
import objects.FileSample;
import objects.Table;
import jsputil.CreateCsvTable;
import jsputil.CreateFixedTable;
import jsputil.ResultUtil;

public class TableServlet extends HttpServlet {
	private CreateFixedTable cft;
	private ResultUtil ru = new ResultUtil();
	private FileSample fs;
	private RequestDispatcher dispatcher;
	private CreateCsvTable tt = new CreateCsvTable();
	public String finalPath = "";
	public String table = "";
	public String header = "";
	public String tailer = "";
	public String date = "";
	public String fileType = "";
	public String fixedPath = "";
	public String csvPath = "";

	
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		finalPath = request.getParameter("finalPath");
		date = request.getParameter("date");
		System.out.println("hahahaha" + finalPath);
		
		//get the real path for the xml file
		String tempPath = request.getSession().getServletContext().getRealPath(request.getRequestURI());
		int tempLength = tempPath.length();
		String realPath = tempPath.substring(0, tempLength - 19);
		System.out.println(realPath);
		fixedPath = realPath + "structureFixed.xml";
		csvPath = realPath + "structure.xml";
		
		//fixedPath = "C:\\Users\\znsong\\Workspaces\\MyEclipse Professional 2014\\.metadata\\.me_tcat7\\webapps\\FileViewer\\structureFixed.xml";
		//fixedPath = "C:\\Users\\znsong\\Documents\\My Received Files\\structureFixed.xml";
		
		FileTypeMapping ftm = new FileTypeMapping(csvPath, fixedPath);
		String fileType = ftm.washFileName(finalPath);
		System.out.println(fileType);
		fs = ftm.getFileSample(fileType);
		//date = ftm.getUploadDate(finalPath);
		
		int which = ftm.getWhich();
		System.out.println(which);
		
		
		request.setAttribute("finalPath", finalPath);
		request.setAttribute("fixedPath", fixedPath);
		request.setAttribute("csvPath", csvPath);
		request.setAttribute("fileType", fileType);
		request.setAttribute("date", date);
		
		
		if (fileType.equals(null)) {
			dispatcher = request.getRequestDispatcher("/error.jsp");  
			dispatcher.forward(request, response);
		}
		if (which == 0) {
			dispatcher = request.getRequestDispatcher("/error.jsp");  
			dispatcher.forward(request, response);
		}
		if (which == 1) { // the file is a csv file
			try {
				table = tt.getTable(finalPath, csvPath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("table", table);
			
			dispatcher = request.getRequestDispatcher("/csvTable.jsp"); 
			dispatcher.forward(request, response);
		}
		if (which == 2) { //the file is a fixed length file
			
			try {
				cft = new CreateFixedTable(fs, finalPath);
				
				table = cft.createTable(1, 1000);
				header = cft.createHeaderTable();
				tailer = cft.createTailerTable();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			request.setAttribute("table", table);
			request.setAttribute("header", header);
			request.setAttribute("tailer", tailer);
			
			dispatcher = request.getRequestDispatcher("/fixTest.jsp"); 
			dispatcher.forward(request, response);
		}
		
		
//		if (finalPath.equals("C:\\Users\\znsong\\Workspaces\\MyEclipse Professional 2014\\.metadata\\.me_tcat7\\webapps\\FileViewer\\uploadFolder\\KXCV00P.GB.GLOBAL.BIN.RANGE.G3586V00_.txt")){
//			request.setAttribute("finalPath", finalPath);
//			request.setAttribute("fixedPath", fixedPath);
//			request.setAttribute("csvPath", csvPath);
//			dispatcher = request.getRequestDispatcher("/fixedTable.jsp"); 
//			dispatcher.forward(request, response);
//		}
//		else if (finalPath.equals("C:\\Users\\znsong\\Workspaces\\MyEclipse Professional 2014\\.metadata\\.me_tcat7\\webapps\\FileViewer\\uploadFolder\\US-eBay-EOM-Fees@ebay.com.TRR-20140702.01.008_.CSV")) {
//			dispatcher = request.getRequestDispatcher("/csvTable.jsp"); 
//			dispatcher.forward(request, response);
//		}
//		else if (finalPath.equals("C:\\Users\\znsong\\Workspaces\\MyEclipse Professional 2014\\.metadata\\.me_tcat7\\webapps\\FileViewer\\uploadFolder\\MVX5N5KZ9CTX8_receipt_2014-05-15-446 - Copy_.csv")) {
//			dispatcher = request.getRequestDispatcher("/csvTable2.jsp"); 
//			dispatcher.forward(request, response);
//		}
//		else if (finalPath.equals("C:\\Users\\znsong\\Workspaces\\MyEclipse Professional 2014\\.metadata\\.me_tcat7\\webapps\\FileViewer\\uploadFolder\\FID1556739.KASYEB72.12272014-Copy_.020110")) {
//			
//		}
		
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
	

}
