package koniec;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import otoczenie.Podstawowe;

public class koniec extends JFrame {

	private JLabel koniec = new JLabel("Koniec gry przegra³eœ");
	private JLabel punktyTekst = new JLabel("Zdobyte punkty");
	private JLabel punkty = new JLabel(String.valueOf(Podstawowe.getLicz()));

	public koniec() {

		setTitle("Gra w Boga");
		setVisible(true);
		setSize(800, 400);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

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

}
