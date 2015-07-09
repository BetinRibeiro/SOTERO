package Funcoes;

public class Funcoes {

	// calculo da mercadoria vendida
	public float cmv(float eI, float c, float eF) {
		// EI - Estoque inicial de mercadorias
		// c - compras liquidas no periodo
		// EF - estoque final de mercadoria no periodo
		return eI + c - eF;
		// compras deduzidas dos impostos das devoluções de compras e
		// abatimentos
	}

	// Custo de produto vendido
	public float cpv(float cip, float cpp, float cpa) {
		// cip - Custo incorrido na produçao
		// cpp - custo produção no periodo
		// cpa - custo produtos acabados no periodo
		return cip + cpp - cpa;
	}

	// Custo ocorrido na produção
	public float cip(float materiaPrimaDireta, float maoDeObraDireta,
			float custoindiretoProducao) {
		return materiaPrimaDireta + maoDeObraDireta + custoindiretoProducao;

	}

	// custo produção
	public float cpp(float eIProdEmElaboracao, float eFProdEmElaboracao) {
		// as variaveis prod = produtos
		return eIProdEmElaboracao - eFProdEmElaboracao;
	}

	// Custo de produção acabado no periodo
	public float cpa(float eIProdAcabados, float eFProdAcabados) {
		// as variaveis prod = produtos
		return eIProdAcabados - eFProdAcabados;
	}

	// Resultado financeiro Liquido
	public float rfl(float receitaFinanceira, float despesaFinanceira) {
		return receitaFinanceira - despesaFinanceira;
	}

	public float numeroIndice(float vlrAnoSeguinte, float vltAno, float base) {
		// multiplicado por 100 para ver percentual
		return (vlrAnoSeguinte / (vltAno - base)) * 100;
	}

	public float participacaoCapitaisTerceirosEndividamento(
			float capitalTerceiro, float passivoTotal) {
		return (capitalTerceiro / passivoTotal) * 100;
	}

	public float composicaoEndividamento(float passivoCirculante,
			float capitalTercero) {
		return (passivoCirculante / capitalTercero) * 100;
	}

	public float imobilizacaoPatrimonioLiquido(float ativoPermanente,
			float patromonioLiquido) {
		return (ativoPermanente / patromonioLiquido) * 100;
	}

	public float imobilizacaoRecursosNaoCorrentes(float patrimonioLiquido,
			float ativoPermanente, float exigivelLongoPraso) {
		return (ativoPermanente / (patrimonioLiquido + exigivelLongoPraso)) * 100;
	}

	public float liquidezSeca(float ativoCirculante, float estoques,
			float passivoCirculante) {
		return (ativoCirculante - estoques) / passivoCirculante;
	}

	public float liquidezCorrente(float ativoCirculante, float passivoCirculante) {
		return ativoCirculante / passivoCirculante;
	}

	public float liquidezGeral(float ativoCirculante, float passivoCirculante,
			float exigivelLongoPraso, float realizavelLongoPraso) {
		return (ativoCirculante + realizavelLongoPraso)
				/ (passivoCirculante + exigivelLongoPraso);
	}

	public float giroDoAtivo(float vendasLiquidas, float ativoTotal) {
		return vendasLiquidas / ativoTotal;
	}

	public float margemLiquida(float lucroLiquido, float vendasLiquidas) {
		return lucroLiquido / vendasLiquidas * 100;
	}

	public float rentabilidadeDoAtivo(float lucroLiquido, float ativoLiquido) {
		return lucroLiquido / ativoLiquido * 100;
	}

	public float rentabilidadeDoPatrimonioLiquido(float lucroLiquido,
			float patromonioLiquidoMedio) {
		return lucroLiquido / patromonioLiquidoMedio * 100;
	}

	public float financiamentoDeAtivo(float emprestimosEfinanciamentos,
			float ativoTotal) {
		return emprestimosEfinanciamentos / ativoTotal * 100;
	}

