package Painel.Financeiro.Contas.Recebimento;

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

import Bin.Cliente;
import Janela.Financeiro.Detalhamento.JFrameVendaClientes;
import Persistence.DAO;
import TableModel.Cliente.TMClienteFinanceiroContasReceber;

import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class JPanelRecebimento extends JPanel implements
		ActionListener {

	// tabela de vendas em pendencia
	private JTable tabelaClientesDebito;

	// model para trabalhar com as tabelas
	TMClienteFinanceiroContasReceber model = new TMClienteFinanceiroContasReceber();

	// botões declarados globalmente
	private JButton btnDetalhe;

	// painel do grafico que será iniciado quando o painel for iniciado
	private JPanel painalAgendamento;

	// instancia da classe DAO que faz conexão com o baco
	private DAO banco = new DAO();

	private JButton btnAtualizar;

	/**
	 * Create the panel.
	 */
	public JPanelRecebimento() {
		setLayout(null);
		// tamanho do painel
		setBounds(0, 45, 1089, 416);

		JLabel lblRecebimentosVista = new JLabel("CLIENTES EM DEBITO");
		lblRecebimentosVista.setForeground(Color.BLACK);
		lblRecebimentosVista.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRecebimentosVista.setBounds(465, 10, 345, 25);
		add(lblRecebimentosVista);

		JPanel panel = new JPanel();
		panel.setBounds(465, 45, 615, 314);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 615, 314);
		panel.add(scrollPane);

		tabelaClientesDebito = new JTable(model);

		// tabela com colunas fixasv
		tabelaClientesDebito.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		tabelaClientesDebito.getColumn("Nome").setPreferredWidth(220);
		tabelaClientesDebito.getColumn("Código").setPreferredWidth(70);
		// tabelaVendasPendencia.getColumn("Descrição").setPreferredWidth(220);

		// seleciona apenas uma linha
		tabelaClientesDebito
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(tabelaClientesDebito);

		btnDetalhe = new JButton("Detalhe");
		btnDetalhe.setBounds(465, 370, 115, 25);
		add(btnDetalhe);
		btnDetalhe.addActionListener(this);

		painalAgendamento = new JPanelAgendamento();
		painalAgendamento.setBorder(new LineBorder(new Color(0, 0, 0)));
		painalAgendamento.setBounds(10, 10, 444, 394);
		add(painalAgendamento);
		painalAgendamento.setLayout(null);
		
		 btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(964, 14, 115, 25);
		add(btnAtualizar);
		btnAtualizar.addActionListener(this);

		atualizarTabelaClientesDebito();
	}

	private void atualizarTabelaClientesDebito() {

		// remove tudo do model que controla a exibição da tabela
		model.removeTudo();

		List<?> lista = banco.listarObjetos(Cliente.class, "nome");
		for (int i = 0; i < lista.size(); i++) {

			Cliente cliente = (Cliente) lista.get(i);
			if (cliente.getDivida() > 0) {

				model.addRow(cliente);
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
		case "Detalhe":
			detalhe();
			break;
			
		case "Atualizar":
			atualizarTabelaClientesDebito();
			break;

		default:
			break;
		}

	}

	private void detalhe() {
		try{

		Integer id = (Integer) tabelaClientesDebito.getValueAt(
				tabelaClientesDebito.getSelectedRow(), 0);
		Cliente cliente = (Cliente) banco.buscarPorId(Cliente.class, id);
		
		JFrameVendaClientes dt = new JFrameVendaClientes(
				cliente);
		dt.setVisible(true);
		atualizarTabelaClientesDebito();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERRO -" + e);
			JOptionPane
					.showMessageDialog(null,
							" Selecione uma conta para poder verificar os detalhes.");
//		} catch (Exception e) {
//			System.out.println("ERRO -" + e);
//			JOptionPane.showMessageDialog(null, " ERRO - " + e
//					+ ", entre em contato com o administrador do sistema");
	}
		
	}

	

}
