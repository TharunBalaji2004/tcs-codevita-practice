#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

bool is_palindrome(string s) {
  if (s.length() == 1)
    return true;
  string s1 = s;
  reverse(s.begin(), s.end());
  return s1 == s;
}

int main() {
  string s, s1, s2, s3;
  cin >> s;
  int l = s.length();
  for (int i = 1; i < l - 1; i++) {
    s1 = s.substr(0, i);
    if (is_palindrome(s1)) {
      for (int j = 1; j < l - i; j++) {
        s2 = s.substr(i, j);
        s3 = s.substr(i + j, l - i - j);
        if (is_palindrome(s1) && is_palindrome(s2) && is_palindrome(s3)) {
          cout << s1 << endl << s2 << endl << s3 << endl;
          return 0;
        }
      }
    }
  }
  cout << "Impossible" << endl;
  return 0;
}