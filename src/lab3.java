import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class lab3 {

    /*
     * Returns an ArrayList of words from a file.
     */
    static ArrayList<String> read(String file) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner reader = new Scanner(System.in);

        reader = new Scanner(new FileReader(file));

        while (reader.hasNext()) // reads the file until end of file is reached
            list.add(reader.next().toLowerCase()); //stores these words in an array in lowercase form

        reader.close();

        return list;
    }

    /*
     * Sequential Search or Linear Search is a brute force technique which forces
     * the program to loop through each index until the key value is found.
     * Normally the technique would have an efficiency of O(n) if the program is looking
     * for a single key. However, in this case the efficiency should be O(n^2) as we are
     * comparing 2 different ArrayLists and the outer loop is dependent of the inner loop.
     * The built-in equals() method has a time complexity of O(N)
     * Total time complexity including 2 nested for loops and the equals() method call : O(N^3)
     */
    static void seqSearch(ArrayList<String> test, ArrayList<String> words) {
        double startTime, elapsedTime;

        //initialize wordsNotFound with all the values from the testdata
        ArrayList<String> wordsNotFound = new ArrayList<String>(test);

        //initialize count as the number of words in testdata
        int count = test.size();

        startTime = System.currentTimeMillis();

        for (int i = 0; i < test.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (test.get(i).equals(words.get(j))) {
                    count--;
                    wordsNotFound.remove(test.get(i));
                }
            }
        }

        elapsedTime = (System.currentTimeMillis() - startTime) * 1000;
        System.out.println("Sequential Search:\t" + count + " words not found. " + elapsedTime + " microseconds.");
        System.out.println("Words not found:\t" + wordsNotFound);
    }

    /*
     *  Helper function for binSearch
     *  Recursively take half of the word list to search for the word
     *  If the word is not found, add it to the wordsNotFound list and return it
     *  Binary search for a single value key is O(logN)
     *  String comparison Equals is O(N) complexity
     *  Time complexity of searching for a word : O(NlogN)
     */
    static ArrayList<String> binSearchHelper(String searchKey,
                                             ArrayList<String> words,
                                             ArrayList<String> wordsNotFound) {
        // base case, only 1 word left to check
        if (words.size() == 1 && !searchKey.equals(words.get(0))) {
            wordsNotFound.add(searchKey);
            return wordsNotFound;
        }
        int middle = words.size() / 2;
        // word is found case
        if (searchKey.equals(words.get(middle))) {
            return wordsNotFound;
        }
        // word is lexicographically less than the middle word, closer to A
        if (searchKey.compareToIgnoreCase(words.get(middle)) < 0) {
            ArrayList<String> halfOfWords = new ArrayList<>(words.subList(0, middle));
            return binSearchHelper(searchKey, halfOfWords, wordsNotFound);
        }
        // word is lexicographically greater than the middle word, closer to Z
        if (searchKey.compareToIgnoreCase(words.get(middle)) > 0) {
            ArrayList<String> halfOfWords = new ArrayList<>(words.subList(middle + 1, words.size()));
            return binSearchHelper(searchKey, halfOfWords, wordsNotFound);
        }
        return wordsNotFound;
    }

    /*
     *  Binary search is a method in which the 'middle' index of reference array
     *  and the 'key' value is always compared. In each comparison, the middle
     *  index adjusts depending if the key is < or > or = to the middle.
     *  Looping through the test_data is (n) times, and comparing it using
     *  binary search technique is (logn).Thus, program is supposed to run (n)(logn) times
     *  Efficiency : O(nlogn)
     */
    static void binSearch(ArrayList<String> test, ArrayList<String> words) {
        double startTime, elapsedTime;
        ArrayList<String> wordsNotFound = new ArrayList<String>();
        int count = 0;

        startTime = System.currentTimeMillis();

        // Use helper function to look for every search key in lab3_testdata.txt
        for (String searchKey : test) {
            wordsNotFound = binSearchHelper(searchKey, words, wordsNotFound);
        }
        count = wordsNotFound.size();

        elapsedTime = (System.currentTimeMillis() - startTime) * 1000;
        System.out.println("Binary Search:\t\t" + count + " words not found. " + elapsedTime + " microseconds.");
        System.out.println("Words not found:\t" + wordsNotFound);
    }

    /*
     * main method
     */
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> test = read("lab3_testdata.txt");
        ArrayList<String> words = read("lab3_wordlist.txt");

        seqSearch(test, words);
        System.out.println();
        binSearch(test, words);
    }

}
