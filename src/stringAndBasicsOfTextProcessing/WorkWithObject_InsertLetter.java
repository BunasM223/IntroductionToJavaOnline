package stringAndBasicsOfTextProcessing;
/*
В строке вставить после каждого символа 'a' символ 'b'.
 */

public class WorkWithObject_InsertLetter {
    public static void main(String[] agrs) {
        String str = "sdfsda4sdf ds5sdafs7s dfs9a dfs7sf as6sfs 1sfd312s  dfsdf a ";
        String str2 = str;

        System.out.println("Исходная строка    -" + str2 );
        str2 = str.replace("a","ab");
        System.out.println("Новая строка       -" + str2 );


    }
}
