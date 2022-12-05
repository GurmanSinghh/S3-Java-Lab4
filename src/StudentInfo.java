import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class StudentInfo extends JFrame{

    //Declaring the variables
    private JPanel masterPanel, panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9, panel10;

    private JLabel lblFullName, lblAddress, lblCity, lblProvince, lblPostalCode, lblPhoneNumber, lblEmail;

    private JTextField txtFullName, txtAddress, txtCity, txtProvince, txtPostalCode, txtPhoneNumber, txtEmail;

    private JButton btnDisplay;

    private JCheckBox checkBox1, checkBox2;

    private JRadioButton radioButton1, radioButton2;

    private JComboBox courseList;

    private JTextArea txtArea;

    private List<String> addedCourses = new ArrayList<>();

    private JList<String> selectedCourses = new JList<>();

    //Constructor
    public StudentInfo() {
//Setting up the Panel
        setSize(400, 400);
        setLayout(null);

//Creating masterPanel
        masterPanel = new JPanel();
        masterPanel.setLayout(null);
        masterPanel.setBounds(6,6,740, 450);
        add(masterPanel);

//Creating panel 1
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(10,30, 400, 240);
        panel1.setBorder(BorderFactory.createTitledBorder("Personal Information"));
        masterPanel.add(panel1);

//Creating panel 2
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(420,18, 150, 100);
        panel2.setBorder(BorderFactory.createTitledBorder("Extra Activities"));
        masterPanel.add(panel2);

//Creating panel 3
        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(280, 268, 180, 35);
        masterPanel.add(panel3);

//Creating panel 4
        panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setBounds(580, 18, 150, 100);
        panel4.setBorder(BorderFactory.createTitledBorder("Student's Major"));
        masterPanel.add(panel4);

//Creating panel 5
        panel5 = new JPanel();
        panel5.setLayout(null);
        panel5.setBounds(420, 128, 310, 130);
        panel5.setBorder(BorderFactory.createTitledBorder("Student's Courses"));
        masterPanel.add(panel5);

//Creating panel 6
        panel6 = new JPanel();
        panel6.setLayout(null);
        panel6.setBounds(10, 300, 720, 140);
        panel6.setBorder(BorderFactory.createTitledBorder("Student's Courses"));
        masterPanel.add(panel6);

//Creating panel 7
        panel7 = new JPanel(new GridLayout(7, 2, -180, 5));
        panel7.setBounds(10, 20, 380, 200);

//Creating the labels
        lblFullName = new JLabel("Full Name: ");
        lblAddress = new JLabel("Address: ");
        lblCity = new JLabel("City: ");
        lblProvince = new JLabel("Province: ");
        lblPostalCode = new JLabel("Postal Code: ");
        lblPhoneNumber = new JLabel("Phone Number: ");
        lblEmail = new JLabel("Email: ");

//Creating the text fields
        txtFullName = new JTextField();
        txtAddress = new JTextField();
        txtCity = new JTextField();
        txtProvince = new JTextField();
        txtPostalCode = new JTextField();
        txtPhoneNumber = new JTextField();
        txtEmail = new JTextField();

//Adding the labels and text fields to the panel
        panel7.add(lblFullName);
        panel7.add(txtFullName);
        panel7.add(lblAddress);
        panel7.add(txtAddress);
        panel7.add(lblCity);
        panel7.add(txtCity);
        panel7.add(lblProvince);
        panel7.add(txtProvince);
        panel7.add(lblPostalCode);
        panel7.add(txtPostalCode);
        panel7.add(lblPhoneNumber);
        panel7.add(txtPhoneNumber);
        panel7.add(lblEmail);
        panel7.add(txtEmail);
        panel1.add(panel7);

//Creating a layout manager to hold the check boxes
        panel8 = new JPanel(new GridLayout(2, 2, 10, -5));
        panel8.setBounds(5, 22, 150, 75);

//Creating the check boxes
        checkBox1 = new JCheckBox("Student Council");
        checkBox2 = new JCheckBox("Volunteer Work");

//Adding the check boxes to the panels
        panel8.add(checkBox1);
        panel8.add(checkBox2);
        panel2.add(panel8);

//Creating a layout manager to hold the radio buttons
        panel9 = new JPanel(new GridLayout(2, 2, 10, -5));
        panel9.setBounds(5, 22, 150, 75);

//Creating the radio buttons
        radioButton1 = new JRadioButton("Computer Science");
        radioButton1.setSelected(true);
        radioButton2 = new JRadioButton("Business");

//When the radio button is clicked, the event is fired
        radioButton1.addActionListener(event -> radioClicked());
        radioButton2.addActionListener(event -> radioClicked());

//Adding radio buttons to a group
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(radioButton1);
        btnGroup.add(radioButton2);

//Adding the radio buttons to a panel
        panel9.add(radioButton1);
        panel9.add(radioButton2);
        panel4.add(panel9);

//Adding the panel to hold the combo box
        panel10 = new JPanel(new GridLayout(1, 1));
        panel10.setBounds(9, 22, 280, 25);

        courseList = new JComboBox();

        panel10.add(courseList);

        panel5.add(panel10);

//When the user goes to the courseList, the event is fired to add a course
        courseList.addActionListener(event -> courseAdded());

//Display button
        btnDisplay = new JButton("Display");
        btnDisplay.setBounds(60, 5, 80, 25);

//When the event of clicking on Display button happens, the method displayClicked will be executed
        btnDisplay.addActionListener(event -> displayClicked());

//Adding the button to a panel
        panel3.add(btnDisplay);

//Creating the text area to display all the user's inputs
        txtArea = new JTextArea();
        txtArea.setLineWrap(true);

//Including the txtArea on the scrollPane
        JScrollPane scrollPane = new JScrollPane(txtArea);
        scrollPane.setBounds(10, 20, 700, 110);
        txtArea.setEditable(false);

//Adding the scrollPane to panel6
        panel6.add(scrollPane);

//Set border for the box which will hold the courses selected by the user
        selectedCourses.setBorder(BorderFactory.createLineBorder(Color.BLACK));

//Including the selected courses to a scroll pane
        JScrollPane paneCourses = new JScrollPane(selectedCourses);
        paneCourses.setBounds(10, 60, 280, 60);
        panel5.add(paneCourses);
    }

    //Method to handle the events that happen when the Display button is clicked
    public void displayClicked() {
//Getting the user's inputs on text fields
        String fullName = txtFullName.getText();
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String province = txtProvince.getText();
        String postalCode = txtPostalCode.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String email = txtEmail.getText();

        try {
            if(
                    fullName == null || fullName.isEmpty() ||
                            address == null || address.isEmpty() ||
                            city == null || city.isEmpty() ||
                            province == null || province.isEmpty() ||
                            postalCode == null || postalCode.isEmpty() ||
                            phoneNumber == null || phoneNumber.isEmpty() ||
                            email == null || email.isEmpty()
            )
            {
                JOptionPane.showMessageDialog(null, "It is necessary to fill all the fields. ");
            }
            else
            {
                txtArea.append(
                        "Full Name: " + fullName + "\n" +
                                "Address: " + address + "\n" +
                                "City: " + city + "\n" +
                                "Province: " + province + "\n" +
                                "Postal Code: " + postalCode + "\n" +
                                "Phone Number: " + phoneNumber + "\n" +
                                "Email: " + email + "\n");

                if(checkBox1.isSelected()){
                    txtArea.append("Student Council: yes\n");
                }
                else {
                    txtArea.append("Student Council: no\n");
                }
                if(checkBox2.isSelected()){
                    txtArea.append("Volunteer Work: yes\n");
                }
                else {
                    txtArea.append("Volunteer Work: no\n");
                }
                txtArea.append("Courses: \n");

                for (String course : addedCourses){
                    txtArea.append(String.format(" - %s\n", course));
                }

            }


        } catch (Exception e){}

    }

    //Method to handle the events when the first/second radioButton is clicked
    public void radioClicked(){

        try {
            if(radioButton1.isSelected()){
                courseList.removeAllItems();
                courseList.addItem("");
                courseList.addItem("Java Programming Language");
                courseList.addItem("Python Programming Language");
                courseList.addItem("C# Programming Language");
            }
            if(radioButton2.isSelected()){
                courseList.removeAllItems();
                courseList.addItem("");
                courseList.addItem("Business 1");
                courseList.addItem("Business 2");
                courseList.addItem("Business 3");
            }

        }catch (Exception e){}

    }
    //Method to handle the events when a course is added
    public void courseAdded(){
        try {
            if(courseList.getSelectedItem()!=null){
                addedCourses.add(courseList.getSelectedItem().toString());
            }

            String[] arrayCourses = new String[addedCourses.size()];

            for (int i = 0; i < addedCourses.size(); i++) {
                arrayCourses[i] = addedCourses.get(i);
            }

            selectedCourses.setListData(arrayCourses);
        }catch (Exception e){}

    }
}
