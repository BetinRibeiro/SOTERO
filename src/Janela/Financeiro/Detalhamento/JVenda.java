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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import Bin.Cliente;
import Bin.Item;
import Bin.Produto;
import Bin.Venda;
import Persistence.DAO;
import TableModel.Financeiro.Conta.TMReceber;
import TableModel.Produto.TMCarrinhoVenda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class JVenda extends JDialog implements
		ActionListener {

	// TODO - formatar saida de data

	int alterar = 0;
	
	DecimalFormat df = new DecimalFormat("0.00");

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtDescricao;
	private JTextField txtCusto;
	private JTextField txtCliente;
	private JTextField txtData;
	private JTable tabelaProduto;
	SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy" );

	Venda vendaOriginal;

	private DAO banco = new DAO();

	// model para exibições
	private TMReceber modelVenda = new TMReceber();
	TMCarrinhoVenda model = new TMCarrinhoVenda();

	private JButton btnAlterar;

	private JButton btnPreo;
	private JTextField txtValorTotal;

	/**
	 * Create the dialog.
	 */
	public JVenda(Venda vendaReferenciada) {
		setTitle("Detalhamento da Venda");

		vendaOriginal = vendaReferenciada;
		// this.venda = vendaa;

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
		panel.setBounds(10, 100, 616, 140);
		contentPanel.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 616, 140);
		panel.add(scrollPane);

		tabelaProduto = new JTable(model);

		// tabela com colunas fixasv
		tabelaProduto.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		//tabelaProduto.getColumn("Cliente").setPreferredWidth(220);
		tabelaProduto.getColumn("Código").setPreferredWidth(70);
		tabelaProduto.getColumn("Descrição").setPreferredWidth(220);

		// seleciona apenas uma linha
		tabelaProduto
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		tabelaProduto.setEnabled(false);
		scrollPane.setViewportView(tabelaProduto);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 10, 46, 20);
		contentPanel.add(lblCdigo);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 40, 66, 20);
		contentPanel.add(lblDescrio);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(322, 40, 97, 20);
		contentPanel.add(lblCliente);

		JLabel lblNewLabel = new JLabel("Custo Total");
		lblNewLabel.setBounds(281, 71, 66, 20);
		contentPanel.add(lblNewLabel);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(432, 10, 46, 20);
		contentPanel.add(lblData);

		System.out
				.println("id venda referenciada " + vendaReferenciada.getId());

		System.out.println("id venda original " + vendaOriginal.getId());

		txtId = new JTextField(String.valueOf(vendaOriginal.getId()));
		txtId.setEnabled(false);
		txtId.setBounds(76, 10, 102, 20);
		contentPanel.add(txtId);
		txtId.setColumns(10);

		txtDescricao = new JTextField(vendaOriginal.getDescricao());
		txtDescricao.setEnabled(false);
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(76, 40, 218, 20);
		contentPanel.add(txtDescricao);

		txtCusto = new JTextField(String.valueOf(df.format(vendaOriginal.getCusto())));
		txtCusto.setEnabled(false);
		txtCusto.setColumns(10);
		txtCusto.setBounds(346, 71, 102, 20);
		contentPanel.add(txtCusto);

		Cliente cliente = (Cliente) banco.buscarPorId(Cliente.class,
				vendaOriginal.getCliente());
		txtCliente = new JTextField(cliente.getNome());
		txtCliente.setEnabled(false);
		txtCliente.setColumns(10);
		txtCliente.setBounds(402, 40, 224, 20);
		contentPanel.add(txtCliente);

		txtData = new JTextField(String.valueOf(dt.format(vendaOriginal.getData())));
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

		JTable table = new JTable(modelVenda);
		table.setEnabled(false);
		scrollPane_1.setViewportView(table);

		JLabel lblListaDePagamentos = new JLabel("Lista de pagamentos");
		lblListaDePagamentos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaDePagamentos.setBounds(10, 250, 281, 19);
		contentPanel.add(lblListaDePagamentos);

		JLabel lblListaProdutos = new JLabel("Lista de produtos");
		lblListaProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaProdutos.setBounds(10, 75, 281, 20);
		contentPanel.add(lblListaProdutos);

		btnAlterar = new JButton("Alterar");

		btnAlterar.setBounds(432, 432, 89, 23);
		contentPanel.add(btnAlterar);

		btnPreo = new JButton("Pre\u00E7o");
		btnPreo.setEnabled(false);
		btnPreo.setBounds(537, 250, 89, 23);
		contentPanel.add(btnPreo);

		JLabel lblValorTota = new JLabel("Valor Tota");
		lblValorTota.setBounds(458, 71, 67, 20);
		contentPanel.add(lblValorTota);

		txtValorTotal = new JTextField(String.valueOf(df.format(vendaOriginal.getValor())));
		txtValorTotal.setEnabled(false);
		txtValorTotal.setColumns(10);
		txtValorTotal.setBounds(524, 71, 102, 20);
		contentPanel.add(txtValorTotal);

		atualizaTabela();
		btnSair.addActionListener(this);
		btnAlterar.addActionListener(this);

		btnPreo.addActionListener(this);

	}

	private void atualizaTabela() {
		model.removeTudo();

		// para poder modificar a divida do cliente caso tenha alguma alteração!
		Cliente cliente = (Cliente) banco.buscarPorId(Cliente.class,
				vendaOriginal.getCliente());
		
		System.out.println(txtValorTotal.getText());
		float valorTotal = Float.parseFloat(txtValorTotal.getText().replaceAll(",", "."));
		cliente.setDivida(cliente.getDivida()
				- valorTotal);

		// auxiliar para poder modificar o valor total caso modifique o preço do
		// produto!!
		float totalVenda = 0;

		List<?> lista = banco.listarObjetos(Item.class, "id");

		for (int i = 0; i < lista.size(); i++) {
			Item comp = (Item) lista.get(i);

			if (comp.getIdMovimento().equals(vendaOriginal.getId())
					&& comp.getMovimento().equals("VENDA")) {
				Produto prod = (Produto) banco.buscarPorId(Produto.class,
						comp.getIdProd());

				prod.setId(comp.getId());
				// prod.setCusto(comp.getCusto());
				prod.setQuantidade(comp.getQuantidade());
				prod.setPreco(comp.getPreco());

				totalVenda = totalVenda
						+ (prod.getPreco() * prod.getQuantidade());

				model.addRow(prod);
			}
		}
		txtValorTotal.setText(String.valueOf(df.format(totalVenda)));
		cliente.setDivida(cliente.getDivida() + totalVenda);
		vendaOriginal.setValor(totalVenda);
		banco.salvarOuAtualizarObjeto(vendaOriginal);
		banco.salvarOuAtualizarObjeto(cliente);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "Salvar":
			
			txtDescricao.setEnabled(false);
			tabelaProduto.setEnabled(false);
			btnPreo.setEnabled(false);
			vendaOriginal.setDescricao(txtDescricao.getText().toUpperCase());
			banco.salvarOuAtualizarObjeto(vendaOriginal);
			btnAlterar.setText("Alterar");

			break;
		case "Alterar":
			txtDescricao.setEnabled(true);
			tabelaProduto.setEnabled(true);
			btnPreo.setEnabled(true);
			btnAlterar.setText("Salvar");

			break;
		case "Sair":
			dispose();
			break;
		case "Preço":
			alterarPreco();
			break;

		default:
			break;
		}

	}

	private void alterarPreco() {
		try {

			Integer codigo = (Integer) tabelaProduto.getValueAt(
					tabelaProduto.getSelectedRow(), 0);

			this.setVisible(false);
			float precoNovo = Float.parseFloat(JOptionPane
					.showInputDialog("Digite o preço novo: "));
			

			List<?> listaItem = banco.listarObjetos(Item.class, "id");

			for (int i = 0; i < listaItem.size(); i++) {
				Item item = (Item) listaItem.get(i);
				if (item.getId().equals(codigo)) {
					item.setPreco(precoNovo);
					atualizaTabela();
				}
				banco.salvarOuAtualizarObjeto(item);
				atualizaTabela();
				
			}
			this.setVisible(true);
		} catch (ArrayIndexOutOfBoundsException e) {
			this.setVisible(false);
			System.out.println("ERRO -" + e);
			JOptionPane
					.showMessageDialog(null,
							" Selecione uma produto para poder alterar o seu pagamento.");
			this.setVisible(true);
		} catch (Exception e) {
			this.setVisible(false);
			System.out.println("ERRO -" + e);
			JOptionPane.showMessageDialog(null, " ERRO - " + e
					+ ", entre em contato com o administrador do sistema");
			this.setVisible(true);
		}

	}
}
