package stream_system;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class InvoiceMS {
	private Scanner s ;
	private String input;
	private String range;
	private int min;
	private int max;
	private Invoice[] invoices = {
			new Invoice(83, "Electric sander", 7, 57.98),
			new Invoice(24, "Power saw", 18, 99.99),
			new Invoice(7, "Sledge hammer", 11, 21.50),
			new Invoice(77, "Hammer", 76, 11.99),
			new Invoice(39, "Lawn mower", 3, 79.50),
			new Invoice(68, "Screwdriver", 106, 6.99),
			new Invoice(56, "Jig saw", 21, 11.00),
			new Invoice(3, "Wrench", 34, 7.50),
			new Invoice(45, "Wrench", 13, 7.50),
			new Invoice(22, "Hammer", 47, 11.99)
			};
	
	public InvoiceMS() {
		System.out.println("Welcome to invoice management system.");
		System.out.println("Functions: Report/Select/Order-Id/Order-Name");
		System.out.print("Choice (-1 to exit): ");
		s = new Scanner(System.in);
		input = s.nextLine();
		while(!input.equalsIgnoreCase("-1")) {
			if(input.equalsIgnoreCase("Report")) {
				System.out.println();
				System.out.println("Invoices group by description:");
				report();
				System.out.println("\n" + "Functions: Report/Select/Order-Id/Order-Name");
				System.out.print("Choice (-1 to exit): ");
				input = s.nextLine();
			}
			else if(input.equalsIgnoreCase("Select")) {
				System.out.print("Input the range to show (min,man): ");
				range = s.nextLine();
				String[] spRange = range.split(",");
				min = Integer.valueOf(spRange[0]);
				max = Integer.valueOf(spRange[1]);
				System.out.println("\n" + "Invoices mapped to description and invoice amount for invoice in the range " + spRange[0] + "-" + spRange[1] +":");
				select();
				System.out.println("\n" + "Functions: Report/Select/Order-Id/Order-Name");
				System.out.print("Choice (-1 to exit): ");
				input = s.nextLine();
			}
			else if(input.equalsIgnoreCase("Order-Id")) {
				System.out.println();
				System.out.println("Invoices group by description:");
				orderById();
				System.out.println("\n" + "Functions: Report/Select/Order-Id/Order-Name");
				System.out.print("Choice (-1 to exit): ");
				input = s.nextLine();
			}
			else if(input.equalsIgnoreCase("Order-Name")) {
				System.out.println();
				System.out.println("Invoices group by description:");
				orderByName();
				System.out.println("\n" + "Functions: Report/Select/Order-Id/Order-Name");
				System.out.print("Choice (-1 to exit): ");
				input = s.nextLine();
			}
			while(!input.equalsIgnoreCase("Report") && !input.equalsIgnoreCase("Select") && !input.equalsIgnoreCase("-1") && !input.equalsIgnoreCase("Order-Id") && !input.equalsIgnoreCase("Order-Name")) {
				System.out.print("Wrong input. Enter again: ");
				input = s.nextLine();
			}
		}
	}
	
	private void report() {
		Arrays.stream(invoices)
		.sorted(Comparator.comparing(Invoice::getTotalPrice))
		.forEach(x -> System.out.printf("%s%-17s%s%11.2f\n","Description: ", x.getPartDescription(), "Invoice amount:", x.getPrice()*x.getQuantity()));
	}
	
	private void select() {
		Arrays.stream(invoices)
		.filter(x -> x.getPrice()*x.getQuantity() >= min && x.getPrice()*x.getQuantity() <= max)
		.sorted(new InvoiceComparator())
		.forEach(x -> System.out.printf("%s%-17s%s%11.2f\n","Description: ", x.getPartDescription(), "Invoice amount:", x.getPrice()*x.getQuantity()));
	}
	
	private void orderById() {
		Arrays.stream(invoices)
		.sorted(Comparator.comparing(Invoice::getPartNumber))
		.forEach(x -> System.out.println(x.toString()));
	}
	
	private void orderByName() {
		Arrays.stream(invoices)
		.sorted(Comparator.comparing(Invoice::getPartDescription))
		.forEach(x -> System.out.printf("%s%-17s%s%11.2f\n","Description: ", x.getPartDescription(), "Invoice amount:", x.getPrice()*x.getQuantity()));
	}
}
