package okienka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import koniec.Podsumowanie;
import mozgi.Mozg;
import mozgi.On;
import mozgi.Ona;
import otoczenie.PoziomTrudnosci;

public class MenuBarOkienko extends JMenuBar implements ActionListener {
	/**
	 * dgfggf
	 */
	private static final long serialVersionUID = -5204466433395836989L;
	private JMenu menuPlik, menuNarzedzia, menuWyglad, menuPomoc, menuZmusJa,
			menuZmusJego, menuRozkazy, menuBuduj, menuZnajdzOn, menuZnajdzOna,
			menuJaOn, menuJaOna, menuLas, menuDom, menuZrobOna, menuInneOna,
			menuOkienka, menuTempo;
	private JMenuItem mPodsumuj, mRestart, mWyjscie, mOProgramie, mMetal,
			mNimbus, mWindows, zabijOn, zabijOna, budujMur, budujKurnik,
			budujPlot, znajdzGline, znajdzJedzenie, znajdzZiola, znajdzGlinea,
			znajdzJedzeniea, znajdzZiolaa, zbierajOdchody, spij, szukajkapusty,
			jedz, lecz, rabDrewno, rozstawMaleWnyki, zbierzMaleWnyki, pasza,
			leki, cegla, kury, spijona, szukajkapustyona, jedzona, leczona,
			zrubMaleWnyki, zrobPasza, zrobLeki, zrobCegle, Sprzataj, Garboj,
			chodujKury, okienkoNiepowodzen, mSuwaki, m05, m1, m2, m4, m025;

	private JFrame okienko;
	private Object on;
	private Object ona;
	private Object okienkoNiepowodzeñ;
	private Object suwaki;

	public MenuBarOkienko(Okienko okienko, final On on, final Ona ona,
			OkienkoNiepowodzeñ okienkoNiepowodzeñ, OkienkoSuwaki suwaki) {
		super();
		this.okienko = okienko;
		this.on = on;
		this.ona = ona;
		this.okienkoNiepowodzeñ = okienkoNiepowodzeñ;
		this.suwaki = suwaki;
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

		menuTempo = new JMenu("Tempo gry");
		m025 = new JMenuItem("Tempo X 0,25");
		m05 = new JMenuItem("Tempo X 0,5");
		m1 = new JMenuItem("Tempo X 1");
		m2 = new JMenuItem("Tempo X 2");
		m4 = new JMenuItem("Tempo X 4");
		m025.addActionListener(this);
		m05.addActionListener(this);
		m1.addActionListener(this);
		m2.addActionListener(this);
		m4.addActionListener(this);
		menuTempo.add(m025);
		menuTempo.add(m05);
		menuTempo.add(m1);
		menuTempo.add(m2);
		menuTempo.add(m4);
		menuNarzedzia.add(menuTempo);

		menuRozkazy = new JMenu("Polecenia");

		menuZmusJa = new JMenu("Zmuœ j¹");

		menuJaOna = new JMenu("JA");

		zabijOna = new JMenuItem("Zabij");
		spijona = new JMenuItem("Spj");
		szukajkapustyona = new JMenuItem("Szukaj czegoœ w kapuscie");
		jedzona = new JMenuItem("Jedz");
		leczona = new JMenuItem("lecz");

		menuJaOna.add(spijona);
		menuJaOna.add(szukajkapustyona);
		menuJaOna.add(jedzona);
		menuJaOna.add(leczona);
		menuJaOna.add(zabijOna);
		menuZmusJa.add(menuJaOna);
		menuZnajdzOna = new JMenu("Szukaj");

		znajdzGlinea = new JMenuItem("Szukaj Gline");
		znajdzJedzeniea = new JMenuItem("Szukaj Jedzenie");
		znajdzZiolaa = new JMenuItem("Szukaj Zio³a");
		zbierajOdchody = new JMenuItem("Zbieraj Odchody");

		menuZnajdzOna.add(zbierajOdchody);
		menuZnajdzOna.add(znajdzGlinea);
		menuZnajdzOna.add(znajdzJedzeniea);
		menuZnajdzOna.add(znajdzZiolaa);
		menuZmusJa.add(menuZnajdzOna);

		menuZrobOna = new JMenu("Zrób");

		zrubMaleWnyki = new JMenuItem("ZrobMaleWnyki");
		zrobPasza = new JMenuItem("ZrobPasza");
		zrobLeki = new JMenuItem("ZrobLeki");
		zrobCegle = new JMenuItem("ZrobCegle");

		menuZrobOna.add(zrubMaleWnyki);
		menuZrobOna.add(zrobPasza);
		menuZrobOna.add(zrobLeki);
		menuZrobOna.add(zrobCegle);
		menuZmusJa.add(menuZrobOna);

		menuInneOna = new JMenu("Inne");

		Sprzataj = new JMenuItem("Sprzataj");
		Garboj = new JMenuItem("Garboj");
		chodujKury = new JMenuItem("ChodujKury");

		menuInneOna.add(Sprzataj);
		menuInneOna.add(Garboj);
		menuInneOna.add(chodujKury);
		menuZmusJa.add(menuInneOna);

		menuZmusJego = new JMenu("Zmuœ jego"); // on

		menuBuduj = new JMenu("Buduj");

		budujMur = new JMenuItem("Zabij Mur");
		budujKurnik = new JMenuItem("Zabij Kurnik");
		budujPlot = new JMenuItem("Zabij Plot");

		menuBuduj.add(budujMur);
		menuBuduj.add(budujKurnik);
		menuBuduj.add(budujPlot);
		menuZmusJego.add(menuBuduj);

		menuZnajdzOn = new JMenu("Szukaj");

		znajdzGline = new JMenuItem("Szukaj Gline");
		znajdzJedzenie = new JMenuItem("Szukaj Jedzenie");
		znajdzZiola = new JMenuItem("Szukaj Zio³a");

		menuZnajdzOn.add(znajdzGline);
		menuZnajdzOn.add(znajdzJedzenie);
		menuZnajdzOn.add(znajdzZiola);
		menuZmusJego.add(menuZnajdzOn);

		menuRozkazy.add(menuZmusJa);
		menuRozkazy.add(menuZmusJego);

		menuJaOn = new JMenu("JA");
		spij = new JMenuItem("Spj");
		szukajkapusty = new JMenuItem("Szukaj czegoœ w kapuscie");
		jedz = new JMenuItem("Jedz");
		lecz = new JMenuItem("lecz");
		zabijOn = new JMenuItem("Zabij");

		menuJaOn.add(spij);
		menuJaOn.add(szukajkapusty);
		menuJaOn.add(jedz);
		menuJaOn.add(lecz);
		menuJaOn.add(zabijOn);
		menuZmusJego.add(menuJaOn);

		menuLas = new JMenu("Roboty leœne");
		rabDrewno = new JMenuItem("R¹b Drewno");
		rozstawMaleWnyki = new JMenuItem("Rozstaw ma³e wnyki");
		zbierzMaleWnyki = new JMenuItem("Zbierz ma³e wnyki");
		menuLas.add(rabDrewno);
		menuLas.add(rozstawMaleWnyki);
		menuLas.add(zbierzMaleWnyki);
		menuZmusJego.add(menuLas);

		menuDom = new JMenu("Dom");
		pasza = new JMenuItem("Zrób pasze");
		leki = new JMenuItem("Zrób leki");
		cegla = new JMenuItem("Wypal ceg³ê");
		kury = new JMenuItem("Wysiaduj jajka");
		menuDom.add(pasza);
		menuDom.add(leki);
		menuDom.add(cegla);
		menuDom.add(kury);
		menuZmusJego.add(menuDom);

		menuOkienka = new JMenu("Okienka");
		okienkoNiepowodzen = new JMenuItem("Okienko niepowodzeñ");
		okienkoNiepowodzen.addActionListener(this);
		menuOkienka.add(okienkoNiepowodzen);
		mSuwaki = new JMenuItem("Paski");
		mSuwaki.addActionListener(this);
		menuOkienka.add(mSuwaki);

		menuPomoc = new JMenu("pomoc");

		mOProgramie = new JMenuItem("O programie");
		mOProgramie.addActionListener(this);
		menuPomoc.add(mOProgramie);

		add(menuPlik);
		add(menuNarzedzia);
		add(menuRozkazy);
		add(menuOkienka);
		add(Box.createHorizontalGlue());
		add(menuPomoc);
	}

