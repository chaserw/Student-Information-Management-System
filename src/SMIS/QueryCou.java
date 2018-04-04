package 学生信息管理系统;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QueryCou extends JFrame {
	private JTable table;
	public QueryCou() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 148, 525, 180);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(30);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\u8BFE\u7A0B\u540D", "\u8BFE\u7A0B\u53F7", "\u5B66\u5206"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		MysqlConn.ConnectSQL();
		MysqlConn.getdatacou();
		
		if(MysqlConn.counter == 0){
			JOptionPane.showMessageDialog(null, "课程还未导入!", "提示消息", JOptionPane.ERROR_MESSAGE);
		}
			
		for(int i = 0; i < MysqlConn.counter; i++){
			table.setValueAt(MysqlConn.c_name[i], i, 0);
			table.setValueAt(MysqlConn.c_no[i], i, 1);
			table.setValueAt(MysqlConn.credit[i], i, 2);
		}
		
		JLabel label = new JLabel("\u6240\u6709\u8BFE\u7A0B\u4FE1\u606F\u5982\u4E0B\uFF1A");
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label.setBounds(235, 76, 164, 45);
		getContentPane().add(label);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Cou co = new Cou();
			}
		});
		button.setBounds(199, 367, 89, 36);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setBounds(362, 367, 89, 36);
		getContentPane().add(button_1);
		
		//给窗口设置标题
		this.setTitle("学生信息管理系统-管理员-查询课程信息");
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
