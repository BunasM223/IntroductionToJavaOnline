package stringAndBasicsOfTextProcessing;
/*
Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
 */
public class WorkWithObject_CountA {
    public static void main(String[] agrs) {
        String str = "sdfsd4sd fdsa5sdf s7sadfs9s dfas7sfds6 safs a sfd31 sdfsdf";
        String str2 = str;
        String letter;
        int count = 0;

        for (int i = 0; i < str2.length(); i++) {
            letter = String.valueOf(str2.charAt(i));

            if (letter.equals("a")) {
                count++;
            }
        }

        System.out.println("Исходная строка - " + str);
        System.out.println("Количество букв а в строке  - " + count);

    }
}
