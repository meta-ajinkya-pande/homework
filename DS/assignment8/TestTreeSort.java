package assignment8;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTreeSort {
	
	TreeSort<Integer> treeSort;
	@Before
	public void setUp() throws Exception {
		treeSort = new TreeSort<Integer>();
	}

	@Test
	public void test() {
		treeSort.addValue(20);
		treeSort.addValue(15);
		treeSort.addValue(29);
		treeSort.addValue(13);
		treeSort.addValue(16);
		treeSort.addValue(21);
		treeSort.addValue(33);
		
		List<Integer> expectedList = new ArrayList<Integer>();
		expectedList.add(13);
		expectedList.add(15);
		expectedList.add(16);
		expectedList.add(20);
		expectedList.add(21);
		expectedList.add(29);
		expectedList.add(33);
		
		assertEquals(expectedList, treeSort.sort());
		
	}

}
