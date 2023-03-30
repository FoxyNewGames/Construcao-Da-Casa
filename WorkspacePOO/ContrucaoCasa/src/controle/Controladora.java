package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import visualizacao.EntradaSaida;
import modelo.*;

public class Controladora {

	// Criação do Objeto Casa como Private
	private Casa casa = null;

	public void exibeMenu() {

		int opcao;
		do {
			if (casa == null) {
				JOptionPane.showMessageDialog(null, "Por favor, Selecione Construir Casa Primeiro.");
				opcao = 0;
			} else {
				opcao = EntradaSaida.solicitaOpcao();
			}

			switch (opcao) {
				case 0:
					// Construção da casa
					this.casa = new Casa();
					String descricao = EntradaSaida.solicitaDescricao("Casa", 0);
					String cor = EntradaSaida.solicitaCor();
					int qtDePortas = EntradaSaida.solicitaQtDeAberturas("Portas");
					if (qtDePortas <= 0) {
						JOptionPane.showInternalMessageDialog(null, "Não Use Valores 0 OU Abaixo de Tal!");
						System.exit(0);
					}
					int qtdeJanelas = EntradaSaida.solicitaQtDeAberturas("Janelas");
					if (qtdeJanelas <= 0) {
						JOptionPane.showInternalMessageDialog(null, "Não Use Valores 0 OU Abaixo de Tal!");
						System.exit(0);
					}

					/*
					 * instância de um objeto ArrayList da seguinte forma que, irá com sua forma
					 * de
					 * "Vetor" armazenar todos os itens abaixo pedidos, fazendo assim uma lista de
					 * um objeto só, mas com toda sua descrição, acessando seus metodos direto da
					 * classe casa e retornando-os para cá
					 */
					ArrayList<Aberturas> listaDePortas = new ArrayList<Aberturas>();

					for (int i = 0; i < qtDePortas; i++) {
						Porta porta = new Porta();
						/*
						 * Por intermedio do objeto porta, acessando o metodo setdescricao, da classe
						 * abertura e levando como parametro a descricao da porta.
						 */
						porta.setDescricao(EntradaSaida.solicitaDescricao("porta", (i + 1)));
						porta.setEstado(EntradaSaida.solicitaEstado("porta"));
						listaDePortas.add(porta);
					}
					ArrayList<Aberturas> listaDeJanelas = new ArrayList<Aberturas>();
					for (int i = 0; i < qtdeJanelas; i++) {
						Janela janela = new Janela();
						// Criando objeto janela e instanciando para ele a classe janela
						janela.setDescricao(EntradaSaida.solicitaDescricao("Janela", (i + 1)));
						janela.setEstado(EntradaSaida.solicitaEstado("Janela"));
						/*
						 * O objeto Janela esta acessando o setDescricao enviando a descricao da janela
						 */
						listaDeJanelas.add(janela);// add janela na array listadejanela
					}
					// Formação das frases para cada porta e janela conforme quantidade
					this.casa.constroiCasa(descricao, cor, listaDePortas, listaDeJanelas);
					System.out.println("Descrição da Casa:" + casa.getDescricao() + "\n");
					System.out.println("Cor da Casa:" + casa.getCor() + "\n");

					for (Aberturas porta : casa.getlistaDePortas()) {
						System.out.println("Descrição da Porta:" + porta.getDescricao() + "\n");
						System.out.println("Estado da Porta:" + porta.getEstado() + "\n");
					}
					for (Aberturas Janela : casa.getlistaDeJanelas()) {
						System.out.println("Descrição da Janela:" + Janela.getDescricao() + "\n");
						System.out.println("Estado da Janela:" + Janela.getEstado() + "\n");
					}

					break;

				case 1:

					String tipoAbertura = EntradaSaida.solicitaTipoAberturas();
					// Instanciação de uma arraylist
					ArrayList<Aberturas> listaDeAberturas = new ArrayList<Aberturas>();
					if (tipoAbertura.equals("porta")) {
						listaDeAberturas = this.casa.getlistaDePortas();
					} else {
						listaDeAberturas = this.casa.getlistaDeJanelas();
					}
					int posicao = EntradaSaida.solicitaAberturaMover(listaDeAberturas);
					int novoEstado = 0;

					if (posicao != -1) {
						novoEstado = EntradaSaida.solicitaEstado(tipoAbertura);
						Aberturas abertura = this.casa.retornaAbertura(posicao, tipoAbertura);
						this.casa.moverAbertura(abertura, novoEstado);
						System.out.println("Novo Estado da " + tipoAbertura + ": " + abertura.getEstado());

					} else {
						EntradaSaida.exibeMsgAbertura();
					}
					break;

				case 2:
					// OT11
					String informacoes = this.casa.geraInforCasa();
					EntradaSaida.exibeInfoCasa(informacoes);
					break;

			}
		} while (opcao != 3);
		// Controladora está acessando o Método exibeMsgEncerraPrograma da classe
		// EntradaSaida
		EntradaSaida.exibeMsgEncerraPrograma();
		System.exit(0);
	}
}