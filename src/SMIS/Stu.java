package 学生信息管理系统;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//查询、插入、修改、删除学生信息
public class Stu extends JFrame{
	public Stu() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(151, 27, 330, 305);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u60A8\u8981\u8FDB\u884C\u7684\u64CD\u4F5C");
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label.setBounds(69, 13, 191, 41);
		panel.add(label);
		
		JButton button = new JButton("\u67E5\u8BE2\u5B66\u751F\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				QueryStu qs = new QueryStu();
			}
		});
		button.setBounds(91, 67, 143, 50);
		panel.add(button);
		
		JButton button_1 = new JButton("\u63D2\u5165\u5B66\u751F\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InsertStu is = new InsertStu();
			}
		});
		button_1.setBounds(91, 128, 143, 50);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u4FEE\u6539\u5B66\u751F\u4FE1\u606F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String s = null;
				InsertStu us = new InsertStu(s);
			}
		});
		button_2.setBounds(91, 185, 143, 50);
		panel.add(button_2);
		
		JButton button_3 = new JButton("\u5220\u9664\u5B66\u751F\u4FE1\u606F");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Delete ds = new Delete();
			}
		});
		button_3.setBounds(91, 242, 143, 50);
		panel.add(button_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(179, 367, 272, 49);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton button_4 = new JButton("\u8FD4\u56DE");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin ad = new Admin();
			}
		});
		button_4.setBounds(41, 5, 76, 40);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("\u9000\u51FA");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_5.setBounds(146, 5, 76, 40);
		panel_1.add(button_5);
		
		//给窗口设置标题
		this.setTitle("学生信息管理系统-管理员");
		//设置窗体大小
		this.setSize(650,520);
		//设置窗体初始位置
		this.setLocation(200, 150);
		//设置当关闭窗口时，保证JVM也退出
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//显示窗体
		this.setVisible(true);
		//窗体大小可变
		this.setResizable(true);
	}
}
