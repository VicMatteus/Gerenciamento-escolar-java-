package org.integrantes;

public class Aluno extends Pessoa
{
	int matricula;

	public Aluno(String nome, String nivel, int idade, int matricula)
	{
		super(nome, nivel, idade);
		this.setMatricula(matricula);
	}


	public int getMatricula()
	{
		return matricula;
	}
	public void setMatricula(int matricula)
	{
		this.matricula = matricula;
	}

	public String toString()
	{
		String info = "";
		info += super.toString() + this.getMatricula();
		return info;
	}

}
