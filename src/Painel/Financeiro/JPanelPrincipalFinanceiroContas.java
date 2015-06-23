package Painel.Financeiro;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Painel.Financeiro.Contas.Pagamento.JPanelPrincipalPagamento;
import Painel.Financeiro.Contas.Recebimento.JPanelPrincipalRecebimento;
import Persistence.DAO;

@SuppressWarnings("serial")
public class JPanelPrincipalFinanceiroContas extends JPanel implements ActionListener {
	JPanel painelEspecifico = new JPanelPrincipalRecebimento();
	// TODO - verificar os tratamentos de exceções, inserssão de numeros e
	// valores não preenchidos

	DAO dao = new DAO();

	private JButton btnPagar;

	private JButton btnReceber;

	/**
	 * Create the panel.
	 */
	public JPanelPrincipalFinanceiroContas() {
		setBackground(new Color(51, 51, 51));
		this.setBounds(10, 60, 1089, 508);
		this.setLayout(null);

		JPanel panel = painelEspecifico;
		panel.setBounds(0, 47, 1089, 461);
		add(panel);
		panel.setLayout(null);

		JLabel lblCadastroCliente = new JLabel("CONTAS FINANCEIRAS");
		lblCadastroCliente.setForeground(Color.WHITE);
		lblCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastroCliente.setBounds(10, 11, 345, 25);
		add(lblCadastroCliente);

		btnReceber = new JButton("Receber");
		btnReceber.setForeground(Color.BLACK);
		btnReceber.setBackground(new Color(102, 153, 204));
		btnReceber.setBounds(964, 12, 115, 25);
		add(btnReceber);

		btnPagar = new JButton("Pagar");
		btnPagar.setForeground(Color.BLACK);
		btnPagar.setBackground(new Color(102, 153, 204));
		btnPagar.setBounds(842, 12, 115, 25);
		add(btnPagar);

		btnPagar.addActionListener(this);
		btnReceber.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		System.out.println(acao);

		switch (acao) {
		case "Pagar":
			try {

				remove(painelEspecifico);
				painelEspecifico = new JPanelPrincipalPagamento();
				add(painelEspecifico);

				// parece que só pega com isso aqui nem sei exatamente o porque.
				invalidate();
				validate();
				repaint();

				break;
			} catch (Exception e2) {
				System.out.println("Erro " + e2);
				JOptionPane.showMessageDialog(null, "Erro - " + e2);
			}

		case "Receber":
			try {
				remove(painelEspecifico);
				painelEspecifico = new JPanelPrincipalRecebimento();
				add(painelEspecifico);

				// parece que só pega com isso aqui nem sei exatamente o porque.
				invalidate();
				validate();
				repaint();

				break;
			} catch (Exception e2) {
				System.out.println("Erro " + e2);
				JOptionPane.showMessageDialog(null, "Erro - " + e2);
			}

		default:
			break;
		}

	}

}
