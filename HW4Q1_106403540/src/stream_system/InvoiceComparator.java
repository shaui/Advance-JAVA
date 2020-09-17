package stream_system;

import java.util.Comparator;


public class InvoiceComparator implements Comparator<Invoice>{

	@Override
	public int compare(Invoice i1, Invoice i2) {
		return (int) (i1.getPrice()*i1.getQuantity() - i2.getPrice()*i2.getQuantity());
	}

}
