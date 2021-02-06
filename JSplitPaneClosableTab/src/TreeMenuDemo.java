import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class TreeMenuDemo extends JPanel
        implements TreeSelectionListener {

    private JTree tree;

    public TreeMenuDemo() {
        setLayout(new GridLayout());      
       
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Tree Menu");
        DefaultMutableTreeNode child1, child2;
        DefaultMutableTreeNode grandChild1, grandChild2, grandChild3, grandChild4;
        child1 = new DefaultMutableTreeNode("File");
        child2 = new DefaultMutableTreeNode("Entry");
        root.add(child1);
        root.add(child2);

        grandChild1 = new DefaultMutableTreeNode("Exit");
        child1.add(grandChild1);

        grandChild2 = new DefaultMutableTreeNode("Sample1");
        grandChild3 = new DefaultMutableTreeNode("Sample2");
        grandChild4 = new DefaultMutableTreeNode("Sample3");

        child2.add(grandChild2);
        child2.add(grandChild3);
        child2.add(grandChild4);
        tree = new JTree(root);
        tree.addTreeSelectionListener(this);
        add(new JScrollPane(tree), BorderLayout.CENTER);
        //setBackground(Color.decode("#90EE90"));
        setSize(250, 275);
        setVisible(true);
    }

    @Override
    public void valueChanged(TreeSelectionEvent event) {
        if (tree.getLastSelectedPathComponent().toString().equals("Exit")) {
            System.exit(0);
        }
        if (tree.getLastSelectedPathComponent().toString().equals("Sample1")) {
            DynTabSplitDemo.lblTest.setText("Open tab One");
            JScrollPane scrollPane = new JScrollPane(new ExamplePanel1("Colors"));
            Icon icon = ClosableTabDemo.PAGE_ICON;
            ClosableTabDemo.addClosableTab(DynTabSplitDemo.tabbedPane, scrollPane, "Sample1", icon);
        }
        if (tree.getLastSelectedPathComponent().toString().equals("Sample2")) {
             DynTabSplitDemo.lblTest.setText("Open tab Two");
            JScrollPane scrollPane = new JScrollPane(new ExamplePanel2());
            Icon icon = ClosableTabDemo.PAGE_ICON;
            ClosableTabDemo.addClosableTab(DynTabSplitDemo.tabbedPane, scrollPane, "Sample2", icon);
        }
        if (tree.getLastSelectedPathComponent().toString().equals("Sample3")) {
             DynTabSplitDemo.lblTest.setText("Open tab Three");
            JScrollPane scrollPane = new JScrollPane(new ExamplePanel3());
            Icon icon = ClosableTabDemo.PAGE_ICON;
            ClosableTabDemo.addClosableTab(DynTabSplitDemo.tabbedPane, scrollPane, "Sample3", icon);
        }
    }
}