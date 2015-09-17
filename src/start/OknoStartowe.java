package start;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import otoczenie.Podstawowe;

public class OknoStartowe extends JFrame implements ActionListener {
	private JButton enter;
	private JLabel koniec = new JLabel("Koniec gry przegra³eœ");
	private JLabel punktyTekst = new JLabel("Zdobyte punkty");
	private JLabel punkty = new JLabel(String.valueOf(Podstawowe.getLicz()));

	public OknoStartowe() {

		setTitle("Gra w Boga");
		setVisible(true);
		setSize(800, 400);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		enter = new JButton("GO");
		enter.setBounds(201, 21, 60, 20);
		enter.addActionListener(this);
		add(enter);

		koniec.setBounds(130, 30, 350, 50);
		koniec.setFont(new Font("SansSerif", Font.BOLD, 28));
		punkty.setBounds(220, 80, 220, 25);
		punkty.setFont(new Font("SansSerif", Font.BOLD, 18));
		punktyTekst.setBounds(70, 80, 220, 25);
		punktyTekst.setFont(new Font("SansSerif", Font.BOLD, 18));
		add(punkty);
		add(koniec);
		add(punktyTekst);

	}

	public void actionPerformed(ActionEvent e) {
		Object zr = e.getSource();
		if (zr == enter)
			dispose();

	}

}
