/**
 * 
 */
package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ajinkya Pande
 *
 */
public class CompositeMenu extends Menu {
	private String parent;
	private List<Menu> menulist = new ArrayList<Menu>();
	private String menuname;

	@Override
	public void actionPerformed() {
		// TODO Auto-generated method stub
		System.out.println(parent);
		System.out.println("");
		int i = 1;
		for (Menu menu : menulist) {
			System.out.println(i + " : " + menu.getMenuName());
			i++;
		}
	}

	public void printList(int index,Scanner sc) {
		System.out.println(parent);
		menulist.get(index).actionPerformed();
		System.out.println("Enter your Choice");
		int choice = sc.nextInt();
		sc.nextLine();
		printList(choice, sc);
	}

	public void generateList(Scanner sc) {
		int no_items = 0;
		try {
			System.out.println("Enter The no of items for "+getMenuName()+" menu");
			no_items = sc.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.nextLine();
		}
		for (int i = 0; i < no_items; i++) {
			System.out.println("Enter item for "+ getMenuName() + " menu");
			String name = sc.nextLine();
			System.out.println("It is a Composite Menu ?");
			String ans = sc.nextLine();
			if (ans.equalsIgnoreCase("Y")) {
				CompositeMenu menu = new CompositeMenu();
				menu.setMenuName(name);
				menu.setParent(this.getMenuName());
				menu.generateList(sc);
				menulist.add(menu);
			} else {
				LeafMenu menu = new LeafMenu();
				menu.setMenuName(name);
				menu.setParent(this.menuname);
				menulist.add(menu);
			}
		}
	}

	@Override
	public String getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public void setParent(String parentName) {
		// TODO Auto-generated method stub
		this.parent = parentName;
	}

	public void addList(Menu menu) {
		// TODO Auto-generated method stub
		menulist.add(menu);
	}

	public List<Menu> getList() {
		// TODO Auto-generated method stub
		return menulist;
	}

	@Override
	public void setMenuName(String name) {
		// TODO Auto-generated method stub
		this.menuname = name;
	}

	@Override
	public String getMenuName() {
		// TODO Auto-generated method stub
		return menuname;
	}
}