	public void actionPerformed(ActionEvent e) {

		Object z = e.getSource();

		if (z == mWyjscie) {
			int odp = JOptionPane.showConfirmDialog(null, "wyjscie", "tytu³",
					JOptionPane.YES_NO_OPTION);
			if (odp == JOptionPane.YES_OPTION) {

				((Okienko) okienko).off();

			} else if (odp == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "To po co tyle zachodu");
			} else if (odp == JOptionPane.CLOSED_OPTION) {
				JOptionPane.showMessageDialog(null, "error", "tytul",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (z == mOProgramie) {
			JOptionPane
					.showMessageDialog(
							null,
							"Steruj nimi by zyskaæ jak naj wiêcej surowców \n wiêcej informacji u producenta",
							"Informacje", JOptionPane.INFORMATION_MESSAGE);
		} else if (z == mMetal) {
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
		} else if (z == mNimbus) {
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
		} else if (z == mWindows) {
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
		} else if (z == mRestart) {
			((Mozg) on).Zabij();
			((Mozg) ona).Zabij();
		} else if (z == mPodsumuj) {
			int odp = JOptionPane
					.showConfirmDialog(
							null,
							"Podsumowanie zakoñczy grê. \n Jesteœ pewien ¿e chcesz to zrobiæ",
							"Podsumuj", JOptionPane.YES_NO_OPTION);

			if (odp == JOptionPane.YES_OPTION) {

				((Okienko) okienko).off();
				Podsumowanie koniec = new Podsumowanie();
			}

		} else if (z == okienkoNiepowodzen) {
			if (!((OkienkoNiepowodzeñ) okienkoNiepowodzeñ).isVisible())
				((OkienkoNiepowodzeñ) okienkoNiepowodzeñ).setVisible(true);

		} else if (z == mSuwaki) {
			if (!((OkienkoSuwaki) suwaki).isVisible())
				((OkienkoSuwaki) suwaki).setVisible(true);
		} else if (z == m025) {
			PoziomTrudnosci.setTempo(4);
		} else if (z == m05) {
			PoziomTrudnosci.setTempo(2);
		} else if (z == m1) {
			PoziomTrudnosci.setTempo(1);
		} else if (z == m2) {
			PoziomTrudnosci.setTempo(0.5);
		} else if (z == m4) {
			PoziomTrudnosci.setTempo(0.25);
		}

	}
}
