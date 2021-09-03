package stringAndBasicsOfTextProcessing;
/*
Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
Крайние пробелы в строке удалить.
 */
public class StrLikeArray_DeleteSpaces {
    public static void main(String[] agrs) {
        String str = " sdfsd4sdf  ds5sdfs7s dfs9s  dfs7sf    ds6sfs 1sfd312sdfsdf ";
        String str2 = str;
        String a;
        String b;
        int count = 0;
        int m;

        //удаление пробелов в начале и конце
        System.out.println("Исходная строка    -" + str2 + "-");
        str2 = str2.trim();
        System.out.println("Строка после трима -" + str2 + "-");

        for (int i = 0; i < str2.length()-1; i++) {
            a = String.valueOf(str2.charAt(i));
            b = String.valueOf(str2.charAt(i+1));

            if (a.equals(" ")) {
                // если текущий символ пробел и следующий тоже, то цикл со счетчиком по строке начисная с i+1, пока не дойдём до следующего не пробела
                // последним символом пробел не может быть так как  перед циклом тримнули
                if ( b.equals(" ")) {
                    m = i+1;
                    while (String.valueOf(str2.charAt(m)).equals(" ")){
                        m++;
                    }
                    str2 = str2.substring(0,i+1) + str2.substring(m+2);
                }
            }
        }


        System.out.println("Строка только с единичными пробелами -" + str2);

    }
}