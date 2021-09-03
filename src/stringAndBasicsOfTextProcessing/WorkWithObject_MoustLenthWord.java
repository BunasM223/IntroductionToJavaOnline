package stringAndBasicsOfTextProcessing;
/*
Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
длинных слов может быть несколько, не обрабатывать.
 */
public class WorkWithObject_MoustLenthWord {
    public static void main(String[] agrs) {
        String str = "word6 word67  word678 word6789112 word6789  word67890 word678911";

        int count = 0;
        int size = 0;
        int position = 0;
        for (int i = 0; i < str.length(); i++) {

            if (!String.valueOf(str.charAt(i)).equals(" ")) {
                count++;
            } else {

                if (size < count) {
                    size = count;
                    position = i - count;
                }
                count = 0;
            }
            //обработка окончания строки (последнего слова)
            if (((i+1) == str.length()) && (!String.valueOf(str.charAt(i)).equals(" "))){

                if (size < count) {
                    size = count;
                    position = i - count + 1;
                }
            }
        }
        System.out.println("Самое длинное слово - " + str.substring(position, size+position));
    }
}
