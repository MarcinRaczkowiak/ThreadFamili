package start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mozgi.On;
import mozgi.Ona;
import okienka.AtrybutyPostaci;
import okienka.Dobra;
import okienka.ZasobyRodziny;
import okienka.Zwierzeta;

public class p2Samouczek extends JPanel implements ActionListener {
	private JButton KS, UG;
	private String imie = "Marek";
	private String nazwisko = "Nowak";
	private String imieona = "Helena";

	private int lenistwo = 50;
	private int przedmiot = 50;
	private int sila = 50;

	private int glod = 70;
	private int hp = 100;
	private int sen = 100;
	private int sex = 50;

	On on = new On(sen, hp, sila, przedmiot, glod, lenistwo, sex, imie,
			nazwisko, true);

	Ona ona = new Ona(sen, hp, sila, przedmiot, glod, lenistwo, sex, imieona,
			false);

	JLabel AtrybutyPostaci = new JLabel("Atrybuty postaci:");
	JLabel ZasobyRodziny = new JLabel("ZasobyRodziny:");
	JLabel Dobra = new JLabel("Dobra Budynki:");
	JLabel Zwierzeta = new JLabel("Posiadene zwierzeta:");

	public p2Samouczek() {
		setSize(800, 600);

		setLayout(null);

		JLabel tekstSamouczka = new JLabel(
				"Tutaj widoczna jest tabela z punktami   -> ");
		tekstSamouczka.setBounds(1, 1, 450, 20);
		add(tekstSamouczka);
		JLabel tekstSamouczka2 = new JLabel(
				"postaci pilnuj by parametry nie spad³y bo zgin¹ ");
		tekstSamouczka2.setBounds(1, 20, 450, 20);
		add(tekstSamouczka2);
		JLabel tekstSamouczka3 = new JLabel(
				"Tutaj widoczna jest tabela z surowcami   -> ");
		tekstSamouczka3.setBounds(1, 140, 450, 20);
		add(tekstSamouczka3);
		JLabel tekstSamouczka4 = new JLabel(
				"zaz¹dzaj nimi m¹drze i prze¿yj jak naj ³urzej ");
		tekstSamouczka4.setBounds(1, 160, 450, 20);
		add(tekstSamouczka4);

		AtrybutyPostaci t = new AtrybutyPostaci(on, ona);
		ZasobyRodziny t2 = new ZasobyRodziny();
		Dobra t3 = new Dobra(on, ona);
		Zwierzeta t4 = new Zwierzeta(on, ona);
		t.setBounds(10, 19, 467, 100);
		t2.setBounds(310, 140, 467, 200);
		t3.setBounds(310, 355, 467, 90);
		t4.setBounds(310, 460, 467, 100);
		add(t);
		add(t2);
		add(t3);
		add(t4);

		AtrybutyPostaci.setBounds(300, 1, 100, 20);
		ZasobyRodziny.setBounds(300, 120, 100, 20);
		Dobra.setBounds(300, 335, 100, 20);
		Zwierzeta.setBounds(300, 445, 150, 20);

		add(AtrybutyPostaci);
		add(ZasobyRodziny);
		add(Dobra);
		add(Zwierzeta);
		KS = new JButton("Zakoñæ¿ szkolenie");
		KS.setBounds(310, 550, 200, 20);
		add(KS);
		KS.addActionListener(this);

		UG = new JButton("Graj");
		UG.setBounds(510, 550, 200, 20);
		add(UG);
		UG.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		Object z = e.getSource();
		if (z == KS)

			System.exit(0);
		if (z == UG) {
			extracted();
			new Kreator().main();

		}

	}

	private void extracted() {
		System.exit(0);
	}

}
