package org.manager;
import java.util.ArrayList;

import org.integrantes.Professor;
import org.integrantes.Turma;
//Classe responsável por gerencias as operações dos professores
public class ProfManager
{

	public static Professor criarProf(String nome,String nivel, int idade, float salario)
	{
		Professor profAux = new Professor(nome, nivel, idade, salario);
		return profAux;
	}
	
	public static ArrayList<Professor> removerProfessor(ArrayList<Professor> professores, int index) //remove um aluno da lista
	{
		professores.remove(professores.get(index));
		return professores;
	}
	
	public static void exibirProfessores(ArrayList<Professor> professores)					//mostra todos os alunos na tela
	{
		if(professores.size() > 0)
		{
			for(Professor professor : professores) 													// teste de um for each pra ficar limpo
			{
				System.out.println("Nome: " + professor.getNome() + " --- Idade: " + professor.getIdade());
				System.out.println("Nível: " + professor.getNivel() + " --- Salário: " + professor.getSalario());
				System.out.println("------------------------------------------------");
			}
		}
		else
			System.out.println("Não existe professor cadastrado!");
		
		System.out.println("+++++++++++++++++++++++++++++\n");
	}
	
	public static void exibirUm(ArrayList<Professor> professores, int index)  			//mostra os dados de um só aluno
	{
		System.out.println("Nome: " + professores.get(index).getNome() + " --- Idade: " + professores.get(index).getIdade());
		System.out.println("Nível: " + professores.get(index).getNivel() + " --- Matrícula: " + professores.get(index).getSalario());
		System.out.println("++++++++++++++++++++++++++");
	}

	public static int existe(ArrayList<Professor> professores, String nome) 			//percorre tudo fazendo uma busca e retornando o index
	{
		int i = 0;
		for(Professor professor : professores)
		{
			if(professor.getNome().equalsIgnoreCase(nome))
				return i;
			else
				i++;
		}
		return -1;
	}
	
	public static void inserirProfNaTurma(Turma turma, Professor professor) 			// implementado mas não utilizado ainda
	{
		turma.setProfessor(professor);
	}
	
}
