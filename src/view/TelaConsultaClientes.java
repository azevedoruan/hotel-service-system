package view;

import java.util.List;
import java.util.Scanner;

import modelo.ClienteFisico;
import servicos.ClienteFisicoServico;
import view.exceptions.TelaException;

public class TelaConsultaClientes extends Tela {

	private ClienteFisicoServico servico;
	private int opcaoSelecionada = 0;
	
	public TelaConsultaClientes() {
		servico = new ClienteFisicoServico();
	}
	
	@Override
	public void cabecalho() {
		super.cabecalho();
		System.out.println("Consultas de cliente\n");
	}
	
	@Override
	public void conteudo() {
		if (opcaoSelecionada == 1) {
			System.out.println("recebe cpf ou cnpj cliente");
			System.out.println("verificar cpf");
			System.out.println("se cpf for valido, consultar cliente");
			System.out.println("descreve cliente");
			
			System.out.println("verificar cnpj");
			System.out.println("se cnpj for valido, consultar empresa");
			System.out.println("descreve empresa");	
		} else if (opcaoSelecionada == 2) {
			List<ClienteFisico> clientes = servico.consultarTodosClientesFisicosCadastrados();
			for (ClienteFisico cf : clientes) {
				System.out.print(cf.getNome());
				if (cf.getEmpresaVinculo().getNome() != null)
					System.out.print(" vinculado a " + cf.getEmpresaVinculo().getNome());
				System.out.println();
			}
			System.out.println();
		}
	}

	@Override
	public Tela selecionarOpcao(Scanner sc) {
		try {
			if (opcaoSelecionada == 0) {
				System.out.println("Selecione uma opcao:");
				System.out.println("1 -> Consultar cliente");
				System.out.println("2 -> Mostrar lista de clientes");
				System.out.println("0 -> Voltar");
				int opcao = sc.nextInt();
				
				switch (opcao) {
				case 1:
				case 2:
					opcaoSelecionada = opcao;
					return this;
				case 0:
					return new TelaPrincipal();
				default:
					throw new TelaException("Erro de opcao. Valores validos vao de 0 a 2 apenas.");
				}
			} else {
				System.out.println("Selecione qualquer tecla para confirmar");
				opcaoSelecionada = 0;
				sc.nextLine();
				sc.nextLine();
				return this;
			}
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
			System.out.println("\nSelecione qualquer tecla para confirmar");
			sc.nextLine();
			sc.nextLine();
			return this;
		}
	}
}
