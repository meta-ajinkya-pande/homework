package assignment7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 * This is main class for the employee class 
 * It do natural sorting by implementing the tree Set
 * It sort data according to the name by Comparator class implementation
 * Unique id is also maintain by tree Set    
 * @author Ajinkya pande
 *
 */
public class EmployeeCollection {
	
	public static void main(String[] data) {
		/* 	
		 * The employee treeSet which contains 
		 * unique id of employee
		 * employee name and address
		 */
		Set<Employee> employees = new TreeSet<Employee>();
		employees.add(new Employee(85, "c_emp1", "address 1"));
		employees.add(new Employee(42, "fa_emp3", "address 3"));
		employees.add(new Employee(41, "g_emp2", "address 2"));
		employees.add(new Employee(122, "a_emp12", "address 12"));
		employees.add(new Employee(17, "p_emp10", "address 10"));
		// Same empId = 17 for different data 
		employees.add(new Employee(17, "c_emp1", "address 1"));
		employees.add(new Employee(2, "fa_emp3", "address 3"));
		employees.add(new Employee(4, "g_emp2", "address 2"));
		employees.add(new Employee(1, "a_emp12", "address 12"));
		employees.add(new Employee(7, "p_emp10", "address 10"));

		// Natural Order
		System.out.println("Natural Order");
		System.out.println(employees);

		List<Employee> empList = new ArrayList<Employee>(employees);
		System.out.println("-----------------------------------------------");

		//Order by name
		System.out.println("Sorted by name");
		Collections.sort(empList, new EmployeeNameSorted());
		System.out.println(empList);
	}
}
