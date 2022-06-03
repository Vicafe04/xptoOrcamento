package control;

import java.util.ArrayList;

import dao.OrcamentoDAO;
import model.Orcamento;

public class OrcamentoProcess {
	
	public static ArrayList<Orcamento> orcamentos = new ArrayList<>();
	private static OrcamentoDAO od = new OrcamentoDAO();
	
	public static void abrir() {
		orcamentos = od.ler();
		if(orcamentos.size() == 0) {
			orcamentos.add(new Orcamento());
		}
	}
	
	public static void salvar() {
		od.escrever(orcamentos);
	}

}
