package assignment8;

public class Main {

	public static void main(String[] ar) {
		TreeSort<String> bt = new TreeSort<String>();

		bt.addValue("20");
		bt.addValue("15");
		bt.addValue("29");
		bt.addValue("13");
		bt.addValue("16");
		bt.addValue("21");
		bt.addValue("33");
		
		System.out.println(bt.sort());
	}
}