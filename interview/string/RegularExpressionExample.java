package string;

import java.util.regex.Pattern;

public class RegularExpressionExample {
    public static void main (String[] args){
        Pattern pattern = Pattern.compile(".*[0-9].*");
        String[] inputs = {"123", "-123", "123.12", "abcd123" };
        for (String input : inputs){
            System.out.println(input + " is number " + pattern.matcher(input).matches());
        }

        String[] numbers = {"123", "-123", "123.12", "abcd123" };

        Pattern digitPattern = Pattern.compile(".*\\d{3}.*");
        //Pattern digitPattern = Pattern.compile("\\d\\d\\d\\d\\d\\d");

        for (String number : numbers){
            System.out.println(number + " is 6 digit number " + digitPattern.matcher(number).matches());

        }

//    . — соответствует любому символу;
//
//   [ ] — совпадает с символом из диапазона, содержащегося в квадратных скобках;
//
//   [^] — соответствует символам, которые не входят в диапазон, содержащийся в квадратных скобках;
//
//   * — совпадение 0 или более раз с указанным элементом;
//
//    + — совпадение 1 или более раз с указанным элементом;
//
//   ? — совпадение 0 или 1 раз с указанным элементом;
//
//    {n} — точное совпадение n раз указанного элемента;
//
//    {n, m} — точное совпадение от n до m раз указанного элемента;
//
//   {n, } — точное совпадение n или более раз указанного элемента;
//
//   \ — экранирование или отмена специального значения указанного символа.

    }
}
