package sort;

public class Rectangle implements Comparable {

	private Point upperLeftPoint;
	private int width;
	private int height;

	public Rectangle() {

	}

	public Rectangle(Point upperLeftPoint, int height, int width) {
		this.upperLeftPoint = upperLeftPoint;
		this.height = height;
		this.width = width;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Rectangle) {
			// logika za poredjenje povrsine koja se koristi pri sortiranju
			return (int) (this.area() - ((Rectangle) o).area());
		}
		return 0;
	}

	public int area() {
		return width * height;
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String toString() {
		return "Upper left point: " + upperLeftPoint + ", height: " + height + ", width: " + width;
	}

}
