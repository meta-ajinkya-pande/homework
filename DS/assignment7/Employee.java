package assignment7;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {
	
	private int empId; // employee id 
	private String name; // employee name
	private String address; // employee address

	/**
	 * Constructor to set empid, name, address
	 * @param empId is employee id
	 * @param name is employee name
	 * @param address is the employee address
	 */
	public Employee(int empId, String name, String address) {
		setAddress(address);
		setName(name);
		setEmpId(empId);
	}

	/**
	 * To set the emplyoee
	 * @param empId
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * To get the employee Id
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param name set the employee name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return name of the employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param address set the address of employee
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return address of the employee
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * To convert object to string
	 */
	@Override
	public String toString() {
		String string = "\n" + getEmpId() + " " + getName() + " "
				+ getAddress() + "\n";
		return string;
	}

	/**
	 * To set uniqueness as empId
	 */
	@Override
	public int hashCode() {
		Integer i = empId;
		return i.hashCode();
	}

	/**
	 * For equal objects
	 */
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj == null || obj.getClass() != getClass()) {
			result = false;
		} else {
			Employee emp = (Employee) obj;
			if (this.empId == emp.getEmpId()) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * Compare by empId
	 */
	@Override
	public int compareTo(Employee o) {
		return this.getEmpId() - o.getEmpId();
	}
}

/**
 * Inner Class for sorting according to name
 */
class EmployeeNameSorted implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}
}