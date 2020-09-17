package day2_2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Management {

	public HashMap map_work;
	
	public Management() {
		map_work = new HashMap();
	}
	
	public void add_worker(String id, Work w) {
		map_work.put(id, w);
	}
	
	
	public double afterTax(String id) {
		
		return ((Work) map_work.get(id)).monthPay() - ((Work) map_work.get(id)).monthPay()*0.15;
	}
	
	public double total_month_sal() {
		double total = 0;
		
		Set<String> s = map_work.keySet();
		String[] key = s.toArray(new String[0]);
		for(int i=0; i<key.length; i++) {
			total += ((Work) map_work.get(key[i])).monthPay();
		}
		
		/*
		Work[] works = (Work[]) map_work.values().toArray(new Work[0]);
		for(Work w : works) {
			total += w.monthPay();
		}
		*/
		
		/*
		Iterator i = map_work.values().iterator();
		while(i.hasNext()) {
			total += ((Work)i.next()).monthPay();
		}
		*/
		return total;
	}
	
	public void check() throws Exception {
		if(total_month_sal() > 50000) {
			throw new Exception();
		}
	}
}
