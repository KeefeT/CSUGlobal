//Algorithm convertToPostfix(infix)
//// Converts an infix expression to an equivalent postfix expression.
//operatorStack = a new empty stack
//postfix = a new empty string
//while (infix has characters left to parse)
//{
//nextCharacter = next nonblank character of infix
//switch (nextCharacter)
//{
//case variable:
//Append nextCharacter to postfix
//break
//case '^' :
//operatorStack.push(nextCharacter)
//break
//case '+' : case '-' : case '*' : case '/' :
//while (!operatorStack.isEmpty() and
//precedence of nextCharacter <= precedence of operatorStack.peek())
//{
//Append operatorStack.peek() to postfix
//operatorStack.pop()
//}
//operatorStack.push(nextCharacter)
//break
//case '( ' :
//operatorStack.push(nextCharacter)
//break
//case ')' : // Stack is not empty if infix expression is valid
//topOperator = operatorStack.pop()
//while (topOperator != '(')
//{
//Append topOperator to postfix
//topOperator = operatorStack.pop()
//}
//break
//default: break // Ignore unexpected characters
//}
//}
//while (!operatorStack.isEmpty())
//{
//topOperator = operatorStack.pop()
//Append topOperator to postfix
//}
//return postfix

import java.util.Stack;

public class PostfixConverter {
	
	public static String convertToPostfix(String infix) {
		Stack<Character> stack = new Stack<Character>();
		String postfix = "";
		for (char character : infix.toCharArray()) {
			switch (character) {
				case '^':
					stack.push(character);
					break;
				case '+':
				case '-':
				case '*':
				case '/':
					//intentional fallthrough
					while (!stack.isEmpty() && precedence(character) <= precedence(stack.peek())) {
						postfix += stack.pop();
					}
					stack.push(character);
					break;
				case '(':
					stack.push(character);
					break;
				case ')':
					char topOp = stack.pop();
					while (topOp != '(') {
						postfix += topOp;
						topOp = stack.pop();
					}
					break;
				default: 
					if (Character.isLetter(character)) {
						postfix += character;
					} 
					break;
			}
		}
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}
		return postfix;
	}
	
	public static int precedence(char ch) {
		switch (ch) {
			case '^':
				return 2;
			case '+':
			case '-':
			case '*':
			case '/':
				//intentional fallthrough
				return 1;
			default:
				return -1;
		}
	}
	
	public static void testConverter(String infix, String expected) {
		System.out.println("Infix notation: " + infix);
		String result;
		try {
			result = convertToPostfix(infix);
			System.out.println("Expected result: " + expected);
			System.out.println("Actual result: " + result);
			System.out.println("Is result correct?: " + expected.equals(result) + "\n");
		} catch (Exception e) {
			System.out.println("Error parsing infix notation: " + e + "\n");
		}
	}
	
	public static void main(String args[]) {	
		testConverter("a/b*(c+(d-e))", "ab/cde-+*");
		testConverter("a+b", "ab+");
		testConverter("(((a-b)))", "ab-");
		
		System.out.println("Next test should throw error due to unbalanced infix....");
		testConverter("(a*b))", "code shouldn't even check this");
		testConverter("a^b*c", "ab^c*");
		testConverter("a*c^b", "acb^*");
	}

}
