package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, boolean selected) {
		this(x, y);
		setSelected(selected);
	}

	public void draw(Graphics g) {
		g.setColor(getBojaIvice());
		g.drawLine(this.getX() - 2, this.getY(), this.getX() + 2, this.getY());
		g.drawLine(this.getX(), this.getY() - 2, this.getX(), this.getY() + 2);
		if (isSelected() == true) {
			g.setColor(Color.BLACK);
			g.drawRect(this.getX() - 3, this.getY() - 3, 6, 6);
		}

	}

	@Override
	public boolean contains(int x, int y) {
		if (this.distance(x, y) <= 3) {
			return true;
		} else {
			return false;
		}
	}

	public double distance(int x2, int y2) {
		double dx = this.x - x2;
		double dy = this.y - y2;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void dijalog() {
		DrawingPointDlg drwpoidlg = new DrawingPointDlg();
		for (Shape shape : PnlDrawing.shapesArray) {
			if (shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				drwpoidlg.getTxtXCoord().setText(split[1]);
				drwpoidlg.getTxtYCoord().setText(split[3]);
				shape.moveBy(Integer.parseInt(drwpoidlg.getTxtXCoord().getText()),
						Integer.parseInt(drwpoidlg.getTxtYCoord().getText()));
			}
		}
		drwpoidlg.setVisible(true);
	}

	@Override
	public void moveBy(int newX, int newY) {
		this.x = newX;
		this.y = newY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "( " + this.getX() + " , " + this.getY() + " ) " + isSelected();
	}

	@Override
	public void boji(Graphics g) {
		// Nema povrsinu
	}
}