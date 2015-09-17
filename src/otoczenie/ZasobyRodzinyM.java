package otoczenie;

public class ZasobyRodzinyM {
	private static int jedzenie = 50;

	public synchronized static void DodajJedzenie(int zysk) {
		jedzenie = jedzenie + (zysk * PoziomTrudnosci.getMnorznikSurowcow());
	}

	public synchronized static void OdliczJedzenie(int strata) {
		jedzenie = jedzenie - strata;
	}

	public static int getJedzenie() {
		return jedzenie;
	}

	private static int ziola = 5;

	public synchronized static void DodajZiola(int zysk) {
		ziola = ziola + (zysk * PoziomTrudnosci.getMnorznikSurowcow());
	}

	public synchronized static void OdliczZiola(int strata) {
		ziola = ziola - strata;
	}

	public static int getZiola() {
		return ziola;
	}

	private static int lekarstwo = 1;

	public synchronized static void DodajLekarstwo() {

		lekarstwo++;

	}

	public synchronized static void OdliczLekarstwo(int strata) {
		lekarstwo = lekarstwo - strata;
	}

	public static int getLekarstwo() {
		return lekarstwo;
	}

	private static int glina = 10;

	public synchronized static void DodajGlina(int zysk) {
		glina = glina + (zysk * PoziomTrudnosci.getMnorznikSurowcow());
	}

	public synchronized static void OdliczGlina(int strata) {
		glina = glina - strata;
	}

	public static int getGlina() {
		return glina;
	}

	private static int cegla = 0;

	public synchronized static void DodajCegla() {

		cegla++;

	}

	public synchronized static void OdliczCegla(int strata) {
		cegla = cegla - strata;
	}

	public static int getCegla() {
		return cegla;
	}

	private static int drewno = 20;

	public synchronized static void DodajDrewno(int zysk) {
		drewno = drewno + (zysk * PoziomTrudnosci.getMnorznikSurowcow());

	}

	public synchronized static void OdliczDrewno(int strata) {
		if (strata <= drewno) {
			drewno = drewno - strata;
		} else {
			drewno = 0;
		}

	}

	public static int getDrewno() {
		return drewno;
	}

	private static int garbowanaSkora = 0;

	public synchronized static void DodajGarbowanaSkora(int zysk) {
		garbowanaSkora += zysk;
	}

	public synchronized static void OdliczGarbowanaSkora(int strata) {
		garbowanaSkora -= strata;

	}

	public static int getGarbowanaSkora() {
		return garbowanaSkora;
	}

	private static int skora = 5;

	public synchronized static void DodajSkora(int zysk) {
		skora = skora + (zysk * PoziomTrudnosci.getMnorznikSurowcow());
	}

	public synchronized static void OdliczSkora(int strata) {
		skora -= strata;
	}

	public static int getSkora() {
		return skora;
	}

	private static int odchody = 0;

	public synchronized static void DodajOdchody(int zysk) {
		odchody += zysk;
	}

	public synchronized static void OdliczOdchody(int strata) {
		if (strata >= odchody) {
			odchody = 0;
		} else {
			odchody -= strata;
		}
	}

	public static int getOdchody() {
		return odchody;
	}

	private static int pasza = 30;

	public synchronized static void DodajPasza(int zysk) {
		pasza += zysk;
	}

	public synchronized static void OdliczPasza(int strata) {
		pasza -= strata;
	}

	public static int getPasza() {
		return pasza;
	}

	private static int jajka = 5;

	public synchronized static void DodajJajka(int zysk) {
		jajka += zysk;
	}

	public synchronized static void OdliczJajka(int strata) {
		jajka -= strata;
	}

	public static int getJajka() {
		return jajka;
	}

}
