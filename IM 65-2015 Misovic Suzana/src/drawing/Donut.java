package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Area;

public class Donut extends Circle {
	private int innerRadius;

	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		setSelected(selected);
	}

	@Override
	public boolean contains(int x, int y) {
		double dFromDistance = this.getCenter().distance(x, y);
		return super.contains(x, y) && dFromDistance > innerRadius;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getBojaIvice());
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(),
				this.getInnerRadius() * 2, this.getInnerRadius() * 2);
		super.draw(g);
	}

	@Override
	public void boji(Graphics g) {
		super.boji(g);
		g.setColor(getBojaPovrsine());
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(),
				this.getInnerRadius() * 2, this.getInnerRadius() * 2);
		g.setColor(Color.WHITE);
		g.fillOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(),
				this.getInnerRadius() * 2, this.getInnerRadius() * 2);
	}

	@Override
	public void dijalog() {
		DrawingDonutDlg drwdondlg = new DrawingDonutDlg();
		for (Shape shape : PnlDrawing.shapesArray) {
			if (shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				drwdondlg.getTxtXCoord().setText(split[3]);
				drwdondlg.getTxtYCoord().setText(split[5]);
				drwdondlg.getTxtSP().setText(split[9]);
				drwdondlg.getTxtUP().setText(split[14]);
			}
		}
		drwdondlg.setVisible(true);
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

	public String toString() {
		return super.toString() + ", inner radius: " + innerRadius + " " + isSelected();
	}

}