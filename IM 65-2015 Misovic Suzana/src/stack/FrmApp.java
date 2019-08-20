package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class FrmApp extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	Stack<Rectangle> stack = new Stack<Rectangle>();

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
		setTitle("Stack - IM 65-2015 Misovic Suzana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 347);
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
						Rectangle r = new Rectangle(p, Integer.parseInt(d.getTxtVisina().getText()),
								Integer.parseInt(d.getTxtSirina().getText()));
						stack.push(r);
						dlm.add(0, r);
						System.out.println("Stack: "+stack);
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Please enter an integer!", "Error",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

		JButton btnDelete = new JButton("Delete");
		pnlButtons.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DlgAdd d = new DlgAdd();
				try {
					d.getBtnOk().setVisible(true);
					d.getBtnAdd().setVisible(false);
					d.getBtnCancel().setVisible(false);

					d.getTxtX().setText(Integer.toString(dlm.get(0).getUpperLeftPoint().getX()));
					d.getTxtY().setText(Integer.toString(dlm.get(0).getUpperLeftPoint().getY()));
					d.getTxtVisina().setText(Integer.toString(dlm.get(0).getHeight()));
					d.getTxtSirina().setText(Integer.toString(dlm.get(0).getWidth()));

					d.setVisible(true);

					dlm.remove(0);
					stack.pop();
					System.out.println("Stack: "+stack);
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Stack is empty!", "Error", JOptionPane.WARNING_MESSAGE);
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
