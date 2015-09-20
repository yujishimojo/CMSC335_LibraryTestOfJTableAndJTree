import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.DefaultMutableTreeNode;

public class LibraryTestOfJTableAndJTree implements ActionListener, TreeSelectionListener {

	// declare Swing components as instance variables
	static Library library;
	static JFrame outputFrame;
	static JPanel panel1, panel2, panel3, panel4;
	static Container container;
	static JLabel label1, label2, label3, label4, label5, label6;
	static JTextField textField1, textField2, textField3;
	static JButton button1, button2, button3;
	static JScrollPane pane1, pane2;
	static JTable table;
	static DefaultTableModel tableModel;
	static TableRowSorter<TableModel> sorter;
	static JTree tree;
	static DefaultMutableTreeNode root,
	node1, node1_1, node1_2, node1_3, node1_4, node1_5,
	node2, node2_1, node2_2, node2_3, node2_4, node2_5, node2_6;

	public static void main(String args[]){
		// instantiate a Library object
		library  = new Library();

		// create instances of authors
		library.authors.add(new Author("Dan Brown", "123 Street", "Concord", "New Hampshire", 3301, "603-123-456"));
		library.authors.add(new Author("Stephen R. Covey", "456 Street", "Salt Lake City", "Utah", 84101, "385-456-7890"));
		library.authors.add(new Author("Tina Seelig", "450 Serra Mall", "Stanford", "California", 94305, "650-725-1627"));
		library.authors.add(new Author("Y. Daniel Liang", "11935 Abercorn Street", "Savannah", "Georgia", 314191997, "912-344-3264"));
		library.authors.add(new Author("Brian Goetz", "777 Street", "Williston", "Vermont", 5495, "912-344-3264"));
		library.authors.add(new Author("Ray Murphy", "University Road", "Galway", "County Galway, Ireland", 904018, "802-388-8405"));
		library.authors.add(new Author("Walter Isaacson", "789 Street", "New Orleans", "Louisiana", 70112, "504-789-0123"));

		// create instances of books
		library.books.add(new Book("The Lost Symbol", "Mystery & Thrillers", 10, 0));
		library.books.add(new Book("Angels & Demons", "Mystery & Thrillers", 16, 0));
		library.books.add(new Book("The Da Vinci Code", "Mystery & Thrillers", 10, 0));
		library.books.add(new Book("Deception Point", "Mystery & Thrillers", 16, 0));
		library.books.add(new Book("Digital Fortress", "Mystery & Thrillers", 9, 0));
		library.books.add(new Book("The 7 Habits of Highly Effective People", "Business & Investing", 16, 1));
		library.books.add(new Book("The 8th Habit: From Effectiveness to Greatness", "Business & Investing", 16, 1));
		library.books.add(new Book("The 3rd Alternative: Solving Life's Most Difficult Problems", "Business & Investing", 16, 1));
		library.books.add(new Book("What I Wish I Knew When I Was 20", "Business & Investing", 23, 2));
		library.books.add(new Book("inGenius: A Crash Course on Creativity", "Business & Investing", 26, 2));
		library.books.add(new Book("Introduction to Java Programming, Comprehensive", "Computers & Technology", 129, 3));
		library.books.add(new Book("Java Concurrency in Practice", "Computers & Technology", 60, 4));
		library.books.add(new Book("English Grammar In Use", "Education & Reference", 36, 5));
		library.books.add(new Book("Steve Jobs", "Biographies & Memoirs", 30, 6));
		library.books.add(new Book("Einstein: His Life and Universe", "Biographies & Memoirs", 19, 6));
		library.books.add(new Book("Benjamin Franklin: An American Life", "Biographies & Memoirs", 19, 6));
		library.books.add(new Book("Kissinger: A Biography", "Biographies & Memoirs", 22, 6));

		// instantiate a LibraryTest object that invokes libraryGUI() method
		LibraryTestOfJTableAndJTree viewer = new LibraryTestOfJTableAndJTree();
		viewer.libraryGUI();
	}

