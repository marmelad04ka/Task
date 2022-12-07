import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Fourteen {
    //№1 Посчитать количество чисел, в которых нет 5.
    // https://www.codewars.com/kata/5813d19765d81c592200001a/java
    public static int dontGiveMeFive(int start, int end) {
        int count = 0;
        for(int i = start; i <= end; i++){
            count += 1;
            int[] arr = Integer.toString(i).chars().map(c -> c - '0').toArray();
            for(int j = 0; j < arr.length; j++){
                if(arr[j] == 5) {
                    count -= 1;
                    break;
                }
            }
        }
        return count;
    }

    //№2 Найти слово в тексте, которое встречается чаще всего
    public static String mostFrequentWord(String str) {
        str = str.replaceAll("[^a-zA-z ]", "");
        String[] strArr = str.split(" ");
        int count = 0, max = 0;
        String strNew = "", notSingle = "In this sentence, the word '%s' occurs most times (%s)", allSingle = "all words single";
        for(int i = 0; i < strArr.length; i++){
            if(strArr[i].equals("")) continue;
            for(int j = 0; j < strArr.length; j++) if(strArr[i].equals(strArr[j])) count += 1;
            if(count > max) {
                strNew = strArr[i];
                max = count;
            }
            count = 0;
        }
        return max == 1? allSingle: String.format(notSingle, strNew, max);
    }

    //№3 https://www.hackerrank.com/challenges/java-string-tokens/problem?isFullScreen=true
    public static String splitText(String str){
        String str1 = str.replaceAll("[^a-zA-Z]", " ").replaceAll("[^a-zA-Z ]", "");
        String[] strArr = str1.split(" ");
        for(int i = 0; i < strArr.length; i++){
            if(strArr[i].equals("") || strArr[i].equals(" ")){
                strArr = ArrayUtils.remove(strArr, i);
                i -= 1;
            }
        }
        System.out.println(strArr.length);
        Arrays.stream(strArr).forEach(s -> System.out.println(s));
        return "2";
    }

    //№4 Палиндром ди число
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int[] arr = Integer.toString(x).chars().map(c -> c - '0').toArray();
        int[] firstHalf = new int[arr.length /2], endHalf = new int[arr.length /2 ] ;
        int count = 0;
        if(arr.length%2 == 1){
            for(int i = 0; i < arr.length/2 ; i++) firstHalf[i] = arr[i];
            for(int i = arr.length/2 + 1; i < arr.length  ; i++){
                endHalf[count] = arr[i];
                count += 1;
            }
        }
        if(arr.length%2 == 0){
            for(int i = 0; i < arr.length/2 ; i++) firstHalf[i] = arr[i];
            for(int i = arr.length/2; i < arr.length  ; i++){
                endHalf[count] = arr[i];
                count += 1;
            }
        }
        for (int i = 0; i < endHalf.length / 2; i++) {
            int tmp = endHalf[i];
            endHalf[i] = endHalf[endHalf.length - i - 1];
            endHalf[endHalf.length - i - 1] = tmp;
        }
        return Arrays.equals(firstHalf, endHalf);
    }

    //№5
    //№6
    //№7
    //№8
    //№9
    //№10
}
