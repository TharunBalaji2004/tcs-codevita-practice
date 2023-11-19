#include <bits/stdc++.h>
using namespace std;

struct Student {
  string name;
  double percentage;
  string choice1;
  string choice2;
  string choice3;
  string final_college;
};
struct College {
  string name;
  int seats;
  vector<Student> students;
  double cut_off_percentage;
};

void print_student(Student student) {
  cout << student.name << " " << student.percentage << "% " << student.choice1
       << " " << student.choice2 << " " << student.choice3 << " "
       << "College admitted: " << student.final_college << endl;
}

bool compare_students(const Student &a, const Student &b) {
  if (a.percentage != b.percentage) {
    return a.percentage > b.percentage;
  }
  return a.name < b.name;
}

bool compare_colleges(const College &a, const College &b) {
  if (a.seats != b.seats) {
    return a.seats > b.seats;
  }
  return a.name < b.name;
}

bool compare_colleges_by_percent(const College &a, const College &b) {
  if (a.cut_off_percentage != b.cut_off_percentage) {
    return a.cut_off_percentage > b.cut_off_percentage;
  }
  return a.name < b.name;
}
int main() {
  int c, n;
  cin >> c >> n;
  map<string, College> colleges_map;
  for (int i = 0; i < c; i++) {
    int seats;
    cin >> seats;
    College cur_college;
    cur_college.name = "C-" + to_string(i + 1);
    cur_college.seats = seats;
    colleges_map[cur_college.name] = cur_college;
  }
  string input;
  vector<Student> students;
  cin.ignore();
  for (int i = 0; i < n; i++) {
    getline(cin, input);
    stringstream ss(input);
    string token;
    Student student;
    getline(ss, student.name, ',');
    getline(ss, token, ',');
    student.percentage = stod(token);
    getline(ss, student.choice1, ',');
    getline(ss, student.choice2, ',');
    getline(ss, student.choice3, ',');
    students.push_back(student);
  }
  sort(students.begin(), students.end(), compare_students);
  for (int i = 0; i < n; i++) {
    string cur_choice = "none";
    if (colleges_map[students[i].choice1].seats > 0) {
      cur_choice = students[i].choice1;
    } else if (colleges_map[students[i].choice2].seats > 0) {
      cur_choice = students[i].choice2;
    } else if (colleges_map[students[i].choice3].seats > 0) {
      cur_choice = students[i].choice3;
    }
    if (cur_choice != "none") {
      colleges_map[cur_choice].seats -= 1;
      colleges_map[cur_choice].students.push_back(students[i]);
    }
    students[i].final_college = cur_choice;
  }
  vector<Student> second_round_students;
  for (auto &student : students) {
    if (student.final_college == "none") {
      second_round_students.push_back(student);
    }
  }
  if (second_round_students.size() != 0) {
    for (auto &stu : second_round_students) {
      vector<College> colleges;
      for (const auto &college : colleges_map) {
        College c;
        c.name = college.second.name;
        c.seats = college.second.seats;
        for (auto &student : college.second.students) {
          c.students.push_back(student);
        }
        colleges.push_back(c);
      }
      sort(colleges.begin(), colleges.end(), compare_colleges);
      colleges_map[colleges[0].name].seats -= 1;
      colleges_map[colleges[0].name].students.push_back(stu);
      stu.final_college = colleges[0].name;
    }
  }
  vector<College> sorted_colleges;
  for (auto &college : colleges_map) {
    double min_percent = INT_MAX;
    for (const auto &student : college.second.students) {
      if (student.percentage < min_percent) {
        min_percent = student.percentage;
      }
    }
    if (min_percent != INT_MAX) {
      college.second.cut_off_percentage = min_percent;
    } else {
      college.second.cut_off_percentage = 0;
    }
    sorted_colleges.push_back(college.second);
  }

  sort(sorted_colleges.begin(), sorted_colleges.end(),
       compare_colleges_by_percent);
  for (auto &college : sorted_colleges) {
    if (college.cut_off_percentage != 0)
      cout << college.name << " " << college.cut_off_percentage << endl;
    else
      cout << college.name << " n/a" << endl;
  }

  return 0;
}
