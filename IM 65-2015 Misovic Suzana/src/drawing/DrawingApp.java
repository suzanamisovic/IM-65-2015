package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.SystemColor;

public class DrawingApp extends JFrame {

	private JPanel contentPane;
	private PnlDrawing pnlCenter;
	static Color bojaIvice = Color.BLACK;
	static Color bojaPovrsine = Color.WHITE;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingApp frame = new DrawingApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DrawingApp() {
		setTitle("Drawing - IM 65-2015 Misovic Suzana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pnlTop = new JPanel();
		pnlTop.setBackground(SystemColor.window);
		contentPane.add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnPoint = new JButton("Point");
		pnlTop.add(btnPoint);
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 1;
				for (Shape shape : PnlDrawing.shapesArray) {
					shape.setSelected(false);
				}

			}
		});

		JButton btnLine = new JButton("Line");
		pnlTop.add(btnLine);
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 2;
				for (Shape shape : PnlDrawing.shapesArray) {
					shape.setSelected(false);
				}
			}
		});

		JButton btnRectangle = new JButton("Rectangle");
		pnlTop.add(btnRectangle);
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 3;
				for (Shape shape : PnlDrawing.shapesArray) {
					shape.setSelected(false);
				}
			}
		});

		JButton btnCircle = new JButton("Circle");
		pnlTop.add(btnCircle);
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 4;
				for (Shape shape : PnlDrawing.shapesArray) {
					shape.setSelected(false);
				}
			}
		});

		JButton btnDonut = new JButton("Donut");
		pnlTop.add(btnDonut);
		btnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 5;
				for (Shape shape : PnlDrawing.shapesArray) {
					shape.setSelected(false);
				}
			}
		});

		pnlCenter = new PnlDrawing();
		pnlCenter.setBackground(Color.WHITE);
		pnlCenter.setBorder(null);
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
				gl_pnlCenter.createParallelGroup(Alignment.LEADING).addGap(0, 728, Short.MAX_VALUE));
		gl_pnlCenter
				.setVerticalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addGap(0, 358, Short.MAX_VALUE));
		pnlCenter.setLayout(gl_pnlCenter);

		JPanel pnlBottom = new JPanel();
		pnlBottom.setBackground(SystemColor.window);
		contentPane.add(pnlBottom, BorderLayout.SOUTH);
		pnlBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnSelect = new JButton("Select");
		pnlBottom.add(btnSelect);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PnlDrawing.shapesArray.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nema objekata za selektovanje!", "Obavestenje",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					PnlDrawing.obj = 6;
				}
			}
		});

		JButton btnModify = new JButton("Edit");
		pnlBottom.add(btnModify);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PnlDrawing.shapesArray.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nema objekata za modifikacuju!", "Obavestenje",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				for (Shape shape : PnlDrawing.shapesArray) {
					if (shape.isSelected()) {
						shape.dijalog();
						return;
					}

				}
				JOptionPane.showMessageDialog(null, "Pre modifikovanja morate selektovati objekat!", "Obavestenje",
						JOptionPane.INFORMATION_MESSAGE);

			}

		});

		JButton btnDelete = new JButton("Delete");
		pnlBottom.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PnlDrawing.shapesArray.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nema objekata za brisanje!", "Obavestenje",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				for (Shape shape : PnlDrawing.shapesArray) {
					if (shape.isSelected()) {
						int odgovor = JOptionPane.showConfirmDialog(null,
								"Da li zelite da izbrisete selektovani objekat?", "Upozorenje",
								JOptionPane.YES_NO_OPTION);
						if (odgovor == 0) {
							PnlDrawing.shapesArray.remove(shape);
						}
						return;
					}

				}
				JOptionPane.showMessageDialog(null, "Pre brisanja morate selektovati objekat!", "Obavestenje",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

	}
}