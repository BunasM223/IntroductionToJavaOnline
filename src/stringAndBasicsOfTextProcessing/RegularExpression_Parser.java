package stringAndBasicsOfTextProcessing;
/*
Дана строка, содержащая следующий текст (xml-документ):
<notes>
 <note id = "1">
 <to>Вася</to>
 <from>Света</from>
 <heading>Напоминание</heading>
 <body>Позвони мне завтра!</body>
 </note>
 <note id = "2">
 <to>Петя</to>
 <from>Маша</from>
 <heading>Важное напоминание</heading>
 <body/>
 </note>
</notes>
Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
нельзя.
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression_Parser {
    public static void main(String[] agrs) {

        String str = "<notes>\n" +
                       " <note id = \"1\">\n" +
                         " <to>Вася</to>\n" +
                         " <from>Света</from>\n" +
                         " <heading>Напоминание</heading>\n" +
                         " <body>Позвони мне завтра!</body>\n" +
                       " </note>\n" +
                       " <note id = \"2\">\n" +
                         " <to>Петя</to>\n" +
                         " <from>Маша</from>\n" +
                         " <heading>Важное напоминание</heading>\n" +
                         " <body/>\n" +
                       " </note>\n" +
                     "</notes>";
        String ch;
        String tmpStr = "";
        int start ;
        int end;
        int l = 1;
        ArrayList<String> A = new ArrayList<String>();
        System.out.println("Исходный тьекст:");
        System.out.println(str);

        A = tags(str);
        System.out.println("Массив Тэгов:");
        for (String elem : A) {
            System. out. printf(elem + " ");
        }

        System.out.println();

        Pattern p = Pattern.compile("note id");
        Pattern k = Pattern.compile("/note>");
        Matcher m = p.matcher(str);
        Matcher n = k.matcher(str);
        while (m.find() && n.find()) {
            start = m.end();
            end = n.start();
            System.out.println("Message " + l);
            writecontecst(A,str.substring(start,end));
            l++;
        }

    }

    /*метод получения тэгов */
    public static ArrayList<String> tags (String str){
        String ch;
        String ch1;
        String tmp;
        String tempWord = "";
        boolean flagEndTeg = false;
        boolean flagWrite = true;
        ArrayList<String> tags =  new ArrayList<String>();
        boolean a = false;
        for (int i = 0;i<str.length()-1;i++){
            a = false;
            ch = String.valueOf(str.charAt(i));
            tmp = String.valueOf(str.charAt(i+1));
            if (ch.matches("^[<]+$")){
                /*не завершающий тэг*/
                if (ch.matches("^[<]+$") && tmp.matches("^[/]+$")) {
                    flagEndTeg = false;
                } else {
                    flagEndTeg = true;
                    continue;
                }
                //continue;
            }

            tempWord = "";
            if (flagEndTeg) {
                while (!a){
                    ch1 =  String.valueOf(str.charAt(i));
                    a = ch1.matches("^[>]+$");
                    if (!a) {tempWord += ch1;
                    i++;}

                }
                /*если такой тэг уже есть то пропускаем его*/
                for (int j = 0;j<tags.size();j++) {
                    if (tags.get(j).equals(tempWord)) {
                        flagWrite = false;
                    }
                }
                if (flagWrite) tags.add(tempWord);
                flagEndTeg = false;
            }

        }
        return tags;
    }
    /*метод чтения содержимого тэгов*/
    public static void writecontecst (ArrayList<String> Array, String Str ){
        int start ;
        int end;
        for (int i = 0;i < Array.size();i++){

            Pattern p = Pattern.compile("<" + Array.get(i) + ">");//начало тэга
            Pattern k = Pattern.compile("</" + Array.get(i) + ">"); //окончание тэга
            Pattern g = Pattern.compile("<" + Array.get(i) + "/>"); //пустой тэг
            Matcher m = p.matcher(Str);
            Matcher n = k.matcher(Str);
            Matcher t = g.matcher(Str);
            while (m.find() && n.find()) {
                start = m.end();
                end = n.start();
                System.out.println(Array.get(i) + " " + Str.substring(start,end));
            }
            while (t.find()) {
                start = t.start();
                end = t.end();
                System.out.println(Str.substring(start,end) + " - Пустое сообщение!");
            }

        }

    }
}
