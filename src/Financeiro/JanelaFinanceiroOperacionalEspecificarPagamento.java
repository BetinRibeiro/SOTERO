package Financeiro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Bin.Compra;
import Bin.Fornecedor;
import Bin.Pagamento;
import Persistence.Banco;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;

@SuppressWarnings("serial")
public class JanelaFinanceiroOperacionalEspecificarPagamento extends JDialog
		implements ActionListener {

	private final JPanel contentPanel = new JPanel();

	// variaveis que modificaresmo em toda a classe
	private JTextField txtValor;
	private JTextField txtFornecedor;
	private JTextField txtDescricao;
	private JTextField txtRestante;
	private JLabel lblNumeroPagamento;
	private JDateChooser jdc;

	Banco banco = new Banco();

	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	Compra compraOriginal = new Compra();
	List<Pagamento> listaPagamento = new ArrayList<Pagamento>();

	int numero = 1;

	private JButton btnCancelar;

	private JButton btnOk;

	private Pagamento pagamentoInserido;

	float valorQueFalta = 0;

	/**
	 * Create the dialog.
	 * 
	 * @param compra
	 */
	public JanelaFinanceiroOperacionalEspecificarPagamento(Compra compra) {
		setTitle("Especificando Pagamento");

		compraOriginal = compra;

		setBounds(100, 100, 390, 229);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		setModal(true);
		setResizable(false);
		setAlwaysOnTop(true);

		setLocationRelativeTo(null);

		lblNumeroPagamento = new JLabel("Numero do Pagamento");
		lblNumeroPagamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroPagamento.setBounds(10, 10, 148, 20);
		contentPanel.add(lblNumeroPagamento);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(46, 130, 46, 20);
		contentPanel.add(lblValor);

		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setBounds(20, 40, 72, 20);
		contentPanel.add(lblFornecedor);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(20, 70, 72, 20);
		contentPanel.add(lblDescrio);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(46, 99, 46, 20);
		contentPanel.add(lblData);

		txtValor = new JTextField();
		txtValor.setBounds(100, 130, 72, 20);
		contentPanel.add(txtValor);
		txtValor.setColumns(10);

		Fornecedor fornecedor = (Fornecedor) banco.buscarPorId(
				Fornecedor.class, compra.getFornecedor());

		txtFornecedor = new JTextField(fornecedor.getNome());
		txtFornecedor.setEnabled(false);
		txtFornecedor.setColumns(10);
		txtFornecedor.setBounds(100, 40, 270, 20);
		contentPanel.add(txtFornecedor);

		txtDescricao = new JTextField("DIGITE A DESCRIÇÃO DE PAGAMENTO");
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(100, 70, 270, 20);
		contentPanel.add(txtDescricao);

		txtRestante = new JTextField();
		txtRestante.setEnabled(false);
		txtRestante.setBounds(198, 10, 109, 20);
		contentPanel.add(txtRestante);
		txtRestante.setColumns(10);

		JLabel lblFalta = new JLabel("Falta");
		lblFalta.setBounds(133, 10, 46, 20);
		contentPanel.add(lblFalta);

		jdc = new JDateChooser();
		jdc.setBounds(99, 100, 140, 20);
		contentPanel.add(jdc);

		lblNumeroPagamento.setText("1º pagamento");
		Banco banco = new Banco();
		Fornecedor fornecedor1 = (Fornecedor) banco.buscarPorId(
				Fornecedor.class, compraOriginal.getFornecedor());

		txtFornecedor.setText(fornecedor1.getNome());
		txtRestante.setText(String.valueOf(compraOriginal.getCusto()));

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("OK");

				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				btnCancelar = new JButton("Cancelar");

				btnCancelar.setActionCommand("Cancelar");
				buttonPane.add(btnCancelar);
			}
		}
		btnOk.addActionListener(this);
		btnCancelar.addActionListener(this);
		valorQueFalta = compra.getCusto();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "OK":
			try {

				Banco banco = new Banco();
				pagamentoInserido = new Pagamento();

				pagamentoInserido.setValor(Float.valueOf(txtValor.getText()));
				pagamentoInserido
						.setData(Date.valueOf(df.format(jdc.getDate())));
				pagamentoInserido.setDescricao(txtDescricao.getText());
				pagamentoInserido.setClassificacao("COMPRA");
				pagamentoInserido.setPago(false);
				pagamentoInserido.setIdMovimento(compraOriginal.getId());

				if (pagamentoInserido.getValor() > valorQueFalta) {
					setVisible(false);
					JOptionPane
							.showMessageDialog(null,
									"Seu pagamento esta maior que o valor real que falta a pagar.");
					setVisible(true);
				}
				if (pagamentoInserido.getValor() < valorQueFalta) {
					inserirPagamento();
					txtRestante.setText(String.valueOf(valorQueFalta));

					break;

				}
				if ((pagamentoInserido.getValor() == valorQueFalta)) {
					inserirPagamento();

					for (int i = 0; i < listaPagamento.size(); i++) {
						banco.salvarObjeto(listaPagamento.get(i));
					}
					compraOriginal.setEstado("DIVIDIDA");
					banco.salvarOuAtualizarObjeto(compraOriginal);
					dispose();
				}
			} catch (NumberFormatException e2) {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Insira valores válidos");
				setVisible(true);
			}

			break;
		case "Cancelar":
			dispose();
			break;

		default:
			break;
		}

	}

	private void inserirPagamento() {
		// compraOriginal.setCusto(compraOriginal.getCusto()
		// - compraIserir.getCusto());

		listaPagamento.add(pagamentoInserido);

		txtRestante.setText(String.valueOf(compraOriginal.getCusto()));
		txtValor.setText("");
		numero = numero + 1;
		lblNumeroPagamento.setText(numero + "º pagamento");

		valorQueFalta = valorQueFalta - pagamentoInserido.getValor();

	}
}
