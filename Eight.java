import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Eight {
    //№1 Даны результаты матчей,  посчитать кол-во очков, которые заработала команда (x>y -3p; x<y - op; x=y - 1p)
    public int points(String[] games){
        int count = 0;
        char[] ch = Arrays.toString(games).toCharArray();
        for(int i = 0; i <ch.length; i++){
            if(ch[i-1] > ch[i+1]) count += 3;
            if(ch[i-1] < ch[i+1]) count += 0;
            if(ch[i-1] == ch[i+1]) count += 1;
        }
        return count;
    }

    //№2 Переверните число
    public int sortDec(final int num){
        int[] arr = Integer.toString(num).chars().map(c -> c - '0').toArray();
        boolean isSorted = false;
        int buf;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++){
                if(arr[i] < arr[i+1]){
                    isSorted = false;

                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                }
            }
        }
        return IntStream.range(0, arr.length).map(i -> (int) (Math.pow(10, arr.length -1 -i) * arr[i])).sum();
    }

    //№3 Дан набор букв, верните середину
    public String getMiddle(String word){
        char[] ch = word.toCharArray();
        if(word.length() == 1) return word;

        char ch1 = word.charAt((word.length()/2)-1), ch2 = word.charAt((word.length()/2));
        String str1 = String.valueOf(ch1), str2 = String.valueOf(ch2);
        if(word.length()%2 ==0) return String.format("%s%s", str1, str2);
        if (word.length()%2 != 0) return str2;

        return "0";
    }

    //№4 Отфильтровать список и вернуть цифры
    public List filterList(final List<Object>list){
        return list.stream().filter(e -> e instanceof Integer).collect(Collectors.toList());
    }

    //№5 Заменить первую букву и буквы после пробела на заглавные
    public String toJadenCase(String phrase){
        if(phrase == null || phrase.length() == 0) return null;
        char[] ch = phrase.toCharArray();
        for (int i = 0; i < ch.length - 1; i++){
            char c = ch[i+1], a = ch[0];
            ch[0] = Character.toUpperCase(a);
            if(ch[i] == ' ' && ch[i] != ch.length) ch[i+1] = Character.toUpperCase(c);
        }
        return String.valueOf(ch);
    }

    //№6 Вернуть длину самого короткого слова в строке
    public int findShort(String s){
        String str2 = "00000000000000000000000000000";
        String[] str = s.split(" ");
        for(int i = 0; i <str.length; i++){
            if(str[i].length() < str2.length()) str2 = str[i];
        }
        return str2.length();
    }

    //№7 Найти сумму чисел между двумя числами (включая эти числа)
    public int getSum(int a, int b){
        int count = 0;
        if(a > b) for(int i = b; i <= a; i++) count += i;
        if(a < b) for(int i = a; i <= b; i++) count += i;
        return a == b? a: count;
    }

    //№8 Найти следующий идеальный квадрат после числа
    public long findNextSquare(long sq){
        double number = Math.pow(sq, 0.5);
        return number%1 == 0? (long) (number = (number + 1) * (number + 1)): -1;
    }

    //№9 Преобразовать двоичное число  вдесятичное
    public int convertBinaryArrayToInt(List<Integer> binary){
        int[] arr = binary.stream().mapToInt(i -> i).toArray();
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum = (int) (arr[i] * Math.pow(2, (arr.length - 1) - i)) + sum;
        }
        return sum;
    }

    //№10 Проверить, заканчивается ли строка на определенные символы
    public boolean solution(String str, String ending){
        String aboba = "";
        if(ending.length() == 0) return true;
        for(int i = 0; i < str.length(); i++){
            aboba = str.substring(i);
            if(aboba.equals(ending)) return true;
        }
        return false;
    }
}
