package Janela.Financeiro.Detalhamento;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import Bin.Compra;
import Bin.Fornecedor;
import Bin.Item;
import Bin.Pagamento;
import Bin.Produto;
import Persistence.DAO;
import TableModel.Conta.TMPagamento;
import TableModel.Produto.TMCarrinhoCompra;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JCompra extends JDialog implements
		ActionListener {


	int alterar = 0;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtDescricao;
	private JTextField txtCusto;
	private JTextField txtFornecedor;
	private JTextField txtData;
	private JTable tabelaProduto;
	
	DecimalFormat df = new DecimalFormat("0.00");
    SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy" );
    
    Compra compraReferenciada;


	private DAO banco = new DAO();

	// model para exibições
	private TMPagamento modelPagamento = new TMPagamento();
	TMCarrinhoCompra model = new TMCarrinhoCompra();

	private JButton btnAlterar;

	private JTable tablePagamento;

	/**
	 * Create the dialog.
	 */
	
	
	public JCompra(Compra compraReferenciada) {
		setTitle("Detalhamento da Compra");

		identificaCompraOriginal(compraReferenciada);
		// this.compra = compraa;
		
		this.compraReferenciada = compraReferenciada;

		setBounds(100, 100, 652, 494);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		setModal(true);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 102, 616, 159);
		contentPanel.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 616, 159);
		panel.add(scrollPane);

		tabelaProduto = new JTable(model);

		// tabela com colunas fixasv
		tabelaProduto.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		// tabelaProduto.getColumn("Fornecedor").setPreferredWidth(220);
		tabelaProduto.getColumn("Descrição").setPreferredWidth(220);

		// seleciona apenas uma linha
		tabelaProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tabelaProduto.setEnabled(false);
		scrollPane.setViewportView(tabelaProduto);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 10, 46, 20);
		contentPanel.add(lblCdigo);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 40, 66, 20);
		contentPanel.add(lblDescrio);

		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setBounds(322, 40, 97, 20);
		contentPanel.add(lblFornecedor);

		JLabel lblNewLabel = new JLabel("Total da compra");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(367, 71, 130, 20);
		contentPanel.add(lblNewLabel);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(432, 10, 46, 20);
		contentPanel.add(lblData);

		txtId = new JTextField(String.valueOf(compraReferenciada.getId()));
		txtId.setEnabled(false);
		txtId.setBounds(76, 10, 102, 20);
		contentPanel.add(txtId);
		txtId.setColumns(10);

		txtDescricao = new JTextField(compraReferenciada.getDescricao());
		txtDescricao.setEnabled(false);
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(76, 40, 218, 20);
		contentPanel.add(txtDescricao);

		txtCusto = new JTextField(String.valueOf(df.format(compraReferenciada.getCusto())));
		txtCusto.setHorizontalAlignment(SwingConstants.CENTER);
		txtCusto.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtCusto.setEnabled(false);
		txtCusto.setColumns(10);
		txtCusto.setBounds(507, 66, 119, 30);
		contentPanel.add(txtCusto);

		Fornecedor fornecedor = (Fornecedor) banco.buscarPorId(
				Fornecedor.class, compraReferenciada.getFornecedor());
		txtFornecedor = new JTextField(fornecedor.getNome());
		txtFornecedor.setEnabled(false);
		txtFornecedor.setColumns(10);
		txtFornecedor.setBounds(402, 40, 224, 20);
		contentPanel.add(txtFornecedor);

		txtData = new JTextField(String.valueOf(dt.format(compraReferenciada.getData())));
		txtData.setEnabled(false);
		txtData.setColumns(10);
		txtData.setBounds(503, 10, 123, 20);
		contentPanel.add(txtData);

		JButton btnSair = new JButton("Sair");

		btnSair.setBounds(537, 432, 89, 23);
		contentPanel.add(btnSair);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 280, 616, 144);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 616, 144);
		panel_1.add(scrollPane_1);

		tablePagamento = new JTable(modelPagamento);

		// tabela com colunas fixasv
		tablePagamento.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		
		tablePagamento.getColumn("Descrição").setPreferredWidth(220);
		//tablePagamento.getColumn("Fornecedor").setPreferredWidth(220);

		// seleciona apenas uma linha
		tablePagamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tablePagamento.setEnabled(false);
		scrollPane_1.setViewportView(tablePagamento);

		JLabel lblListaDePagamentos = new JLabel("Lista de pagamentos");
		lblListaDePagamentos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaDePagamentos.setBounds(10, 261, 281, 19);
		contentPanel.add(lblListaDePagamentos);

		JLabel lblListaProdutos = new JLabel("Lista de produtos");
		lblListaProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaProdutos.setBounds(10, 83, 281, 19);
		contentPanel.add(lblListaProdutos);

		btnAlterar = new JButton("Alterar");

		btnAlterar.setBounds(432, 432, 89, 23);
		contentPanel.add(btnAlterar);

		preencheTabela();
		btnSair.addActionListener(this);
		btnAlterar.addActionListener(this);

	}

	private void identificaCompraOriginal(Compra compraParametro) {

		List<?> listaCompra = banco.listarObjetos(Pagamento.class, "id");
		Pagamento pagamentoBanco;
		for (int i = 0; i < listaCompra.size(); i++) {
			pagamentoBanco = (Pagamento) listaCompra.get(i);
			if ((pagamentoBanco.getIdMovimento() ==compraParametro.getId())) {
				modelPagamento.addRow(pagamentoBanco);
			}
		}

	}

	private void preencheTabela() {
		model.removeTudo();

		banco = new DAO();
		List<?> lista = banco.listarObjetos(Item.class, "id");

		for (int i = 0; i < lista.size(); i++) {
			Item comp = (Item) lista.get(i);

			if (comp.getIdMovimento().equals(compraReferenciada.getId())
					&& comp.getMovimento().equals("COMPRA")) {
				Produto prod = (Produto) banco.buscarPorId(Produto.class,
						comp.getIdProd());

				prod.setCusto(comp.getCusto());
				prod.setQuantidade(comp.getQuantidade());

				model.addRow(prod);
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "Salvar":

			txtDescricao.setEnabled(false);
			compraReferenciada.setDescricao(txtDescricao.getText().toUpperCase());
			banco.salvarOuAtualizarObjeto(compraReferenciada);
			btnAlterar.setText("Alterar");

			break;
		case "Alterar":
			txtDescricao.setEnabled(true);
			btnAlterar.setText("Salvar");

			break;
		case "Sair":
			dispose();
			break;

		default:
			break;
		}

	}
}
