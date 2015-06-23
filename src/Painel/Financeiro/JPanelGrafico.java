package Painel.Financeiro;

import java.util.List;

import javax.swing.JPanel;

import org.hibernate.engine.jndi.JndiException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import Bin.Caixa;
import Bin.Cliente;
import Bin.Fornecedor;
import Persistence.DAO;

import javax.swing.border.LineBorder;

import java.awt.Color;

@SuppressWarnings("serial")
public class JPanelGrafico extends JPanel {

	DAO banco = new DAO();
	float totalCaixa = 0;
	float totalPagamentos = 0;
	float totalRecebimentos = 0;

	public JPanelGrafico() {

		setBounds(0, 0, 444, 394);

		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

		somaPagamentos();

		somaRecebimentos();

		@SuppressWarnings("unchecked")
		List<Caixa> a = (List<Caixa>) banco.listarObjetos(Caixa.class, "id");
		Integer ultimaPosicao = a.size();
		Integer IdCaixa = a.get(ultimaPosicao - 1).getId();

		Caixa cx = (Caixa) banco.buscarPorId(Caixa.class, IdCaixa);

		totalCaixa = cx.getValor();

		dataSet.setValue(totalPagamentos, "Contas à pagar", "Divida");
		dataSet.setValue(totalRecebimentos, "Contas à receber", "Recebimento");
		dataSet.setValue(totalCaixa, "Dinheiro em Caixa", "Dinheiro");

		JFreeChart grafico = ChartFactory.createBarChart3D("Contas e Caixa",
				"Parametros", "Valores", dataSet, PlotOrientation.VERTICAL,
				true, true, false);
		setLayout(null);

		ChartPanel chartPanel = new ChartPanel(grafico);
		chartPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		chartPanel.setBounds(0, 0, 444, 394);

		add(chartPanel);

	}

	private void somaRecebimentos() {
		List<?> lista = banco.listarObjetos(Cliente.class, "nome");
		for (int i = 0; i < lista.size(); i++) {

			Cliente cliente = (Cliente) lista.get(i);
			if (cliente.getDivida() > 0) {
				totalRecebimentos = totalRecebimentos + cliente.getDivida();
			}

		}

	}

	private void somaPagamentos() {
		try {

		} catch (JndiException e) {
			System.out.println("ERRO HIBERNATE - " + e);
		}
		List<?> lista = banco.listarObjetos(Fornecedor.class, "id");
		for (int i = 0; i < lista.size(); i++) {

			Fornecedor fornecedor = (Fornecedor) lista.get(i);
			if (fornecedor.getDebito() > 0) {
				totalPagamentos = totalPagamentos + fornecedor.getDebito();
			}

		}
	}

}
