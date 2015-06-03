package objects;

public class ColumnVal {
	private boolean required = false;
	private String type = null;
	private int upper = 0;
	private int lower = 0;
	
	public boolean getRequired() {
		return required;
	}
	
	public String getType() {
		return type;
	}
	
	public int getUpper() {
		return upper;
	}
	
	public int getLower() {
		return lower;
	}
	
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public void setUpper(int upper) {
		this.upper = upper;
	}
	
	public void setLower(int lower) {
		this.lower = lower;
	}
}
