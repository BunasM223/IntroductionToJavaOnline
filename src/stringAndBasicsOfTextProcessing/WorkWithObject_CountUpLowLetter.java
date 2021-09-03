package stringAndBasicsOfTextProcessing;
/*
Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские буквы.
 */
public class WorkWithObject_CountUpLowLetter {
    public static void main(String[] agrs) {
        String str = "aaaAAA ddDФD";
        int countUp = 0;
        int countLw = 0;
        String st ;
        char cht;

        for (int i = 0; i<str.length(); i++) {
            st = String.valueOf(str.charAt(i));
            cht = str.charAt(i);
            /*проверка на только английские буквы */
            if (st.matches("^[A-Za-z]+$")){
                if (Character.isUpperCase(cht)) countUp++;
                else countLw++;
            }
        }
        System.out.println("В строке - " + str );
        System.out.println(" заглавных букв английского алфавита - " + countUp + " и маленьких  - " + countLw);
    }
}
