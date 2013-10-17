package sxu.tools;

import java.awt.Component;
import java.awt.Point;
import java.awt.Toolkit;

/**
 * 
 * @ClassName: CommonTools
 * @author SXU
 * @date 2013年10月17日 上午11:27:15
 * @Description: 
 *		一些通用工具
 */
public class CommonTools {

	/**
	 * 
	 * @Method: setWindowCenter
	 * @author SXU
	 * @date 2013年10月17日 下午1:03:45
	 * @Description: 
	 *		居中显示
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
