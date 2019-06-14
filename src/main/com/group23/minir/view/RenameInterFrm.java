package com.group23.minir.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.group23.minir.core.Renamer;
import com.group23.minir.util.StringUtil;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.regex.PatternSyntaxException;
import java.awt.event.ActionEvent;

/**
 * 重命名内部界面类
 * @author Group 23
 * @version 1.0
 */
public class RenameInterFrm extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField dirTxt;
	private JTextField regTxt;
	private JTextField beginTxt;
	private JTextField stepTxt;

	private JFileChooser fileChooser = new JFileChooser();
	private JTextField prefixTxt;
	private JTextField suffixTxt;

	/**
	 * 启动程序
	 * @param args main参数
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RenameInterFrm frame = new RenameInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 创建重命名界面
	 */
	public RenameInterFrm() {
		setFrameIcon(new ImageIcon(RenameInterFrm.class.getResource("/images/modify.png")));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u6587\u4EF6\u6279\u91CF\u6539\u540D");
		setBounds(100, 100, 432, 382);

		JButton button = new JButton("\u9009\u62E9\u76EE\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseDirActionPerformed();
			}
		});
		button.setIcon(new ImageIcon(RenameInterFrm.class.getResource("/images/search.png")));

		dirTxt = new JTextField();
		dirTxt.setToolTipText("\u70B9\u51FB\u5DE6\u4FA7\u6309\u94AE\u9009\u62E9\u76EE\u5F55");
		dirTxt.setEnabled(false);
		dirTxt.setColumns(10);

		regTxt = new JTextField();
		regTxt.setToolTipText(
				"\u8BF7\u5F85\u6539\u540D\u6587\u4EF6\u7684\u6587\u4EF6\u540D\u7279\u5F81\uFF08\u6B63\u5219\u8868\u8FBE\u5F0F\uFF09");
		regTxt.setColumns(10);

		JLabel lblNewLabel = new JLabel("\u6587\u4EF6\u540D\u7279\u5F81\uFF1A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));

		JLabel label = new JLabel("\u8D77\u59CB\u7F16\u53F7\uFF1A");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("宋体", Font.PLAIN, 15));

		beginTxt = new JTextField();
		beginTxt.setToolTipText("\u65B0\u540D\u79F0\u7684\u8D77\u59CB\u7F16\u53F7\uFF08\u4E3A\u6574\u6570\uFF09");
		beginTxt.setColumns(10);

		JLabel label_1 = new JLabel("\u7F16\u53F7\u95F4\u8DDD\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));

		stepTxt = new JTextField();
		stepTxt.setToolTipText(
				"\u65B0\u540D\u79F0\u7F16\u53F7\u7684\u95F4\u8DDD\uFF08\u4E3A\u975E\u96F6\u6574\u6570\uFF09");
		stepTxt.setColumns(10);

		JButton btnNewButton = new JButton("\u5F00\u59CB\u6539\u540D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renameActionPerformed();
			}
		});
		btnNewButton.setIcon(new ImageIcon(RenameInterFrm.class.getResource("/images/edit.png")));

		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		button_1.setIcon(new ImageIcon(RenameInterFrm.class.getResource("/images/reset.png")));

		JLabel label_2 = new JLabel("\u65B0\u540D\u5F62\u5F0F\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));

		prefixTxt = new JTextField();
		prefixTxt.setToolTipText("\u7F16\u53F7\u524D\u9762\u7684\u5B57\u7B26\u4E32");
		prefixTxt.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("+ \u7F16 \u53F7 +");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		suffixTxt = new JTextField();
		suffixTxt.setToolTipText("\u7F16\u53F7\u524D\u9762\u7684\u5B57\u7B26\u4E32");
		suffixTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(43)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false).addGroup(groupLayout
								.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 90,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 90,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)).addComponent(button)
								.addComponent(lblNewLabel))
						.addGap(29).addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING).addComponent(dirTxt, 200, 200, 200)
										.addComponent(stepTxt, 200, 200, 200).addComponent(beginTxt, 200, 200, 200)
										.addComponent(regTxt, GroupLayout.PREFERRED_SIZE, 200,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(prefixTxt, GroupLayout.PREFERRED_SIZE, 60,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 60,
														GroupLayout.PREFERRED_SIZE)
												.addGap(10).addComponent(suffixTxt, GroupLayout.PREFERRED_SIZE, 60,
														GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup().addGap(30)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(176).addComponent(button_1,
												GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnNewButton))))
				.addContainerGap(43, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(40)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(dirTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
				.addGap(28)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						regTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(beginTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(stepTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(prefixTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(suffixTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
				.addGap(41).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(button_1))
				.addContainerGap(56, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 重命名事件处理
	 */
	private void renameActionPerformed() {
		String dir = dirTxt.getText();
		String reg = regTxt.getText();
		String begin = beginTxt.getText();
		String step = stepTxt.getText();
		String prefix = prefixTxt.getText();
		String suffix = suffixTxt.getText();

		// 检查目录，文件名特征，起始编号和编号间距，它们不可为空
		if (StringUtil.isEmpty(dir)) {
			JOptionPane.showMessageDialog(null, "请选择目录！");
			return;
		}

		if (StringUtil.isEmpty(reg)) {
			JOptionPane.showMessageDialog(null, "请输入正则表达式！");
			return;
		}

		if (StringUtil.isEmpty(begin)) {
			JOptionPane.showMessageDialog(null, "请输入起始编号！");
			return;
		}

		if (StringUtil.isEmpty(step)) {
			JOptionPane.showMessageDialog(null, "请输入编号间距！");
			return;
		}
		try {
			int result = new Renamer(dir, reg, Integer.parseInt(begin), Integer.parseInt(step), prefix, suffix).start();
			JOptionPane.showMessageDialog(null, "重命名成功！" + result + "个文件名已被修改。");
			// 成功后重置表单
			reset();
		} catch (PatternSyntaxException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "正则表达式错误导致无法选中文件，修改失败！请使用java正则表达式规范！");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "请输入正确的起始编号和编号间距，它们都为整数！");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	/**
	 * 重置表单
	 */
	private void reset() {
		dirTxt.setText("");
		regTxt.setText("");
		beginTxt.setText("");
		stepTxt.setText("");
		prefixTxt.setText("");
		suffixTxt.setText("");
	}

	/**
	 * 目录选择事件处理
	 */
	private void chooseDirActionPerformed() {
		// 设置为只选择目录
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int state = fileChooser.showOpenDialog(null);
		if (state == JFileChooser.APPROVE_OPTION) {
			File dir = fileChooser.getSelectedFile();
			dirTxt.setText(dir.toString());
		}
	}

}
