package ViewRelatorio;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import modelTabela.ModelFornecedorRelatorio;
import Bin.Fornecedor;
import Persistence.Banco;

@SuppressWarnings("serial")
public class PainelRelatorioFornecedor extends JPanel {
	//TODO - verificar os tratamentos de exce��es, inserss�o de numeros e valores n�o preenchidos
	
	private JTable table;
	
	ModelFornecedorRelatorio model = new ModelFornecedorRelatorio();

	private Banco dao=new Banco();

	/**
	 * Create the panel.
	 */

	public PainelRelatorioFornecedor() {

		this.setBounds(263, 100, 1099, 579);
		// this.setBounds(0, 0, 1099, 579);
		this.setLayout(null);
		// this.add(new CadastroFornecedor());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 102));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(0, 0, 1099, 54);
		add(panel);
		panel.setLayout(null);

		JLabel lblCadastroEAlterao = new JLabel(
				"LISTA DOS FORNECEDORES");
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

		List<?> lista = dao.listarObjetos(Fornecedor.class, "nome");
		System.out.println(lista.size());
		for (int i = 0; i < lista.size(); i++) {
			Fornecedor fornecedor = (Fornecedor) lista.get(i);
			model.addRow(fornecedor);
		}

	}

		
		

	
}
