package stringAndBasicsOfTextProcessing;
/*
Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных операции:
отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине; отсортировать лексемы
в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression_SortText {
    public static void main(String[] agrs) {
        String str = "PARAGRAPH1Start jflkvvb jfdhldn bjdsfn hsunnnj dfdsdfdsdsfs kkddskkkddskee ajdsfn. Jhlhlzxbvchbobaew! Kznjdsnvjnjnbjb? Jhlkslzxbvchbpoblbhbd. Jhvczygo! Lhhhhsn cxlhhhh PARAGRAPH1End!\n" +
                     "PARAGRAPH2Start jflkvvb jfdhldn jdsfn hsunnnj dfdfdsdsfs. Jhlhlzxbvchbobaew! Kznjdsnvjnjnbjb? PARAGRAPH2End.\n" +
                     "PARAGRAPH3Start jflkvvb jfdhldn jdsfn hsunnnj dfdfdsdsfs. Jhlhlzxbvchbobaew! Jhvczygo! Lhhhhsn cxlhhhh vhhh!" +
                     "asddda jflkvvb jfdhldn jdsfn hsunnnj dfdfdsdsfs. Jhlhlzxbvchbobaew! Kznjdsnvjnjnbjb? Jhlkslzxbvchbpoblbhbd. Lhvczygo! Mhhhhsn cxlhhhh vhhh!" +
                     "asddda jflkvvb jfdhldn jdsfn hsunnnj dfdfdsdsfs. Jlhlzxbvchbobaew! Kznjdsnvjnjnbjb? Jhlkslzxbvchbpoblbhbd. Lhvczygo! Mhhhhsn cxlhhhh PARAGRAPH3End!" ;
        String ch;
        ArrayList<Integer> numbers ;
        int newNumbers[];
        System.out.println("Исходный тьекст:");
        System.out.println(str);

        //метод возвращет номер абзаца и количество предложений в нем
        numbers = countSentensysParagphs(str);

        //метод который сортирует массив по третьему элементу
        sort(numbers);

        System.out.println();

        //сортировка текста по абзацам по количествву предложений в них
        String sortText1 ="";
        for (int i =2; i< numbers.size();i+=4){
            sortText1 += str.substring(numbers.get(i),numbers.get(i+1)) + "\n";
        }
        System.out.println("Текст отсортированный по количеству прдложений в абзацах");
        System.out.println(sortText1);

        //сортировка слов в предложениях
        int startSentens;
        startSentens = 0;
        String tmpSentens = "";
        String sortText2 = "";
        String sortText3 = "";
        String leksem;
        leksem = "ds";

        for (int i = 0;i<sortText1.length()-1;i++){
            ch = String.valueOf(str.charAt(i));
            if (ch.matches("^[!.?]+$")){
                tmpSentens = str.substring(startSentens,i);
                startSentens = i+1;
                //сортировка текста по колличеству букв
                sortText2 +=sortWords(tmpSentens) + ch + " ";
                //сортировка текста по лексемам
                sortText3 +=sortWordsLeks(tmpSentens,leksem) + ch + " ";
            }
            if (ch.matches("^[\n]+$")){
                sortText2 += ch;
                sortText3 += ch;
                startSentens += 1;
            }
        }
        System.out.println("Текст отсортированный по колличеству букв в словах предложения - ");
        System.out.println(sortText2);

        System.out.println("Текст отсортированный по лексемам - ");
        System.out.println(sortText3);
    }

    //метод сортировки массива по каждому второму элементу и свзязанному с ним первому и теретьему и четвертому
    public static void sort (ArrayList<Integer> num){
        int n = num.size();
        int temp [] = new int[n];
        int max;
        int tmp;
        for (int i = 1; i < num.size(); i+=4) {
            for (int j = 1; j < num.size(); j+=4) {
                if (num.get(i) < num.get(j)) {
                    tmp = num.get(i);
                    num.set(i, num.get(j));
                    num.set(j, tmp);
                    tmp = num.get(i - 1);
                    num.set(i - 1, num.get(j - 1));
                    num.set(j - 1, tmp);
                    tmp = num.get(i + 1);
                    num.set(i + 1, num.get(j + 1));
                    num.set(j + 1, tmp);
                    tmp = num.get(i + 2);
                    num.set(i + 2, num.get(j + 2));
                    num.set(j + 2, tmp);
                }
            }

        }
    }

    //метод котопый возвращает массив по четырем связанным элентам - номер параграфа, количесвто предложений в нем позицию начала и позицию окончания параграфа
    public static ArrayList<Integer> countSentensysParagphs (String str){
        int countSentensys =0;
        int countSentensysP = 0;
        int countParagraphs = 0;
        int tempParagraphs = 0;
        int startElement = 0;

        String ch;
        ArrayList<Integer> strNew = new ArrayList<Integer>();

        for (int i = 0; i<str.length(); i++) {
            ch = String.valueOf(str.charAt(i));
            tempParagraphs = countParagraphs;
            //проверка на окончание предложения//
            if (ch.matches("^[!.?]+$")){
                countSentensys++;
            }
            //проверка на новый абзац//
            if (ch.matches("^[\n]+$")){
                countParagraphs++;
                countSentensysP = countSentensys;
                countSentensys = 0;
            }
            //счётчик параграфов и количества предложений в них
            if (((i+1) == str.length()) && (countSentensys != 0) ){
                countParagraphs++;
                countSentensysP = countSentensys;
            }
            //*если парагрф сменился затусовыывем в массив номер параграфа, количесвто предложений в нем и начала и позицию окончания параграфа*//
            if (tempParagraphs < countParagraphs) {
                strNew.add(countParagraphs);
                strNew.add(countSentensysP);
                strNew.add(startElement);
                strNew.add(i);
                startElement = i + 1;
            }
        }
        return strNew;
    }

    //метод сортировки слов в предложении
    public static String sortWords (String str){
        String[] tempstr = str.split(" ");
        String newStr = "";
        String tempWord;
        for (int i = 0;i < tempstr.length - 1;i++){
            if (tempstr[i].length() > tempstr[i+1].length()){
                tempWord =tempstr[i+1];
                tempstr[i+1] = tempstr[i];
                tempstr[i] = tempWord;
                //если сдвинули слово, то начинаем сначала
                i=-1;
            }
        }
        //в конце каждого слова добавляем по пробелу, если это не окончание предложения
        for (int i = 0;i < tempstr.length;i++){
            if (i != tempstr.length-1) {
                newStr += tempstr[i] + " ";
            } else newStr += tempstr[i];
        }
        return newStr.trim();
    }

    //метод сортировки слов по лексемам
    public static String sortWordsLeks (String str, String leks){

        String[] tempstr = str.split(" ");
        String newStr = "";
        String tempWord;
        Pattern pattern = Pattern.compile("[^" + leks + "]+$");
        Matcher matcher;
        int count = 0;
        int count2 = 0;
        boolean flag;
        int m =0;
        boolean k = false;

        for (int i = 0; i < tempstr.length;i++){
            flag =tempstr[i].matches("\\w*" + leks + "\\w*");
            if (flag){
                tempWord =tempstr[i];
                tempstr[i] = tempstr[m];
                tempstr[m] = tempWord;
                //сортировка по количеству лесем в слове
                if (m != 0){

                   matcher = pattern.matcher(tempstr[m]);
                   while (matcher.find()){
                       count++;
                   }
                    matcher = pattern.matcher(tempstr[m-1]);
                    while (matcher.find()){
                        count2++;
                    }
                    if (count < count2){
                        tempWord =tempstr[m-1];
                        tempstr[m-1] = tempstr[m];
                        tempstr[m] = tempWord;
                    } else if (count == count2) {
                        k = sortWordsALfabet(tempstr[m],tempstr[m-1]);
                        if (k) {
                            tempWord =tempstr[m-1];
                            tempstr[m-1] = tempstr[m];
                            tempstr[m] = tempWord;
                        }
                    }

                }
                m++;
            }
        }
        //в конце каждого слова добавляем по пробелу, если это не окончание предложения
        for (int i = 0;i < tempstr.length;i++){
            if (i != tempstr.length-1) {
                newStr += tempstr[i] + " ";
            } else newStr += tempstr[i];
        }
        return newStr.trim();
    }

    //метод сортировки слов по алфавиту
    public static boolean sortWordsALfabet (String str1, String str2){
        int n = 0;
        char ch1,ch2;

        if (str1.length()<str2.length()){
            n = str1.length();
        }
        else {
            n = str2.length();
        }
        for (int i = 0; i < n ; i++){
            ch1 = str1.charAt(i);
            ch2 = str2.charAt(i);
            if ((byte)ch1 != (byte)ch2){
                if ((byte)ch1 < (byte)ch2){
                return true;
                } else  {
                  return false;
                }
            } else {
                if (i == n -1) return false;
            }
        }
        return false;
    }
}
