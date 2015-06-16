package jsputil;

import java.util.ArrayList;
import java.util.Iterator;

import objects.FileSample;
import dbutil.FileUtilFixed;
import dbutil.ReadFixedXML;

public class CreateFixedTable {
	private ReadFixedXML fix;
	private FileUtilFixed fuf;
	private FileSample fs;
	private ArrayList<String> header = null;
	private ArrayList<String> tailer = null;
	
	public CreateFixedTable(String pathXML, String pathFile) throws Exception {
		fix = new ReadFixedXML(pathXML);
		fs = fix.getFileList().get(0);
		fuf = new FileUtilFixed(pathFile, fs);
	}
	
	public CreateFixedTable(String pathXML, String pathFile, String fileType, String fileName) throws Exception {
		fix = new ReadFixedXML(pathXML);
		fs = fix.getFileList().get(0);
		fuf = new FileUtilFixed(pathFile, fs);
	}
	
	/**
	 * create the fixed table for certain page and certain number of contents
	 * @param pageNumber
	 * @param showNumber
	 * @return
	 * @throws Exception
	 */
	public String createTable(int pageNumber, int showNumber) throws Exception {
		StringBuilder sbTable = new StringBuilder();
		sbTable.append("<thead><tr><th>Index</th>");
		ArrayList<String> title = fs.getTable().getTitleList().get(1);
		Iterator<String> itTitle = title.iterator();
		while(itTitle.hasNext()) {
			sbTable.append("<th>");
			sbTable.append(itTitle.next());
			sbTable.append("</th>");
		}
		sbTable.append("</tr></thead><tbody>");
		
		ArrayList<ArrayList<String>> content = fuf.getPage(showNumber, pageNumber);
		int length = content.size();
		header = content.get(0);
		tailer = content.get(length - 1);
		for (int i = 1; i < length - 1; i++) {
			sbTable.append("<tr>");
			sbTable.append("<td>");
			sbTable.append(i);
			sbTable.append("</td>");
			ArrayList<String> row = content.get(i);
			Iterator<String> itRow = row.iterator();
			while (itRow.hasNext()) {
				sbTable.append("<td>");
				sbTable.append(itRow.next());
				sbTable.append("</td>");
			}
			sbTable.append("</tr>");
		}
		
		return sbTable.toString();
	}
	
	public String createHeaderTable() throws Exception {
		StringBuilder sbTable = new StringBuilder();
		sbTable.append("<thead><tr>");
		ArrayList<String> title = fs.getTable().getTitleList().get(0);
		Iterator<String> itTitle = title.iterator();
		while(itTitle.hasNext()) {
			sbTable.append("<th>");
			sbTable.append(itTitle.next());
			sbTable.append("</th>");
		}
		sbTable.append("</tr></thead><tbody>");
		
		Iterator<String> itHeader = header.iterator();
		while(itHeader.hasNext()) {
			sbTable.append("<th>");
			sbTable.append(itHeader.next());
			sbTable.append("</th>");
		}
		return sbTable.toString();
	}
	
	public String createTailerTable() throws Exception {
		StringBuilder sbTable = new StringBuilder();
		sbTable.append("<thead><tr>");
		ArrayList<String> title = fs.getTable().getTitleList().get(2);
		Iterator<String> itTitle = title.iterator();
		while(itTitle.hasNext()) {
			sbTable.append("<th>");
			sbTable.append(itTitle.next());
			sbTable.append("</th>");
		}
		sbTable.append("</tr></thead><tbody>");
		
		Iterator<String> itTailer = tailer.iterator();
		while(itTailer.hasNext()) {
			sbTable.append("<th>");
			sbTable.append(itTailer.next());
			sbTable.append("</th>");
		}
		return sbTable.toString();
	}
	
	
	/*
	 * getters and setters
	 */
	
	public String getHeader() {
		return this.header.toString();
	}
	
	public String getTailer() {
		return this.tailer.toString();
	}
	
	//set xml template and get file sample by fileType and fileName
	public void setXML(String path, String fileType, String fileName) {
		fix = new ReadFixedXML(path);
		fs = fix.getFileList().get(0);
	}
	
	public void setFile(String path) throws Exception {
		fuf = new FileUtilFixed(path);
	}
	
	public void setFileSample(String fileType, String fileName) {
		
	}
}
