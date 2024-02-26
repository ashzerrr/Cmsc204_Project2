
	package Pj2;

	/**
	 * @author Ashton Kabou
	 * 
	 * 
	 */

	import java.util.ArrayList;

	public class MyStack<T> implements StackInterface<T> { 
		ArrayList<T> stack;
		
		
		/**
	     * Constructor to create a stack with a specified size.
	     * @param size The size of the stack
	     */
				
		public MyStack(int size) {
	        stack = new ArrayList<T>(size);
	        for (int i = 0; i < size; i++) {
	            stack.add(null); // Add null elements to the ArrayList
	        }
	    }
		
		/**
	     * Default constructor to create a stack with an initial capacity of 10.
	     */

		
				public MyStack() {
			stack = new ArrayList<T>();
		}
		
		
				
		 /**
	     * Checks if the stack is full.
	     * @return true if the stack is full, false otherwise
	     */
				
				public boolean isFull() {
					for(int i=0; i<stack.size(); i++) {
						if(stack.get(i)==null)
							return false;
					}
					return true;
				}
				
				/**
	     * Checks if the stack is empty.
	    * @return true if the stack is empty, false otherwise
	     */
		public boolean isEmpty() {
	        for (T element : stack) {
	            if (element != null) {
	                return false;
	            }
	        }
	        return true;
	    }
		
		
		 /**
	     * Returns the element at the top of the stack without removing it.
	     * @return the element at the top of the stack
	     * @throws StackUnderflowException if the stack is empty
	     */

public T top() throws StackUnderflowException {
    if (isEmpty()) {
        throw new StackUnderflowException();
    }
    
    for (int i = stack.size() - 1; i >= 0; i--) {
        if (stack.get(i) != null) {
            return stack.get(i);
        }
    }
    
    
    throw new StackUnderflowException();
}

		
		/**
	     * Removes and returns the element at the top of the stack.
	     * @return the element at the top of the stack
	     * @throws StackUnderflowException if the stack is empty
	     */
		
		public T pop() throws StackUnderflowException{
			if(stack.get(0)==null)
				throw new StackUnderflowException();
			

		
		T top;
		for(int i=0; i<stack.size(); i++) {
			if(stack.get(i)==null) {
				top = stack.get(i-1);
				stack.remove(i-1);
				return top;
			}
		}
		top = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return top;
	}			
	    /**
	     * Adds an element to the top of the stack.
	     * @param e The element to be added to the stack
	     * @return true if the element is successfully added, false otherwise
	     * @throws StackOverflowException if the stack is full
	     */

		
				 public boolean push(T e) throws StackOverflowException {
				        if (isFull()) {
				            throw new StackOverflowException();
				        }

				        for (int i = 0; i < stack.size(); i++) {
				            if (stack.get(i) == null) {
				                stack.set(i, e);
				                return true;
				            }
				        }
				        return false;
				    }
		
		 /**
	     * Returns the number of elements in the stack.
	     * @return the number of elements in the stack
	     */
   
		 public int size() {
		        int count = 0;
		        for (T element : stack) {
		            if (element != null) {
		                count++;
		            }
		        }
		        return count;
		    }
		
		
	    
	    /**
	     * Returns a string representation of the elements in the stack.
	     * @return a string representation of the elements in the stack
	     */

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (T element : stack) {
            if (element != null) {
                str.append(element);
            }
        }
        return str.toString();
    }
    
    
    /**
	     * Returns a string representation of the elements in the stack with a specified delimiter.
	     * @param delimiter The delimiter to use between elements
	     * @return a string representation of the elements in the stack with the specified delimiter
	     */
		 
		 public String toString(String delimiter) {
		        StringBuilder str = new StringBuilder();
		        boolean firstElement = true;
		        for (T element : stack) {
		            if (element != null) {
		                if (!firstElement) {
		                    str.append(delimiter);
		                }
		                str.append(element);
		                firstElement = false;
		            }
		        }
		        return str.toString();
		    }
		
		 public void fill(ArrayList<T> list) {
		        stack.clear(); // Clear the stack before filling it with new elements
		        for (T element : list) {
		            stack.add(element);
		        }
		    }
		
		
	} 