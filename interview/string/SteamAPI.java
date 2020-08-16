package string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SteamAPI {
    public static void main (String[] arg){
        /*Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String last = sc.nextLine();*/

        String first = "Иван";
        String last = "Иванов";

        String fio = first + last;
        System.out.printf("Фамилия: %s Имя: %s %n", last, first);

        Map<Character, Integer> mapFio = new HashMap<>();
        for(char ch : fio.toLowerCase().toCharArray()){
            mapFio.put(ch, mapFio.containsKey(ch)? mapFio.get(ch) + 1 : 1 );
        }

        Map.Entry<Character, Integer> maxEntry = mapFio.entrySet().stream()
                .max(Comparator.comparing(new Function<Map.Entry<Character, Integer>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Character, Integer> o){
                        return o.getValue();
                    }
                }))
                //.max(Comparator.comparing(entry -> entry.getValue()))
                //.max(Comparator.comparing(Map.Entry::getValue))
                .get();

        Character[] charObjectArray = last.chars().mapToObj(c -> (char) c).toArray(Character[]::new);


        Arrays.stream(charObjectArray)
                .filter(item ->  (char) item != (char) maxEntry.getKey())
                .collect(Collectors.toList()).forEach(System.out::print);



    }
}
