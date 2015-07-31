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
        


           
        
    }  	
}
