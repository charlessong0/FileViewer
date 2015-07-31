package control;

import java.util.ArrayList;

import dbutil.ReadCSVXML;
import dbutil.ReadFixedXML;
import objects.FileSample;
import error.Error;

public class FileTypeMapping {
	private String csvTemplate;
	private String fixedTemplate;
	private int which = 0;
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
		if (index != -1) {
			fs = csv.getFileList().get(index);
			which = 1;
		}
		else {
			index = isInList(fileType, fixTypeList);
			if (index != -1) {
				fs = fix.getFileList().get(index);
				which = 2;
			}
			else
				err.err(50);
		}
		return fs;
	}
	
	/**
	 * wash the file name to the exact string we expect for file type
	 * @param fileName
	 * @return
	 */
	public String washFileName(String fileName) {
		ReadFixedXML fix = new ReadFixedXML(fixedTemplate);
		ReadCSVXML csv = new ReadCSVXML(csvTemplate);
		ArrayList<String> fixTypeList = fix.getFileType();
		ArrayList<String> csvTypeList = csv.getFileType();
		for (int i = 0; i < fixTypeList.size(); i++) {
			if (isInString(fileName, fixTypeList.get(i)) != -1)
					return fixTypeList.get(i);
		}
		
		for (int i = 0; i < csvTypeList.size(); i++) {
			if (isInString(fileName, csvTypeList.get(i)) != -1)
				return csvTypeList.get(i);
		}
		return null;
	}
	
	public String getUploadDate(String fileName) {
		return fileName.substring(0, 7);
	}
	
	public int getWhich() {
		return which;
	}
	
	/*
	 * private methods
	 */
	
	
	/**
	 * if the string is in the list, return the position, else, return -1
	 * @param str
	 * @param list
	 * @return
	 */
	private int isInList(String str, ArrayList<String> list) {
		int length = list.size();
		for(int i = 0; i < length; i++) {
			if (str.equals(list.get(i)))
				return i;
		}
		return -1;
	}
	
	/**
	 * if the substring is in the string, return the position, else, return -1
	 * @param string
	 * @param subString
	 * @return
	 */
	private int isInString(String string, String subString) {
		int length = subString.length();
		int totalLength = string.length();
		if (totalLength < length)
			return -1;
		for (int i = 0; i < totalLength - length; i++) {
			if (string.charAt(i) == subString.charAt(0)) {
				if (string.substring(i, i + length).equals(subString))
					return i;
			}
		}
		return -1;
	}
	
}
