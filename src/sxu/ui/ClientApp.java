package sxu.ui;

import java.awt.AWTException;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sxu.module.RoundButton;
import sxu.tools.CommonTools;

import com.sun.awt.AWTUtilities;

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
	private JButton closeBtn;

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
		
		frame.setBounds(100, 100, 200, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CommonTools.setWindowCenter(frame);
		frame.setUndecorated(true);
		// ����frameԲ��
		AWTUtilities.setWindowShape(frame,  
		        new RoundRectangle2D.Double(0.0D, 0.0D, frame.getWidth(),  
		        		frame.getHeight(), 8D, 8D));  
		// ��������ͼ�꼰�˵�
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
                g2d.setColor(new Color(215, 217, 219));
                g2d.fillRect(0, 0, getWidth(), getHeight());  
                  
                g2d.setColor(new Color(115, 119, 127));  
                Shape shape = null;  
                shape = new RoundRectangle2D.Double(0, 0, frame.getWidth()-1, frame.getHeight()-1, 8D, 8D);  
                g2d.draw(shape);          
            }  
		};
		frame.setContentPane(panel);
		panel.setLayout(null);
		
//		closeBtn = new RoundButton("");
//		closeBtn.setBounds(180, 5, 15, 15);
//		closeBtn.setBorder(null);
		
		initCloseBtn();
	}
	
	private void initCloseBtn() {
		closeBtn = new JButton();
		closeBtn.setBounds(180, 5, 15, 15);
		ImageIcon icon= new ImageIcon("images/hui.png");
		closeBtn.setIcon(icon);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false); 
		
		closeBtn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {  
				ImageIcon ic = new ImageIcon("images/hui.png");
				closeBtn.setIcon(ic);
            }
			
			@Override  
			public void mouseEntered(MouseEvent e) {  
				ImageIcon ic = new ImageIcon("images/h.png");
				closeBtn.setIcon(ic);
            }

		});
		panel.add(closeBtn);
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
