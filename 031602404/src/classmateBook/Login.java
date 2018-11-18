package classmateBook;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Dao.dUsers;
import model.Users;

public class Login extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username = null;
	private JPasswordField password = null;
	private JRadioButton t_rbtn = new JRadioButton("����Ա",true);
	private JRadioButton s_rbtn = new JRadioButton("ѧ��");
	private JRadioButton m_rbtn = new JRadioButton("�೤");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Login frame = new Login();	
					frame.setVisible(true); 			
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}
	public Login() {
		setTitle("ͬѧ¼����ϵͳ");								//���ô������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//�����رհ�ť�ǹر�
		setBounds(500, 200, 350, 250);
		contentPane = new JPanel();								//�������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		//���ñ߿�
		setContentPane(contentPane); 							//Ӧ�����
		contentPane.setLayout(new GridLayout(5, 1, 5, 5));		//���ò��ֹ�����
		JPanel panel1 = new JPanel();							//�������
		FlowLayout flowLayout1 = (FlowLayout) panel1.getLayout();
		flowLayout1.setAlignment(FlowLayout.CENTER);
		contentPane.add(panel1);
		JLabel label1 = new JLabel("��¼");						//����
		panel1.add(label1);
		JPanel panel2 = new JPanel();							
		FlowLayout flowLayout2 = (FlowLayout) panel2.getLayout();
		flowLayout2.setAlignment(FlowLayout.CENTER);
		contentPane.add(panel2);
		JLabel label2 = new JLabel("�û�����");
		panel2.add(label2);
		username = new JTextField();
		panel2.add(username);
		username.setColumns(18);
		JPanel panel3 = new JPanel();
		FlowLayout flowLayout3 = (FlowLayout) panel3.getLayout();
		flowLayout3.setAlignment(FlowLayout.CENTER);
		contentPane.add(panel3);
		JLabel label3 = new JLabel("��    �룺");
		panel3.add(label3);
		password = new JPasswordField();
		password.setColumns(18);
		panel3.add(password);
		JPanel panel4 = new JPanel();
		FlowLayout flowLayout4 = (FlowLayout) panel4.getLayout();
		flowLayout4.setAlignment(FlowLayout.CENTER);
		contentPane.add(panel4);
		panel4.add(t_rbtn);
		panel4.add(s_rbtn);
		panel4.add(m_rbtn);
		ButtonGroup group = new ButtonGroup();
		group.add(t_rbtn);
		group.add(s_rbtn);
		group.add(m_rbtn);
		JPanel panel5 = new JPanel();
		FlowLayout flowLayout5 = (FlowLayout) panel5.getLayout();
		flowLayout5.setAlignment(FlowLayout.CENTER);
		contentPane.add(panel5);
		JButton login = new JButton("��¼");
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String uname = username.getText().trim();			//����û���
				String pswd = new String(password.getPassword());	//�������
				dUsers d=new dUsers();
				Users user=new Users();
				user.setUsno(uname);
				user.setUspassword(pswd);
				if(d.testUsers(user)) {
					JOptionPane.showConfirmDialog(null, "��¼�ɹ���","��Ϣ", JOptionPane.YES_NO_OPTION); 
					
				}
				else {
					JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ�","��Ϣ", JOptionPane.ERROR_MESSAGE);
					
				}

				

				if (s_rbtn.isSelected()) {
				
					S_input s1 = new S_input();		
						s1.setVisible(true);
						Toolkit toolkit = s1.getToolkit();	
						Dimension dm = toolkit.getScreenSize();		
						s1.setLocation((dm.width - s1.getWidth())/2, (dm.height - s1.getHeight())/2);
						dispose();
				} else if (t_rbtn.isSelected()) {
					manager m = new manager();
					m.setVisible(true);
					Toolkit toolkit = m.getToolkit();	
					Dimension dm = toolkit.getScreenSize();		
					m.setLocation((dm.width - m.getWidth())/2, (dm.height - m.getHeight())/2);
					dispose();
				}
				else if (m_rbtn.isSelected()) {
					banzhang b = new banzhang();
					b.setVisible(true);
					Toolkit toolkit = b.getToolkit();	
					Dimension dm = toolkit.getScreenSize();		
					b.setLocation((dm.width - b.getWidth())/2, (dm.height - b.getHeight())/2);
					dispose();

					
				}
			}
		});
		panel5.add(login);
	}
}