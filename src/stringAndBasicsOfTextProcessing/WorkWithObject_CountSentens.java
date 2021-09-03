package stringAndBasicsOfTextProcessing;
/*
Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным знаком. Определить количество предложений в строке X.
 */
public class WorkWithObject_CountSentens {
    public static void main(String[] agrs) {


        String str = "asddda jflkvvb  jfdhldn  jdsfn  hsunnnj dfdfdsdsfs. jhlhlzxbvchbobaew! kznjdsnvjnjnbjb? jhlkslzxbvchbpoblbhbd. jhvczygo! lhhhhsn cxlhhhh vhhh!";
        int count = 0;
        String ch;

        for (int i = 0; i < str.length(); i++) {
            ch = String.valueOf(str.charAt(i));

            /*проверка на окончание предложения*/
            if (ch.matches("^[!.?]+$")) {
                count++;

            }
        }
        System.out.println("В строке - " + str + " " + count + " предложений");
    }
}
