import java.util.Arrays;

import static java.lang.Math.abs;

public class One {
    //вернуть минимальное число
    public int minArr(int[] arr){
        return Arrays.stream(arr).min().getAsInt();
    }

    //вернуть максимальное число
    public int maxArr(int[] arr){
        return Arrays.stream(arr).max().getAsInt();
    }

    //вернуть среднее число
    public int svgArr(int[] arr){
        return Arrays.stream(arr).sum()/arr.length;
    }

    //вернуть сумму всех положительных чисел
    public int sumPositivNumArr(int[] arr){
        return Arrays.stream(arr).filter(x -> x > 0).sum();
    }

    //сделать число отрицательным
    public int makeNegative(int num){
        return -abs(num);
    }

    //вернуть противоположность числа
    public int revNum(int num){
        return -num;
    }

    //Перевернуть строку
    public String solution(String str){
        return new StringBuilder(str).reverse().toString();
    }

    //Вернуть "да" - если истина, "нет" - если ложь
    public String boolToWord(boolean b){
        return b? "Yes":"No";
    }

    //Удалить первый и последний символ строки
    public String remove(String str){
        return new StringBuilder(str).substring(1, str.length() - 1);
    }

    //преобразовать int in String
    public String numberToString(int num){
        return String.valueOf(num);
    }
}
