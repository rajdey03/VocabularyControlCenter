// -------------------------------------------------------
	// Assignment 3
	// Question: SinglyLinkedList class
	// Written by: Huu Khoa Kevin Tran 40283037 && Pritthiraj Dey 40273416
	// For COMP 249 Section WW && QQ – Winter 2024
	// --------------------------------------------------------

	// Date of submission: Wednesday, April 15th 2024
	
// -------------------------------------------------------

/**
 * Class for SinglyLinkedList. Contains the inner private node class for the words in a topic.
 * Multiple helper methods and setters and getters to facilitate operations from the driver.
 * One-directional LinkedList, contains head and tail.
 */

package assignment3;

public class SinglyLinkedList {
	
	/**
	 * Inner private class for SNode, nodes in a single linked list.
	 */
	private class SNode {
		
		private String word; // The word stored in this node
	    private SNode next; // Reference to the next node in the linked list
	    

	    /**
	     * Constructor to create a new Words object with the given word.
	     * @param word The word to be stored in this node
	     */
	    public SNode(String word) {
	        this.word = word;
	        this.next = null; // Initially, there's no next node
	    }

	    /**
	     * Getter method to retrieve the word stored in this node.
	     * @return The word stored in this node
	     */
	    public String getWord() {
	        return this.word;
	    }

	    /**
	     * Setter method to update the word stored in this node.
	     * @param word The new word to be stored in this node
	     */
	    public void setWord(String word) {
	        this.word = word;
	    }
		
	}
	// SNode head for this list.
	private SNode head;
	private SNode tail;
	
	/**
	 * Default constructor
	 */
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	/**
	 * Get head of the list
	 * @return head, Head of nodes
	 */
	public SNode getHead() {
		return this.head;
	}
	
	/**
     * Method to add a word to the linked list of words from this topic.
     * @param topic The topic to be added
     */
	public void addFromHead(String word) {
		SNode newNode = new SNode(word);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
		
	}
	/**
     * Method to add a word to the linked list of words from this topic.
     * @param topic The topic to be added
     */
	public void addFromTail(String word) {
		SNode newNode = new SNode(word);
		if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
        	tail.next = newNode;
        	tail = newNode;
        }
	}
	
	/**
	 * Delete node
	 * @return if an item has been deleted successfully or not
	 */
	public void delete(String target) {
		SNode[] nodes = iterateNodes();
		
		if (isEmpty()) {
			return;
		} else {
			for (SNode element : nodes) {
				if (element.word.equals(target) && element == head) {
					head = head.next;
					return;
				} else if (head.next == tail) {
					head = null;
					tail = null;
					return;
				} else if (element.word.equals(target) && element == tail) {
					SNode current = head;
					while (current.next.next != null) {
						current = current.next;
					}
					current.next = null;
					tail = current;
				} else {
					if (element.next.word.equals(target)) {
						element.next = element.next.next;
						break;
						
					}
				}
			}
		}
	}
	
	/**
	 * Check if empty
	 * @return boolean value whether it is empty or not
	 */
	public boolean isEmpty() {
		return (head == null);
	}
	
	/**
	 * Check current size of list
	 * @return integer, number of nodes in list.
	 */
	public int size() {
		int count = 1;
		SNode current = head;
		while (!(current.next == null)) {
			count++;
			current = current.next;
		}
		return count;
	}
	
	/**
	 * Iterate through words only in form of string
	 * @return Array of Strings containing all words for a topic
	 */
	public String[] iterateWords() {
		SNode current = head;
		String[] words = new String[this.size()];
		for (int i = 0; i < size(); i++) {
			words[i] = current.word;
			current = current.next;
		}
		return words;
	}
	
	/**
	 * Found or not (boolean)
	 * @param target
	 * @return boolean value, indicating the presence of a word.
	 */
	public boolean find(String target) {
		String[] nodes = iterateWords();
		for (String element : nodes) {
			if (element == target || element.equalsIgnoreCase(target)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Iterate through nodes objects
	 * @return Array of Nodes
	 */
	public SNode[] iterateNodes() {
		SNode current = head;
		SNode[] nodes = new SNode[this.size()];
		for (int i = 0; i < size(); i++) {
			nodes[i] = current;
			current = current.next;
		}
		return nodes;
	}
	
	/**
	 * Helper method to find and setWord.
	 * @param target targetWord
	 * @param change updatedWord
	 */
	public void setWord(String target, String change) {
		SNode[] nodes = iterateNodes();
		for (SNode element : nodes) {
			if (element.getWord().equals(target)) {
				element.setWord(change);
				break;
			}
		}
	}
	
	
	
}
