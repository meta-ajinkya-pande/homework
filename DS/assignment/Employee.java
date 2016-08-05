package assignment7;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {
	private int empId;
	private String name;
	private String address;

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
	 * Getter empId
	 * @return
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * Setter name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter name
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter Address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Getter Address
	 * @return
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