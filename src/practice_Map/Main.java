package practice_Map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//         todo task 1
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("соз жаз  : ");
//        String world = scanner.nextLine().toUpperCase();
//
//        Map<Character,Integer> map = new LinkedHashMap<>();
//
//        for (char c : world.toCharArray()) {
//            if (c == ' ');
//            map.put(c, map.getOrDefault(c , 0) +1);
//        }
//
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey()  + " : " + entry.getValue());
//        }

//        todo task2
//        System.out.print("соз жаз: ");
//        String world = scanner.nextLine().toUpperCase();
//
//        Map<String,Integer> map2 = new LinkedHashMap<>();
//
//        String[] line = world.split(" ");
//        for (String s : line){
//            if (s.equals(s)){
//               map2.put(s, map2.getOrDefault(s,0)+1);
//           }
//        }
//        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        String[] languages = new String[]{"Java","Go","PHP","Js",
                "Java","Js","C#","Java"};
        System.out.println("countWords(languages) = " + countWords(languages));



    } public static Map<String,Integer> countWords(String[] words){
        Map<String, Integer> wordCount = new LinkedHashMap<>();

        for (String word : words) {
            if (wordCount.containsKey(word)){
                wordCount.put(word,wordCount.get(word)+1);
            }else {
                wordCount.put(word,1);
            }
        }
        return wordCount;

    }
}
