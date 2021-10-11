package coursename;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class instructorform {

	JFrame frame14;
    public static int flag=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instructorform window = new instructorform();
					window.frame14.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public instructorform() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame14 = new JFrame();
		frame14.setBounds(100, 100, 1920, 1080);
		frame14.getContentPane().setBackground(Color.WHITE);
		frame14.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame14.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Sitka Display", Font.BOLD, 28));
		textArea.setBackground(SystemColor.inactiveCaptionBorder);
		textArea.setBounds(732, 27, 130, 40);
		if(instructorpage.firstname!=null) {
			textArea.setText(instructorpage.firstname);
		}
		else {
			textArea.setText(loginsignup.firstname);
		}
		frame14.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Sitka Display", Font.BOLD, 28));
		textArea_1.setBackground(SystemColor.inactiveCaptionBorder);
		textArea_1.setBounds(872, 27, 130, 40);
		if(instructorpage.lastname!=null) {
			textArea_1.setText(instructorpage.lastname);
		}
		else {
			textArea_1.setText(loginsignup.lastname);
		}
		frame14.getContentPane().add(textArea_1);
		
		JLabel lblNewLabel = new JLabel("What you want to do?");
		lblNewLabel.setForeground(new Color(153, 51, 51));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 32));
		lblNewLabel.setBounds(709, 574, 317, 40);
		frame14.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View Projects");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.decode("#3c6382"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewprojects nw=new viewprojects();
				nw.frame23.setVisible(true);
				frame14.dispose();
			}
		});
		btnNewButton.setFont(new Font("Sitka Display", Font.BOLD, 25));
		btnNewButton.setBounds(528, 662, 202, 40);
		frame14.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Log Out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Logged Out Successfully");
				loginsignup nw=new loginsignup();
				nw.frame.setVisible(true);
				frame14.dispose();
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(0, 51, 102));
		btnNewButton_2.setFont(new Font("Sitka Display", Font.BOLD, 28));
		btnNewButton_2.setBounds(796, 736, 151, 41);
		frame14.getContentPane().add(btnNewButton_2);
		
		final JComboBox queries = new JComboBox();
		queries.setBackground(Color.WHITE);
		queries.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		queries.addItem("Select your choice");
		queries.addItem("Unanswered queries");
		queries.addItem("All queries");
		queries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		queries.setBounds(997, 662, 233, 40);
		frame14.getContentPane().add(queries);
		
		JLabel image1lable = new JLabel();
		ImageIcon img= new ImageIcon(this.getClass().getResource("/Screenshot (147).png"));
		image1lable.setIcon(img);
		image1lable.setBounds(553, 127, 763, 446);
		frame14.getContentPane().add(image1lable);
		
		JButton btnNewButton_1 = new JButton("Queries:");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.decode("#3c6382"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query=queries.getSelectedItem().toString();
				if(query.equals("Select your choice")) {
					JOptionPane.showMessageDialog(null, "Select a choice");
				}
				else if(query.equals("Unanswered queries")) {
					flag=1;
					unansweredQueries nw=new unansweredQueries();
					nw.frame18.setVisible(true);
					frame14.dispose();
				}
				else if(query.equals("All queries")) {
					flag=2;
					allqueries nw=new allqueries();
					nw.frame19.setVisible(true);
					frame14.dispose();
			}
			}
		});
		btnNewButton_1.setFont(new Font("Sitka Display", Font.BOLD, 25));
		btnNewButton_1.setBounds(837, 662, 150, 40);
		frame14.getContentPane().add(btnNewButton_1);
		frame14.setBounds(100, 100,1366 , 768);
		frame14.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}
		
		
	
}	
		
		

