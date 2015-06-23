package Painel.Financeiro.Contas.Pagamento;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Bin.Caixa;
import Bin.Pagamento;
import Persistence.DAO;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PanelAgendamento extends JPanel
		implements ActionListener {
	private JTextField txtValor;
	private JTextField txtDescricao;

	DateFormat dfd = new SimpleDateFormat("yyyy-MM-dd");
	String[] listaDesp = { "SALÁRIO", "ENCARGOS", "RETIRADA",
			"SERVIÇOS", "ÁGUA", "ENERGIA ELETRICA", "TELEFONE",
			"MATERIAL DE ESPEDIENTE", "MANUTENÇÃO", "PROPAGANDA E PUBLICIDADE",
			"COMBUSTÍVEL", "MANUTENÇÃO DE VEICULO", "VIAGEM", "DESPESA FINANCEIRA",
			"DEPRECIAÇÃO", "TAXAS", "ALUGUEL", "INTERNET",
			"SERVIÇO DE LIMPEZA", "FRETE", "ASSISTENCIA TECNICA",
			"GASTOS ASSISTENCIAIS", "CORREIOS", "EXTRA", "OUTROS PAGAMENTOS" };
	private JButton btnAgendar;
	private JButton btnCancelar;
	private JButton btnLiberar;
	private JButton btnPagar;
	private JComboBox<String> boxClasse;
	private JDateChooser dtData;
	DecimalFormat df = new DecimalFormat("0.00");
	SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
	private DAO banco = new DAO();
	private JTextField txtCaixa;

	/**
	 * Create the panel.
	 */
	public PanelAgendamento() {
		setBounds(635, 10, 444, 394);
		setLayout(null);

		txtValor = new JTextField();
		txtValor.setEnabled(false);
		txtValor.setColumns(10);
		txtValor.setBounds(365, 315, 70, 20);
		add(txtValor);

		JLabel label = new JLabel("Valor");
		label.setBounds(308, 315, 46, 20);
		add(label);

		JLabel label_1 = new JLabel("Data");
		label_1.setBounds(46, 315, 54, 20);
		add(label_1);

		dtData = new JDateChooser();
		dtData.setEnabled(false);
		dtData.setBounds(110, 315, 140, 20);
		add(dtData);

		JLabel label_2 = new JLabel("Descri\u00E7\u00E3o");
		label_2.setBounds(20, 285, 72, 20);
		add(label_2);

		txtDescricao = new JTextField(
				"DIGITE A DESCRI\u00C7\u00C3O DE PAGAMENTO");
		txtDescricao.setEnabled(false);
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(100, 285, 335, 20);
		add(txtDescricao);

		JLabel lblClassificao = new JLabel("Classifica\u00E7\u00E3o");
		lblClassificao.setBounds(20, 251, 90, 20);
		add(lblClassificao);

		JLabel lblAgendamentoDePagamento = new JLabel(
				"AGENDAMENTO DE PAGAMENTO");
		lblAgendamentoDePagamento.setForeground(Color.BLACK);
		lblAgendamentoDePagamento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAgendamentoDePagamento.setBounds(20, 215, 304, 25);
		add(lblAgendamentoDePagamento);

		boxClasse = new JComboBox<String>(listaDesp);
		boxClasse.setEnabled(false);
		boxClasse.setBounds(110, 250, 325, 20);
		add(boxClasse);

		btnAgendar = new JButton("Agendar");
		btnAgendar.setEnabled(false);
		btnAgendar.setBounds(245, 360, 90, 25);
		add(btnAgendar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(120, 360, 90, 25);
		add(btnCancelar);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 10, 424, 199);
		add(panel);
		panel.setLayout(null);

		JCalendar calendario = new JCalendar();
		calendario.setBounds(1, 1, 422, 197);
		calendario.setWeekOfYearVisible(false);
		panel.add(calendario);

		btnLiberar = new JButton("Liberar");
		btnLiberar.setBounds(20, 360, 90, 25);
		add(btnLiberar);

		btnPagar = new JButton("Pagar");
		btnPagar.setEnabled(false);
		btnPagar.setBounds(345, 360, 90, 25);
		add(btnPagar);

		btnCancelar.addActionListener(this);
		btnAgendar.addActionListener(this);
		btnLiberar.addActionListener(this);
		btnPagar.addActionListener(this);

		txtCaixa = new JTextField();
		txtCaixa.setEnabled(false);
		txtCaixa.setBounds(365, 220, 70, 20);
		add(txtCaixa);
		txtCaixa.setColumns(10);

		JLabel lblCaixa = new JLabel("Caixa");
		lblCaixa.setBounds(319, 223, 46, 14);
		add(lblCaixa);
		valoresPadrao();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		System.out.println("Ação - " + acao);

		switch (acao) {
		case "Cancelar":
			valoresPadrao();
			break;
		case "Agendar":
			agendar();
			break;
		case "Liberar":
			liberar();
			break;
		case "Pagar":
			pagar();
			break;

		default:
			break;
		}

	}

	private void liberar() {
		btnCancelar.setEnabled(true);
		btnAgendar.setEnabled(true);
		btnLiberar.setEnabled(false);
		dtData.setEnabled(true);
		btnPagar.setEnabled(true);
		txtDescricao.setEnabled(true);
		txtValor.setEnabled(true);
		boxClasse.setEnabled(true);

	}

	private void agendar() {
		Pagamento pagamento = new Pagamento();
		// TODO verificar as classes que funcionam pra ver o comportamento
		pagamento.setClassificacao(((String) boxClasse.getSelectedItem())
				.toUpperCase());
		pagamento.setData(Date.valueOf(dfd.format(dtData.getDate())));
		pagamento.setDescricao(txtDescricao.getText().toUpperCase());
		pagamento.setPago(false);
		pagamento.setIdMovimento(0);
		pagamento.setValor(Float.valueOf(txtValor.getText()));
		banco.salvarObjeto(pagamento);
		valoresPadrao();
		JOptionPane.showMessageDialog(null, "Atualize a lista de pagamentos.");

	}

	private void pagar() {
		try {

			Pagamento pagamento = new Pagamento();
			// TODO verificar as classes que funcionam pra ver o comportamento
			pagamento.setClassificacao(((String) boxClasse.getName())
					.toUpperCase());
			pagamento.setData(Date.valueOf(dfd.format(dtData.getDate())));
			pagamento.setDescricao(txtDescricao.getText().toUpperCase());
			pagamento.setPago(true);
			pagamento.setIdMovimento(0);
			pagamento.setValor(Float.valueOf(txtValor.getText().replace(",",
					".")));

			@SuppressWarnings("unchecked")
			List<Caixa> a = (List<Caixa>) banco
					.listarObjetos(Caixa.class, "id");
			Integer ultimaPosicao = a.size();
			Integer IdCaixa = a.get(ultimaPosicao - 1).getId();
			Caixa cx = (Caixa) banco.buscarPorId(Caixa.class, IdCaixa);
			float valorAntigo = cx.getValor();
			float valorAntigoMenosCompraPaga = valorAntigo
					- pagamento.getValor();
			Caixa newCx = new Caixa();
			newCx.setIdMovimento(pagamento.getIdMovimento());
			newCx.setTipo("PAGAMENTO CÓDIGO - " + pagamento.getId());
			newCx.setValor(valorAntigoMenosCompraPaga);

			banco.salvarObjeto(newCx);
			banco.salvarObjeto(pagamento);
			JOptionPane.showMessageDialog(null, "Conta paga com sucesso!");
			valoresPadrao();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Insira valores válidos!");
		}
	}

	private void cancelar() {
		btnCancelar.setEnabled(false);
		btnAgendar.setEnabled(false);
		btnLiberar.setEnabled(true);
		btnPagar.setEnabled(false);
		txtDescricao.setEnabled(false);
		txtValor.setEnabled(false);
		dtData.setEnabled(false);
		boxClasse.setEnabled(false);

	}

	private void valoresPadrao() {
		txtDescricao.setText("DIGITE SUA DESCRIÇÃO");
		txtValor.setText("0.00");
		dtData.setDate(new java.util.Date());
		boxClasse.setName("");

		cancelar();

		btnAgendar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnPagar.setEnabled(false);
		btnLiberar.setEnabled(true);

		// resgata o valor do caixa, pegando o ultimo elemento do banco
		@SuppressWarnings("unchecked")
		List<Caixa> a = (List<Caixa>) banco.listarObjetos(Caixa.class, "id");
		Integer ultimaPosicao = a.size();
		Integer IdCaixa = a.get(ultimaPosicao - 1).getId();

		Caixa cx = (Caixa) banco.buscarPorId(Caixa.class, IdCaixa);
		txtCaixa.setText(String.valueOf(df.format(cx.getValor())));

	}
}
