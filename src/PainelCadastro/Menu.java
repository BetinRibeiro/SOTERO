package PainelCadastro;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;





@SuppressWarnings("serial")
public class Menu extends JPanel implements ActionListener {
	//TODO - verificar os tratamentos de exceções, inserssão de numeros e valores não preenchidos
	
	JPanel painelEspecifico =  new CadastroProduto();

	/**
	 * Create the panel.
	 */

	public Menu() {

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
				"CADASTRO E ALTERA\u00C7\u00C3O");
		lblCadastroEAlterao.setForeground(new Color(255, 255, 255));
		lblCadastroEAlterao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastroEAlterao.setBounds(21, 11, 328, 32);
		panel.add(lblCadastroEAlterao);

		JButton btnFornecedor = new JButton("Fornecedor");
		btnFornecedor.setForeground(new Color(255, 255, 255));
		btnFornecedor.setBackground(new Color(51, 102, 153));
		btnFornecedor.setBounds(420, 15, 115, 25);
		panel.add(btnFornecedor);

		JButton btnProduto = new JButton("Produto");
		btnProduto.setForeground(new Color(255, 255, 255));
		btnProduto.setBackground(new Color(51, 102, 153));
		btnProduto.setBounds(300, 15, 115, 25);
		panel.add(btnProduto);

		JButton btnFerramenta = new JButton("Ferramenta");
		btnFerramenta.setEnabled(false);
		btnFerramenta.setForeground(new Color(255, 255, 255));
		btnFerramenta.setBackground(new Color(51, 102, 153));
		btnFerramenta.setBounds(780, 15, 115, 25);
		panel.add(btnFerramenta);

		JButton btnPropriedade = new JButton("Propriedade");
		btnPropriedade.setEnabled(false);
		btnPropriedade.setForeground(new Color(255, 255, 255));
		btnPropriedade.setBackground(new Color(51, 102, 153));
		btnPropriedade.setBounds(660, 15, 115, 25);
		panel.add(btnPropriedade);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setForeground(Color.WHITE);
		btnCliente.setBackground(new Color(51, 102, 153));
		btnCliente.setBounds(540, 15, 115, 25);
		panel.add(btnCliente);
		
		JButton btnColaborador = new JButton("Colaborador");
		btnColaborador.setEnabled(false);
		btnColaborador.setForeground(Color.WHITE);
		btnColaborador.setBackground(new Color(51, 102, 153));
		btnColaborador.setBounds(900, 15, 115, 25);
		panel.add(btnColaborador);

		// colocando actionlistener em cada botaão
		btnFerramenta.addActionListener(this);
		btnPropriedade.addActionListener(this);
		btnFornecedor.addActionListener(this);
		btnProduto.addActionListener(this);
		btnCliente.addActionListener(this);
		btnColaborador.addActionListener(this);
		
//		foto = new JLabel();
//		foto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//		foto.setBounds(0, 0, 1099, 579);
//		ImageIcon imagem = new ImageIcon(
//				Main.class.getResource("/Imagens/engrenagem.jpeg"));
//		Image img = imagem.getImage().getScaledInstance(foto.getWidth(),
//				foto.getHeight(), Image.SCALE_DEFAULT);
//		foto.setIcon(new ImageIcon(img));
//		painelEspecifico.setBounds(0, 48, 1099, 530);
//		painelEspecifico.add(foto);
		
		this.add(painelEspecifico);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		//this.remove(foto);

		switch (acao) {
		case "Fornecedor":
			remove(painelEspecifico);
			painelEspecifico = new CadastroFornecedor();
			add(painelEspecifico);
			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint(); 

			break;

		case "Produto":
			remove(painelEspecifico);
			painelEspecifico = new CadastroProduto();
			add(painelEspecifico);
			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();
			break;

		case "Cliente":
			remove(painelEspecifico);
			painelEspecifico = new CadastroCliente();
			add(painelEspecifico);
			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint(); 
			break;
		case "Propriedade":
			//TODO 
			break;
		default:
			break;
		}

	}
}
