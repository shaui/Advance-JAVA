package stream_system;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Invoice>{

	@Override
	public int compare(Invoice o1, Invoice o2) {
		return o1.getPartDescription().compareTo(o2.getPartDescription());
	}

}
