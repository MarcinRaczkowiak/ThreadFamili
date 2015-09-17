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

public class AtrybutyPostaci extends JPanel {

	private JTable tabela;

	public AtrybutyPostaci(On on, Ona ona) {
		JTable tabela = createTable(on, ona);
		JScrollPane jps = new JScrollPane(tabela);
		add(jps);

	}

	private JTable createTable(On on, Ona ona) {
		DefaultTableModel dtm = getModel(on, ona);
		tabela = new MojaTabela(dtm);

		tabela.setPreferredScrollableViewportSize(new Dimension(450, 64));
		tabela.setFillsViewportHeight(false);
		return tabela;
	}

	private DefaultTableModel getModel(On on, Ona ona) {
		String[] columnNames = { "Nazwa", on.ImieNazwisko(), ona.Nazwisko(on) };
		String[][] data = prepareData(on, ona);

		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		return dtm;
	}

	private static String[][] prepareData(On on, Ona ona) {
		String[][] data = {
				{ "Punkty zdrowia", String.valueOf(on.getHp()),
						String.valueOf(ona.getHp()) },
				{ "Ochota", String.valueOf(on.getSex()),
						String.valueOf(ona.getSex()) },
				{ "Sen", String.valueOf(on.getSen()),
						String.valueOf(ona.getSen()) },
				{ "Sytoœæ", String.valueOf(on.getGlod()),
						String.valueOf(ona.getGlod()) } };
		return data;
	}

	public void updateTable(On on, Ona ona) {
		tabela.setModel(getModel(on, ona));
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
