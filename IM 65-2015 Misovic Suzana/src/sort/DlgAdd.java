package sort;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class DlgAdd extends JDialog {

	private final JPanel pnlMain = new JPanel();
	private boolean isOK;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtHeight;
	private JTextField txtWidth;
	private JButton btnAdd;
	private JButton btnCancel;

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public JPanel getPnlGlavni() {
		return pnlMain;
	}

	public JPanel getContentPanel() {
		return pnlMain;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}

	public boolean isOK() {
		return isOK;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAdd dialog = new DlgAdd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAdd() {
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setTitle("Add - Sort");
		setModal(true);
		setBounds(100, 100, 264, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(new MigLayout("", "[66px][115px,grow]", "[50px][50][50][50]"));

		JLabel lblX = new JLabel("X:");
		pnlMain.add(lblX, "cell 0 0,alignx left,aligny center");

		txtX = new JTextField();
		txtX.setTransferHandler(null); // onemogucava paste
		txtX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtX.setColumns(10);
		pnlMain.add(txtX, "cell 1 0,growx,aligny center");

		JLabel lblY = new JLabel("Y:");
		pnlMain.add(lblY, "cell 0 1,alignx left,aligny center");

		txtY = new JTextField();
		txtY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtY.setColumns(10);
		pnlMain.add(txtY, "cell 1 1,growx,aligny center");

		JLabel lblHeight = new JLabel("Height:");
		pnlMain.add(lblHeight, "cell 0 2,alignx left,aligny center");

		txtHeight = new JTextField();
		txtHeight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtHeight.setColumns(10);
		pnlMain.add(txtHeight, "cell 1 2,growx,aligny center");

		JLabel lblWidth = new JLabel("Width:");
		pnlMain.add(lblWidth, "cell 0 3,alignx left,aligny center");

		txtWidth = new JTextField();
		txtWidth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtWidth.setColumns(10);
		pnlMain.add(txtWidth, "cell 1 3,growx,aligny center");

		{
			JPanel pnlButtons = new JPanel();
			pnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlButtons, BorderLayout.SOUTH);
			{
				btnAdd = new JButton("Add");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (getTxtX().getText().isEmpty() || getTxtY().getText().isEmpty()
								|| getTxtWidth().getText().isEmpty() || getTxtHeight().getText().isEmpty()) {
							isOK = false;
							setVisible(true);
							JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska",
									JOptionPane.WARNING_MESSAGE);
						} else {
							isOK = true;
							dispose();
						}
					}
				});
				btnAdd.setActionCommand("OK");
				pnlButtons.add(btnAdd);
				getRootPane().setDefaultButton(btnAdd);
			}
			{
				btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						isOK = false;
						txtX.setText("");
						txtY.setText("");
						txtWidth.setText("");
						txtHeight.setText("");
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				pnlButtons.add(btnCancel);
			}
		}
	}
}
