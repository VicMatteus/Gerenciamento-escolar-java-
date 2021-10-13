package org.integrantes;

public class Professor extends Pessoa
{
	private float salario;
	
	public Professor(String nome, String nivel, int idade, float salario)
	{
		super(nome, nivel, idade);
		this.setSalario(salario);
	}

	public float getSalario()
	{
		return salario;
	}
	public void setSalario(float salario)
	{
		this.salario = salario;
	}
	
	public String toString()
	{
		String info = "";
		info += super.toString() + this.getSalario();
		return info;
	}
}
