package stack;

public class Rectangle {

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
		return "(X: " + getUpperLeftPoint().getX() + ", Y: " + getUpperLeftPoint().getY() + ", Width: " + getWidth()
				+ ", Height: " + getHeight() + ")";
	}
}
