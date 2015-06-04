package test;

import java.util.ArrayList;
import java.util.Iterator;

import dbutil.ReadXML;
import objects.FileSample;
import objects.Validation;

public class TestTable {
	public String table = "";
	public String error = "";

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
		boolean isTitle = false;
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
						isTitle = true;
						table += "<thead>";
						table += "<tr>";
						table += "<th>Index</th>";
					}
					else if (token.equals("SB")) {
						view = true;
						if (isTitle) {
							isTitle = false;
							table += "</tr>";
							table += "</thead><tbody>";
						}
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
								error += "<div style=\"color:red\"><b>there is a validation conflict in row ";
								error += row;
								error += ", column ";
								error += column;
								error += "which is marked in red</b></div>";
								System.out.println(error);
							}
							else {
								table += "<td>";
								table += token;
								table += "</td>";
							}
						}
						else {
							if (isTitle) {
								table += "<th>";
								table += token;
								table += "</th>";
							}
							else {
								table += "<td>";
								table += token;
								table += "</td>";
							}
							
						}
					}
				}
				table += "</tr>";
			}
		}
		return table;
	}
}

