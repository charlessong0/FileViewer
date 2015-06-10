package dbutil;

import java.util.ArrayList;
import java.util.Iterator;

import objects.Structure;
import error.Error;

public class FileUtil {
	private FileReader fr;
	private String path = null;
	private Structure structure = null;
	public Error err;
	
	public FileUtil(String path) throws Exception {
		this.path = path;
		fr = new FileReader(this.path);
	}
	
	/*
	 * get the list of all batches
	 * allBatches: the list of bathes - batchList: the list of a batch - batch: the list of a single line in list
	 */
	public ArrayList<ArrayList<ArrayList<String>>> readInBatch() throws Exception {
		String readLine = null;
		int lineLength = 0;
		boolean inBatch = false;
		ArrayList<ArrayList<String>> batchList = new ArrayList<ArrayList<String>>();
		ArrayList<String> batch = new ArrayList<String>();
		ArrayList<ArrayList<ArrayList<String>>> allBatches = new ArrayList<ArrayList<ArrayList<String>>>();
		
		while(true) {
			readLine = fr.readLine();
			batch = fr.fromCSVLinetoArray(readLine);
			lineLength = batch.size();
			if (lineLength == 0)
				break;
			else {
				if (inBatch) {
					if(isBatchFooter(batch)) {
						batchList.add(batch);
						allBatches.add(batchList);
						inBatch = false;
						batchList = new ArrayList<ArrayList<String>>();
					}
					else {
						batchList.add(batch);
					}
				}
				else {
					if (isBatch(batch)) {
						batchList.add(batch);
						inBatch = true;
					}
					else
						continue;
				}
			}
		}
		return allBatches;
	}
	
	/*
	 * get the list of batches - batch headers in line
	 */
	public ArrayList<ArrayList<String>> getBatchNames(ArrayList<ArrayList<ArrayList<String>>> allBatches) {
		ArrayList<ArrayList<String>> batchNames = new ArrayList<ArrayList<String>>();
		Iterator<ArrayList<ArrayList<String>>> batchIt = allBatches.iterator();
		while (batchIt.hasNext()) {
			batchNames.add(batchIt.next().get(0));
		}
		return batchNames;
	}
	
	/*
	 * get a exact batch
	 */
	public ArrayList<ArrayList<String>> getABatch(ArrayList<ArrayList<ArrayList<String>>> allBatches, int index) {
		return allBatches.get(index);
	}
	
	/*
	 * get the length of a batch, regardless of header and footer
	 */
	public int getBatchLength(ArrayList<ArrayList<String>> batch) {
		return batch.size()-2;
	}
	
	/*
	 * get the index of pages
	 */
	public int getPageIndex(int batchLength, int lines) {
		return batchLength/lines;
	}
	
	/*
	 * get 200 lines of batch, if there are less, call 100 method
	 * the first line would be the batch header and the last would be the footer
	 */
	public ArrayList<ArrayList<String>> get200Batch(ArrayList<ArrayList<ArrayList<String>>> allBatches, int batchNumber, int pageIndex) {
		ArrayList<ArrayList<String>> get200 = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> batch = allBatches.get(batchNumber);
		int length = getBatchLength(batch);
		ArrayList<String> header = batch.get(0);
		ArrayList<String> footer = batch.get(length-1);
		if (length < 100) {
			return get100Batch(allBatches, batchNumber, 1);
		}
		else {
			if ((pageIndex-1)*200 > length) {
				err.err(31);
			}
			if (length <= pageIndex*200) {
				get200.add(header);
				for (int i = (pageIndex-1)*200; i <= length; i++) {
					get200.add(batch.get(i));
				}
				get200.add(footer);
			}
			else {
				get200.add(header);
				for (int i = (pageIndex-1)*200 + 1; i <= pageIndex*200; i++) {
					get200.add(batch.get(i));
				}
				get200.add(footer);
			}
			return get200;
		}
	}
	
	/*
	 * get 100 lines of batch, if there are less, call 100 method
	 * the first line would be the batch header and the last would be the footer
	 */
	public ArrayList<ArrayList<String>> get100Batch(ArrayList<ArrayList<ArrayList<String>>> allBatches, int batchNumber, int pageIndex) {
		ArrayList<ArrayList<String>> get100 = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> batch = allBatches.get(batchNumber);
		int length = getBatchLength(batch);
		ArrayList<String> header = batch.get(0);
		ArrayList<String> footer = batch.get(length-1);
		if (length < 50) {
			return get50Batch(allBatches, batchNumber, 1);
		}
		else {
			if ((pageIndex-1)*100 > length) {
				err.err(31);
			}
			else {
				if (length <= pageIndex*100) {
					get100.add(header);
					for (int i = (pageIndex-1)*100; i <= length; i++) {
						get100.add(batch.get(i));
					}
					get100.add(footer);
				}
				else {
					get100.add(header);
					for (int i = (pageIndex-1)*100 + 1; i <= pageIndex*100; i++) {
						get100.add(batch.get(i));
					}
					get100.add(footer);
				}
			}
			return get100;
		}
	}
	
	/*
	 * get 50 lines of batch, if there are less, call 100 method
	 * the first line would be the batch header and the last would be the footer
	 */
	public ArrayList<ArrayList<String>> get50Batch(ArrayList<ArrayList<ArrayList<String>>> allBatches, int batchNumber, int pageIndex) {
		ArrayList<ArrayList<String>> get50 = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> batch = allBatches.get(batchNumber);
		int length = getBatchLength(batch);
		ArrayList<String> header = batch.get(0);
		ArrayList<String> footer = batch.get(length-1);

		if ((pageIndex-1)*50 > length) {
			err.err(31);
		}
		if (length <= pageIndex*50) {
			get50.add(header);
			for (int i = (pageIndex-1)*50; i <= length; i++) {
				get50.add(batch.get(i));
			}
			get50.add(footer);
		}
		else {
			get50.add(header);
			for (int i = (pageIndex-1)*50 + 1; i <= pageIndex*50; i++) {
				get50.add(batch.get(i));
			}
			get50.add(footer);
		}
		System.out.println(get50.get(2));
		return get50;
	}
	
	//getters and setters

	public String getPath() {
		return path;
	}
	
	public FileReader getFR() {
		return fr;
	}
	
	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	
	//examinations
	public boolean isBatch(ArrayList<String> batch) {
		boolean isBatch = false;
		if (batch.get(0).equals(structure.getBatchHeader()))
			isBatch = true;		
		return isBatch;
	}
	
	public boolean isBatchFooter(ArrayList<String> batch) {
		boolean isFooter = false;
		if (batch.get(0).equals(structure.getBatchFooter()))
			isFooter = true;
		return isFooter;
	}
}
