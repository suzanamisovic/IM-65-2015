package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class PnlDrawing extends JPanel implements MouseListener {
	int mouseClickX, mouseClickY, startX, startY, endX, endY, radius, donutRadius, donutInnerRadius, width, height;
	int click = 1;
	Color bojaIvice;
	Color bojaPovrsine;
	static int obj = 0;
	boolean lineStartTrue, lineEndTrue, rectTrue, cirTrue, donTrue, pointTrue;
	
	static ArrayList<Shape> shapesArray = new ArrayList<Shape>();

	public PnlDrawing() {
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		mouseClickX = e.getX();
		mouseClickY = e.getY();
		switch (obj) {
		case 1:
			pointTrue = true;
			bojaIvice = DrawingApp.bojaIvice;
			break;
		case 2:
			if (click % 2 == 0) {
				startX = e.getX();
				startY = e.getY();
				lineStartTrue = true;
			}
			if (click % 2 != 0) {
				endX = e.getX();
				endY = e.getY();
				bojaIvice = DrawingApp.bojaIvice;
				lineEndTrue = true;
			}
			break;

		case 3:
			DrawingRectangleDlg drwrecdlg = new DrawingRectangleDlg();
			drwrecdlg.getTxtXCoord().setText(String.valueOf(mouseClickX));
			drwrecdlg.getTxtYCoord().setText(String.valueOf(mouseClickY));
			drwrecdlg.getTxtXCoord().setEditable(false);
			drwrecdlg.getTxtYCoord().setEditable(false);
			drwrecdlg.getBtnPromenaBoje().setEnabled(true);
			drwrecdlg.getBtnPromenaFill().setEnabled(true);
			drwrecdlg.setVisible(true);

			if (drwrecdlg.isOk) {
				width = Integer.parseInt(drwrecdlg.getTxtSirina().getText());
				height = Integer.parseInt(drwrecdlg.getTxtVisina().getText());

				bojaIvice = drwrecdlg.getBoja();
				bojaPovrsine = drwrecdlg.getBojaPovrsine();

				if (!drwrecdlg.isBojaPovrsineSelektovana() && !drwrecdlg.isBojaIviceSelektovana()) {
					bojaIvice = DrawingApp.bojaIvice;
					bojaPovrsine = DrawingApp.bojaPovrsine;
				}

				rectTrue = true;
			}
			break;

		case 4:
			DrawingCircleDlg drwcirdlg = new DrawingCircleDlg();
			drwcirdlg.getTxtXCoord().setText(String.valueOf(mouseClickX));
			drwcirdlg.getTxtYCoord().setText(String.valueOf(mouseClickY));
			drwcirdlg.getTxtXCoord().setEditable(false);
			drwcirdlg.getTxtYCoord().setEditable(false);
			drwcirdlg.getBtnPromenaBoje().setEnabled(true);
			drwcirdlg.getBtnPromenaBojeKruga().setEnabled(true);
			drwcirdlg.setVisible(true);
			if (drwcirdlg.isOk) {
				radius = Integer.parseInt(drwcirdlg.getTxtRadius().getText());

				bojaIvice = drwcirdlg.getBoja();
				bojaPovrsine = drwcirdlg.getBojaPovrsine();

				if (!drwcirdlg.isBojaPovrsineSelektovana() && !drwcirdlg.isBojaIviceSelektovana()) {
					bojaIvice = DrawingApp.bojaIvice;
					bojaPovrsine = DrawingApp.bojaPovrsine;
				}

				cirTrue = true;
			}
			break;

		case 5:
			DrawingDonutDlg drwdondlg = new DrawingDonutDlg();
			drwdondlg.getTxtXCoord().setText(String.valueOf(mouseClickX));
			drwdondlg.getTxtYCoord().setText(String.valueOf(mouseClickY));
			drwdondlg.getTxtXCoord().setEditable(false);
			drwdondlg.getTxtYCoord().setEditable(false);
			drwdondlg.getBtnPromenaBoje().setEnabled(true);
			drwdondlg.getBtnPromenaBojeKruga().setEnabled(true);
			drwdondlg.setVisible(true);
			if (drwdondlg.isOk == true) {
				donutRadius = Integer.parseInt(drwdondlg.getTxtSP().getText());
				donutInnerRadius = Integer.parseInt(drwdondlg.getTxtUP().getText());

				bojaIvice = drwdondlg.getBoja();
				bojaPovrsine = drwdondlg.getBojaPovrsine();

				if (!drwdondlg.isBojaPovrsineSelektovana() && !drwdondlg.isBojaIviceSelektovana()) {
					bojaIvice = DrawingApp.bojaIvice;
					bojaPovrsine = DrawingApp.bojaPovrsine;
				}

				donTrue = true;
			}
			break;

		case 6:
			boolean matchFound = false;
			Collections.reverse(shapesArray);
			for (Shape shape : shapesArray) {
				shape.setSelected(false);
				if (matchFound == false) {
					if (shape.contains(mouseClickX, mouseClickY)) {
						shape.setSelected(true);
						matchFound = true;
					}
				}
			}
			Collections.reverse(shapesArray);
			System.out.println(shapesArray);
			break;

		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		switch (obj) {
		case 1:
			if (pointTrue == true) {
				Point p = new Point(mouseClickX, mouseClickY, false);
				shapesArray.add(p);
				p.setBojaIvice(bojaIvice);
				System.out.println(shapesArray.get(shapesArray.size() - 1));
				pointTrue = false;
			}
			break;
		case 2:
			if (lineStartTrue == true && lineEndTrue == true) {
				Line l = new Line(new Point(startX, startY), new Point(endX, endY), false);
				shapesArray.add(l);
				l.setBojaIvice(bojaIvice);
				System.out.println(shapesArray.get(shapesArray.size() - 1));
				lineStartTrue = false;
				lineEndTrue = false;

			}
			break;
		case 3:
			if (rectTrue == true) {
				Rectangle r = new Rectangle(new Point(mouseClickX, mouseClickY), width, height, false);
				shapesArray.add(r);
				r.setBojaIvice(bojaIvice);
				r.setBojaPovrsine(bojaPovrsine);
				System.out.println(shapesArray.get(shapesArray.size() - 1));
				rectTrue = false;
			}
			break;
		case 4:
			if (cirTrue == true) {
				Circle c = new Circle(new Point(mouseClickX, mouseClickY), radius, false);
				shapesArray.add(c);
				c.setBojaIvice(bojaIvice);
				c.setBojaPovrsine(bojaPovrsine);
				System.out.println(shapesArray.get(shapesArray.size() - 1));
				cirTrue = false;
			}
			break;
		case 5:
			if (donTrue == true) {
				Donut d = new Donut(new Point(mouseClickX, mouseClickY), donutRadius, donutInnerRadius, false);
				shapesArray.add(d);
				d.setBojaIvice(bojaIvice);
				d.setBojaPovrsine(bojaPovrsine);
				System.out.println(shapesArray.get(shapesArray.size() - 1));
				donTrue = false;
			}
			break;
		}

		for (Shape shape : shapesArray) {
			shape.boji(g);
			shape.draw(g);
		}
		repaint();
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		switch (obj) {
		case 2:
			click++;
		}
	}
}