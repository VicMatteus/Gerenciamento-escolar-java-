package org.manager;

import java.util.ArrayList;
import org.integrantes.*;

public class TurmManager
{
	public static Turma criarTurma(Professor professor, ArrayList<Aluno> alunos)
	{
		Turma turmaAux = new Turma(professor, alunos);
		return turmaAux;
	}
	
	public static ArrayList<Professor> removerProfessor(ArrayList<Professor> professores, int index) //remove um aluno da lista
	{
		professores.remove(professores.get(index));
		return professores;
	}
	
	public static void adicionarAluno(Aluno aluno, Turma turma)
	{
		turma.getAlunos().add(aluno);
	}
	
	public static boolean removerAluno(Aluno aluno, Turma turma)
	{
		if(buscarAluno(aluno.getNome(), turma) != -1)
		{
			turma.getAlunos().remove(aluno);
			return true;
		}
		else
		{
			System.out.println("O aluno não existe nessa turma!");
			return false;
		}
	}
	
	
	public static int buscarAluno(String alunoAlvo, Turma turma)
	{
		int i = 0;
		for(Aluno aluno : turma.getAlunos())
		{
			if(aluno.getNome().equalsIgnoreCase(alunoAlvo))
				return i;
		}
		return -1;
	}
	
	public static void exibirTurmas(ArrayList<Turma> turmas)
	{
		if(turmas.size() > 0)
		{
			for(Turma turma : turmas)
			{
				System.out.println("Turma Nº" + turma.getTurma() + " --- Professor: " + turma.getProfessor().getNome());
				AluManager.exibirAlunos(turma.getAlunos());
			}
			System.out.println("+++++++++++++++++++++++++++++");
		}
		else
			System.out.println("Não exitem turmas cadastradas!\n");
	}

}
