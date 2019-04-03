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
		  JButton ok = new JButton("确定");
	      JPanel northPanel = new JPanel();
	      northPanel.setLayout(new GridLayout(2, 1));
	      northPanel.add(new JLabel("请输入单词(以逗号隔开): "));
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
						dataset.addValue(function.staff.get(str[i]), "词频",str[i]);
						textArea.append(str[i]+"\t"+function.staff.get(str[i])+"\n");
					}	
					else
					{
						dataset.addValue(0, "词频", str[i]);
						textArea.append(str[i]+"\t"+"没有找到该单词！\n");
					}	
				}
				chart1();
				
				long endTime=System.currentTimeMillis();
				JOptionPane.showMessageDialog(null, "耗时:"+(endTime-startTime)+"ms");
			}  
	      });
	      pack();
	      this.setTitle("指定单词词频统计");
	      this.setBounds(800,400,600,320);
	      this.setVisible(true);							//设置可见
		  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//界面关闭时释放资源
	}
	public void chart1()
	{
		JFreeChart chart = ChartFactory.createBarChart(
                "指定单词的词频柱状图",    //标题
                "",    //x轴名称
                "",    //y轴名称
                dataset,//数据集
                PlotOrientation.VERTICAL,//使用垂直柱状图
                true,//是否使用legend
                false,//是否使用tooltip
                false);   //是否使用url
		
		Font kfont = new Font("宋体", Font.PLAIN, 20);    // 底部   
        Font titleFont = new Font("宋体", Font.BOLD, 25); // 图片标题   
        // 图片标题   
        chart.setTitle(new TextTitle(chart.getTitle().getText(), titleFont));   
        // 底部   
        chart.getLegend().setItemFont(kfont);   
		CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot(); 
		BarRenderer barrenderer = new BarRenderer();
		barrenderer.setMaximumBarWidth(0.1);
		barrenderer.setMinimumBarLength(0.1);
		plot.setRenderer(barrenderer);
		BarRenderer customBarRenderer = (BarRenderer) plot.getRenderer(); 
		customBarRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());//显示每个柱的数值
		customBarRenderer.setBaseItemLabelsVisible(true);
		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();   
        categoryplot.setDomainGridlinesVisible(true);   
        categoryplot.setRangeCrosshairVisible(true);   
        categoryplot.setRangeCrosshairPaint(Color.blue);   
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();   
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());   
        BarRenderer barrenderer1 = (BarRenderer) categoryplot.getRenderer();   
        barrenderer1.setBaseItemLabelFont(new Font("宋体", Font.PLAIN, 12));   
        barrenderer1.setSeriesItemLabelFont(1, new Font("宋体", Font.PLAIN, 12));   
        CategoryAxis domainAxis = categoryplot.getDomainAxis();            
        /*------设置X轴坐标上的文字-----------*/  
        domainAxis.setLabelFont(new Font("sans-serif", Font.PLAIN, 20));   
        /*------设置X轴的标题文字------------*/  
        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 20));   
        /*------设置Y轴坐标上的文字-----------*/  
        numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));   
        /*------设置Y轴的标题文字------------*/  
        numberaxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));   
        /*------这句代码解决了底部汉字乱码的问题-----------*/  
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));

		ChartFrame cf = new ChartFrame("词频显示", chart);
		cf.pack();
		cf.setVisible(true);
	}

}
