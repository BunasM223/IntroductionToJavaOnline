package programmingWithClasses;
/*
Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
назначения должны быть упорядочены по времени отправления.
 */

import java.util.Random;
import java.util.Scanner;

public class Train {
    private String nameStation;
    private int trainNumber;
    private String departTime;

    public Train(String nameStation, int trainNumber, String departTime) {

        this.nameStation = nameStation;
        this.trainNumber = trainNumber;
        this.departTime = departTime;

    }

    public String getNameStation() {
        return nameStation;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getDepartTime() {
        return departTime;
    }

}

class TrainService {
    /*сортироваеп по названиям станций*/
    static void sortNameStation (Train[] train){
        Train tempstr;
        int k;

        for (int i = 0; i < train.length; i++) {
            for (int j = 0; j < i; j++) {
                k = sortWordsALfabet(train[i].getNameStation(), train[j].getNameStation());
                if (k == 1) {
                    tempstr = train[i];
                    train[i] = train[j];
                    train[j] = tempstr;
                } else if (k == 0) {
                    k = sortWordsALfabet(train[i].getDepartTime(), train[j].getDepartTime());
                    System.out.println("Будем сортировать по времени");
                    if (k == 1) {
                        tempstr = train[i];
                        train[i] = train[j];
                        train[j] = tempstr;
                    }
                }
            }
        }

    }
   /*посик запси по номеру поезда*/
    static int findeTrainNumber (Train[] train, int trainNumber){
        for (int i = 0;i < train.length;i++){
            if (train[i].getTrainNumber() == trainNumber) return i;
        }
        return -1;
    }
   /*сортировка по номерам поездов*/
    static void sortTrains (Train[] train){
        Train max;
        for (int i = 0; i < train.length; i++) {
            for (int j = 0; j < i; j++) {
                if (train[i].getTrainNumber() < train[j].getTrainNumber()) {
                    max = train[i];
                    train[i]= train[j];
                    train[j] = max;
                }
            }

        }
    }

    /*сравнение 2-х слов*/
    public static int sortWordsALfabet (String str1, String str2){
        //-1 - первое слово меньше второго (по алфавиту)
        // 1 - второе слово меньше первого (по аолфавиту)
        // 0 - слова одинаковы
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
                    return 1;
                } else  {
                    return -1;
                }
            } else {
                if ((i == (n -1)) && ((byte)ch1 == (byte)ch2)) {
                    return 0;
                }
                if (i == n -1) return -1;
            }
        }
        return -1;
    }



}
class Main3 {

    public static void main(String[] agrs) {
        Train[] train = new Train[5];
        int trainNumber;
        int findNumber;
        Random random = new Random();
        /*заполнение массива*/
        for (int i = 0;i < train.length;i++){
            train[i] = new Train("Station" + (100 + random.nextInt(100)),random.nextInt(100), "1" + i + ":25:00");
        }
        /*Список поездов*/
        System.out.println("Весь список поездов ");
        for (int i = 0;i < train.length;i++){
            System.out.println(train[i].getNameStation() + " " + train[i].getTrainNumber() + " " + train[i].getDepartTime());
        }
        System.out.println();

        /*поиск поезда*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер искомого поезда");
        trainNumber = 0; //номер поезда по умолчанию
        if (sc.hasNextInt()){
            trainNumber = sc.nextInt();
        } else  System.out.println("Номер поезда не  должен быть числовымвв");
        sc.close();

        findNumber = TrainService.findeTrainNumber(train,trainNumber);
        System.out.println("Поиск нужного поезда " + trainNumber);
        if (findNumber != -1) System.out.println(train[findNumber].getNameStation() + " " + train[findNumber].getTrainNumber() + " " + train[findNumber].getDepartTime());
        else System.out.println("Поезд с номером " + trainNumber + " не найден!");
        System.out.println();

        /*сортировка по номерам поездов*/
        Train[] train2 = train;
        TrainService.sortTrains(train2);
        System.out.println("Весь список поездов отсортированный по номерам поездов");
        for (int i = 0;i < train2.length;i++){
            System.out.println(train2[i].getNameStation() + " " + train2[i].getTrainNumber() + " " + train2[i].getDepartTime());
        }
        System.out.println();

        /*сортировка по названиям станций*/
        Train[] train3 = train;
        TrainService.sortNameStation(train3);
        System.out.println("Весь список поездов отсортированный по названиям станций");
        for (int i = 0;i < train3.length;i++){
            System.out.println(train3[i].getNameStation() + " " + train3[i].getTrainNumber() + " " + train3[i].getDepartTime());
        }
        System.out.println();


    }

}