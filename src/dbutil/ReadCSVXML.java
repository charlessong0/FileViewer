package dbutil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import objects.ColumnVal;
import objects.FileSample;
import objects.Structure;
import objects.Table;
import objects.Validation;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import error.Error;


public class ReadCSVXML {
	private String filepath = "";
	private DocumentBuilder db= null;
	private DocumentBuilderFactory dbf= null;
	private File file = null;
	private Document doc = null;
	private Element root = null;
	private Error error = new Error();
	private ArrayList<FileSample> fileList = new ArrayList<FileSample>();
	
	public ReadCSVXML(String filepath) {
		/*
		setFilepath(filepath);
		System.out.println(this.filepath);
		setFile();
		setDocumentBuilderFactory();
		setDocumentBuilder();
		setDoc(this.db);
		setRoot(this.doc);
		
		System.out.println(root.getNodeName());
		//System.out.println(root.getTextContent());
		System.out.println(root.getAttributes().getNamedItem("class").getTextContent());
		
		NodeList childnodes = root.getChildNodes();
		Node detail = childnodes.item(5);
		if (detail.getNodeName() == "#text") {
			System.out.println("haha123");
		}
		//System.out.println(detail.getTextContent());
		System.out.println(detail.getNodeName());
		System.out.println(childnodes.getLength());
		
		NodeList childnodes2 = detail.getChildNodes();
		Node detail2 = childnodes2.item(1);
		System.out.println("~~~~~~~~~~~~~~~~~~");
		System.out.println(detail2.getAttributes().getNamedItem("value").getTextContent());
		System.out.println(detail2.getNodeName());
		System.out.println(detail2.getTextContent());
		if (detail2.getTextContent().equals(""))
			System.out.println("empty!!!!!!");
		System.out.println(childnodes2.getLength());
		
		System.out.println("this is the end of the test");
		
		*/
		setFilepath(filepath);
		System.out.println(this.filepath);
		setFile();
		setDocumentBuilderFactory();
		setDocumentBuilder();
		setDoc(this.db);
		setRoot(this.doc);
		
		System.out.println(root.getNodeName());
		NodeList files = root.getChildNodes();
		System.out.println(files.item(5).getNodeName());
		System.out.println(files.getLength());
		
		// read file list
		for (int i = 1; i <= getNum(files.getLength()); i++) {
			//System.out.println(i);
			Node file = files.item(setNum(i));
			FileSample readFile = new FileSample();
			NodeList innerFile = file.getChildNodes();
			readFile.setFileType(file.getTextContent());
			
			//set file type
			Node fileType = innerFile.item(setNum(1));
			//System.out.println(fileType.getTextContent());
			readFile.setFileType(fileType.getTextContent());
			
			//set file structure - done
			Structure structure = new Structure();
			Node fileStructure = innerFile.item(setNum(2));
			//System.out.println(fileStructure.getNodeName());
			NodeList structureList = fileStructure.getChildNodes();
			int structureLength = getNum(structureList.getLength());
			for (int j = 1; j <= structureLength; j++) {
				Node structureInfo = structureList.item(setNum(j));
				//System.out.println(structureInfo.getTextContent());
				if ("fileheader".equals(structureInfo.getNodeName())) {
					structure.setFileHeader(structureInfo.getTextContent());
				}
				else if ("filefooter".equals(structureInfo.getNodeName())) {
					structure.setFileFooter(structureInfo.getTextContent());
				}
				else if ("batchheader".equals(structureInfo.getNodeName())) {
					structure.setBatchHeader(structureInfo.getTextContent());
				}
				else if ("batchfooter".equals(structureInfo.getNodeName())) {
					structure.setBatchFooter(structureInfo.getTextContent());
				}
				else if ("title".equals(structureInfo.getNodeName())) {
					structure.setTitle(structureInfo.getTextContent());
				}
				else if ("content".equals(structureInfo.getNodeName())) {
					structure.setContent(structureInfo.getTextContent());
				}
				else
					error.err(12);
			}
			readFile.setStructure(structure);
			
			//set file table - done
			Table table = new Table();
			Node fileTable = innerFile.item(setNum(3));
			//System.out.println(fileTable.getNodeName());
			NodeList tableList = fileTable.getChildNodes();
			for (int j = 1; j <= getNum(tableList.getLength()); j++) {
				Node tableInfo = tableList.item(setNum(j));
				if ("hastitle".equals(tableInfo.getNodeName())) {
					if ("1".equals(tableInfo.getTextContent()))
						table.setHasTitle(true);
					else 
						table.setHasTitle(false);
				}
				else if ("filename".equals(tableInfo.getNodeName())) {
					table.setFileName(tableInfo.getTextContent());
				}
				else if ("filetype".equals(tableInfo.getNodeName())) {
					table.setFileType(tableInfo.getTextContent());
				}
				else if ("uploadtime".equals(tableInfo.getNodeName())) {
					table.setUpdateTime(tableInfo.getTextContent());
				}
				else if ("totallength".equals(tableInfo.getNodeName())) {
					if ("".equals(tableInfo.getTextContent())) 
						table.setTotalLength(0);
					else 
						table.setTotalLength(Integer.parseInt(tableInfo.getTextContent()));
				}
				//title - set column names in the table
				else if ("title".equals(tableInfo.getNodeName())) {
					NodeList titleList = tableInfo.getChildNodes();
					for (int k = 1; k <= getNum(titleList.getLength()); k++) {
						Node column = titleList.item(setNum(k));
						String testColumn = column.getNodeName();
						//System.out.println(testColumn.charAt(0));
						if ('c' == testColumn.charAt(0)) {
							table.addColumn(column.getTextContent());
						}
						else
							error.err(131);
					}
					table.addTitle();
					//System.out.println(table.getTitleList().size());
				}
				else
					error.err(13);
				//System.out.println(table.getHasTitle());
			}
			readFile.setTable(table);;
			
			//set file validation - done
			Validation validation = new Validation();
			Node fileValidation = innerFile.item(setNum(4));
			NodeList validationColumn = fileValidation.getChildNodes();
			//System.out.println(fileValidation.getNodeName());
			//set columns
			for (int j = 1; j <= getNum(validationColumn.getLength()); j++) {
				Node fileColumn = validationColumn.item(setNum(j));
				ColumnVal column = new ColumnVal();
				
				//System.out.println(fileColumn.getNodeName());
				
				if ("true".equals(fileColumn.getAttributes().getNamedItem("required").getTextContent()))
					column.setRequired(true);
				else if ("false".equals(fileColumn.getAttributes().getNamedItem("required").getTextContent()))
					column.setRequired(false);
				else
					error.err(14);
				
				String type = fileColumn.getAttributes().getNamedItem("type").getTextContent();
				column.setType(type);
				if ("number".equals(type)) {
					int upper = Integer.parseInt(fileColumn.getChildNodes().item(1).getTextContent());
					int lower = Integer.parseInt(fileColumn.getChildNodes().item(3).getTextContent());
					column.setUpper(upper);
					column.setLower(lower);
				}
				validation.addColumn(column);;
			}
			readFile.setValidation(validation);
			
			fileList.add(readFile);
		}
	}
	
	public ArrayList<FileSample> getFileList() {
		return fileList;
	}
	
	public ArrayList<String> getFileType() {
		ArrayList<String> typeList = new ArrayList<String>();
		for (int i = 0; i < fileList.size(); i++) {
			typeList.add(fileList.get(i).getFileType());
		}
		
		return typeList;
	}
	 
// those are private methods
	 
	private void setFilepath(String filepath) {
		this.filepath = filepath;
	}
		
	private void setDocumentBuilderFactory() {
		this.dbf = DocumentBuilderFactory.newInstance(); 
	}
	 
	 private void setDocumentBuilder() {
		 try {
			this.db = this.dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 
	 private void setFile() {
		 this.file = new File(this.filepath);
	 }
	 
	 private void setDoc(DocumentBuilder db) {
		 try {
			this.doc = db.parse(this.file);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 private void setRoot(Document doc) {
		 this.root = doc.getDocumentElement();
	 }
 
	 /*
	  * get the index number in dom using child index(start from 1)
	  */
	 private int setNum(int number) {
		 return number*2-1;
	 }
	 
	 /*
	  * get the child index using the index in dom(start from 1)
	  */
	 private int getNum(int number) {
		 return (number-1)/2;
	 }
	 
}