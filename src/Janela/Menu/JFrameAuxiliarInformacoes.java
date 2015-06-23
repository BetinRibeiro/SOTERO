package Janela.Menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.DebugGraphics;

@SuppressWarnings("serial")
public class JFrameAuxiliarInformacoes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextPane txtpnProduoOuServio;


	/**
	 * Create the dialog.
	 */
	public JFrameAuxiliarInformacoes() {
		setModal(true);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 741, 464);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 705, 371);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		scrollPane.setWheelScrollingEnabled(false);
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane.setBounds(10, 11, 685, 349);
		panel.add(scrollPane);
		
		txtpnProduoOuServio = new JTextPane();
		txtpnProduoOuServio.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtpnProduoOuServio.setEditable(false);
		txtpnProduoOuServio.setText("Determinar o objetivo - miss\u00E3o\r\n\r\nplanejar - estrategia e tatica\r\n\r\npreparar a equipe - mobilizar\r\n\r\nexecutar o plano - diciplina\r\n\r\nevaliar resultados - confirmar, corrigir e aprender\r\n\r\n\r\n\r\nprodu\u00E7\u00E3o ou servi\u00E7o : planejamento e controle de produ\u00E7\u00E3o ou servi\u00E7o, engenharia de produto ou servi\u00E7o, sistema de qualidade e produtividade, custo de produ\u00E7\u00E3o ou servi\u00E7o, manuten\u00E7\u00E3o de maquinas e equipamento, produtos ou servi\u00E7os\r\n\r\nComercial ou marketing : planejamento e gest\u00E3o de marketing, prospect, clientes e consumidores, pedido de vendas, faturamento, gest\u00E3o de vendas, contrato e distribui\u00E7\u00E3o, exporta\u00E7\u00E3o, pesquisa e estat\u00EDstica, \r\n\r\nfinanceira: contas a pagar e receber, movimenta\u00E7\u00E3o bancaria, fluxo de caixa, or\u00E7amento e gest\u00E3o do capital,\r\n\r\nmaterial e log\u00EDstico: fornecedores, compras e suprimentos, estoque, recep\u00E7\u00E3o e expedi\u00E7\u00E3o de materiais, importa\u00E7\u00E3o,\r\n\r\nrecursos humanos: gest\u00E3o pessoal. f\u00E9rias admiss\u00E3o e demiss\u00E3o, folha de pagamento, cargos e sal\u00E1rios, treinamento e desenvolvimento, benef\u00EDcios assistenciais, seguran\u00E7a e medicina no trabalho,\r\n\r\n\r\njur\u00EDdico legal: contabilidade, impostos e recolhimento. ativo fixo e patrim\u00F4nio, livros fiscais de entrada e sa\u00EDda\r\n");
		scrollPane.setViewportView(txtpnProduoOuServio);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Liberar Altera\u00E7\u00F5es");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					txtpnProduoOuServio.setEditable(true);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Sair da janela ");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
