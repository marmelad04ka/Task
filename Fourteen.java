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

    //№2
    //№3
    //№4
    //№5
    //№6
    //№7
    //№8
    //№9
    //№10
}