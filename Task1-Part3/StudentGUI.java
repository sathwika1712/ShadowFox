import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Student {
    String name, roll, course;

    Student(String name, String roll, String course) {
        this.name = name;
        this.roll = roll;
        this.course = course;
    }
}

public class StudentGUI {

    static ArrayList<Student> students = new ArrayList<>();
    static DefaultListModel<String> listModel = new DefaultListModel<>();

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Management System");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField nameField = new JTextField();
        JTextField rollField = new JTextField();
        JTextField courseField = new JTextField();

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        JList<String> studentList = new JList<>(listModel);

        frame.setLayout(new GridLayout(9, 1));

        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Roll No:"));
        frame.add(rollField);
        frame.add(new JLabel("Course:"));
        frame.add(courseField);

        frame.add(addBtn);
        frame.add(updateBtn);
        frame.add(deleteBtn);
        frame.add(new JScrollPane(studentList));

        // ADD
        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            String roll = rollField.getText();
            String course = courseField.getText();

            students.add(new Student(name, roll, course));
            listModel.addElement(name + " - " + roll + " - " + course);

            nameField.setText("");
            rollField.setText("");
            courseField.setText("");
        });

        // UPDATE
        updateBtn.addActionListener(e -> {
            int index = studentList.getSelectedIndex();

            if (index != -1) {
                String name = nameField.getText();
                String roll = rollField.getText();
                String course = courseField.getText();

                students.set(index, new Student(name, roll, course));
                listModel.set(index, name + " - " + roll + " - " + course);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a student to update!");
            }
        });

        // DELETE
        deleteBtn.addActionListener(e -> {
            int index = studentList.getSelectedIndex();
            if (index != -1) {
                students.remove(index);
                listModel.remove(index);
            }
        });

        frame.setVisible(true);
    }
}
