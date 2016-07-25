package assignment1;


public abstract class Menu implements ActionMenu {
	public abstract void setMenuName(String name);
	public abstract String getMenuName();
	public abstract String getParent();
	public abstract void setParent(String parentName);
}