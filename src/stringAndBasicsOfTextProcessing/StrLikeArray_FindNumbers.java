package stringAndBasicsOfTextProcessing;
/*
В строке найти количество чисел.
 */

public class StrLikeArray_FindNumbers {
    public static void main(String[] agrs) {
        String str = "sdfsd4sdfds5sdfs7sdfs9sdfs7sfds6sfs1sfd312sdfsdf";
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String str2 = str;
        String firstLetter;
        String secontLetter;
        int count = 0;

        //имея массив цифр ищем каждую из них в тсроке и заменяем на пусто
        for (int i = 0; i < numbers.length; i++) {
            if (str2.indexOf(numbers[i]) > 0) {
                str2 = str2.replace(numbers[i], " ");
            }
        }

        for (int i = 0; i < str2.length()-1; i++) {
          firstLetter = String.valueOf(str2.charAt(i));
          secontLetter = String.valueOf(str2.charAt(i+1));
          // если текущий символ пробел а следующий нет (тоесть число закончилось то счетчик ++
          if (firstLetter.equals(" ")) {
              if ( !secontLetter.equals(" ")) count++;
          }
        }

        System.out.println("Исходная строка - " + str);
        System.out.println("Количество чисел в строке  - " + count);

    }
}
