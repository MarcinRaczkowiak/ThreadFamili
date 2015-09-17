package mozgi;

import java.util.Random;

import javax.swing.JOptionPane;

import okienka.GuzikiOn;
import okienka.GuzikiOna;
import okienka.Okienko;
import okienka.OkienkoNiepowodzeñ;
import otoczenie.DobraM;
import otoczenie.PoziomTrudnosci;
import otoczenie.ZasobyRodzinyM;
import otoczenie.ZwierzetaM;

public class Mozg {
	String imie;
	private boolean zyje = true;

	private int hp;
	private int sex;
	private int sen;
	private int glod;

	private int zmeczenie;
	private int sila;
	private int zwinnosc;
	private int lenistwo;

	private int przedmiot;

	private boolean plecm;
	static boolean zmuszaczon = false;
	static String polecenieon = "";
	static boolean zmuszacz = false;
	static String polecenie = "";

	public Mozg(int sen, int hp, int sila, int przedmiot, int glod,
			int lenistwo, int sex, String imie, boolean plecm) {
		this.sen = sen;
		this.hp = hp;
		this.sila = sila;
		this.glod = glod;
		this.przedmiot = przedmiot;
		this.sex = sex;
		this.lenistwo = lenistwo;
		this.imie = imie;
		this.plecm = plecm;
	}

	public void Mysl(final On on, final Ona ona) {
		if (zmuszaczon && getPlec()) {
			zmuszaczon(on, ona);
		} else if (zmuszacz && !getPlec()) {
			zmuszacz(on, ona);
		} else if (PoziomTrudnosci.getOnSuwak().equals("zdobywaniePokarmu")
				&& getPlec()
				|| PoziomTrudnosci.getOnaSuwak().equals("zdobywaniePokarmu")
				&& !getPlec()) {
			MyslZbierajJedzenie(on, ona);
		} else if (PoziomTrudnosci.getOnSuwak().equals("zbierajSurowce")
				&& getPlec()
				|| PoziomTrudnosci.getOnaSuwak().equals("zbierajSurowce")
				&& !getPlec()) {
			MyslZbierajSurowce(on, ona);
		} else if (PoziomTrudnosci.getOnSuwak()
				.equals("przetwarzanieProduktow")
				&& getPlec()
				|| PoziomTrudnosci.getOnaSuwak().equals(
						"przetwarzanieProduktow") && !getPlec()) {
			MyslPrzetwarzaj(on, ona);
		} else if (PoziomTrudnosci.getOnSuwak().equals("dbajOSiebie")
				&& getPlec()
				|| PoziomTrudnosci.getOnaSuwak().equals("dbajOSiebie")
				&& !getPlec()) {
			MyslDbajOSiebie(on, ona);

		} else {
			MyslAutomat(on, ona);
		}
	}

	public void zmuszaczon(final On on, final Ona ona) {
		if (GuzikiOn.getciagloscon())
			zmuszaczon = false;

		if (polecenie.equals("zdobywaniePokarmu")) {

		} else if (polecenieon.equals("SzukanieKapusty")) {
			Sex();
		} else if (polecenieon.equals("Jedz")) {
			Jedz();
		} else if (polecenieon.equals("ZnajdzJedzenie")) {
			ZnajdzJedzenie();
		} else if (polecenieon.equals("ZnajdzZiola")) {
			ZnajdzZiola();
		} else if (polecenieon.equals("ZnajdzGline")) {
			ZnajdzGline();
		} else if (polecenieon.equals("ZrobLeki")) {
			ZrobLeki();
		} else if (polecenieon.equals("ZrobCegle")) {
			ZrobCegle();
		} else if (polecenieon.equals("Lecz")) {
			Lecz();
		} else if (polecenieon.equals("Spij")) {
			Spij();
		} else if (polecenieon.equals("Zabij")) {
			Zabij();
		} else if (polecenie.equals("ZrobPasza")) {
			ZrobPasza();
		} else if (polecenieon.equals("ChodujKury")) {
			ChodujKury();

		} else {
			on.zmuszaczon();
		}

	}

