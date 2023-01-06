import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Display extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public static void display() {
		try {
			Connection con = DB.dbConnection();
			String pq = "select * from student";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(pq);
			while(rs.next()) {
				JOptionPane.showMessageDialog(null,"ID: "+rs.getString(1)+"\nName: "+rs.getString(2)+"\nAdd: "+rs.getString(3)+"\nMobile: "+rs.getString(4));
				
			}
			System.out.println("print");
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Database is Empty");
				System.out.println("Empty");
				e.printStackTrace();
			}
	}
	public Display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
	}

}
