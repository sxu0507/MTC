package sxu.tools;

import java.awt.Component;
import java.awt.Point;
import java.awt.Toolkit;

/**
 * 
 * @ClassName: CommonTools
 * @author SXU
 * @date 2013��10��17�� ����11:27:15
 * @Description: 
 *		һЩͨ�ù���
 */
public class CommonTools {

	/**
	 * 
	 * @Method: setWindowCenter
	 * @author SXU
	 * @date 2013��10��17�� ����1:03:45
	 * @Description: 
	 *		������ʾ
	 * @return Point
	 * @param component
	 * @return
	 */
	public static Point setWindowCenter(Component component) {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Point center = new Point();
		center.x = (int) toolkit.getScreenSize().getWidth() / 2
				- component.getWidth() / 2;
		center.y = (int) toolkit.getScreenSize().getHeight() / 2
				- component.getHeight() / 2;
		component.setLocation(center);
		
		return center;
	}
}
