package visualizacao;

import javax.swing.JOptionPane;

import modelo.Aberturas;

import java.util.ArrayList;

import javax.swing.JComboBox;

public class EntradaSaida {

	public static String solicitaDescricao(String descricao, int ordem) {
		if (ordem == 0) {
			return JOptionPane.showInputDialog("Informe a Descrição" + descricao);
		} else {
			return JOptionPane.showInputDialog("Informe a Descrição" + ordem + " " + descricao);
			/*
			 * retornando a descricao da porta
			 * 
			 */
		}
	}

	public static String solicitaCor() {
		return JOptionPane.showInputDialog("Informe a Cor da Casa");
	}

	public static int solicitaQtDeAberturas(String abertura) {
		return Integer.parseInt(JOptionPane.showInputDialog("Informe a Quantidade de " + abertura));
	}

	// Um JComboBox é um componente que combina dois recursos: uma área de
	// exibição
	// que mostra uma opção padrão e
	// uma caixa de listagem que contém opções alternativas adicionais.
	// (Uma caixa de listagem também é conhecida como caixa de combinação ou
	// lista
	// suspensa.)
	// A exibição área contém um botão no qual o usuário pode clicar ou um
	// campo
	// editável no qual o usuário pode digitar.”

	public static int solicitaOpcao() {
		String[] opcoes = { "Construir Casa", "Movimentar Portas ou Janelas", "Ver Informações da Casa",
				"Sair do Programa" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a Opção Desejada", JOptionPane.OK_CANCEL_OPTION);

		return menu.getSelectedIndex();
	}

	public static int solicitaEstado(String tipoAbertura) {
		String[] opcao = { "Fechada", "Aberta" };
		return JOptionPane.showOptionDialog(null, "Informe o Estado da" + tipoAbertura, "Estado",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcao, opcao[1]);
	}
	// usamos as mesmas informações de tipo <String> com o construtor como fazemos
	// ao criar objetos de coleção como ArrayList

	public static void exibeMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O Programa Será Enecerrado!");
	}

	public static String solicitaTipoAberturas() {
		// O método solicitaTipoAbertura()retornaráumaString,correspondente ao botão
		// do
		// showOptionDialog() que foi clicado: (retorno 0) ou (retorno 1).
		String[] opcoes = { "Porta", "Janela" };

		int tipoAbertura = JOptionPane.showOptionDialog(null, "Informe Qual tipo de Abertura deseja Movimentar",
				"Mover Abertura", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
		if (tipoAbertura == 0) {
			return "porta";
		} else {
			return "janela";
		}
	}

	public static int solicitaAberturaMover(ArrayList<Aberturas> listaDeAberturas) {
		// pedir um detalhamento dessa parte.
		String tipoAbertura = listaDeAberturas.get(0).getClass().getName();
		tipoAbertura = tipoAbertura.replaceAll("Modelo. ", "");
		int qtDeAberturas = listaDeAberturas.size();
		String[] descricoesAberturas = new String[qtDeAberturas];

		for (int i = 0; i < qtDeAberturas; i++) {
			descricoesAberturas[i] = listaDeAberturas.get(i).getDescricao();
		}
		String msg = "escolha a" + tipoAbertura + "  a ser Movimentada";
		JComboBox exibicaoAberturas = new JComboBox(descricoesAberturas);
		int confirmacao = JOptionPane.showConfirmDialog(null, exibicaoAberturas, msg, JOptionPane.OK_CANCEL_OPTION);

		if (confirmacao == 0) {
			return exibicaoAberturas.getSelectedIndex();
		} else {
			return -1;
		}
	}

	// OT11
	public static void exibeInfoCasa(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes, "Ver Informções da Casa", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exibeMsgAbertura() {
		JOptionPane.showInternalMessageDialog(null, "Nenhuma Abertura Será Movimentada");
	}
}
