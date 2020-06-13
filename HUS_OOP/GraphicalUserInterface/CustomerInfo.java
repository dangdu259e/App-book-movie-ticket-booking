	package GraphicalUserInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import GraphicalUserInterface.CustomerInfo.SwingAction;
import Object.Customer;
import Database.queryprocess;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class CustomerInfo extends JFrame {

	
	private final Action action = new SwingAction();
	private JTextField textName;
	private JTextField textPhoneNumber; 
	private JTextField textEmail;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textSoCMND;

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new CustomerInfo().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("MyFrame");
		setSize(507,584);
		getContentPane().setForeground(Color.WHITE);
		//frame.setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		//JLabel
		JLabel lblNewLabel = new JLabel("THÔNG TIN CÁ NHÂN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(132, 11, 245, 32);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ và tên:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 81, 80, 42);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Số điện thoại:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 119, 90, 42);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 171, 80, 32);
		getContentPane().add(lblNewLabel_3);
				
		//JTextField
		textName = new JTextField();
		textName.setBounds(106, 88, 326, 32);
		getContentPane().add(textName);
		
		textPhoneNumber = new JTextField();
		textPhoneNumber.setBounds(106, 126, 326, 32);
		getContentPane().add(textPhoneNumber);
		
		JButton btnNewAcc = new JButton();
		btnNewAcc.setAction(action);
		btnNewAcc.setText("Create new account");
		btnNewAcc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textSoCMND.getText().equals("")|| textName.getText().isEmpty() || textPhoneNumber.getText().isEmpty() || textUsername.getText().isEmpty() || textPassword.getText().isEmpty() || textEmail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin","Message", JOptionPane.ERROR_MESSAGE);
				}
				int i = Integer.parseInt(textSoCMND.getText().trim());
				String name = textName.getText().trim();
				int phone = Integer.parseInt(textPhoneNumber.getText().trim());
				String email = textEmail.getText().trim();
				String username = textUsername.getText().trim();
				String password = textPassword.getText().trim();
				int soCMND= Integer.parseInt(textSoCMND.getText().trim());
				//i++;
				Customer cus = new Customer();
				cus.setUsername(username);
				cus.setSoCMND(soCMND);
				cus.setName(name);
				cus.setPhoneNumber(phone);
				cus.setUsername(username);
				cus.setPassword(password);
				cus.setEmail(email);
				
				if(new queryprocess().createUser(cus)) {
					JOptionPane.showMessageDialog(null	, "Sucess","Message",JOptionPane.OK_OPTION);
				} else {
				JOptionPane.showMessageDialog(null,"False", "message",JOptionPane.ERROR_MESSAGE);
				}
			}	
		});
		
		btnNewAcc.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewAcc.setBounds(316, 515, 177, 32);
		getContentPane().add(btnNewAcc);
		
		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 213, 80, 32);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 253, 80, 32);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblSoCMND = new JLabel("Số CMND");
		lblSoCMND.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSoCMND.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoCMND.setBounds(10, 295, 80, 32);
		getContentPane().add(lblSoCMND);
		
		textEmail = new JTextField();
		textEmail.setBounds(106, 168, 326, 32);
		getContentPane().add(textEmail);
		
		textUsername = new JTextField();
		textUsername.setBounds(106, 211, 326, 32);
		getContentPane().add(textUsername);
		
		textPassword = new JTextField();
		textPassword.setBounds(106, 253, 326, 32);
		getContentPane().add(textPassword);
		
		textSoCMND = new JTextField();
		textSoCMND.setBounds(106, 295, 326, 32);
		getContentPane().add(textSoCMND);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 365, 493, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 46, 493, 2);
		getContentPane().add(separator_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login_S lg = new Login_S();
				lg.main(null);
				lg.pack();
				lg.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnLogin.setBounds(0, 517, 177, 29);
		getContentPane().add(btnLogin);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "NEXT");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}