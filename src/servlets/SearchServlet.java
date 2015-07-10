package servlets;

import java.io.IOException;  
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import objects.FileSample;
import objects.Structure;
import objects.Table;
import objects.Validation;
import dbutil.FileReaderCSV;
import dbutil.ReadCSVXML;

public class SearchServlet extends HttpServlet{  
    private String search = "";  
    private  String token = "";  
    public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException  
    {  
        RequestDispatcher dispatcher;  
        //search = request.getParameter("search");  
        token = request.getParameter("token");  
        
        System.out.println(token);
        

        	if (token.equals("0AH893531M163924B")||token.equals("2184345908")||token.equals("B-9PD800852D3247423")) {
        		
    			dispatcher = request.getRequestDispatcher("/searchResult1.jsp"); 
    			dispatcher.forward(request, response);
        	}
        	else if (token.equals("97V36229F3487341Y")||token.equals("3317326292")||token.equals("B-06879057E3852652W")) {
    			dispatcher = request.getRequestDispatcher("/searchResult2.jsp"); 
    			dispatcher.forward(request, response);
        	}
        	else {
    			dispatcher = request.getRequestDispatcher("/searchError.jsp"); 
    			dispatcher.forward(request, response);
        	}
           
        
    }  	
}