	public void zmuszacz(final On on, final Ona ona) {
		if (GuzikiOna.getciagloscona())
			zmuszacz = false;

		if (polecenie.equals("zdobywaniePokarmu")) {

		} else if (polecenie.equals("Sex")) {
			Sex();
		} else if (polecenie.equals("Jedz")) {
			Jedz();
		} else if (polecenie.equals("ZnajdzJedzenie")) {
			ZnajdzJedzenie();
		} else if (polecenie.equals("ZnajdzZiola")) {
			ZnajdzZiola();
		} else if (polecenie.equals("ZnajdzGline")) {
			ZnajdzGline();
		} else if (polecenie.equals("ZrobLeki")) {
			ZrobLeki();
		} else if (polecenie.equals("ZrobCegle")) {
			ZrobCegle();
		} else if (polecenie.equals("Lecz")) {
			Lecz();
		} else if (polecenie.equals("Spij")) {
			Spij();
		} else if (polecenie.equals("Zabij")) {
			Zabij();
		} else if (polecenie.equals("ZrobPasza")) {
			ZrobPasza();
		} else if (polecenieon.equals("ChodujKury")) {
			ChodujKury();

		} else {
			ona.zmuszaczona(on, ona);
		}

	}

	public void MyslPrzetwarzaj(final On on, final Ona ona) {
		Random rand = new Random();
		int b = rand.nextInt(100);
		if (b <= 33) {
			ZrobLeki();
		} else if (b <= 66) {
			ZrobCegle();
		} else {
			ZrobPasza();
		}
	}

	public void MyslZbierajJedzenie(final On on, final Ona ona) {
		ZnajdzJedzenie();
	}

	public void MyslZbierajSurowce(final On on, final Ona ona) {
		Random rand = new Random();
		int b = rand.nextInt(100);
		if (b <= 50) {
			ZnajdzZiola();
		} else {
			ZnajdzGline();
		}
	}

	public void MyslAutomat(final On on, final Ona ona) {
		if (hp < sex) {
			if (hp < sen) {
				if (hp < glod) {
					if (hp < 50) {
						Lecz();
					} else {
						if (getPlec()) {
							on.PraceOn(on, ona);
						} else {
							ona.PraceOna(on, ona);
						}
					}

				} else if (glod < 50) {
					Jedz();
				} else {
					if (getPlec()) {
						on.PraceOn(on, ona);
					} else {
						ona.PraceOna(on, ona);
					}
				}
			} else if (sen < glod) {
				if (sen < 50) {

					Spij();
				} else {
					if (getPlec()) {
						on.PraceOn(on, ona);
					} else {
						ona.PraceOna(on, ona);
					}
				}

			} else if (glod < 50) {
				Jedz();
			} else {
				if (getPlec()) {
					on.PraceOn(on, ona);
				} else {
					ona.PraceOna(on, ona);
				}

			}
		} else if (sex < sen) {
			if (sex < glod) {
				if (sex < 50) {

					Sex();
				} else {
					if (getPlec()) {
						on.PraceOn(on, ona);
					} else {
						ona.PraceOna(on, ona);
					}
				}

			} else if (glod < 50) {
				Jedz();
			} else {
				if (getPlec()) {
					on.PraceOn(on, ona);
				} else {
					ona.PraceOna(on, ona);
				}

			}

		} else if (sen < glod) {
			if (sen < 50) {

				Spij();
			} else {
				if (getPlec()) {
					on.PraceOn(on, ona);
				} else {
					ona.PraceOna(on, ona);
				}
			}

		} else if (glod < 50) {
			Jedz();
		} else {
			if (getPlec()) {
				on.PraceOn(on, ona);
			} else {
				ona.PraceOna(on, ona);
			}

		}

	}

	public void MyslDbajOSiebie(final On on, final Ona ona) {
		if (hp < sex) {
			if (hp < sen) {
				if (hp < glod) {
					Lecz();
				} else {
					Jedz();

				}
			} else if (sen < glod) {

				Spij();

			} else {
				Jedz();

			}
		} else if (sex < sen) {
			if (sex < glod) {

				Sex();

			} else {
				Jedz();

			}

		} else if (sen < glod) {
			Spij();

		} else {
			Jedz();

		}
	}

