package Pj2;

import java.util.ArrayList;

/**
 * This class implements a generic queue using an ArrayList as the underlying data structure.
 * @author Ashton Kabou
 */

public class MyQueue<T> implements QueueInterface<T> {
	
	// ArrayList to store the elements of the queue
	ArrayList<T> queue;
	
	/**
	 * Constructor to create a queue with a specified size.
	 * @param size The size of the queue
	 */
	public MyQueue(int size) {
		queue = new ArrayList<T>(size);
		for(int i=0; i<size; i++) {
			queue.add(i, null);
		}
	}
	
	/**
	 * Default constructor to create a queue with an initial capacity of 10.
	 */
	public MyQueue() {
		queue = new ArrayList<T>();
	}
	
	/**
	 * Checks if the queue is empty.
	 * @return true if the queue is empty, false otherwise
	 */
	 public boolean isEmpty() {
	        for (T element : queue) {
	            if (element != null) {
	                return false;
	            }
	        }
	        return true;
	    }
	
	/**
	 * Checks if the queue is full.
	 * @return true if the queue is full, false otherwise
	 */
	
	public boolean isFull() {
        
        for (T element : queue) {
            if (element == null) {
                return false;
            }
        }
        return true;
    }
	
	/**
	 * Removes and returns the element at the front of the queue.
	 * @return the element at the front of the queue
	 * @throws QueueUnderflowException if the queue is empty
	 */
	
	public T dequeue() throws QueueUnderflowException{
		T front;
		if(queue.get(0) == null)
			throw new QueueUnderflowException();
		for(int i=0; i<queue.size(); i++)
		{
			if(queue.get(i)==null) {
				front = queue.get(i-1);
				queue.remove(i-1);
				return front;
			}
		}
		front = queue.get(queue.size()-1);
		queue.remove(queue.size()-1);
		return front;
	}
	
	/**
	 * Returns the number of elements in the queue.
	 * @return the number of elements in the queue
	 */
	
	public int size() {
        int count = 0;
        for (T element : queue) {
            if (element != null) {
                count++;
            }
        }
        return count;
    }
	
	
	/**
	 * Adds an element to the rear of the queue.
	 * @param e The element to be added to the queue
	 * @return true if the element is successfully added, false otherwise
	 * @throws QueueOverflowException if the queue is full
	 */
	
	
	
	public boolean enqueue(T e) throws QueueOverflowException{
		if(queue.get(queue.size()-1)!=null)
			throw new QueueOverflowException();
		
		for(int i=0; i<queue.size(); i++) {
			if(queue.get(0)==null) {
				queue.set(0, e);
				return true;
			}
			else if(queue.get(i)==null) {
				while(queue.get(0)!=null) {
					queue.set(i, queue.get(i-1));
					queue.set(i-1, null);
					i--;
				}
			}
		}
		queue.set(0, e);
		return true;
	}

	
	
	/**
	 * Returns a string representation of the elements in the queue.
	 * @return a string representation of the elements in the queue
	 */
	
	public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = queue.size() - 1; i >= 0; i--) {
            if (queue.get(i) != null) {
                str.append(queue.get(i));
            }
        }
        return str.toString();
    }

	
	/**
	 * Returns a string representation of the elements in the queue with a specified delimiter.
	 * @param delimiter The delimiter to use between elements
	 * @return a string representation of the elements in the queue with the specified delimiter
	 */
	 public String toString(String delimiter) {
	        StringBuilder str = new StringBuilder();
	        boolean firstElement = true;
	        for (int i = queue.size() - 1; i >= 0; i--) {
	            if (queue.get(i) != null) {
	                if (!firstElement) {
	                    str.append(delimiter);
	                }
	                str.append(queue.get(i));
	                firstElement = false;
	            }
	        }
	        return str.toString();
	    }	
	/**
	 * Fills the queue with elements from an ArrayList.
	 * @param list The ArrayList containing elements to fill the queue
	 */
	
	 public void fill(ArrayList<T> list) {
	        queue.clear(); // Clear the existing elements in the queue
	        for (int i = list.size() - 1; i >= 0; i--) {
	            queue.add(list.get(i)); // Add elements from the list to the queue in reverse order
	        }
	    }
	
	
	}
