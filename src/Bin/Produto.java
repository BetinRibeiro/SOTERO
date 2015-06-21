package Bin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//aqui explica que essa classe diz respeito a uma entidade
//define o mesmo nome que estara no banco de dados
@Entity
@Table(name = "produto")
public class Produto {
	// a chame primaria da tabela
	// valor gerado automaticamente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "localizacao")
	private String localizacao;

	@Column(name = "estoquemin")
	private float estoqueMin;

	@Column(name = "quantidade")
	private float quantidade;

	@Column(name = "custo")
	private float custo;

	@Column(name = "preco")
	private float preco;

	@Column(name = "classificacao")
	private String classificacao;
	

	@Column(name = "habilitado")
	private Boolean habilitado;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getLocalizacao() {
		return localizacao;
	}


	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}


	public float getEstoqueMin() {
		return estoqueMin;
	}


	public void setEstoqueMin(float estoqueMin) {
		this.estoqueMin = estoqueMin;
	}


	public float getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}


	public float getCusto() {
		return custo;
	}


	public void setCusto(float custo) {
		this.custo = custo;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public String getClassificacao() {
		return classificacao;
	}


	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}


	public Boolean getHabilitado() {
		return habilitado;
	}


	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	
	


}
