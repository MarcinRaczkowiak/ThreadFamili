package okienka;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import mozgi.UzupelnianieTabeli;

public class TabelaOna extends JPanel {
	private JTable tabela;

	public TabelaOna() {
		String[] columns = { "Nazwa", "iloœæ" };

		String[][] data = { { "Spij", "Czas" }, { "Obija", "Czas" },
				{ "ZnajdzJedzenie", "Czas" }, { "ZnajdzZiola", "Czas" },
				{ "SzukanieKapusty", "Czas" }, { "Sprzataj", "Czas" },
				{ "ZbierajOdchody", "Czas" }, { "Garboj", "skór i odchody" },
				{ "ZróbMaleWnyki", "5 drewna" }, { "ZrobPasza", "jedzenie" },
				{ "Jedz", "1 jedzenie" },

				{ "ZnajdzGline", "Czas" }, { "ZrobLeki", "x Zio³a" },
				{ "ZrobCegle", "x gliny" }, { "Lecz", "1 Lek" },
				{ "ChodujKury", "1 jajko" }, { "Zabij", "Seppuku" }, };

		tabela = new JTable(data, columns) {
			public boolean isCellEditable(int data, int columns) {
				return false;
			}

			public Component prepareRenderer(TableCellRenderer r, int data,
					int columns) {
				Component c = super.prepareRenderer(r, data, columns);
				if (data % 2 == 0)
					c.setBackground(Color.WHITE);

				else
					c.setBackground(Color.LIGHT_GRAY);
				if (isCellSelected(data, columns)) {
					UzupelnianieTabeli.UzupelnijONA(data);

				}

				return c;
			}

		};

		tabela.setPreferredScrollableViewportSize(new Dimension(270, 140));
		tabela.setFillsViewportHeight(true);

		JScrollPane jps = new JScrollPane(tabela);
		add(jps);

	}

	public static void main(String[] args) {

		TabelaOna t = new TabelaOna();
		TabelaOna t2 = new TabelaOna();
		JFrame jf = new JFrame();
		jf.setTitle("tabela");
		jf.setSize(600, 600);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
		jf.add(t2, BorderLayout.SOUTH);
	}

}
