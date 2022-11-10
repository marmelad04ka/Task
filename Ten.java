import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;

public class Ten {
    //№1 Дано слово, посчитать количество букв или символов, которые встречаются больше 1 раза
    public static int duplicateCountBigOne(String text){
        Stream<String> stream = Stream.of(text.toLowerCase().split(""));
        Set<String> items = new HashSet<>();

        return (int) stream.filter(n -> !items.add(n)).collect(Collectors.toSet()).stream().count();
    }

    //№2 Заменить все повторяющиеся буквы в слове на (, остальные на )
    public static String duplicateCount(String text){
        Stream<String> stream = Stream.of(text.toLowerCase().split(""));
        Set<String> items = new HashSet<>();

        String str = stream.filter(n -> !items.add(n)).collect(Collectors.toSet()).toString();

        String[] strArrShort = str.toLowerCase().split("");
        String[] strArr = text.toLowerCase().split("");

        for(int i = 0; i < strArr.length; i++){
            for(int j = 0; j < strArrShort.length; j++){
                if(strArr[i].equals(strArrShort[j])) strArr[i] = ")";
            }
        }

        for(int i = 0; i < strArr.length; i++){
            if(strArr[i] != ")") strArr[i] = "(";
        }
        return String.join("", strArr);
    }

    //№3 Принимаем положительный параметр num и возвращаем его мультипликативную стойкость,
    // то есть количество раз, которое вы должны умножить на num, пока не получите одну цифру
    public static int persistence (long n){
        int[] nums = Long.toString(n).chars().map(c -> c - '0').toArray();
        int bb = nums[0], count = 0;
        boolean isSorted = true;

        if(n < 10) return 0;
        while(isSorted){
            for(int i = 1; i < nums.length; i++){
                bb = nums[i] * bb;
            }
            nums = Long.toString(bb).chars().map(c -> c - '0').toArray();
            count += 1;
            if(bb < 10) break;
            bb = nums[0];
        }
        return count;
    }

    //№4 Убрать в предложении все – и _ и буквы после этих символов заменить на заглавные
    public static String toCameCase(String s){
        String[] strArr = s.split("");
        for(int i = 0; i < strArr.length; i++){
            if(strArr[i].equals("-") || strArr[i].equals("_")){
                strArr[i + 1] = strArr[i + 1].toUpperCase();
            }
        }
        return String.join("", strArr).replaceAll("_", "")
                .replaceAll("-", "");
    }

    //№5 Выяснить является ли предложение  панаграммой
    public static boolean check(String sentence){
        String newStr = sentence.replaceAll("[^A-Za-z]", "").toLowerCase();
        String result = new StringBuilder(newStr).reverse().toString();
        result = result.replaceAll("(.)(?=.*\\1)", "");
        result = new StringBuilder(result).reverse().toString();

        return result.length() == 26;
    }

    //№6 Найти уникальное число в массиве
    public static double findUniq(double arr[]){
        double[] newArr = arr;
        int lengthStart = 0;
        boolean isTrue = true;
        while (isTrue){
            newArr = arr;
            lengthStart = arr.length;
            arr = ArrayUtils.removeAllOccurrences(arr, arr[0]);
            if(lengthStart - arr.length == 1) return newArr[0];
        }
        return 0;

    }

    //№7Дано слово/предложение (абвгде), разделить следующим образом: аб вг де.
    // Если в слове нечетное кол-во букв, то добавить _ в конце (абвгдеж -> аб вг де ж_)
    public static String[] solutionTwoAndDownLine(String s){
        String newStr = "";
        if(s.length()%2 != 0) newStr = s.concat("_");
        else newStr = s;
        String[] newArr = new String[newStr.length()/2], wordsArr = newStr.split("");

        for(int i = 0; i < newArr.length; i++){
            newArr[i] = wordsArr[0] + wordsArr[1];
            wordsArr = ArrayUtils.removeAll(wordsArr, 0, 1);
        }
        return newArr;
    }

    //№8Дано предложение, вернуть самое тяжелое слово
    // (наибольшая сумма порядковых номеров букв)
    public static String high(String s){
        if(s.length() < 1) return s;
        String[] firstArr = s.split(" ");
        String bigString = "";
        int sum = 0, count = 0;
        for(int i = 0; i < firstArr.length; i++){
            String[] secondArr = firstArr[i].split("");
            String str = String.join("", secondArr);
            for(int j = 0; j < secondArr.length; j++){
                char a = str.charAt(j);
                int asd = a;
                sum = sum + (asd - 96);
            }
            if(sum > count){
                bigString = firstArr[i];
                count = sum;
            }
            sum = 0;
        }
        return bigString;
    }

    //№9Параметром функции findNb (find_nb, find-nb, findNb,...)
    // будет целое число m, и вы должны вернуть целое число n,
    // такое как n^3 + (n-1)^3 + ... + 1^3 = m,
    // если такое n существует, или -1, если такого n нет.
    public static long findNB(long m){
        long count = 0;
        for(int i = 0; i < m; i++){
            count = (long) Math.pow(i, 3) + count;
            if(count == m) return i;
            if(count > m) return -1;
        }
        return 2;
    }

    //№10Учитывая массив (arr) в качестве аргумента,
    // завершите функцию countSmileys, которая должна вернуть
    // общее количество улыбающихся лиц.
    // (глаза -  :|; , нос - -|~|void, рот - )|D )
    public static int countSmileys(List<String> arr){
        return (int) arr.stream().filter(x -> x.matches("[:;][-~]?[)D]")).count();
    }
}
