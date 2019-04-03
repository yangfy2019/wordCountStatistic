package login;

import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import zhujiemian.firstFrame;

import javax.swing.JOptionPane;


/**
 * ��½����
 */
public class loginPanel extends JPanel implements ActionListener{	
	JLabel jAdminL=new JLabel("�û���:");;           //�����û�����ǩ
	JLabel jPassWordL=new JLabel("�� �룺");       	//������¼�����ǩ
	JTextField jAdminT=new JTextField();              //�����û��������
	JPasswordField jPassWordT=new JPasswordField();	//�������������
	JButton jLoginOk=new JButton("��¼");       			//������¼��ť
	JButton jLoginRe=new JButton("����");       			//�������ð�ť
	ImageIcon ii;										//����ImageIcon����
	JLabel background=new JLabel();						//����ͼƬ��ǩ				
	public loginPanel(){		
		ii=new ImageIcon("res/img/login1.png");			//��ͼƬ���ص�ImageIcon����
		background.setIcon(ii);							//��ͼƬ��ӵ���ǩ��
		background.setBounds(125, 10, ii.getIconWidth(), ii.getIconHeight());	//���ñ�ǩ��С��λ��
		this.add(background);							//��ӱ�ǩ��JPanel��
		ii.setImage(ii.getImage().getScaledInstance		//��֤ͼƬ���ᱻ����
		(ii.getIconWidth(), ii.getIconHeight(), Image.SCALE_DEFAULT)); 		
		this.setLayout(null);						//����JPanel����Ϊ��										
		jAdminL.setBounds(80,170,80,30);				
		this.add(jAdminL);								//����û�����ǩ����¼JPanel��
		jAdminT.setBounds(130,170,240,30);				
		this.add(jAdminT);                         		//����û�������򵽵�¼JPanel��
		jPassWordL.setBounds(80,210,80,30);			
		this.add(jPassWordL);							//��������ǩ����¼JPanel��
		jPassWordT.setBounds(130,210,240,30);
		this.add(jPassWordT);                    		 //�����������򵽵�¼JPanel��
		jLoginOk.setBounds(150,250,80,20);
		this.add(jLoginOk);                     		 //��ӵ�¼��ť����¼JPanel��
		jLoginRe.setBounds(260,250,80,20);				
		this.add(jLoginRe);	                    		//������ð�ť����¼JPanel��
		jLoginOk.addActionListener(this);				//����¼��ť��Ӽ���
		jLoginRe.addActionListener(this);				//�����ð�ť��Ӽ���
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0){ 		//��¼/���ð�ť��Ӽ���
		if(arg0.getSource()==jLoginRe){    				//������ð�ť
			jAdminT.setText("");						//�û���������������
			jPassWordT.setText("");						//����������������
		}
		else if(arg0.getSource()==jLoginOk){        		//�����½��ť
			String s=jAdminT.getText().toString();		//����û��������뵽�ַ�����
			String p=jPassWordT.getText().toString();
			if(s.equals("nwnu") && p.equals("2019") ){					//����û��������뵽�ַ�����
				JOptionPane.showMessageDialog(null, "��¼�ɹ�!");//��ʾ��¼�ɹ�
                 new firstFrame();//�����������	
			}
			else{
				jAdminT.setText("");					//�û���������������
				jPassWordT.setText("");					//����������������
				JOptionPane.showMessageDialog(null, "�û����������������������");//������ʾ��ǩ����
			}
		}
	}
}

