package lesson4;

import static java.lang.Math.sqrt;

public class Triangle {
    int a;
    int b;
    int c;

    public Triangle(int a, int b, int c) {
       if ((a + b > c) & (a + c  > b) & (b+ c > a)) {
            this.a = a;
            this.b = b;
            this.c = c;
       } else {
            System.out.println("Треугольник не создать!!!");
           try {
               throw new Exception();
           } catch (Exception e) {
               e.printStackTrace();
               //System.exit(0);
           }

       }
    }

    public int countArea() {
        double a1 = a;
        double p = (a1 + b + c) / 2;
        double s1 = p * (p - a) * (p - b) * (p - c);
        double s2 = sqrt(s1);
        int s3 = (int) Math.round(s2);
        //int s3=(int) s2;
        return s3;
    }

}
