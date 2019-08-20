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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DrawingLineDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnPotvrdi;
	private JLabel lblXStart;
	private JButton btnPonisti;
	private JLabel lblYStart;
	private JLabel lblXEnd;
	private JLabel lblYEnd;
	private JTextField txtXStart;
	private JTextField txtYStart;
	private JTextField txtXEnd;
	private JTextField txtYEnd;
	private int startPointX;
	private int startPointY;
	private int endPointX;
	private int endPointY;
	private JButton btnPromenaBoja;
	private Color boja = Color.BLACK;
	boolean bojaSelektovana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DrawingLineDlg dialog = new DrawingLineDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DrawingLineDlg() {
		setModal(true);
		setResizable(false);
		setTitle("Parametri - Linije");
		setBounds(100, 100, 400, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		lblXStart = new JLabel("X koordinata pocetne tacke:");
		lblYStart = new JLabel("Y koordinata pocetne tacke:");
		lblXEnd = new JLabel("X koordinata krajnje tacke:");
		lblYEnd = new JLabel("Y koordinata krajnje tacke:");
		txtXStart = new JTextField();
		txtXStart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (getTxtXStart().getText().trim().isEmpty()) {
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
		txtXStart.setColumns(10);
		txtYStart = new JTextField();
		txtYStart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (getTxtYStart().getText().trim().isEmpty()) {
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
		txtYStart.setColumns(10);
		txtXEnd = new JTextField();
		txtXEnd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (getTxtXEnd().getText().trim().isEmpty()) {
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
		txtXEnd.setColumns(10);
		txtYEnd = new JTextField();
		txtYEnd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (getTxtYEnd().getText().trim().isEmpty()) {
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
		txtYEnd.setColumns(10);

		btnPromenaBoja = new JButton("Promena boje linije");
		btnPromenaBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boja = JColorChooser.showDialog(null, "Panel boja", boja);
				bojaSelektovana = true;
				btnPromenaBoja.setForeground(boja);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel
								.createParallelGroup(Alignment.LEADING).addComponent(btnPromenaBoja)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtXEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblXStart)
												.addGap(49).addComponent(txtXStart, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtYStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtYEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(104, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblYStart).addContainerGap(239,
								Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblXEnd).addContainerGap(245,
								Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblYEnd).addContainerGap(245,
								Short.MAX_VALUE)))));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addGap(26)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblXStart).addComponent(
						txtXStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblYStart).addComponent(
						txtYStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblXEnd).addComponent(
						txtXEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblYEnd).addComponent(
						txtYEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(19).addComponent(btnPromenaBoja).addContainerGap(37, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			btnPonisti = new JButton("Ponisti");
			btnPonisti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			{
				btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtXStart.getText().isEmpty() || txtYStart.getText().isEmpty()
								|| txtXEnd.getText().isEmpty() || txtYEnd.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena", "Greska",
									JOptionPane.ERROR_MESSAGE);
							dispose();
						} else {
							startPointX = Integer.parseInt(txtXStart.getText());
							startPointY = Integer.parseInt(txtYStart.getText());
							endPointY = Integer.parseInt(txtXEnd.getText());
							endPointY = Integer.parseInt(txtYEnd.getText());
							for (Shape shape : PnlDrawing.shapesArray) {
								if (shape.isSelected()) {
									if (shape instanceof Line) {
										((Line) shape).setStart(new Point(startPointX, startPointY));
										((Line) shape).setEnd(new Point(endPointX, endPointY));
										if (bojaSelektovana == true) {
											shape.setBojaIvice(boja);
											bojaSelektovana = false;
										}
									}

								}
							}
							dispose();
						}

					}
				});
				btnPotvrdi.setActionCommand("OK");
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING).addGroup(gl_buttonPane
					.createSequentialGroup().addGap(26)
					.addComponent(btnPotvrdi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(84).addComponent(btnPonisti, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE).addGap(75)));
			gl_buttonPane.setVerticalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
							.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE).addComponent(btnPotvrdi)
									.addComponent(btnPonisti))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
			buttonPane.setLayout(gl_buttonPane);
		}
	}

	public JTextField getTxtXStart() {
		return txtXStart;
	}

	public void setTxtXStart(JTextField txtXStart) {
		this.txtXStart = txtXStart;
	}

	public JTextField getTxtYStart() {
		return txtYStart;
	}

	public void setTxtYStart(JTextField txtYStart) {
		this.txtYStart = txtYStart;
	}

	public JTextField getTxtXEnd() {
		return txtXEnd;
	}

	public void setTxtXEnd(JTextField txtXEnd) {
		this.txtXEnd = txtXEnd;
	}

	public JTextField getTxtYEnd() {
		return txtYEnd;
	}

	public void setTxtYEnd(JTextField txtYEnd) {
		this.txtYEnd = txtYEnd;
	}

	public int getStartPointX() {
		return startPointX;
	}

	public void setStartPointX(int startPointX) {
		this.startPointX = startPointX;
	}

	public int getStartPointY() {
		return startPointY;
	}

	public void setStartPointY(int startPointY) {
		this.startPointY = startPointY;
	}

	public int getEndPointX() {
		return endPointX;
	}

	public void setEndPointX(int endPointX) {
		this.endPointX = endPointX;
	}

	public int getEndPointY() {
		return endPointY;
	}

	public void setEndPointY(int endPointY) {
		this.endPointY = endPointY;
	}

	public Color getBoja() {
		return boja;
	}

	public void setBoja(Color boja) {
		this.boja = boja;
	}

}
