package okienka;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import mozgi.On;
import mozgi.Ona;
import otoczenie.DobraM;

public class Dobra extends JPanel {

	private JTable tabela;

	public Dobra(On on, Ona ona) {
		JTable tabela = createTable();
		JScrollPane jps = new JScrollPane(tabela);
		add(jps);
	}

	private JTable createTable() {
		DefaultTableModel dtm = getModel();
		tabela = new MojaTabela(dtm);

		tabela.setPreferredScrollableViewportSize(new Dimension(450, 64));
		tabela.setFillsViewportHeight(false);
		return tabela;
	}

	private DefaultTableModel getModel() {
		String[] columnNames = { "Nazwa", "iloœæ", "wymagania" };
		String[][] data = prepareData();

		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		return dtm;
	}

	private static String[][] prepareData() {
		String[][] data = {
				{ "ceglany mur", String.valueOf(DobraM.getCeglanyPlot()),
						"Ceg³a" },
				{ "drewniany p³ot", String.valueOf(DobraM.getDrewnianyPlot()),
						"Drewno" },
				{ "ma³e wnyki", String.valueOf(DobraM.getMaleWnyki()), "Drewno" },
				{ "rozstawione ma³e wnyki",
						String.valueOf(DobraM.getRozstawioneMaleWnyki()),
						"ma³e wnyki" },
				{ "kurnik", String.valueOf(DobraM.getKurnik()),
						"drewno ceg³y g.skóry" }, };
		return data;
	}

	public void updateTable() {
		tabela.setModel(getModel());
		repaint();
	}

	private class MojaTabela extends JTable {

		public MojaTabela(DefaultTableModel dtm) {
			super(dtm);
		}

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

			return c;
		}
	}

}
