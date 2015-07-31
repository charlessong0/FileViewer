package error;

public class Error {

	public void err(int index) {
		System.out.println(index);
		
		//type 1 error: xml mistakes
		//11 - xml file level error: type, structure, table, validation
		//12 structure
		//13 table
		//14 validation
		//21 no such batch header in the file
		//31 page index out of bound
		//40 empty fixed file
		
//		/*
//		 *         	if (token.equals("0AH893531M163924B")||token.equals("2184345908")||token.equals("B-9PD800852D3247423")) {
//        		
//    			dispatcher = request.getRequestDispatcher("/searchResult1.jsp"); 
//    			dispatcher.forward(request, response);
//        	}
//        	else if (token.equals("97V36229F3487341Y")||token.equals("3317326292")||token.equals("B-06879057E3852652W")) {
//    			dispatcher = request.getRequestDispatcher("/searchResult2.jsp"); 
//    			dispatcher.forward(request, response);
//        	}
//        	else {
//    			dispatcher = request.getRequestDispatcher("/searchError.jsp"); 
//    			dispatcher.forward(request, response);
//        	}
//		 */
	}

}
