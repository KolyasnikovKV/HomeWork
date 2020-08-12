package string;

import com.sun.deploy.util.StringUtils;

import java.util.Scanner;

public class VowelCounter {
    public static void main(String[] args){
        System.out.println("Введите строку");
        Scanner reader = new Scanner(System.in);

        String input = reader.nextLine();
        char[] letters = input.toCharArray();

        int count = 0;

        for (char ch : letters){
            switch (ch){
                case 'а':
                case 'е':
                case 'и':
                case 'о':
                case 'у':
                    count ++; break;
                default:

            }
        }

        System.out.println("Numbers = " + count);

     /*   int count = StringUtils.countOccurrencesOf(input, "a");

        System.out.println("count of occurrence of character 'a' on String: " +
                " Today is Monday' using Spring StringUtils " + count);


        //Using Apache commons lang StringUtils class
        int number = org.apache.commons.lang.StringUtils.countMatches(input, "a");
        System.out.println("count of character 'a' on String: 'Today is Monday' using commons StringUtils " + number);

*/



         int charCount = 0;

         for (int i = 0; i < input.length(); i++){
             if (input.charAt(i) == 'е'){
                 charCount++;
             }
         }
        System.out.println(charCount);

        charCount = 0;

        for(char ch : input.toCharArray()){
            if (ch == 'е') {
                charCount++;
            }
        }

        System.out.println(charCount);


    }
}
