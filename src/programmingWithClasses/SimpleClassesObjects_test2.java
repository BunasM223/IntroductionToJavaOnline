package programmingWithClasses;



/*
Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте
конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра
класса.
 */
public class SimpleClassesObjects_test2 {
    private int firsVariable;
    private int secondVariable;

    public SimpleClassesObjects_test2 (int a, int b){
        /*если приходит ноль то возвращаем по умолчанию*/
        if (a == 0) this.firsVariable =8;
        else this.firsVariable = a;

        if (b == 0 ) this.secondVariable = 9;
        else this.secondVariable = b;
    }
    public void setSecondVar (int secondVariable){
        this.secondVariable = secondVariable;

    }
    public void setFirstVar (int firsVariable){
        this.firsVariable = firsVariable;

    }
    public int getFirstVar (){
        return firsVariable;

    }
    public int getSecondVar (){
        return secondVariable;

    }



}

class Main {
    public static void main(String[] agrs) {

        SimpleClassesObjects_test2 first = new SimpleClassesObjects_test2(0,0);

        /*получение значений по умолчанию*/
        System.out.println(first.getFirstVar() + " " + first.getSecondVar());

        /*запись и получение новых значений*/
        first.setSecondVar(2);
        first.setFirstVar(5);
        System.out.println(first.getFirstVar() + " " + first.getSecondVar());
    }

}
