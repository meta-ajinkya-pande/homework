package assignment1;

import java.util.List;

public abstract class Menu implements ActionMenu {
	public abstract void setMenuName(String name);
	public abstract String getMenuName();
	public abstract String getParent();
	public abstract void setParent(String parentName);
	public abstract void addList(String[] list);
	public abstract List<String> getList();
}