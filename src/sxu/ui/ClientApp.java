package sxu.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sxu.tools.CommonTools;

import java.awt.BorderLayout;
import java.awt.geom.RoundRectangle2D;

public class ClientApp {

	private JFrame frame;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientApp window = new ClientApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 250);
		frame.setUndecorated(true);
		CommonTools.setWindowCenter(frame);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		initContentPanel();
	}
	
	/**
	 * 
	 * @Method: initContentPanel
	 * @author SXU
	 * @date 2013年10月17日 上午11:33:08
	 * @Description: 
	 *		初始化内容面板
	 * @return void
	 */
	private void initContentPanel() {
		final int R = 66;  
	    final int G = 194;  
	    final int B = 110;
		final Paint p = new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 100),  
	            frame.getWidth(), frame.getHeight(), new Color(R, G, B, 200), true);  
		panel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){  
                Graphics2D g2d = (Graphics2D) g;  
                g2d.setPaint(p);  
                // 设置画笔颜色为白色  
                g2d.setColor(new Color(215, 217, 219));  
                g2d.fillRect(0, 0, getWidth(), getHeight());  
                  
                // 设置画笔颜色为蓝色  
                g2d.setColor(new Color(115, 119, 127));  
                Shape shape = null;  
                shape = new RoundRectangle2D.Double(0, 0, frame.getWidth()-1, frame.getHeight()-1, 6.5D, 6.5D);  
                g2d.draw(shape);          
                  
            }  
		};
		frame.setContentPane(panel);
		
	}

}
