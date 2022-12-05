import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentInfo.setResizable(false);
        studentInfo.setTitle("Student Application");
        studentInfo.setSize(770, 500);
        studentInfo.setVisible(true);
        studentInfo.setLocationRelativeTo(null);
    }
}

