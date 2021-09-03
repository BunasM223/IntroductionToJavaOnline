package stringAndBasicsOfTextProcessing;
/*
Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
def", то должно быть выведено "abcdef".
 */
public class WorkWithObject_DelRepeatSymbols {
    public static void main(String[] agrs) {
        String str = "sdfsd4sd fdsa5sdf s7sadfs9s dfas7sfds6 safs a sfd31 sdfsdf";
        //sdf4a579631 - правилный результат
        String ыек2 = str;
        String letter ;
        int i = 0;
        int lenth = ыек2.length();


        while  (i != (lenth-1)) {
            letter = ыек2.substring(i,i+1);
            if (letter.equals(" ")) i--; //если будет пробел, то дописывать не будем а просто удлим его
            ыек2 = ыек2.substring(0,i+1) + delSymbols(ыек2.substring(i+1),letter);
            i++;
            lenth = ыек2.length();

        }

        //sdf4a579631
        System.out.println("Исходная строка - " + str);
        System.out.println("Строка без повторяющихся символов - " + ыек2);

    }
    //метод удаления символов
    public static String delSymbols (String str, String letter){
        String tempStr = str;
        tempStr = tempStr.replace(letter,"");

        return tempStr;
    }
}


