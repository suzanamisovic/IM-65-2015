package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class FrmApp extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();

	ArrayList<Rectangle> recList = new ArrayList<Rectangle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmApp frame = new FrmApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmApp() {
		setTitle("Sort - IM 65-2015 Misovic Suzana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlButtons = new JPanel();
		contentPane.add(pnlButtons, BorderLayout.NORTH);

		JButton btnAdd = new JButton("Add");
		pnlButtons.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgAdd d = new DlgAdd();
				d.setVisible(true);
				if (d.isOK()) {
					try {
						Point p = new Point(Integer.parseInt(d.getTxtX().getText()),
								Integer.parseInt(d.getTxtY().getText()));
						Rectangle r = new Rectangle(p, Integer.parseInt(d.getTxtHeight().getText()),
								Integer.parseInt(d.getTxtWidth().getText()));
						dlm.addElement(r);
						recList.add(r);
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Please enter an integer!", "Error",
								JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});

		JButton btnSort = new JButton("Sort");
		pnlButtons.add(btnSort);
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (recList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "List is empty!", "Error", JOptionPane.WARNING_MESSAGE);
				}
				recList.sort(null);
				dlm.clear();
				// for (int i = recList.size()-1; i >= 0; i--) opadajuce
				for (int i = 0; i < recList.size(); i++) // rastuce
				{
					dlm.addElement(recList.get(i));
				}

			}
		});

		JPanel pnlMain = new JPanel();
		contentPane.add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pnlMain.add(scrollPane);

		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(dlm);
	}
}
