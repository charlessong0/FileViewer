package objects;

public class Structure {
	private String fileHeader = null;
	private String fileFooter = null;
	private String batchHeader = null;
	private String batchFooter = null;
	private String title = null;
	private String content = null;
	
	public String getFileHeader() {
		return fileHeader;
	}
	
	public String getFileFooter() {
		return fileFooter;
	}
	
	public String getBatchHeader() {
		return batchHeader;
	}
	
	public String getBatchFooter() {
		return batchFooter;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setFileHeader(String fileHeader) {
		this.fileHeader = fileHeader;
	}
	
	public void setFileFooter(String fileFooter) {
		this.fileFooter = fileFooter;
	}
	
	public void setBatchHeader(String batchHeader) {
		this.batchHeader = batchHeader;
	}
	
	public void setBatchFooter(String batchFooter) {
		this.batchFooter = batchFooter;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

}
