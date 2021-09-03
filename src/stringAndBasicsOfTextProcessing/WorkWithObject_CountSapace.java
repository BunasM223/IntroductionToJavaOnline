package stringAndBasicsOfTextProcessing;
/*
Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
 */

public class WorkWithObject_CountSapace {
    public static void main(String[] agrs) {
        String str = "        sdfsd4sdf  ds5sdfs7s dfs9s  dfs7sf    ds6sfs 1sfd312s       dfsdf               ";
        String str2 = str;
        String a;
        String b;
        int count;
        int countSpases = 0;
        int m;

        System.out.println("Исходная строка    -" + str2 + "-");

        for (int i = 0; i < str2.length()-1; i++) {
            a = String.valueOf(str2.charAt(i));
            b = String.valueOf(str2.charAt(i+1));
            count = 0;
            if (a.equals(" ")) {
                count++;
                // если текущий символ пробел и следующий тоже, то цикл со счетчиком по строке начисная с i+1, пока
                // не дойдём до следующего не пробела или окончания строки

                if ( b.equals(" ")) {
                    m = i+1;
                    while (String.valueOf(str2.charAt(m)).equals(" ")){
                        m++;
                        count++;
                        if (m == str2.length()) break;
                    }
                }
            }
            if (countSpases < count) countSpases = count;
        }

        System.out.println("Максимальное колличество подряд идущих пробелов - " + countSpases);

    }
}
