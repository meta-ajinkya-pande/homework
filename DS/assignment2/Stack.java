package assignment2;

import java.util.Scanner;

import assignment1.*;

public class Stack {
	
	private List<Character> stack; // this is stack which we have to maintain
	private int top = -1; // this is condition that stack is empty

	//constructor
	public Stack() {
		stack = new SingleLinkedList<Character>();
	}

	// It push the element into the stack
	public void push(char data) {
		top++;
		stack.add(data);
	}
	
	// It pop the element into the stack
	public char pop() {
		char data = stack.remove(top);
		top--;
		return data;
	}

	// It peek the element in stack top
	public char peek() {
		char data = stack.getElement(top);
		return data;
	}

	// this function convert the infix expression to postfix expression
	public String convertInfixToPostfix(String expression) {
		String output="";
		int length = expression.length();
		for (int i = 0; i < length; i++) {
			char data = expression.charAt(i);
			if (isOperator(data)) {
				if (top == -1)
					push(data);
				else {
					char previous = peek();
					if(precedence(previous) <= precedence(data) || data == '(') {
						push(data);
					}else{
						while(precedence(previous) > precedence(data) && !stack.isEmpty()){
							if(!(peek() == '('))
								output += pop();
							else{
								pop();
								break;
							}
						}
						if(!(data == ')'))
							push(data);
					}
				}
			}else{
				output += data;
			}
		}
		while(!stack.isEmpty()){
			output += pop();
		}
		return output;
	}

	private int precedence(char data) {
		if (data == '^'){
			return 3;
		}
		else if (data == '*' || data == '/') {
			return 2;
		} else if (data == '+' || data == '-') {
			return 1;
		} else {
			return 0;
		}
	}

	public boolean isOperator(char data) {
		if (data == '*' || data == '/' || data == '+' || data == '-'
				|| data == '^' || data == '(' || data ==')') {
			return true;
		}
		return false;
	}

	public static void main(String[] ar) {
		Stack stack = new Stack();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter The Expression");
		String expression = scan.nextLine();
		scan.close();
		String out = stack.convertInfixToPostfix(expression);
		System.out.println(out);
	}
}
