public class Six {
    //№1 Камень, ножницы, бумага
    public String rps(String p1, String p2){
        if(p1 == "Scissors" && p2 == "Paper" || p1 == "Paper" && p2 == "Rock" || p1 == "Rock" && p2 == "sciors") return "Player 1 won!";
        else if (p1 == p2) return "Draw!";
        else return "Player 2 won!";
    }

    //№2 Метод разбивает строку и возвращает массив слов
    public String[] stringToArray(String s){
        return s.split(" ");
    }

    //№3 Найти среднее значение трех баллов и вернуть буквенное значение
    public char getGrade(int s1, int s2, int s3){
        int avgScore = (s1 + s2 + s3)/3;

        return avgScore >= 90? 'A': avgScore >= 80? 'B': avgScore >= 70? 'C': avgScore >= 60? 'D':'F';
    }

    //№4 Удалить все ! из строки
    public String removeExclamationMarks(String s){
        return s.replaceAll("!", "");
    }

    //№5 Вернуть количество гласных в строке
    public int getCount(String str){
        return str.replaceAll("[^aeiou]", "").length();
    }

    //№6 Удалить все гласные в строке
    public String dixemvowel(String str){
        return str.replaceAll("[aeiou]", "");
    }

    //№7 Вернуть сумму всех чисел кратных 3 или 5, меньше переданного числа
    public int solution(int number){
        int sum = 0;
        if(number < 0) return 0;
        for(int i = 1; i < number; i++){
            if(i%3 == 0 || i%5 == 0) sum += i;
        }
        return sum;
    }

    //№8 Принимаем массив, содержащий имена людей, которым понравился элемент
    // вернуть текст
    public String whoLikeIt(String... names){
        switch(names.length){
            case 0: return "no one like this";
            case 1: return String.format("%s like this", names[0]);
            case 2: return String.format("%s and %s like this", names[0], names[1]);
            case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
            default: return String.format("%s, %s and %d other like this", names[0], names[1], names.length - 2);
        }
    }

    //№9 Сделать номер телефона из массива цифр
    public String createPhoneNumber(int[] numbers){
        return String.format("(%s%s%s) %s%s%s - %s%s%s%s", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);
    }

    //№10 Найти четное/нечетное число в массиве, который состоит полностью из четных/нечетных чисел
    public int find(int[] integer){
        int sum = integer[0] + integer[1] + integer[2];
        for(int i = 0; i <integer.length; i++){
            for(int j = 0; j <= 3; j++){
                if(integer[0]%2 == 0 && integer[1]%2 == 0 && integer[2]%2 == 0){
                    if(integer[i]%2 != 0) return integer[i];
                } else if (integer[0]%2 != 0 && integer[1]%2 != 0 && integer[2]%2 != 0) {
                    if(integer[i]%2 == 0) return integer[i];
                } else if (sum%2 == 0) {
                    if(integer[j]%2 == 0) return integer[j];
                } else if (sum%2 != 0) {
                    if(integer[j]%2 != 0) return integer[j];
                }
            }
        }
        return 0;
    }
}
