package Painel.Financeiro.Contas.Recebimento;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PanelPrincipalRecebimento extends JPanel implements
		ActionListener {

	private JPanel panelExibido =  new PanelPendencias();

	private JButton btnPendencias;

	private JButton btnRecebimentos;

	private JButton btnHistorico;

	private JButton btnOutro;

	private JButton btnOutro_1;

	/**
	 * Create the frame.
	 */
	public PanelPrincipalRecebimento() {
		this.setBounds(0, 47, 1089, 461);
		this.setLayout(null);
		this.setBackground(new Color(51, 102, 102));
		
		add(panelExibido);
		panelExibido.setLayout(null);

		JLabel lblContasAPagar = new JLabel("CONTAS A RECEBER");
		lblContasAPagar.setForeground(new Color(255, 255, 255));
		lblContasAPagar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContasAPagar.setBounds(50, 10, 345, 25);
		add(lblContasAPagar);
//
//		panelExibido = new JPanel();
//		panelExibido.setBounds(0, 45, 1089, 416);
//		add(panelExibido);
//		panelExibido.setLayout(null);

		JTextArea txtrOGraficoTem = new JTextArea();
		txtrOGraficoTem
				.setText("o grafico tem que ser duas barras \r\numa mostrando as conta e\r\n a outra o dinheiro em ccaixa");
		txtrOGraficoTem.setBounds(63, 74, 304, 225);

		btnPendencias = new JButton("Pendencias");
		btnPendencias.setForeground(Color.WHITE);
		btnPendencias.setBackground(new Color(51, 102, 153));
		btnPendencias.setBounds(475, 10, 115, 25);
		add(btnPendencias);

		btnRecebimentos = new JButton("Recebimentos");
		btnRecebimentos.setForeground(Color.WHITE);
		btnRecebimentos.setBackground(new Color(51, 102, 153));
		btnRecebimentos.setBounds(599, 10, 115, 25);
		add(btnRecebimentos);

		btnHistorico = new JButton("Historico");
		btnHistorico.setForeground(Color.WHITE);
		btnHistorico.setEnabled(false);
		btnHistorico.setBackground(new Color(51, 102, 153));
		btnHistorico.setBounds(719, 10, 115, 25);
		add(btnHistorico);

		btnOutro = new JButton("Outro");
		btnOutro.setForeground(Color.WHITE);
		btnOutro.setEnabled(false);
		btnOutro.setBackground(new Color(51, 102, 153));
		btnOutro.setBounds(844, 10, 115, 25);
		add(btnOutro);

		btnOutro_1 = new JButton("Outro");
		btnOutro_1.setForeground(Color.WHITE);
		btnOutro_1.setEnabled(false);
		btnOutro_1.setBackground(new Color(51, 102, 153));
		btnOutro_1.setBounds(964, 10, 115, 25);
		add(btnOutro_1);
		
		btnHistorico.addActionListener(this);
		btnOutro.addActionListener(this);
		btnOutro_1.addActionListener(this);
		btnPendencias.addActionListener(this);
		btnRecebimentos.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String acao = e.getActionCommand();

		System.out.println(acao);

		switch (acao) {
		case "Pendencias":
			remove(panelExibido);
			panelExibido = new PanelPendencias();
			add(panelExibido);
			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();
			break;
		case "Recebimentos":
			remove(panelExibido);
			panelExibido = new PanelRecebimento();
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
