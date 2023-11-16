import java.util.*;

public class CrazyRing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Double x1 = sc.nextDouble();
        Double y1 = sc.nextDouble();
        Double x2 = sc.nextDouble();
        Double y2 = sc.nextDouble();
        Double x3 = sc.nextDouble();
        Double y3 = sc.nextDouble();

        if (findTriangleArea(x1, y1, x2, y2, x3, y3) == 0) {
            System.out.println("Not Possible");
        } else {
            Double res = findAreaRing(x1, y1, x2, y2, x3, y3);
            System.out.printf("%.2f", res);
        }

        sc.close();
    }

    private static Double findAreaRing(Double x1, Double y1, Double x2, Double y2, Double x3, Double y3) {
        Double a = findDistance(x1, y1, x2, y2);
        Double b = findDistance(x2, y2, x3, y3);
        Double c = findDistance(x3, y3, x1, y1);

        Double R = (a*b*c)/(4*findTriangleArea(x1, y1, x2, y2, x3, y3));
        Double r = findTriangleArea(x1, y1, x2, y2, x3, y3)/findSemiPerimeter(x1, y1, x2, y2, x3, y3);

        return Math.PI*(R*R - r*r);
    }

    private static Double findDistance(Double x1, Double y1, Double x2, Double y2) {
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }

    private static Double findSemiPerimeter(Double x1, Double y1, Double x2, Double y2, Double x3, Double y3) {
        Double a = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
        Double b = Math.sqrt(Math.pow((x3-x2), 2) + Math.pow((y3-y2), 2));
        Double c = Math.sqrt(Math.pow((x1-x3), 2) + Math.pow((y1-y3), 2));

        return (a+b+c)/2.0;
    }

    private static Double findTriangleArea(Double x1, Double y1, Double x2, Double y2, Double x3, Double y3) {
        return Math.abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))/2.0);
    }
}
