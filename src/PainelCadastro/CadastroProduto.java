package PainelCadastro;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.hibernate.engine.jndi.JndiException;

import Bin.Produto;
import Persistence.DAO;
import TableModel.Produto.TMCadastro;

@SuppressWarnings("serial")
public class CadastroProduto extends JPanel implements
		ActionListener {

	// TODO - verificar os tratamentos de exceções, inserssão de numeros e
	// valores não preenchidos

	DAO dao = new DAO();

	// boyões utilizados
	private JButton btnAlterar;
	private JButton btnDeletar;
	private JButton btnSalvar;
	private JButton btnCriar;

	private JComboBox<String> boxClassificacao;

	// caixas de texto utilizadas
	private JTextField txtDescricao;
	private JTextField txtCodigo;
	private JTextField txtlocal;
	private JTextField txtPreco;
	private JTextField txtEstMin;
	private JTable table;
	private JCheckBox chckbxHabilitar;

	private TMCadastro model = new TMCadastro();

	/**
	 * Create the panel.
	 */
	public CadastroProduto() {
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
		// tabela com colunas fixasv
		table.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		table.getColumn("Descrição").setPreferredWidth(550);
		table.getColumn("Classificação").setPreferredWidth(200);
		table.getColumn("Quantidade").setPreferredWidth(80);

		// seleciona apenas uma linha
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(table);

		JLabel label = new JLabel("Codigo");
		label.setBounds(135, 11, 70, 20);
		panel.add(label);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(135, 51, 70, 20);
		panel.add(lblDescrio);

		JLabel lblLocalizao = new JLabel("Localiza\u00E7\u00E3o");
		lblLocalizao.setBounds(345, 91, 70, 20);
		panel.add(lblLocalizao);

		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(135, 131, 70, 20);
		panel.add(lblPreo);

		JLabel lblEstoqueMinimo = new JLabel("Estoque Minimo");
		lblEstoqueMinimo.setBounds(345, 131, 146, 20);
		panel.add(lblEstoqueMinimo);

		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(135, 31, 197, 20);
		panel.add(txtCodigo);

		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(135, 71, 407, 20);
		panel.add(txtDescricao);

		txtlocal = new JTextField();
		txtlocal.setText("A");
		txtlocal.setColumns(10);
		txtlocal.setBounds(345, 111, 197, 20);
		panel.add(txtlocal);

		txtPreco = new JTextField();
		txtPreco.setText("0");
		txtPreco.setColumns(10);
		txtPreco.setBounds(135, 151, 197, 20);
		panel.add(txtPreco);

		txtEstMin = new JTextField();
		txtEstMin.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				String valor = txtEstMin.getText();
				valor = valor.replace(".", ",");
				txtEstMin.setText(valor);

			}
		});
		txtEstMin.setText("1");
		txtEstMin.setColumns(10);
		txtEstMin.setBounds(345, 151, 197, 20);
		panel.add(txtEstMin);

		JLabel txtClassificacao = new JLabel("Classificacao");
		txtClassificacao.setBounds(135, 91, 172, 20);
		panel.add(txtClassificacao);

		String[] lista = { "Hidraulico", "Eletrico", "Ferramenta", "Consumo",
				"Pintura", "Utencilho" };

		// TODO - Aqui geralmente é o que dá erro quando entramos no designer do
		// windowBuilder
		boxClassificacao = new JComboBox(lista);
		boxClassificacao.setBounds(135, 111, 197, 20);
		panel.add(boxClassificacao);

		chckbxHabilitar = new JCheckBox("Habilitar");
		chckbxHabilitar.setSelected(true);
		chckbxHabilitar.setBounds(345, 30, 97, 23);
		panel.add(chckbxHabilitar);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 115, 178);
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
		btnAlterar.addActionListener(this);

		JLabel lblCadastroProduto = new JLabel("CADASTRO  - PRODUTO");
		lblCadastroProduto.setForeground(Color.WHITE);
		lblCadastroProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastroProduto.setBounds(10, 11, 345, 25);
		add(lblCadastroProduto);

		atualizaTabela();
		valoresPadrao();

	}

	private void atualizaTabela() {
		try {
			model.removeTudo();
			List<?> lista = dao.listarObjetos(Produto.class, "descricao");
			for (int i = 0; i < lista.size(); i++) {
				Produto produto = (Produto) lista.get(i);
				model.addRow(produto);
			}
		} catch (JndiException e) {
			System.out.println("ERRO HIBERNATE -" + e);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();


		switch (acao) {
		case "Alterar":
			alterarProduto();
			break;
		case "Salvar":
			salvarProduto();
			break;
		case "Deletar":
			deletar();
			break;
		case "Criar":
			criarProduto();
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

				Produto produto = (Produto) dao.buscarPorId(Produto.class, id);
				dao.deletarObjeto(produto);
				atualizaTabela();
			} else {
				JOptionPane.showMessageDialog(null, "Senha incorreta!");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "ERRO - " + e
					+ ". (Selecione o produto antes de delatar).");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO DELETAR- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}
	}

	private void salvarProduto() {
		try {

			Produto p = (Produto) dao.buscarPorId(Produto.class,
					Integer.valueOf(txtCodigo.getText()));

			p.setId(Integer.parseInt(txtCodigo.getText()));

			p.setDescricao(txtDescricao.getText().toUpperCase());
			p.setLocalizacao(txtlocal.getText().toUpperCase());
			p.setEstoqueMin(Float.parseFloat(txtEstMin.getText().replaceAll(",", ".")));
			p.setPreco(Float.parseFloat(txtPreco.getText().replaceAll(",", ".")));
			p.setHabilitado(chckbxHabilitar.isSelected());
			dao.salvarOuAtualizarObjeto(p);

			valoresPadrao();
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "ERRO - " + e
					+ ". (Selecione o produto antes de delatar).");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO SALVAR- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}
	}

	private void alterarProduto() {
		try {

			Integer id = (Integer) table.getValueAt(table.getSelectedRow(), 0);
			Produto produto = (Produto) dao.buscarPorId(Produto.class, id);
			txtCodigo.setText(String.valueOf(produto.getId()));
			txtDescricao.setText(produto.getDescricao());
			txtEstMin.setText(String.valueOf(produto.getEstoqueMin()));
			txtlocal.setText(produto.getLocalizacao());
			txtPreco.setText(String.valueOf(produto.getPreco()));
			chckbxHabilitar.setSelected(produto.getHabilitado());
			boxClassificacao.getModel().setSelectedItem(
					produto.getClassificacao());

			valoresAlteracoes();
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "ERRO - " + e
					+ ". (Selecione o produto antes de Alterar).");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO ALTERAR- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}
	}

	private void criarProduto() {
		try {

			Produto p = new Produto();

			p.setDescricao(txtDescricao.getText().toUpperCase());
			p.setLocalizacao(txtlocal.getText().toUpperCase());
			p.setEstoqueMin(Float.parseFloat(txtEstMin.getText().replaceAll(",", ".")));
			p.setPreco(Float.parseFloat(txtPreco.getText().replaceAll(",", ".")));
			p.setHabilitado(chckbxHabilitar.isSelected());
			p.setClassificacao(String.valueOf(
					boxClassificacao.getSelectedItem()).toUpperCase());

			// só para alterar

			dao.salvarObjeto(p);

			valoresPadrao();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "ERRO - " + e
					+ ". (Insira numeros nos locais dos numeros).");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO CRIAR- " + e
					+ ".(Informe o erro do sistema ao administrador) ");
		}
	}

	public void valoresAlteracoes() {

		btnAlterar.setEnabled(false);
		btnCriar.setEnabled(false);
		btnDeletar.setEnabled(true);
		btnDeletar.setText("Cancelar");
		btnSalvar.setEnabled(true);

		table.setEnabled(false);

	}

	public void valoresPadrao() {
		txtCodigo.setText("");
		txtDescricao.setText(" - ");
		txtEstMin.setText("0.0");
		txtlocal.setText("A");
		txtPreco.setText("0.00");

		btnAlterar.setEnabled(true);
		btnCriar.setEnabled(true);
		btnDeletar.setEnabled(true);
		btnDeletar.setText("Deletar");
		btnSalvar.setEnabled(false);

		chckbxHabilitar.setSelected(true);
		atualizaTabela();
		table.setEnabled(true);
	}

}
