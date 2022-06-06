package control;

import java.util.ArrayList;

import dao.OrcamentoDAO;
import model.Orcamento;

public class OrcamentoProcess {
	
	public static ArrayList<Orcamento> orcamentos = new ArrayList<>();
	private static OrcamentoDAO od = new OrcamentoDAO();
	
	public static void abrir() {
		orcamentos = od.ler();
	}
	
	public static void salvar() {
		od.escrever(orcamentos);
	}
	
	public static void carregar() {
		orcamentos = new ArrayList<>();

	}

	public static void compararProdutos(String tfProduto) {
		int aux = 0;
		double valor = 999999999;
		for (Orcamento orcamento : orcamentos) {
			if (orcamento.getProduto().equals(tfProduto) && orcamento.getPreco() < valor) {
			aux = orcamentos.indexOf(orcamento);
			valor = orcamento.getPreco();
			}
		}
		
		for (Orcamento orcamento : orcamentos) {
			if (orcamentos.indexOf(orcamento) == aux) {
				orcamento.setMaisBarato(true);
			} else if(orcamento.getProduto() == tfProduto){
				orcamento.setMaisBarato(false);
			}
		}
		
	}
}