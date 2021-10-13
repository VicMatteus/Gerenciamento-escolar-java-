package org.integrantes;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.manager.AluManager;
import org.manager.ProfManager;
import org.manager.*;

public class Main
{
	// Me pergunto se seria melhor criar essas listas s� nas classes respons�veis
	// por operar elas...
	
	private static ArrayList<Aluno> alunos = new ArrayList<>();
	private static ArrayList<Professor> professores = new ArrayList<>();
	private static ArrayList<Turma> turmas = new ArrayList<>();
	
	public static void main(String[] args) throws IOException
	{
		/*
		 * validarEntrada(); //user: user; senha: 123 // loop de verifica��o de login e
		 * senha; pode ser descartado pela falta de complexidade
		 */
		iniciar(); // recupera os dados do "papel"
		menuIni(); // Inicia os menus em loop
	}
	
	public static void iniciar() throws IOException
	{
		alunos = Arquivo.ler();
		professores = Arquivo.lerProfessores();
		turmas = Arquivo.lerTurmas(professores, alunos);
		System.out.println("Sistema inicializado com sucesso!");
	}
	
	public static void validarEntrada()
	{
		Scanner ler = new Scanner(System.in);
		boolean validar;
		do
		{
			System.out.println("Digite seu usu�rio: ");
			String user = ler.next();
			
			System.out.println("Digite sua senha: ");
			String pass = ler.next();
			
			if(user.equals("user") && pass.equals("123"))
			{
				System.out.println("Entrada v�lida!");
				validar = true;
			}
			else
			{
				System.out.println("Entrada inv�lida!");
				validar = false;
			}
		}
		while (validar != true);
	}
	
	public static void menuIni() throws IOException
	{
		Scanner ler = new Scanner(System.in);
		int opcao = 0;
		do
		{
			System.out.println("O que ser� gerenciado?");
			System.out.println("1 - Alunos\n2 - Professores\n3 - Turmas\n9 - Sair");
			try // para impedir entradas inv�lidas.
			{
				opcao = ler.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.out.println("Entrada inv�lida!");
				ler.nextLine();
			}
			switch (opcao)
			{
				case 1:
					menuAlu();
					break;
				
				case 2:
					menuProf();
					break;
				
				case 3:
					menuTurma();
					break;
				case 9:
					System.out.println("Execu��o finalizada.");
					break;
				
				default:
					System.out.println("Op��o inv�lida!");
			}
		}
		while (opcao != 9);
	}
	
