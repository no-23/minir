package com.group23.minir.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Color;


/**
*  主界面类
* @author Group 23
* @version 1.0
*/

public class MainFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JDesktopPane table;

	
	/**
	 * 启动程序
	 * @param args main参数
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 创建主界面
	 */
	public MainFrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/images/faraday.png")));
		setTitle("minir -- \u6279\u91CF\u6587\u4EF6\u6539\u540D\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 533);
		
		//使得frame生成到屏幕中心
		this.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u6587\u4EF6");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("\u6279\u91CF\u91CD\u547D\u540D");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RenameInterFrm renameInterFrm = new RenameInterFrm();
				renameInterFrm.setVisible(true);
				table.add(renameInterFrm);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/modify.png")));
		mnNewMenu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7A0B\u5E8F");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "退出minir?");
				if (result == 0) {
					MainFrm.this.dispose();
				}
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		mnNewMenu.add(menuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmGroup = new JMenuItem("Group 23");
		mntmGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutInterFrm aboutInterFrm = new AboutInterFrm();
				aboutInterFrm.setVisible(true);
				table.add(aboutInterFrm);
			}
		});
		mntmGroup.setIcon(new ImageIcon(MainFrm.class.getResource("/images/group.png")));
		mnNewMenu_1.add(mntmGroup);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		table = new JDesktopPane() {
			private static final long serialVersionUID = 1L;
			//设置背景图片
			private ImageIcon ico=new ImageIcon(MainFrm.class.getResource("/images/background.jpg"));
			public void paintComponent(java.awt.Graphics g){
			g.drawImage(ico.getImage(), 0, 0, getWidth(), getHeight(), this);
			}
		};
		table.setBackground(Color.ORANGE);
		contentPane.add(table, BorderLayout.CENTER);
		table.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}
