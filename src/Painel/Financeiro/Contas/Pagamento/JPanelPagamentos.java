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
import Bin.Pagamento;
import Janela.Financeiro.Detalhamento.JFrameCompra;
import Janela.Financeiro.Operacional.JFrameEspecificarPagamento;
import Persistence.DAO;
import TableModel.Conta.TMPagamento;

import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class JPanelPagamentos extends JPanel implements
		ActionListener {

	// tabela de compras em pendencia
	private JTable tabelaComprasPendencia;

	// model para trabalhar com as tabelas
	TMPagamento model = new TMPagamento();

	// botões declarados globalmente
	private JButton btnDetalhe;
	private JButton btnEspecificar;
	private JButton btnAlterar;
	private JButton btnRecebimento;
	private JButton btnQuitar;

	// painel do grafico que será iniciado quando o painel for iniciado
	private JPanel painalAgendamento;

	// instancia da classe DAO que faz conexão com o baco
	private DAO banco = new DAO();

	private JButton btnAtualizar;

	/**
	 * Create the panel.
	 */
	public JPanelPagamentos() {
		setLayout(null);
		// tamanho do painel
		setBounds(0, 45, 1089, 416);

		JLabel lblRecebimentosVista = new JLabel("PAGAMENTOS AGENDADOS");
		lblRecebimentosVista.setForeground(Color.BLACK);
		lblRecebimentosVista.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRecebimentosVista.setBounds(280, 10, 345, 25);
		add(lblRecebimentosVista);

		btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(10, 370, 115, 25);
		add(btnQuitar);

		JPanel panel = new JPanel();
		panel.setBounds(10, 45, 615, 314);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 615, 314);
		panel.add(scrollPane);

		tabelaComprasPendencia = new JTable(model);

		// tabela com colunas fixasv
		tabelaComprasPendencia.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		// tabelaComprasPendencia.getColumn("Fornecedor").setPreferredWidth(220);
		tabelaComprasPendencia.getColumn("Código").setPreferredWidth(70);
		tabelaComprasPendencia.getColumn("Descrição").setPreferredWidth(220);

		// seleciona apenas uma linha
		tabelaComprasPendencia
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(tabelaComprasPendencia);

		btnDetalhe = new JButton("Detalhe");
		btnDetalhe.setBounds(135, 370, 115, 25);
		add(btnDetalhe);

		btnEspecificar = new JButton("Especificar");
		btnEspecificar.setEnabled(false);
		btnEspecificar.setBounds(260, 370, 115, 25);
		add(btnEspecificar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(385, 370, 115, 25);
		add(btnAlterar);

		btnRecebimento = new JButton("Recebimento");
		btnRecebimento.setEnabled(false);
		btnRecebimento.setBounds(510, 370, 115, 25);
		add(btnRecebimento);

		btnAlterar.addActionListener(this);
		btnDetalhe.addActionListener(this);
		btnEspecificar.addActionListener(this);
		btnRecebimento.addActionListener(this);
		btnQuitar.addActionListener(this);

		painalAgendamento = new JPanelAgendamento();
		painalAgendamento.setBorder(new LineBorder(new Color(0, 0, 0)));
		painalAgendamento.setBounds(635, 10, 444, 394);
		add(painalAgendamento);
		painalAgendamento.setLayout(null);
		
		 btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(10, 14, 115, 25);
		add(btnAtualizar);
		btnAtualizar.addActionListener(this);

		atualizarTabelaContas();
	}

	private void atualizarTabelaContas() {

		// remove tudo do model que controla a exibição da tabela
		model.removeTudo();

		List<?> lista = banco.listarObjetos(Pagamento.class, "data");
		for (int i = 0; i < lista.size(); i++) {

			Pagamento pagamento = (Pagamento) lista.get(i);
			if (!pagamento.getPago()) {
				model.addRow(pagamento);
			}

		}
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
		case "Atualizar":
			atualizarTabelaContas();
			break;

		default:
			break;
		}

	}

	
	private void especificar() {
			Integer id = (Integer) tabelaComprasPendencia.getValueAt(
					tabelaComprasPendencia.getSelectedRow(), 0);
			Compra compra = (Compra) banco.buscarPorId(Compra.class, id);
			JFrameEspecificarPagamento dt = new JFrameEspecificarPagamento(
					compra);
			dt.setVisible(true);
			atualizarTabelaContas();

	}

	private void detalhe() {
		try{

		Integer id = (Integer) tabelaComprasPendencia.getValueAt(
				tabelaComprasPendencia.getSelectedRow(), 0);
		Pagamento pagamento = (Pagamento) banco.buscarPorId(Pagamento.class, id);
		
		Compra compra = (Compra) banco.buscarPorId(Compra.class, pagamento.getIdMovimento());
		JFrameCompra janelaCompra = new JFrameCompra(compra);
		janelaCompra.setVisible(true);
		atualizarTabelaContas();
		}catch(ArrayIndexOutOfBoundsException e){
			JOptionPane.showMessageDialog(null, "Selecione um item antes de ver os detalhes!");
		}

	}

	private void alterar() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Operação não implementada!!");

	}

	private void quitar() {
		try{
		Integer codigo = (Integer) tabelaComprasPendencia.getValueAt(
				tabelaComprasPendencia.getSelectedRow(), 0);

		Pagamento pagamento = (Pagamento) banco.buscarPorId(Pagamento.class, codigo);

		pagamento.setPago(true);

		@SuppressWarnings("unchecked")
		List<Caixa> a = (List<Caixa>) banco.listarObjetos(Caixa.class, "id");
		Integer ultimaPosicao = a.size();
		Integer IdCaixa = a.get(ultimaPosicao - 1).getId();

		Caixa cx = (Caixa) banco.buscarPorId(Caixa.class, IdCaixa);

		float valorAntigo = cx.getValor();

		float valorAntigoMenosCompraPaga = valorAntigo - pagamento.getValor();

		Caixa newCx = new Caixa();
		newCx.setIdMovimento(pagamento.getIdMovimento());
		newCx.setTipo("PAGAMENTO CÓDIGO - " + pagamento.getId());
		newCx.setValor(valorAntigoMenosCompraPaga);
		if (pagamento.getClassificacao().toLowerCase().contains("COMPRA".toLowerCase())) {
			Compra compraReferenciada = (Compra) banco.buscarPorId(Compra.class, pagamento.getIdMovimento());
			
			Fornecedor fornecedor = (Fornecedor) banco.buscarPorId(
					Fornecedor.class, compraReferenciada.getFornecedor());

			fornecedor.setDebito(fornecedor.getDebito() - pagamento.getValor());
			banco.salvarOuAtualizarObjeto(fornecedor);
	
		}

		banco.salvarObjeto(newCx);
		
		banco.salvarOuAtualizarObjeto(pagamento);
		JOptionPane.showMessageDialog(null, "Conta paga com sucesso!");

		atualizarTabelaContas();
		}catch(ArrayIndexOutOfBoundsException e){
			JOptionPane.showMessageDialog(null, "Selecione um item antes de quitar!");
		}

	}
}
