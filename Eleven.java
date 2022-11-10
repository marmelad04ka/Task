import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Eleven {
    //№1 Узнать простое число или нет
    public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i < Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }
        return true;
    }

    //№2 Найти в массиве элемент, который встречается нечетное кол-во раз
    public static int findIt(int[] a){
        int[] countArr = a;
        int count = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < countArr.length; i++){
                if(a[i] == countArr[j]) count += 1;
            }
            if(count%2 != 0) return a[i];
        }
        return 0;
    }

    //№3 Разложить число на разряды ( 705006 = 700000 + 5000 + 6)
    public static String expandedForm(int num){
        int[] arr = Integer.toString(num).chars().map(c -> c - '0').toArray(), newArr =new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) continue;
            arr[i] = arr[i] * (int) Math.pow(10, arr.length - i - 1);
            newArr[i] = arr[i];
        }
        newArr = ArrayUtils.removeAllOccurrences(newArr, 0);
        return Arrays.toString(newArr).replaceAll("[\\[\\]\\ ]", "")
                .replaceAll("[\\,\\ ]", " + ");
    }

    //№4 Для двух массивов a и b напишите функцию comp(a, b) (orcompSame(a, b)), которая проверяет,
    // имеют ли два массива «одинаковые» элементы с одинаковыми кратностями
    public static boolean comp(int[] a, int[] b) {
        if(a == null || b == null) return false;
        if(b.length == 0) return true;
        if(a.length == 0) return false;
        int[] doubleA = Arrays.stream(a).map(x -> x * x).toArray();
        int count = 0;
        for(int i = 0; i < doubleA.length; i++){
            for(int j = 0; j < b.length; j++){
                if(doubleA[i] == b[j]){
                    count += 1;
                    b = ArrayUtils.remove(b, j);
                }
            }
        }
        if(count == doubleA.length) return true;
        return false;
    }

    //№5 Дан массив, в котором есть 1 уникальное число, найдите его
    public static int stray(int[] numbers) {
        int[] secondArr = numbers;
        for(int i = 0; i < numbers.length; i++){
            numbers = ArrayUtils.removeAllOccurrences(numbers, numbers[0]);
            if(numbers.length == 1) return numbers[0];
            if(secondArr.length - numbers.length == 1) return secondArr[0];
            secondArr = numbers;
        }
        return 0;
    }

    //№6 Посчитать кол-во true в массиве
    public static int countSheeps(Boolean[] arrayOfSheeps) {
        arrayOfSheeps = ArrayUtils.removeAllOccurrences(arrayOfSheeps, null);
        return (int) Arrays.stream(arrayOfSheeps).filter(x -> x == true).count();
    }

    //№7 Перевернуть все слова в строке
    public static String reverseWords(final String original)
    {
        if(original.trim().length() == 0) return "))))";
        System.out.print(original.length());
        String[] str = original.split(" ");
        for(int i = 0; i < str.length; i++){
            str[i] = String.valueOf(new StringBuffer(str[i]).reverse());
        }
        return String.join(" ", str);
    }

    //№8 Bouncing ball. https://www.codewars.com/kata/5544c7a5cb454edb3c000047/java
    public static int bouncingBall(double h, double bounce, double window) {
        if(h < 0 || bounce < 0 || bounce > 1 || window > h) return -1;
        double count = 0;
        while(h > window){
            h = h * bounce;
            count++;
        }
        return (int) (count * 2) - 1;
    }

    //№9 Вставить пробел во все места в предложении, где встречается заглавная буква. https://www.codewars.com/kata/5208f99aee097e6552000148/java
    public static String camelCase(String input) {
        return String.join(" ", input.split("(?=[A-Z])"));
    }

    //№10 Построить волну из слов (hello -> Hello, hEllo, heLlo, hello, hello) https://www.codewars.com/kata/58f5c63f1e26ecda7e000029/java
    public static String[] wave(String str){
        String timeStr = str.replaceAll(" ", "");
        String[] newArr = new String[timeStr.split("").length + (str.split(" ").length - 1)], voidStr = {};
        if(str.length() == 0) return voidStr;
        String[] strArr = str.split("");
        for(int i = 0; i < newArr.length; i++) {
            if(strArr[i].equals(" ")) continue;
            for (int j = 0; j < strArr.length; j++) strArr[i] = strArr[i].toUpperCase();

            newArr[i] = String.join("", strArr);
            strArr[i] = strArr[i].toLowerCase();
        }
        newArr = ArrayUtils.removeAllOccurrences(newArr, null);
        return newArr;
    }
}
