package org.manager;
import java.util.ArrayList;

import org.integrantes.Aluno;
import org.integrantes.Turma;

//Classe responsável por gerenciar os alunos realizando todas as operações disponiveis para estes

public class AluManager         										// na teoria vou poder usar essa clasee sem precisar instanciar ela
{
	public static Aluno criarAluno(String nome,String nivel, int idade, int matricula)
	{
		Aluno aluAux = new Aluno(nome, nivel, idade, matricula);
		return aluAux;
	}
	
	public static ArrayList<Aluno> removerAluno(ArrayList<Aluno> alunos, int index) //remove um aluno da lista
	{
		alunos.remove(alunos.get(index));
		return alunos;
	}
	
	public static void exibirAlunos(ArrayList<Aluno> alunos)					//mostra todos os alunos na tela
	{
		for(Aluno aluno : alunos) 													// teste de um for each pra ficar limpo
		{
			System.out.println("Nome: " + aluno.getNome() + " --- Idade: " + aluno.getIdade());
			System.out.println("Nível: " + aluno.getNivel() + " --- Matrícula: " + aluno.getMatricula());
			System.out.println("------------------------------------------------");
		}
		System.out.println    ("+++++++++++++++++++++++++++++\n");
	}
	
	public static void exibirUm(ArrayList<Aluno> alunos, int index)  			//mostra os dados de um só aluno
	{
		System.out.println("Nome: " + alunos.get(index).getNome() + " --- Idade: " + alunos.get(index).getIdade());
		System.out.println("Nível: " + alunos.get(index).getNivel() + " --- Matrícula: " + alunos.get(index).getMatricula());
		System.out.println("==========================");
	}
	
	public static int existe(ArrayList<Aluno> alunos, String nome) 			//percorre tudo fazendo uma busca e retornando o index
	{
		int i = 0;
		for(Aluno aluno : alunos)
		{
			if(aluno.getNome().equalsIgnoreCase(nome))
				return i;
			else
				i++;
		}
		return -1;
	}
}
