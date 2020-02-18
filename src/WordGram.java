
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 *
 * @author Jason Few
 *
 */
public class WordGram {

	private String[] myWords;
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = null;
		myHash = 0;
		for (int i=0; i<size; i++){
			myWords[i] = source[i+start];
		}

		// TODO: initialize myWords
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return returns the int number of words of the list of myWords
	 */
	public int length(){
		return myWords.length;
	}


	/**
	 * Complete appropriate comment here
	 * @param o
	 * @return returns a boolean to see if two strings are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		return o.toString().equals(this.toString());
	}

	@Override

	public int hashCode(){
		if (myHash == 0){
			myHash = this.toString().hashCode();
		}
		return myHash;
	}


	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return A new WordGram that obtains all the orignal words and adds 'last' to it
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		String[] s = new String[wg.length()];
		for (int i=0;i<s.length-1;i++){
			s[i] = myWords[i+1];
		}
		s[myWords.length-1] = last;

		WordGram retvalue = new WordGram(s, 0, myWords.length);
		return retvalue;
	}

	@Override
	public String toString(){
		if (myToString == null){
			myToString = String.join(" ", myWords);
		}
		return myToString;
	}
}
