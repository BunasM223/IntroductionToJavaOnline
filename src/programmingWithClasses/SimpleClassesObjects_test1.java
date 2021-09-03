package programmingWithClasses;
/*
Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
наибольшее значение из этих двух переменных.
 */

import java.util.Random;

public class SimpleClassesObjects_test1 {
    public static void main(String[] agrs) {
        int a = 7;
        int b = 9;
        /*вывод на экран*/
        showDeskop("Первое число - ",a);
        showDeskop("Второе число - ",b);

        /*меняем переменные*/
        a = changeNumber(a);
        b = changeNumber(b);
        showDeskop("Первое число - ",a);
        showDeskop("Второе число - ",b);

        /*сумма переменных*/
        int s = sumNumbers(a,b);
        showDeskop("Сумма чисел - ",s);

        /*большее из чисел */
        int bigNum = biggerNumber(a,b);
        if (bigNum == 0 ) showDeskop("числа равны. результат сравнения -  ", bigNum );
        else showDeskop("Большее число " , bigNum);

    }
    /*метод выводв нв экра*/
    public static void showDeskop(String m, int n){
        System.out.println(m + n);
    }



    /*метод изменнения переменной*/
    public static Integer changeNumber(int n){
        Random random = new Random();
        int k = n + random.nextInt(100);
        return k;
    }

    /*метод нахождения суммы переменной*/
    public static Integer sumNumbers(int a, int b){
        int k = b + a;
        return k;
    }

    /*метод нахождения суммы переменной*/
    public static Integer biggerNumber(int a, int b){
        if (a > b) return a;
        else if (a < b) return b;
             else return 0;
    }
}
