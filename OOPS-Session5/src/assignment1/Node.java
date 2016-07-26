package assignment1;

import java.util.ArrayList;

public class Node {
	private ArrayList<Connection> friends;
	private String label;
	
	public Node(String label){
		this.label = label;
		this.friends = new ArrayList<Connection>(); 
	}
	
	public void addFriends(Connection connection){
		if(this.friends.contains(connection)){
			return;
		}
		this.friends.add(connection);
	}
	
	public boolean ContainsFriends(Connection connection){
		return friends.contains(connection);
	}
	
	public Connection getConnection(int index){
		return friends.get(index);
	}
	
	public Connection removefriend(int index){
		return this.friends.remove(index);
	}
	
	public int countFriends(){
		return this.friends.size();
	}
	
	public int hashCode(){
		return this.label.hashCode();
	}
	
	public boolean equals(Object other){
		if(!(other instanceof Node)){
			return false;
		}
		return this.label.equals((Node)other);
	}
	
	public ArrayList<Connection> getFriends(){
		return new ArrayList<Connection>(this.friends);
	}
}
