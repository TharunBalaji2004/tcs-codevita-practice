#include <bits/stdc++.h>
using namespace std;

int main() {
  int t, n;
  cin >> t;
  while (t--) {
    cin >> n;
    vector<int> chocolates(n);
    for (int i = 0; i < n; i++) {
      cin >> chocolates[i];
    }
    sort(chocolates.begin(), chocolates.end(), greater<int>());
    stack<int> choco_stack;
    for (int i : chocolates) {
      choco_stack.push(i);
    }
    int time = 0;
    while (choco_stack.size() > 1) {
      int first = choco_stack.top();
      choco_stack.pop();
      int second = choco_stack.top();
      choco_stack.pop();
      int result = first + second;
      time += result;
      choco_stack.push(result);
    }
    cout << time << endl;
  }
  return 0;
}
