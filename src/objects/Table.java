package objects;

public class Table {
	private boolean hasTitle = false;
	private String fileName = null;
	private String fileType = null;
	private String updateTime = null;
	
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
	
	public void setHasTitle(boolean hasTitle) {
		this.hasTitle = hasTitle;
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

}
