import java.util.Arrays;

public class Five {
    //№1 Если имя начинается на Р/р вернуть истину
    public String areYouPlayingBanjo(String name){
        char[] b = name.toCharArray();
        return(b[0] == 'R' || b[0] == 'r')? name + " plays banjo": name + " does not play banjo";
    }

    //№2 Вычислить индекс массы тела
    public String bmi(double weight, double height){
        double bmi = weight/(height*height);

        if(bmi <= 18.5) return "Underweight";
        if(bmi <= 25.0) return "Normal";
        if(bmi <= 30.0) return "Overweight";
        return "Obese";
    }

    //№3 Принимаем массив чисел, вернуть их сумму
    public double sum(double[] numbers){
        return Arrays.stream(numbers).sum();
    }

    //№4 Принимаем массив чисел, вернуть их умножение
    public int grow(int[] x){
        int multi = 1;
        for(int i: x) multi *= i;
        return multi;
    }

    //№5 Вернуть значение массива, округленное до ближайшего целого числа
    public int getAverage(int[] marks){
        return (int) Arrays.stream(marks).average().orElse(0);
    }

    //№6 Заменить символ в строке на другой
    public String dnaToRna(String dna){
        return dna.replace("T", "U");
    }

    //№7 Сложить числа в двух массивах
    public int arrayPlusArray(int[] arr1, int[] arr2){
        return Arrays.stream(arr1).sum() + Arrays.stream(arr2).sum();
    }

    //№8 Заполнить массив всеми числами до числа х
    public int[] monkeyCount(final int n){
        int[] num = new int[n];
        for(int i = 0; i < n; i++) num[i] = i + 1;
        return num;
    }

    //№9 Вернуть число, умноженное на 10, если оно логически верно
    public String bonusTime(final int salary, final boolean bonus){
        return bonus? "$" + Integer.toString(salary * 10): "$" + Integer.toString(salary);
    }

    //№10 Берем массив слов, объединяем их в предложение и возвращаем
    public String smash(String... words){
        return String.join(" ", words);
    }
}
