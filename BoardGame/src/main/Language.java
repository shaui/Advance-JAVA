package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import component.card.*;

public class Language {
	
	private BufferedReader br;
	private ArrayList<String[]> l_l = new ArrayList<>(),
			                    l_ef = new ArrayList<>(),
			                    l_ic = new ArrayList<>(),
			                    l_i = new ArrayList<>(),
			                    l_pp = new ArrayList<>();
	private Pattern name = Pattern.compile("Name:(\\S+)"),
					info = Pattern.compile("Info:(\\S+)"),
					num = Pattern.compile("Num:([0-9]{1,2}~?[0-9]{0,2})"),
					money = Pattern.compile("Money:([0-9]+)");
	
	public Language() {
		try {
			InputStreamReader isr = new InputStreamReader(getClass().getResourceAsStream("/lang/Constructure.txt"), "utf-8");
			br = new BufferedReader(isr);
			int type = 0;
			String[] tempS = null;
			Matcher m;
			while(br.ready()) {
				String line = br.readLine();
				switch(line) {
				case "地標":
					type = 1;
					continue;
				case "重要建築物":
					type = 2;
					continue;
				case "基礎設施":
					type = 3;
					continue;
				case "加工廠":
					type = 4;
					continue;
				case "娛樂設施":
					type = 5;
					continue;
				}
				if(type > 0) {
					m = name.matcher(line);
					if(m.find()) {
						tempS = new String[4];
						tempS[0] = m.group(1);
						continue;
					}
					m = info.matcher(line);
					if(m.find()) {
						tempS[1] = m.group(1);
						continue;
					}
					m = num.matcher(line);
					if(m.find()) {
						tempS[2] = m.group(1);
						continue;
					}
					m = money.matcher(line);
					if(m.find()) {
						tempS[3] = m.group(1);
						switch(type) {
						case 1:
							l_l.add(tempS);
							break;
						case 2:
							l_ic.add(tempS);
							break;
						case 3:
							l_i.add(tempS);
							break;
						case 4:
							l_pp.add(tempS);
							break;
						case 5:
							l_ef.add(tempS);
							break;
						}
						tempS = null;
						continue;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] getLanguage(Card type) {
		switch(type.getType()) {
		case Card.entertaining_facilities:
			return l_ef.get(Entertaining_Facilities.getNumber(type));
		case Card.important_constructure:
			return l_ic.get(Important_Constructure.getNumber(type));
		case Card.infrastructure:
			return l_i.get(Infrastructure.getNumber(type));
		case Card.processing_plant:
			return l_pp.get(Processing_Plant.getNumber(type));
		case Card.landmark:
			return l_l.get(Landmark.getNumber(type));
		}
		return null;
	}
}
