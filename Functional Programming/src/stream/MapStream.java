package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MapStream {

	public static void main(String[] args) {
		Employee[] employees = {
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"),
				new Employee("Matthew", "Indigo", 3587.5, "Sales"),
				new Employee("James", "Indigo", 4700.77, "Marketing"),
				new Employee("Luke", "Indigo", 6200, "IT"),
				new Employee("Jason", "Blue", 3200, "Sales"),
				new Employee("Wendy", "Brown", 4236.4, "Marketing")};

		List<Employee> list = Arrays.asList(employees);

		Map<String, List<Employee>> groupedByDepartment =
				list.stream()				//����Map				//Key:Employee::getDepartment //Value�N�OEmployee��List (�]�����ۦPKey���|��_�Ӧ���List)
				.collect(Collectors.groupingBy(Employee::getDepartment));

		//map have a method : forEach() //List also have the method
		groupedByDepartment.forEach(
				(department, employeesInDepartment) -> 
				{
					System.out.println(department);
					employeesInDepartment.forEach(
							employee -> System.out.printf("   %s%n", employee));
				}
				);
		
		Map<String, Long> employeeCountByDepartment =
				list.stream()							//Key is Employee::getDepartment //Value is Collectors.counting()
				.collect(Collectors.groupingBy(Employee::getDepartment, 
						TreeMap::new, Collectors.counting())); //TreeMap::new --> set the map to TreeMap to order

		employeeCountByDepartment.forEach(
				(department, count) -> System.out.printf(
						"%s has %d employee(s)%n", department, count));
		/*
		wordCounts.entrySet() //Because map cannot direct use stream()
        .stream()
        .collect(
           Collectors.groupingBy(entry -> entry.getKey().charAt(0), 
              TreeMap::new, Collectors.toList())) //Key�O�Ĥ@�Ӧr�� �AValue�O�ۦP�r����r��List //Value�i�H��Collectors.toList()�Ӱ��X�@��value�� List
        .forEach((letter, wordList) -> 
           { 
              System.out.printf("%n%C%n", letter); //%C�ܦ��j�g
              //wordList�O�o��Map����Value --> �ۦP�r����r��List
              wordList.stream().forEach(word -> System.out.printf(
                 "%13s: %d%n", word.getKey(), word.getValue())); //�]�����ӨC�ӳ�r������n���X�{�h�֦��F�A�ҥH��word.getValue()
              													  //getKey()�BgetValue()���Ojava.util.Map.Entry�̭���method
           });
			*/
	}

}
