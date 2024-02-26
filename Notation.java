package Pj2;

/**
 * 
 * @author Ashton Kabou
 * 
 * 
 *
 */
public class Notation extends Object {
	public Notation() {
		
	}
	
	
	
	/** 
     * Determines the precedence of an operator.
     * 
     * @param c The operator
     * @return 1 if the operator is + or -, 2 if the operator is * or /, 0 otherwise
     */
	private static int precedence(char c) {
		if(c=='+' || c=='-')
			return 1;
		else if(c=='/' || c=='*')
			return 2;
		return 0;
	}
	
	
	
	
	/**
	 * Converts an infix notation string to a postfix notation string.
	 * 
	 * @param infix The infix notation string
	 * @return The corresponding postfix notation string
	 * @throws InvalidNotationFormatException if the infix notation is invalid
	 */
	public static String convertInfixToPostfix(String infix) {
	    MyStack<Character> Pstack = new MyStack<Character>(infix.length());
	    for (int i = 0; i < infix.length(); i++) {
	        char currentChar = infix.charAt(i);
	        switch (currentChar) {
	            case '(':
	                Pstack.push(currentChar);
	                break;
	            case ')':
	                if (Pstack.isEmpty()) {
	                    throw new InvalidNotationFormatException();
	                } else {
	                    Pstack.pop();
	                }
	                break;
	        }
	    }
	    
	    if (!Pstack.isEmpty()) {
	        throw new InvalidNotationFormatException();
	    }
	    
	    MyQueue<Character> queue = new MyQueue<Character>(infix.length());
	    MyStack<Character> stack = new MyStack<Character>(infix.length());
	    
	    for (int i = 0; i < infix.length(); i++) {
	        char c = infix.charAt(i);
	        
	        if (Character.isDigit(c)) {
	            queue.enqueue(c);
	        } else if (c == '(') {
	            stack.push(c);
	        } else if (c == ')') {
	            while (!stack.isEmpty() && stack.top() != '(') {
	                queue.enqueue(stack.pop());
	            }
	            stack.pop();
	        } else {
	            while (!stack.isEmpty() && precedence(c) <= precedence(stack.top())) {
	                queue.enqueue(c);
	            }
	            stack.push(c);
	        }
	    }
	    
	    return queue.toString();
	}

	
	
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
	    MyStack<String> stack = new MyStack<String>(postfix.length() * 2);

	    for (int i = 0; i < postfix.length(); i++) {
	        char currentChar = postfix.charAt(i);
	        if (Character.isDigit(currentChar)) {
	            stack.push(Character.toString(currentChar));
	        } else if (!Character.isDigit(currentChar)) {
	            if (stack.size() < 2) {
	                throw new InvalidNotationFormatException();
	            }

	            String string1 = stack.pop();
	            String string2 = stack.pop();
	            stack.push("(" + string2 + currentChar + string1 + ")");
	        }
	    }

	    if (stack.size() > 1) {
	        throw new InvalidNotationFormatException();
	    }
	    return stack.toString();
	}
	
	
	


		 /**
	     * Converts a postfix notation string to an infix notation string.
	     * 
	     * @param postfix The postfix notation string
	     * @return The corresponding infix notation string
	     * @throws InvalidNotationFormatException if the postfix notation is invalid
	     */

	
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
	    MyStack<Double> stack = new MyStack<Double>(postfixExpr.length());

	    for (int i = 0; i < postfixExpr.length(); i++) {
	        char currentChar = postfixExpr.charAt(i);

	        if (Character.isDigit(currentChar)) {
	            stack.push((double) Character.getNumericValue(currentChar));
	        } else if (currentChar == '+' || currentChar == '-' || currentChar == '/' || currentChar == '*') {
	            if (stack.size() < 2) {
	                throw new InvalidNotationFormatException();
	            }

	            double number1 = stack.pop();
	            double number2 = stack.pop();
	            double result = 0;

	            switch (currentChar) {
	                case '+':
	                    result = number2 + number1;
	                    break;
	                case '-':
	                    result = number2 - number1;
	                    break;
	                case '/':
	                    result = number2 / number1;
	                    break;
	                case '*':
	                    result = number2 * number1;
	                    break;
	            }

	            stack.push(result);
	        }
	    }

	    if (stack.size() != 1) {
	        throw new InvalidNotationFormatException();
	    }

	    return stack.pop();
	}

	

	
	
	
	
	
	} 