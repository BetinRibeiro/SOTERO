package Painel.Cadastro;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import Bin.Cliente;
import Persistence.DAO;
import TableModel.Cliente.TMCadastro;

@SuppressWarnings("serial")
public class JPanelCadastroCliente extends JPanel implements
		ActionListener {

	// TODO - verificar os tratamentos de exceções, inserssão de numeros e
	// valores não preenchidos

	DAO dao = new DAO();

	// boyões utilizados
	private JButton btnAlterar;
	private JButton btnDeletar;
	private JButton btnSalvar;
	private JButton btnCriar;

	private JComboBox<String> boxUF;

	// caixas de texto utilizadas
	private JTextField txtNome;
	private JTextField txtCodigo;
	private JTextField txtCPF;
	private JTextField txtRG;
	private JTextField txtLougradouro;
	private JTextField txtCEP;
	private JTextField txtBairro;
	private JTable table;

	private TMCadastro model = new TMCadastro();
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtApelido;
	private JPanel panel_1;

	/**
	 * Create the panel.
	 */
	public JPanelCadastroCliente() {
		setBackground(new Color(51, 51, 51));
		this.setBounds(10, 60, 1089, 508);
		this.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 47, 1089, 461);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 229, 1069, 223);
		panel.add(scrollPane);

		table = new JTable(model);
		// tabela com colunas fixas
		table.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		table.getColumn("Nome").setPreferredWidth(350);
		table.getColumn("Código").setPreferredWidth(30);
		table.getColumn("Email").setPreferredWidth(250);

		// seleciona apenas uma linha
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(table);

		JLabel label = new JLabel("Codigo");
		label.setBounds(135, 11, 70, 20);
		panel.add(label);

		JLabel lblDescrio = new JLabel("Nome");
		lblDescrio.setBounds(135, 51, 70, 20);
		panel.add(lblDescrio);

		JLabel lblCusto = new JLabel("CPF");
		lblCusto.setBounds(135, 91, 70, 20);
		panel.add(lblCusto);

		JLabel lblLocalizao = new JLabel("RG");
		lblLocalizao.setBounds(345, 91, 197, 20);
		panel.add(lblLocalizao);

		JLabel lblPreo = new JLabel("Lougradouro");
		lblPreo.setBounds(135, 131, 70, 20);
		panel.add(lblPreo);

		JLabel lblEstoqueMinimo = new JLabel("CEP");
		lblEstoqueMinimo.setBounds(345, 171, 146, 20);
		panel.add(lblEstoqueMinimo);

		JLabel lblQuantidade = new JLabel("Bairro");
		lblQuantidade.setBounds(135, 171, 70, 20);
		panel.add(lblQuantidade);

		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(135, 31, 197, 20);
		panel.add(txtCodigo);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(135, 71, 407, 20);
		panel.add(txtNome);

		txtCPF = new JTextField();
		txtCPF.setText("123.456.789.11");
		txtCPF.setColumns(10);
		txtCPF.setBounds(135, 111, 197, 20);
		panel.add(txtCPF);

		txtRG = new JTextField();
		txtRG.setText("20081465786");
		txtRG.setColumns(10);
		txtRG.setBounds(345, 111, 197, 20);
		panel.add(txtRG);

		txtLougradouro = new JTextField();
		txtLougradouro.setText("RUA XXXXXXXXXXXXXXXXX");
		txtLougradouro.setColumns(10);
		txtLougradouro.setBounds(135, 151, 407, 20);
		panel.add(txtLougradouro);

		txtCEP = new JTextField();
		txtCEP.setText("630.50.300");
		txtCEP.setColumns(10);
		txtCEP.setBounds(345, 191, 197, 20);
		panel.add(txtCEP);

		txtBairro = new JTextField();
		txtBairro.setText("CENTRO");
		txtBairro.setColumns(10);
		txtBairro.setBounds(135, 191, 197, 20);
		panel.add(txtBairro);

		JLabel txtClassificacao = new JLabel("UF");
		txtClassificacao.setBounds(10, 171, 81, 20);
		panel.add(txtClassificacao);

		String[] lista = { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES",
				"GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR",
				"RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" };

		boxUF = new JComboBox<String>(lista);
		boxUF.setBounds(10, 191, 115, 20);
		panel.add(boxUF);
		

		txtCidade = new JTextField();
		txtCidade.setText("JUAZEIRO DO NORTE");
		txtCidade.setColumns(10);
		txtCidade.setBounds(552, 151, 197, 20);
		panel.add(txtCidade);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(552, 131, 146, 20);
		panel.add(lblCidade);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(552, 171, 146, 20);
		panel.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setText("88 4563 7897");
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(552, 191, 197, 20);
		panel.add(txtTelefone);

		JLabel lblWmail = new JLabel("Email");
		lblWmail.setBounds(552, 91, 146, 20);
		panel.add(lblWmail);

		txtEmail = new JTextField();
		txtEmail.setText("...@GMAIL.COM");
		txtEmail.setColumns(10);
		txtEmail.setBounds(552, 111, 197, 20);
		panel.add(txtEmail);

		JLabel lblCon = new JLabel("Apelido");
		lblCon.setBounds(552, 51, 146, 20);
		panel.add(lblCon);

		txtApelido = new JTextField();
		txtApelido.setColumns(10);
		txtApelido.setBounds(552, 71, 197, 20);
		panel.add(txtApelido);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 115, 160);
		panel.add(panel_1);
		panel_1.setLayout(null);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(0, 17, 115, 25);
		panel_1.add(btnAlterar);

		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(0, 57, 115, 25);
		panel_1.add(btnDeletar);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(0, 97, 115, 25);
		panel_1.add(btnSalvar);
		btnSalvar.setEnabled(false);

		btnCriar = new JButton("Criar");
		btnCriar.setBounds(0, 136, 115, 25);
		panel_1.add(btnCriar);
		btnCriar.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnDeletar.addActionListener(this);

		// implementando actionpeformed
		btnAlterar.addActionListener(this);

		JLabel lblCadastroCliente = new JLabel("CADASTRO  - CLIENTE");
		lblCadastroCliente.setForeground(Color.WHITE);
		lblCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastroCliente.setBounds(10, 11, 345, 25);
		add(lblCadastroCliente);
		valoresPadrao();

		atualizaTabela();

	}

	private void atualizaTabela() {
		model.removeTudo();

		List<?> lista = dao.listarObjetos(Cliente.class, "nome");
		for (int i = 0; i < lista.size(); i++) {
			Cliente cliente = (Cliente) lista.get(i);
			if (cliente.getId() != 1) {
				model.addRow(cliente);
			}
			
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "Alterar":
			alterarCliente();
			break;
		case "Salvar":
			salvarCliente();
			break;
		case "Deletar":
			deletar();
			break;
		case "Criar":
			criarCliente();
			break;
		case "Cancelar":
			valoresPadrao();
			break;

		default:
			break;
		}

	}

	private void valoresPadrao() {
		txtBairro.setText("CENTRO");
		txtCEP.setText("63.050-300");
		txtCidade.setText("JUAZEIRO DO NORTE");
		txtCPF.setText("000.000.000-00");
		txtCodigo.setText("");
		txtApelido.setText("");
		txtEmail.setText("...@gmail.com");
		txtRG.setText("99999999999");
		txtLougradouro.setText("RUA ...");
		txtNome.setText("");
		txtTelefone.setText("88 8888 8888");

		boxUF.getModel().setSelectedItem("CE");
		
		btnAlterar.setEnabled(true);
		btnCriar.setEnabled(true);
		btnDeletar.setEnabled(true);
		btnDeletar.setText("Deletar");
		btnSalvar.setEnabled(false);

		
		atualizaTabela();
		table.setEnabled(true);

	}

	private void deletar() {
		try {
			Integer id = (Integer) table.getValueAt(table.getSelectedRow(), 0);
			String a = JOptionPane.showInputDialog("SENHA:");
			if (a.equals("123")) {

				Cliente cliente = (Cliente) dao.buscarPorId(Cliente.class, id);
				dao.deletarObjeto(cliente);
				atualizaTabela();
			} else {
				JOptionPane.showMessageDialog(null, "Senha incorreta!");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "ERRO - " + e
					+ ". (Selecione o cliente antes de delatar).");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO DELETAR- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}

	}

	private void salvarCliente() {
		try {

			Cliente cliente = (Cliente) dao.buscarPorId(Cliente.class, Integer.valueOf(txtCodigo.getText()));

			cliente.setId(Integer.valueOf(txtCodigo.getText()));
			cliente.setNome(txtNome.getText().toUpperCase());
			cliente.setCpf(txtCPF.getText());
			cliente.setRg(txtRG.getText());
			cliente.setLougradouro(txtLougradouro.getText().toUpperCase());
			cliente.setBairro(txtBairro.getText().toUpperCase());
			cliente.setCep(txtCEP.getText());
			cliente.setCidade(txtCidade.getText().toUpperCase());
			cliente.setUf(String.valueOf(boxUF.getSelectedItem()));
			cliente.setTelefone(txtTelefone.getText());
			cliente.setApelido(txtApelido.getText().toUpperCase());
			cliente.setEmail(txtEmail.getText().toLowerCase());

			dao.salvarOuAtualizarObjeto(cliente);

			valoresPadrao();
			
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "ERRO - " + e
					+ ". (Selecione o cliete antes de delatar).");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO SALVAR- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}

	}

	private void alterarCliente() {
		try {
		Integer id = (Integer) table.getValueAt(table.getSelectedRow(), 0);

		Cliente cliente = (Cliente) dao.buscarPorId(Cliente.class, id);

		txtBairro.setText(cliente.getBairro());
		txtCEP.setText(cliente.getCep());
		txtCidade.setText(cliente.getCidade());
		txtCPF.setText(cliente.getCpf());
		txtCodigo.setText(String.valueOf(cliente.getId()));
		txtApelido.setText(cliente.getApelido());
		txtEmail.setText(cliente.getEmail());
		txtRG.setText(cliente.getRg());
		txtLougradouro.setText(cliente.getLougradouro());
		txtNome.setText(cliente.getNome());
		txtTelefone.setText(cliente.getTelefone());

		boxUF.getModel().setSelectedItem(cliente.getUf());

		valoresAlteracoes();
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "ERRO - " + e
					+ ". (Insira numeros nos locais dos numeros).");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO ALTERAR- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}

	}

	private void valoresAlteracoes() {

		btnAlterar.setEnabled(false);
		btnCriar.setEnabled(false);
		btnDeletar.setEnabled(true);
		btnDeletar.setText("Cancelar");
		btnSalvar.setEnabled(true);

		table.setEnabled(false);
		
	}

	private void criarCliente() {
		try {

		Cliente cliente = new Cliente();

		cliente.setNome(txtNome.getText().toUpperCase());
		cliente.setCpf(txtCPF.getText());
		cliente.setRg(txtRG.getText());
		cliente.setLougradouro(txtLougradouro.getText().toUpperCase());
		cliente.setBairro(txtBairro.getText().toUpperCase());
		cliente.setCep(txtCEP.getText());
		cliente.setCidade(txtCidade.getText().toUpperCase());

		cliente.setUf(String.valueOf(boxUF.getSelectedItem()));
		cliente.setTelefone(txtTelefone.getText());
		cliente.setApelido(txtApelido.getText().toUpperCase());
		cliente.setEmail(txtEmail.getText().toLowerCase());
		cliente.setRecebimento(0);
		cliente.setDivida(0);

		dao.salvarObjeto(cliente);
		valoresPadrao();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "ERRO - " + e
					+ ". (Insira numeros nos locais dos numeros).");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO CRIAR- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}

	}


}
