package zhujiemian;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class firstFrame extends JFrame
{
	String lookAndFeel;       				//������
	firstPanel jfirstPanel = new firstPanel();
	public firstFrame()
	{
		this.setTitle("Ӣ���ı�ͳ�Ʒ�������");				//���ñ���
		jfirstPanel.setBackground(Color.WHITE);        		//������ɫ����Ϊ��ɫ
		Toolkit toolkit=Toolkit.getDefaultToolkit();        //����һ��Toolkit����
		Dimension d=toolkit.getScreenSize();                //���Dimension����
		int x=(int) ((d.width)/2);                    	//��¼��������Ļ��x����
		int y=(int) ((d.height)/2); 
		this.add(jfirstPanel);							//��JPanel������ӵ���¼������
		//this.setBounds(x,y,0,0);				//���ý����С
		this.setBounds(300, 200, x,y);
		this.setVisible(true);							//���ÿɼ�
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//����ر�ʱ�ͷ���Դ
		this.setResizable(true); 						//�����С���ɸı�
		try	{
			lookAndFeel="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
			UIManager.setLookAndFeel(lookAndFeel);		//������۷��			
		}
		catch(Exception e){	e.printStackTrace();}
	}

}
