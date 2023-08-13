/*Zayeem_Zaki Project7, 
 * In this project we read the textFile(book) and add all the words to the LinkedList and
 * keep count of the total words, and the different words in the book*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class project7 {	 
	public static void main(String[] args) throws FileNotFoundException {
		//opens a textBook
		File file = new File("Shakespeare.txt");
		//creates a scanner to read , we have made scanner array to open book two times 
		//first time for Unsorted sortedList and second time for SortedList
		Scanner[] input = { new Scanner(file), new Scanner(file)};
		
		//creates an array for startTime which stores the time at which execution starts,
		//and then milliSecs and seconds which stores the total time of execution for each list
		long[] startTime = new long[2];
		long[] milliSecs = new long[2];
		double[] seconds = new double[2];
		
		//creates a listInterface for each list
		ListInterface[] lists = new ListInterface[2];
		lists[0] = new Hash1();
		lists[1] = new Hash2();
		
		//stores listNames to be used in print out statement
		String[] listNames = {"Hash1", "Hash2"};

		//prints out the data header
		System.out.println(" #    List Name      Run Time  Vocabulary  Total Words   Key Comp   ");
		System.out.println("-- ----------------- --------  ----------  ----------- ------------  ");
		
		//Initialize the counter for while loop
		int i=0;
		//while loop which executes 2 times, each time for each list
		while(i < 2) {
			//stores the start time in milliseconds
			startTime[i] = System.currentTimeMillis();
			//while loop which is executed till all the words are read from the book
			while (input[i].hasNext()) {
				//trimmed word with no leading or trailing punctuation
				String Word = TrimLTPunct(input[i].next()).toLowerCase();
				//if the word isn't empty after trimming leading and trailing punctuation it's added to the respective list
				if(Word != "") 
					lists[i].add(Word);
			}
			input[i].close();
			//calculates the total time of execution in milliseconds and stores in the milliSecs array
			milliSecs[i] = System.currentTimeMillis() - startTime[i] ;
			//converts milliSecs to seconds and stores in seconds array
			seconds[i] = milliSecs[i ] / 1000.000;
			// prints out the data well formatted
			System.out.printf("%2d %-17s %8.3f %10d %11d %13d \n",
					i +1, listNames[i], seconds[i], lists[i].getDistinctWords(),
					lists[i].getTotalWords(), lists[i].getKeyCompare());
			//increments i to execute for the other list
			i++;
		
		}
		
	}

	//trim LT punctuation method which trims the punctuation of the words
	public static String TrimLTPunct(String word){
		//create a string of punctuation which is trimmed at the beginning and the end of the word
		String LTpunct = "!@#$%^&*()_+-=[]\\{}|;':\"`~,./<>?";
		
		//trims the leading punctuation by comparing the first character of word to the LTpunct string, 
		//if the first character of word is equal to any punctuation then the substring of word excluding first character is set as new word
		while (word.length() != 0 && LTpunct.indexOf(word.charAt(0)) != -1){
			word = word.substring(1);
		}
		//trims the trailing punctuation by comparing the last character of word to the LTpunct string, 
		//if the last character of word is equal to any punctuation then the substring of word excluding last character is set as new word
		while (word.length() != 0 && LTpunct.indexOf(word.charAt(word.length() - 1)) != -1){
			word = word.substring(0, word.length() - 1);
		}
        //returns new trimmed when the method is called.
		return word;
	}
}
