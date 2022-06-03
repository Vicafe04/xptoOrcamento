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
}