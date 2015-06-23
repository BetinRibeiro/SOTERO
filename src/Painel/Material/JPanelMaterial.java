package Painel.Material;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import Painel.Cadastro.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JPanelMaterial extends JPanel implements ActionListener {
	JPanel painelEspecifico = new JPanelCompraProduto();

	/**
	 * Create the panel.
	 */

	public JPanelMaterial() {
		
		//TODO - verificar os tratamentos de exceções, inserssão de numeros e valores não preenchidos

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
				"MATERIAL E MOVIMENTA\u00C7\u00C3O");
		lblCadastroEAlterao.setForeground(new Color(255, 255, 255));
		lblCadastroEAlterao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastroEAlterao.setBounds(21, 11, 328, 32);
		panel.add(lblCadastroEAlterao);

		JButton btnVenda = new JButton("Venda");
		btnVenda.setEnabled(false);
		btnVenda.setForeground(new Color(255, 255, 255));
		btnVenda.setBackground(new Color(51, 102, 153));
		btnVenda.setBounds(420, 15, 115, 25);
		panel.add(btnVenda);

		JButton btnCompra = new JButton("Compra");
		btnCompra.setForeground(new Color(255, 255, 255));
		btnCompra.setBackground(new Color(51, 102, 153));
		btnCompra.setBounds(300, 15, 115, 25);
		panel.add(btnCompra);

		JButton btnAjuste = new JButton("Ajuste");
		btnAjuste.setEnabled(false);
		btnAjuste.setForeground(new Color(255, 255, 255));
		btnAjuste.setBackground(new Color(51, 102, 153));
		btnAjuste.setBounds(660, 15, 115, 25);
		panel.add(btnAjuste);

		JButton btnFornecedor = new JButton("Fornecedor");
		btnFornecedor.setForeground(new Color(255, 255, 255));
		btnFornecedor.setBackground(new Color(51, 102, 153));
		btnFornecedor.setBounds(780, 15, 115, 25);
		panel.add(btnFornecedor);
		
		JButton btnBalanco = new JButton("Balan\u00E7o");
		btnBalanco.setForeground(Color.WHITE);
		btnBalanco.setBackground(new Color(51, 102, 153));
		btnBalanco.setBounds(540, 15, 115, 25);
		panel.add(btnBalanco);
		
		JButton btnProduto = new JButton("Produto");
		btnProduto.setForeground(Color.WHITE);
		btnProduto.setBackground(new Color(51, 102, 153));
		btnProduto.setBounds(900, 15, 115, 25);
		panel.add(btnProduto);

		// colocando actionlistener em cada botaão
		btnAjuste.addActionListener(this);
		btnFornecedor.addActionListener(this);
		btnVenda.addActionListener(this);
		btnCompra.addActionListener(this);
		btnBalanco.addActionListener(this);
		btnProduto.addActionListener(this);
		
		this.add(painelEspecifico);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		

		switch (acao) {
		case "Compra":
			remove(painelEspecifico);
			painelEspecifico = new JPanelCompraProduto();
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint(); 
			break;
		case "Balan\u00E7o":
			remove(painelEspecifico);
			painelEspecifico = new JPanelBalancoProduto();
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint(); 
			break;
		case "Venda":
			JOptionPane.showMessageDialog(null, "Falta a implementação!!");
			//TODO - implementar
			remove(painelEspecifico);
			//painelEspecifico = new lista das vendas dar baixa quando entregar a mercadoria saida do estoque;
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint(); 
			break;
		case "Fornecedor":
			//TODO - implementar
			remove(painelEspecifico);
			painelEspecifico = new JPanelCadastroFornecedor();
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint(); 
			break;
		case "Ajuste":
			JOptionPane.showMessageDialog(null, "Falta a implementação!!");
			//TODO - implementar
			remove(painelEspecifico);
			//painelEspecifico = new lista ajuste de estoque entradas e saidas que não sao compras nem vendas;
			add(painelEspecifico);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint(); 
			break;
		case "Produto":
			//TODO - implementar
			remove(painelEspecifico);
			painelEspecifico = new JPanelCadastroProduto ();
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