	public void libraryGUI() {
		outputFrame = new JFrame(); // instantiate a JFrame object
		outputFrame.setSize(850,500);
		outputFrame.setTitle("LibraryTestOfJTableAndJTree");
		outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		container = outputFrame.getContentPane();
		container.setLayout(new FlowLayout());

		panel1 = new JPanel(); // instantiate a JPanel object
		panel1.setLayout(new BorderLayout()); // set the panel1's layout

		// instantiate a JLabel object, add it to container and panel
		label1 = new JLabel("Title :");
		container.add(label1);
		panel1.add(label1, BorderLayout.WEST);

		textField1 = new JTextField("", 15);
		container.add(textField1);
		panel1.add(textField1, BorderLayout.CENTER);
		//handler is the actionPerformed() below.
		textField1.addActionListener( this );

		button1 = new JButton("Search on Title");
		container.add(button1);
		panel1.add(button1, BorderLayout.EAST);
		button1.addActionListener( this );

		label2 = new JLabel(""); // for exception error messages
		label2.setForeground(Color.red);
		container.add(label2);
		panel1.add(label2, BorderLayout.SOUTH);

		outputFrame.add(panel1);

		panel2 = new JPanel();
		panel2.setLayout(new BorderLayout()); // set the panel2's layout

		label3 = new JLabel("Genre :");
		container.add(label3);
		panel2.add(label3, BorderLayout.WEST);

		textField2 = new JTextField("", 15);
		container.add(textField2);
		panel2.add(textField2, BorderLayout.CENTER);
		textField2.addActionListener(this);

		button2 = new JButton("Search on Genre");
		container.add(button2);
		panel2.add(button2, BorderLayout.EAST);
		button2.addActionListener(this);

		label4 = new JLabel(""); // for exception error messages
		label4.setForeground(Color.red);
		container.add(label4);
		panel2.add(label4, BorderLayout.SOUTH);

		outputFrame.add(panel2);

		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT)); // set the panel3's layout

		label5 = new JLabel("Author Index :");
		container.add(label5);
		panel3.add(label5);

		textField3 = new JTextField("", 3);
		container.add( textField3 );
		panel3.add(textField3);
		textField3.addActionListener(this);

		button3 = new JButton( "Search on author index" );
		container.add( button3 );
		panel3.add(button3);
		button3.addActionListener(this);

		label6 = new JLabel(""); // for exception error messages
		label6.setForeground(Color.red);
		container.add(label6);
		panel3.add(label6);

		outputFrame.add(panel3);

		panel4 = new JPanel();
		panel4.setLayout(new BorderLayout());

		// create a JTree object
		root = new DefaultMutableTreeNode("Root");
		node1 = new DefaultMutableTreeNode("Genre");
		node1_1 = new DefaultMutableTreeNode("Mystery & Thrillers");
		node1_2 = new DefaultMutableTreeNode("Business & Investing");
		node1_3 = new DefaultMutableTreeNode("Computers & Technology");
		node1_4 = new DefaultMutableTreeNode("Education & Reference");
		node1_5 = new DefaultMutableTreeNode("Biographies & Memoirs");
		node2 = new DefaultMutableTreeNode("Author Index");
		node2_1 = new DefaultMutableTreeNode(0);
		node2_2 = new DefaultMutableTreeNode(1);
		node2_3 = new DefaultMutableTreeNode(2);
		node2_4 = new DefaultMutableTreeNode(3);
		node2_5 = new DefaultMutableTreeNode(4);
		node2_6 = new DefaultMutableTreeNode(5);

		root.add(node1);
		node1.add(node1_1);
		node1.add(node1_2);
		node1.add(node1_3);
		node1.add(node1_4);
		node1.add(node1_5);

		root.add(node2);
		node2.add(node2_1);
		node2.add(node2_2);
		node2.add(node2_3);
		node2.add(node2_4);
		node2.add(node2_5);
		node2.add(node2_6);

		tree = new JTree(root);
		pane1 = new JScrollPane();
		pane1.getViewport().setView(tree);
		pane1.setPreferredSize(new Dimension(500, 350));
		panel4.add(tree, BorderLayout.WEST);
		tree.setRootVisible(false);
		// handler is the valueChanged() below.
		tree.addTreeSelectionListener(this);

		// create a JTable object
		String[] columnNames = {"Title", "Genre", "Price", "Author of Index"};
		Object[][] data = null;
		tableModel = new DefaultTableModel(data, columnNames);
		table = new JTable(tableModel);
		sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		panel4.add(table, BorderLayout.EAST);
		pane2 = new JScrollPane(table);
		pane2.setPreferredSize(new Dimension(550, 350));
		panel4.add(pane2);

		outputFrame.add(panel4);
		outputFrame.setVisible(true);
	}

	// event handler for JButton, JTextField events.
	public void actionPerformed( ActionEvent event ) {
		// reset error messages
		label2.setText("");
		label4.setText("");
		label6.setText("");

		// reset table
		tableModel.setRowCount(0);

		// access the text
		String queryTitle = textField1.getText();
		String queryGenre = textField2.getText();
		String queryAuthorIndex = textField3.getText();

		if ( event.getSource() == button1 ) {
			if (!queryTitle.equals("")) {
				Book resultTitle = this.library.searchTitle(queryTitle);
				if (resultTitle == null) {
					label2.setText("\"" + queryTitle + "\" is not found in the library.\n");
				}
				else {
					tableModel.addRow(resultTitle.convertArray());
				}
			}
			else {
				for(int i=0; i<library.books.size(); i++){
					tableModel.addRow(library.books.get(i).convertArray());
				}
			}
		}
		else if ( event.getSource() == button2 ) {
			if (!queryGenre.equals("")) {
				ArrayList<Book> resultGenre = this.library.searchGenre(queryGenre);
				if (resultGenre == null) {
					label4.setText("\"" + queryGenre + "\" is not found in the library.\n");
				}
				else {
					for(int i=0; i<resultGenre.size(); i++){
						tableModel.addRow(resultGenre.get(i).convertArray());
					}
				}
			}
			else {
				for(int i=0; i<library.books.size(); i++){
					tableModel.addRow(library.books.get(i).convertArray());
				}
			}
		}
		else if ( event.getSource() == button3 ) {
			if (!queryAuthorIndex.equals("")) {
				int queryAuthorIndexInt = Integer.valueOf(queryAuthorIndex);
				ArrayList<Book> resultAuthorIndex = this.library.searchAuthorIndex(queryAuthorIndexInt);
				if (resultAuthorIndex == null) {
					label6.setText("\"" + queryAuthorIndex + "\" is not found in the library.\n");
				}
				else {
					for(int i=0; i<resultAuthorIndex.size(); i++){
						tableModel.addRow(resultAuthorIndex.get(i).convertArray());
					}
				}
			}
			else {
				for(int i=0; i<library.books.size(); i++){
					tableModel.addRow(library.books.get(i).convertArray());
				}
			}
		}
	}

	// event handler for JTree events.
	public void valueChanged(TreeSelectionEvent e) {
		// get the last selected element
		DefaultMutableTreeNode current = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		DefaultMutableTreeNode parent = (DefaultMutableTreeNode) current.getParent();
		String currentParent = (String) parent.getUserObject();
		int count = current.getChildCount();

		if (count == 0) { // if child nodes
			if (currentParent == "Genre") {
				String currentData = (String) current.getUserObject();
				tableModel.setRowCount(0); //reset tree
				ArrayList<Book> resultGenre = this.library.searchGenre(currentData);
				for(int i=0; i<resultGenre.size(); i++){
					tableModel.addRow(resultGenre.get(i).convertArray());
				}
			} else if (currentParent == "Author Index") {
				int currentData = (Integer) current.getUserObject();
				tableModel.setRowCount(0);
				ArrayList<Book> resultAuthorIndex = this.library.searchAuthorIndex(currentData);
				for(int i=0; i<resultAuthorIndex.size(); i++){
					tableModel.addRow(resultAuthorIndex.get(i).convertArray());
				}
			}
		}
	}
}