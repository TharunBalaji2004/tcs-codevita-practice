package CollegeRankIII;

import java.util.*;

public class CollegeRank {

    static class Student {
        String name;
        double percentage;
        String choice1;
        String choice2;
        String choice3;
        String finalCollege;

        public Student(String name, double percentage, String choice1, String choice2, String choice3) {
            this.name = name;
            this.percentage = percentage;
            this.choice1 = choice1;
            this.choice2 = choice2;
            this.choice3 = choice3;
            this.finalCollege = "";
        }
    }

    static class College {
        String name;
        int seats;
        List<Student> students;
        double cutOffPercentage;

        public College(String name, int seats) {
            this.name = name;
            this.seats = seats;
            this.students = new ArrayList<>();
            this.cutOffPercentage = 0.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        Map<String, College> collegesMap = new HashMap<>();

        // Input available seats for each college
        for (int i = 0; i < c; i++) {
            int seats = scanner.nextInt();
            College curCollege = new College("C-" + (i + 1), seats);
            collegesMap.put(curCollege.name, curCollege);
        }

        scanner.nextLine(); // Consume the newline character

        List<Student> students = new ArrayList<>();

        // Input student data
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split(",");
            String name = tokens[0];
            double percentage = Double.parseDouble(tokens[1]);
            String choice1 = tokens[2];
            String choice2 = tokens[3];
            String choice3 = tokens[4];
            students.add(new Student(name, percentage, choice1, choice2, choice3));
        }

        // Sort students based on percentage and name
        Collections.sort(students, (a, b) -> {
            if (a.percentage != b.percentage) {
                return Double.compare(b.percentage, a.percentage);
            }
            return a.name.compareTo(b.name);
        });

        // Assign students to colleges based on preferences and available seats
        for (int i = 0; i < n; i++) {
            String curChoice = "none";
            if (collegesMap.get(students.get(i).choice1).seats > 0) {
                curChoice = students.get(i).choice1;
            } else if (collegesMap.get(students.get(i).choice2).seats > 0) {
                curChoice = students.get(i).choice2;
            } else if (collegesMap.get(students.get(i).choice3).seats > 0) {
                curChoice = students.get(i).choice3;
            }
            if (!curChoice.equals("none")) {
                collegesMap.get(curChoice).seats -= 1;
                collegesMap.get(curChoice).students.add(students.get(i));
            }
            students.get(i).finalCollege = curChoice;
        }

        // Identify students for the second round
        List<Student> secondRoundStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.finalCollege.equals("none")) {
                secondRoundStudents.add(student);
            }
        }

        // Process second round admissions
        if (!secondRoundStudents.isEmpty()) {
            for (Student stu : secondRoundStudents) {
                List<College> colleges = new ArrayList<>(collegesMap.values());
                colleges.sort((a, b) -> {
                    if (a.seats != b.seats) {
                        return Integer.compare(b.seats, a.seats);
                    }
                    return a.name.compareTo(b.name);
                });

                collegesMap.get(colleges.get(0).name).seats -= 1;
                collegesMap.get(colleges.get(0).name).students.add(stu);
                stu.finalCollege = colleges.get(0).name;
            }
        }

        // Calculate cut-off percentages for each college
        List<College> sortedColleges = new ArrayList<>(collegesMap.values());

        for (College college : sortedColleges) {
            double minPercent = Double.MAX_VALUE;
            for (Student student : college.students) {
                if (student.percentage < minPercent) {
                    minPercent = student.percentage;
                }
            }
            college.cutOffPercentage = (minPercent != Double.MAX_VALUE) ? minPercent : 0.0;
        }

        // Sort colleges based on cut-off percentages and names
        sortedColleges.sort((a, b) -> {
            if (a.cutOffPercentage != b.cutOffPercentage) {
                return Double.compare(b.cutOffPercentage, a.cutOffPercentage);
            }
            return a.name.compareTo(b.name);
        });

        // Print the results
        for (College college : sortedColleges) {
            if (college.cutOffPercentage != 0.0) {
                System.out.printf("%s %.2f%n", college.name, college.cutOffPercentage);
            } else {
                System.out.println(college.name + " n/a");
            }
        }

        scanner.close();
    }
}
