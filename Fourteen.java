public class Fourteen {
    //№1 Посчитать количество чисел, в которых нет 5.
    // https://www.codewars.com/kata/5813d19765d81c592200001a/java
    public static int dontGiveMeFive(int start, int end) {
        int count = 0;
        for(int i = start; i <= end; i++){
            count += 1;
            int[] arr = Integer.toString(i).chars().map(c -> c - '0').toArray();
            for(int j = 0; j < arr.length; j++){
                if(arr[j] == 5) {
                    count -= 1;
                    break;
                }
            }
        }
        return count;
    }

    //№2 Найти слово в тексте, которое встречается чаще всего
    public static String mostFrequentWord(String str) {
        str = str.replaceAll("[^a-zA-z ]", "");
        String[] strArr = str.split(" ");
        int count = 0, max = 0;
        String strNew = "", notSingle = "In this sentence, the word '%s' occurs most times (%s)", allSingle = "all words single";
        for(int i = 0; i < strArr.length; i++){
            if(strArr[i].equals("")) continue;
            for(int j = 0; j < strArr.length; j++) if(strArr[i].equals(strArr[j])) count += 1;
            if(count > max) {
                strNew = strArr[i];
                max = count;
            }
            count = 0;
        }
        return max == 1? allSingle: String.format(notSingle, strNew, max);
    }

    //№3
    //№4
    //№5
    //№6
    //№7
    //№8
    //№9
    //№10
}
