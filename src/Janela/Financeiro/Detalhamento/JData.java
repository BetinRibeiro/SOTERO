package Janela.Financeiro.Detalhamento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import Bin.Recebimento;
import Persistence.DAO;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JData extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JCalendar calendario;
	private JButton cancelButton;


	public JData(final Recebimento recebimento) {
		
		
		
		setBounds(100, 100, 361, 258);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setModal(true);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{

			calendario = new JCalendar();
			calendario.setWeekOfYearVisible(false);
			contentPanel.add(calendario);
			
			pack();
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						long n = calendario.getDate().getTime();
						recebimento.setData( new Date(n));
						
						DAO banco = new DAO();
						banco.salvarOuAtualizarObjeto(recebimento);
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Data modificada com sucesso!!");
						//setVisible(true);
						//dispose();
						cancelButton.setText("Sair");
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
