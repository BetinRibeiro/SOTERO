package Painel.Principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.jboss.jandex.Main;

import Janela.Menu.JFrameAuxiliarInformacoes;
import Painel.Cadastro.JPanelMenuCadastro;
import Painel.Comercial.*;
import Painel.Financeiro.JPanelPrincipalFinanceiro;
import Painel.Material.*;
import Painel.Relatorio.*;

@SuppressWarnings("serial")
public class JPanelTeleInicial extends JFrame implements ActionListener {

	// TODO - verificar os tratamentos de exceções, inserssão de numeros e
	// valores não preenchidos

	private JPanel contentPane;

	// botões que estão no listner
	private JButton btnArquivo;
	private JButton btnUsuario;
	private JButton btnEdicao;
	private JButton btnAjuda;
	private JButton btnEstoque;
	private JButton btnClientes;
	private JButton btnFornecedores;
	private JButton btnDespesas;
	private JButton btnPagamentos;
	private JButton btnRecebimentos;
	private JButton btnFuncionarios;
	private JButton btnPropriedades;
	private JButton btnFerramentas;
	private JButton btnProduoEServios;
	private JButton btnComercialEMarketing;
	private JButton btnGerenciaFinanceira;
	private JButton btnMateriaisMovimentacao;
	private JButton btnRecursosHumanos;
	private JButton btnJuridicoLegal;
	private JButton btnRelatoriosContabeis;
	private JButton btnCadastroEAlterao;

	// label data que será modificada quando atualizar
	private JLabel data;

	private JLabel foto;

	private JPanel painelModular;

	private JButton btnInicial;