	public static void menuAlu() throws IOException
	{
		Scanner ler = new Scanner(System.in);
		int opcao = 0, idadeAux, numAux, aux;
		String nomeAux, areaAux;
		do
		{
			System.out.println("Escolha uma op��o:\n1 - Adicionar aluno\n2 - Exibir todos os alunos\n3 - Buscar alunos\n4 - Remover aluno\n9 - Encerrar");
			try
			{
				opcao = ler.nextInt();
				
				switch (opcao)
				{
					case 1:
						
						ler.nextLine();
						System.out.println("Digite o nome do aluno");
						nomeAux = ler.nextLine();
						System.out.println("Digite a idade do aluno");
						// ler.nextLine();
						idadeAux = ler.nextInt();
						System.out.println("Digite a matr�cula do aluno");
						ler.nextLine();
						numAux = ler.nextInt();
						System.out.println("Digite o n�vel do aluno(fundamental 1, 2, m�dio ou superior)");
						ler.nextLine();
						areaAux = ler.nextLine();
						
						alunos.add(AluManager.criarAluno(nomeAux, areaAux, idadeAux, numAux)); // usando metodo static pra adicionar um aluno aos dados
						System.out.println("Opera��o realizada com sucesso!\n");
						break;
					
					case 2:
						AluManager.exibirAlunos(alunos); // usando metodo static pra mostrar todos os alunos na tela
						break;
					
					case 3:
						ler.nextLine();
						System.out.println("Digite o nome do aluno:");
						nomeAux = ler.nextLine();
						
						if((aux = AluManager.existe(alunos, nomeAux)) != -1) AluManager.exibirUm(alunos, aux);
						
						else System.out.println("Aluno n�o encontrado.");
						break;
					
					case 4:
						ler.nextLine();
						System.out.println("Digite o nome do aluno a ser desligado:");
						nomeAux = ler.nextLine();
						
						if((aux = AluManager.existe(alunos, nomeAux)) != -1) // poderia fazer uso de tecnicas de programa��o din�mica?
						{
							alunos = AluManager.removerAluno(alunos, aux);
							System.out.println("Opera��o realizada com sucesso");
						}
						else System.out.println("Aluno n�o encontrado.");
						break;
					
					case 9:
						Arquivo.escreverEncerramento(alunos);
						System.out.println("Dados armazenados!");
						break;
					
					default:
						System.out.println("Op��o inv�lida!");
						break;
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println("Entrada inv�lida!");
				ler.nextLine();
			}
		}
		while (opcao != 9);
	}
	
	public static void menuProf() throws IOException
	{
		Scanner ler = new Scanner(System.in);
		String nomeAux, areaAux;
		float numAux;
		int opcao, idadeAux, index;
		
		do
		{
			System.out.println("\n1 - Adicionar professor\n2 - Remover professor\n3 - Listar professores\n4 - Buscar um professor\n9 - Encerrar");
			try
			{
				opcao = ler.nextInt();
				
				switch (opcao)
				{
					case 1:
						ler.nextLine();
						System.out.println("Digite o nome do professor:");
						nomeAux = ler.nextLine();
						System.out.println("Digite o nivel do professor:");
						areaAux = ler.nextLine();
						System.out.println("Digite a idade do professor:");
						ler.nextLine();
						idadeAux = ler.nextInt();
						System.out.println("Digite o sal�rio do professor:");
						ler.nextLine();
						numAux = ler.nextFloat();
						
						professores.add(ProfManager.criarProf(nomeAux, areaAux, idadeAux, numAux));
						System.out.println("Opera��o realizada com sucesso!");
						break;
					
					case 2:
						ler.nextLine();
						System.out.println("Digite o nome do professor a ser desligado:");
						nomeAux = ler.nextLine();
						if((index = ProfManager.existe(professores, nomeAux)) != -1)
						{
							professores = ProfManager.removerProfessor(professores, index);
							System.out.println("Opera��o realizada com sucesso!");
						}
						else System.out.println("Esse professor n�o esixte!");
						break;
					
					case 3:
						ProfManager.exibirProfessores(professores);
						break;
					
					case 4:
						ler.nextLine();
						System.out.println("Digite o nome do professor buscado:");
						nomeAux = ler.nextLine();
						if((index = ProfManager.existe(professores, nomeAux)) != -1)
						{
							ProfManager.exibirUm(professores, index);
						}
						else System.out.println("Esse professor n�o esixte!");
						break;
					
					case 9:
						Arquivo.escreverEncerramentoProfessores(professores);
						System.out.println("Dados salvos!");
						break;
					default:
						System.out.println("Op��o inv�lida!");
				}
				
			}
			catch (InputMismatchException e)
			{
				System.out.println("Entrada inv�lida!");
				ler.nextLine();
				break;
			}
		}
		while (opcao != 9);
	}
	
	public static void menuTurma() throws IOException
	{
		String nomeAux;
		int opcao = 0, index, numAux;
		
		do
		{
			System.out.println("1 - Criar nova turma\n2 - Excluir uma turma\n3 - Exibir turmas\n9 - Sair");
			Scanner ler = new Scanner(System.in);
			try
			{
				opcao = ler.nextInt();
				
				switch (opcao)
				{
					case 1:
						ler.nextLine();
						System.out.println("Quem ser� o professor da turma?");
						ProfManager.exibirProfessores(professores);
						System.out.println("Digite o nome do professor selecionado:");
						nomeAux = ler.nextLine();
						if((index = ProfManager.existe(professores, nomeAux)) != -1)
						{
							ArrayList<Aluno> alunoAux = new ArrayList<>();
							for (int i = 0; i < 15; i++) // Quantidade m�xima de alunos por turma � 15
							{ // Assim, da lista geral de alunos, os primeiros 15 ser�o da T1
								if(i < alunos.size()) alunoAux.add(alunos.get(i));
								else break;
							}
							Turma turmaAux = new Turma(professores.get(index), alunoAux);
							turmas.add(turmaAux);
							System.out.println("Turma criada com sucesso!");
						}
						else System.out.println("Professor n�o encontrado!");
						break;
					
					case 2:
						ler.nextLine();
						System.out.println("Digite o n�mero da turma a ser excluida");
						numAux = ler.nextInt();
						if(numAux <= turmas.size()) turmas.remove(numAux - 1);
						
						else System.out.println("Turma n�o encontrada.");
						break;
					
					case 3:
						TurmManager.exibirTurmas(turmas);
						break;
					
					case 9:
						// System.out.println(turmas.get(0).toString());
						Arquivo.escreverTurmas(turmas);
						System.out.println("Dados salvos!");
						break;
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println("Entrada inv�lida!");
				ler.nextLine();
			}
		}
		while (opcao != 9);
	}
}
