package programmingWithClasses;
/*
Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */

public class Student {
    private String famile;
    private String initials;
    private int groupeNumber;
    private int[] grade = new int[5];
    private boolean flag = true;


    public Student(String famile, String initials, int groupeNumber, int[] grade) {
        setFamile(famile);
        setInitials(initials);
        setGroupeNumber(groupeNumber);
        setGrade(grade);
    }

    public int[] getGrade() {
        return grade;
    }

    void setGrade(int[] grade) {
        this.grade = grade;
    }

    public String getFamile() {
        return famile;
    }
    public int getGroupeNumber() {
        return groupeNumber;
    }

     void setFamile(String famile) {
        this.famile = famile;
    }

    void setGroupeNumber(int groupeNumber) {
        this.groupeNumber = groupeNumber;
    }

    public String getInitials() {
        return initials;
    }

    void setInitials(String initials) {
        this.initials = initials;
    }
}
class Main2 {
    public static void main(String[] agrs) {
        Student grade [] = new Student[10];
        Student write = new Student("Ivanov","AA",4, new int[]{9, 10});
//        System.out.print(write.getFamile() + " " + write.getInitials() + " " + write.getGroupeNumber() + " ");

        for (int i =0;i<grade.length;i++){
           //grade[i] =
        }
    }

}
