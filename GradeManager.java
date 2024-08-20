package learner;

import java.util.ArrayList;
import java.util.Scanner;

class StudentGrade {
    private String subject;
    private double grade;

    public StudentGrade(String subject, double grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }
}

public class GradeManager {
    private ArrayList<StudentGrade> grades;

    public GradeManager() {
        grades = new ArrayList<>();
    }

    public void addGrade(String subject, double grade) {
        grades.add(new StudentGrade(subject, grade));
    }

    public double calculateAverageGrade() {
        double total = 0;
        for (StudentGrade sg : grades) {
            total += sg.getGrade();
        }
        return total / grades.size();
    }

    public String getLetterGrade(double averageGrade) {
        if (averageGrade >= 90) {
            return "A";
        } else if (averageGrade >= 80) {
            return "B";
        } else if (averageGrade >= 70) {
            return "C";
        } else if (averageGrade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public double calculateGPA(double averageGrade) {
        if (averageGrade >= 90) {
            return 4.0;
        } else if (averageGrade >= 80) {
            return 3.0;
        } else if (averageGrade >= 70) {
            return 2.0;
        } else if (averageGrade >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    public void displayGrades() {
        System.out.println("Subject Grades:");
        for (StudentGrade sg : grades) {
            System.out.println(sg.getSubject() + ": " + sg.getGrade());
        }
    }

    public void displayOverallPerformance() {
        double averageGrade = calculateAverageGrade();
        String letterGrade = getLetterGrade(averageGrade);
        double gpa = calculateGPA(averageGrade);

        System.out.println("\nOverall Performance:");
        System.out.println("Average Grade: " + averageGrade);
        System.out.println("Letter Grade: " + letterGrade);
        System.out.println("GPA: " + gpa);
    }

    public static void main(String[] args) {
        GradeManager gm = new GradeManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int numSubjects = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Enter the subject name:");
            String subject = scanner.nextLine();
            System.out.println("Enter the grade for " + subject + ":");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            gm.addGrade(subject, grade);
        }

        gm.displayGrades();
        gm.displayOverallPerformance();

        scanner.close();
    }
}
