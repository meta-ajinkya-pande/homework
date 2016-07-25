package assignment1;

public class Validation {
	
	public boolean isInputValid(String value, String start, String end) {
		int s = start.codePointAt(0);
		int e = end.codePointAt(0);
		int v = value.codePointAt(0);
		if (value.length() == 1 || v >= s && v <= e) {
			return true;
		}
		return false;
	}
}
