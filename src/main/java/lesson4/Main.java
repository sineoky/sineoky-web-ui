package lesson4;
//Задание 4 Синеокая Марина
public class Main {
    public static void main(String[] args) {
        int a=5;
        int b=7;
        int c=3;
        Triangle myTriangle=new Triangle(a,b,c);
        //double s3=Triangle.Area(a,b,c);
        double s=myTriangle.countArea();
        System.out.println("Площадь треугольника= "+s);
    }
}
