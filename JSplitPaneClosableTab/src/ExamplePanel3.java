import java.awt.Color;
import javax.swing.JEditorPane;

public class ExamplePanel3 extends JEditorPane {

	public ExamplePanel3() {
		// rPanel.setBounds(10, 10, 200, 200);
		setBackground(Color.decode("#FFDAB9"));
		setBorder(new javax.swing.border.LineBorder(new java.awt.Color(100, 50, 150), 5, true));
		setContentType("text/html");
		// create some simple html as a string
		String htmlString = "<html>\n" + "<body>\n" + "<h1 style='color: blue'>Welcome!</h1>\n"
				+ "<h2 style='color: #ff0000'>This is the Sample3 window</h2>\n"
				+ "<h2 style='color: #006400'>You can close tab by click x</h2>\n"
				+ "<p>Write some welcome text here</p>\n"
				+ "<p style='color : black; background-color : #fafafa;'>Enjoy!</p>\n" + "</body>\n";
		setText(htmlString);
	}

	public ExamplePanel3(String string) {
		// TODO Auto-generated constructor stub
	}
}