	public void ChodujKury() {

		if (ZasobyRodzinyM.getJajka() > 0) {
			ZasobyRodzinyM.OdliczJajka(1);
			Okienko.updateTableZasobyRodziny();
			if (ZwierzetaM.getKury() < (DobraM.getKurnik()) * 10) {
				ZwierzetaM.DodajKure();
				Okienko.updateTableZwierzeta();
			} else {
				String a = imie + ". Wychodowana kura uciek³a! \n";

				if (ZwierzetaM.getKury() >= (DobraM.getKurnik()) * 10)
					a = a + " Za ma³o miejsca w kurniku!!!";
				OkienkoNiepowodzeñ.DopiszTekst(a);
				if (!PoziomTrudnosci.getOkienkaInformacyjne())
					JOptionPane.showMessageDialog(null, a, "Pilna wiadomoœæ",
							JOptionPane.INFORMATION_MESSAGE);
			}

		} else {
			String a = imie + " Nie wykona zadania bo \n";
			if (ZasobyRodzinyM.getJajka() == 0)
				a = a + "Nie posiadasz Jajek";
			if (ZwierzetaM.getKury() >= (DobraM.getKurnik()) * 10)
				a = a + "\n Za ma³o miejsca w kurniku";
			OkienkoNiepowodzeñ.DopiszTekst(a);
			if (!PoziomTrudnosci.getOkienkaInformacyjne())
				JOptionPane.showMessageDialog(null, a, "Pilna wiadomoœæ",
						JOptionPane.INFORMATION_MESSAGE);
		}

		if (getPlec()) {
			Okienko.OnRobi("Choduje kury  ");
		} else {
			Okienko.OnaRobi("Choduje kury  ");
		}

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void Sex() {
		sex = 100;

		if (getPlec()) {
			Okienko.OnRobi("Zaglada do kapusty  ");
		} else {
			Okienko.OnaRobi("Zagl¹da do kapuste  ");
		}

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void ZrobPasza() {

		if (ZasobyRodzinyM.getJedzenie() > 4) {
			ZasobyRodzinyM.OdliczJedzenie(4);
			ZasobyRodzinyM.DodajPasza(25);
			Okienko.updateTableZasobyRodziny();

			glod += 5;
			if (getPlec()) {
				Okienko.OnRobi("Robi pasze  ");
			} else {
				Okienko.OnaRobi("Robi paszae  ");
			}

			try {
				Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
						* PoziomTrudnosci.getTempo() * 900));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			ZnajdzJedzenie();
		}

	}

	public void Jedz() {

		if (ZasobyRodzinyM.getJedzenie() > 0 || ZasobyRodzinyM.getJajka() > 0) {
			if (ZasobyRodzinyM.getJedzenie() > 0) {
				ZasobyRodzinyM.OdliczJedzenie(1);

				glod = glod + 25;
			}
			if (ZasobyRodzinyM.getJajka() > 1) {
				ZasobyRodzinyM.OdliczJajka(2);

				glod = glod + 25;
			}
			Okienko.updateTableZasobyRodziny();
			if (getPlec()) {
				Okienko.OnRobi("Je posi³ek  ");
			} else {
				Okienko.OnaRobi("Je posi³ek  ");
			}

			try {
				Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
						* PoziomTrudnosci.getTempo() * 600));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			ZnajdzJedzenie();
		}

	}

