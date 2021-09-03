package stringAndBasicsOfTextProcessing;

/*
Из заданной строки получить новую, повторив каждый символ дважды.
 */
public class WorkWithObject_DoobleLetter {
    public static void main(String[] agrs) {
        String str = "sdfsd4sd fdsa5sdf s7sadfs9s dfas7sfds6 safs a sfd31 sdfsdf";
        String str2 = "";
        String letter ;
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 2; j++) {
                str2 += String.valueOf(str.charAt(i));
            }
        }

        System.out.println("Исходная строка - " + str);
        System.out.println("Строка в которой каждый символ повторяется дважды  - " + str2);

    }
}