	private JLabel foto2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
							.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					JPanelTeleInicial frame = new JPanelTeleInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JPanelTeleInicial() {
		setTitle("ALCER SOTERO - Planejamento de recurso corporativo");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 102));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelTopo = new JPanel();
		panelTopo.setBackground(new Color(51, 51, 51));
		panelTopo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTopo.setBounds(2, 2, 1360, 97);
		contentPane.add(panelTopo);
		panelTopo.setLayout(null);

		btnArquivo = new JButton("Arquivo");
		btnArquivo.setEnabled(false);
		btnArquivo.setForeground(new Color(255, 255, 255));
		btnArquivo.setBackground(new Color(51, 102, 153));
		btnArquivo.setBounds(870, 10, 90, 25);
		panelTopo.add(btnArquivo);

		btnUsuario = new JButton("Usuario");
		btnUsuario.setEnabled(false);
		btnUsuario.setForeground(new Color(255, 255, 255));
		btnUsuario.setBackground(new Color(51, 102, 153));
		btnUsuario.setBounds(962, 10, 90, 25);
		panelTopo.add(btnUsuario);

		btnEdicao = new JButton("Edi\u00E7\u00E3o");
		btnEdicao.setEnabled(false);
		btnEdicao.setForeground(new Color(255, 255, 255));
		btnEdicao.setBackground(new Color(51, 102, 153));
		btnEdicao.setBounds(1054, 10, 90, 25);
		panelTopo.add(btnEdicao);

		btnAjuda = new JButton("Ajuda");
		btnAjuda.setForeground(new Color(255, 255, 255));
		btnAjuda.setBackground(new Color(51, 102, 153));
		btnAjuda.setBounds(1145, 10, 90, 25);
		panelTopo.add(btnAjuda);

		btnEstoque = new JButton("Estoque");
		btnEstoque.setForeground(new Color(0, 0, 0));
		btnEstoque.setBackground(new Color(102, 153, 204));
		btnEstoque.setBounds(25, 65, 115, 25);
		panelTopo.add(btnEstoque);

		btnClientes = new JButton("Clientes");
		btnClientes.setForeground(new Color(0, 0, 0));
		btnClientes.setBackground(new Color(102, 153, 204));
		btnClientes.setBounds(139, 65, 115, 25);
		panelTopo.add(btnClientes);

		btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.setForeground(new Color(0, 0, 0));
		btnFornecedores.setBackground(new Color(102, 153, 204));
		btnFornecedores.setBounds(253, 65, 115, 25);
		panelTopo.add(btnFornecedores);

		btnDespesas = new JButton("Despesas");
		btnDespesas.setEnabled(false);
		btnDespesas.setForeground(new Color(0, 0, 0));
		btnDespesas.setBackground(new Color(102, 153, 204));
		btnDespesas.setBounds(367, 65, 115, 25);
		panelTopo.add(btnDespesas);

		btnPagamentos = new JButton("Pagamentos");
		btnPagamentos.setEnabled(false);
		btnPagamentos.setForeground(new Color(0, 0, 0));
		btnPagamentos.setBackground(new Color(102, 153, 204));
		btnPagamentos.setBounds(595, 65, 115, 25);
		panelTopo.add(btnPagamentos);

		btnRecebimentos = new JButton("Recebimentos");
		btnRecebimentos.setEnabled(false);
		btnRecebimentos.setForeground(new Color(0, 0, 0));
		btnRecebimentos.setBackground(new Color(102, 153, 204));
		btnRecebimentos.setBounds(480, 65, 115, 25);
		panelTopo.add(btnRecebimentos);

		btnFuncionarios = new JButton("Colaboradores");
		btnFuncionarios.setEnabled(false);
		btnFuncionarios.setForeground(Color.BLACK);
		btnFuncionarios.setBackground(new Color(102, 153, 204));
		btnFuncionarios.setBounds(710, 65, 115, 25);
		panelTopo.add(btnFuncionarios);

		btnPropriedades = new JButton("Propriedades");
		btnPropriedades.setEnabled(false);
		btnPropriedades.setForeground(Color.BLACK);
		btnPropriedades.setBackground(new Color(102, 153, 204));
		btnPropriedades.setBounds(937, 65, 115, 25);
		panelTopo.add(btnPropriedades);

		btnFerramentas = new JButton("Ferramentas");
		btnFerramentas.setEnabled(false);
		btnFerramentas.setForeground(Color.BLACK);
		btnFerramentas.setBackground(new Color(102, 153, 204));
		btnFerramentas.setBounds(823, 65, 115, 25);
		panelTopo.add(btnFerramentas);

		JPanel panelFuncoes = new JPanel();
		panelFuncoes.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFuncoes.setBounds(2, 100, 260, 579);
		contentPane.add(panelFuncoes);
		panelFuncoes.setLayout(null);

		btnProduoEServios = new JButton("Produ\u00E7\u00E3o e Servi\u00E7os");
		btnProduoEServios.setEnabled(false);
		btnProduoEServios.setForeground(new Color(255, 255, 255));
		btnProduoEServios.setBackground(new Color(0, 0, 51));
		btnProduoEServios.setBounds(10, 196, 240, 25);
		panelFuncoes.add(btnProduoEServios);

		btnComercialEMarketing = new JButton("Comercial e Marketing");
		btnComercialEMarketing.setForeground(new Color(255, 255, 255));
		btnComercialEMarketing.setBackground(new Color(0, 0, 51));
		btnComercialEMarketing.setBounds(10, 84, 240, 25);
		panelFuncoes.add(btnComercialEMarketing);

		btnGerenciaFinanceira = new JButton("Gerencia Financeira");
		btnGerenciaFinanceira.setForeground(new Color(255, 255, 255));
		btnGerenciaFinanceira.setBackground(new Color(0, 0, 51));
		btnGerenciaFinanceira.setBounds(10, 112, 240, 25);
		panelFuncoes.add(btnGerenciaFinanceira);

		btnMateriaisMovimentacao = new JButton("Materiais e Estoque");
		btnMateriaisMovimentacao.setForeground(new Color(255, 255, 255));
		btnMateriaisMovimentacao.setBackground(new Color(0, 0, 51));
		btnMateriaisMovimentacao.setBounds(10, 56, 240, 25);
		panelFuncoes.add(btnMateriaisMovimentacao);

		btnRecursosHumanos = new JButton("Recursos Humanos");
		btnRecursosHumanos.setEnabled(false);
		btnRecursosHumanos.setForeground(new Color(255, 255, 255));
		btnRecursosHumanos.setBackground(new Color(0, 0, 51));
		btnRecursosHumanos.setBounds(10, 140, 240, 25);
		panelFuncoes.add(btnRecursosHumanos);

		btnJuridicoLegal = new JButton("Juridico Legal");
		btnJuridicoLegal.setEnabled(false);

		btnJuridicoLegal.setForeground(new Color(255, 255, 255));
		btnJuridicoLegal.setBackground(new Color(0, 0, 51));
		btnJuridicoLegal.setBounds(10, 224, 240, 25);
		panelFuncoes.add(btnJuridicoLegal);

		btnRelatoriosContabeis = new JButton("Relatorios Contabeis ");
		btnRelatoriosContabeis.setEnabled(false);
		btnRelatoriosContabeis.setForeground(new Color(255, 255, 255));
		btnRelatoriosContabeis.setBackground(new Color(0, 0, 51));
		btnRelatoriosContabeis.setBounds(10, 168, 240, 25);
		panelFuncoes.add(btnRelatoriosContabeis);

		btnCadastroEAlterao = new JButton("Cadastro e Altera\u00E7\u00E3o");
		btnCadastroEAlterao.setForeground(Color.WHITE);
		btnCadastroEAlterao.setBackground(new Color(0, 0, 51));
		btnCadastroEAlterao.setBounds(10, 28, 240, 25);
		panelFuncoes.add(btnCadastroEAlterao);

		btnInicial = new JButton("Retomar ao Inicio");
		btnInicial.setForeground(Color.WHITE);
		btnInicial.setBackground(new Color(0, 0, 51));
		btnInicial.setBounds(10, 2, 240, 25);
		panelFuncoes.add(btnInicial);

		JPanel panelRodape = new JPanel();
		panelRodape.setBackground(new Color(51, 51, 51));
		panelRodape.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelRodape.setBounds(2, 681, 1360, 30);
		contentPane.add(panelRodape);
		panelRodape.setLayout(null);
		
