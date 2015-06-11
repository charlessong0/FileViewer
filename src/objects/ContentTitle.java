package objects;

import java.util.ArrayList;

public class ContentTitle {
	private ArrayList<Integer> startList = new ArrayList<Integer>();
	private ArrayList<Integer> lengthList = new ArrayList<Integer>();
	private ArrayList<Integer> endList = new ArrayList<Integer>();
	
	public ArrayList<Integer> getStartList() {
		return startList;
	}
	
	public ArrayList<Integer> getEndList() {
		return endList;
	}
	
	public ArrayList<Integer> getLengthList() {
		return lengthList;
	}
	
	public void addStart(int start) {
		startList.add(start);
	}
	
	public void addLength(int length) {
		lengthList.add(length);
	}
	
	public void addEnd(int end) {
		endList.add(end);
	}
}
