package stringAndBasicsOfTextProcessing;
/*
    Замените в строке все вхождения 'word' на 'letter'
 */
public class StrLikeArra_ReplaseWord {
    public static void main(String[] agrs) {
        String str = "jkdskjword knjl;nv;zn jjfb  word kdf;x wordmnjkxncv";//просто строка
        String[] str2 = str.split(" ");//строка как массив
        str = str.replace("word","letter");
        for (int i=0;i<str2.length;i++){
            str2[i] = str2[i].replace("word","letter");
        }
        System.out.println(str);

        for (String elem : str2) {
            System. out. printf(elem + " ");
        }
        System.out.println();

    }
}
