package assignment2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	Stack stack;
	@Before
	public void setUp() throws Exception {
		stack = new Stack();
	}

	@Test
	public void testInfixtoPostfix() {
		assertEquals("ABC-+", stack.convertInfixToPostfix("A+(B-C)"));
	}
	
	@Test
	public void testPop(){
		stack.push('A');
		assertEquals('A' , stack.pop());
	}
	
	@Test
	public void testPeek(){
		stack.push('A');
		stack.push('B');
		assertEquals('B', stack.peek());
	}
}
