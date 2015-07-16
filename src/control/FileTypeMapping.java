package control;

import java.util.ArrayList;

import dbutil.ReadCSVXML;
import dbutil.ReadFixedXML;
import objects.FileSample;
import error.Error;

public class FileTypeMapping {
	private String csvTemplate;
	private String fixedTemplate;
	Error err = new Error();
	
	public FileTypeMapping() {
		
	}
	
	public FileTypeMapping(String csvTemplate, String fixedTemplate) {
		this.csvTemplate = csvTemplate;
		this.fixedTemplate = fixedTemplate;
	}
	
	public void setTemplate(String csvTemplate, String fixedTemplate) {
		this.csvTemplate = csvTemplate;
		this.fixedTemplate = fixedTemplate;
	}
	
	public FileSample getFileSample(String fileType) {
		FileSample fs = null;
		ReadFixedXML fix = new ReadFixedXML(fixedTemplate);
		ReadCSVXML csv = new ReadCSVXML(csvTemplate);
		ArrayList<String> fixTypeList = fix.getFileType();
		ArrayList<String> csvTypeList = csv.getFileType();
		
		int index = isInList(fileType, csvTypeList);
		if (index != -1) 
			fs = csv.getFileList().get(index);
		else {
			index = isInList(fileType, fixTypeList);
			if (index != -1) 
				fs = fix.getFileList().get(index);
			else
				err.err(50);
		}
		return fs;
	}
	
	public String washFileName(String fileName) {
		String result = "";
		
		return result;
	}
	
	public String getUploadDate(String fileName) {
		return fileName.substring(0, 5);
	}
	
	
	/*
	 * private methods
	 */
	
	private int isInList(String str, ArrayList<String> list) {
		int length = list.size();
		for(int i = 0; i < length; i++) {
			if (str.equals(list.get(i)))
				return i;
		}
		return -1;
	}
	
}
