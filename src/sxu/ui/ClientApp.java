package sxu.ui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Paint;
import java.awt.PopupMenu;
import java.awt.Shape;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sxu.tools.CommonTools;

/**
 * 
 * @ClassName: ClientApp
 * @author SXU
 * @date 2013��10��17�� ����1:29:56
 * @Description: 
 *		�ͻ��� ��������
 */
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
		frame.setBackground(new Color(0, 0, 0));
		this.setTray();
		// AWTUtilities.setWindowOpacity(frame, 0.9f);  // ����͸��
		initContentPanel();
	}
	
	/**
	 * 
	 * @Method: initContentPanel
	 * @author SXU
	 * @date 2013��10��17�� ����11:33:08
	 * @Description: 
	 *		��ʼ���������
	 * @return void
	 */
	private void initContentPanel() {
		
		final Paint p = new GradientPaint(0.0f, 0.0f, new Color(66, 194, 110, 100),  
	            frame.getWidth(), frame.getHeight(), new Color(66, 194, 110, 200), true);  
		panel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){  
                Graphics2D g2d = (Graphics2D) g;  
                g2d.setPaint(p);  
                // ���û�����ɫΪ��ɫ  
                g2d.setColor(new Color(215, 217, 219));  
                g2d.fillRect(0, 0, getWidth(), getHeight());  
                  
                // ���û�����ɫΪ��ɫ  
                g2d.setColor(new Color(115, 119, 127));  
                Shape shape = null;  
                shape = new RoundRectangle2D.Double(0, 0, frame.getWidth()-1, frame.getHeight()-1, 6.5D, 6.5D);  
                g2d.draw(shape);          
                  
            }  
		};
		frame.setContentPane(panel);
		panel.setLayout(null);
	}
	
	/**
	 *  
	 * @Method: setTray
	 * @author SXU
	 * @date 2013��10��17�� ����1:28:35
	 * @Description: 
	 *		��������Сͼ��Ͳ˵�
	 * @return void
	 */
    public void setTray() {  
          
        if(SystemTray.isSupported()){//�жϵ�ǰƽ̨�Ƿ�֧�����̹���  
            //��������ʵ��  
            SystemTray tray = SystemTray.getSystemTray();  
            //��������ͼ�꣺1.��ʾͼ��Image 2.ͣ����ʾtext 3.�����˵�popupMenu 4.��������ͼ��ʵ��  
            //1.����Imageͼ��  
            Image image = Toolkit.getDefaultToolkit().getImage("images/trayICO.jpg");  
            //2.ͣ����ʾtext  
            String text = "MTC";  
            //3.�����˵�popupMenu  
            PopupMenu popMenu = new PopupMenu();  
            MenuItem itmOpen = new MenuItem("��");  
            itmOpen.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e) {  
                    //Show();  
                }                 
            });  
            MenuItem itmHide = new MenuItem("����");  
            itmHide.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e) {  
                   // UnVisible();  
                }  
            });  
            MenuItem itmExit = new MenuItem("�˳�");  
            itmExit.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e) {  
                    //Exit();  
                }  
            });  
            popMenu.add(itmOpen);  
            popMenu.add(itmHide);  
            popMenu.add(itmExit);  
              
            //��������ͼ��  
            TrayIcon trayIcon = new TrayIcon(image, text, popMenu);
            //������ͼ��ӵ�������  
            try {  
                tray.add(trayIcon);  
            } catch (AWTException e1) {  
                e1.printStackTrace();  
            }  
        }  
    }  
}
