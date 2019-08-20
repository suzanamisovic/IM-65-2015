package drawing;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Comparable, Moveable {

	private boolean selected;
	private Color bojaIvice = Color.BLACK;
	private Color bojaPovrsine = Color.WHITE;

	public Shape() {

	}

	public abstract void boji(Graphics g);

	public Shape(boolean selected) {
		this.selected = selected;
	}

	public abstract boolean contains(int x, int y);

	public abstract void draw(Graphics g);

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public abstract void dijalog();

	public void setBojaIvice(Color bojaIvice) {
		this.bojaIvice = bojaIvice;
	}

	public Color getBojaIvice() {
		return bojaIvice;
	}

	public Color getBojaPovrsine() {
		return bojaPovrsine;
	}

	public void setBojaPovrsine(Color bojaPovrsine) {
		this.bojaPovrsine = bojaPovrsine;
	}
}
