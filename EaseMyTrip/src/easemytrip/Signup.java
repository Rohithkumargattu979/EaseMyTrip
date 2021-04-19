package easemytrip;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.time.LocalDate;
import java.time.Period;
import java.math.*;

public class Signup extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JButton b1, b2;
    private JComboBox comboBox;


    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Signup() {
        setBounds(600, 250, 700, 406);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);

	JLabel lblUsername = new JLabel("Username :");
	lblUsername.setForeground(Color.DARK_GRAY);
	lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblUsername.setBounds(99, 86, 92, 26);
	contentPane.add(lblUsername);

	JLabel lblEmail = new JLabel("Email ID :");
	lblEmail.setForeground(Color.DARK_GRAY);
	lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblEmail.setBounds(99, 123, 92, 26);
	contentPane.add(lblEmail);

	JLabel lblAadhaar = new JLabel("Aadhaar ID :");
	lblAadhaar.setForeground(Color.DARK_GRAY);
	lblAadhaar.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblAadhaar.setBounds(99, 160, 92, 26);
	contentPane.add(lblAadhaar);

	JLabel lblPhone = new JLabel("Phone :");
	lblPhone.setForeground(Color.DARK_GRAY);
	lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblPhone.setBounds(99, 234, 92, 26);
	contentPane.add(lblPhone);

	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female", "Others" }));
	comboBox.setBounds(265, 202, 148, 20);
	contentPane.add(comboBox);

	JLabel lblGender = new JLabel("Gender :");
	lblGender.setForeground(Color.DARK_GRAY);
	lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblGender.setBounds(99, 197, 140, 26);
	contentPane.add(lblGender);
	
	JLabel lblDOB = new JLabel("DOB in YYYY-MM-DD :");
	lblDOB.setForeground(Color.DARK_GRAY);
	lblDOB.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDOB.setBounds(99, 268, 92, 26);
	contentPane.add(lblDOB);
	
	JLabel lblAdd = new JLabel("Address :");
	lblAdd.setForeground(Color.DARK_GRAY);
	lblAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblAdd.setBounds(99, 302, 92, 26);
	contentPane.add(lblAdd);
        
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("easemytrip/icons/loginimg.png"));
        Image i1 = c1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel l6 = new JLabel(i2);
        l6.setBounds(460, 70, 200, 200);
        add(l6);

    textField = new JTextField();
	textField.setBounds(265, 91, 148, 20);
	contentPane.add(textField);
	textField.setColumns(10);

	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(265, 128, 148, 20);
	contentPane.add(textField_1);

    textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(265, 165, 148, 20);
	contentPane.add(textField_2);

	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(265, 202, 148, 20);
	contentPane.add(textField_3);
	
	textField_4 = new JTextField();
	textField_4.setColumns(10);
	textField_4.setBounds(265, 276, 148, 20);
	contentPane.add(textField_4);
	
	textField_5 = new JTextField();
	textField_5.setColumns(10);
	textField_5.setBounds(265, 313, 148, 20);
	contentPane.add(textField_5);
	

	b1 = new JButton("Create");
	b1.addActionListener(this);
	b1.setFont(new Font("Tahoma", Font.BOLD, 13));
	b1.setBounds(140, 289, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("Tahoma", Font.BOLD, 13));
	b2.setBounds(300, 289, 100, 30);
	b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	JPanel panel = new JPanel();
	panel.setForeground(new Color(34, 139, 34));
	panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	panel.setBounds(31, 30, 640, 310);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn con = new Conn();
            
            if(ae.getSource() == b1){
                String sql = "insert into account(username, email_id, aadhaar_id, phone, gender, dob, age, address) values(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);
		
		String d = textField_4.getText();
		LocalDate dob = LocalDate.parse(d);
		st.setString(1, textField.getText());
        st.setString(2, textField_1.getText());
		st.setString(3, textField_2.getText());
		st.setString(5, textField_3.getText());
		st.setString(4, (String) comboBox.getSelectedItem());
		st.setString(6, textField_4.getText());
		st.setInt(7, (int) getAge(dob));
		st.setString(7, textField_5.getText());
		

		int i = st.executeUpdate();
		if (i > 0){
                    JOptionPane.showMessageDialog(null, "Account Created Successfully ");
                }

                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
                textField_4.setText("");
                textField_5.setText("");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new Login().setVisible(true);
			
            }
        }catch(Exception e){
                System.out.println(e);
        }
        
        
    }
    public static int getAge(LocalDate dob) {
        LocalDate curDate = LocalDate.now();
        return Period.between(dob, curDate).getYears();
    }
    
    public void random(){
        

        int a = (int) (1 + (Math.random() * 10000000));  


       // Output is different every time this code is executed    
       //System.out.println(a);  
       if (a== (query to get all the cid){
           c_id = a;
       }  
     else{
         random();
     }
} 
}
