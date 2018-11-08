import java.awt.Color;
public class SeamCarver {
	Picture picture;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture1) {
		this.picture = picture1;
	}
	// current picture
	public Picture picture() {
		return picture;
	}
	// width of current picture
	public int width() {
		return picture.width();
	}

	// height of current picture
	public int height() {
		return picture.height();
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		double deltax = 0.0;
		double deltay = 0.0;
		if (x == 0 || y == 0 || picture.height() - 1 == 0 || picture.width() - 1 == 0) {
			return 1000;
		} else {
			Color hozright = picture.get(x+1, y);
			Color hozleft = picture.get(x-1, y);
			Color vertop = picture.get(x, y-1);
			Color verbottom = picture.get(x, y+1);
			deltax = (Math.pow((hozright.getRed() - hozleft.getRed()), 2) + Math.pow((hozright.getGreen() - hozleft.getGreen()), 2) + Math.pow((hozright.getBlue() - hozleft.getBlue()), 2));
			deltay = (Math.pow((vertop.getRed() - verbottom.getRed()), 2) + Math.pow((vertop.getGreen() - verbottom.getGreen()), 2) + Math.pow((vertop.getBlue() - verbottom.getBlue()), 2));
			return Math.sqrt(deltax + deltay);
		}
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}