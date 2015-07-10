package test;

import java.util.ArrayList;
import java.util.Iterator;

import dbutil.FileReaderCSV;
import dbutil.ReadCSVXML;
import objects.FileSample;
import objects.Structure;
import objects.Table;
import objects.Validation;

public class TestTable3 {
	public String tableStr = "";
	public String error = "";
	
	public String getTable() throws Exception {
		//FileReader fr = new FileReader("C:\\Users\\znsong\\Documents\\My Received Files\\US-eBay-EOM-Fees@ebay.com.TRR-20140702.01.008.csv");
		//FileReader fr = new FileReader("C:\\Users\\znsong\\Documents\\My Received Files\\MVX5N5KZ9CTX8_results_2014-05-15-446.csv");
		FileReaderCSV fr = new FileReaderCSV("C:\\Users\\znsong\\Documents\\My Received Files\\US-eBay-EOM-Fees@ebay.com.TRR-20140702.01.008 - Copy.csv");
		ReadCSVXML readXML = new ReadCSVXML("C:\\Users\\znsong\\Documents\\My Received Files\\structure.xml");
		ArrayList<FileSample> fileList = readXML.getFileList();
		FileSample file = fileList.get(0);
		Validation validation = file.getValidation();
		
		String readLine = "";
		int lineLength = 0;
		String token = "";
		boolean show = false;
		boolean isTitle = false;
		int row = 0;
		int column = 0;
		
		//get basic structure from file
		Structure structure = file.getStructure();
		Table table = file.getTable();
		boolean hasTitle = table.getHasTitle();
		//String fileHeader = structure.getFileHeader();
		//String fileFooter = structure.getFileFooter();
		String batchHeader = structure.getBatchHeader();
		String batchFooter = structure.getBatchFooter();
		String title = structure.getTitle();
		String content = structure.getContent();
		ArrayList templateTitle = new ArrayList();
		
		//if there is existing title in the file, we can just use it and do not have to read title in XML template
		if (hasTitle) {
			while (true) {
				readLine = fr.readLine();
				lineLength = fr.fromCSVLinetoArray(readLine).size();
				
				if (lineLength == 0)
					break;
				else {
					Iterator<String> it = fr.fromCSVLinetoArray(readLine).iterator();
					while (it.hasNext()) {
						token = (String) it.next();
						if (token.equals(title)) {
							show = true;
							isTitle = true;
							tableStr += "<thead>";
							tableStr += "<tr>";
							tableStr += "<th>Index</th>";
						}
						else if (token.equals(content)) {
							show = true;
							if (isTitle) {
								isTitle = false;
								tableStr += "</tr>";
								tableStr += "</thead><tbody>";
							}
							row ++;
							column = 1;
							tableStr += "</tr>";
							tableStr += "<tr><td>";
							tableStr += row;
							tableStr += "</td>";
						}
						else if(token.equals(batchFooter)) {
							tableStr += "</tr>";
							show = false;
							break;
						}
						else if (show) {
							column++;
							if (row == 1 && column == 10) {
								//System.out.println(token);
									tableStr += "<td>";
									tableStr += token;
									tableStr += "</td>";
							}
							else {
								if (isTitle) {
									tableStr += "<th>";
									tableStr += token;
									tableStr += "</th>";
								}
								else {
									tableStr += "<td>";
									tableStr += token;
									tableStr += "</td>";
								}
							}
						}
					}
					tableStr += "</tr>";
				}
				//System.out.println(tableStr);
			}
		}
		//if there is no existing title in the file, we need to get the title in the XML template
		else {
			//add title in the table
			tableStr += "<thead>";
			tableStr += "<tr>";
			tableStr += "<th>Index</th>";
			Iterator itTitle = templateTitle.iterator();
			while(itTitle.hasNext()) {
				tableStr += "<th>";
				tableStr += itTitle.next();
				tableStr += "</th>";
			}
			tableStr += "</tr>";
			tableStr += "</thead><tbody>";
			
			while (true) {
				readLine = fr.readLine();
				lineLength = fr.fromCSVLinetoArray(readLine).size();
				
				if (lineLength == 0)
					break;
				else {
					Iterator<String> it = fr.fromCSVLinetoArray(readLine).iterator();
					while (it.hasNext()) {
						token = (String) it.next();
						if (token.equals(content)) {
							show = true;
							row ++;
							column = 1;
							tableStr += "</tr>";
							tableStr += "<tr><td>";
							tableStr += row;
							tableStr += "</td>";
						}
						else if(token.equals(batchFooter)) {
							tableStr += "</tr>";
							show = false;
							break;
						}
						else if (show) {
							column++;
							if (row == 1 && column == 10) {
									tableStr += "<td>";
									tableStr += token;
									tableStr += "</td>";
							}
							else {
								tableStr += "<td>";
								tableStr += token;
								tableStr += "</td>";
							}
						}
					}
					tableStr += "</tr>";
				}
				//System.out.println(tableStr);
			}
		}
		
		//System.out.println(tableStr);
		return tableStr;
	}

}

