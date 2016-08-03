package assignment4;

public class Jobs implements Comparable<Jobs> {

	private String name;
	private int priority;

	private final String CHAIR = "chairman papers";
	private final String PROFESSORS = "professor papers";
	private final String GRADUATES = "graduate papers";
	private final String UNDERGRADUATES = "undergraduate papers";
	
	private final int CHAIRPRIORITY = 4;
	private final int PROFESSORSPRIORITY = 3;
	private final int GRADUATESPRIORITY = 2;
	private final int UNDERGRADUATESPRIORITY = 1;
	
	@Override
	public int compareTo(Jobs o) {
		if(this.getPriority() > o.getPriority()){
			return 1;
		}else if(this.getPriority() < o.getPriority()){
			return -1;
		}else{
			return 0;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priorityName) {
		if(priorityName == CHAIRPRIORITY){
			priority = CHAIRPRIORITY;
			this.setName(CHAIR);
		}else if(priorityName == PROFESSORSPRIORITY){
			priority = PROFESSORSPRIORITY;
			this.setName(PROFESSORS);
		}else if(priorityName == GRADUATESPRIORITY){
			priority = GRADUATESPRIORITY;
			this.setName(GRADUATES);
		}else if(priorityName == UNDERGRADUATESPRIORITY){
			priority = UNDERGRADUATESPRIORITY;
			this.setName(UNDERGRADUATES);
		}
	}

}
