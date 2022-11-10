public class Two {
    //№1 Вернуть строку повторяющуюся х раз
    public String repeatString(final int repeat, final String string){
        return string.repeat(repeat);
    }

    //№2 удалить пробелы из строки
    public String noSpace(final String x){
        return x.replace(" ", "");
    }

    //№3 Найти сумму всех чисел от 1 до х, х > 0
    public int summation(int n){
        int num = 0;
        for (int i = 0; i <= n; i++){
            num += i;
        }
        return num;
    }

    //№4 Возвести в квадрат все числа от 1 до х, и суммировать их
    public int squareSum(int[] n){
        int sum = 0;
        for(int i: n){
            sum += i * i;
        }
        return sum;
    }

    //№5 Найти наименьшее целое число в массиве
    public int findSmallestInt(int[] args){
        int min = args[0];
        for(int i: args){
            if(min > i) min = i;
        }
        return min;
    }

    //№6 Посчитать количество Истина в массиве
    public int countSheeps(boolean[] arrayOfSheeps){
        int count = 0;
        for(Boolean present: arrayOfSheeps){
            if(present != null && present) count += 1;
        }
        return count;
    }

    //№7 К какому веку относится год
    public int century(int number){
        int count = 0;
        for(int i = 1; i <= number + 99; i++){
            if(i%100 == 0) count += 1;
        }
        return count;
    }

    //№8 Проверить делится число на 2 других числа
    public boolean isDivisible(long n, long x, long y){
        return (n%x == 0) && (n%y == 0);
    }

    //№9 Чед пьет воды 0,5л/ч, посчитать кол-во литров воды, которое выпьет человек за х часов
    public int liters(double time){
        return (int) time/2;
    }

    //№10 Созать метод, который выполняет 4 арефм. операции
    public int basicMath (String op, int v1, int v2){
        switch(op){
            case "+":
                return v1 + v2;
            case "-":
                return v1 - v2;
            case "*":
                return v1 * v2;
            case "/":
                return v1 / v2;
        }
        return  0;
    }
}
