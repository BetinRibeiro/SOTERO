package ViewMaterial;

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

import Bin.Compra;
import Bin.Fornecedor;
import Bin.Produto;
import Bin.Item;
import Persistence.Banco;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

import modelTabela.ModelFornecedorComercialCompra;
import modelTabela.ModelProdutosCarrinhoCompra;
import modelTabela.ModelProdutosCompraMaterial;

@SuppressWarnings("serial")
public class PainelMaterialSecundarioCompraProduto extends JPanel implements
		ActionListener {

	// TODO - verificar os tratamentos de exceções, inserssão de numeros e
	// valores não preenchidos

	// valor total para ser controlado e exibido
	private JTextField txtValortotal;
	private float valorTotalCompra;

	// tabelas
	private JTable tableProdutosCadastrados;
	private JTable tableListaCompra;

	// botões
	private JButton btnRetirar;
	private JButton btnAlterar;
	private JButton btnCancelar;
	private JButton btnFinalizar;
	private JButton btnInserir;
	private JButton btnConcluir;
	private JButton btnVoltar;

	// banco de dados dos produtos
	private Banco banco = new Banco();

	// lista de compra
	private List<Produto> listaCarrinhoCompra = new ArrayList<Produto>();

	// model para exibição das tabelas
	private ModelProdutosCompraMaterial modelListaEstoque = new ModelProdutosCompraMaterial();
	private ModelProdutosCarrinhoCompra modelCarrinhoCompra = new ModelProdutosCarrinhoCompra();
	private ModelFornecedorComercialCompra modelFornecedor = new ModelFornecedorComercialCompra();

	//
	Compra compra = new Compra();
	private JTextField txtDescricao;
	private JTable tableFornecedor;

	/**
	 * Create the panel.
	 */
	public PainelMaterialSecundarioCompraProduto() {
		setBackground(new Color(51, 51, 51));
		this.setBounds(10, 60, 1089, 508);
		this.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 47, 1089, 461);
		add(panel);
		panel.setLayout(null);

		JPanel panelProdutos = new JPanel();
		panelProdutos.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelProdutos.setBounds(5, 45, 471, 404);
		panel.add(panelProdutos);
		panelProdutos.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 471, 404);
		panelProdutos.add(scrollPane);

		tableProdutosCadastrados = new JTable(modelListaEstoque);

		// tabela com colunas fixasv
		tableProdutosCadastrados.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		tableProdutosCadastrados.getColumn("Descrição").setPreferredWidth(350);

		// seleciona apenas uma linha
		tableProdutosCadastrados
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(tableProdutosCadastrados);

		JPanel panelCarrinho = new JPanel();
		panelCarrinho.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCarrinho.setBounds(611, 45, 463, 172);
		panel.add(panelCarrinho);
		panelCarrinho.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 463, 172);
		panelCarrinho.add(scrollPane_1);

		tableListaCompra = new JTable(modelCarrinhoCompra);

		// tabela com colunas fixasv
		tableListaCompra.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		tableListaCompra.getColumn("Descrição").setPreferredWidth(250);

		// seleciona apenas uma linha
		tableListaCompra.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane_1.setViewportView(tableListaCompra);

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

		JLabel lblListaDeCompra = new JLabel("LISTA DE COMPRA");
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

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setEnabled(false);
		btnFinalizar.setBounds(959, 424, 115, 25);
		panel.add(btnFinalizar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setEnabled(false);
		btnVoltar.setBounds(836, 424, 115, 25);
		panel.add(btnVoltar);

		JPanel panelFornecedor = new JPanel();
		panelFornecedor.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFornecedor.setBounds(486, 254, 588, 159);
		panel.add(panelFornecedor);
		panelFornecedor.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 588, 159);
		panelFornecedor.add(scrollPane_2);

		tableFornecedor = new JTable(modelFornecedor);

		// tabela com colunas fixasv
		tableFornecedor.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		tableFornecedor.getColumn("Nome").setPreferredWidth(392);

		// seleciona apenas uma linha
		tableFornecedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane_2.setViewportView(tableFornecedor);

		tableFornecedor.setEnabled(false);

		btnConcluir = new JButton("Concluir");
		btnConcluir.setEnabled(false);
		btnConcluir.setBounds(486, 192, 115, 25);
		panel.add(btnConcluir);

		btnVoltar.setEnabled(false);

		JLabel lblDescruo = new JLabel("Descri\u00E7\u00E3o");
		lblDescruo.setBounds(486, 426, 94, 20);
		panel.add(lblDescruo);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(553, 426, 260, 20);
		panel.add(txtDescricao);
		txtDescricao.setColumns(10);
		txtDescricao.setEnabled(false);

		JLabel lblListaDeFornecedores = new JLabel("LISTA DE FORNECEDORES");
		lblListaDeFornecedores.setForeground(Color.BLACK);
		lblListaDeFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListaDeFornecedores.setBounds(486, 228, 345, 25);
		panel.add(lblListaDeFornecedores);

		JLabel lblCadastroCliente = new JLabel("COMPRA DE PRODUTO");
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

		atualizarTabelaProdutos();
		atualizarTabelaFornecedor();

	}

	private void atualizarTabelaProdutos() {
		try {
			
		
		modelListaEstoque.removeTudo();
		List<?> lista = banco.listarObjetos(Produto.class, "descricao");
		for (int i = 0; i < lista.size(); i++) {
			
			Produto produto = (Produto) lista.get(i);
			modelListaEstoque.addRow(produto);

		}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO - " +e);
		}
	}

	private void atualizarCarrinho() {
		modelCarrinhoCompra.removeTudo();

		List<Produto> lista = listaCarrinhoCompra;
		for (int i = 0; i < lista.size(); i++) {
			Produto produto = (Produto) lista.get(i);
			modelCarrinhoCompra.addRow(produto);

		}
	}

	private void atualizarTabelaFornecedor() {
		modelFornecedor.removeTudo();

		List<?> lista = banco.listarObjetos(Fornecedor.class, "nome");
		;
		for (int i = 0; i < lista.size(); i++) {
			Fornecedor fornecedor = (Fornecedor) lista.get(i);
			modelFornecedor.addRow(fornecedor);

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

		default:
			break;
		}

	}

	private void finalizar() {
		try {
			Compra compra = new Compra();
			compra.setData(new java.sql.Date(new java.util.Date().getTime()));
			compra.setCusto(valorTotalCompra);
			compra.setDescricao(txtDescricao.getText().toUpperCase());
			compra.setFornecedor((Integer) tableFornecedor.getValueAt(
					tableFornecedor.getSelectedRow(), 0));
			JOptionPane.showMessageDialog(null, compra.getFornecedor());
			compra.setEstado("PENDENCIA");

			banco.salvarObjeto(compra);
			@SuppressWarnings("unchecked")
			List<Compra> a = (List<Compra>) banco.listarObjetos(Compra.class,
					"id");
			Integer ultimaPosicao = a.size();
			Integer IdCompra = a.get(ultimaPosicao - 1).getId();
			for (int i = 0; i < listaCarrinhoCompra.size(); i++) {
				Item item = new Item();
				item.setIdMovimento(IdCompra);
				item.setIdProd(listaCarrinhoCompra.get(i).getId());
				item.setCusto(listaCarrinhoCompra.get(i).getCusto());
				item.setQuantidade(listaCarrinhoCompra.get(i).getQuantidade());
				item.setPreco(listaCarrinhoCompra.get(i).getPreco());
				item.setMovimento("COMPRA");
				modificaCompraNoEstoque(item);
				banco.salvarObjeto(item);

			}
			Fornecedor fornecedor = (Fornecedor) banco.buscarPorId(Fornecedor.class, compra.getFornecedor());
			
			fornecedor.setDebito(fornecedor.getDebito()+compra.getCusto());
			JOptionPane.showMessageDialog(null, "Você deve "+fornecedor.getDebito()+" R$ ao fornecedor "+fornecedor.getNome());
			
			banco.salvarOuAtualizarObjeto(fornecedor);
			JOptionPane
					.showMessageDialog(null, "Compra efetuada com sucesso!!");
			cancelar();

			
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "ERRO - " + e
					+ ". (Selecione o fornecedor antes de finalizar a compra).");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO FINALIZAR COMPRA- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}
	}

	private void modificaCompraNoEstoque(Item item) {
		try {
			Produto prod = (Produto) banco.buscarPorId(Produto.class,
					item.getIdProd());
			float quantidadeNova = (prod.getQuantidade())
					+ (item.getQuantidade());
			float custoTotalCompra = item.getQuantidade() * item.getCusto();
			float custoTotalEstoque = prod.getQuantidade() * prod.getCusto();
			float custoTotalGeral = custoTotalCompra + custoTotalEstoque;
			float custoUnitarioNovo = custoTotalGeral / quantidadeNova;

			prod.setPreco(item.getPreco());

			prod.setQuantidade(quantidadeNova);
			prod.setCusto(custoUnitarioNovo);

			banco.salvarOuAtualizarObjeto(prod);
			JOptionPane.showMessageDialog(null, "Item salvo no banco");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO MODIFICAR COMPRA- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}

	}

	private void voltar() {
		try {
			tableListaCompra.setEnabled(true);
			tableProdutosCadastrados.setEnabled(true);

			btnInserir.setEnabled(true);
			btnAlterar.setEnabled(true);
			btnCancelar.setEnabled(true);
			btnRetirar.setEnabled(true);
			btnConcluir.setEnabled(true);

			tableFornecedor.setEnabled(false);
			btnFinalizar.setEnabled(false);
			btnVoltar.setEnabled(false);

			txtDescricao.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO VOLTAR- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}
	}

	private void concluir() {
		try {
			tableFornecedor.setEnabled(true);
			tableListaCompra.setEnabled(false);
			tableProdutosCadastrados.setEnabled(false);
			btnInserir.setEnabled(false);
			btnAlterar.setEnabled(false);
			btnCancelar.setEnabled(false);
			btnRetirar.setEnabled(false);
			btnConcluir.setEnabled(false);
			btnFinalizar.setEnabled(true);
			btnVoltar.setEnabled(true);
			txtDescricao.setEnabled(true);
			JOptionPane.showMessageDialog(null,
					"Selecione um Fornecedor para prosseguir!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO CONCLUIR- " + e
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
			float custoTotalCompra = item.getCusto() + item.getQuantidade();

			float somaCustos = custoTotalAntigo + custoTotalCompra;

			float custoUnitarioNovo = somaCustos / quantidadeNova;

			produto.setQuantidade(quantidadeNova);
			produto.setCusto(custoUnitarioNovo);
			banco.salvarOuAtualizarObjeto(produto);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO RECALCULAR NA COMPRA- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}
	}

	private void cancelar() {
		try {
			// isso aqui não faz parte desse setor!
			voltar();
			listaCarrinhoCompra.clear();
			atualizarCarrinho();
			atualizaValorTotal();
			atualizarTabelaProdutos();
			btnAlterar.setEnabled(false);
			btnCancelar.setEnabled(false);
			btnRetirar.setEnabled(false);
			btnFinalizar.setEnabled(false);
			btnVoltar.setEnabled(false);
			btnConcluir.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO CANCELAR- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}

	}

	private void alterar() {
		try {
			String descricao = (String) tableListaCompra.getValueAt(
					tableListaCompra.getSelectedRow(), 0);

			float quantidade = Float.parseFloat(JOptionPane.showInputDialog(
					"Quantidade: ").replace(',', '.'));

			float custo = Float.parseFloat(JOptionPane.showInputDialog(
					"Custo Unitario: ").replace(',', '.'));

			float preco;

			for (int i = 0; i < listaCarrinhoCompra.size(); i++) {
				preco = Float.parseFloat(JOptionPane.showInputDialog(
						"O preço é: " + listaCarrinhoCompra.get(i).getPreco()
								+ "R$, Atualize o preço: ").replace(',', '.'));
				if (descricao.equals(listaCarrinhoCompra.get(i).getDescricao())) {
					listaCarrinhoCompra.get(i).setQuantidade(quantidade);
					listaCarrinhoCompra.get(i).setCusto(custo);
					listaCarrinhoCompra.get(i).setPreco(preco);
				}
			}
			atualizarCarrinho();
			atualizaValorTotal();
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "ERRO - " + e
					+ ". (Selecione o produto do carrinho antes de alterar valores).");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO ALTERAR- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}

	}

	private void retirar() {
		try {

			String descricao = (String) tableListaCompra.getValueAt(
					tableListaCompra.getSelectedRow(), 0);
			for (int i = 0; i < listaCarrinhoCompra.size(); i++) {
				if (descricao.equals(listaCarrinhoCompra.get(i).getDescricao())) {
					listaCarrinhoCompra.remove(i);
				}
			}
			atualizarCarrinho();
			atualizaValorTotal();
			Integer a = listaCarrinhoCompra.size();
			if (a == 0) {
				btnAlterar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnRetirar.setEnabled(false);
				btnFinalizar.setEnabled(false);
				btnVoltar.setEnabled(false);
				btnConcluir.setEnabled(false);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "ERRO - " + e
					+ ". (Selecione o produto do carrinho antes de retirar da compra).");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO RETIRAR- " + e
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
			produto.setCusto(Float.parseFloat(JOptionPane.showInputDialog(
					"Custo Unitario: ").replace(',', '.')));
			produto.setPreco(Float.parseFloat(JOptionPane.showInputDialog(
					"O preço é: " + produto.getPreco()
							+ "R$, Atualize o preço: ").replace(',', '.')));
			for (int i = 0; i < listaCarrinhoCompra.size(); i++) {
				if (listaCarrinhoCompra.get(i).getId() == produto.getId()) {
					produto.setQuantidade(produto.getQuantidade()
							+ listaCarrinhoCompra.get(i).getQuantidade());
					listaCarrinhoCompra.remove(i);
				}
			}
			listaCarrinhoCompra.add(produto);
			atualizaValorTotal();
			atualizarCarrinho();
			btnAlterar.setEnabled(true);
			btnCancelar.setEnabled(true);
			btnRetirar.setEnabled(true);
			btnConcluir.setEnabled(true);

		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "ERRO - " + e
					+ ". (Selecione o produto da lista antes de incluir na compra).");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO INCLUIR- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}
	}

	private void atualizaValorTotal() {
		try{
		valorTotalCompra = 0;
		for (int i = 0; i < listaCarrinhoCompra.size(); i++) {
			valorTotalCompra = valorTotalCompra
					+ (listaCarrinhoCompra.get(i).getQuantidade() * listaCarrinhoCompra
							.get(i).getCusto());
		}
		txtValortotal.setText(String.valueOf(valorTotalCompra));
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "ERRO ATUALIZAR VALOR TOTAL- " + e
				+ ".(Informe o erro do sistema ao administrador) ");
	}

	}
}
