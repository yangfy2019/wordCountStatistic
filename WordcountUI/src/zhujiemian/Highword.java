package zhujiemian;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Highword extends JFrame 
{
	public Highword(boolean flag)
	{
		JTextField textField = new JTextField();
		JButton ok = new JButton("ȷ��");
	      JPanel northPanel = new JPanel();
	      northPanel.setLayout(new GridLayout(2, 2));
	      northPanel.add(new JLabel("������Kֵ: "));
	      northPanel.add(textField);
	      northPanel.add(ok);
	      add(northPanel, BorderLayout.NORTH);

	      JTextArea textArea = new JTextArea(20, 5);
	      JScrollPane scrollPane = new JScrollPane(textArea);
	      add(scrollPane, BorderLayout.CENTER);
	      
	      ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				textArea.setText("");
				
				long startTime=System.currentTimeMillis();
				int k=Integer.parseInt(textField.getText().toString());
				for(int i=0;i<k;i++)//10
				{
					boolean ok=false;
					if(flag)
						textArea.append(function.aList.get(i).getKey()+"\t"+function.aList.get(i).getValue()+"\n");
					else
					{
						for(int j=0;j<function.stop.size();j++)
						{
							if(function.aList.get(i).getKey().toLowerCase().equals(function.stop.get(j)))
							{
								k++;
								ok=true;
								break;
							}
						}
						if(!ok)
							textArea.append(function.aList.get(i).getKey()+"\t"+function.aList.get(i).getValue()+"\n");
					}
				}
				long endTime=System.currentTimeMillis();
				JOptionPane.showMessageDialog(null, "��ʱ:"+(endTime-startTime)+"ms");
			}  
	      });
	      pack();
	      if(flag)
	      {
	    	  this.setTitle("��Ƶ��ͳ��");
	    	  this.setBounds(300,200,500,320);
	      }  
	      else
	      {
	    	  this.setTitle("����ʡ����ʡ��ڴʵĸ�Ƶ��ͳ��");
	    	  this.setBounds(300,200,700,320);
	    
	      }
	    	  
	      this.setBounds(300,200,500,320);
	      this.setVisible(true);							//���ÿɼ�
		  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//����ر�ʱ�ͷ���Դ
	}

}