//		setar data no painel principla TODO
		
		Date valorData = new Date() ;
        String dataz = "dd/MM/yyyy";
        SimpleDateFormat formatas = new SimpleDateFormat(dataz );
        String adata = formatas.format(valorData );

		data = new JLabel(adata);
		data.setForeground(new Color(255, 255, 255));
		data.setBounds(15, 9, 94, 14);
		panelRodape.add(data);

		JLabel lblUsbetingmailcom = new JLabel("usbetin@gmail.com");
		lblUsbetingmailcom.setForeground(Color.WHITE);
		lblUsbetingmailcom.setBounds(595, 9, 165, 14);
		panelRodape.add(lblUsbetingmailcom);

		JLabel lblRogobertoRibeiro = new JLabel(
				"Rogoberto Ribeiro - (88) 8817 - 0587 | (88) 9786 - 7735");
		lblRogobertoRibeiro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRogobertoRibeiro.setForeground(Color.WHITE);
		lblRogobertoRibeiro.setBounds(881, 9, 469, 14);
		panelRodape.add(lblRogobertoRibeiro);

		// adicionando actionlistner aos botões
		btnAjuda.addActionListener(this);
		btnArquivo.addActionListener(this);
		btnCadastroEAlterao.addActionListener(this);
		btnClientes.addActionListener(this);
		btnComercialEMarketing.addActionListener(this);
		btnDespesas.addActionListener(this);
		btnEdicao.addActionListener(this);
		btnEstoque.addActionListener(this);
		btnFerramentas.addActionListener(this);
		btnFuncionarios.addActionListener(this);
		btnGerenciaFinanceira.addActionListener(this);
		btnJuridicoLegal.addActionListener(this);
		btnMateriaisMovimentacao.addActionListener(this);
		btnPagamentos.addActionListener(this);
		btnProduoEServios.addActionListener(this);
		btnPropriedades.addActionListener(this);
		btnRecebimentos.addActionListener(this);
		btnRecursosHumanos.addActionListener(this);
		btnRelatoriosContabeis.addActionListener(this);
		btnUsuario.addActionListener(this);
		btnFornecedores.addActionListener(this);
		btnInicial.addActionListener(this);

		painelModular = new JPanel();
		painelModular.setBackground(Color.WHITE);
		painelModular.setBounds(263, 100, 1099, 579);
		// this.setBounds(0, 0, 1099, 579);
		painelModular.setLayout(null);
		contentPane.add(painelModular);

		// imagem no lugar do painel dos modulos
		foto = new JLabel();
		foto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		foto.setBounds(0, 0, 1099, 579);
		ImageIcon imagem = new ImageIcon(
				Main.class.getResource("/Imagens/02.jpg"));
		Image img = imagem.getImage().getScaledInstance(foto.getWidth(),
				foto.getHeight(), Image.SCALE_DEFAULT);
		foto.setIcon(new ImageIcon(img));
		painelModular.add(foto);
		
		foto2 = new JLabel();
		foto2.setBounds(58, 260, 141, 157);
		ImageIcon im = new ImageIcon(
				Main.class.getResource("/Imagens/logo2.png"));
		Image imge = im.getImage().getScaledInstance(foto2.getWidth(),
				foto2.getHeight(), Image.SCALE_DEFAULT);
		foto2.setIcon(new ImageIcon(imge));
		panelFuncoes.add(foto2);
		
		//painelModular.add(new PainelOpcoesPrincipais());

		// ____________________________________________________________________
