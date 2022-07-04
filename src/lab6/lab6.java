package lab6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class lab6 {

    static void q1(String file) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new FileReader(file));

        //create your map
        Map<String, Integer> frequency = new HashMap<>();
        while(reader.hasNext())
        {
            String word = reader.next();
//            System.out.println(word);
            //Implement
            if(!frequency.containsKey(word)) {
                frequency.put(word.toLowerCase(), 1);
            } else {
                int count =  frequency.get(word);
                frequency.replace(word, count++);

            }
        }
        frequency.keySet();
        ArrayList<String> sortedKeys = new ArrayList<>(frequency.keySet());
        Collections.sort(sortedKeys);
        for (String name: sortedKeys) {
            System.out.println(name + ' ' + frequency.get(name));
        }
        reader.close();
    }

    static boolean q2(String file) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new FileReader(file));

        HashSet<String> words = new HashSet<>();
        int counter = 0;

        while(reader.hasNext())
        {
            String word = reader.next();
            words.add(word);
            counter++;
        }
        reader.close();
        return counter == words.size();

    }

    static void q3(String file) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new FileReader(file));

        int keyWordsCount = reader.nextInt();
        String[] keywords = new String[keyWordsCount];
        int excuseCount = reader.nextInt();
        HashMap<String, Integer> excusesAndKeywordCounts = new HashMap<>();

        // skip first line with numbers
        reader.nextLine();

        //read keywords
        for(int i = 0; i < keyWordsCount; i++)
        {
            keywords[i] = reader.nextLine();
        }

        //Add keyword counts and excuses to hashmap
        for (int i = 0; i < excuseCount; i++)
        {
            String excuse = reader.nextLine();
            excusesAndKeywordCounts.put(excuse, 0);
        }

        for (String keyword: keywords) {
            for (Map.Entry<String, Integer> entry : excusesAndKeywordCounts.entrySet()) {
                String removedOccurrences = entry.getKey().replace(keyword, "");
                int numberOccurrences = (entry.getKey().length() - removedOccurrences.length()) / keyword.length();
                if (numberOccurrences != 0) {
                    excusesAndKeywordCounts.merge(entry.getKey(), numberOccurrences, Integer::sum);
                }
            }
        }

        int maxKeywordOccurrences = Collections.max(excusesAndKeywordCounts.values());
        ArrayList<String> maxKeywordExcuses = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : excusesAndKeywordCounts.entrySet()) {
            if (entry.getValue() == maxKeywordOccurrences) {
                maxKeywordExcuses.add(entry.getKey());
            }
        }

        Collections.sort(maxKeywordExcuses);

        //Print max excuses
        for (String excuse : maxKeywordExcuses) {
            System.out.println(excuse);
        }

        reader.close();

    }


    public static void main(String[] args) throws FileNotFoundException
    {
        q1("love.txt");
        System.out.println(q2("q2input.txt"));
        q3("q3test.txt");
    }

}