	public float participacaoInstituicoesDeCreditoNoFinanciamento(
			float financiamentos, float capitalDeTerceiros) {
		return financiamentos / capitalDeTerceiros * 100;
	}

	public float financiamentoDoAtivoCirculantePorInstituicoesFinanceiras(
			float financiamentoCurtoPraso, float ativoCirculante) {
		return financiamentoCurtoPraso / ativoCirculante * 100;
	}

	public float duplicatasDescontadas(float duplicatasDescontadas,
			float duplicatasAReceber) {
		return duplicatasDescontadas / duplicatasAReceber * 100;
	}

	public float giro(float vendasLiquidas, float ativoTotal) {
		return vendasLiquidas / ativoTotal;
	}

	public float margemLucro(float lucroLiquido, float vendasLiquidas) {
		return lucroLiquido / vendasLiquidas * 100;
	}

	public float taxaRetorno(float giroDoAtivo, float margemDeLucro) {
		return giroDoAtivo * margemDeLucro;
	}

	public float ativoLiquido(float ativoTotal, float passivoOperacional) {
		return ativoTotal - passivoOperacional;
	}

	public float lucro(float lucroLiquido, float despesasFinanceiras) {
		return lucroLiquido + despesasFinanceiras;
	}

	public float vendasLiquidas(float vendasBrutas,
			float devolucoesECancelamentos) {
		return vendasBrutas - devolucoesECancelamentos;
	}

	public float rentabilidadeDoAtivo(float vendasLiquidas, float ativoLiquido,
			float lucro) {
		return vendasLiquidas / ativoLiquido * lucro / vendasLiquidas;
	}

	public float necessidadeDeCapitalDeGiro(float ativoCirculanteOperacional,
			float passivoCirculanteOperacional) {
		return ativoCirculanteOperacional - passivoCirculanteOperacional;
	}

	public float financiamentoDoCapitalCirculanteLiquido(
			float exigivelALongoPraso, float PatrimonioLiquido,
			float realizavelALongoPraso, float ativoPermanente) {
		return (exigivelALongoPraso + PatrimonioLiquido)
				- (realizavelALongoPraso + ativoPermanente);
	}

	public float prasoMedioDeRotacaoDoEstoque(float estoque,
			float custoMercadoriaVendida, float diasDoPeriodo) {
		return (estoque / custoMercadoriaVendida) * diasDoPeriodo;
	}

	public float prasoMedioRecebimentoVendas(float duplicatasReceber,
			float receitaBrutaVendas, float diasDoPeriodo) {
		return (duplicatasReceber / receitaBrutaVendas) * diasDoPeriodo;
	}

	public float prasoMedioPagamentoDeCompras(
			float mediaValoresPagosFornecedores, float compras,
			float diasDoPeriodo) {
		return (mediaValoresPagosFornecedores / compras) * diasDoPeriodo;
	}

	public float cicliOperacional(float prasoMedioDeRotacaoDoEstoque,
			float prasoMedioRecebimentoVendas) {
		return prasoMedioDeRotacaoDoEstoque + prasoMedioRecebimentoVendas;
	}

	public float cicloCaixaCicloFinanceiro(float prasoMedioDeRotacaoDoEstoque,
			float prasoMedioRecebimentoVendas,
			float prasoMedioPagamentoDeCompras) {
		return prasoMedioDeRotacaoDoEstoque + prasoMedioRecebimentoVendas
				- prasoMedioPagamentoDeCompras;
	}

	public float cicloCaixaCicloFinanceiro(float cicloMedioOperacional,
			float prasoMedioPagamentoDeCompras) {
		return cicloMedioOperacional - prasoMedioPagamentoDeCompras;
	}

	public float custoMercadoriaVendida(float estoqueInicial, float compras,
			float estoqueFinal) {
		return estoqueInicial + compras - estoqueFinal;
	}

	public float capitalDeGiro(float ativoCirculante, float passivoCirculante) {
		return ativoCirculante - passivoCirculante;
	}

}
