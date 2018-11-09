import java.awt.Color;
import java.util.Arrays;
public class SeamCarver {
	public int BORDER_ENERGY = 1000;
	public Picture picture;
	public int width;
    public int height;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture1) {
		if(picture == null) {
			throw new IllegalArgumentException("picture is null");
		}
		this.picture = picture1;
		this.width = picture.width();
        this.height = picture.height();
	}
	// current picture
	public Picture picture() {
		return picture;
	}
	// width of current picture
	public int width() {
		return width;
	}

	// height of current picture
	public int height() {
		return height;
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		double deltax = 0.0;
		double deltay = 0.0;
		if (x == 0 || y == 0 || x == picture.width() - 1 || y == picture.height() - 1) {
			return BORDER_ENERGY;
		} else {
			Color hozright = picture.get(x+1, y);
			Color hozleft = picture.get(x-1, y);
			Color vertop = picture.get(x, y-1);
			Color verbottom = picture.get(x, y+1);
			deltax = (Math.pow((hozright.getRed() - hozleft.getRed()), 2) +
				      Math.pow((hozright.getGreen() - hozleft.getGreen()), 2) +
				      Math.pow((hozright.getBlue() - hozleft.getBlue()), 2));
			deltay = (Math.pow((vertop.getRed() - verbottom.getRed()), 2) +
				      Math.pow((vertop.getGreen() - verbottom.getGreen()), 2) +
				      Math.pow((vertop.getBlue() - verbottom.getBlue()), 2));
			return Math.sqrt(deltax + deltay);
		}
	}

	public double[][] transpose(double[][] matrix) {
    	int m = matrix.length;
    	int n = matrix[0].length;

      	double transpose[][] = new double[n][m];
      	for (int i = 0; i < m; i++)
        	for (int j = 0; j < n; j++)
            	transpose[j][i] = matrix[i][j];
        return transpose;
    }

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		double[][] sum = new double[width][height];
        int[][] parent = new int[width][height];
        for (int y = 0; y < height; ++y) {
            sum[0][y] = BORDER_ENERGY;
            parent[0][y] = y;
        }

        for (int x = 1; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                double temp = sum[x - 1][y];
                // parent[x][y] = y;
                if (y > 0 && sum[x - 1][y - 1] < temp) {
                    temp = sum[x - 1][y - 1];
                    // parent[x][y] = y - 1;
                }

                if (y < height - 1 && sum[x - 1][y + 1] < temp) {
                    temp = sum[x - 1][y + 1];
                    // parent[x][y] = y + 1;
                }
                sum[x][y] = energy(x, y) + temp;
            }
		}
		for (int x = 1; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                double temp = sum[x - 1][y];
                parent[x][y] = y;
                if (y > 0 && sum[x - 1][y - 1] < temp) {
                    temp = sum[x - 1][y - 1];
                    parent[x][y] = y - 1;
                }

                if (y < height - 1 && sum[x - 1][y + 1] < temp) {
                    temp = sum[x - 1][y + 1];
                    parent[x][y] = y + 1;
                }
            }
        }

        int index = 0;
        for (int y = 1; y < height; ++y) {
            if (sum[width - 1][y] < sum[width - 1][index]) {
                index = y;
            }
        }
        int[] seam = new int[width];
        seam[width - 1] = index;
        for (int x = width - 2; x >= 0; --x) {
            seam[x] = parent[x + 1][index];
            index = parent[x + 1][index];
        }
        return seam;
    }

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		double[][] sum = new double[width][height];
        int[][] parent = new int[width][height];
        for (int x = 0; x < width; ++x) {
            sum[x][0] = BORDER_ENERGY;
            parent[x][0] = x;
        }
        System.out.println(Arrays.deepToString(sum));
        System.out.println(Arrays.deepToString(parent));
        // adding pixel energy with least adjucent pixel
        for (int y = 1; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                double temp = sum[x][y - 1];
                 parent[x][y] = x;
                if (x > 0 && sum[x - 1][y - 1] < temp) {
                    temp = sum[x - 1][y - 1];
                     parent[x][y] = x - 1;
                }

                if (x < width - 1 && sum[x + 1][y - 1] < temp) {
                    temp = sum[x + 1][y - 1];
                     parent[x][y] = x + 1;
                }
                sum[x][y] = energy(x, y) + temp;
            }
		}
		int index = 0;
        for (int x = 1; x < width; ++x) {
            if (sum[x][height - 1] < sum[index][height - 1]) {
            	index = x;
            }
        }
        int[] seam = new int[height];
        seam[height - 1] = index;
        for (int y = height - 2; y >= 0; --y) {
            seam[y] = parent[index][y + 1];
            index = parent[index][y + 1];
        }
        return seam;
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {
		if (seam == null || seam.length != width) {
            throw new IllegalArgumentException("Seam is illegal.");
        }

        if (height <= 1) {
            throw new IllegalArgumentException("Height of the picture is less than or equal to 1");
        }

        for (int x = 0; x < width; ++x) {
            for (int y = seam[x]; y < height - 1; ++y) {
                picture.set(x, y, picture.get(x, y + 1));
            }
        }

        --height;
	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {
		if (seam == null || seam.length != height) {
            throw new IllegalArgumentException("Seam is illegal.");
        }

        if (width <= 1) {
            throw new IllegalArgumentException("Width of the picture is less than or equal to 1");
        }

        for (int y = 0; y < height; ++y) {
            for (int x = seam[y]; x < width - 1; ++x) {
                picture.set(x, y, picture.get(x + 1, y));
            }
        }

        --width;
	}
}