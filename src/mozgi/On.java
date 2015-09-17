package mozgi;

import java.util.Random;

import javax.swing.JOptionPane;

import okienka.GuzikiOn;
import okienka.Okienko;
import okienka.OkienkoNiepowodzeñ;
import otoczenie.DobraM;
import otoczenie.Podstawowe;
import otoczenie.PoziomTrudnosci;
import otoczenie.ZasobyRodzinyM;
import otoczenie.ZwierzetaM;

public class On extends Mozg {
	private String nazwisko;

	public On(int oksposzczegawczosc, int hp, int sila, int przedmiot,
			int glod, int lenistwo, int sex, String imie, String nazwisko,
			boolean plecm) {
		super(oksposzczegawczosc, hp, sila, przedmiot, glod, lenistwo, sex,
				imie, plecm);
		this.nazwisko = nazwisko;

	}

	public String ImieNazwisko() {
		return imie + " " + nazwisko;
	}

	public String Nazwisko() {
		return nazwisko;
	}

	public void zmuszaczon() {
		if (polecenieon.equals("BudujMur")) {
			Bild();
		} else if (polecenieon.equals("RabDrewno")) {
			RabDrewno();

		} else if (polecenieon.equals("RozstawMaleWnyki")) {
			RozstawMaleWnyki();
		} else if (polecenieon.equals("ZbierzMaleWnyki")) {
			ZbierzMaleWnyki();
		} else if (polecenieon.equals("BudujKurnik")) {
			BudujKurnik();
		} else if (polecenieon.equals("BudujPlot")) {
			BudujPlot();
		} else {
			zmuszaczon = false;
			polecenieon = "";
			GuzikiOn.setCiaglosON(false);
			OkienkoNiepowodzeñ.DopiszTekst("Nie ma takiego polecenia");
			if (!PoziomTrudnosci.getOkienkaInformacyjne())
				JOptionPane.showMessageDialog(null, "Komêda " + polecenie
						+ " nie istnieje ", "Pilna wiadomoœæ",
						JOptionPane.WARNING_MESSAGE);
		}
	}

	public void AutomatON() {
		Random rand = new Random();
		int b = rand.nextInt(100);
		if (b <= 25) {
			Przerwa();
		} else if (b <= 50) {
			RabDrewno();
		} else if (b <= 75) {
			RozstawMaleWnyki();
		} else {
			ZbierzMaleWnyki();
		}
	}

	public void PraceOn(final On on, final Ona ona) {
		Random rand = new Random();
		int b = rand.nextInt(100);
		if (b <= 20) {
			MyslPrzetwarzaj(on, ona);
		} else if (b <= 40) {
			MyslZbierajJedzenie(on, ona);
		} else if (b <= 60) {
			MyslZbierajSurowce(on, ona);
		} else if (b <= 80) {
			MyslDbajOSiebie(on, ona);
		} else {
			AutomatON();
		}
	}

