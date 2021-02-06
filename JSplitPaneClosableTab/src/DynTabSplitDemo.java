import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author User
 */
public class DynTabSplitDemo extends JFrame implements ActionListener {

	JMenuBar bar;
	JMenu mnu1, mnu2;
	JMenuItem item1, item2, item3, item4;
	JSplitPane jSplitPane, jSplitPane2;
	JPanel jPanel1, jPanel2a, jPanel2b;
	public static JLabel lblTest;
	public static JTabbedPane tabbedPane;
	private int tab_one_Count, tab_two_Count;
	// int w, h;

	public DynTabSplitDemo() {
//        w = Toolkit.getDefaultToolkit().getScreenSize().width;
//        h = Toolkit.getDefaultToolkit().getScreenSize().height;

		// creating objects
		bar = new JMenuBar();
		mnu1 = new JMenu("File");
		mnu2 = new JMenu("Entry");
		item1 = new JMenuItem("Exit");
		item2 = new JMenuItem("Sample1");
		item3 = new JMenuItem("Sample2");
		item4 = new JMenuItem("Sample3");
		lblTest = new JLabel();
		tabbedPane = new JTabbedPane();

		mnu1.add(item1);
		mnu2.add(item2);
		mnu2.add(item3);
		mnu2.add(item4);
		bar.add(mnu1);
		bar.add(mnu2);
		setJMenuBar(bar);
		setTitle("JSplitPane with ClosableTab Demo");
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		//
		jPanel1 = new JPanel();
		jPanel2a = new JPanel();
		jPanel2b = new JPanel();
		lblTest.setText("Hello");
		jPanel1.setBackground(Color.decode("#90EE90"));
		jPanel1.add(lblTest);
		jPanel1.setLayout(new GridLayout());
		jPanel2a.setLayout(new GridLayout());
		jPanel2b.setLayout(new GridLayout());
		jPanel2b.add(tabbedPane, BorderLayout.EAST);

		WelcomePanel wPanel = new WelcomePanel();
		tabbedPane.add("Welcome", wPanel);

		TreeMenuDemo tree = new TreeMenuDemo();
		jPanel2a.add(tree);

		jSplitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jPanel2a, jPanel2b);
		jSplitPane2.setOneTouchExpandable(true);

		// jSplitPane2.setDividerLocation(200);
		jSplitPane2.setResizeWeight(0.15);

		jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jSplitPane2, jPanel1);
		jSplitPane.setOneTouchExpandable(true);
		jSplitPane.setResizeWeight(0.95);
		// jSplitPane.setDividerLocation(h-250);

		getContentPane().add(jSplitPane, BorderLayout.CENTER);
		setSize(800, 600);
		setLocationRelativeTo(null);
		// setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DynTabSplitDemo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == item1) {
			System.exit(0);
		}
		if (e.getSource() == item2) {
			tab_one_Count++;
			lblTest.setText("Open tab One");
			JScrollPane scrollPane = new JScrollPane(new ExamplePanel1("Button Event"));
			Icon icon = ClosableTabDemo.PAGE_ICON;
			// adding tab with closable icon
			ClosableTabDemo.addClosableTab(tabbedPane, scrollPane, "Sample1", icon);
		}
		if (e.getSource() == item3) {
			tab_two_Count++;
			lblTest.setText("Open tab Two");
			JScrollPane scrollPane = new JScrollPane(new ExamplePanel2());
			Icon icon = ClosableTabDemo.PAGE_ICON;
			ClosableTabDemo.addClosableTab(tabbedPane, scrollPane, "Sample2", icon);
		}
		if (e.getSource() == item4) {
			lblTest.setText("Open tab Three");
			JScrollPane scrollPane = new JScrollPane(new ExamplePanel3());
			Icon icon = ClosableTabDemo.PAGE_ICON;
			ClosableTabDemo.addClosableTab(tabbedPane, scrollPane, "Sample3", icon);
		}
	}
}
