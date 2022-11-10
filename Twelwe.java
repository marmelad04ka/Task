import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Twelwe {
    //№1 В предложении сделать заглавными буквы: после пробелов, первую. Склеить все в 1 строку
    //https://www.codewars.com/kata/587731fda577b3d1b0001196/java
    public static String camelCase(String str) {
        String[] strArr = str.trim().split("");
        for(int i = 0; i < strArr.length; i++){
            strArr[0] = strArr[0].toUpperCase();
            if(strArr[i].equals(" ")) strArr[i + 1] = strArr[i + 1].toUpperCase();
        }
        return String.join("", strArr).replaceAll(" ", "");
    }

    //№2 https://www.codewars.com/kata/5626b561280a42ecc50000d1/java
    public static List<Long> sumDigPow(long a, long b) {
        List<Long> list = new ArrayList<>();
        int count = 0;
        for(long i = a; i <= b; i++ ){
            long[] timeArr = new long[1];
            timeArr[0] = i;
            long[] arr2 = Long.toString(timeArr[0]).chars().map(c -> c - '0').asLongStream().toArray();
            for(int j = 0, z = 1; j < arr2.length; j++, z++){
                count = (int) Math.pow(arr2[j], z) + count;
            }
            if(count == timeArr[0]) list.add(timeArr[0]);
            count = 0;
        }
        return list;
    }

    //№3 Посчитать, сколько в прямоугольник поместится квадратов, вывести их площади от большей к меньшей
    //https://www.codewars.com/kata/55466989aeecab5aac00003e/java
    public static List<Integer> sqInRect(int lng, int wdth) {
        if(lng == wdth) return null;
        List<Integer> list = new ArrayList<>();
        int full = lng * wdth;
        for(int i = lng * wdth / 2; i >= 2; i--){
            if(i * i < full && i <= lng && i <= wdth){
                list.add(i);
                full = full - i * i;
                if(lng != i) lng = lng - i;
                if(wdth != i) wdth = wdth - i;
                if(wdth == i || lng == i) i++;
                if(lng == wdth && lng != 1 && wdth != 1) list.add(lng);
            }
        }
        if(lng == 1 && wdth == 1){
            int indexOfLastElement = list.size() - 1;
            list.remove(indexOfLastElement);
            return list;
        }
        for(int j = lng * wdth - full; j < lng * wdth; j++){
            if(lng == wdth) continue;
            list.add(1);
        }
        return list;
    }

    //№4 https://www.codewars.com/kata/52761ee4cffbc69732000738/java
    public static String battle(String goodAmounts, String evilAmounts) {
        String[] good = goodAmounts.split(" ");
        String[] evil = evilAmounts.split(" ");
        int countGood = Integer.parseInt(good[0]) * 1 + Integer.parseInt(good[1]) * 2 + Integer.parseInt(good[2]) * 3 + Integer.parseInt(good[3]) * 3 + Integer.parseInt(good[4]) * 4 + Integer.parseInt(good[5]) * 10;
        int countEvil = Integer.parseInt(evil[0]) * 1 + Integer.parseInt(evil[1]) * 2 + Integer.parseInt(evil[2]) * 2 + Integer.parseInt(evil[3]) * 2 + Integer.parseInt(evil[4]) * 3 + Integer.parseInt(evil[5]) * 5 + Integer.parseInt(evil[6]) * 10;
        String goodsWins = "Battle Result: Good triumphs over Evil", evilsWins = "Battle Result: Evil eradicates all trace of Good", zero = "Battle Result: No victor on this battle field";
        if(countGood == countEvil) return zero;
        return countGood > countEvil? goodsWins : evilsWins;
    }

    //№5 Дана арифметическая прогрессия, найти недостающий элемент (1,2,3,5 – 4; 1,3,5,9,11 - 7)
    //https://www.codewars.com/kata/52de553ebb55d1fca3000371/java
    public static int findMissing(int[] numbers)
    {
        if(numbers[0] == numbers[1]) return 0;
        int[] newArr = numbers;
        int num = numbers[2] - numbers[1], count = 0, ch;
        for(int i = 0; i < numbers.length; i++){
            ch = numbers[i] + num;
            for(int j = 0; j < newArr.length; j++){
                if(newArr[j] == ch) count++;
            }
            if(count == 0) return ch;
            count = 0;
        }
        return 0;
    }

    //№6 https://www.codewars.com/kata/59c633e7dcc4053512000073
    public static int solve(final String s) {
        String[] str = s.split("[aeiou]");
        int count = 0, timeInt = 0, count2 = 0;
        for(int i = 0; i < str.length; i++){
            if(str[i].length() == 0) continue;
            String str2 = str[i];
            String[] endArr = str2.split("");
            for(int j = 0; j < endArr.length; j++){
                char a = endArr[j].charAt(0);
                timeInt = a;
                count = (timeInt - 96) + count;
            }
            if(count > count2) count2 = count;
            count = 0;
        }
        return count2;
    }

    //№7 Проверка номера телефона
    // https://www.codewars.com/kata/525f47c79f2f25a4db000025/java
    public static boolean validPhoneNumber(String phoneNumber) {
        if(phoneNumber.matches(".*[a-zA-Z*]+.*")) return false;
        String[] str = phoneNumber.split("");
        return str[0].equals("(") && str[4].equals(")") && str[5].equals(" ") && str[9].equals("-") && str.length == 15;
    }

    //№8 Проверить номер кредитной карты
    // https://www.codewars.com/kata/5418a1dd6d8216e18a0012b2/java
    public static boolean validate(String n){
        int[] arr = Long.toString(Long.parseLong(n)).chars().map(c -> c - '0').toArray();
        if(arr.length%2 == 0){
            for(int i = 0; i < arr.length; i++){
                if(i%2 == 0) arr[i] = arr[i] *2;
                if(arr[i] > 9) arr[i] = arr[i] - 9;
            }
        }
        if(arr.length%2 == 1){
            for(int j = 0; j < arr.length; j++){
                if(j%2 == 1) arr[j] = arr[j] *2;
                if(arr[j] > 9) arr[j] = arr[j] - 9;
            }
        }
        if(Arrays.stream(arr).sum() < 10) return false;
        return Arrays.stream(arr).sum() >= 10? Arrays.stream(arr).sum()%10 == 0: Arrays.stream(arr).sum()%10 == 1;
    }

    //№9 https://www.codewars.com/kata/597770e98b4b340e5b000071/java
    public static String extractFileName(String dirtyFileName) {
        String[] str = dirtyFileName.split("");
        aboba(str, "_");
        String middle = String.valueOf(new StringBuffer(String.join("", aboba(str, "_"))).reverse());
        String[] str2 = middle.split("");
        aboba(str2, ".");
        return String.valueOf(new StringBuffer(String.join("", aboba(str2, "."))).reverse());
    }
    public static String[] aboba(String[] arr, String pl){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(count == 0){
                arr = ArrayUtils.remove(arr, 0);
                i = 0;
            }
            if(arr[i].equals(pl)){
                arr = ArrayUtils.remove(arr, i);
                break;
            }
        }
        return arr;
    }

    //№10 Посчитать кол-во пар перчаток в ящике
    public static int numberOfPairs(String[] gloves) {
        int count = 0, count2 = 0;
        int[] arr2 = new int[gloves.length];
        String[] arr = gloves;
        boolean isTrue = true;
        for(int i = 0; i < gloves.length; i++){
            arr = ArrayUtils.removeAllOccurrences(arr, gloves[i]);
            int a =  gloves.length - arr.length;
            arr2[count] = a;
            count += 1;
            gloves = arr;
            i = -1;
        }
        arr2 = ArrayUtils.removeAllOccurrences(arr2, 1);
        arr2 = ArrayUtils.removeAllOccurrences(arr2, 0);
        for(int j = 0; j < arr2.length; j++){
            if(arr2[j] > 2 && arr2[j]%2 == 0) {
                count2 += arr2[j]/2;
                continue;
            }
            if(arr2[j] > 2 && arr2[j]%2 == 1){
                arr2[j] -= 1;
                if(arr2[j] == 2) {
                    count2 += 1;
                    continue;
                }
                while(isTrue){
                    arr2[j] = arr2[j] / 2;
                    count2 += 1;
                    if(arr2[j] == 2) isTrue = false;
                }
            }
            count2 += 1;
        }
        return count2;
    }
}
