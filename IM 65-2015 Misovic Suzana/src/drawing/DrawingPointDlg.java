package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DrawingPointDlg extends JDialog {

	private final JPanel pnlCentar = new JPanel();
	private JButton btnPotvrdi;
	private JButton btnPonisti;
	private JTextField txtXCoord;
	private JTextField txtYCoord;
	private int xPoint;
	private int yPoint;
	private Color boja = Color.BLACK;
	boolean bojaSelektovana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DrawingPointDlg dialog = new DrawingPointDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DrawingPointDlg() {
		setModal(true);
		setResizable(false);
		setTitle("Parametri - Tacke");
		setBounds(100, 100, 282, 319);
		getContentPane().setLayout(new BorderLayout());
		pnlCentar.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCentar, BorderLayout.CENTER);

		JLabel lblXKoordinata = new JLabel("X koordinata:");
		JLabel lblYKoordinata = new JLabel("Y koordinata:");
		txtXCoord = new JTextField();
		txtXCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (getTxtXCoord().getText().trim().isEmpty()) {
					if (!((c >= '1') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
					}
				} else {
					if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			}
		});
		txtXCoord.setColumns(10);
		txtYCoord = new JTextField();
		txtYCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (getTxtYCoord().getText().trim().isEmpty()) {
					if (!((c >= '1') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
					}
				} else {
					if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			}
		});
		txtYCoord.setColumns(10);

		JButton btnBoja = new JButton("Promena boje tacke");
		btnBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boja = JColorChooser.showDialog(null, "Panel boja", boja);
				bojaSelektovana = true;

				btnBoja.setForeground(boja);
				;
			}
		});
		GroupLayout gl_pnlCentar = new GroupLayout(pnlCentar);
		gl_pnlCentar.setHorizontalGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlCentar
				.createSequentialGroup().addGap(
						24)
				.addGroup(
						gl_pnlCentar.createParallelGroup(Alignment.LEADING).addComponent(btnBoja)
								.addGroup(
										gl_pnlCentar.createSequentialGroup()
												.addGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING)
														.addComponent(lblXKoordinata).addComponent(lblYKoordinata))
												.addGap(28)
												.addGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING)
														.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(64, Short.MAX_VALUE)));
		gl_pnlCentar.setVerticalGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup().addGap(28)
						.addGroup(gl_pnlCentar.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblXKoordinata))
						.addGap(31)
						.addGroup(gl_pnlCentar.createParallelGroup(Alignment.TRAILING).addComponent(lblYKoordinata)
								.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(28).addComponent(btnBoja).addContainerGap(85, Short.MAX_VALUE)));
		pnlCentar.setLayout(gl_pnlCentar);
		{
			JPanel pnlDole = new JPanel();
			getContentPane().add(pnlDole, BorderLayout.SOUTH);
			{
				btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (txtXCoord.getText().isEmpty() || txtYCoord.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena", "Greska",
									JOptionPane.ERROR_MESSAGE);
							dispose();

						} else {
							xPoint = Integer.parseInt(txtXCoord.getText());
							yPoint = Integer.parseInt(txtYCoord.getText());
							for (Shape shape : PnlDrawing.shapesArray) {
								if (shape.isSelected()) {
									shape.moveBy(xPoint, yPoint);
									if (bojaSelektovana == true) {
										shape.setBojaIvice(boja);
										bojaSelektovana = false;
									}
								}
							}
							dispose();
							return;
						}

					}

				});
				btnPotvrdi.setActionCommand("OK");
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				btnPonisti = new JButton("Ponisti");
				btnPonisti.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						dispose();
					}
				});
				btnPonisti.setActionCommand("Cancel");
			}
			GroupLayout gl_pnlDole = new GroupLayout(pnlDole);
			gl_pnlDole.setHorizontalGroup(
					gl_pnlDole.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlDole.createSequentialGroup()
							.addGap(27).addComponent(btnPotvrdi).addGap(61).addComponent(btnPonisti).addGap(23)));
			gl_pnlDole
					.setVerticalGroup(
							gl_pnlDole.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
									gl_pnlDole.createSequentialGroup()
											.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGroup(gl_pnlDole.createParallelGroup(Alignment.BASELINE)
													.addComponent(btnPotvrdi).addComponent(btnPonisti))
											.addContainerGap()));
			pnlDole.setLayout(gl_pnlDole);
		}
	}

	public JTextField getTxtXCoord() {
		return txtXCoord;
	}

	public void setTxtXCoord(JTextField txtXCoord) {
		this.txtXCoord = txtXCoord;
	}

	public JTextField getTxtYCoord() {
		return txtYCoord;
	}

	public void setTxtYCoord(JTextField txtYCoord) {
		this.txtYCoord = txtYCoord;
	}

	public int getXPoint() {
		return xPoint;
	}

	public void setXPoint(int xPoint) {
		this.xPoint = xPoint;
	}

	public int getYPoint() {
		return yPoint;
	}

	public void setYp(int yPoint) {
		this.yPoint = yPoint;
	}

	public Color getBoja() {
		return boja;
	}

	public void setBoja(Color boja) {
		this.boja = boja;
	}
}
