package stream_system;

import java.util.Comparator;

public class ComparatorById implements Comparator<Invoice>{

	@Override
	public int compare(Invoice o1, Invoice o2) {
		return o1.getPartNumber() - o2.getPartNumber();
	}

}
