package org.integrantes;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Turma
{
	static int id = 0;
	private Professor professor;
	private ArrayList<Aluno> alunos;
	final int capacidade = 15;
	
	private int turma = id + 1;
	
	public Turma(Professor professor)
	{
		this.setProfessor(professor);
		id++;
	}
	public Turma(Professor professor, ArrayList<Aluno> alunos)
	{
		this.setProfessor(professor);
		this.setAlunos(alunos);
		id++;
	}
	
	
	public Professor getProfessor()
	{
		return professor;
	}
	public void setProfessor(Professor professor)
	{
		this.professor = professor;
	}
	
	public ArrayList<Aluno> getAlunos()
	{
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos)
	{
		this.alunos = alunos;
	}
	
	public int getTurma()
	{
		return turma;
	}
	public void setTurma(int turma)
	{
		this.turma = turma;
	}
	
	public int getCapacidade()
	{
		return capacidade;
	}
	
	public String toString() // preciso analisar se está bacana
	{
		String info = "";
		info += this.getTurma() + ";" + this.getProfessor().getNome() + ";";
		
		for(int i = 0; i < this.getAlunos().size(); i ++)
		{
			if(i != this.getAlunos().size()-1)				
				info += this.getAlunos().get(i).getNome() + ";";
			
			else
				info += this.getAlunos().get(i).getNome();
		}
		return info;
	}
	
}
