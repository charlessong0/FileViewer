package servlets;

import java.io.IOException;  

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

public class SearchServlet extends HttpServlet{  
    private String search;  
    private  String token;  
    public void service(HttpServletRequest request,HttpServletResponse response)  
    {  
        RequestDispatcher dispatcher;  
        search = request.getParameter("search");  
        token = request.getParameter("token");  
        
        if(search.equals("")||token.equals(""))  
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
        else  
        {
        	
           
        }  
    }  	
}
