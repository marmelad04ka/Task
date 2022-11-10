import java.util.Arrays;

public class Nine {
    //№1 Дан ряд 1/1 + 1/4 + 1/7 + 1/х. Вернуть сумму ряда до х (после запятой 2 знака)
    public String seriesSum(int n){
        double sum = 0;
        for(double i = 1; i < n * 3; i += 3) sum = (1/i) + sum;
        return String.format("%.2f", sum);
    }

    //№2 Вернуть минимальное и максимальное число из массива как массив
    public int[] minMax(int[] arr){
        int[] minMax = new int[2];
        minMax[0] = Arrays.stream(arr).min().getAsInt();
        minMax[1] = Arrays.stream(arr).max().getAsInt();
        return minMax;
    }

    //№3 На входе боец1, боец2 и кто начинает бой, вывести победителя
    //Доп класс
    public class Fighter{
        public String name;
        public int healt, damagePerAttack;
        public Fighter(String name, int healt, int damagePerAttack){
            this.name = name;
            this.healt = healt;
            this.damagePerAttack = damagePerAttack;
        }
    }

    public String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker){
        boolean fight = true;
        if(firstAttacker == fighter1.name){
            while(fight){
                fighter2.healt = fighter2.healt - fighter1.damagePerAttack;
                if(fighter2.healt <= 0) return fighter1.name;

                fighter1.healt = fighter1.healt - fighter2.damagePerAttack;
                if(fighter1.healt <= 0) return fighter2.name;
            }
        } else if (firstAttacker == fighter2.name) {
            while(fight){
                fighter1.healt = fighter1.healt - fighter2.damagePerAttack;
                if(fighter1.healt <= 0) return fighter2.name;

                fighter2.healt = fighter2.healt - fighter1.damagePerAttack;
                if(fighter2.healt <= 0) return fighter1.name;
            }
        }
        return "no attacker";
    }

    //№4 Дано начальное население города, конечное, среднее прибывание людей в город, процент прироста людей за год.
    // Посчитать за сколько лет начальное население превысит конечное.
    public int nbYear(int p0, double percent, int aug, int p){
        double startPeople = p0, avgSum = aug, endPeople = p;
        int count = 0;
        while (startPeople < endPeople){
            count += 1;
            startPeople = startPeople + (startPeople * percent * 0.01) + avgSum;
        }
        return count;
    }

    //№5 Даны 2 массива х и у. Удалить из массива х все значения у
    public int[] arrayDiff(int[] a, int[] b){
        if(b.length == 0 || a.length == 0) return a;
        int[] newArr = null, postArr = {};
        for(int q = 0; q < b.length + 1; q++){
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < b.length; i++){
                    if(a[i] == b[j]){
                        newArr = new int[a.length - 1];
                        for(int index = 0; index < i; index++) newArr[index] = a[index];
                        for(int d = i; d < a.length - 1; d++) newArr[d] = a[d + 1];
                        a = newArr;
                        break;
                    }
                }
            }
            if(a.length == 0) return postArr;
        }
        return newArr;
    }

    //№6 Найти положительное целое число k, если оно существует, такое, что сумма цифр n, взятых в последовательных степенях p, равна k * n. Иначе вернуть -1
    public int bbb(int n, int p){
        double num = 0;
        int count = -1;
        int[] arr = Integer.toString(n).chars().map(c -> c - '0').toArray();
        for(int i = 0; i < (arr.length + p); i++){
            count += 1;
            num = Math.pow(arr[count], 1) + num;
        }
        return num/n%1 == 0? (int) num/n: -1;
    }

    //№7 Перевести десятичное число в двоичное и посчитать кол-во 1
    public static int countBits(int num){
        String strFull = Integer.toString(num, 2);
        String strNonOne = strFull.replace("1", "");
        return Integer.parseInt(String.valueOf(strFull.length() - strNonOne.length()));
    }

    //№8 Дано предложение: is2 Thi1s T4est 3a.
    // Вернуть Thi1s is2 3a T4est (предложения могут быть любыми, в словах всегда есть цифры).
    public static String order(String words){
        String[] strArrold = words.split(" ");
        String[] strArrNew = new String[strArrold.length];
        for(int i = 0; i < strArrold.length; i++){
            for(int j = 0; j <= 9; j++) {
                if (strArrold[i].contains(Integer.toString(j))) strArrNew[j-1] = strArrold[i];
            }
        }
        return words.length() == 0? "":String.join(" ", strArrNew);
    }
    //№9 Перевернуть все слова длина которых больше 5
    public static String spinWords(String words){
        String[] strArr = words.split(" ");
        for(int i = 0; i < strArr.length; i++){
            if(strArr[i].length() >= 5) strArr[i] = new StringBuffer(strArr[i]).reverse().toString();
        }
        return String.join(" ", strArr);
    }

    //№10 Учитывая массив целых чисел nums и целочисленную число, вернуть индексы двух чисел так,
    // чтобы их сумма была равна числу
    public int[] twoSum(int[] nums, int target){
        int[] timeless = new int[2], newArr = null;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            count = target - nums[i];
            newArr = new int[nums.length - 1];
            for(int index = 0; index < i; index++) newArr[index] = nums[index];
            for(int d = i; d < nums.length - 1; d++) newArr[d] = nums[d + 1];

            for(int j = 0; j < newArr.length; j++){
                if(newArr[j] == count){
                    timeless[0] = i;
                    timeless[1] = j;
                }
            }
        }
        return timeless;
    }
}
