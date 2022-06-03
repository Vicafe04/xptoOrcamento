package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import control.OrcamentoProcess;
import model.Orcamento;

public class OrcamentoForm extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel id, fornecedor, produto, preco;
	private JTextField tfId, tfFornecedor, tfProduto, tfPreco;
	private JTextArea verResultados;
	private JButton create, read, update, delete;
	private String texto = "";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private final Locale BRASIL = new Locale("pt", "BR");
	private DecimalFormat df = new DecimalFormat("#.00");
	private int autoId;
	//= OrcamentoProcess.orcamentos.get(OrcamentoProcess.orcamentos.size()-1).getId() + 1;
	
	OrcamentoForm(){
		setTitle("Orçamento");
		setBounds(150, 170, 800, 600);
		painel = new JPanel();
		painel.setBackground(new Color(255, 233, 213));
		setContentPane(painel);
		setLayout(null);
		
		id = new JLabel("Id:");
		id.setBounds(20, 20, 120, 30);
		painel.add(id);
		fornecedor = new JLabel("Fornecedor:");
		fornecedor.setBounds(20, 55, 120, 30);
		painel.add(fornecedor);
		produto = new JLabel("Produto:");
		produto.setBounds(20, 90, 120, 30);
		painel.add(produto);
		preco = new JLabel("preco:");
		preco.setBounds(20, 125, 120, 30);
		painel.add(preco);
		
		tfId = new JTextField(String.format("%d", autoId));
		tfId.setEditable(false);
		tfId.setBounds(110, 20, 40, 30);
		painel.add(tfId);
		tfFornecedor = new JTextField();
		tfFornecedor.setBounds(110, 55, 155, 30);
		painel.add(tfFornecedor);
		tfProduto = new JTextField();
		tfProduto.setBounds(110, 90, 155, 30);
		painel.add(tfProduto);
		tfPreco = new JTextField();
		tfPreco.setBounds(110, 125, 155, 30);
		painel.add(tfPreco);
		
		create = new JButton("Cadastrar");
		read = new JButton("Buscar");
		update = new JButton("Atualizar");
		delete = new JButton("Excluir");
		create.setBounds(545, 55, 110, 50);
		read.setBounds(425, 55, 110, 50);
		update.setBounds(425, 110, 110, 50);
		delete.setBounds(545, 110, 110, 50);
		update.setEnabled(false);
		delete.setEnabled(false);
		painel.add(create);
		painel.add(read);
		painel.add(update);
		painel.add(delete);

		verResultados = new JTextArea();
		verResultados.setEditable(false);
		verResultados.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		preencherAreaDeTexto();
	}

	private void preencherAreaDeTexto() {
		for (Orcamento o : OrcamentoProcess.orcamentos) {
			texto += o.toString();
		}
		verResultados.setText(texto);
	}
		
	

	public static void main(String[] args) {
		new OrcamentoForm().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == create) {
//			cadastrar();
//		}
//		if (e.getSource() == read) {
//			buscar();
//		}
//		if (e.getSource() == update) {
//			alterar();
//		}
//		if (e.getSource() == delete) {
//			excluir();
//		}
		
	}

}
