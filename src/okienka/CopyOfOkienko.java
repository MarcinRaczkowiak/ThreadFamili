package okienka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import mozgi.On;
import mozgi.Ona;

public class CopyOfOkienko extends JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenu menuPlik, menuNarzedzia, menuWyglad, menuPomoc, menuZmusJa,
			menuZmusJego, menuRozkazy, menuBuduj;
	private JMenuItem mPodsumuj, mRestart, mWyjscie, nOProgramie, mOProgramie,
			mpKopiuj, mpDolacz, mpWklej, mMetal, mNimbus, mWindows, zabijOn,
			zabijOna;

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

	public CopyOfOkienko(On on, Ona ona) {

		menuBar = new JMenuBar();

		menuPlik = new JMenu("Plik");
		mPodsumuj = new JMenuItem("Podsumuj", 'P');
		mRestart = new JMenuItem("Reset", 'R');
		mWyjscie = new JMenuItem("Wyjscie");
		mPodsumuj.addActionListener(this);
		mRestart.addActionListener(this);
		menuPlik.add(mPodsumuj);
		menuPlik.add(mRestart);
		menuPlik.addSeparator();
		menuPlik.add(mWyjscie);
		mWyjscie.addActionListener(this);
		mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));

		menuNarzedzia = new JMenu("Narzedzia");
		menuWyglad = new JMenu("Wyglad");
		mWindows = new JMenuItem("Windows");
		mMetal = new JMenuItem("Metal");
		mNimbus = new JMenuItem("Nimbus");
		mWindows.addActionListener(this);
		mMetal.addActionListener(this);
		mNimbus.addActionListener(this);
		menuWyglad.add(mWindows);
		menuWyglad.add(mMetal);
		menuWyglad.add(mNimbus);
		menuNarzedzia.add(menuWyglad);

		menuRozkazy = new JMenu("Polecenia");

		menuZmusJa = new JMenu("Zmuœ j¹");

		zabijOna = new JMenuItem("Zabij");

		menuZmusJa.add(zabijOna);

		menuZmusJego = new JMenu("Zmuœ jego");

		menuBuduj = new JMenu("Buduj");
		menuZmusJego.add(menuBuduj);

		zabijOn = new JMenuItem("Zabij");
		menuZmusJego.add(zabijOn);

		menuRozkazy.add(menuZmusJa);
		menuRozkazy.add(menuZmusJego);

		menuPomoc = new JMenu("pomoc");

		mOProgramie = new JMenuItem("O programie");
		mOProgramie.addActionListener(this);
		menuPomoc.add(mOProgramie);

		setJMenuBar(menuBar);
		menuBar.add(menuPlik);
		menuBar.add(menuNarzedzia);
		menuBar.add(menuRozkazy);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(menuPomoc);

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
		dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object z = e.getSource();

		if (z == mWyjscie) {
			int odp = JOptionPane.showConfirmDialog(null, "wyjscie", "tytu³",
					JOptionPane.YES_NO_OPTION);
			if (odp == JOptionPane.YES_OPTION) {
				dispose();
			} else if (odp == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "To po co tyle zachodu");
			} else if (odp == JOptionPane.CLOSED_OPTION) {
				JOptionPane.showMessageDialog(null, "error", "tytul",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (z == mOProgramie)
			JOptionPane
					.showMessageDialog(
							null,
							"Steruj nimi by zyskaæ jak naj wiêcej surowców \n wiêcej informacji u producenta",
							"Informacje", JOptionPane.INFORMATION_MESSAGE);

		if (z == mMetal) {
			try {
				UIManager
						.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			} catch (InstantiationException e1) {

				e1.printStackTrace();
			} catch (IllegalAccessException e1) {

				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {

				e1.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI(this);
		}
		if (z == mNimbus) {
			try {
				UIManager
						.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {

				e1.printStackTrace();
			} catch (IllegalAccessException e1) {

				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {

				e1.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI(this);
		}
		if (z == mWindows) {
			try {
				UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			} catch (InstantiationException e1) {

				e1.printStackTrace();
			} catch (IllegalAccessException e1) {

				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {

				e1.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI(this);
		}
		if (z == mRestart) {
			JOptionPane.showMessageDialog(null, "reset w budowie",
					"Informacje", JOptionPane.INFORMATION_MESSAGE);
		}
		if (z == mPodsumuj) {
			int odp = JOptionPane
					.showConfirmDialog(
							null,
							"Podsumowanie zakoñczy grê. \n Jesteœ pewien ¿e chcesz to zrobiæ",
							"Podsumuj", JOptionPane.YES_NO_OPTION);
			if (odp == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Podsumuj w budowie",
						"Informacje", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}
}
