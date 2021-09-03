package programmingWithClasses;
/*
 Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
заданное количество часов, минут и секунд.
 */

import java.util.Scanner;

public class WathTime {
    int hh;
    int mm;
    int ss;

    public int getHh() {
        return hh;
    }

    public int getMm() {
        return mm;
    }

    public int getSs() {
        return ss;
    }

    public void setHh(int hh) {
        this.hh = hh;
    }

    public void setMm(int min) {
        int mmTmp;
        int hhTmp;
        mmTmp = mm;
        mmTmp += min;

        if (mmTmp >= 60) {
            hhTmp = hh;
            hhTmp += mmTmp / 60;
            //hh = hhTmp;
            mmTmp = mmTmp % 60;
            setHh(hhTmp);
        }
        this.mm = mmTmp;
    }

    public void setSs(int sec) {
        int mmTmp;
        int ssTmp = ss;
        ssTmp += sec;

        if (ssTmp >= 60) {
            mmTmp = mm;
            mmTmp += (ssTmp / 60);
            setMm(mmTmp);
            ssTmp = (ssTmp % 60);
        }
        this.ss = ssTmp;
    }
}

class Main5{
    public static void main(String[] agrs) {
        int k;
        WathTime time = new WathTime();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите колличесвто секунд");

        if (sc.hasNextInt()){
            k = sc.nextInt();
            if (k < 0){
                System.out.println("Введите Значение меньше нуля");
            } else{
                time.setSs(k);
            }
        }else{
            System.out.println("введено не верное значение секунд");
        }
        sc.close();

        System.out.println("Время в формате НН:ММ:ЫЫ - " + time.getHh() + ":" + time.getMm() + ":" + time.getSs() );

    }
}

