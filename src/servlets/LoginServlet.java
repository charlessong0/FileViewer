package servlets;

import java.io.IOException;  

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

public class LoginServlet extends HttpServlet{  
    private String fileName;  
    private  String fileType;  
    public void service(HttpServletRequest request,HttpServletResponse response)  
    {  
        RequestDispatcher dispatcher;  
        fileName = request.getParameter("fileName");  
        fileType = request.getParameter("fileType");  
        
        if(fileName.equals(fileType))  
        {
        	if(fileName.equals("0")) {
        		dispatcher = request.getRequestDispatcher("/csvTable.jsp");  
                try {  
                    dispatcher.forward(request, response);  
                } catch (ServletException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                } catch (IOException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
        	}
        	else if(fileName.equals("1")) {
        		dispatcher = request.getRequestDispatcher("/fixedTable.jsp");  
                try {  
                    dispatcher.forward(request, response);  
                } catch (ServletException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                } catch (IOException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
        	}
            
        }  
        else  
        {
            dispatcher = request.getRequestDispatcher("/error.jsp");  
            try {  
                dispatcher.forward(request, response);  
            } catch (ServletException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }  	
}
