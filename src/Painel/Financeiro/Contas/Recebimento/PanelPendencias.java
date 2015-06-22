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

import Bin.Caixa;
import Bin.Cliente;
import Bin.Venda;
import Janela.Financeiro.Detalhamento.JVenda;
import Janela.Financeiro.Operacional.JEspecificarRecebimento;
import Painel.Financeiro.PanelGrafico;
import Persistence.DAO;
import TableModel.Financeiro.Conta.TMReceber;

@SuppressWarnings("serial")
public class PanelPendencias extends JPanel implements
		ActionListener {

	// tabela de vendas em pendencia
	private JTable tabelaVendasPendencia;

	// model para trabalhar com as tabelas
	TMReceber model = new TMReceber();

	// bot�es declarados globalmente
	private JButton btnDetalhe;
	private JButton btnEspecificar;
	private JButton btnAlterar;
	private JButton btnDesfazer;
	private JButton btnQuitar;

	// painel do grafico que ser� iniciado quando o painel for iniciado
	private JPanel painalGrafico = new PanelGrafico();

	// instancia da classe DAO que faz conex�o com o baco
	private DAO banco = new DAO();

	/**
	 * Create the panel.
	 */
	public PanelPendencias() {
		setLayout(null);
		// tamanho do painel
		setBounds(0, 45, 1089, 416);

		JLabel lblRecebimentosVista = new JLabel(
				"VENDAS COM RECEBIMENTOS N\u00C3O AGENDADOS");
		lblRecebimentosVista.setForeground(Color.BLACK);
		lblRecebimentosVista.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRecebimentosVista.setBounds(465, 10, 584, 25);
		add(lblRecebimentosVista);

		btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(465, 379, 115, 25);
		add(btnQuitar);

		JPanel panel = new JPanel();
		panel.setBounds(465, 45, 615, 325);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 615, 325);
		panel.add(scrollPane);

		tabelaVendasPendencia = new JTable(model);

		// tabela com colunas fixasv
		tabelaVendasPendencia.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		tabelaVendasPendencia.getColumn("Cliente").setPreferredWidth(220);
		tabelaVendasPendencia.getColumn("C�digo").setPreferredWidth(70);
		tabelaVendasPendencia.getColumn("Descri��o").setPreferredWidth(220);

		// seleciona apenas uma linha
		tabelaVendasPendencia
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(tabelaVendasPendencia);

		btnDetalhe = new JButton("Detalhe");
		btnDetalhe.setBounds(590, 379, 115, 25);
		add(btnDetalhe);

		btnEspecificar = new JButton("Especificar");
		btnEspecificar.setBounds(715, 379, 115, 25);
		add(btnEspecificar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(840, 379, 115, 25);
		add(btnAlterar);

		btnDesfazer = new JButton("Desfazer");
		btnDesfazer.setEnabled(false);
		btnDesfazer.setBounds(965, 379, 115, 25);
		add(btnDesfazer);

		btnAlterar.addActionListener(this);
		btnDetalhe.addActionListener(this);
		btnEspecificar.addActionListener(this);
		btnDesfazer.addActionListener(this);
		btnQuitar.addActionListener(this);

		painalGrafico.setBounds(10, 10, 444, 394);
		add(painalGrafico);

		atualizarTabelaContas();
	}

	private void atualizarTabelaContas() {
		try {

			// remove tudo do model que controla a exibi��o da tabela
			model.removeTudo();

			List<?> lista = banco.listarObjetos(Venda.class, "data");
			for (int i = 0; i < lista.size(); i++) {

				Venda venda = (Venda) lista.get(i);
				if (venda.getEstado().equals("PENDENCIA")) {
					model.addRow(venda);
				}

			}
			remove(painalGrafico);
			painalGrafico = new PanelGrafico();
			painalGrafico.setLocation(10, 10);
			// painalGrafico.setBounds(635, 10, 444, 394);
			add(painalGrafico);
			invalidate();
			validate();
			repaint();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro - " + e
					+ ", entre em contato com o administrador do sistemas.");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		System.out.println(acao);

		switch (acao) {
		case "Quitar":
			quitar();

			break;
		case "Detalhe":
			detalhe();

			break;
		case "Alterar":
			alterar();
			break;
		case "Especificar":
			especificar();
			break;

		default:
			break;
		}

	}

	private void especificar() {

		try {
			Integer id = (Integer) tabelaVendasPendencia.getValueAt(
					tabelaVendasPendencia.getSelectedRow(), 0);
			Venda venda = (Venda) banco.buscarPorId(Venda.class, id);
			System.out.println("Cliente codigo " + venda.getCliente());
			if (venda.getCliente() != 1) {
				JEspecificarRecebimento dt = new JEspecificarRecebimento(
						venda);
				dt.setVisible(true);
				atualizarTabelaContas();

			}
			if (venda.getCliente() == 1) {
				JOptionPane
						.showMessageDialog(null,
								"Essa venda n�o pode ser especificada, pois n�o existe cliente!");
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERRO -" + e);
			JOptionPane
					.showMessageDialog(null,
							" Selecione uma compra para poder especificar o seu pagamento.");
		} catch (Exception e) {
			System.out.println("ERRO -" + e);
			JOptionPane.showMessageDialog(null, " ERRO - " + e
					+ ", entre em contato com o administrador do sistema");
		}

	}

	private void alterar() {
		// TODO Auto-generated method stub

	}

	private void detalhe() {

		try {
			Integer id = (Integer) tabelaVendasPendencia.getValueAt(
					tabelaVendasPendencia.getSelectedRow(), 0);
			System.out.println(id);
			Venda venda = (Venda) banco.buscarPorId(Venda.class, id);
			JVenda dt = new JVenda(
					venda);
			dt.setVisible(true);
			atualizarTabelaContas();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERRO -" + e);
			JOptionPane.showMessageDialog(null,
					" Selecione uma compra para poder detalha-la.");
		} catch (Exception e) {
			System.out.println("ERRO -" + e);
			JOptionPane.showMessageDialog(null, " ERRO - " + e
					+ ", entre em contato com o administrador do sistema");
		}
	}

	private void quitar() {

		try {
			Integer id = (Integer) tabelaVendasPendencia.getValueAt(
					tabelaVendasPendencia.getSelectedRow(), 0);

			Venda venda = (Venda) banco.buscarPorId(Venda.class, id);

			venda.setEstado("QUITADA");

			@SuppressWarnings("unchecked")
			List<Caixa> a = (List<Caixa>) banco
					.listarObjetos(Caixa.class, "id");
			Integer ultimaPosicao = a.size();
			Integer IdCaixa = a.get(ultimaPosicao - 1).getId();

			Caixa cx = (Caixa) banco.buscarPorId(Caixa.class, IdCaixa);

			float valorAntigoMaiValorRecebido = (Float.valueOf(cx.getValor()))
					+ venda.getValor();

			Caixa newCx = new Caixa();
			newCx.setIdMovimento(venda.getId());
			newCx.setTipo("RECEBIMENTO VENDA");
			newCx.setValor(valorAntigoMaiValorRecebido);

			Cliente cliente = (Cliente) banco.buscarPorId(Cliente.class,
					venda.getCliente());

			cliente.setDivida(cliente.getDivida() - venda.getValor());

			banco.salvarObjeto(newCx);
			banco.salvarOuAtualizarObjeto(cliente);
			banco.salvarOuAtualizarObjeto(venda);
			JOptionPane.showMessageDialog(null, "Conta recebida com sucesso!");

			atualizarTabelaContas();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERRO -" + e);
			JOptionPane.showMessageDialog(null,
					" Selecione uma compra para poder quitar.");
		} catch (Exception e) {
			System.out.println("ERRO -" + e);
			JOptionPane.showMessageDialog(null, " ERRO - " + e
					+ ", entre em contato com o administrador do sistema");
		}
	}

}
