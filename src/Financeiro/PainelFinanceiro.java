package Financeiro;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class PainelFinanceiro extends JPanel implements ActionListener {
	JPanel painelEspecifico = new PainelFinanceiroContas();

	/**
	 * Create the panel.
	 */

	public PainelFinanceiro() {

		// valores não preenchidos

		this.setBounds(263, 100, 1099, 579);
		// this.setBounds(0, 0, 1099, 579);
		this.setLayout(null);
		// this.add(new CadastroProduto());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 102));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(0, 0, 1099, 54);
		add(panel);
		panel.setLayout(null);

		JLabel lblCadastroEAlterao = new JLabel("GERENCIA FINANCEIRA");
		lblCadastroEAlterao.setForeground(new Color(255, 255, 255));
		lblCadastroEAlterao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastroEAlterao.setBounds(21, 11, 328, 32);
		panel.add(lblCadastroEAlterao);

		JButton btnBanco = new JButton("Banco");
		btnBanco.setEnabled(false);
		btnBanco.setForeground(new Color(255, 255, 255));
		btnBanco.setBackground(new Color(51, 102, 153));
		btnBanco.setBounds(420, 15, 115, 25);
		panel.add(btnBanco);

		JButton btnContas = new JButton("Contas");
		btnContas.setForeground(new Color(255, 255, 255));
		btnContas.setBackground(new Color(51, 102, 153));
		btnContas.setBounds(300, 15, 115, 25);
		panel.add(btnContas);

		JButton btnPlanejamento = new JButton("Planejamento");
		btnPlanejamento.setEnabled(false);
		btnPlanejamento.setForeground(new Color(255, 255, 255));
		btnPlanejamento.setBackground(new Color(51, 102, 153));
		btnPlanejamento.setBounds(660, 15, 115, 25);
		panel.add(btnPlanejamento);

		JButton btnGestao = new JButton("Gest\u00E3o");
		btnGestao.setEnabled(false);
		btnGestao.setForeground(new Color(255, 255, 255));
		btnGestao.setBackground(new Color(51, 102, 153));
		btnGestao.setBounds(780, 15, 115, 25);
		panel.add(btnGestao);

		JButton btnFluxo = new JButton("Fluxo");
		btnFluxo.setEnabled(false);
		btnFluxo.setForeground(Color.WHITE);
		btnFluxo.setBackground(new Color(51, 102, 153));
		btnFluxo.setBounds(540, 15, 115, 25);
		panel.add(btnFluxo);

		JButton btnRelatorio = new JButton("Relatorio");
		btnRelatorio.setEnabled(false);
		btnRelatorio.setForeground(Color.WHITE);
		btnRelatorio.setBackground(new Color(51, 102, 153));
		btnRelatorio.setBounds(900, 15, 115, 25);
		panel.add(btnRelatorio);

		// colocando actionlistener em cada botaão
		btnPlanejamento.addActionListener(this);
		btnGestao.addActionListener(this);
		btnBanco.addActionListener(this);
		btnContas.addActionListener(this);
		btnFluxo.addActionListener(this);
		btnRelatorio.addActionListener(this);

		this.add(painelEspecifico);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();


		switch (acao) {
		case "Contas":

			remove(painelEspecifico);
			 painelEspecifico = new PainelFinanceiroContas();
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();
			break;
		case "Banco":
			JOptionPane.showMessageDialog(null, "Falta a implementação!!");

			remove(painelEspecifico);
			// painelEspecifico = new VendaProduto();
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();
			break;

		case "Fluxo":
			JOptionPane.showMessageDialog(null, "Falta a implementação!!");
			remove(painelEspecifico);
			// painelEspecifico = new BalancoProduto();
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();
			break;

		case "Planejamento":
			JOptionPane.showMessageDialog(null,
					"Falta a implementação, analise de mercado!!");
			// TODO - implementar
			remove(painelEspecifico);
			// painelEspecifico = new CadastroFornecedor();
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();
			break;
		case "Gestão":
			JOptionPane.showMessageDialog(null,
					"Falta a implementação, atendimento ao cliente!!");
			// TODO - implementar
			remove(painelEspecifico);
			// painelEspecifico = new lista ajuste de estoque entradas e saidas
			// que não sao compras nem vendas;
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();
			break;
		case "Relatorio":
			JOptionPane.showMessageDialog(null,
					"Falta a implementação, analise de desempenho!!");
			// TODO - implementar
			remove(painelEspecifico);
			// painelEspecifico = new CadastroProduto();
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();
			break;

		default:
			break;
		}

	}
}
