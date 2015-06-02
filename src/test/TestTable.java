package test;

import java.util.Iterator;

public class TestTable {
	//private String table = "<tr> <td width=\"200\">1</td> <td width=\"200\">2</td> <td width=\"200\">3</td> </tr> <tr> <td>a</td> <td>b</td> <td>c</td> </tr> <tr> <td>test1</td> <td>test2</td> <td>test3</td> </tr> ";
	private String table = "";
	
	public String getTable() throws Exception {
		//FileReader fr = new FileReader("C:\\Users\\znsong\\Documents\\My Received Files\\US-eBay-EOM-Fees@ebay.com.TRR-20140702.01.008.csv");
		//FileReader fr = new FileReader("C:\\Users\\znsong\\Documents\\My Received Files\\MVX5N5KZ9CTX8_results_2014-05-15-446.csv");
		FileReader fr = new FileReader("C:\\Users\\znsong\\Documents\\My Received Files\\US-eBay-EOM-Fees@ebay.com.TRR-20140702.01.008.csv");
		
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
				
				Iterator it = fr.fromCSVLinetoArray(temp).iterator();
				
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
				}
				table += "</tr>";
			}
		}
		return table;
	}
}


