package 学生信息管理系统;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cou extends JFrame {
	public Cou() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(152, 59, 329, 302);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u60A8\u8981\u8FDB\u884C\u7684\u64CD\u4F5C");
		label.setBounds(69, 5, 191, 41);
		panel.add(label);
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JButton button = new JButton("\u67E5\u8BE2\u8BFE\u7A0B\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				QueryCou qc = new QueryCou();
			}
		});
		button.setBounds(94, 59, 140, 47);
		panel.add(button);
		
		JButton button_1 = new JButton("\u6DFB\u52A0\u8BFE\u7A0B\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InsertCou ic = new InsertCou();
			}
		});
		button_1.setBounds(94, 119, 140, 47);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u4FEE\u6539\u8BFE\u7A0B\u4FE1\u606F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String s = null;
				InsertCou uc = new InsertCou(s);
			}
		});
		button_2.setBounds(94, 182, 140, 47);
		panel.add(button_2);
		
		JButton button_3 = new JButton("\u5220\u9664\u8BFE\u7A0B\u4FE1\u606F");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Delete dc = new Delete();
			}
		});
		button_3.setBounds(94, 242, 140, 47);
		panel.add(button_3);
		
		JButton button_4 = new JButton("\u8FD4\u56DE");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin ad = new Admin();
			}
		});
		button_4.setBounds(202, 389, 94, 41);
		getContentPane().add(button_4);
		
		JButton button_5 = new JButton("\u9000\u51FA");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_5.setBounds(345, 389, 94, 41);
		getContentPane().add(button_5);
		
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
