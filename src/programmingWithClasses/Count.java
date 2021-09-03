package programmingWithClasses;
/*
Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
 */

import java.util.Random;

public class Count {
    private double count;

    public Count (){
        this.count = ServisCount.setDefalt(getCount());
    }

    /*если значение счетчика = 0, геттер возвращает значение по умолчанию*/
    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

}

class ServisCount{

    /*увеличение счетчика в диапозоне*/
    static void incrementInDiaposon(Count count, int a, int b) {
        int start;
        int end;
        /*диапозон на увеличение*/
        if (a < b) {
            start = a;
            end = b;
        } else {
            start = b;
            end = a;
        }
        /*+1 в диапазоне*/
        for (int i = start;i <= end;i++){
            ServisCount.increment(count);
        }
    }
    /*уменьшение счетчика в диапозоне*/
    static  void decrementIndiaposon(Count count, int a, int b) {
        int start;
        int end;
        /*диапозон на увеличение*/
        if (a < b) {
            start = a;
            end = b;
        } else {
            start = b;
            end = a;
        }

        for (int i = start;i <= end;i++){
           ServisCount.decrement(count);
        }
    }

    /*метод установки рандомного значения */
    static void setRandom (Count count){
        Random random = new Random();
        count.setCount(count.getCount() + random.nextInt(1000));
    }

    /*метод установки рандомного значения */
    static double setDefalt(double count) {
        if (count == 0.0) {
            count = 7;
        }
        return count;
    }

    static void increment (Count count){
        count.setCount(count.getCount() + 1);
    }

    static void decrement (Count count){
        count.setCount(count.getCount() - 1);
    }


}
class Main4 {

    public static void main(String[] agrs) {
        Count count = new Count();
        Count count2 = new Count();
        Count count3 = new Count();
        int a = 2;
        int b = 10;
        /*инкримент счетчика*/
        count.setCount(25);
        System.out.println("Начальное значение счетчика  - " + count.getCount());
        System.out.println("Диапозон  - от  " + a + " до " + b );
        ServisCount.incrementInDiaposon(count,2,10);
        System.out.println("Значение счетчика при '+1' в диапазане [" + a + "," + b + "] - " + count.getCount());

        /*декремент счетчика*/
        count2.setCount(25);
        System.out.println("Начальное значение счетчика  - " + count2.getCount());
        System.out.println("Диапозон  - от  " + a + " до " + b );
        ServisCount.decrementIndiaposon(count2,2,10);
        System.out.println("Значение счетчика при '-1' в диапазане [" + a + "," + b + "] - " + count2.getCount());

        /*рандомное значение счетчика */
        System.out.println("Начальное значение счетчика  - " + count3.getCount());
        ServisCount.setRandom(count3);
        System.out.println("рандомное значение счетчика в диапазоне от 0 до 1000 - " + count3.getCount());
    }
}