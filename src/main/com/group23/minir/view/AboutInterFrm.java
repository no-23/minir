package com.group23.minir.view;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
* 信息内部界面类
* @author Group 23
* @version 1.0
*/

public class AboutInterFrm extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 *  启动程序
	 * @param args main参数
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutInterFrm frame = new AboutInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 创建信息界面
	 */
	public AboutInterFrm() {
		setFrameIcon(new ImageIcon(AboutInterFrm.class.getResource("/images/about.png")));
		getContentPane().setForeground(Color.LIGHT_GRAY);
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5173\u4E8EGroup 23");
		setBounds(100, 100, 450, 313);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AboutInterFrm.class.getResource("/images/faraday.png")));

		JLabel msgLabel = new JLabel(
				"<html><body>Group 23<br><br> \u5C0F\u7EC4\u6210\u5458\uFF1A\u8D1D\u91D1\u6797\uFF0C\u6768\u601D\u7426\uFF0C\u88F4\u9896<br><br>balalalala~~~</body></html>");
		msgLabel.setBackground(Color.PINK);
		msgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		msgLabel.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		msgLabel.setVerticalAlignment(SwingConstants.TOP);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(153).addComponent(lblNewLabel))
								.addGroup(groupLayout.createSequentialGroup().addGap(27).addComponent(msgLabel,
										GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(25, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(msgLabel)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}
}
