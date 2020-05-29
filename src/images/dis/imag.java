package images.dis;

import javax.swing.ImageIcon;
import images.im;

public class imag {
	
	//Instantiating ImageIcon variables
	
	private static ImageIcon wat = new ImageIcon(im.class.getResource("wat.jpg"));
	private static ImageIcon fir = new ImageIcon(im.class.getResource("fir.jpg"));
	private static ImageIcon gra = new ImageIcon(im.class.getResource("gra.jpg"));
	
	
	//Getter methods
	public static ImageIcon getWater() {
		return wat;
	}
	public static ImageIcon getFire() {
		return fir;
	}
	public static ImageIcon getGrass() {
		return gra;
	}
}
