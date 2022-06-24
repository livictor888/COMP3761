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
                int old_count =  frequency.get(word);
                old_count++;
                frequency.replace(word, old_count);

            }
        }

        frequency.keySet();

        ArrayList<String> sortedKeys = new ArrayList<>(frequency.keySet());
        Collections.sort(sortedKeys);
        for (String name: sortedKeys) {
//            String key = name.toString();
//            String value = frequency.get(name).toString();
            System.out.println(name + ' ' + frequency.get(name));
        }

        reader.close();
    }

    static boolean q2(String file) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new FileReader(file));

        //create your hashset

        HashSet<String> words = new HashSet<>();
        int counter = 0;

        while(reader.hasNext())
        {
            String word = reader.next();
            //Implement
            words.add(word);
            counter++;
        }
        reader.close();

        return counter == words.size();

    }

    static void q3(String file) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new FileReader(file));

        //create your other variables (sets, etc)

        int keyWordsCount = reader.nextInt();
        int excuseCount = reader.nextInt();

        // skip first line with numbers
        reader.nextLine();

        //read keywords
        for(int i = 0; i < keyWordsCount; i++)
        {
            //read keywords e.g. datatype.add(reader.nextLine())
        }

        //evaluate excuses
        for(int i = 0; i < excuseCount; i++)
        {
            String excuse = reader.nextLine();
            String excuseWords[] = excuse.split(" ");

            //Implement
        }

        //Print max excuses

        reader.close();

    }


    public static void main(String[] args) throws FileNotFoundException
    {
        q1("love.txt");
//        System.out.println(q2("q2input.txt.txt"));
//        q3("q3test.txt.txt");
    }

}
