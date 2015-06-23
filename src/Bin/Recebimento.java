package Bin;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "recebimento")
public class Recebimento {
	
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(columnDefinition = "serial")
		private Integer id;
		@Column(name = "data")
		private Date data;
		@Column(name = "valor")
		private float valor;
		@Column(name = "descricao")
		private String descricao;
		@Column(name = "classificacao")
		private String classificacao;
		@Column(name = "recebido")
		private boolean recebido;
		@Column(name = "id_movimento")
		private Integer idMovimento;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Date getData() {
			return data;
		}
		public void setData(Date data) {
			this.data = data;
		}
		public float getValor() {
			return valor;
		}
		public void setValor(float valor) {
			this.valor = valor;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public String getClassificacao() {
			return classificacao;
		}
		public void setClassificacao(String classificacao) {
			this.classificacao = classificacao;
		}
		public boolean isRecebido() {
			return recebido;
		}
		public void setRecebido(boolean recebido) {
			this.recebido = recebido;
		}
		public Integer getIdMovimento() {
			return idMovimento;
		}
		public void setIdMovimento(Integer idMovimento) {
			this.idMovimento = idMovimento;
		}
		

		
}
