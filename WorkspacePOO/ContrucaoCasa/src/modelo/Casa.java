package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Casa {

	/*
	 * Casa é Classe mãe, para não ter reescrever varias vezes o mesmo codigo em
	 * cada classe filha, é feito dessa maneira usando objetos
	 */
	private String descricao;
	private String cor;
	private ArrayList<Aberturas> listaDePortas = new ArrayList<Aberturas>();
	private ArrayList<Aberturas> listaDeJanelas = new ArrayList<Aberturas>();

	public Aberturas retornaAbertura(int posicao, String tipoAbertura) {
		if (tipoAbertura.equals("porta")) {
			return this.listaDePortas.get(posicao);
		} else {
			return this.listaDeJanelas.get(posicao);
		}
	}

	public void moverAbertura(Aberturas abertura, int novoEstado) {
		abertura.setEstado(novoEstado);
	}

	public static void exibeMsgAbertura() {
		JOptionPane.showMessageDialog(null, "Nenhuma Abertura Foi Movimentada");
	}

	// Get Busca/Captura
	public String getDescricao() {
		return descricao;
	}

	// Set Guarda
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public ArrayList<Aberturas> getlistaDePortas() {
		return listaDePortas;
	}

	public void setListaDePortas(ArrayList<Aberturas> listaDePortas) {
		this.listaDePortas = listaDePortas;
	}

	public ArrayList<Aberturas> getlistaDeJanelas() {
		return listaDeJanelas;
	}

	public void setListaDeJanelas(ArrayList<Aberturas> listaDeJanelas) {
		this.listaDeJanelas = listaDeJanelas;
	}

	// OT11
	public String geraInforCasa() {
		// Formando a descricao da casa inteira, com suas portas e janelas,
		// tendo seus detalhes ja armazenados em objetos na memoria agora usados para
		// formar suas descricoes completas.
		String informacoes = "Descrição: " + this.descricao + "\nCor: " + this.cor + "\nLista de Portas:\n";

		for (Aberturas abertura : this.listaDePortas) {
			int estado = abertura.getEstado();
			String estadoPorta;
			if (abertura.getEstado() == 1) {
				estadoPorta = "Aberta";
			} else {
				estadoPorta = "Fechada";
			}

			informacoes += abertura.getDescricao() + "  Estado: " + estadoPorta + "\n";
		}
		informacoes += "\nLista de Janelas:\n";
		for (Aberturas abertura : this.listaDeJanelas) {

			int estado = abertura.getEstado();
			String estadoJanela;
			if (abertura.getEstado() == 1) {
				estadoJanela = "Aberta";
			} else {
				estadoJanela = "Fechada";
			}
			informacoes += abertura.getDescricao() + "  Estado: " + estadoJanela + "\n";
		}
		return informacoes;
	}

	public void constroiCasa(String descricao, String Cor, ArrayList<Aberturas> listaDePortas,
			ArrayList<Aberturas> listaDeJanelas) {
		setDescricao(descricao);
		setCor(Cor);
		setListaDePortas(listaDePortas);
		setListaDeJanelas(listaDeJanelas);
	}
}