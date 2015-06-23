package ViewPrincipal;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modelTabela.ModelClienteCadastro;

import org.jboss.jandex.Main;

import Bin.Cliente;
import Persistence.Banco;

@SuppressWarnings("serial")
public class PainelOpcoesPrincipais extends JPanel {
	
	ModelClienteCadastro model = new ModelClienteCadastro();

	private Banco dao=new Banco();

	private JLabel foto;

	private JLabel foto1;

private JLabel foto2;

private JLabel foto3;

	/**
	 * Create the panel.
	 */

	public PainelOpcoesPrincipais() {

		this.setBounds(0, 0, 1099, 579);
		// this.setBounds(0, 0, 1099, 579);
		this.setLayout(null);
		// this.add(new CadastroCliente());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 102));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(0, 0, 1099, 54);
		add(panel);
		panel.setLayout(null);
		
		foto = new JLabel();
		foto.setBounds(75, 150, 100, 110);
		ImageIcon imagem = new ImageIcon(
				Main.class.getResource("/Imagens/CadastroCliente.png"));
		Image img = imagem.getImage().getScaledInstance(foto.getWidth(),
				foto.getHeight(), Image.SCALE_DEFAULT);
		foto.setIcon(new ImageIcon(img));
		add(foto);
		
		foto1 = new JLabel();
		foto1.setBounds(825, 150, 100, 110);
		ImageIcon imagem1 = new ImageIcon(
				Main.class.getResource("/Imagens/CadastroFornecedor.png"));
		Image img1 = imagem1.getImage().getScaledInstance(foto1.getWidth(),
				foto1.getHeight(), Image.SCALE_DEFAULT);
		foto1.setIcon(new ImageIcon(img1));
		add(foto1);
		
		foto2 = new JLabel();
		foto2.setBounds(575, 150, 100, 110);
		ImageIcon imagem2 = new ImageIcon(
				Main.class.getResource("/Imagens/CadastroProduto.png"));
		Image img2 = imagem2.getImage().getScaledInstance(foto2.getWidth(),
				foto2.getHeight(), Image.SCALE_DEFAULT);
		foto2.setIcon(new ImageIcon(img2));
		add(foto2);
		
		foto3 = new JLabel();
		foto3.setBounds(301, 150, 100, 110);
		ImageIcon imagem3 = new ImageIcon(
				Main.class.getResource("/Imagens/CadastroFuncionario.png"));
		Image img3 = imagem3.getImage().getScaledInstance(foto3.getWidth(),
				foto3.getHeight(), Image.SCALE_DEFAULT);
		foto3.setIcon(new ImageIcon(img3));
		add(foto3);
		
		JLabel lblCadastroCliente = new JLabel("Cadastro Cliente");
		lblCadastroCliente.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCadastroCliente.setBounds(63, 271, 182, 27);
		add(lblCadastroCliente);
		
		JLabel lblCadastroFuncionario = new JLabel("Cadastro Funcionario");
		lblCadastroFuncionario.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCadastroFuncionario.setBounds(280, 271, 232, 27);
		add(lblCadastroFuncionario);
		
		JLabel lblCadastroProduto = new JLabel("Cadastro Produto");
		lblCadastroProduto.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCadastroProduto.setBounds(565, 271, 182, 27);
		add(lblCadastroProduto);
		
		JLabel lblCadastroFornecedor = new JLabel("Cadastro Fornecedor");
		lblCadastroFornecedor.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCadastroFornecedor.setBounds(800, 271, 232, 27);
		add(lblCadastroFornecedor);
	}
	}

		
		

	
