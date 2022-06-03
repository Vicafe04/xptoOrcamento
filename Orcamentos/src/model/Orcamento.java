package model;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;

public class Orcamento {
	
	private int id;
	private String fornecedor, produto;
	private double preco;
	private boolean maisBarato;
	
	private final Locale BRASIL = new Locale("pt", "BR");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private DecimalFormat df = new DecimalFormat("#.00");

	public Orcamento(int id) {
		this.id = id;
	}

	public Orcamento(int id, String fornecedor, String produto, double preco, boolean maisBarato) {
		this.id = id;
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.preco = preco;
		this.maisBarato = maisBarato;
	}
	
	public Orcamento(String linha) {
		df.setCurrency(Currency.getInstance(BRASIL));
		this.id = Integer.parseInt(linha.split(";")[0]);
		this.fornecedor = linha.split(";")[1];
		this.produto = linha.split(";")[2];
		try {
			this.preco = Double.parseDouble(df.parse(linha.split(";")[3]).toString());
		} catch (ParseException e) {
			System.out.println(e);
		}
		this.maisBarato =  Boolean.parseBoolean(linha.split(";")[4]);
	}
	
	public int getId() {
		return id;
	}
	
	public String getId(String s) {
		return String.format("%d", id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isMaisBarato() {
		return maisBarato;
	}

	public void setMaisBarato(boolean maisBarato) {
		this.maisBarato = maisBarato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fornecedor, id, maisBarato, preco, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orcamento other = (Orcamento) obj;
		return Objects.equals(fornecedor, other.fornecedor) && id == other.id && maisBarato == other.maisBarato
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco)
				&& Objects.equals(produto, other.produto);
	}

}
