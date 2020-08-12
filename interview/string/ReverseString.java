package string;

public class ReverseString {

    public static void main(String[] args){

        String str = "ЯБЛОКО";
        char[] chAr = str.toCharArray();
        char[] newchAr = new char[chAr.length];
        for (int i = 0; i < chAr.length; i++) {
            newchAr[chAr.length - i - 1] = chAr[i];
        }
        String newStr = new String(newchAr);
        System.out.println(newStr);

        for (int i = 0; i < newchAr.length / 2; i++) {
            char buff = newchAr[i];
            newchAr[i] = newchAr[chAr.length - i - 1];
            newchAr[chAr.length - i - 1] = buff;
        }
        System.out.println(new String(newchAr));

        String reverse = reverseRecursively("ПРИВЕТ");
        System.out.println(reverse);
    }


    public static String reverseRecursively(String str){
        if (str.length() < 2){
            return  str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);
    }

}
