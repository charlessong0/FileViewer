package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsputil.CreateFixedTable;
import jsputil.ResultUtil;
import objects.FileSample;
import objects.Table;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * Servlet implementation class MyServlet
 */
public class UploadServlet extends HttpServlet {
	private RequestDispatcher dispatcher;
	private CreateFixedTable cft;
	private ResultUtil ru = new ResultUtil();
	private FileSample fs;
	private FileInputStream fis;
	private String finalPath;
	private String date = "";
	/**
	 * Default constructor.
	 */
	public UploadServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		
		try{
			// MyForm myForm = new MyForm(); // Prepare bean.
			// process(request, myForm); // Process request.
			process(request); 
//			if (fis == null)
//				System.out.println("3:it is null!");
//			System.out.println(fis);
			request.setAttribute("finalPath", finalPath);
			request.setAttribute("date", date);
			dispatcher = request.getRequestDispatcher("/filepath.jsp"); 
			dispatcher.forward(request, response);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	// private void process(HttpServletRequest request, MyForm myForm) {

	private void process(HttpServletRequest request) throws Exception {
		try {
			List<FileItem> items = new ServletFileUpload(
					new DiskFileItemFactory()).parseRequest(request);

			for (FileItem item : items) {
				if (item.isFormField()) {
					System.out.println("there is a form field.");
				}else{ // Process the form file field (input type="file")
					//get current system time
					Calendar c = Calendar.getInstance();
					int year = c.get(Calendar.YEAR);
					int month = c.get(Calendar.MONTH) + 1;
					int day = c.get(Calendar.DATE);
					String time = "";
					time += year;
					if (month < 10) {
						time += 0;
					}
					time += month;
					if (day < 10) {
						time += 0;
					}
					time +=day;
					System.out.println(time);
					date = time;
					
					InputStream in = item.getInputStream();
					
					String fileName = FilenameUtils.getName(item.getName());
					System.out.println("Filename -> " + fileName);
					String realPath = getServletContext().getRealPath("/");
					File file = new File(realPath+"/uploadFolder");
					file.mkdir();
					
					String prefix = FilenameUtils.getBaseName(fileName) + "_"; 
					//String prefix = time + "_" + FilenameUtils.getBaseName(fileName);
					System.out.println("prefix -> "+prefix);
		            
					String suffix = "." + FilenameUtils.getExtension(fileName);
					System.out.println("suffix -> "+suffix);
					// Prepare filename prefix and suffix for an unique filename in upload folder.
					//File tempFile = File.createTempFile(prefix, suffix,file); 
					
					finalPath = file.toString() + "\\" + prefix+suffix;
					File tempFile = new File(finalPath);
					System.out.println("tempFile -> "+ tempFile);
					item.write(tempFile); // File uploaded to "uploadFolder" in Web Server(Not database)
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
			throw new Exception(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} 
	}
}