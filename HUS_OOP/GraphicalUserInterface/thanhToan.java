package GraphicalUserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.queryprocess;
import Object.Chairs;
import Object.Customer;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class thanhToan extends JFrame {

	private JPanel contentPane;

	public thanhToan() {
		setTitle("Thanh toán");
		setVisible(true);
		setResizable(false);
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 457, 124);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JLabel lblBnChcChn = new JLabel(
				"Bạn chắc chắn muốn mua ghế đã chọn, tổng tiền là "
						+ SoDoGhe.count * 100000 + " VND");
		lblBnChcChn.setVerticalAlignment(SwingConstants.TOP);
		lblBnChcChn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblBnChcChn.setBounds(10, 11, 421, 32);
		contentPane.add(lblBnChcChn);

		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setBounds(228, 51, 89, 23);
		contentPane.add(btnXacNhan);
		btnXacNhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if (SoDoGhe.buttons[i][j].getBackground() == Color.green) {
							SoDoGhe.buttons[i][j].setBackground(Color.red);
							SoDoGhe.lbTien.setText("0 VND");
							SoDoGhe.lbSoGhe.setText("0");
							SoDoGhe.count = 0;
							Chairs chair = new Chairs();
							chair.setTrucHoanh(j);
							chair.setTrucTung(i);
							queryprocess pQueryprocess = new queryprocess();	
							try {
								queryprocess.redChairs(chair);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			}
		});

		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBounds(327, 51, 89, 23);
		
		
		contentPane.add(btnHuy);
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
	}
	
}
