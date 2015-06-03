package test;

import java.util.ArrayList;
import java.util.Iterator;

import dbutil.ReadXML;
import objects.FileSample;
import objects.Validation;

public class TestTable {
	public String table = "";

	public String getTable() throws Exception {
		//FileReader fr = new FileReader("C:\\Users\\znsong\\Documents\\My Received Files\\US-eBay-EOM-Fees@ebay.com.TRR-20140702.01.008.csv");
		//FileReader fr = new FileReader("C:\\Users\\znsong\\Documents\\My Received Files\\MVX5N5KZ9CTX8_results_2014-05-15-446.csv");
		FileReader fr = new FileReader("C:\\Users\\znsong\\Documents\\My Received Files\\US-eBay-EOM-Fees@ebay.com.TRR-20140702.01.008.csv");
		ReadXML readXML = new ReadXML("C:\\Users\\znsong\\Documents\\My Received Files\\structure.xml");
		ArrayList<FileSample> fileList = readXML.getFileList();
		FileSample file = fileList.get(0);
		Validation validation = file.getValidation();
		
		String temp = "";
		int length = 0;
		String token = "";
		boolean view = false;
		int row = 0;
		int column = 0;
		
		while (true) {
			temp = fr.readLine();
			length = fr.fromCSVLinetoArray(temp).size();
			
			if (length == 0)
				break;
			else {
				Iterator<String> it = fr.fromCSVLinetoArray(temp).iterator();
				while (it.hasNext()) {
					token = (String) it.next();
					if (token.equals("CH")) {
						view = true;
						table += "<tr background-color=\"red\">";
						table += "<td>Index</td>";
					}
					else if (token.equals("SB")) {
						view = true;
						row ++;
						column = 1;
						table += "</tr>";
						table += "<tr><td>";
						table += row;
						table += "</td>";
					}
					else if(token.equals("SF")) {
						table += "</tr>";
						view = false;
						break;
					}
					else if (view) {
						column++;
						if (row == 1 && column == 10) {
							int upper = validation.getColumn(10).getUpper();
							int lower = validation.getColumn(10).getLower();
							int value = Integer.parseInt(token);
							if (value < lower || value > upper) {
								table += "<td bgcolor=\"red\">";
								table += token;
								table += "</td>";
							}
							else {
								table += "<td>";
								table += token;
								table += "</td>";
							}
						}
						else {
							table += "<td>";
							table += token;
							table += "</td>";
						}
					}
				}
				table += "</tr>";
			}
		}
		return table;
	}
}

