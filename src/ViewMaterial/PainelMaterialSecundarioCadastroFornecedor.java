package ViewMaterial;

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

import modelTabela.ModelFornecedorCadastro;
import Bin.Fornecedor;
import Persistence.Banco;

@SuppressWarnings("serial")
public class PainelMaterialSecundarioCadastroFornecedor extends JPanel
		implements ActionListener {

	// TODO - verificar os tratamentos de exceções, inserssão de numeros e
	// valores não preenchidos

	Banco dao = new Banco();

	// boyões utilizados
	private JButton btnAlterar;
	private JButton btnDeletar;
	private JButton btnSalvar;
	private JButton btnCriar;

	private JComboBox<String> boxUF;

	// caixas de texto utilizadas
	private JTextField txtNome;
	private JTextField txtCodigo;
	private JTextField txtCNPJ;
	private JTextField txtEscEst;
	private JTextField txtLougradouro;
	private JTextField txtCEP;
	private JTextField txtBairro;
	private JTable table;

	private ModelFornecedorCadastro model = new ModelFornecedorCadastro();
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtContato;
	private JPanel panel_1;

	/**
	 * Create the panel.
	 */
	public PainelMaterialSecundarioCadastroFornecedor() {
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

		JLabel lblCusto = new JLabel("CNPJ");
		lblCusto.setBounds(135, 91, 70, 20);
		panel.add(lblCusto);

		JLabel lblLocalizao = new JLabel("Escri\u00E7\u00E3o Estadual");
		lblLocalizao.setBounds(345, 91, 197, 20);
		panel.add(lblLocalizao);

		JLabel lblPreo = new JLabel("Lougradouro");
		lblPreo.setBounds(135, 131, 146, 20);
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

		txtCNPJ = new JTextField();
		txtCNPJ.setText("98754300013");
		txtCNPJ.setColumns(10);
		txtCNPJ.setBounds(135, 111, 197, 20);
		panel.add(txtCNPJ);

		txtEscEst = new JTextField();
		txtEscEst.setText("98767845");
		txtEscEst.setColumns(10);
		txtEscEst.setBounds(345, 111, 197, 20);
		panel.add(txtEscEst);

		txtLougradouro = new JTextField();
		txtLougradouro.setText("RUA X");
		txtLougradouro.setColumns(10);
		txtLougradouro.setBounds(135, 151, 407, 20);
		panel.add(txtLougradouro);

		txtCEP = new JTextField();
		txtCEP.setText("63050300");
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

		// TODO - Aqui geralmente é o que dá erro quando entramos no designer do
		// windowBuilder
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
		txtTelefone.setText("88 6784 0987");
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

		JLabel lblContato = new JLabel("Contato");
		lblContato.setBounds(552, 51, 146, 20);
		panel.add(lblContato);

		txtContato = new JTextField();
		txtContato.setColumns(10);
		txtContato.setBounds(552, 71, 197, 20);
		panel.add(txtContato);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 115, 163);
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

		JLabel lblCadastroFornecedor = new JLabel("CADASTRO  - FORNECEDOR");
		lblCadastroFornecedor.setForeground(Color.WHITE);
		lblCadastroFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastroFornecedor.setBounds(10, 11, 345, 25);
		add(lblCadastroFornecedor);

		boxUF.getModel().setSelectedItem("CE");

		atualizaTabela();
	}

	private void atualizaTabela() {
		model.removeTudo();

		List<?> lista = dao.listarObjetos(Fornecedor.class, "nome");
		for (int i = 0; i < lista.size(); i++) {
			Fornecedor fornecedor = (Fornecedor) lista.get(i);
			model.addRow(fornecedor);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();


		switch (acao) {
		case "Alterar":
			alterarFornecedor();
			break;
		case "Salvar":
			salvarFornecedor();
			break;
		case "Deletar":
			deletar();
			break;
		case "Criar":
			criarFornecedor();
			break;
		case "Cancelar":
			valoresPadrao();
			break;

		default:
			break;
		}

	}

	private void deletar() {
		try {
			Integer id = (Integer) table.getValueAt(table.getSelectedRow(), 0);
			String a = JOptionPane.showInputDialog("SENHA:");
			if (a.equals("123")) {

				Fornecedor fornecedor = (Fornecedor) dao.buscarPorId(
						Fornecedor.class, id);
				dao.deletarObjeto(fornecedor);
				atualizaTabela();
			} else {
				JOptionPane.showMessageDialog(null, "Senha incorreta!");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "ERRO - " + e
					+ ". (Selecione o fornecedor antes de delatar).");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO DELETAR- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}
	}

	private void salvarFornecedor() {
		try {

			Fornecedor fornecedor = (Fornecedor) dao.buscarPorId(Fornecedor.class, Integer.valueOf(txtCodigo.getText()));

			fornecedor.setId(Integer.valueOf(txtCodigo.getText()));
			fornecedor.setNome(txtNome.getText().toUpperCase());
			fornecedor.setCnpj(txtCNPJ.getText());
			fornecedor.setEscEst(txtEscEst.getText());
			fornecedor.setLougradouro(txtLougradouro.getText().toUpperCase());
			fornecedor.setBairro(txtBairro.getText().toUpperCase());
			fornecedor.setCep(txtCEP.getText());
			fornecedor.setCidade(txtCidade.getText().toUpperCase());
			fornecedor.setUf(String.valueOf(boxUF.getSelectedItem())
					.toUpperCase());
			fornecedor.setTelefone(txtTelefone.getText());
			fornecedor.setContato(txtContato.getText().toUpperCase());
			fornecedor.setEmail(txtEmail.getText().toLowerCase());

			dao.salvarOuAtualizarObjeto(fornecedor);

			valoresPadrao();
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "ERRO - " + e
					+ ". (Selecione o fornecedor antes de delatar).");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO SALVAR- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}
	}

	private void valoresPadrao() {

		txtCodigo.setText("");
		txtCNPJ.setText("98754300013");
		txtNome.setText("");
		txtCEP.setText("63050300");
		txtEscEst.setText("98767845");
		txtLougradouro.setText("RUA X");
		txtBairro.setText("CENTRO");
		txtContato.setText("");
		txtEmail.setText("...@GMAIL.COM");
		txtCidade.setText("JUAZEIRO DO NORTE");
		txtTelefone.setText("88 6784 0987");
		boxUF.getModel().setSelectedItem("CE");

		btnAlterar.setEnabled(true);
		btnCriar.setEnabled(true);
		btnDeletar.setEnabled(true);
		btnDeletar.setText("Deletar");
		btnSalvar.setEnabled(false);

		atualizaTabela();
		table.setEnabled(true);
	}

	private void alterarFornecedor() {
		try {

			Integer id = (Integer) table.getValueAt(table.getSelectedRow(), 0);
			Fornecedor fornecedor = (Fornecedor) dao.buscarPorId(
					Fornecedor.class, id);
			txtBairro.setText(fornecedor.getBairro().toUpperCase());
			txtCEP.setText(fornecedor.getCep());
			txtCidade.setText(fornecedor.getCidade().toUpperCase());
			txtCNPJ.setText(fornecedor.getCnpj());
			txtCodigo.setText(String.valueOf(fornecedor.getId()));
			txtContato.setText(fornecedor.getContato().toUpperCase());
			txtEmail.setText(fornecedor.getEmail().toLowerCase());
			txtEscEst.setText(fornecedor.getEscEst());
			txtLougradouro.setText(fornecedor.getLougradouro().toUpperCase());
			txtNome.setText(fornecedor.getNome().toUpperCase());
			txtTelefone.setText(fornecedor.getTelefone());

			boxUF.getModel().setSelectedItem(fornecedor.getUf());

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

	private void criarFornecedor() {
		try {

			Fornecedor fornecedor = new Fornecedor();

			fornecedor.setNome(txtNome.getText().toUpperCase());
			fornecedor.setCnpj(txtCNPJ.getText());
			fornecedor.setEscEst(txtEscEst.getText());
			fornecedor.setLougradouro(txtLougradouro.getText().toUpperCase());
			fornecedor.setBairro(txtBairro.getText().toUpperCase());
			fornecedor.setCep(txtCEP.getText());
			fornecedor.setCidade(txtCidade.getText().toUpperCase());
			fornecedor.setUf(String.valueOf(boxUF.getSelectedItem())
					.toUpperCase());
			fornecedor.setTelefone(txtTelefone.getText());
			fornecedor.setContato(txtContato.getText().toUpperCase());
			fornecedor.setEmail(txtEmail.getText().toLowerCase());

			dao.salvarObjeto(fornecedor);

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
