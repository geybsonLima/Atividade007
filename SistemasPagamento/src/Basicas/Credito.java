package Basicas;
import java.util.Date;

public class Credito {
	
	private int codigoCredito;
	private double valorCrédito;
	private String nomeCliente;
	private Date dataEmissao;
	
	
	public int getCodigoCredito() {
		return codigoCredito;
	}
	public void setCodigoCredito(int codigoCredito) {
		this.codigoCredito = codigoCredito;
	}
	public double getValorCrédito() {
		return valorCrédito;
	}
	public void setValorCrédito(double valorCrédito) {
		this.valorCrédito = valorCrédito;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Date getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

}
