package PainelRelatorio;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import Bin.Produto;
import Persistence.DAO;
import TableModel.Produto.TMRelatorio;

@SuppressWarnings("serial")
public class PainelRelatorioProduto extends JPanel {
	
	//TODO - verificar os tratamentos de exceções, inserssão de numeros e valores não preenchidos
	private JTable table;
	
	TMRelatorio model = new TMRelatorio();

	private DAO dao=new DAO();

	/**
	 * Create the panel.
	 */

	public PainelRelatorioProduto() {

		this.setBounds(263, 100, 1099, 579);
		// this.setBounds(0, 0, 1099, 579);
		this.setLayout(null);
		// this.add(new CadastroProduto());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 102));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(0, 0, 1099, 54);
		add(panel);
		panel.setLayout(null);

		JLabel lblCadastroEAlterao = new JLabel(
				"INVENTARIO DE PRODUTOS");
		lblCadastroEAlterao.setForeground(new Color(255, 255, 255));
		lblCadastroEAlterao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastroEAlterao.setBounds(21, 11, 328, 32);
		panel.add(lblCadastroEAlterao);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 1079, 503);
		add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		atualizaTabela();
	}
	
	private void atualizaTabela() {
		model.removeTudo();

		@SuppressWarnings("unchecked")
		List<Produto> lista = (List<Produto>) dao.listarObjetos(Produto.class,"descricao");
		//System.out.println(lista.size());
		for (int i = 0; i < lista.size(); i++) {
			Produto produto = (Produto) lista.get(i);
			
			model.addRow(produto);
		}
		
		

	}

	
}
