package okienka;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import mozgi.On;
import mozgi.Ona;

public class Okienko extends JFrame {
	private JMenuBar menuBar;

	static JLabel onr = new JLabel("robio");
	private JLabel JLon = new JLabel("on:");
	private JLabel AtrybutyPostaci = new JLabel("Atrybuty postaci:");
	private JLabel ZasobyRodziny = new JLabel("ZasobyRodziny:");
	private JLabel Dobra = new JLabel("Dobra Budynki:");
	private JLabel Zwierzeta = new JLabel("Posiadene zwierzeta:");
	static JLabel onar = new JLabel("robib");
	private JLabel JLona = new JLabel("ona:");

	private JLabel lBug = new JLabel("Guziki Boga:");

	private JLabel onal = new JLabel("Panel za¿¹dzania kobiet¹");
	private JLabel onl = new JLabel("Panel za¿¹dzania Mêrzczyzn¹");

	private AtrybutyPostaci t;
	static ZasobyRodziny t2;
	static Dobra t3;
	static Zwierzeta t4;

	private Object on;
	private Object ona;

	public Okienko(On on, Ona ona, OkienkoNiepowodzeñ okienkoNiepowodzeñ,
			OkienkoSuwaki suwaki) {
		this.on = on;
		this.ona = ona;
		menuBar = new MenuBarOkienko(this, on, ona, okienkoNiepowodzeñ, suwaki);

		setJMenuBar(menuBar);

		t = new AtrybutyPostaci(on, ona);
		t2 = new ZasobyRodziny();
		t3 = new Dobra(on, ona);
		t4 = new Zwierzeta(on, ona);
		GuzikiBoga g1 = new GuzikiBoga();
		GuzikiOna g2 = new GuzikiOna();
		GuzikiOn g3 = new GuzikiOn();

		setTitle("Gra w Boga");
		setVisible(true);
		setSize(800, 625);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		AtrybutyPostaci.setBounds(300, 1, 100, 20);
		ZasobyRodziny.setBounds(300, 120, 100, 20);
		Dobra.setBounds(300, 335, 100, 20);
		JLon.setBounds(1, 1, 220, 15);
		JLona.setBounds(1, 15, 220, 15);
		onr.setBounds(50, 1, 250, 15);
		onar.setBounds(50, 15, 250, 15);
		onl.setBounds(5, 332, 220, 15);
		onal.setBounds(5, 55, 467, 100);
		lBug.setBounds(5, 30, 220, 15);
		Zwierzeta.setBounds(300, 445, 150, 20);
		t.setBounds(310, 19, 467, 100);
		t2.setBounds(310, 140, 467, 200);
		t3.setBounds(310, 355, 467, 90);
		t4.setBounds(310, 460, 467, 100);
		g1.setBounds(1, 45, 300, 60);
		g2.setBounds(1, 115, 500, 210);
		g3.setBounds(1, 350, 500, 210);

		add(AtrybutyPostaci);
		add(ZasobyRodziny);
		add(Dobra);
		add(onal);
		add(onl);
		add(JLon);
		add(JLona);
		add(onr);
		add(onar);
		add(lBug);
		add(Zwierzeta);
		add(t);
		add(t2);
		add(t3);
		add(t4);
		add(g1);
		add(g2);
		add(g3);

	}

	public static void Repaint(On on, Ona ona) {

	}

	public static void OnRobi(String on) {
		onr.setText(on);
	}

	public static void OnaRobi(String ona) {
		onar.setText(ona);
	}

	public void updateTableAtrybutyPostaci(On on, Ona ona) {
		t.updateTable(on, ona);

	}

	public static void updateTableZasobyRodziny() {
		t2.updateTable();

	}

	public static void updateTableDobra() {
		t3.updateTable();

	}

	public static void updateTableZwierzeta() {
		t4.updateTable();

	}

	public void off() {
		setVisible(false);
		// System.exit(0);
	}

}
