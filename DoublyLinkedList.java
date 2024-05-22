// -------------------------------------------------------
	// Assignment 3
	// Question: DoublyLinkedList class
	// Written by: Huu Khoa Kevin Tran 40283037 && Pritthiraj Dey 40273416
	// For COMP 249 Section WW && QQ – Winter 2024
	// --------------------------------------------------------

	// Date of submission: Wednesday, April 15th 2024
	
// -------------------------------------------------------

/**
 * Class for DoublyLinkedList. Contains the inner private node class for topics.
 * Multiple helper methods and setters and getters to facilitate operations from the driver.
 * Two-directional LinkedList, contains head and tail.
 */

package assignment3;

import java.util.ArrayList;

public class DoublyLinkedList {
	
	/**
	 * Inner private class representing a node in the doubly linked list of topics.
	 */
	private class DNode {
		
		
		private Vocab topic; // The topic associated with this node
		private DNode next; // Reference to the next node in the linked list
		private DNode previous; // Reference to the previous node in the linked list
		 

		 /**
		 * Constructor to create a new DNode object with the given topic.
		 * @param topic The topic to be associated with this node
		 */
		public DNode(Vocab topic) {
	       	this.topic = topic;
	        this.previous = null; // Initially, there is no previous node
	        this.next = null; // Initially, there is no next node
		}

	} // End of node class
	
	/**
     * Getter method to retrieve the topic associated with this node.
     * @return The topic associated with this node
     */
    public Vocab getTopic() {
        return head.topic;
    }

    /**
     * Setter method to update the topic associated with this node.
     * @param topic The new topic to be associated with this node
     */
    public void setTopic(Vocab topic) {
    	head.topic = topic;
    }

    /**
     * Getter method to retrieve the reference to the next node.
     * @return The reference to the next node
     */
    public DNode getNext() {
        return head.next;
    }

    /**
     * Setter method to update the reference to the next node.
     * @param next The new reference to the next node
     */
    public void setNext(DNode next) {
    	head.next = next;
    }

    /**
     * Getter method to retrieve the reference to the previous node.
     * @return The reference to the previous node
     */
    public DNode getPrevious() {
        return head.previous;
    }

    /**
     * Setter method to update the reference to the previous node.
     * @param previous The new reference to the previous node
     */
    public void setPrevious(DNode previous) {
    	head.previous = previous;
    }
	
	// Head node for linked list
	private DNode head;
	private DNode tail;
	
	//Default constructor
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public DNode getHead() {
		return this.head;
	}
	
	public void setHead(DNode head) {
        this.head = head;
    }
	
	public DNode getTail() {
		return this.tail;
	}
	
	public void setTail(DNode tail) {
        this.tail = tail;
    }
	
	
	
	/**
     * Method to add a topic to the linked list of topics.
     * @param topic The topic to be added
     */
	public void addFromHead(Vocab topic) {
		DNode newNode = new DNode(topic);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
		
	}
	/**
	 * Add from tail (node)
	 * @param topic
	 */
	public void addFromTail(Vocab topic) {
		DNode newNode = new DNode(topic);
		if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
        	tail.next = newNode;
        	newNode.previous = tail;
        	tail = newNode;
        }
	}
	
	/**
	 * Delete target node
	 * @return if an item has been deleted successfully or not
	 */
	public void delete(int target) {
		DNode[] nodes = iterateNodes();
		if (isEmpty()) {
			return;
		} else if (nodes[target-1] == head) {
			head.next.previous = null;
			head = head.next;
		} else if (nodes[target-1] == tail) {
			tail.previous.next = null;
			tail = tail.previous;
		} else {
			nodes[target-1].next.previous = nodes[target-1].previous;
			nodes[target-1].previous.next = nodes[target-1].next;
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
		DNode current = head;
		while (!(current.next == null)) {
			++count;
			current = current.next;
		}
		return count;
	}
	
	/**
	 * Iterate through all existing vocabs and store in in an array to return
	 * @return Vocab[] array
	 */
	public Vocab[] iterateVocabs() {
		DNode current = head;
		Vocab[] vocabs = new Vocab[size()];
		for (int i = 0; i < size(); i++) {
			vocabs[i] = current.topic;
			current = current.next;
		}
		return vocabs;
	}
	
	/**
	 * Iterate through all existing nodes and store in in an array to return
	 * @return DNode[] array
	 */
	public DNode[] iterateNodes() {
		DNode current = head;
		DNode[] nodes = new DNode[size()];
		for (int i = 0; i < size(); i++) {
			nodes[i] = current;
			current = current.next;
		}
		return nodes;
	}
	
	/**
	 * Insert a topic before another topic (vocab) and readjust the list.
	 * @param target Index of array 
	 * @param newTopic Given topic to insert
	 */
	public void insertBefore(int target, Vocab newTopic) {
		DNode[] nodes = iterateNodes();
		DNode newNode = new DNode(newTopic);
		if (nodes[target-1] == head) {
			addFromHead(newTopic);
		} else {
			newNode.next = nodes[target-1];
			newNode.previous = nodes[target-1].previous;
			nodes[target-1].previous.next = newNode;
			nodes[target-1].previous = newNode;
		}
	}
	
	/**
	 * Insert a topic after another topic (vocab) and readjust the list.
	 * @param target Index of array 
	 * @param newTopic Given topic to insert
	 */
	public void insertAfter(int target, Vocab newTopic) {
		DNode[] nodes = iterateNodes();
		DNode newNode = new DNode(newTopic);
		if (nodes[target-1] == tail) {
			addFromTail(newTopic);
		} else {
			newNode.previous = nodes[target-1];
			newNode.next = nodes[target-1].next;
			nodes[target-1].next = newNode;
		}
	}
	
	/**
	 * Search the world through all topics and return the locations(topics)
	 * @param target, given word to search for.
	 */
	public void globalSearch(String target) {
		Vocab[] vocabs = iterateVocabs();
		System.out.println(target+" has been found in the following topics: ");
		for (Vocab element : vocabs) {
			if (element.getWords().find(target)) {
				System.out.println(element.getTopic());
			}
		}
	}
	/**
	 * Iterate through every topics and store words with specific a starting letter.
	 * @param target
	 * @return Return ArrayList<String> that contains all words starting with a letter
	 */
	public ArrayList<String> globalLetterSearch(String target) {
		ArrayList<String> matches = new ArrayList<String>();
		Vocab[] vocabs = iterateVocabs();
		for (Vocab element : vocabs) {
			String[] founds = element.getWords().iterateWords();
			for (String match : founds) {
				if (match.startsWith(target)) {
					matches.add(match);
				}
			}
		}
		
		return matches;
	}

}
