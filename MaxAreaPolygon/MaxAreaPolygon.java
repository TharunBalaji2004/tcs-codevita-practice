package MaxAreaPolygon;

import java.util.*;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class MaxAreaPolygon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            points.add(new Point(x, y));
        }
        List<Point> convexHullPoints = convexHull(points);
        int maxArea = calculateArea(convexHullPoints);
        System.out.println(maxArea);

        scanner.close();
    }
    private static List<Point> convexHull(List<Point> points) {
        int n = points.size();
        if (n <= 3) {
            return points;
        }
        Collections.sort(points, Comparator.comparing((Point point) -> point.x).thenComparing(point -> point.y));
        List<Point> upperHull = new ArrayList<>();
        List<Point> lowerHull = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while (upperHull.size() >= 2 && crossProduct(upperHull.get(upperHull.size() - 2), upperHull.get(upperHull.size() - 1), points.get(i)) <= 0) {
                upperHull.remove(upperHull.size() - 1);
            }
            upperHull.add(points.get(i));
        }
        for (int i = n - 1; i >= 0; i--) {
            while (lowerHull.size() >= 2 && crossProduct(lowerHull.get(lowerHull.size() - 2), lowerHull.get(lowerHull.size() - 1), points.get(i)) <= 0) {
                lowerHull.remove(lowerHull.size() - 1);
            }
            lowerHull.add(points.get(i));
        }
        upperHull.remove(upperHull.size() - 1);
        lowerHull.remove(lowerHull.size() - 1);
        upperHull.addAll(lowerHull);
        return upperHull;
    }
// formula to find the orientation of the points is (P1, P2,P3)
// (y2 - y1)(x3 - x2) - (y3 - y2)(x2 - x1)

    private static int crossProduct(Point p0, Point p1, Point p2) {
        int x1 = p1.x - p0.x;
        int y1 = p1.y - p0.y;
        int x2 = p2.x - p0.x;
        int y2 = p2.y - p0.y;
        return x1 * y2 - x2 * y1;
    }
// Area = | 1/2 [ (x1y2 + x2y3 + … + xn-1yn + xny1) – (x2y1 + x3y2 + … + xnyn-1 + x1yn) ] |
    private static int calculateArea(List<Point> polygon) {
        int n = polygon.size();
        if (n < 3) {
            return 0;
        }
        int area = 0;
        for (int i = 0; i < n; i++) {
            int x1 = polygon.get(i).x;
            int y1 = polygon.get(i).y;
            int x2 = polygon.get((i + 1) % n).x;
            int y2 = polygon.get((i + 1) % n).y;
            area += (x1 * y2 - x2 * y1);
        }
        return Math.abs(area) / 2;
    }
}
