// -------------------------------------------------------
	// Assignment 3
	// Question: Vocab class
	// Written by: Huu Khoa Kevin Tran 40283037 && Pritthiraj Dey 40273416
	// For COMP 249 Section WW && QQ – Winter 2024
	// --------------------------------------------------------

	// Date of submission: Wednesday, April 15th 2024
	
// -------------------------------------------------------

/**
 * Class for Vocab. Contains the Vocab objects to relate the DoublyLinkedList and SinglyLinkedList together and easily identify topics.
 */

package assignment3;

public class Vocab {
	private String topic;
	private SinglyLinkedList words;
	
	/**
	 * 
	 * @param topic, takes in the name of the topic
	 */
	public Vocab(String topic) {
		this.topic = topic;
		words = new SinglyLinkedList();
	}
	
	/**
	 * Set topic
	 * @param topic. Takes in a String value.
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	/**
	 * Change the list of words
	 * @param words, a SinglyLinkedList class
	 */
	public void setWords(SinglyLinkedList words) {
		this.words = words;
	}
	
	/**
	 * Get the topic 
	 * @return String topic
	 */
	public String getTopic() {
		return this.topic;
	}
	
	/**
	 * Get the list of words
	 * @return list of words in SinglyLinkedList class
	 */
	public SinglyLinkedList getWords() {
		return this.words;
	}
	
}