	public void ZnajdzJedzenie() {
		Random rand = new Random();
		int b = rand.nextInt(100);
		if (b <= 25) {
			ZasobyRodzinyM.DodajJedzenie(1);
			Okienko.updateTableZasobyRodziny();
		}
		if (getPlec()) {
			Okienko.OnRobi("Poszukuje Jedzenia  ");
		} else {
			Okienko.OnaRobi("Poszukuje Jedzenia  ");
			ZasobyRodzinyM.DodajJedzenie(2);
		}

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void ZnajdzZiola() {
		Random rand = new Random();
		int b = rand.nextInt(100);
		if (b <= 25) {
			ZasobyRodzinyM.DodajZiola(1);
		}
		Okienko.updateTableZasobyRodziny();
		if (getPlec()) {
			Okienko.OnRobi("Poszukuje Zió³  ");
		} else {
			Okienko.OnaRobi("Poszukuje Zió³  ");
			ZasobyRodzinyM.DodajZiola(1);
		}

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 1500));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void ZnajdzGline() {
		ZasobyRodzinyM.DodajGlina(1);
		Okienko.updateTableZasobyRodziny();
		if (getPlec()) {
			Okienko.OnRobi("Poszukuje Gliny  ");
		} else {
			Okienko.OnaRobi("Poszukuje Gliny  ");
		}

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 1700));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void ZrobLeki() {
		if (ZasobyRodzinyM.getZiola() > 2) {
			ZasobyRodzinyM.OdliczZiola(3);
			ZasobyRodzinyM.DodajLekarstwo();
			Okienko.updateTableZasobyRodziny();
		} else {
			String a = imie + " Nie wykona zadania bo \n";
			if (ZasobyRodzinyM.getZiola() <= 2)
				a = a + "Za ma³o zio³a w magazynie";
			OkienkoNiepowodzeñ.DopiszTekst(a);
			if (!PoziomTrudnosci.getOkienkaInformacyjne())
				JOptionPane.showMessageDialog(null, a, "Pilna wiadomoœæ",
						JOptionPane.INFORMATION_MESSAGE);
		}
		if (getPlec()) {
			Okienko.OnRobi("Robi leki  ");
		} else {
			Okienko.OnaRobi("Robi leki  ");
		}

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 4000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void ZrobCegle() {
		if (ZasobyRodzinyM.getGlina() > 3) {
			ZasobyRodzinyM.DodajCegla();
			Okienko.updateTableZasobyRodziny();
		} else {
			String a = imie + " Nie wykona zadania bo \n";
			if (ZasobyRodzinyM.getGlina() <= 2)
				a = a + "Za ma³o gliny w magazynie";
			OkienkoNiepowodzeñ.DopiszTekst(a);
			if (!PoziomTrudnosci.getOkienkaInformacyjne())
				JOptionPane.showMessageDialog(null, a, "Pilna wiadomoœæ",
						JOptionPane.INFORMATION_MESSAGE);
		}
		if (getPlec()) {
			Okienko.OnRobi("Wypala ceg³e  ");
			ZasobyRodzinyM.DodajCegla();
		} else {
			Okienko.OnaRobi("Wypala ceg³e  ");
		}
		Okienko.updateTableZasobyRodziny();
		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 3000));
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

	public void Lecz() {
		if (ZasobyRodzinyM.getLekarstwo() > 0) {
			ZasobyRodzinyM.OdliczLekarstwo(1);
			Okienko.updateTableZasobyRodziny();
			hp += 25;
			if (getPlec()) {
				Okienko.OnRobi("Leczy Siê  ");
			} else {
				Okienko.OnaRobi("Leczy siê  ");
			}

			try {
				Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
						* PoziomTrudnosci.getTempo() * 400));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			if (ZasobyRodzinyM.getZiola() >= 3) {
				ZrobLeki();
			} else {
				ZnajdzZiola();
			}
		}
	}

	public void Spij() {
		sen = 100;
		System.out.println(sen);
		if (getPlec()) {
			Okienko.OnRobi(" spi  ");
		} else {
			Okienko.OnaRobi(" spi  ");
		}

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 7000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean getPlec() {
		return plecm;
	}

	public String getImie() {
		return imie;
	}

	public boolean isZyje() {
		return zyje;
	}

	public void Zabij() {
		zyje = false;
		if (getPlec()) {
			Okienko.OnRobi("Zmar³  ");
		} else {
			Okienko.OnaRobi("Zmar³a  ");
		}
	}

	public int getSen() {
		return sen;
	}

	public int getHp() {
		return hp;
	}

	public int getSila() {
		return sila;
	}

	public int getZwinnosc() {
		return zwinnosc;
	}

	public int getZmeczenie() {
		return zmeczenie;
	}

	public int getSex() {
		return sex;
	}

	public int getLenistwo() {
		return lenistwo;
	}

	public int getPrzedmiot() {
		return przedmiot;
	}

	public int getGlod() {
		return glod;
	}

	public static void zmuszacztrue() {
		zmuszacz = true;

	}

	public static void zmuszacztrueon() {
		zmuszaczon = true;

	}

	public static void setPolecenie(String poleceni) {
		polecenie = poleceni;
	}

	public static void setPolecenieon(String poleceni) {
		polecenieon = poleceni;
	}

	public void czas(On on, Ona ona) {
		if (zyje) {
			if (!PoziomTrudnosci.getOchota()) {
				sex -= 1;
			} else {
				sex = 48;
			}
			if (!PoziomTrudnosci.getWyspany())
				sen -= 1;
			if (!PoziomTrudnosci.getSytosc())
				glod -= 2;
			if (sex <= 1) {
				hp -= 1;
			}
			if (sen <= 1) {
				hp -= 1;
			}
			if (glod <= 1) {
				hp -= 2;
			}
			if (sex <= -15) {
				hp -= 2;
			}
			if (sen <= -15) {
				hp -= 2;
			}
			if (glod <= -15) {
				hp -= 2;
			}
			if (hp <= 1) {
				zyje = false;
				if (getPlec()) {
					Okienko.OnRobi("Zmar³  ");
				} else {
					Okienko.OnaRobi("Zmar³a  ");
				}
			}

		}

	}
}
