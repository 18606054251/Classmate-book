package frame;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Dao.dUsers;
import model.Users;

import javax.swing.JLabel;
import javax.swing.JOptionPane;





public class S_input extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField stu_name = null;
	private JTextField stu_address = null;
	private JTextField stu_phone = null;
	private JTextField stu_wechat = null;
	private JTextField stu_email = null;
	private JTextField stu_qq = null;
	private JTextArea stu_message = null;


	
	public S_input() {
		setTitle("学生信息导入");								//设置窗体标题
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//单击关闭按钮是关闭
		setSize(300,700);
		

		
		JLabel label1 = new JLabel("姓名：");
		stu_name = new  JTextField();
		stu_name.setColumns(18);

		
	
		JLabel label2 = new JLabel("家庭住址：");
		stu_address= new  JTextField();
		stu_address.setColumns(18);
		
		
		JLabel label3 = new JLabel("电话：");
		stu_phone= new  JTextField();
		stu_phone.setColumns(18);

		
		JLabel label4 = new JLabel("微信：");
		stu_wechat= new  JTextField();
		stu_wechat.setColumns(18);
		
		JLabel label5 = new JLabel("邮箱：");
		stu_email= new  JTextField();
		stu_email.setColumns(18);
		
		JLabel label6 = new JLabel("QQ：");
		stu_qq= new  JTextField();
		stu_qq.setColumns(18);
		
		
		JLabel label7 = new JLabel("个性语言：");
		stu_message= new JTextArea(20,10);
		JScrollPane sPane  = new JScrollPane(stu_message);
		
		JButton jb1 = new JButton("提交");

		GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        
		
		this.add(label1);
		this.add(stu_name);
		this.add(label2);
		this.add(stu_address);
		this.add(label3);
		this.add(stu_phone);
		this.add(label4);
		this.add(stu_wechat);
		this.add(label5);
		this.add(stu_email);
		this.add(label6);
		this.add(stu_qq);
		this.add(label7);
		this.add(sPane);
		this.add(jb1);
		
		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		s.gridx = 0;
		s.gridy = 0;
		s.gridwidth = 1;

        layout.setConstraints(label1, s);
		s.gridx = 0;
		s.gridy = 1;
        layout.setConstraints(stu_name, s);
		s.gridx = 0;
		s.gridy = 2;
        layout.setConstraints(label2, s);
		s.gridx = 0;
		s.gridy = 3;
        layout.setConstraints(stu_address, s);
		s.gridx = 0;
		s.gridy = 4;
        layout.setConstraints(label3, s);
		s.gridx = 0;
		s.gridy = 5;
        layout.setConstraints(stu_phone, s);
		s.gridx = 0;
		s.gridy = 6;
        layout.setConstraints(label4, s);
		s.gridx = 0;
		s.gridy = 7;
        layout.setConstraints(stu_wechat, s);
		s.gridx = 0;
		s.gridy = 8;
        layout.setConstraints(label5, s);
		s.gridx = 0;
		s.gridy = 9;
        layout.setConstraints(stu_email, s);
		s.gridx = 0;
		s.gridy = 10;
        layout.setConstraints(label6, s);
		s.gridx = 0;
		s.gridy = 11;
        layout.setConstraints(stu_qq, s);
		s.gridx = 0;
		s.gridy = 12;
        layout.setConstraints(label7, s);
		s.gridx = 0;
		s.gridy = 13;

        layout.setConstraints(sPane, s);
		s.gridx = 0;
		s.gridy = 15;
		s.gridwidth = 1;
		layout.setConstraints(jb1, s);
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Users user = new Users();
				user.setUsname(stu_name.getText());
				user.setUsaddress(stu_address.getText());
				user.setUsdiy(stu_phone.getText());
				user.setUsweixin(stu_wechat.getText());
				user.setUsyouxiangadd(stu_email.getText());
				user.setUsqq(stu_qq.getText());
				
				dUsers dUser = new dUsers();
				dUser.editUser(user);
				JOptionPane.showConfirmDialog(null, "修改成功！", "消息", JOptionPane.YES_NO_OPTION);
			}
		});



}
}

