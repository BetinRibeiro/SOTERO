package Painel.Financeiro.Contas.Pagamento;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;

import Bin.Caixa;
import Bin.Compra;
import Bin.Fornecedor;
import Janela.Financeiro.Detalhamento.JFrameCompra;
import Janela.Financeiro.Operacional.JFrameEspecificarPagamento;
import Painel.Financeiro.JPanelGrafico;
import Persistence.DAO;
import TableModel.Financeiro.Conta.TMPagar;

@SuppressWarnings("serial")
public class JPanelPendencias extends JPanel implements
		ActionListener {

	// tabela de compras em pendencia
	private JTable tabelaComprasPendencia;

	// model para trabalhar com as tabelas
	TMPagar model = new TMPagar();

	// bot�es declarados globalmente
	private JButton btnDetalhe;
	private JButton btnEspecificar;
	private JButton btnAlterar;
	private JButton btnRecebimento;
	private JButton btnQuitar;

	// painel do grafico que ser� iniciado quando o painel for iniciado
	private JPanel painalGrafico;

	// instancia da classe DAO que faz conex�o com o baco
	private DAO banco = new DAO();

	/**
	 * Create the panel.
	 */
	public JPanelPendencias() {
		setLayout(null);
		// tamanho do painel
		setBounds(0, 45, 1089, 416);

		JLabel lblRecebimentosVista = new JLabel(
				"COMPRAS COM PAGAMENTOS N\u00C3O AGENDADOS");
		lblRecebimentosVista.setForeground(Color.BLACK);
		lblRecebimentosVista.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRecebimentosVista.setBounds(173, 10, 452, 25);
		add(lblRecebimentosVista);

		btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(10, 379, 115, 25);
		add(btnQuitar);

		JPanel panel = new JPanel();
		panel.setBounds(10, 45, 615, 325);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 615, 325);
		panel.add(scrollPane);

		tabelaComprasPendencia = new JTable(model);

		// tabela com colunas fixasv
		tabelaComprasPendencia.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		tabelaComprasPendencia.getColumn("Fornecedor").setPreferredWidth(220);
		tabelaComprasPendencia.getColumn("C�digo").setPreferredWidth(70);
		tabelaComprasPendencia.getColumn("Descri��o").setPreferredWidth(220);

		// seleciona apenas uma linha
		tabelaComprasPendencia
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(tabelaComprasPendencia);

		btnDetalhe = new JButton("Detalhe");
		btnDetalhe.setBounds(135, 379, 115, 25);
		add(btnDetalhe);

		btnEspecificar = new JButton("Especificar");
		btnEspecificar.setBounds(260, 379, 115, 25);
		add(btnEspecificar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(385, 379, 115, 25);
		add(btnAlterar);

		btnRecebimento = new JButton("Recebimento");
		btnRecebimento.setEnabled(false);
		btnRecebimento.setBounds(510, 379, 115, 25);
		add(btnRecebimento);

		btnAlterar.addActionListener(this);
		btnDetalhe.addActionListener(this);
		btnEspecificar.addActionListener(this);
		btnRecebimento.addActionListener(this);
		btnQuitar.addActionListener(this);

		painalGrafico = new JPanelGrafico();
		painalGrafico.setBounds(635, 10, 444, 394);
		add(painalGrafico);

		atualizarTabelaContas();
	}

	private void atualizarTabelaContas() {

		// remove tudo do model que controla a exibi��o da tabela
		model.removeTudo();

		List<?> lista = banco.listarObjetos(Compra.class, "data");
		for (int i = 0; i < lista.size(); i++) {

			Compra compra = (Compra) lista.get(i);
			if (compra.getEstado().equals("PENDENCIA")) {
				model.addRow(compra);
			}

		}
		remove(painalGrafico);
		painalGrafico = new JPanelGrafico();
		painalGrafico.setBounds(635, 10, 444, 394);
		add(painalGrafico);
		invalidate();
		validate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		System.out.println(acao);

		switch (acao) {
		case "Alterar":
			alterar();
			break;
		case "Quitar":
			quitar();
			break;
		case "Detalhe":
			detalhe();
			break;
		case "Especificar":
			especificar();
			break;
		case "Recebimento":
			recebimento();
			break;

		default:
			break;
		}

	}

	private void recebimento() {
		// TODO Auto-generated method stub

	}

	private void especificar() {
		try{
			Integer id = (Integer) tabelaComprasPendencia.getValueAt(
					tabelaComprasPendencia.getSelectedRow(), 0);
			Compra compra = (Compra) banco.buscarPorId(Compra.class, id);
			JFrameEspecificarPagamento dt = new JFrameEspecificarPagamento(
					compra);
			dt.setVisible(true);
			atualizarTabelaContas();
		}catch(ArrayIndexOutOfBoundsException e){
			JOptionPane.showMessageDialog(null, "Selecione um item antes de especificar!");
		}
	}

	private void detalhe() {
		try{

		Integer id = (Integer) tabelaComprasPendencia.getValueAt(
				tabelaComprasPendencia.getSelectedRow(), 0);
		Compra compra = (Compra) banco.buscarPorId(Compra.class, id);
		JFrameCompra janelaCompra = new JFrameCompra(
				compra);
		janelaCompra.setVisible(true);
		atualizarTabelaContas();
	}catch(ArrayIndexOutOfBoundsException e){
		JOptionPane.showMessageDialog(null, "Selecione um item antes de ver os detalhes!");
	}

	}

	private void alterar() {
		// TODO Auto-generated method stub

	}

	private void quitar() {
		try{
			
		
		Integer codigo = (Integer) tabelaComprasPendencia.getValueAt(
				tabelaComprasPendencia.getSelectedRow(), 0);

		Compra compra = (Compra) banco.buscarPorId(Compra.class, codigo);

		compra.setEstado("QUITADA");

		@SuppressWarnings("unchecked")
		List<Caixa> a = (List<Caixa>) banco.listarObjetos(Caixa.class, "id");
		Integer ultimaPosicao = a.size();
		Integer IdCaixa = a.get(ultimaPosicao - 1).getId();

		Caixa cx = (Caixa) banco.buscarPorId(Caixa.class, IdCaixa);

		float valorAntigoMenosCompraPaga = (Float.valueOf(cx.getValor()))
				- compra.getCusto();

		Caixa newCx = new Caixa();
		newCx.setIdMovimento(compra.getId());
		newCx.setTipo("PAGAMENTO COMPRA");
		newCx.setValor(valorAntigoMenosCompraPaga);

		Fornecedor fornecedor = (Fornecedor) banco.buscarPorId(
				Fornecedor.class, compra.getFornecedor());

		fornecedor.setDebito(fornecedor.getDebito() - compra.getCusto());

		banco.salvarObjeto(newCx);
		banco.salvarOuAtualizarObjeto(fornecedor);
		banco.salvarOuAtualizarObjeto(compra);
		JOptionPane.showMessageDialog(null, "Conta paga com sucesso!");

		atualizarTabelaContas();
		}catch(ArrayIndexOutOfBoundsException e){
			JOptionPane.showMessageDialog(null, "Selecione um item antes de quitar!");
		}

	}
}
