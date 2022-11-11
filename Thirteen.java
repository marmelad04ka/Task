import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Thirteen {
    //№1 https://www.codewars.com/kata/520b9d2ad5c005041100000f/java
    public static String pigIt(String str) {
        String ay = "ay";
        String[] strArr = str.split(" "), newArr = new String[strArr.length];
        for(int i = 0 ; i < strArr.length; i++){
            String[] forArr = new String[strArr[i].length()];
            forArr = strArr[i].split("");

            String first = forArr[0];
            for(int j = 1; j < forArr.length; j++) forArr[j - 1] = forArr[j];
            forArr[forArr.length - 1] = first;
            String str2 = String.join("", forArr);
            newArr[i] = str2;
        }
        for(int i = 0; i < newArr.length; i++){
            if(newArr[i].matches("[!@#$%&*?><,.;:']")) continue;
            newArr[i] = newArr[i] + ay;
        }
        return String.join(" ", newArr);
    }

    //№2 RGB to Hex Convertion
    // https://www.codewars.com/kata/513e08acc600c94f01000001/java
    public static String rgb(int r, int g, int b) {
        if(r > 255) r = 255; if(g > 255) g = 255; if(b > 255) b = 255;
        if(r < 0) r = 0; if(g < 0) g = 0; if(b < 0) b = 0;
        String R = Integer.toString(r, 16).toUpperCase();
        String G = Integer.toString(g, 16).toUpperCase();
        String B = Integer.toString(b, 16).toUpperCase();
        if(R.length() == 1) R = "0" + R; if(G.length() == 1) G = "0" + G; if(B.length() == 1) B = "0" + B;
        return R + G + B;
    }

    //№3 Посчитать кол-во простых чисел до введенного числа
    public static int countSimple(int num){
        int count = 0;
        for(int i = 3; i <= num; i+= 2){
            if(itSimple(i) == 1) count += 1;
        }
        return count + 1;
    }

    public static int itSimple(int num2) {
        boolean isTrue = true;
        int temp = 0;
        for (int i = 2; i <= num2 / 2; i++) {
            temp = num2 % i;
            if (temp == 0) {
                isTrue = false;
                break;
            }
        }
        return isTrue?1:0;
    }

    //№4 Отсортировать набор чар по алфавиту
    public static char[] ch1(char[] ch){
        int[] arr = new int[ch.length];
        for(int i = 0; i < ch.length; i++) arr[i] = (int) ch[i];
        Arrays.sort(arr);
        for(int j = 0; j < arr.length; j++) ch[j] = (char) arr[j];
        return ch;
    }

    //№5 удалить все последовательные повторяющиеся буквы из каждой строки в массиве
    // https://www.codewars.com/kata/59f08f89a5e129c543000069/java
    public static String[] dup(String[] arr){
        String[] str1 = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            String[] timeArr = arr[i].split("");
            for(int j = 0; j < timeArr.length; j++){
                if(j + 1 > timeArr.length - 1) break;
                if(timeArr[j].equals(timeArr[j + 1])){
                    timeArr = ArrayUtils.remove(timeArr, j + 1);
                    j -= 1;
                }
            }
            str1[i] = String.join("", timeArr);
        }
        System.out.print(String.join(" ", str1));
        return str1;
    }

    //№6 отсортировать все буквы (кроме первой и последней) в слове по алфавиту в обратном порядке
    //https://www.codewars.com/kata/5898b4b71d298e51b600014b/java
    public static String sortTheInnerContent(String words){
        String str = "";
        String[] newStr = words.split(" "), endArr = new String[newStr.length];
        for(int i = 0; i < newStr.length; i++){
            str = newStr[i];
            if(newStr[i].length() >= 4){
                String[] splitNonFirstAndEnd = newStr[i].split("");
                String firstStr = splitNonFirstAndEnd[0], endStr = splitNonFirstAndEnd[splitNonFirstAndEnd.length -1];
                splitNonFirstAndEnd = ArrayUtils.remove(splitNonFirstAndEnd, 0);
                splitNonFirstAndEnd = ArrayUtils.remove(splitNonFirstAndEnd, splitNonFirstAndEnd.length - 1);
                Arrays.sort(splitNonFirstAndEnd);
                str = firstStr + String.valueOf(new StringBuffer(String.join("", splitNonFirstAndEnd)).reverse()) + endStr;
            }
            endArr[i] = str;
        }
        return String.join(" ", endArr);
    }

    //№7 https://www.codewars.com/kata/52b305bec65ea40fe90007a7/java
    public static List<String> grabscrab(String s, List<String> words){
        ArrayList<String> list = new ArrayList<>();
        String str = StringUtils.join(words, " ");
        String[] strArr = s.split(""), endArr = str.split(" ");
        Arrays.sort(strArr);
        for(int i = 0; i < endArr.length; i++){
            char[] ch = Arrays.toString(endArr[i].toCharArray()).toCharArray();
            int[] arr = new int[ch.length];
            for(int q = 0; q < ch.length; q++) arr[q] = (int) ch[q];
            Arrays.sort(arr);
            for(int j = 0; j < arr.length; j++) ch[j] = (char) arr[j];
            str = String.valueOf(ch).replaceAll(",", "").replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "");
            if(String.join("", strArr).equals(str)) list.add(endArr[i]);
        }
        return list;
    }

    //№8 Вам будет дан массив целых чисел.
    // Ваша задача состоит в том, чтобы взять этот массив и найти индекс N, где сумма целых чисел слева от N равна сумме целых чисел справа от N.
    // Если нет такого индекса, который мог бы это сделать, верните - 1.
    public static int findEvenIndex(int[] arr) {
        int firstSum = 0, endSum = 0;
        for(int i = 0; i < arr.length; i++){
            for(int i1 = 0; i1 < i; i1++){
                if(i == 0){
                    firstSum = 0;
                    continue;
                }
                firstSum += arr[i1];
            }
            for(int i2 = i + 1; i2 < arr.length; i2++) endSum += arr[i2];
            if(firstSum == endSum) return i;
            firstSum = 0; endSum = 0;
        }
        return -1;
    }
    //№9 Найти пропущенную букву в последовательном наборе букв.
    //https://www.codewars.com/kata/5839edaa6754d6fec10000a2/java
    public static char findMissingLetter(char[] array) {
        int num = (char) array[0], num2 = (char) array[0];
        for(int i = 0; i < array.length; i++){
            num2 = num; num = (char) array[i];
            if(num - num2 > 1){
                num2 += 1;
                return (char) num2;
            }
        }
        return ' ';
    }

    //№10 шифр Цезаря
    public static String floatingCaesarCipher(String str, int step){
        String[] strArr = new String[str.length()];
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            int num = (int) ch;
            if(num >= 97 && num <= 122) {
                num += step;
                if(num > 122) num = (num - 122) + 96;
                ch = (char) num;
            }
            if(num >= 65 && num <= 90){
                num += step;
                if(num > 90) num = (num - 90) + 64;
                ch = (char) num;
            }
            strArr[i] = String.valueOf(ch);
        }
        return String.join("", strArr);
    }
}
