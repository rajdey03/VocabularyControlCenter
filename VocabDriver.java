// -------------------------------------------------------
	// Assignment 3
	// Question: VocabDriver class
	// Written by: Huu Khoa Kevin Tran 40283037 && Pritthiraj Dey 40273416
	// For COMP 249 Section WW && QQ – Winter 2024
	// --------------------------------------------------------

	// Date of submission: Wednesday, April 15th 2024
	
// -------------------------------------------------------

/**
 * Class for the Main Driver (VocabDriver). Contains all the methods to execute for the main menu.
 * Multiple helper methods and setters and getters to facilitate operations from the driver.
 * Contains main method down below.
 */

package assignment3;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class VocabDriver {
	
	/*
	 * Attributes file_name is static because we want to 
	 */
	private static String file_name;
	private static DoublyLinkedList vocab_list = new DoublyLinkedList();
	
	/**
	 * Method to browse through the list of topics and display them.
	 * @param info Scanner object for input
	 */
	public static void browseTopic(Scanner info) {	
	    int index = 1;
	    int browse_choice = 1;
	    
	    while (browse_choice != 0) {	    
		    // Display the initial menu
		    System.out.println("\n---------------------------");
		    System.out.println("\tPick a topic");
		    System.out.println("---------------------------");
	    
	        // Iterate through the list of topics and display them
		    index = 1;
	    	do {   		
	    		if (vocab_list.isEmpty()) {
	    			break;
	    		}
	          	System.out.println(index + " " + vocab_list.iterateVocabs()[index-1].getTopic());
	            index++;
	        } while (index-1 < vocab_list.size());
	 
	        
	        // Display the exit option
	        System.out.println("0 Exit");
	        System.out.println("---------------------------");
	        System.out.print("Enter Your Choice: ");
	        
	        // Read user input
	        browse_choice = info.nextInt();
	        info.nextLine();
	        
	        do {
		        switch (browse_choice) {
		            case 0:
		                break;
		            default:
		                // If the choice is within the valid range
		                if (browse_choice >= 1 && browse_choice <= index) {
		                    // Display the words associated with the selected topic
		                	System.out.println("Topic: "+vocab_list.iterateVocabs()[browse_choice-1].getTopic());
		                	index = 1;
		                	 do {
		         	        	if (index % 5 == 0) {
		         	        		System.out.println();
		         	        	}
		         	            System.out.print(index + ": " + vocab_list.iterateVocabs()[browse_choice-1].getWords().iterateWords()[index-1] + "\t");
		         	            index++;
		         	        } while (index-1 < vocab_list.iterateVocabs()[browse_choice-1].getWords().size());
		                } else {
		                    // Display error message for invalid choice
		                    System.out.print("Option out of range, try again: ");
		                    browse_choice = info.nextInt();
		        	        info.nextLine();
		                }
		                break;
		        }
	        } while (!(browse_choice == 0) && !((browse_choice >= 1 || browse_choice <= vocab_list.iterateVocabs()[browse_choice-1].getWords().size())));
	    }
	}

	/**
	 * Method to insert a new topic before another topic in the list.
	 * @param info Scanner object for input
	 */
	public static void insertTopicBefore(Scanner info) {
	    int index = 1;
	    int browse_choice = 1;
	    
	    
	    while (browse_choice != 0) {
	    // Display the initial menu
		    System.out.println("---------------------------");
		    System.out.println("\tPick a topic");
		    System.out.println("---------------------------");
	    

	        // Iterate through the list of topics and display them
	    	do { 
	    		if (vocab_list.isEmpty()) {
	    			break;
	    		}
	          	System.out.println(index + " " + vocab_list.iterateVocabs()[index-1].getTopic());
	            index++;
	        } while (index-1 < vocab_list.size());
	        
	        // Display the exit option
	        System.out.println("0 Exit");
	        System.out.println("---------------------------");
	        System.out.print("Enter Your Choice: ");
	        
	        // Read user input
	        browse_choice = info.nextInt();
	        info.nextLine();
	        
	        switch (browse_choice) {
	            case 0:
	                break;
	            default:
	                // If the choice is within the valid range
	                if (browse_choice >= 1 && browse_choice <= vocab_list.size()) {
	                	System.out.println("Enter a topic name: ");
	                	String topicName = info.nextLine();
	                	Vocab newVocab = new Vocab(topicName);

	                    // Call method to add new topic before the selected topic
	                    vocab_list.insertBefore(browse_choice, newVocab);
	                    

	                    String word;
	                    System.out.println("Enter a word - to quit press Enter:");
	                    while (true) {
	                    	word = info.nextLine();
	                    	if (word.isBlank()) {
	                    		break;
	                    	} else {
	                    		newVocab.getWords().addFromTail(word);
	                    	}
	                    }
	
	                    // Reset index for next iteration
	                    index = 1;
	                } else {
	                    // Display error message for invalid choice
	                    System.out.println("Option out of range, try again: ");
	                    browse_choice = info.nextInt();
	        	        info.nextLine();
	                    
	                    // Reset current_topic and index for next iteration
	                    index = 1;
	                }
                break;
	        }
	    }
	}
	
	
	/**
	 * Method to insert a new topic after another topic in the list.
	 * @param info Scanner object for input
	 */
	public static void insertTopicAfter(Scanner info) {
	    int index = 1;
	    int browse_choice = 1;
	    
	    
	    while (browse_choice != 0) {
	    // Display the initial menu
		    System.out.println("---------------------------");
		    System.out.println("\tPick a topic");
		    System.out.println("---------------------------");
	    

	        // Iterate through the list of topics and display them
	    	do {
	    		if (vocab_list.isEmpty()) {
	    			break;
	    		}
	          	System.out.println(index + " " + vocab_list.iterateVocabs()[index-1].getTopic());
	            index++;
	        } while (index-1 < vocab_list.size());
	        
	        // Display the exit option
	        System.out.println("0 Exit");
	        System.out.println("---------------------------");
	        System.out.print("Enter Your Choice: ");
	        
	        // Read user input
	        browse_choice = info.nextInt();
	        info.nextLine();
	        
	        switch (browse_choice) {
	            case 0:
	                break;
	            default:
	                // If the choice is within the valid range
	                if (browse_choice >= 1 && browse_choice <= vocab_list.size()) {
	                	System.out.println("Enter a topic name: ");
	                	String topicName = info.nextLine();
	                	Vocab newVocab = new Vocab(topicName);

	                    // Call method to add new topic before the selected topic
	                    vocab_list.insertAfter(browse_choice, newVocab);
	                    

	                    String word;
	                    System.out.println("Enter a word - to quit press Enter:");
	                    while (true) {
	                    	word = info.nextLine();
	                    	if (word.isBlank()) {
	                    		break;
	                    	} else {
	                    		newVocab.getWords().addFromTail(word);
	                    	}
	                    }
	
	                    // Reset index for next iteration
	                    index = 1;
	                } else {
	                    // Display error message for invalid choice
	                    System.out.println("Option out of range, try again: ");
	                    browse_choice = info.nextInt();
	        	        info.nextLine();
	                    
	                    // Reset current_topic and index for next iteration
	                    index = 1;
	                }
                break;
	        }
	    }
	}
	/**
	 * Remove a specific topic 
	 * @param info, takes in Scanner for user's input on topic to be removed
	 */
	public static void removeTopic(Scanner info) {
	    int index = 1;
	    int browse_choice = 1;
		System.out.println("---------------------------");
	    System.out.println("\tPick a topic");
	    System.out.println("---------------------------");
	    
	    // Iterate through the list of topics and display them
    	do {
    		if (vocab_list.isEmpty()) {
    			break;
    		}
          	System.out.println(index + " " + vocab_list.iterateVocabs()[index-1].getTopic());
            index++;
        } while (index-1 < vocab_list.size());
        
        // Display the exit option
        System.out.println("0 Exit");
        System.out.println("---------------------------");
        System.out.print("Enter Your Choice: ");
        
        // Read user input
        browse_choice = info.nextInt();
        info.nextLine();
        
        switch (browse_choice) {
            case 0:
                break;
            default:
                // If the choice is within the valid range
                if (browse_choice >= 1 && browse_choice <= vocab_list.size()) {
                	vocab_list.delete(browse_choice);
                } else {
                    // Display error message for invalid choice
                    System.out.println("Option out of range, try again: ");
                    browse_choice = info.nextInt();
        	        info.nextLine();
                }
            break;
        }
	    
	}
	/**
	 * Modify a specific topic 
	 * @param info, takes in Scanner for user's input on topic to be modified
	 */
	public static void modifyTopic(Scanner info) {
	    int browse_choice = 1;
	    int index = 1;
	    String modifyChoice = "";
	    
	    while (browse_choice != 0 && !modifyChoice.equals("0")) {
	    // Display the initial menu
		    System.out.println("---------------------------");
		    System.out.println("\tPick a topic");
		    System.out.println("---------------------------");
		    index = 1;
		    browse_choice = 1;
		    modifyChoice = "";

	        // Iterate through the list of topics and display them
	    	do {
	    		
	    		if (vocab_list.isEmpty()) {
	    			break;
	    		}
	          	System.out.println(index + " " + vocab_list.iterateVocabs()[index-1].getTopic());
	            index++;
	        } while (index-1 < vocab_list.size());
	        
	        // Display the exit option
	        System.out.println("0 Exit");
	        System.out.println("---------------------------");
	        System.out.print("Enter Your Choice: ");
	        
	        // Read user input
	        browse_choice = info.nextInt();
	        info.nextLine();
	        
	        switch (browse_choice) {
	            case 0:
	                break;
	            default:
	                // If the choice is within the valid range
	                if (browse_choice >= 1 && browse_choice <= vocab_list.size()) {
	                	System.out.println("---------------------------");
	                	System.out.println("\tModify Topics Menu");
	                	System.out.println("---------------------------");
	                	System.out.println("a add a word");
	                	System.out.println("r remove a word");
	                	System.out.println("c change a word");
	                	System.out.println("0 Exit");
	                	System.out.println("---------------------------");
	                	System.out.print("Enter Your Choice: ");
	                	modifyChoice = info.nextLine();
	                	
	                	String word = "";
	                	do {
		                	switch(modifyChoice) {
			                	case "0":
			                		break;
			                	case "a":
			                		System.out.println("Type a word and press Enter, or press Enter to end input: ");
			                		word = info.nextLine();
			                		if (vocab_list.iterateVocabs()[browse_choice-1].getWords().find(word)) {
			                			System.out.println("Sorry, the word: \'"+word+"\' is already listed");
			                			break;
			                		} else {
			                			vocab_list.iterateVocabs()[browse_choice-1].getWords().addFromTail(word);
			                		}
			                		break;
			                	case "r":
			                		System.out.println("Type a word and press Enter, or press Enter to end input: ");
			                		word = info.nextLine();
			                		if (!vocab_list.iterateVocabs()[browse_choice-1].getWords().find(word)) {
			                			System.out.println("Sorry, there is no word: "+word);
			                			break;
			                		} else {
			                			vocab_list.iterateVocabs()[browse_choice-1].getWords().delete(word);
			                		}
			                		break;
			                	case "c":
			                		System.out.println("Type a word and press Enter, or press Enter to end input: ");
			                		word = info.nextLine();
			                		if (!vocab_list.iterateVocabs()[browse_choice-1].getWords().find(word)) {
			                			System.out.println("Sorry, there is no word: "+word);
			                			break;
			                		} else {
			                			System.out.print("What would you like to change it to: ");
			                			String change = info.nextLine();
			                			vocab_list.iterateVocabs()[browse_choice-1].getWords().setWord(word,change);
			                		}
			                		break;
			                	default:
			                		 // Display error message for invalid choice
				                    System.out.println("Option out of range, try again: ");
				                    modifyChoice = info.nextLine();
				        	        info.nextLine();
		                	}
		                	
	                	} while (!(modifyChoice.equals("0") || modifyChoice.equals("a") || modifyChoice.equals("r") || modifyChoice.equals("c")));
	                	
	                } else {
	                    // Display error message for invalid choice
	                    System.out.println("Option out of range, try again: ");
	                    browse_choice = info.nextInt();
	        	        info.nextLine();
	                }
                break;
	        }
	    }
	}
	/**
	 * Search for a specific word and list the location of the word and its topic
	 * @param info, takes in Scanner for user's input on word to be searched
	 */
	public static void searchForWord(Scanner info) {
		System.out.println("---------------------------");
	    System.out.println("Which word are you looking for?: ");
	    String target = info.nextLine();
	    System.out.println("---------------------------");
	    vocab_list.globalSearch(target);
	}
	
	/**
	 * Method to load topics and associated words from a file.
	 * @param info Scanner object for input
	 */
	public static void loadFile(Scanner info) {
	    System.out.print("Enter the name of the input file: ");
	    file_name = info.nextLine();
        Vocab current_vocab = null;
	    
	    try {
	    	
	        Scanner read = new Scanner(new File(file_name));
	      
	        // Read lines from the file
	        while (read.hasNextLine()) {
	            String line = read.nextLine();
	            
	            if (line.startsWith("#")) {
	                // If the line starts with '#', it indicates a new topic
	            	current_vocab = new Vocab(line.substring(1));
	                vocab_list.addFromTail(current_vocab);
	                
	                boolean inside = true;
	                while (inside) {
	                	if (!read.hasNextLine()) {
	                		inside = false;
	                		break;
	                	}
	                	String wordLine = read.nextLine();
	                	if (wordLine.isBlank()) {
	                		inside = false;
	                		break;
	                	} else {
	                		current_vocab.getWords().addFromTail(wordLine);
	                		inside = true;
	                	}
	                }
	            } 
	            
	        }
	        read.close();
	        System.out.println("Done loading");
	    } catch (FileNotFoundException fnfe) {
	        fnfe.printStackTrace();
	    }
	}

	/**
	 * Show all words beginning with a given letter by the user
	 * @param info, Scanner input from user.
	 */
	public static void showWords(Scanner info) {
		System.out.println("---------------------------");
	    System.out.println("What is the letter?: ");
	    String target = info.nextLine();
	    System.out.println("---------------------------");
	    System.out.println("Here are the matches: ");    
	    ArrayList<String> matches = vocab_list.globalLetterSearch(target);
	    for (String element : matches) {
	    	System.out.println(element);
	    }
	}
	
	/**
	 * Method to save the topics and associated vocabulary words to a text file.
	 * @param file The name of the file to save the data to
	 */
	public static void saveFile(String file) {
	    try {
	        PrintWriter pw = new PrintWriter(file);
	        
	        Vocab[] vocabs = vocab_list.iterateVocabs();
	        
	        for (Vocab element : vocabs) {
	        	String[] words = element.getWords().iterateWords();
	        	
	        	pw.println("#" + element.getTopic());
	        	
	        	for (String word : words) {
	        		pw.println(word);
	        	}
	        	pw.println();
	        }

	        System.out.println("The file has been saved.");
	        pw.close();
	    } catch (IOException ioe) {
	        ioe.printStackTrace();
	    }
	}

	
	public static void main(String[] args) {
		
		Scanner info = new Scanner(System.in);
		boolean run_program = true;
		
		while(run_program) {
			System.out.println("---------------------------");
			System.out.println("Vocabulary Control Center");
			System.out.println("---------------------------");
			System.out.println("1 Browse a topic");
			System.out.println("2 Insert a new topic before another one");
			System.out.println("3 Insert a new topic after another one");
			System.out.println("4 Remove a topic");
			System.out.println("5 Modify a topic");
			System.out.println("6 Search topics for a word");
			System.out.println("7 Load from a file");
			System.out.println("8 Show all words starting with a given letter");
			System.out.println("9 Save to file");
			System.out.println("0 Exit");
			System.out.println("---------------------------");
			System.out.print("Enter Your Choice: ");
			
			int menu_choice = info.nextInt();
			info.nextLine();
			
			switch(menu_choice) {
			case 1:
				browseTopic(info); //Done
				break;
			case 2:
				insertTopicBefore(info); //In Progress (Need help)
				break;
			case 3:
				insertTopicAfter(info); //In Progress (Need help)
				break;
			case 4:
				removeTopic(info);
				break;
			case 5:
				modifyTopic(info);
				break;
			case 6:
				searchForWord(info);
				break;
			case 7:
				loadFile(info); //Done
				break;
			case 8:
				showWords(info);
				break;
			case 9:
				saveFile(file_name); //Done, but did not test it yet
				break;
			case 0:
				System.out.println("Thank you for using VocabManager.");
				run_program = false;
				break;
			default:
				System.out.println("\nInvalid choice. Please try again.\n");
			}
		}
	}
}
