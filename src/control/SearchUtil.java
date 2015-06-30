package control;

import java.util.ArrayList;
import java.util.Iterator;


public class SearchUtil {
	/**
	 * get the line contains token "search" in column index
	 * @param serach
	 * @param index
	 * @return
	 */
	public ArrayList<ArrayList<String>> searchBatch(String serach, int index) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> temp = new ArrayList<String>();
		Iterator<ArrayList<String>> it = result.iterator();
		
		while(it.hasNext()) {
			temp = it.next();
			if (temp.get(index).equals(serach))
				result.add(temp);
		}
		
		return result;
	}

}
