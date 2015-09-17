package start;

import koniec.koniec;
import mozgi.On;
import mozgi.Ona;
import okienka.Okienko;
import okienka.OkienkoNiepowodzeñ;
import okienka.OkienkoSuwaki;
import otoczenie.DobraM;
import otoczenie.Podstawowe;
import otoczenie.PoziomTrudnosci;
import otoczenie.ZasobyRodzinyM;
import otoczenie.ZwierzetaM;

public class Kreator {

	private Okienko okienko;
	private OkienkoNiepowodzeñ okienkoNiepowodzeñ;
	private OkienkoSuwaki suwaki;

	public void main() {
		new Podstawowe();
		new ZasobyRodzinyM();

		String imie = "Marek";
		String nazwisko = "Nowak";
		String imieona = "Helena";

		int lenistwo = 50;
		int przedmiot = 50;
		int sila = 50;

		int glod = 70;
		int hp = 100;
		int sen = 100;
		int sex = 50;

		On on = new On(sen, hp, sila, przedmiot, glod, lenistwo, sex, imie,
				nazwisko, true);
		sex = 100;
		glod = 100;
		sen = 20;
		Ona ona = new Ona(sen, hp, sila, przedmiot, glod, lenistwo, sex,
				imieona, false);
		okienkoNiepowodzeñ = new OkienkoNiepowodzeñ();
		suwaki = new OkienkoSuwaki();
		okienko = new Okienko(on, ona, okienkoNiepowodzeñ, suwaki);
		try {
			Thread.sleep(900);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		doWork(on, ona, okienko);
	}

	public void doWork(final On on, final Ona ona, final Okienko okienko) {

		Thread ton = new Thread(new Runnable() {

			public void run() {
				while (on.isZyje()) {

					on.Mysl(on, ona);
				}

			}

		});

		Thread tona = new Thread(new Runnable() {
			public void run() {
				while (ona.isZyje()) {

					ona.Mysl(on, ona);
				}
			}
		});
		Thread tNatura = new Thread(new Runnable() {
			public void run() {
				while (ona.isZyje() || on.isZyje()) {
					if (ZwierzetaM.getKury() > 0) {

						ZasobyRodzinyM.DodajOdchody(ZwierzetaM.getKury());
						if ((ZwierzetaM.getKury() - DobraM.getDrewnianyPlot()) < ZasobyRodzinyM
								.getPasza()) {
							ZasobyRodzinyM
									.OdliczPasza((ZwierzetaM.getKury() - DobraM
											.getDrewnianyPlot()));
							ZasobyRodzinyM.DodajJajka(ZwierzetaM.getKury());
							Okienko.updateTableZasobyRodziny();
						} else {
							ZwierzetaM.OdliczKury(1);
							Okienko.updateTableZwierzeta();
						}
					}
					try {
						Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
								* PoziomTrudnosci.getTempo() * 70000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread tCzas = new Thread(new Runnable() {
			public void run() {
				while (ona.isZyje() || on.isZyje()) {
					ona.czas(on, ona);
					on.czas(on, ona);
					okienko.updateTableAtrybutyPostaci(on, ona);
					if (ona.isZyje() || on.isZyje()) {

						try {
							Thread.sleep((long) (PoziomTrudnosci.getUtrataSil()
									* PoziomTrudnosci.getTempo() * 900));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				okienko.off();
				koniec koniec = new koniec();
			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ton.start();
		tona.start();
		tNatura.start();
		tCzas.start();
		try {
			ton.join();
			tona.join();
			tNatura.join();
			tCzas.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}
}
