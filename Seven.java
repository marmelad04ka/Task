import java.util.Arrays;
import java.util.stream.Collectors;

public class Seven {
    //№1 Учитывая цифру х - верните сумму цифр х
    public int sumNumNumbers(int n){
        return (n != 0 && n%9 == 0)? 9: n%9;
    }

    //№2 Дается строка чисел, разделенных пробелами, вернуть наименьшее и наибольшее число
    public String highAndLow(String numbers){
        int[] numArr = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = numArr[0], min = numArr[0];
        for(int i: numArr){
            if(max < i) max = i;
            if(min < i) min = i;
        }
        String strMax = String.valueOf(max);
        String strMin = String.valueOf(min);
        return String.format("%s %s", strMax, strMin);
    }

    //№3 Содержит ли строка одинаковое количество х и о
    public boolean getXO(String str){
        char[] str1 = str.toCharArray();
        int countO = 0, countX = 0;
        for(int i: str1){
            if(i == 'o' || i == 'O') countO += i;
            if(i == 'x' || i == 'X') countX += i;
        }
        return countO == countX;
    }

    //№4 Заменить определенные буквы на другие
    public String makeComplement(String dna){
        return dna.replace("A", "B")
                .replace("C", "D")
                .replace("T", "A")
                .replace("G", "C")
                .replace("B", "T")
                .replace("D", "G");
    }

    //№5 Заменить все символы кроме последних 4 на #
    public String mskify(String str){
        char[] ch = str.toCharArray();
        if(ch.length <= 4) return String.valueOf(ch);
        for(int i = 0; i < ch.length - 4; i++) ch[i] = '#';
        return String.valueOf(ch);
    }

    //№6 Возвести в квадрат каждую цифру числа и соеденить их
    public int squareDigits(int n){
        int[] arr = Integer.toString(n).chars().map(c -> c-'0').toArray();
        for(int i = 0; i < arr.length; i++) arr[i] *= arr[i];

        String str = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining());
        return Integer.parseInt(str);
    }

    //№7 Вернуть сколько раз повторяются буквы из определенного диапазона в строке
    public String printError(String str){
        String str1 = str.replaceAll("[abcdefghijklm]", "");
        return String.format("%s/%s", str1.length(), str.length());
    }

    //№8 Проверка пин-кода (4-6 цифр)
    public boolean validatePin(String pin){
        return pin.matches("\\d{4}") || pin.matches("\\d{6}");
    }

    //№9 Преобразовать имя в инициалы
    public String correct(String string){
        char[] ch = string.toCharArray();
        String str1 = String.valueOf(ch[0]).toUpperCase();
        String str2 = "";
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == ' ') str2 = String.valueOf(ch[i+1]).toUpperCase();
        }
        return String.format("%s.%s", str1, str2);
    }

    //№10 Заменить буквы в началае слов на заглавные
    public String toJadenCase(String phrase){
        if(phrase == null || phrase.equals("")) return null;

        char[] array = phrase.toCharArray();

        for(int i = 0; i < array.length; i++){
            if(i == 0 || array[i - 1] == ' ') array[i] = Character.toUpperCase(array[i]);
        }
        return new String(array);
    }
}
