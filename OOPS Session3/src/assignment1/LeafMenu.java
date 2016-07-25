package assignment1;


public class LeafMenu extends Menu {
	
	private String parent;
	private String menuname;
	
	@Override
	public void actionPerformed(){
		System.out.println(parent + "->" + menuname);
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
}
