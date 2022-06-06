package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Orcamento;

public class OrcamentoDAO {
	
	private BufferedReader br;
	private BufferedWriter bw;
	private String path = "C:\\Users\\DESENVOLVIMENTO\\Desktop\\Orcamentos\\data\\Orcamento.csv";
	
	public ArrayList<Orcamento> ler() {
		ArrayList<Orcamento> linhas = new ArrayList<>();
		Orcamento o;
		try {
			br = new BufferedReader(new FileReader(path));
			String linha = br.readLine();
			while(linha != null) {
				o = new Orcamento(linha);
				linhas.add(o);
				linha = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo n�o encontrado."+e);
		} catch (IOException e) {
			System.out.println("Arquivo provavelmente est� aberto."+e);
		}
		return linhas;
	}

	public void escrever (ArrayList<Orcamento> linhas) {
		try {
		bw = new BufferedWriter(new FileWriter(path));
		for (Orcamento l : linhas) {
			bw.write(l.toCSV());
		}
		bw.close();
	}catch(IOException e) {
		System.out.println(e);
	}
}
}