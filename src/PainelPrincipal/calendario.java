package PainelPrincipal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

@SuppressWarnings("serial")
public class calendario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calendario frame = new calendario();
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
	public calendario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JCalendar calendario = new JCalendar();
		calendario.setWeekOfYearVisible(false);
		contentPane.add(calendario);
		pack();
		
		
		Calendar calend = calendario.getCalendar();
		
		
		System.out.println(calend.getTime());
		dispose();
		JPanel painel = new JPanel();
		painel.setVisible(true);
		contentPane.add(painel);
		
				
				//new java.sql.Date(new java.util.Date().getTime());
		
		
	}

}
