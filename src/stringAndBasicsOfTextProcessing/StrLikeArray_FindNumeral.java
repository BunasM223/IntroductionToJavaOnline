package stringAndBasicsOfTextProcessing;
/*
В строке найти количество цифр
 */
public class StrLikeArray_FindNumeral {
    public static void main(String[] agrs) {
        String str = "sdfsd4sdfds5sdfs7sdfs9sdfs7sfds6sfs1sfd312sdfsdf";
        String str2 = str;
        int countNumbers;
        //int occurrencesCount = testString.length() - testString.replace(",", "").length();
        String [] numbers = {"1" ,"2","3","4","5","6","7","8","9"};

        //имея массив цифр ищем каждую из них в тсроке и заменяем на пусто
        for (int i =0;i < numbers.length; i++) {
            str2 =str2.replace(numbers[i],"");
        }
        countNumbers = str.length() - str2.length();
        System.out.println("Исходная строка - " + str);
        System.out.println("новая    строка - " + str2);
        System.out.println("Количество цифр в строке  - " + countNumbers);

    }
}