//		contentPane.remove(painelModular);
//		painelModular = new PainelFinanceiro();
//		getContentPane().add(painelModular);
//		invalidate();
//		validate();
//		repaint();

		// _____________________________________________________________________

		// this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();


		switch (acao) {

		case "Retomar ao Inicio":

			// remove o painel que esta amostra, seta nesse painel o novo e
			// adiciona novamente ao frame principal
			contentPane.remove(painelModular);
			painelModular = new JPanel();
			painelModular.setBackground(Color.WHITE);
			painelModular.setBounds(263, 100, 1099, 579);
			// this.setBounds(0, 0, 1099, 579);
			painelModular.setLayout(null);
			contentPane.add(painelModular);

			painelModular.add(foto);
			getContentPane().add(painelModular);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();

			break;
		case "Clientes":

			// remove o painel que esta amostra, seta nesse painel o novo e
			// adiciona novamente ao frame principal
			contentPane.remove(painelModular);
			painelModular = new JPanelRelatorioCliente();
			getContentPane().add(painelModular);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();
			
			break;

		case "Materiais e Estoque":

			// remove o painel que esta amostra, seta nesse painel o novo e
			// adiciona novamente ao frame principal
			contentPane.remove(painelModular);
			painelModular = new JPanelMaterial();
			getContentPane().add(painelModular);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();

			break;

		case "Comercial e Marketing":

			// remove o painel que esta amostra, seta nesse painel o novo e
			// adiciona novamente ao frame principal
			contentPane.remove(painelModular);
			painelModular = new JPanelVenda();
			getContentPane().add(painelModular);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();

			break;

		case "Gerencia Financeira":

			// remove o painel que esta amostra, seta nesse painel o novo e
			// adiciona novamente ao frame principal
			contentPane.remove(painelModular);
			painelModular = new JPanelPrincipalFinanceiro();
			getContentPane().add(painelModular);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();
			break;

		// _______________________________________________________________

		case "Estoque":
			// remove o painel que esta amostra, seta nesse painel o novo e
			// adiciona novamente ao frame principal
			contentPane.remove(painelModular);
			painelModular = new JPanelRelatorioProduto();
			getContentPane().add(painelModular);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();

			break;

		case "Fornecedores":

			// remove o painel que esta amostra, seta nesse painel o novo e
			// adiciona novamente ao frame principal
			contentPane.remove(painelModular);
			painelModular = new JPanelRelatorioFornecedor();
			getContentPane().add(painelModular);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();
			break;

		case "Cadastro e Alteração":

			// remove o painel que esta amostra, seta nesse painel o novo e
			// adiciona novamente ao frame principal
			contentPane.remove(painelModular);
			painelModular = new JPanelMenuCadastro();
			getContentPane().add(painelModular);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();
			break;

		case "Ajuda":

			// remove o painel que esta amostra, seta nesse painel o novo e
			// adiciona novamente ao frame principal
			JFrameAuxiliarInformacoes j = new JFrameAuxiliarInformacoes();
			j.setVisible(true);

			// parece que só pega com isso aqui nem sei exatamente o porque.
			invalidate();
			validate();
			repaint();

			break;
		}

	}
}
