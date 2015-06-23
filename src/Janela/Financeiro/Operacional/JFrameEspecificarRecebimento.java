package Janela.Financeiro.Operacional;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Bin.Cliente;
import Bin.Recebimento;
import Bin.Venda;
import Persistence.DAO;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JFrameEspecificarRecebimento extends JDialog
		implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCliente;
	private JTextField txtDescricao;
	private JTextField txtRestante;
	private JLabel lblNumeroRecebimento;
	private JDateChooser jdc;
	
	DAO banco = new DAO();

	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	Venda vendaOriginal = new Venda();
	List<Recebimento> listaRecebimento = new ArrayList<Recebimento>();

	int numero = 1;

	private JButton btnCancelar;

	private JButton btnOk;

	private Recebimento recebimentoInserido;

	float valorQueFalta = 0;

	/**
	 * Create the dialog.
	 * 
	 * @param venda
	 */
	public JFrameEspecificarRecebimento(Venda venda) {
		setTitle("Especificando Recebimento");

		vendaOriginal = venda;

		setBounds(100, 100, 390, 229);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		setModal(true);
		setResizable(false);
		setAlwaysOnTop(true);

		setLocationRelativeTo(null);

		lblNumeroRecebimento = new JLabel("Numero do Recebimento");
		lblNumeroRecebimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroRecebimento.setBounds(10, 10, 148, 20);
		contentPanel.add(lblNumeroRecebimento);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(20, 40, 72, 20);
		contentPanel.add(lblCliente);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(20, 70, 72, 20);
		contentPanel.add(lblDescrio);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(46, 99, 46, 20);
		contentPanel.add(lblData);

		Cliente Fornecedor = (Cliente) banco.buscarPorId(Cliente.class, venda.getCliente());
		
		txtCliente = new JTextField(Fornecedor.getNome());
		txtCliente.setEnabled(false);
		txtCliente.setColumns(10);
		txtCliente.setBounds(100, 40, 270, 20);
		contentPanel.add(txtCliente);

		txtDescricao = new JTextField("DIGITE A DESCRIÇÃO DE PAGAMENTO");
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(100, 70, 270, 20);
		contentPanel.add(txtDescricao);

		txtRestante = new JTextField(String.valueOf(venda.getValor()));
		txtRestante.setHorizontalAlignment(SwingConstants.CENTER);
		txtRestante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRestante.setEnabled(false);
		txtRestante.setBounds(261, 5, 109, 25);
		contentPanel.add(txtRestante);
		txtRestante.setColumns(10);

		JLabel lblFalta = new JLabel("Valor");
		lblFalta.setBounds(205, 5, 46, 25);
		contentPanel.add(lblFalta);

		jdc = new JDateChooser();
		jdc.setBounds(99, 100, 140, 20);
		contentPanel.add(jdc);

		lblNumeroRecebimento.setText("Recebimento");
		DAO banco = new DAO();
		Cliente Fornecedor1 = (Cliente) banco.buscarPorId(
				Cliente.class, vendaOriginal.getCliente());

		txtCliente.setText(Fornecedor1.getNome());

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
		valorQueFalta = venda.getValor();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "OK":

			DAO banco = new DAO();
			recebimentoInserido = new Recebimento();

			recebimentoInserido.setValor(Float.valueOf(txtRestante.getText()));
			recebimentoInserido.setData(Date.valueOf(df.format(jdc.getDate())));
			recebimentoInserido.setDescricao(txtDescricao.getText());
			recebimentoInserido.setClassificacao("VENDA");
			recebimentoInserido.setRecebido(false);
			recebimentoInserido.setIdMovimento(vendaOriginal.getId());
			


			if (recebimentoInserido.getValor() > valorQueFalta) {
				setVisible(false);
				JOptionPane
						.showMessageDialog(null,
								"Seu recebimento esta maior que o valor real que falta a pagar.");
				setVisible(true);
			}
			if (recebimentoInserido.getValor() < valorQueFalta) {
				inserirRecebimento();
				txtRestante.setText(String.valueOf(valorQueFalta));

				break;

			}
			if ((recebimentoInserido.getValor() == valorQueFalta)) {
				inserirRecebimento();

				for (int i = 0; i < listaRecebimento.size(); i++) {
					banco.salvarOuAtualizarObjeto(listaRecebimento.get(i));
				}
				vendaOriginal.setEstado("DIVIDIDA");
				banco.salvarOuAtualizarObjeto(vendaOriginal);
				dispose();
			}
			break;
		case "Cancelar":
			dispose();
			break;

		default:
			break;
		}

	}

	private void inserirRecebimento() {
		// vendaOriginal.setValor(vendaOriginal.getValor()
		// - vendaIserir.getValor());

		listaRecebimento.add(recebimentoInserido);

		txtRestante.setText(String.valueOf(vendaOriginal.getValor()));
		txtRestante.setText("");
		numero = numero + 1;
		lblNumeroRecebimento.setText(numero + "º recebimento");

		valorQueFalta = valorQueFalta - recebimentoInserido.getValor();

	}
}
