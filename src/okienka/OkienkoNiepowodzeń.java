package okienka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OkienkoNiepowodzeñ extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 973209532967398093L;
	private static JTextArea tekst;
	private JButton czysc;

	public OkienkoNiepowodzeñ() {

		setTitle("Nie wykonane zadania");
		setVisible(false);
		setSize(410, 410);
		setLayout(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);

		tekst = new JTextArea("");

		JScrollPane jps = new JScrollPane(tekst);
		jps.setBounds(0, 0, 400, 340);
		add(jps);

		czysc = new JButton("Czyœæ");
		czysc.setBounds(150, 347, 100, 20);
		czysc.addActionListener(this);
		add(czysc);

	}

	public static void DopiszTekst(String nowy) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();

		String stary = tekst.getText() + "\n" + dateFormat.format(date) + "\n"
				+ nowy + "\n";
		tekst.setText(stary);

	}

	public void actionPerformed(ActionEvent e) {
		Object z = e.getSource();
		if (z == czysc) {
			tekst.setText("");
		}

	}

}