	public void BudujKurnik() {
		Okienko.OnRobi("Buduje Kurnik");
		if (ZasobyRodzinyM.getCegla() >= 20 && ZasobyRodzinyM.getSkora() >= 2
				&& ZasobyRodzinyM.getDrewno() >= 30) {
			ZasobyRodzinyM.OdliczCegla(20);
			ZasobyRodzinyM.OdliczDrewno(30);
			ZasobyRodzinyM.OdliczSkora(2);
			DobraM.DodajKurnik();
			Podstawowe.licz();

		} else {
			String a = imie + " Nie wykona zadania bo \n";
			if (ZasobyRodzinyM.getCegla() < 20)
				a = a + "Za ma³o Cegie³ w magazynie\n";
			if (ZasobyRodzinyM.getSkora() < 2)
				a = a + "Za ma³o Skór w magazynie\n";
			if (ZasobyRodzinyM.getDrewno() < 30)
				a = a + "Za ma³o Drewna w magazynie\n";
			OkienkoNiepowodzeñ.DopiszTekst(a);
			if (!PoziomTrudnosci.getOkienkaInformacyjne())
				JOptionPane.showMessageDialog(null, a, "Pilna wiadomoœæ",
						JOptionPane.INFORMATION_MESSAGE);
		}

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void BudujPlot() {
		Okienko.OnRobi("Robi p³ot");
		if (ZasobyRodzinyM.getDrewno() >= 15) {
			ZasobyRodzinyM.OdliczDrewno(15);
			Okienko.updateTableZasobyRodziny();
			DobraM.DodajDrewnianyPlot();
			Okienko.updateTableDobra();
			Podstawowe.licz();

		} else {
			String a = imie + " Nie wykona zadania bo \n";
			if (ZasobyRodzinyM.getDrewno() < 15)
				a = a + "Za ma³o Drewna w magazynie\n";
			OkienkoNiepowodzeñ.DopiszTekst(a);
			if (!PoziomTrudnosci.getOkienkaInformacyjne())
				JOptionPane.showMessageDialog(null, a, "Pilna wiadomoœæ",
						JOptionPane.INFORMATION_MESSAGE);
		}

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void Bild() {
		Okienko.OnRobi(" Bilding");
		if (ZasobyRodzinyM.getCegla() >= 15) {
			ZasobyRodzinyM.OdliczCegla(15);
			Okienko.updateTableZasobyRodziny();
			DobraM.DodajCeglanyPlot();
			Okienko.updateTableDobra();
			Podstawowe.licz();

		} else if (!PoziomTrudnosci.getOkienkaInformacyjne()) {
			String a = imie + " Nie wykona zadania bo \n";
			if (ZasobyRodzinyM.getCegla() < 15)
				a = a + "Za ma³o Cegie³ w magazynie\n";
			OkienkoNiepowodzeñ.DopiszTekst(a);
			if (!PoziomTrudnosci.getOkienkaInformacyjne())
				JOptionPane.showMessageDialog(null, a, "Pilna wiadomoœæ",
						JOptionPane.INFORMATION_MESSAGE);
		}

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void ZbierzMaleWnyki() {
		if (DobraM.getRozstawioneMaleWnyki() >= 1) {
			DobraM.OdliczRozstawioneMaleWnyki(1);
			Random rand = new Random();
			int b = rand.nextInt(100);
			if (b >= 20) {
				DobraM.ZwiekszMaleWnyki();
				if (b > 80 && ZwierzetaM.getKury() < (DobraM.getKurnik()) * 10) {
					ZwierzetaM.DodajKure();

				}
			} else {
				ZasobyRodzinyM.DodajJedzenie(10);
				ZasobyRodzinyM.DodajSkora(1);
			}

		} else {
			String a = imie + " Nie wykona zadania bo \n";

			a = a + "W lesie nie ma ma³ych nyk";
			OkienkoNiepowodzeñ.DopiszTekst(a);
			if (!PoziomTrudnosci.getOkienkaInformacyjne())
				JOptionPane.showMessageDialog(null, a, "Pilna wiadomoœæ",
						JOptionPane.INFORMATION_MESSAGE);
		}
		Okienko.updateTableZwierzeta();
		Okienko.updateTableZasobyRodziny();
		Okienko.OnRobi("Zbiera ma³e wnyki");

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 2000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void RozstawMaleWnyki() {
		if (DobraM.getMaleWnyki() >= 1) {
			DobraM.OdliczMaleWnyki(1);
			DobraM.ZwiekszRozstawioneMaleWnyki();
			Okienko.updateTableDobra();

		} else {
			String a = imie + " Nie wykona zadania bo \n";

			a = a + "Nie ma wnyk do rozstawienia";
			OkienkoNiepowodzeñ.DopiszTekst(a);
			if (!PoziomTrudnosci.getOkienkaInformacyjne())
				JOptionPane.showMessageDialog(null, a, "Pilna wiadomoœæ",
						JOptionPane.INFORMATION_MESSAGE);
		}

		Okienko.OnRobi("Roztawia ma³e wnyki");

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 4500));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void RabDrewno() {
		Okienko.OnRobi("R¹bie drzewo");

		ZasobyRodzinyM.DodajDrewno(10);
		Okienko.updateTableZasobyRodziny();
		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void Przerwa() {
		Okienko.OnRobi(" Przerwa");

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
