package PainelComercial;

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
import javax.swing.ListSelectionModel;

import Bin.Cliente;
import Bin.Venda;
import Bin.Produto;
import Bin.Item;
import Persistence.DAO;
import TableModel.Cliente.TMClienteVenda;
import TableModel.Produto.TMCarrinhoVenda;
import TableModel.Produto.TMComercialVenda;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class PanelVendaProduto extends JPanel implements
		ActionListener {

	// TODO - verificar os tratamentos de exceções, inserssão de numeros e
	// valores não preenchidos

	// valor total para ser controlado e exibido
	private JTextField txtValortotal;
	private float valorTotalVenda;

	// tabelas
	private JTable tableProdutosCadastrados;
	private JTable tableListaVenda;

	// botões
	private JButton btnRetirar;
	private JButton btnAlterar;
	private JButton btnCancelar;
	private JButton btnFinalizar;
	private JButton btnInserir;
	private JButton btnConcluir;
	private JButton btnVoltar;

	// banco de dados dos produtos
	private DAO banco = new DAO();

	// lista de venda
	private List<Produto> listaCarrinhoVenda = new ArrayList<Produto>();

	// model para exibição das tabelas
	private TMComercialVenda modelListaEstoque = new TMComercialVenda();
	private TMCarrinhoVenda modelCarrinhoVenda = new TMCarrinhoVenda();
	private TMClienteVenda modelVendaCliente = new TMClienteVenda();

	//
	Venda venda = new Venda();
	private JTextField txtDescricao;
	private JTable tableClientes;
	private JCheckBox seleciona;
	private JCheckBox chckbxRevenda;
	private float custo=0;

	/**
	 * Create the panel.
	 */
	public PanelVendaProduto() {
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

		tableProdutosCadastrados = new JTable(modelListaEstoque);
		

		// tabela com colunas fixasv
		tableProdutosCadastrados.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		tableProdutosCadastrados.getColumn("Descrição").setPreferredWidth(250);

		// seleciona apenas uma linha
		tableProdutosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(tableProdutosCadastrados);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(611, 45, 463, 172);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 463, 172);
		panel_2.add(scrollPane_1);

		tableListaVenda = new JTable(modelCarrinhoVenda);
		scrollPane_1.setViewportView(tableListaVenda);

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

		JLabel lblProdutosCadastrados = new JLabel("PRODUTOS CADASTRADOS");
		lblProdutosCadastrados.setForeground(Color.BLACK);
		lblProdutosCadastrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProdutosCadastrados.setBounds(10, 10, 345, 25);
		panel.add(lblProdutosCadastrados);

		JLabel lblListaDeVenda = new JLabel("LISTA DE VENDA");
		lblListaDeVenda.setForeground(Color.BLACK);
		lblListaDeVenda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListaDeVenda.setBounds(611, 10, 345, 25);
		panel.add(lblListaDeVenda);

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
		btnConcluir.setBounds(486, 192, 115, 25);
		panel.add(btnConcluir);

		JLabel lblListaDeClientes = new JLabel("LISTA DE CLIENTES");
		lblListaDeClientes.setForeground(Color.BLACK);
		lblListaDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListaDeClientes.setBounds(486, 228, 238, 25);
		panel.add(lblListaDeClientes);

		JLabel label_1 = new JLabel("Descri\u00E7\u00E3o");
		label_1.setBounds(486, 426, 94, 20);
		panel.add(label_1);

		txtDescricao = new JTextField();
		txtDescricao.setEnabled(false);
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(553, 426, 260, 20);
		panel.add(txtDescricao);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setEnabled(false);
		btnVoltar.setBounds(836, 424, 115, 25);
		panel.add(btnVoltar);

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setEnabled(false);
		btnFinalizar.setBounds(959, 424, 115, 25);
		panel.add(btnFinalizar);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(486, 253, 588, 159);
		panel.add(panel_3);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 588, 159);
		panel_3.add(scrollPane_2);

		tableClientes = new JTable(modelVendaCliente);
		tableClientes.setEnabled(false);
		scrollPane_2.setViewportView(tableClientes);

		seleciona = new JCheckBox("Registrar Cliente");
		seleciona.setEnabled(false);
		seleciona.setBounds(890, 224, 184, 23);
		panel.add(seleciona);

		seleciona.addActionListener(this);
		JLabel lblCadastroCliente = new JLabel("VENDA DE PRODUTO");
		lblCadastroCliente.setForeground(Color.WHITE);
		lblCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastroCliente.setBounds(10, 11, 345, 25);
		add(lblCadastroCliente);

		btnAlterar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnFinalizar.addActionListener(this);
		btnRetirar.addActionListener(this);
		btnInserir.addActionListener(this);
		btnVoltar.addActionListener(this);
		btnConcluir.addActionListener(this);

		atualizarTabela();
		atualizarTabelaCliente();

		txtDescricao.setText("VENDA À VISTA");

		chckbxRevenda = new JCheckBox("Revenda");
		chckbxRevenda.setEnabled(false);
		chckbxRevenda.setBounds(775, 224, 97, 23);
		panel.add(chckbxRevenda);

	}

	private void atualizarTabela() {
		modelListaEstoque.removeTudo();

		List<?> lista = banco.listarObjetos(Produto.class, "descricao");
		for (int i = 0; i < lista.size(); i++) {
			Produto produto = (Produto) lista.get(i);
			modelListaEstoque.addRow(produto);

		}
	}

	private void atualizarCarrinho() {
		modelCarrinhoVenda.removeTudo();

		List<Produto> lista = listaCarrinhoVenda;
		for (int i = 0; i < lista.size(); i++) {
			Produto produto = (Produto) lista.get(i);
			modelCarrinhoVenda.addRow(produto);

		}
	}

	private void atualizarTabelaCliente() {
		modelVendaCliente.removeTudo();

		List<?> lista = banco.listarObjetos(Cliente.class, "nome");

		for (int i = 0; i < lista.size(); i++) {
			Cliente cliente = (Cliente) lista.get(i);
			if (cliente.getId() != 1) {
				modelVendaCliente.addRow(cliente);
			}

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
			concluir();
			break;
		case "Voltar":
			voltar();
			break;
		case "Finalizar":
			finalizar();
			break;

		case "Registrar Cliente":
			if (seleciona.isSelected()) {
				tableClientes.setEnabled(true);
				txtDescricao.setEnabled(true);
				txtDescricao.setText("");
				chckbxRevenda.setEnabled(true);

			}
			if (!seleciona.isSelected()) {
				tableClientes.setEnabled(false);
				txtDescricao.setEnabled(false);
				txtDescricao.setText("VENDA À VISTAS");
				chckbxRevenda.setSelected(false);
				chckbxRevenda.setEnabled(false);
			}
			break;

		default:
			break;
		}

	}

	private void finalizar() {

		try {

			Cliente cliente = new Cliente();
			Venda venda = new Venda();
			venda.setData(new java.sql.Date(new java.util.Date().getTime()));
			venda.setValor(valorTotalVenda);
			venda.setCusto(custo);
			venda.setDescricao(txtDescricao.getText().toUpperCase());

			if (!seleciona.isSelected()) {
				venda.setCliente(1);
				cliente = (Cliente) banco.buscarPorId(Cliente.class, 1);
			} else {
				venda.setCliente(((Integer) tableClientes.getValueAt(
						tableClientes.getSelectedRow(), 0)));
				
				cliente = (Cliente) banco.buscarPorId(Cliente.class, venda.getCliente());
				if (chckbxRevenda.isSelected()) {
					venda.setDescricao(venda.getDescricao() + " REVENDA");
				}
			}
			venda.setEstado("PENDENCIA");

			float custo = 0;

			banco.salvarObjeto(venda);

			@SuppressWarnings("unchecked")
			List<Venda> a = (List<Venda>) banco
					.listarObjetos(Venda.class, "id");
			Integer ultimaPosicao = a.size();
			Integer idVenda = a.get(ultimaPosicao - 1).getId();
			for (int i = 0; i < listaCarrinhoVenda.size(); i++) {
				Item item = new Item();
				item.setIdMovimento(idVenda);
				item.setIdProd(listaCarrinhoVenda.get(i).getId());
				item.setCusto(listaCarrinhoVenda.get(i).getCusto());
				item.setQuantidade(listaCarrinhoVenda.get(i).getQuantidade());
				item.setPreco(listaCarrinhoVenda.get(i).getPreco());
				item.setMovimento("VENDA");

				custo = custo
						+ (listaCarrinhoVenda.get(i).getQuantidade() * listaCarrinhoVenda
								.get(i).getCusto());

				Produto prod = (Produto) banco.buscarPorId(Produto.class,
						item.getIdProd());
				prod.setQuantidade(prod.getQuantidade() - item.getQuantidade());
				banco.salvarOuAtualizarObjeto(prod);
				banco.salvarObjeto(item);

			}
			cliente.setDivida(cliente.getDivida() + valorTotalVenda);
			banco.salvarOuAtualizarObjeto(cliente);

			cancelar();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO FINALIZAR COMPRA- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}

	}

	private void voltar() {
		try {

			tableListaVenda.setEnabled(true);
			tableProdutosCadastrados.setEnabled(true);

			btnInserir.setEnabled(true);
			btnAlterar.setEnabled(true);
			btnCancelar.setEnabled(true);
			btnRetirar.setEnabled(true);
			btnConcluir.setEnabled(true);

			tableClientes.setEnabled(false);
			btnFinalizar.setEnabled(false);
			btnVoltar.setEnabled(false);
			chckbxRevenda.setEnabled(false);
			chckbxRevenda.setSelected(false);

			txtDescricao.setEnabled(false);
			seleciona.setSelected(false);
			seleciona.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO FINALIZAR COMPRA- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}

	}

	private void concluir() {
		try {
			tableListaVenda.setEnabled(false);
			tableProdutosCadastrados.setEnabled(false);
			btnInserir.setEnabled(false);
			btnAlterar.setEnabled(false);
			btnCancelar.setEnabled(false);
			btnRetirar.setEnabled(false);
			btnConcluir.setEnabled(false);
			btnFinalizar.setEnabled(true);
			btnVoltar.setEnabled(true);
			txtDescricao.setEnabled(false);
			seleciona.setEnabled(true);

			txtDescricao.setText("VENDA À VISTA");

			JOptionPane.showMessageDialog(null,
					"Selecione um Cliente para prosseguir!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO FINALIZAR COMPRA- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}
	}

	@SuppressWarnings("unused")
	private void recalculaProduto(Produto produto, Item item) {
		try {
			float quantidadeNova = produto.getQuantidade()
					+ item.getQuantidade();
			float custoTotalAntigo = produto.getCusto()
					* produto.getQuantidade();
			float custoTotalVenda = item.getCusto() + item.getQuantidade();

			float somaCustos = custoTotalAntigo + custoTotalVenda;

			float custoUnitarioNovo = somaCustos / quantidadeNova;

			produto.setQuantidade(quantidadeNova);
			produto.setCusto(custoUnitarioNovo);
			banco.salvarOuAtualizarObjeto(produto);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO FINALIZAR COMPRA- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}
	}

	private void cancelar() {
		try {
			// isso aqui não faz parte desse setor!
			voltar();
			listaCarrinhoVenda.clear();
			atualizarCarrinho();
			atualizaValorTotal();
			atualizarTabela();
			btnAlterar.setEnabled(false);
			btnCancelar.setEnabled(false);
			btnRetirar.setEnabled(false);
			btnFinalizar.setEnabled(false);
			btnVoltar.setEnabled(false);
			btnConcluir.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO FINALIZAR COMPRA- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}

	}

	private void alterar() {
		try {
			String descricao = (String) tableListaVenda.getValueAt(
					tableListaVenda.getSelectedRow(), 0);

			float quantidade = Float.parseFloat(JOptionPane.showInputDialog(
					"Quantidade: ").replace(',', '.'));

			for (int i = 0; i < listaCarrinhoVenda.size(); i++) {
				if (descricao.equals(listaCarrinhoVenda.get(i).getDescricao())) {
					listaCarrinhoVenda.get(i).setQuantidade(quantidade);
				}
			}
			atualizarCarrinho();
			atualizaValorTotal();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO FINALIZAR COMPRA- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}

	}

	private void retirar() {
		try {
			String descricao = (String) tableListaVenda.getValueAt(
					tableListaVenda.getSelectedRow(), 0);
			for (int i = 0; i < listaCarrinhoVenda.size(); i++) {
				if (descricao.equals(listaCarrinhoVenda.get(i).getDescricao())) {
					listaCarrinhoVenda.remove(i);
				}
			}
			atualizarCarrinho();
			atualizaValorTotal();
			Integer a = listaCarrinhoVenda.size();
			if (a == 0) {
				btnAlterar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnRetirar.setEnabled(false);
				btnFinalizar.setEnabled(false);
				btnVoltar.setEnabled(false);
				btnConcluir.setEnabled(false);
			}
			atualizaValorTotal();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO FINALIZAR COMPRA- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}
	}

	private void incluir() {
		try {

			Integer id = (Integer) tableProdutosCadastrados.getValueAt(
					tableProdutosCadastrados.getSelectedRow(), 0);
			Produto produto = (Produto) banco.buscarPorId(Produto.class, id);
			produto.setQuantidade(Float.parseFloat(JOptionPane.showInputDialog(
					"Quantidade: ").replace(',', '.')));
			for (int i = 0; i < listaCarrinhoVenda.size(); i++) {
				if (listaCarrinhoVenda.get(i).getId() == produto.getId()) {
					produto.setQuantidade(produto.getQuantidade()
							+ listaCarrinhoVenda.get(i).getQuantidade());
					listaCarrinhoVenda.remove(i);
				}
			}
			listaCarrinhoVenda.add(produto);
			atualizaValorTotal();
			atualizarCarrinho();
			btnAlterar.setEnabled(true);
			btnCancelar.setEnabled(true);
			btnRetirar.setEnabled(true);
			btnConcluir.setEnabled(true);
			atualizaValorTotal();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO FINALIZAR COMPRA- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}
	}

	private void atualizaValorTotal() {
		try {
			valorTotalVenda = 0;
			custo = 0;
			for (int i = 0; i < listaCarrinhoVenda.size(); i++) {
				valorTotalVenda = valorTotalVenda
						+ (listaCarrinhoVenda.get(i).getQuantidade() * listaCarrinhoVenda
								.get(i).getPreco());
				custo = custo+ (listaCarrinhoVenda.get(i).getQuantidade() * listaCarrinhoVenda
						.get(i).getCusto());
			}
			txtValortotal.setText(String.valueOf(valorTotalVenda));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO FINALIZAR COMPRA- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}

	}
}
