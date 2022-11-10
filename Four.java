import java.util.Arrays;

public class Four {
    //№1 Учитывая случайное неотрицательное число, вернуть цифры этого числа в массиве в обратном порядке
    public int[] digitize(long n){
        String str = Long.toString(n);
        StringBuffer bf = new StringBuffer(str);
        bf.reverse();
        int[] num = new int[bf.length()];
        for(int i = 0; i < bf.length(); i++){
            num[i] = bf.charAt(i) - '0';
        }
        return num;
    }

    //№2 Вернуть время с полуночи в миллисекундах
    public int past(int h, int m, int s){
        return (h <= 60 && m <= 60 && s <= 60 && h >= 0 && m >= 0 && s>= 0)?((h * 3600) + (m * 60) + s)*1000: 0;
    }

    //№3 Принимаем массив, вернуть массив с обратными элементами
    public int[] invert(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] *= -1;
        }
        return array;
    }

    //№4 х умножить на у, если кто-то меньше 0 - вернуть 0
    public int multi(int n, int m){
        return n < 0 || m < 0? 0: n * m;
    }

    //№5 Вычислить среднее значение в массиве. пустые массивы возвращают 0
    public double findAverage(int[] array){
        double avg = 0;
        for(int i: array) avg += i;
        return avg/ array.length;
    }

    //№6 ПРоверить содержит ли массив заданное число
    public boolean check(Object[] a, Object x){
        for(int i = 0; i < a.length; i++){
            if(a[i] == x) return true;
        }
        return false;
    }

    //№7 Дано число, массив. Если среднее значение массива больше числа вернуть истину
    public boolean betterThanAverage(int[] classPoints, int yourPoints){
        return Arrays.stream(classPoints).average().orElse(0) < yourPoints;
    }

    //№8 Создать метод, который возвращает массив целых чисел от х до 1, где х больше 0
    public int[] reverse(int n){
        int g = -1;
        int[] arr = new int[n];
        for(int i = arr.length; i > 0; i--){
            g += 1;
            arr[g] = i;
        }
        return arr;
    }

    //№9 Принимаем 2 числа, если они оба четны/нечетные - ернуть ложь
    public boolean isLove(final int flower1, final int flower2){
        return flower1 % 2 != flower2 % 2;
    }

    //№10 Перевернуть все слова в переданной строек
    public String reverseWords(String str){
        String[] words = str.split(" ");
        int n = words.length;
        String temp;

        for(int i = 0; i < n/2; i++){
            temp = words[n-i-1];
            words[n-i-1] = words[i];
            words[i] = temp;
        }
        return String.join(" ", words);
    }
}
