package coursename;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class studentform {

	JFrame frame15;
	public static int flag=0;
	private JComboBox queries;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentform window = new studentform();
					window.frame15.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public studentform() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame15 = new JFrame();
		frame15.getContentPane().setBackground(Color.WHITE);
		frame15.setBackground(Color.WHITE);
		frame15.setBounds(100, 100, 1920, 1080);
		frame15.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame15.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Sitka Display", Font.BOLD, 28));
		textArea.setBackground(SystemColor.inactiveCaptionBorder);
		textArea.setBounds(693, 27, 130, 40);
		if(studentpage.firstname!=null) {
			textArea.setText(studentpage.firstname);
		}
		else {
			textArea.setText(loginsignup.firstname);
		}
		frame15.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Sitka Display", Font.BOLD, 28));
		textArea_1.setBackground(SystemColor.inactiveCaptionBorder);
		textArea_1.setBounds(833, 27, 130, 40);
		if(studentpage.lastname!=null) {
			textArea_1.setText(studentpage.lastname);
		}
		else {
			textArea_1.setText(loginsignup.lastname);
		}
		frame15.getContentPane().add(textArea_1);
		
		JLabel lblNewLabel = new JLabel("What you want to do?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(153, 51, 51));
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 32));
		lblNewLabel.setBounds(658, 571, 317, 40);
		frame15.getContentPane().add(lblNewLabel);
		
		JLabel image1lable = new JLabel();
		ImageIcon img= new ImageIcon(this.getClass().getResource("/Screenshot (156).jpg"));
		image1lable.setIcon(img);
		image1lable.setBounds(553, 127, 763, 446);
		frame15.getContentPane().add(image1lable);
		
		JButton btnNewButton = new JButton("Submit Projects");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.decode("#3c6382"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentsproject nw=new studentsproject();
				nw.frame16.setVisible(true);
				frame15.dispose();
			}
		});
		btnNewButton.setFont(new Font("Sitka Display", Font.BOLD, 25));
		btnNewButton.setBounds(496, 662, 202, 40);
		frame15.getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Queries:");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.decode("#3c6382"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query=queries.getSelectedItem().toString();
				if(query.equals("Select your choice")) {
					JOptionPane.showMessageDialog(null, "Select a choice");
				}
				else if(query.equals("Ask a query")) {
					flag=1;
					askQuery nw=new askQuery();
					nw.frame21.setVisible(true);
					frame15.dispose();
				}
				else if(query.equals("All queries asked")) {
					flag=2;
					allqueries2 nw=new allqueries2();
					nw.frame22.setVisible(true);
					frame15.dispose();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Sitka Display", Font.BOLD, 25));
		btnNewButton_1.setBounds(833, 662, 145, 40);
		frame15.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Log Out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Logged Out Successfully");
				loginsignup nw=new loginsignup();
				nw.frame.setVisible(true);
				frame15.dispose();
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Sitka Display", Font.BOLD, 30));
		btnNewButton_2.setBackground(new Color(0, 51, 102));
		btnNewButton_2.setBounds(761, 736, 151, 41);
		frame15.getContentPane().add(btnNewButton_2);
		
		queries = new JComboBox();
		queries.setBackground(Color.WHITE);
		queries.addItem("Select your choice");
		queries.addItem("Ask a query");
		queries.addItem("All queries asked");
		queries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		queries.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		queries.setBounds(988, 662, 233, 40);
		frame15.getContentPane().add(queries);
		
		
		
	}

}
