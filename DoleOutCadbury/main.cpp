#include <bits/stdc++.h>
using namespace std;

struct Rect {
  int length;
  int width;
  Rect(int l, int w) {
    width = w;
    length = l;
  }
};

void print_rect(Rect r) { cout << r.length << " " << r.width << endl; }

int get_no_of_students(Rect &rect) {
  int sum = 0;
  Rect r = rect;
  while (true) {
    if (r.width == r.length) {
      sum += 1;
      break;
    } else if (r.width > r.length) {
      r.width = r.width - r.length;
      sum += 1;
    } else {
      r.length = r.length - r.width;
      sum += 1;
    }
  }
  return sum;
}


int main() {
  int min_length, max_length, min_width, max_width;
  cin >> min_length >> max_length >> min_width >> max_width;
  vector<Rect> rectangle_combinations;
  for (int i = min_length; i <= max_length; i++) {
    for (int j = min_width; j <= max_width; j++) {
      rectangle_combinations.push_back(Rect(i, j));
    }
  }
  int ans = 0;
  for (auto &rect : rectangle_combinations) {
    int cur = get_no_of_students(rect);
    cout << " " << rect.length << " " << rect.width << " " << cur << endl;
    ans += cur;
  }
  cout << ans << endl;
  return 0;
}
