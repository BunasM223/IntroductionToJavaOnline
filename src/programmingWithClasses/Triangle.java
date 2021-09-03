package programmingWithClasses;
/*
Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
площади, периметра и точки пересечения медиан.
 */
public class Triangle {
    int a,b,c;
    public Triangle (int a, int b, int c){
        setA(a);
        setB(b);
        setC(c);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }
}
class  ServisTriangle{
    static double areaTriangle (Triangle trABC){
        double area = 0;
        area = 2/3*Math.sqrt(2*)
        return area;
    }
    static double medianTriangle (Triangle trABC){
        double m1,m2,m3;
        m1 = 0.5*(Math.sqrt(2*(Math.pow(trABC.getA(),2)) + 2*(Math.pow(trABC.getB(),2)) - (Math.pow(trABC.getC(),2))));
        m2 = 0.5*(Math.sqrt(2*(Math.pow(trABC.getA(),2)) + 2*(Math.pow(trABC.getC(),2)) - (Math.pow(trABC.getB(),2))));
        m3 = 0.5*(Math.sqrt(2*(Math.pow(trABC.getB(),2)) + 2*(Math.pow(trABC.getC(),2)) - (Math.pow(trABC.getA(),2))));

        return m1;
    }
    static double pointMediansTriangle (Triangle trABC){
        double point;
        point = ServisTriangle.medianTriangle(trABC);
        return point;
    }

}
class Main6 {
    public static void main(String[] agrs) {
        int a = 3;
        int b = 4;
        int c = 5;
        int area;
        double pointMedian;
        Triangle trABC = new Triangle(a,b,c);
        pointMedian = ServisTriangle.pointMediansTriangle(trABC);
        area = ServisTriangle.areaTriangle(trABC);


    }
}
