package Painel.Financeiro.Contas.Recebimento;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Bin.Caixa;
import Bin.Recebimento;
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
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class JPanelAgendamento extends JPanel
		implements ActionListener {
	private JTextField txtValor;
	private JTextField txtDescricao;

	DateFormat dfd = new SimpleDateFormat("yyyy-MM-dd");
	String[] listaDesp = { "ALUGUEL", "APLICAÇÃO", "EMPRESTIMO", "JURO", "OURAS VENDAS","RENDIMENTO", "RESGATE" };
	private JButton btnCancelar;
	private JButton btnLiberar;
	private JButton btnReceber;
	private JComboBox<String> boxClasse;
	private JDateChooser dtData;
	DecimalFormat df = new DecimalFormat("0.00");
	SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
	private DAO banco = new DAO();
	private JTextField txtCaixa;
	private JLabel label_3;

	/**
	 * Create the panel.
	 */
	public JPanelAgendamento() {
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

		JLabel lblAgendamentoDeRecebimento = new JLabel(
				"OUTROS RECEBIMENTOS");
		lblAgendamentoDeRecebimento.setForeground(Color.BLACK);
		lblAgendamentoDeRecebimento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAgendamentoDeRecebimento.setBounds(20, 215, 309, 25);
		add(lblAgendamentoDeRecebimento);

		boxClasse = new JComboBox<String>(listaDesp);
		boxClasse.setEnabled(false);
		boxClasse.setBounds(110, 250, 325, 20);
		add(boxClasse);

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

		btnReceber = new JButton("Receber");
		btnReceber.setEnabled(false);
		btnReceber.setBounds(345, 360, 90, 25);
		add(btnReceber);

		btnCancelar.addActionListener(this);
		btnLiberar.addActionListener(this);
		btnReceber.addActionListener(this);

		txtCaixa = new JTextField();
		txtCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		txtCaixa.setEnabled(false);
		txtCaixa.setBounds(365, 220, 70, 20);
		add(txtCaixa);
		txtCaixa.setColumns(10);
		
		label_3 = new JLabel("Caixa");
		label_3.setBounds(319, 223, 46, 14);
		add(label_3);

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
			//NÃO PODEMOS AGENDAR QUANDO É A MODALIDADE RECEBIMENTO!
			//agendar();
			break;
		case "Liberar":
			liberar();
			break;
		case "Receber":
			receber();
			break;

		default:
			break;
		}

	}

	private void liberar() {
		btnCancelar.setEnabled(true);
		btnLiberar.setEnabled(false);
		dtData.setEnabled(true);
		btnReceber.setEnabled(true);
		txtDescricao.setEnabled(true);
		txtValor.setEnabled(true);
		boxClasse.setEnabled(true);

	}

//	private void agendar() {
//		Recebimento recebimento = new Recebimento();
//		// ESSA CLASSE NÃO É UTILIZADA NOS RECEBIMENTOS
//		recebimento.setClassificacao(((String) boxClasse.getSelectedItem())
//				.toUpperCase());
//		recebimento.setData(Date.valueOf(dfd.format(dtData.getDate())));
//		recebimento.setDescricao(txtDescricao.getText().toUpperCase());
//		recebimento.setRecebido(false);
//		recebimento.setIdMovimento(0);
//		recebimento.setValor(Float.valueOf(txtValor.getText()));
//		banco.salvarObjeto(recebimento);
//		valoresPadrao();
//		JOptionPane
//				.showMessageDialog(null, "Atualize a lista de recebimentos.");
//
//	}

	private void receber() {

		try {
			
		
		Recebimento recebimento = new Recebimento();
		// TODO verificar as classes que funcionam pra ver o comportamento
		recebimento.setClassificacao(((String) boxClasse.getName())
				.toUpperCase());
		recebimento.setData(Date.valueOf(dfd.format(dtData.getDate())));
		recebimento.setDescricao(txtDescricao.getText().toUpperCase());
		recebimento.setRecebido(true);
		recebimento.setIdMovimento(0);
		recebimento.setValor(Float.valueOf(txtValor.getText().replace(",", ".")));

		@SuppressWarnings("unchecked")
		List<Caixa> a = (List<Caixa>) banco.listarObjetos(Caixa.class, "id");
		Integer ultimaPosicao = a.size();
		Integer IdCaixa = a.get(ultimaPosicao - 1).getId();
		Caixa cx = (Caixa) banco.buscarPorId(Caixa.class, IdCaixa);
		float valorAntigo = cx.getValor();
		float valorAntigoMenosVendaPaga = valorAntigo + recebimento.getValor();
		Caixa newCx = new Caixa();
		newCx.setIdMovimento(recebimento.getIdMovimento());
		newCx.setTipo("RECEBIMENTO CÓDIGO - " + recebimento.getId());
		newCx.setValor(valorAntigoMenosVendaPaga);

		banco.salvarObjeto(newCx);
		banco.salvarObjeto(recebimento);
		JOptionPane.showMessageDialog(null, "Recebido com sucesso!");
		valoresPadrao();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Insira valores validos nos campos!");
		}catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Insira valores validos nos campos!");
		}
	}

	private void cancelar() {
		btnCancelar.setEnabled(false);
		btnLiberar.setEnabled(true);
		btnReceber.setEnabled(false);
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

		// resgata o valor do caixa, pegando o ultimo elemento do banco
		@SuppressWarnings("unchecked")
		List<Caixa> a = (List<Caixa>) banco.listarObjetos(Caixa.class, "id");
		Integer ultimaPosicao = a.size();
		Integer IdCaixa = a.get(ultimaPosicao - 1).getId();

		Caixa cx = (Caixa) banco.buscarPorId(Caixa.class, IdCaixa);
		txtCaixa.setText(String.valueOf(df.format(cx.getValor())));

	}
}
