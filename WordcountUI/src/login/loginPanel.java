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
 * 登陆界面
 */
public class loginPanel extends JPanel implements ActionListener{	
	JLabel jAdminL=new JLabel("用户名:");;           //创建用户名标签
	JLabel jPassWordL=new JLabel("密 码：");       	//创建登录密码标签
	JTextField jAdminT=new JTextField();              //创建用户名输入框
	JPasswordField jPassWordT=new JPasswordField();	//创建密码输入框
	JButton jLoginOk=new JButton("登录");       			//创建登录按钮
	JButton jLoginRe=new JButton("重置");       			//创建重置按钮
	ImageIcon ii;										//创建ImageIcon对象
	JLabel background=new JLabel();						//创建图片标签				
	public loginPanel(){		
		ii=new ImageIcon("res/img/login1.png");			//将图片加载到ImageIcon对象
		background.setIcon(ii);							//将图片添加到标签中
		background.setBounds(125, 10, ii.getIconWidth(), ii.getIconHeight());	//设置标签大小、位置
		this.add(background);							//添加标签到JPanel中
		ii.setImage(ii.getImage().getScaledInstance		//保证图片不会被拉伸
		(ii.getIconWidth(), ii.getIconHeight(), Image.SCALE_DEFAULT)); 		
		this.setLayout(null);						//设置JPanel布局为空										
		jAdminL.setBounds(80,170,80,30);				
		this.add(jAdminL);								//添加用户名标签到登录JPanel中
		jAdminT.setBounds(130,170,240,30);				
		this.add(jAdminT);                         		//添加用户名输入框到登录JPanel中
		jPassWordL.setBounds(80,210,80,30);			
		this.add(jPassWordL);							//添加密码标签到登录JPanel中
		jPassWordT.setBounds(130,210,240,30);
		this.add(jPassWordT);                    		 //添加密码输入框到登录JPanel中
		jLoginOk.setBounds(150,250,80,20);
		this.add(jLoginOk);                     		 //添加登录按钮到登录JPanel中
		jLoginRe.setBounds(260,250,80,20);				
		this.add(jLoginRe);	                    		//添加重置按钮到登录JPanel中
		jLoginOk.addActionListener(this);				//给登录按钮添加监听
		jLoginRe.addActionListener(this);				//给重置按钮添加监听
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0){ 		//登录/重置按钮添加监听
		if(arg0.getSource()==jLoginRe){    				//点击重置按钮
			jAdminT.setText("");						//用户名输入框内容清空
			jPassWordT.setText("");						//密码输入框内容清空
		}
		else if(arg0.getSource()==jLoginOk){        		//点击登陆按钮
			String s=jAdminT.getText().toString();		//添加用户名、密码到字符串中
			String p=jPassWordT.getText().toString();
			if(s.equals("nwnu") && p.equals("2019") ){					//添加用户名、密码到字符串中
				JOptionPane.showMessageDialog(null, "登录成功!");//提示登录成功
                 new firstFrame();//打开主管理界面	
			}
			else{
				jAdminT.setText("");					//用户名输入框内容清空
				jPassWordT.setText("");					//密码输入框内容清空
				JOptionPane.showMessageDialog(null, "用户名或密码错误，请重新输入");//设置提示标签内容
			}
		}
	}
}

