package Painel.Comercial;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Painel.Cadastro.JPanelCadastroCliente;


@SuppressWarnings("serial")
public class JPanelMenu extends JPanel implements ActionListener {
	JPanel painelEspecifico = new JPanelVenda();

	/**
	 * Create the panel.
	 */

	public JPanelMenu() {
		

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

		JLabel lblCadastroEAlterao = new JLabel(
				"COMERCIAL E MARKETING");
		lblCadastroEAlterao.setForeground(new Color(255, 255, 255));
		lblCadastroEAlterao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastroEAlterao.setBounds(21, 11, 328, 32);
		panel.add(lblCadastroEAlterao);

		JButton btnVenda = new JButton("Venda");
		btnVenda.setForeground(new Color(255, 255, 255));
		btnVenda.setBackground(new Color(51, 102, 153));
		btnVenda.setBounds(300, 15, 115, 25);
		panel.add(btnVenda);

		JButton btnCompra = new JButton("Cliente");
		btnCompra.setForeground(new Color(255, 255, 255));
		btnCompra.setBackground(new Color(51, 102, 153));
		btnCompra.setBounds(420, 15, 115, 25);
		panel.add(btnCompra);

		JButton btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.setEnabled(false);
		btnPesquisa.setForeground(new Color(255, 255, 255));
		btnPesquisa.setBackground(new Color(51, 102, 153));
		btnPesquisa.setBounds(660, 15, 115, 25);
		panel.add(btnPesquisa);

		JButton btnAtendimento = new JButton("Atendimento");
		btnAtendimento.setEnabled(false);
		btnAtendimento.setForeground(new Color(255, 255, 255));
		btnAtendimento.setBackground(new Color(51, 102, 153));
		btnAtendimento.setBounds(780, 15, 115, 25);
		panel.add(btnAtendimento);
		
		JButton btnhistorico = new JButton("Historico");
		btnhistorico.setEnabled(false);
		btnhistorico.setForeground(Color.WHITE);
		btnhistorico.setBackground(new Color(51, 102, 153));
		btnhistorico.setBounds(540, 15, 115, 25);
		panel.add(btnhistorico);
		
		JButton btnVendedores = new JButton("Vendedores");
		btnVendedores.setEnabled(false);
		btnVendedores.setForeground(Color.WHITE);
		btnVendedores.setBackground(new Color(51, 102, 153));
		btnVendedores.setBounds(900, 15, 115, 25);
		panel.add(btnVendedores);

		// colocando actionlistener em cada botaão
		btnPesquisa.addActionListener(this);
		btnAtendimento.addActionListener(this);
		btnVenda.addActionListener(this);
		btnCompra.addActionListener(this);
		btnhistorico.addActionListener(this);
		btnVendedores.addActionListener(this);
		
		this.add(painelEspecifico);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		

		switch (acao) {
		case "Cliente":
			remove(painelEspecifico);
			painelEspecifico = new JPanelCadastroCliente();
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint(); 
			break;
		case "Venda":
			remove(painelEspecifico);
			painelEspecifico = new JPanelVenda();
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint(); 
			break;
			
			
		case "Historico":
			JOptionPane.showMessageDialog(null, "Falta a implementação, analise de desempenho!!");
			remove(painelEspecifico);
			//painelEspecifico = new BalancoProduto();
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint(); 
			break;
		
		case "Pesquisa":
			JOptionPane.showMessageDialog(null, "Falta a implementação, analise de mercado!!");
			//TODO - implementar
			remove(painelEspecifico);
			//painelEspecifico = new CadastroFornecedor();
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint(); 
			break;
		case "Atendimento":
			JOptionPane.showMessageDialog(null, "Falta a implementação, atendimento ao cliente!!");
			//TODO - implementar
			remove(painelEspecifico);
			//painelEspecifico = new lista ajuste de estoque entradas e saidas que não sao compras nem vendas;
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint(); 
			break;
		case "Vendedores":
			JOptionPane.showMessageDialog(null, "Falta a implementação, analise de desempenho!!");
			//TODO - implementar
			remove(painelEspecifico);
			//painelEspecifico = new CadastroProduto();
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
