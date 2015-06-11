package objects;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private boolean hasTitle = false;
	private boolean hasTailer = false;
	private String fileName = null;
	private String fileType = null;
	private String updateTime = null;
	private ArrayList<ArrayList<String>> titleList = new ArrayList<ArrayList<String>>();
	private ArrayList<String> title = new ArrayList<String>();
	private int totalLength = 0;
	
	public HeaderTitle header = new HeaderTitle();
	public ContentTitle content = new ContentTitle();
	public TailerTitle tailer = new TailerTitle();

	public ArrayList<ArrayList<String>> getTitleList() {
		return titleList;
	}
	
	public boolean getHasTailer() {
		return hasTailer;
	}
	
	public boolean getHasTitle() {
		return hasTitle;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getFileType() {
		return fileType;
	}
	
	public String getUpdateTime() {
		return updateTime;
	}
	
	public int getTotalLength() {
		return totalLength;
	}
	
	public void setHasTitle(boolean hasTitle) {
		this.hasTitle = hasTitle;
	}
	
	public void setHasTailer(boolean hasTailer) {
		this.hasTailer = hasTailer;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	public void setTotalLength(int length) {
		this.totalLength = length;
	}
	
	//methods for title
	public void addTitle() {
		titleList.add(title);
		title = new ArrayList<String>();
	}
	
	public void addColumn(String column) {
		title.add(column);
	}
	

}
