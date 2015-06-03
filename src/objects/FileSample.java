package objects;

public class FileSample {
	private String fileType = null;
	private Structure structure = null;
	private Table table = null;
	private Validation validation = null;
	
	public String getFileType() {
		return fileType;
	}
	
	public Structure getStructure() {
		return structure;
	}
	
	public Table getTable() {
		return table;
	}
	
	public Validation getValidation() {
		return validation;
	}
	
	public void setFileType(String filetype) {
		this.fileType = filetype;
	}
	
	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	
	public void setTable(Table table) {
		this.table = table;
	}
	
	public void setValidation(Validation validation) {
		this.validation = validation;
	}
}
