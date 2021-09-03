package stringAndBasicsOfTextProcessing;
/*
С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
 */

public class WorkWithObject_Cake {
    public static void main(String[] agrs) {
        String str = "информатика";
        String str2 = "торт";
        String a = "";
        String b = "";

        System.out.println("Исходная строка1    - " + str);
        System.out.println("Исходная строка2    - " + str2);

        //создам новую строку равную исходной но с сиволами в обратном порядке
        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0;j < str.length(); j++){
                if (String.valueOf(str.charAt(j)).equals(String.valueOf(str2.charAt(i)))){
                    a+=String.valueOf(str.charAt(j));
                    break;
                }
            }

        }

        if (a.equals(str2)) System.out.println("Из слова - " + str + " Можно составить слово - " + a);
        else System.out.println("Из слова - " + str + " невозможно составить слово - " + a);

    }

}
