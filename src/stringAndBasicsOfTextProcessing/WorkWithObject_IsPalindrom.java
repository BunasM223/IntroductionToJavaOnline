package stringAndBasicsOfTextProcessing;
/*
Проверить, является ли заданное слово палиндромом
 */

public class WorkWithObject_IsPalindrom {
    public static void main(String[] agrs) {
        String str = "asdfgfdsa";
        String str2 = "asdffdsa";
        String a = "";
        String b = "";

        System.out.println("Исходная строка1    - " + str);
        System.out.println("Исходная строка2    - " + str2);

        //создам новую строку равную исходной но с сиволами в обратном порядке
        for (int i = str.length() - 1; i >= 0; i--) {
            a += String.valueOf(str.charAt(i));
        }

        if (a.equals(str)) System.out.println("Строка  - " + str + " - палиндром");
        else  System.out.println("Строка  - " + str + " - не палиндром");

        for (int i = str2.length() - 1; i >= 0; i--) {
            b += String.valueOf(str2.charAt(i));
        }

        if (b.equals(str2)) System.out.println("Строка  - " + str2 + " - палиндром");
        else  System.out.println("Строка   - " + str2 + " - не палиндром");

    }
}

