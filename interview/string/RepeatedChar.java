package string;

import java.util.*;

public class RepeatedChar {
    public static char getFirstNonRepeatChar(String str) {

         Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
         for( char ch : str.toCharArray()){
             counts.put(ch, counts.containsKey(ch) ? counts.get(ch) + 1 : 1);
         }
         for (Map.Entry<Character, Integer> entry : counts.entrySet()){
             if(entry.getValue() == 1){
              return entry.getKey();
             }
         }
         throw  new RuntimeException("not found repeated characters");
    }

    public static char firstNonRepeatingChar(String word){
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < word.length(); i++ ){
            char letter = word.charAt(i);
            if(repeating.contains(letter)){
                continue;
            }
            if(nonRepeating.contains(letter)){
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            }else{
                nonRepeating.add(letter);
            }

        }
        return nonRepeating.get(0);
    }


    public static char firstNonRepeatedCharacter(String word){
        HashMap<Character, Integer> scoreboard = new HashMap<>();

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(scoreboard.containsKey(c)){
                scoreboard.put(c, scoreboard.get(c) + 1);
            } else {
                scoreboard.put(c, 1);
            }
        }

        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (scoreboard.get(c) == 1) {
                return c;
            }
        }
        throw  new RuntimeException("Undefined behavior");
    }
}
