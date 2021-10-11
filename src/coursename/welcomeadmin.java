package coursename;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class welcomeadmin {

	JFrame frame11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcomeadmin window = new welcomeadmin();
					window.frame11.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public welcomeadmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame11 = new JFrame();
		frame11.getContentPane().setBackground(Color.WHITE);
		frame11.setBackground(Color.WHITE);
		frame11.setBounds(100, 100, 1920, 1080);
		frame11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame11.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME ADMIN!!");
		lblNewLabel.setForeground(Color.decode("#6F1E51"));
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(540, 54, 500, 50);
		frame11.getContentPane().add(lblNewLabel);
		
		JButton formapproval = new JButton("Form Approval");
		formapproval.setForeground(Color.BLACK);
		formapproval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminlogin nw =new adminlogin();
				nw.frame5.setVisible(true);
				frame11.dispose();
			}
		});
		formapproval.setBackground(Color.decode("#0097e6"));
		formapproval.setFont(new Font("Sitka Display", Font.BOLD, 27));
		formapproval.setBounds(447, 624, 223, 35);
		frame11.getContentPane().add(formapproval);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.setForeground(Color.BLACK);
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentpage nw =new studentpage();
				nw.frame12.setVisible(true);
				frame11.dispose();
			}
		});
		btnStudent.setFont(new Font("Sitka Display", Font.BOLD, 27));
		btnStudent.setBackground(Color.decode("#0097e6"));
		btnStudent.setBounds(725, 624, 223, 35);
		frame11.getContentPane().add(btnStudent);
		
		JButton btnInstructor = new JButton("Instructor");
		btnInstructor.setForeground(Color.BLACK);
		btnInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instructorpage nw =new instructorpage();
				nw.frame13.setVisible(true);
				frame11.dispose();
			}
		});
		btnInstructor.setFont(new Font("Sitka Display", Font.BOLD, 27));
		btnInstructor.setBackground(Color.decode("#0097e6"));
		btnInstructor.setBounds(1008, 624, 223, 35);
		frame11.getContentPane().add(btnInstructor);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginsignup nw =new loginsignup();
				nw.frame.setVisible(true);
				frame11.dispose();
			}
		});
		btnLogOut.setFont(new Font("Sitka Display", Font.BOLD, 27));
		btnLogOut.setBackground(new Color(0, 51, 102));
		btnLogOut.setBounds(725, 705, 223, 35);
		frame11.getContentPane().add(btnLogOut);
		
		JLabel image1lable = new JLabel();
		ImageIcon img= new ImageIcon(this.getClass().getResource("/Screenshot (145).png"));
		image1lable.setIcon(img);
		image1lable.setBounds(502, 143, 625, 430);
		frame11.getContentPane().add(image1lable);
	}
}
