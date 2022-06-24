import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class lab6 {

    static void q1(String file) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new FileReader(file));

        //create your map

        while(reader.hasNext())
        {
            String word = reader.next();
            //Implement
        }

        reader.close();
    }

    static boolean q2(String file) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new FileReader(file));

        //create your hashset
        while(reader.hasNext())
        {
            String word = reader.next();
            //Implement
        }

        reader.close();
        return someBool;

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
        System.out.println(q2("q2input.txt.txt"));
        q3("q3test.txt.txt");
    }

}
