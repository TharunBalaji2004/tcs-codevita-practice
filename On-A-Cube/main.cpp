#include <bits/stdc++.h>
using namespace std;

struct Point3D {
  double x;
  double y;
  double z;
  Point3D() : x(0), y(0), z(0) {}
  Point3D(double x_val, double y_val, double z_val)
      : x(x_val), y(y_val), z(z_val) {}
};
bool is_same_face(Point3D a, Point3D b) {
  return (a.x == b.x and (a.y == b.y or a.z == b.z)) or
         (a.y == b.y and a.z == b.z);
}

double find_distance(Point3D a, Point3D b) {
  double t = pow(a.x - b.x, 2) + pow(a.y - b.y, 2) + pow(a.z - b.z, 2);
  double result = sqrt(t);
  return result;
}

double find_straight_distance(Point3D a, Point3D b) {
  double x_distance = abs(a.x - b.x);
  double y_distance = abs(a.y - b.y);
  double z_distance = abs(a.z - b.z);
  double tot = x_distance + y_distance + z_distance;
  if (a.x == b.x || a.y == b.y) {
    return round(tot * 100) / 100.0;
  } else {
    return round((tot - 2) * 100) / 100.0;
  }
}

double find_same_face_area(double r) {
  double arc_length = 1.0472 * r;
  return arc_length;
}

int main() {
  int n;
  cin >> n;
  vector<Point3D> points(n);
  for (int i = 0; i < n; i++) {
    int x, y, z;
    cin >> x >> y >> z;
    points[i].x = x;
    points[i].y = y;
    points[i].z = z;
  }
  double total_distance = 0;
  for (int i = 0; i < n - 1; i++) {
    bool is_same = is_same_face(points[i], points[i + 1]);
    double dist = find_distance(points[i], points[i + 1]);
    double dist1 = find_straight_distance(points[i], points[i + 1]);
    if (is_same) {
      total_distance += find_same_face_area(dist);
    } else {
      total_distance += dist1;
    }
  }
  cout << fixed << setprecision(2) << total_distance << endl;
  return 0;
}
