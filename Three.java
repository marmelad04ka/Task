import java.util.Arrays;

public class Three {
    //№1 Вернуть массив, где первый элемент - это кол-во положительных чисел
    //а второй элемент - сумма отрицательных
    public int[] countPositivesSumNegatives(int[] input){
        int[] b = new int[2];
        int count = 0, total = 0;
        if(input == null || input.length == 0) return new int[0];
        for(int i = 0; i < input.length; i++){
            if(input[i] > 0){
                count += 1;
                b[0] = count;
            } else if (input[i] < 0 && input != null) {
                total += input[i];
                b[i] = total;
            }
        }
        return b;
    }

    //№2 Вернуть массив с удовенными значениями
    public int[] doubleArr(int[] arr){
        return Arrays.stream(arr).map(x -> x*2).toArray();
    }

    //№3 Найти слово в строке
    public String findNeedle(Object[] haystack){
        for(int i = 0; i < haystack.length; i++){
            if(haystack[i] == null) haystack[i] = "sfs";
            if(haystack[i].equals("needle") && haystack[i] != null){
                return "found the needle at position " + i;
            }
        }
        return "not found";
    }

    //№4 Вернуть строку + имя
    public String qreet(String name){
        return String.format("Hello, %s how are you doing today?", name);
    }

    //№5 Преобразовать логическое значение в строковое
    public String convert(boolean b){
        return b? "true":"false";
    }

    //№6 Вернуть четное число на позиции х
    public int nthEven(int n){
        return (n*2)-2;
    }

    //№7 Проверка имени пользователя
    public static  boolean validateUsr (String s){
        return s.matches("[a-z_\\d]{4,16}");
    }

    //№8 Вернуть массив первых неск.чисел у кратных х
    public int[] countBy(int x, int n){
        int[] arr = new int[n];
        int g = -1;
        for(int i = 1; i <= n*x; i++){
            if(i%x == 0){
                g += 1;
                arr[g] = i;
            }
        }
        return arr;
    }

    //№9 Вернуть "х овца... " повторенную х раз
    public String countingSheep(int num){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 1; i <= num; i++){
            stringBuilder.append(i + " sheep...");
        }
        return stringBuilder.toString();
    }

    //№10 Вернуть истина, если заданное число является простым
    public boolean amIWilson(double n){
        int result = 1;
        for(int i = 1; i <= n - 1; i++){
            result = result * i;
        }
        double num = (result + 1)/(n*n);
        return num == 1;
    }
}
