package PainelMaterial;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

import Bin.Produto;
import Persistence.DAO;
import TableModel.Produto.TMBalanco;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class BalancoProduto extends JPanel implements ActionListener {

	//TODO - verificar os tratamentos de exceções, inserssão de numeros e valores não preenchidos

	// valor total para ser controlado e exibido
	private JTextField txtValortotal;
	private float valorTotalDesfalque;

	// tabelas
	private JTable tableProdutosEstoque;
	private JTable tableListaFalta;

	// botões
	private JButton btnRetirar;
	private JButton btnAlterar;
	private JButton btnCancelar;
	private JButton btnConcluir;
	private JButton btnInserir;

	// banco de dados dos produtos
	private DAO banco = new DAO();

	// lista de compra
	private List<Produto> listaFaltaProdutos = new ArrayList<Produto>();

	// model para exibição das tabelas
	private TMBalanco modelTodos = new TMBalanco();
	private TMBalanco modelfalta = new TMBalanco();
	private JButton btnArquivar;
	
	//

	/**
	 * Create the panel.
	 */
	public BalancoProduto() {
		setBackground(new Color(51, 51, 51));
		this.setBounds(10, 60, 1089, 508);
		this.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 47, 1089, 461);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(5, 45, 471, 404);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 471, 404);
		panel_1.add(scrollPane);

		tableProdutosEstoque = new JTable(modelTodos);
		scrollPane.setViewportView(tableProdutosEstoque);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(611, 45, 463, 404);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 463, 404);
		panel_2.add(scrollPane_1);

		tableListaFalta = new JTable(modelfalta);
		scrollPane_1.setViewportView(tableListaFalta);

		btnInserir = new JButton("Incluir");
		btnInserir.setBounds(486, 45, 115, 25);
		panel.add(btnInserir);

		btnRetirar = new JButton("Retirar");
		btnRetirar.setEnabled(false);
		btnRetirar.setBounds(486, 75, 115, 25);
		panel.add(btnRetirar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(486, 105, 115, 25);
		panel.add(btnAlterar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(486, 135, 115, 25);
		panel.add(btnCancelar);

		JLabel lblProdutosCadastrados = new JLabel("PRODUTOS EM ESTOQUE");
		lblProdutosCadastrados.setForeground(Color.BLACK);
		lblProdutosCadastrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProdutosCadastrados.setBounds(10, 10, 345, 25);
		panel.add(lblProdutosCadastrados);

		JLabel lblListaDeCompra = new JLabel("QUANTIDADE EM FALTA");
		lblListaDeCompra.setForeground(Color.BLACK);
		lblListaDeCompra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListaDeCompra.setBounds(611, 10, 345, 25);
		panel.add(lblListaDeCompra);

		txtValortotal = new JTextField();
		txtValortotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtValortotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtValortotal.setEnabled(false);
		txtValortotal.setText("0.00");
		txtValortotal.setBounds(934, 10, 140, 25);
		panel.add(txtValortotal);
		txtValortotal.setColumns(10);

		btnConcluir = new JButton("Concluir");
		btnConcluir.setEnabled(false);
		btnConcluir.setBounds(486, 405, 115, 25);
		panel.add(btnConcluir);

		btnArquivar = new JButton("Arquivar");
		btnArquivar.setEnabled(false);
		btnArquivar.setBounds(486, 369, 115, 25);
		panel.add(btnArquivar);

		JLabel lblCadastroCliente = new JLabel("BALAN\u00C7O DE ESTOQUE");
		lblCadastroCliente.setForeground(Color.WHITE);
		lblCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastroCliente.setBounds(10, 11, 345, 25);
		add(lblCadastroCliente);

		btnAlterar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnConcluir.addActionListener(this);
		btnRetirar.addActionListener(this);
		btnInserir.addActionListener(this);
		btnArquivar.addActionListener(this);

		atualizarTabelaEstoque();
	}

	private void atualizarTabelaEstoque() {
		modelTodos.removeTudo();

		List<?> lista = banco.listarObjetos(Produto.class, "descricao");
		for (int i = 0; i < lista.size(); i++) {
			Produto produto = (Produto) lista.get(i);
			modelTodos.addRow(produto);

		}
	}

	private void atualizarFalta() {
		modelfalta.removeTudo();

		List<Produto> lista = listaFaltaProdutos;
		for (int i = 0; i < lista.size(); i++) {
			Produto produto = (Produto) lista.get(i);
			modelfalta.addRow(produto);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();


		switch (acao) {
		case "Incluir":
			incluir();
			break;
		case "Retirar":
			retirar();
			break;
		case "Alterar":
			alterar();
			break;
		case "Cancelar":
			cancelar();
			break;
		case "Concluir":
			break;
		case "Arquivar":
			break;

		default:
			break;
		}

	}


	private void cancelar() {
		//isso aqui não faz parte desse setor!
		listaFaltaProdutos.clear();
		atualizarFalta();
		atualizaValorTotal();
		btnAlterar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnRetirar.setEnabled(false);
		btnConcluir.setEnabled(false);
		btnArquivar.setEnabled(false);
	}

	private void alterar() {
		//TODO - implementar
		String descricao = (String) tableListaFalta.getValueAt(
				tableListaFalta.getSelectedRow(), 1);
		
		float quantidade =Float.parseFloat(JOptionPane
				.showInputDialog("Quantidade: "));
		
				
		for (int i = 0; i < listaFaltaProdutos.size(); i++) {
			if (descricao.equals(listaFaltaProdutos.get(i).getDescricao())) {
				listaFaltaProdutos.get(i).setQuantidade(quantidade);
			}
		}
		atualizarFalta();
		atualizaValorTotal();

	}

	private void retirar() {
		String descricao = (String) tableListaFalta.getValueAt(
				tableListaFalta.getSelectedRow(), 0);
		for (int i = 0; i < listaFaltaProdutos.size(); i++) {
			if (descricao.equals(listaFaltaProdutos.get(i).getDescricao())) {
				listaFaltaProdutos.remove(i);
			}
		}
		atualizarFalta();
		atualizaValorTotal();
		Integer a = listaFaltaProdutos.size();
		if (a==0) {
			btnAlterar.setEnabled(false);
			btnCancelar.setEnabled(false);
			btnRetirar.setEnabled(false);
			btnConcluir.setEnabled(false);
			btnArquivar.setEnabled(false);
		}
	}

	private void incluir() {
		Integer id = (Integer) tableProdutosEstoque.getValueAt(
				tableProdutosEstoque.getSelectedRow(), 0);
		Produto produto = (Produto) banco.buscarPorId(Produto.class, id);
		produto.setQuantidade(produto.getQuantidade()-Float.parseFloat(JOptionPane
				.showInputDialog("Quantidade: ")));
		for (int i = 0; i < listaFaltaProdutos.size(); i++) {
			if (listaFaltaProdutos.get(i).getId() == produto.getId()) {
				listaFaltaProdutos.remove(i);
			}
		}
		listaFaltaProdutos.add(produto);
		atualizarFalta();
		atualizaValorTotal();
		btnAlterar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnRetirar.setEnabled(true);
		btnConcluir.setEnabled(true);
		btnArquivar.setEnabled(true);
		
	}

	private void atualizaValorTotal() {
		valorTotalDesfalque = 0;
		for (int i = 0; i < listaFaltaProdutos.size(); i++) {
			Produto produto = (Produto) banco.buscarPorId(Produto.class, listaFaltaProdutos.get(i).getId());
			
			valorTotalDesfalque = valorTotalDesfalque
					+ (listaFaltaProdutos.get(i).getQuantidade() * produto.getCusto());
		}
		txtValortotal.setText(String.valueOf(valorTotalDesfalque));

	}
}
