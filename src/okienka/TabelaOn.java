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

public class TabelaOn extends JPanel {
	private JTable tabela;

	public TabelaOn() {
		String[] columns = { "Komenda", "Wymagania" };

		String[][] data = { { "ZnajdzGline", "Czas" }, { "Spij", "Czas" },
				{ "RabDrewno", "Czas" }, { "ZnajdzJedzenie", "Czas" },
				{ "ZnajdzZiola", "Czas" }, { "SzukanieKapusty", "Czas" },
				{ "BudujMur", "15 cegie³" }, { "BudujPlot", "15 derwno" },
				{ "BudujKurnik", "20 cegie³ 2 skor 30drewna" },
				{ "RozstawMaleWnyki", "ma³e wnyki" },
				{ "ZbierzMaleWnyki", "rozstawione ma³e wnyki" },

				{ "ZrobPasza", "jedzenie" }, { "Jedz", "1 jedzenie" },

				{ "ZrobLeki", "x Zio³a" }, { "ZrobCegle", "x gliny" },
				{ "Lecz", "1 Lek" }, { "ChodujKury", "1 jajko" },
				{ "Zabij", "Seppuku" }, };

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
					UzupelnianieTabeli.UzupelnijON(data);

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

		TabelaOn t = new TabelaOn();
		TabelaOn t2 = new TabelaOn();
		JFrame jf = new JFrame();
		jf.setTitle("tabela");
		jf.setSize(600, 600);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
		jf.add(t2, BorderLayout.SOUTH);
	}

}
