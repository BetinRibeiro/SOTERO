package Janela.Financeiro.Detalhamento;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import Bin.Caixa;
import Bin.Cliente;
import Bin.Recebimento;
import Bin.Venda;
import Persistence.DAO;
import TableModel.Conta.TMRecebimento;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class JVendaClientes extends JDialog
		implements ActionListener {

	// TODO - formatar saida de data

	int alterar = 0;

	private final JPanel contentPanel = new JPanel();
	private JTable tabelaPagamentos;

	private DAO banco = new DAO();

	private JButton btnAdiar;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtLougr;
	private JTextField txtbairro;
	private JTextField txtCidadeUf;
	private JTextField txtCep;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtRg;
	private JTextField txtFone;
	private JTextField txtApelido;
	private JTextField txtDivida;
	private JTextField txtDinheiro;

	DecimalFormat df = new DecimalFormat("0.00");

	private TMRecebimento model = new TMRecebimento();

	private List<Venda> listaVendas = new ArrayList<Venda>();

	private Cliente clienteOriginal;

	private JButton btnDetalhe;

	private JButton btnQuitar;

	private JButton btnReceber;

	private JButton btnSair;

	/**
	 * Create the dialog.
	 */
	public JVendaClientes(Cliente cliente) {
		setTitle("Detalhamento das Vendas");

		clienteOriginal = cliente;

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

		JPanel panelCompras = new JPanel();
		panelCompras.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCompras.setBounds(10, 221, 616, 200);
		contentPanel.add(panelCompras);
		panelCompras.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 616, 200);
		panelCompras.add(scrollPane);

		tabelaPagamentos = new JTable(model);
		// tabela com colunas fixasv
		tabelaPagamentos.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
//		tabelaPagamentos.getColumn("Cliente").setPreferredWidth(220);
//		tabelaPagamentos.getColumn("Código").setPreferredWidth(70);
		tabelaPagamentos.getColumn("Descrição").setPreferredWidth(280);

		// seleciona apenas uma linha
		tabelaPagamentos
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(tabelaPagamentos);

		btnDetalhe = new JButton("Detalhe");

		btnDetalhe.setBounds(319, 432, 89, 23);
		contentPanel.add(btnDetalhe);

		btnAdiar = new JButton("Adiar");

		btnAdiar.setBounds(214, 432, 89, 23);
		contentPanel.add(btnAdiar);

		btnReceber = new JButton("Receber");
		btnReceber.setBounds(10, 432, 89, 23);
		contentPanel.add(btnReceber);

		btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(115, 432, 89, 23);
		contentPanel.add(btnQuitar);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 616, 169);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblCdigo_1 = new JLabel("C\u00F3digo");
		lblCdigo_1.setBounds(10, 10, 66, 20);
		panel.add(lblCdigo_1);

		txtId = new JTextField(String.valueOf(cliente.getId()));
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBounds(76, 10, 108, 20);
		panel.add(txtId);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 40, 66, 20);
		panel.add(lblNome);

		txtNome = new JTextField(String.valueOf(cliente.getNome()));
		txtNome.setEnabled(false);
		txtNome.setColumns(10);
		txtNome.setBounds(76, 40, 353, 20);
		panel.add(txtNome);

		JLabel lblLougradouro = new JLabel("lougradouro");
		lblLougradouro.setBounds(10, 70, 74, 20);
		panel.add(lblLougradouro);

		txtLougr = new JTextField(String.valueOf(cliente.getLougradouro()));
		txtLougr.setEnabled(false);
		txtLougr.setColumns(10);
		txtLougr.setBounds(86, 70, 298, 20);
		panel.add(txtLougr);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 100, 66, 20);
		panel.add(lblBairro);

		txtbairro = new JTextField(String.valueOf(cliente.getBairro()));
		txtbairro.setEnabled(false);
		txtbairro.setColumns(10);
		txtbairro.setBounds(76, 100, 218, 20);
		panel.add(txtbairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(340, 100, 66, 20);
		panel.add(lblCidade);

		txtCidadeUf = new JTextField(String.valueOf(cliente.getCidade()));
		txtCidadeUf.setEnabled(false);
		txtCidadeUf.setColumns(10);
		txtCidadeUf.setBounds(405, 100, 201, 20);
		panel.add(txtCidadeUf);

		JLabel lblCep = new JLabel("Cep");
		lblCep.setBounds(405, 70, 46, 20);
		panel.add(lblCep);

		txtCep = new JTextField(String.valueOf(cliente.getCep()));
		txtCep.setEnabled(false);
		txtCep.setColumns(10);
		txtCep.setBounds(461, 70, 145, 20);
		panel.add(txtCep);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(439, 40, 46, 20);
		panel.add(lblCpf);

		txtCpf = new JTextField(String.valueOf(cliente.getCpf()));
		txtCpf.setEnabled(false);
		txtCpf.setColumns(10);
		txtCpf.setBounds(476, 40, 130, 20);
		panel.add(txtCpf);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 130, 66, 20);
		panel.add(lblEmail);

		txtEmail = new JTextField(String.valueOf(cliente.getEmail()));
		txtEmail.setEnabled(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(75, 130, 331, 20);
		panel.add(txtEmail);

		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(431, 130, 35, 20);
		panel.add(lblRg);

		txtRg = new JTextField(String.valueOf(cliente.getRg()));
		txtRg.setEnabled(false);
		txtRg.setColumns(10);
		txtRg.setBounds(476, 130, 130, 20);
		panel.add(txtRg);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(414, 10, 66, 20);
		panel.add(lblTelefone);

		txtFone = new JTextField(String.valueOf(cliente.getTelefone()));
		txtFone.setEnabled(false);
		txtFone.setColumns(10);
		txtFone.setBounds(470, 10, 136, 20);
		panel.add(txtFone);

		JLabel lblApelido = new JLabel("Apelido");
		lblApelido.setBounds(194, 10, 74, 20);
		panel.add(lblApelido);

		txtApelido = new JTextField(String.valueOf(cliente.getApelido()));
		txtApelido.setEnabled(false);
		txtApelido.setColumns(10);
		txtApelido.setBounds(260, 10, 144, 20);
		panel.add(txtApelido);

		JLabel lblDivida = new JLabel("Divida");
		lblDivida.setBounds(438, 190, 46, 20);
		contentPanel.add(lblDivida);

		txtDivida = new JTextField(
				String.valueOf(df.format(cliente.getDivida())));
		txtDivida.setEnabled(false);
		txtDivida.setColumns(10);
		txtDivida.setBounds(496, 190, 130, 20);
		contentPanel.add(txtDivida);

		JLabel lblDinheiro = new JLabel("Dinheiro");
		lblDinheiro.setBounds(214, 190, 72, 20);
		contentPanel.add(lblDinheiro);

		txtDinheiro = new JTextField(String.valueOf(df.format(cliente
				.getRecebimento())));
		txtDinheiro.setEnabled(false);
		txtDinheiro.setColumns(10);
		txtDinheiro.setBounds(298, 190, 130, 20);
		contentPanel.add(txtDinheiro);

		JLabel lblListaDeVendas = new JLabel("Lista de Vendas");
		lblListaDeVendas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaDeVendas.setBounds(10, 185, 142, 25);
		contentPanel.add(lblListaDeVendas);

		btnSair = new JButton("Sair");
		btnSair.setBounds(418, 432, 89, 23);
		contentPanel.add(btnSair);

		btnDetalhe.addActionListener(this);
		btnAdiar.addActionListener(this);
		btnQuitar.addActionListener(this);
		btnReceber.addActionListener(this);
		btnSair.addActionListener(this);

		listaVendasClienteAtual();

		atualizaTabela();

	}

	private void listaVendasClienteAtual() {
		listaVendas.clear();
		List<?> listaVendasBanco = banco.listarObjetos(Venda.class, "data");
		for (int i = 0; i < listaVendasBanco.size(); i++) {
			Venda venda = (Venda) listaVendasBanco.get(i);
			if (venda.getCliente().equals(clienteOriginal.getId())) {
				listaVendas.add(venda);

			}
		}

	}

	private void atualizaTabela() {

		// remove tudo do model que controla a exibição da tabela
		model.removeTudo();

		List<?> lista = banco.listarObjetos(Recebimento.class, "data");
		for (int i = 0; i < lista.size(); i++) {
			Recebimento recebimento = (Recebimento) lista.get(i);
			if (!recebimento.isRecebido()) {

				for (int j = 0; j < listaVendas.size(); j++) {
					if (recebimento.getIdMovimento().equals(
							listaVendas.get(j).getId())) {
						model.addRow(recebimento);
					}
				}
			}

		}
		invalidate();
		validate();
		repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		System.out.println("fgt " + acao);
		switch (acao) {
		case "Detalhe":
			detalhe();

			break;
		case "Adiar":
			adiar();
			break;
		case "Sair":
			dispose();
			break;
		case "Receber":
			receber();
			break;

		case "Quitar":
			quitar();
			break;

		default:
			break;
		}

	}

	private void quitar() {
		try {

			Integer idRecebimento = (Integer) tabelaPagamentos.getValueAt(
					tabelaPagamentos.getSelectedRow(), 0);

			Recebimento recebimento = (Recebimento) banco.buscarPorId(
					Recebimento.class, idRecebimento);
			if ((recebimento.getValor()+0.99) <= clienteOriginal.getRecebimento()) {

				recebimento.setRecebido(true);

				@SuppressWarnings("unchecked")
				List<Caixa> a = (List<Caixa>) banco.listarObjetos(Caixa.class,
						"id");
				Integer ultimaPosicao = a.size();
				Integer IdCaixa = a.get(ultimaPosicao - 1).getId();

				Caixa cx = (Caixa) banco.buscarPorId(Caixa.class, IdCaixa);

				float valorAntigo = cx.getValor();

				float valorAntigoMaisRecebimento = valorAntigo
						+ recebimento.getValor();

				Caixa newCx = new Caixa();
				newCx.setIdMovimento(recebimento.getIdMovimento());
				newCx.setTipo("RECEBIMENTO CÓDIGO - " + recebimento.getId());
				newCx.setValor(valorAntigoMaisRecebimento);
				if (recebimento.getClassificacao().toLowerCase()
						.contains("VENDA".toLowerCase())) {

					Cliente cliente = (Cliente) banco.buscarPorId(
							Cliente.class, Integer.valueOf(txtId.getText()));

					cliente.setRecebimento(cliente.getRecebimento()
							- cliente.getDivida());

					cliente.setDivida(cliente.getDivida()
							- recebimento.getValor());
					banco.salvarOuAtualizarObjeto(cliente);

					banco.salvarObjeto(newCx);

					banco.salvarOuAtualizarObjeto(recebimento);
					this.setVisible(false);
					atualizaTabela();
					JOptionPane.showMessageDialog(null,
							"Conta quitada com sucesso!");
					this.setVisible(true);
				}

			}
			if (recebimento.getValor() > clienteOriginal.getRecebimento()) {
				this.setVisible(false);
				atualizaTabela();
				JOptionPane
						.showMessageDialog(null,
								"Voce não recebeu dinheiro suficiente para pagar essa divida!");
				this.setVisible(true);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			this.setVisible(false);
			JOptionPane.showMessageDialog(null,
					"Selecione uma venda para poder quitar!");
			this.setVisible(true);
		}

	}

	private void receber() {
		try {
			this.setVisible(false);
			float valorRecebido = Float.valueOf(JOptionPane.showInputDialog(
					"Valor recebido de " + clienteOriginal.getNome()).replace(
					",", "."));

			Integer idCliente = Integer.valueOf(txtId.getText());

			Cliente cliente = (Cliente) banco.buscarPorId(Cliente.class,
					idCliente);

			cliente.setRecebimento(cliente.getRecebimento() + valorRecebido);

			banco.salvarOuAtualizarObjeto(cliente);

			txtDinheiro.setText(String.valueOf(cliente.getRecebimento()));

			atualizaTabela();
			JOptionPane.showMessageDialog(null, "Valor recebido com sucesso!!");
			this.setVisible(true);
		} catch (NumberFormatException e) {
			this.setVisible(false);
			JOptionPane.showMessageDialog(null, "Digite um valor válido!");
			this.setVisible(true);
		}

	}

	private void adiar() {
		try {
			Integer idRecebimento = (Integer) tabelaPagamentos.getValueAt(
					tabelaPagamentos.getSelectedRow(), 0);

			Recebimento recebimento = (Recebimento) banco.buscarPorId(
					Recebimento.class, idRecebimento);

			// Venda venda = (Venda) banco.buscarPorId(Venda.class,
			// recebimento.getIdMovimento());

			JData dg = new JData(
					recebimento);

			setVisible(false);
			dg.setVisible(true);

			setVisible(true);

			atualizaTabela();
			atualizaTabela();
		} catch (ArrayIndexOutOfBoundsException e) {
			this.setVisible(false);
			JOptionPane.showMessageDialog(null,
					"Selecione uma venda para poder adiar!");
			this.setVisible(true);
		}
	}

	private void detalhe() {

		try {
			Integer idRecebimento = (Integer) tabelaPagamentos.getValueAt(
					tabelaPagamentos.getSelectedRow(), 0);

			Recebimento recebimento = (Recebimento) banco.buscarPorId(
					Recebimento.class, idRecebimento);

			this.dispose();

			Venda venda = (Venda) banco.buscarPorId(Venda.class,
					recebimento.getIdMovimento());
			JVendaClienteVerVenda dt = new JVendaClienteVerVenda(
					venda);
			dt.setVisible(true);

			atualizaTabela();
		} catch (ArrayIndexOutOfBoundsException e) {
			this.setVisible(false);
			JOptionPane.showMessageDialog(null,
					"Selecione uma venda para poder ver dos detalhes!");
			this.setVisible(true);
		}

	}

}
