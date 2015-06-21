package Financeiro;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class PainelFinanceiroContasPagar extends JPanel implements
		ActionListener {

	private JButton btnOutros2;

	private JButton btnOutros;

	private JPanel panelExibido = new PainelFinanceiroContasPagarPendencias();

	private JButton btnPagamentos;

	private JButton btnHistorico;

	private JButton btnPendencias;

	/**
	 * Create the frame.
	 */
	public PainelFinanceiroContasPagar() {
		this.setBounds(0, 47, 1089, 461);
		this.setLayout(null);
		this.setBackground(new Color(51, 102, 102));

		JLabel lblContasAPagar = new JLabel("CONTAS A PAGAR");
		lblContasAPagar.setForeground(new Color(255, 255, 255));
		lblContasAPagar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContasAPagar.setBounds(50, 10, 345, 25);
		add(lblContasAPagar);

		add(panelExibido);
		panelExibido.setLayout(null);

		btnOutros = new JButton("Outro");
		btnOutros.setEnabled(false);
		btnOutros.setForeground(Color.WHITE);
		btnOutros.setBackground(new Color(51, 102, 153));
		btnOutros.setBounds(844, 10, 115, 25);
		add(btnOutros);

		btnOutros2 = new JButton("Outro");
		btnOutros2.setEnabled(false);
		btnOutros2.setForeground(Color.WHITE);
		btnOutros2.setBackground(new Color(51, 102, 153));
		btnOutros2.setBounds(964, 10, 115, 25);
		add(btnOutros2);
		btnOutros2.addActionListener(this);
		btnOutros.addActionListener(this);

		btnPagamentos = new JButton("Pagamentos");
		btnPagamentos.setForeground(Color.WHITE);
		btnPagamentos.setBackground(new Color(51, 102, 153));
		btnPagamentos.setBounds(599, 10, 115, 25);
		add(btnPagamentos);

		btnHistorico = new JButton("Historico");
		btnHistorico.setEnabled(false);
		btnHistorico.setForeground(Color.WHITE);
		btnHistorico.setBackground(new Color(51, 102, 153));
		btnHistorico.setBounds(719, 10, 115, 25);
		add(btnHistorico);

		btnPendencias = new JButton("Pendencias");
		btnPendencias.setForeground(Color.WHITE);
		btnPendencias.setBackground(new Color(51, 102, 153));
		btnPendencias.setBounds(475, 10, 115, 25);
		add(btnPendencias);

		btnHistorico.addActionListener(this);
		btnPagamentos.addActionListener(this);
		btnPendencias.addActionListener(this);
		btnOutros.addActionListener(this);
		btnOutros2.addActionListener(this);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String acao = e.getActionCommand();

		System.out.println(acao);

		switch (acao) {
		case "Pendencias":
			remove(panelExibido);
			panelExibido = new PainelFinanceiroContasPagarPendencias();
			add(panelExibido);
			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();
			break;
		
		case "Pagamentos":
			remove(panelExibido);
			panelExibido = new PainelFinanceiroContasPagarPagamentos();

			add(panelExibido);
			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();
			break;
		case "Historico":
			// TODO
			break;
		case "Outro":
			// TODO
			break;
		case "Outro2":
			// TODO
			break;

		default:
			break;
		}

	}
}
