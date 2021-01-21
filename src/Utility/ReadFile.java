package Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

    public static int getNamesCount(String file_name) throws FileNotFoundException {
        File input = new File(file_name);
        Scanner myReader = new Scanner(input);
        int count = 0;
        while (myReader.hasNextLine())
        {
            myReader.nextLine();
            count++;
        }
        myReader.close();
        return count;
    }

    public static String[] getNames(String file_name, int count) throws FileNotFoundException {
        File input = new File(file_name);
        Scanner myReader = new Scanner(input);
        String[] names = new String[count];
        int i = 0;
        while(myReader.hasNextLine())
        {
            String data = myReader.nextLine();
            names[i++] = data;
        }
        myReader.close();
        return names;
    }
}
