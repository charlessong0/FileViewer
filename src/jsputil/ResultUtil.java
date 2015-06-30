package jsputil;

import java.util.ArrayList;

import objects.Table;

public class ResultUtil {
	
	/**
	 * create the selection for title - used in column search
	 * <option value ="1">PP_TRR</option> <option value="2">GLOBAL.BIN.RANGE</option>  
	 * @param table
	 * @return
	 */
	public String createTitleSelection(Table table) {
		StringBuffer sb = new StringBuffer();
		ArrayList<String> title = new ArrayList<String>();
		if (table.getHasTitle()) 
			title = table.getTitleList().get(1);
		else
			title = table.getTitleList().get(0);
		
		int length = title.size();
		for (int i = 0; i < length; i++) {
			sb.append("<option value =\"");
			sb.append(i);
			sb.append("\">");
			sb.append(title.get(i));
			sb.append("</option>");
		}
		
		return sb.toString();
	}

}
