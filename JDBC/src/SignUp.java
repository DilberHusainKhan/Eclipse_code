import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;

public class SignUp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(870,0,500,600);
        frame.setTitle("Registration page");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipse_Code\\JDBC\\src\\signup.png"));
        // Container
        Container c = frame.getContentPane();
        c.setLayout(null);

        // set font 
        Font Bold =new Font("Times New Roman", Font.BOLD, 20);
        Font Normal =new Font("Times New Roman", Font.PLAIN, 18);

        // set lable 
        JLabel Sign_Up = new JLabel("Sign Up",JLabel.CENTER);
        JLabel Name = new JLabel("Student Name");
        JLabel Add = new JLabel("Student Address");
        JLabel Mobile = new JLabel("Student Mobile");
        JLabel user_id = new JLabel("USER ID");        
        user_id.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        JLabel password = new JLabel("Password");
        password.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        JTextField tName= new JTextField();
        JTextField tAdd= new JTextField();
        JTextField tMobile= new JTextField();
        JTextField tuser_id= new JTextField();
        JTextField tpassword= new JTextField();
        
//        tMobile.setEditable(false);

        // set locatio in the Container 
        Sign_Up.setBounds(-16,66,500,100);
        Name.setBounds(50,150,200,50);
        Add.setBounds(50,200,200,50);
        Mobile.setBounds(50,250,200,50);
        user_id.setBounds(50,300,200,50);
        password.setBounds(50,350,200,50);
        tName.setBounds(250,150,200,40);
        tAdd.setBounds(250,200,200,40);
        tMobile.setBounds(250,250,200,40);
        tuser_id.setBounds(250,300,200,40);
        tpassword.setBounds(250,350,200,40); 
        tMobile.setBackground(new Color(255, 255, 255));
        
        // Add Font
        Sign_Up.setFont(Bold);
        Name.setFont(Normal);
        Add.setFont(Normal);
        Mobile.setFont(Normal);
        tName.setFont(Normal);
        tAdd.setFont(Normal);
        tMobile.setFont(Normal);
        tuser_id.setFont(Normal);
        tpassword.setFont(Normal);
        // Image at bottom part
      

        // add lable to the Container 
        c.add(Sign_Up);
        c.add(Name);
        c.add(Add);
        c.add(Mobile);
        c.add(user_id);
        c.add(password);
        c.add(tName);
        c.add(tAdd);
        c.add(tMobile);
        c.add(tuser_id);
        c.add(tpassword);
        
        
        JButton btnNewButton = new JButton("Sign Up");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			String name = tName.getText();
        			String add = tAdd.getText();
        			long mobile = Long.parseLong(tMobile.getText());
        			String user_id = tuser_id.getText();
        			String password = tpassword.getText();
        			
//        			connection
        			Connection conn = DB.dbConnection();
        			String q = "Insert into student(name,address,mobile,user_id,password) values(?,?,?,?,?)";
        			PreparedStatement pst = conn.prepareStatement(q);
        			pst.setString(1,name);
        			pst.setString(2, add);
        			pst.setLong(3,mobile);
        			pst.setString(4, user_id);
        			pst.setString(5, password);
        			
        			pst.executeUpdate();
//        			dailog box
        			JOptionPane.showMessageDialog(null,"data added sucessfull!");
        			
        			//to set data empty after sucessfully added
        			tName.setText("");
        			tAdd.setText("");
        			tMobile.setText("");
        			tuser_id.setText("");
        			tpassword.setText("");
        		}catch(Exception e2) {
        			e2.printStackTrace();
        		}
        	}
        });
        
        
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnNewButton.setBounds(182, 489, 120, 40);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Print All Data");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			Display.display();
        			System.out.println("Done");
        		}catch(Exception e3) {
        			
        			e3.printStackTrace();
        		}
        	}
        });
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton_1.setBounds(10, 11, 131, 25);
        frame.getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Login");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoginFrom.main(null);
        	}
        });
        btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnNewButton_2.setBounds(361, 12, 113, 23);
        frame.getContentPane().add(btnNewButton_2);
        

//        frame.setResizable(false);
		
		
		setContentPane(contentPane);
	}
}
