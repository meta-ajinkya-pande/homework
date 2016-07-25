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
	private List<String> menulist = new ArrayList<String>();
	private String menuname;

	@Override
	public void actionPerformed(Scanner sc) {
		// TODO Auto-generated method stub
		int no_items = 0;
		try{
			System.out.println("Enter The no of items");
			no_items = sc.nextInt();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sc.nextLine();
		}
		for (int i = 0; i < no_items; i++) {
			System.out.println("Enter item");
			String name = sc.nextLine();
			System.out.println("It is a Composite Menu ?");
			String ans = sc.nextLine();
			if(ans.equalsIgnoreCase("Y")){
				CompositeMenu menu = new CompositeMenu();
				menu.setMenuName(name);
				menu.setParent(this.getMenuName());
				menu.actionPerformed(sc);
			}
			menulist.add(name);
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

	@Override
	public void addList(String[] list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.length; i++) {
			menulist.add(list[i]);
		}
	}

	@Override
	public List<String> getList() {
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
