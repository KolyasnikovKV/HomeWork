package string;

import java.util.ArrayList;
import java.util.List;

public class Palindrom {

    public static void recursion(int palindrom, List<Integer> list){
        if (palindrom < 10) {
            list.add(palindrom);
        } else {
        list.add(palindrom % 10);
        recursion(palindrom / 10, list);}
    }

    public static String recursion2(String palindrom){
        if (palindrom.length() < 2) { return "Палиндром";
        } else {
            //if (palindrom.substring(0,1).equals(palindrom.substring(palindrom.length() - 1, palindrom.length())))
            if (palindrom.charAt(0) == palindrom.charAt(palindrom.length() - 1)) {
                String str = recursion2(palindrom.substring(1, palindrom.length() - 1));
                return str; //
            } else {
                return "Обычная строка";
            }
        }
    }

    public static void main(String[] args){

        int palindrom = 1234321;

        List<Integer> list = new ArrayList<Integer>();
        Palindrom.recursion(palindrom, list);
        System.out.println(list.toString());

        boolean isPalindrom = true;
        for (int i = 0; i <= list.size() / 2; i++)
        {
            if (list.get(i) != list.get(list.size()- i - 1)){
                isPalindrom = false;
                break;
            }
        }

        System.out.println( isPalindrom? "Палиндром": "Обычное число");

        String str = "АБРИРБА";
        System.out.println(recursion2(str));
    }
}
