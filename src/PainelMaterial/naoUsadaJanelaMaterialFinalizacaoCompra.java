package PainelMaterial;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Bin.Fornecedor;
import Persistence.DAO;
import TableModel.Fornecedor.TMCompra;


@SuppressWarnings("serial")
public class naoUsadaJanelaMaterialFinalizacaoCompra extends JDialog implements ActionListener {
	
	//TODO - verificar os tratamentos de exceções, inserssão de numeros e valores não preenchidos

	private JPanel contentPane;
	private JTable tableFornecedores;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	TMCompra model = new TMCompra();
	private DAO banco  = new DAO();

	/**
	 * Create the frame.
	 */
	public naoUsadaJanelaMaterialFinalizacaoCompra() {
		setModal(true);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 623, 434);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null); 

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(1, 40, 615, 382);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panelFornecedor = new JPanel();
		panelFornecedor.setBounds(5, 30, 300, 300);
		panel.add(panelFornecedor);
		panelFornecedor.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFornecedor.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 300, 300);
		panelFornecedor.add(scrollPane);

		tableFornecedores = new JTable(model);
		scrollPane.setViewportView(tableFornecedores);

		JPanel panelFinalizacao = new JPanel();
		panelFinalizacao.setBounds(310, 30, 300, 300);
		panel.add(panelFinalizacao);
		panelFinalizacao.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFinalizacao.setLayout(null);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(193, 10, 97, 20);
		panelFinalizacao.add(textField);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setBounds(113, 11, 70, 20);
		panelFinalizacao.add(lblValor);

		JLabel lblQuantParcelas = new JLabel("Quant Parcelas");
		lblQuantParcelas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantParcelas.setBounds(86, 42, 97, 20);
		panelFinalizacao.add(lblQuantParcelas);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(193, 40, 97, 20);
		panelFinalizacao.add(textField_1);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescrio.setBounds(10, 42, 70, 20);
		panelFinalizacao.add(lblDescrio);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 70, 280, 57);
		panelFinalizacao.add(textField_2);

		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setForeground(Color.WHITE);
		btnSelecionar.setBackground(new Color(51, 102, 153));
		btnSelecionar.setBounds(5, 335, 115, 25);
		panel.add(btnSelecionar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setBackground(new Color(51, 102, 153));
		btnAlterar.setBounds(130, 335, 115, 25);
		panel.add(btnAlterar);

		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setForeground(Color.WHITE);
		btnConcluir.setBackground(new Color(51, 102, 153));
		btnConcluir.setBounds(495, 335, 115, 25);
		panel.add(btnConcluir);

		JButton btnArquivar = new JButton("Arquivar");
		btnArquivar.setForeground(Color.WHITE);
		btnArquivar.setBackground(new Color(51, 102, 153));
		btnArquivar.setBounds(370, 335, 115, 25);
		panel.add(btnArquivar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(51, 102, 153));
		btnCancelar.setBounds(250, 335, 115, 25);
		panel.add(btnCancelar);

		JLabel lblListaDeClientes = new JLabel("LISTA DE FUNCIONARIO");
		lblListaDeClientes.setForeground(new Color(0, 0, 0));
		lblListaDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListaDeClientes.setBounds(5, 0, 300, 32);
		panel.add(lblListaDeClientes);

		JLabel lblDetalhamente = new JLabel("DETALHAMENTE");
		lblDetalhamente.setForeground(Color.BLACK);
		lblDetalhamente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDetalhamente.setBounds(310, 0, 300, 32);
		panel.add(lblDetalhamente);

		JLabel lblFinalizaoDaCompra = new JLabel(
				"FINALIZA\u00C7\u00C3O DA COMPRA");
		lblFinalizaoDaCompra.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinalizaoDaCompra.setForeground(new Color(255, 255, 255));
		lblFinalizaoDaCompra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFinalizaoDaCompra.setBounds(0, 0, 615, 40);
		contentPane.add(lblFinalizaoDaCompra);

		btnAlterar.addActionListener(this);
		btnArquivar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnConcluir.addActionListener(this);
		btnSelecionar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String acao = e.getActionCommand();

		System.out.println("acao " + acao);
		switch (acao) {
		case "Selecionar":
			
			break;
		case "Alterar":

			break;
		case "Cancelar":
			dispose();

			break;
		case "Arquivar":

			break;
		case "Concluir":

			break;

		default:
			break;
		}
	}
	@SuppressWarnings("unused")
	private void atualizarTabela() {
		model.removeTudo();

		List<?> lista = banco  .listarObjetos(Fornecedor.class, "nome");
		System.out.println(lista.size());
		for (int i = 0; i < lista.size(); i++) {
			Fornecedor fornecedor = (Fornecedor) lista.get(i);
			model.addRow(fornecedor);

		}
	}
}

