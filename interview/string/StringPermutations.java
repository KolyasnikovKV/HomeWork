package string;

public class StringPermutations {
    public static void main(String[] args){
        permutation("1234");
    }

    public static void permutation(String input){
        permutation("", input);
    }
    //https://javarevisited.blogspot.com/2015/08/how-to-find-all-permutations-of-string-java-example.html
    private static void permutation(String perm, String word){
        if (word.isEmpty()){
            System.err.println(perm + word);
        } else {
            for(int i = 0; i < word.length(); i++){
                permutation(perm + word.charAt(i), word.substring(0, i)
                        + word.substring(i + 1, word.length()));
            }
        }

    }
}
