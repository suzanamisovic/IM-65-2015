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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DrawingRectangleDlg extends JDialog {

	private final JPanel pnlCentar = new JPanel();
	private JButton btnPotvrdi;
	private JButton btnPonisti;
	private JTextField txtSirina;
	private JTextField txtVisina;
	boolean isOk;
	private JTextField txtYCoord;
	private JTextField txtXCoord;
	private JLabel lblYKoordinata;
	private JLabel lblXKoordinata;
	private int xRect;
	private int yRect;
	private int sirina;
	private int visina;
	private Color bojaIvice;
	private Color bojaPovrsine;
	private JButton btnPromenaBoje;
	private JButton btnPromenaFill;
	private boolean bojaIviceSelektovana;
	private boolean bojaPovrsineSelektovana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DrawingRectangleDlg dialog = new DrawingRectangleDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DrawingRectangleDlg() {
		setModal(true);
		setResizable(false);
		setTitle("Parametri - Pravougaonika");
		setBounds(100, 100, 244, 364);
		getContentPane().setLayout(new BorderLayout());
		pnlCentar.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCentar, BorderLayout.CENTER);

		JLabel lblSirina = new JLabel("Sirina:");

		JLabel lblVisina = new JLabel("Visina:");

		txtSirina = new JTextField();
		txtSirina.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (getTxtSirina().getText().trim().isEmpty()) {
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
		txtSirina.setColumns(10);

		txtVisina = new JTextField();
		txtVisina.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (getTxtVisina().getText().trim().isEmpty()) {
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
		txtVisina.setColumns(10);

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

		lblYKoordinata = new JLabel("Y koordinata:");

		lblXKoordinata = new JLabel("X koordinata:");

		btnPromenaBoje = new JButton("Promena boje ivice");
		btnPromenaBoje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaIvice = JColorChooser.showDialog(null, "Panel boja", bojaIvice);
				setBojaIviceSelektovana(true);
				btnPromenaBoje.setForeground(bojaIvice);

			}
		});

		btnPromenaFill = new JButton("Promena boje povrsine");
		btnPromenaFill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bojaPovrsine = JColorChooser.showDialog(null, "Paleta boja", bojaPovrsine);
				setBojaPovrsineSelektovana(true);
				btnPromenaFill.setForeground(bojaPovrsine);

			}
		});
		GroupLayout gl_pnlCentar = new GroupLayout(pnlCentar);
		gl_pnlCentar.setHorizontalGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlCentar
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCentar.createSequentialGroup()
								.addGroup(gl_pnlCentar.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblXKoordinata, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblVisina, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblSirina, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblYKoordinata, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
								.addGroup(
										gl_pnlCentar.createParallelGroup(Alignment.LEADING)
												.addComponent(txtYCoord, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtSirina, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtVisina, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtXCoord, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(31))
						.addGroup(gl_pnlCentar.createSequentialGroup()
								.addGroup(gl_pnlCentar.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnPromenaBoje, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnPromenaFill, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap(129, Short.MAX_VALUE)))));
		gl_pnlCentar.setVerticalGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlCentar
				.createSequentialGroup().addGap(34)
				.addGroup(gl_pnlCentar.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlCentar.createSequentialGroup()
								.addGroup(gl_pnlCentar.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblXKoordinata))
								.addGap(18).addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblYKoordinata))
				.addGap(18)
				.addGroup(gl_pnlCentar.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSirina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSirina))
				.addGap(18)
				.addGroup(gl_pnlCentar.createParallelGroup(Alignment.BASELINE).addComponent(lblVisina).addComponent(
						txtVisina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(btnPromenaBoje).addGap(18).addComponent(btnPromenaFill)
				.addContainerGap(30, Short.MAX_VALUE)));
		pnlCentar.setLayout(gl_pnlCentar);
		{
			JPanel btnDole = new JPanel();
			getContentPane().add(btnDole, BorderLayout.SOUTH);
			{
				btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtXCoord.getText().trim().isEmpty() || txtYCoord.getText().trim().isEmpty()
								|| txtSirina.getText().trim().isEmpty() || txtVisina.getText().trim().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena", "Greska",
									JOptionPane.ERROR_MESSAGE);
							dispose();
						} else {
							xRect = Integer.parseInt(txtXCoord.getText());
							yRect = Integer.parseInt(txtYCoord.getText());
							sirina = Integer.parseInt(txtSirina.getText());
							visina = Integer.parseInt(txtVisina.getText());
							for (Shape shape : PnlDrawing.shapesArray) {
								if (shape.isSelected()) {
									shape.moveBy(xRect, yRect);
									if (isBojaIviceSelektovana() == true) {
										shape.setBojaIvice(bojaIvice);
										setBojaIviceSelektovana(false);
									}
									if (isBojaPovrsineSelektovana() == true) {
										shape.setBojaPovrsine(bojaPovrsine);
										setBojaPovrsineSelektovana(false);
									}
									if (shape instanceof Rectangle) {
										((Rectangle) shape).setWidth(sirina);
										((Rectangle) shape).setHeight(visina);
									}
								}
							}
							isOk = true;
							dispose();
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
			GroupLayout gl_btnDole = new GroupLayout(btnDole);
			gl_btnDole.setHorizontalGroup(
					gl_btnDole.createParallelGroup(Alignment.LEADING).addGroup(gl_btnDole.createSequentialGroup()
							.addGap(20).addComponent(btnPotvrdi).addGap(43).addComponent(btnPonisti).addGap(35)));
			gl_btnDole
					.setVerticalGroup(
							gl_btnDole.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
									gl_btnDole.createSequentialGroup()
											.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGroup(gl_btnDole.createParallelGroup(Alignment.BASELINE)
													.addComponent(btnPotvrdi).addComponent(btnPonisti))
											.addContainerGap()));
			btnDole.setLayout(gl_btnDole);
		}
	}

	public JTextField getTxtSirina() {
		return txtSirina;
	}

	public void setTxtSirina(JTextField txtSirina) {
		this.txtSirina = txtSirina;
	}

	public JTextField getTxtVisina() {
		return txtVisina;
	}

	public void setTxtVisina(JTextField txtVisina) {
		this.txtVisina = txtVisina;
	}

	public JTextField getTxtYCoord() {
		return txtYCoord;
	}

	public void setTxtYCoord(JTextField txtYCoord) {
		this.txtYCoord = txtYCoord;
	}

	public JTextField getTxtXCoord() {
		return txtXCoord;
	}

	public void setTxtXCoord(JTextField txtXCoord) {
		this.txtXCoord = txtXCoord;
	}

	public int getXRect() {
		return xRect;
	}

	public void setXRect(int xRect) {
		this.xRect = xRect;
	}

	public int getYRect() {
		return yRect;
	}

	public void setYRect(int yRect) {
		this.yRect = yRect;
	}

	public int getSirina() {
		return sirina;
	}

	public void setSirina(int sirina) {
		this.sirina = sirina;
	}

	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		this.visina = visina;
	}

	public Color getBoja() {
		return bojaIvice;
	}

	public void setBoja(Color boja) {
		this.bojaIvice = boja;
	}

	public JButton getBtnPromenaBoje() {
		return btnPromenaBoje;
	}

	public void setBtnPromenaBoje(JButton btnPromenaBoje) {
		this.btnPromenaBoje = btnPromenaBoje;
	}

	public Color getBojaPovrsine() {
		return bojaPovrsine;
	}

	public void setBojaPovrsine(Color bojaPovrsine) {
		this.bojaPovrsine = bojaPovrsine;
	}

	public JButton getBtnPromenaFill() {
		return btnPromenaFill;
	}

	public void setBtnPromenaFill(JButton btnPromenaFill) {
		this.btnPromenaFill = btnPromenaFill;
	}

	public boolean isBojaIviceSelektovana() {
		return bojaIviceSelektovana;
	}

	public void setBojaIviceSelektovana(boolean bojaIviceSelektovana) {
		this.bojaIviceSelektovana = bojaIviceSelektovana;
	}

	public boolean isBojaPovrsineSelektovana() {
		return bojaPovrsineSelektovana;
	}

	public void setBojaPovrsineSelektovana(boolean bojaPovrsineSelektovana) {
		this.bojaPovrsineSelektovana = bojaPovrsineSelektovana;
	}

}
