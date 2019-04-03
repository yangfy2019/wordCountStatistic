package zhujiemian;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

public class chart extends JFrame
{
	DefaultCategoryDataset dataset;
	public chart()
	{
		  JTextField textField = new JTextField();
		  JButton ok = new JButton("ȷ��");
	      JPanel northPanel = new JPanel();
	      northPanel.setLayout(new GridLayout(2, 1));
	      northPanel.add(new JLabel("�����뵥��(�Զ��Ÿ���): "));
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
				dataset = new DefaultCategoryDataset();
				long startTime=System.currentTimeMillis();
				
				String word = textField.getText().toString();
				String[] str = word.split(",");
				for(int i=0;i<str.length;i++)
				{
					if(function.staff.get(str[i])!=null)
					{
						dataset.addValue(function.staff.get(str[i]), "��Ƶ",str[i]);
						textArea.append(str[i]+"\t"+function.staff.get(str[i])+"\n");
					}	
					else
					{
						dataset.addValue(0, "��Ƶ", str[i]);
						textArea.append(str[i]+"\t"+"û���ҵ��õ��ʣ�\n");
					}	
				}
				chart1();
				
				long endTime=System.currentTimeMillis();
				JOptionPane.showMessageDialog(null, "��ʱ:"+(endTime-startTime)+"ms");
			}  
	      });
	      pack();
	      this.setTitle("ָ�����ʴ�Ƶͳ��");
	      this.setBounds(800,400,600,320);
	      this.setVisible(true);							//���ÿɼ�
		  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//����ر�ʱ�ͷ���Դ
	}
	public void chart1()
	{
		JFreeChart chart = ChartFactory.createBarChart(
                "ָ�����ʵĴ�Ƶ��״ͼ",    //����
                "",    //x������
                "",    //y������
                dataset,//���ݼ�
                PlotOrientation.VERTICAL,//ʹ�ô�ֱ��״ͼ
                true,//�Ƿ�ʹ��legend
                false,//�Ƿ�ʹ��tooltip
                false);   //�Ƿ�ʹ��url
		
		Font kfont = new Font("����", Font.PLAIN, 20);    // �ײ�   
        Font titleFont = new Font("����", Font.BOLD, 25); // ͼƬ����   
        // ͼƬ����   
        chart.setTitle(new TextTitle(chart.getTitle().getText(), titleFont));   
        // �ײ�   
        chart.getLegend().setItemFont(kfont);   
		CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot(); 
		BarRenderer barrenderer = new BarRenderer();
		barrenderer.setMaximumBarWidth(0.1);
		barrenderer.setMinimumBarLength(0.1);
		plot.setRenderer(barrenderer);
		BarRenderer customBarRenderer = (BarRenderer) plot.getRenderer(); 
		customBarRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());//��ʾÿ��������ֵ
		customBarRenderer.setBaseItemLabelsVisible(true);
		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();   
        categoryplot.setDomainGridlinesVisible(true);   
        categoryplot.setRangeCrosshairVisible(true);   
        categoryplot.setRangeCrosshairPaint(Color.blue);   
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();   
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());   
        BarRenderer barrenderer1 = (BarRenderer) categoryplot.getRenderer();   
        barrenderer1.setBaseItemLabelFont(new Font("����", Font.PLAIN, 12));   
        barrenderer1.setSeriesItemLabelFont(1, new Font("����", Font.PLAIN, 12));   
        CategoryAxis domainAxis = categoryplot.getDomainAxis();            
        /*------����X�������ϵ�����-----------*/  
        domainAxis.setLabelFont(new Font("sans-serif", Font.PLAIN, 20));   
        /*------����X��ı�������------------*/  
        domainAxis.setLabelFont(new Font("����", Font.PLAIN, 20));   
        /*------����Y�������ϵ�����-----------*/  
        numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));   
        /*------����Y��ı�������------------*/  
        numberaxis.setLabelFont(new Font("����", Font.PLAIN, 12));   
        /*------���������˵ײ��������������-----------*/  
        chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));

		ChartFrame cf = new ChartFrame("��Ƶ��ʾ", chart);
		cf.pack();
		cf.setVisible(true);
	}

}
