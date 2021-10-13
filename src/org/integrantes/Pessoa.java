package org.integrantes;

public abstract class Pessoa
{
	public String nome;
	public String nivel;
	public int idade;
	
	public Pessoa(String nome, String nivel, int idade)
	{
		this.setNome(nome);
		this.setNivel(nivel);
		this.setIdade(idade);
	}
	
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public String getNivel()
	{
		return nivel;
	}
	public void setNivel(String nivel)
	{
		this.nivel = nivel;
	}
	public int getIdade()
	{
		return idade;
	}
	public void setIdade(int idade)
	{
		this.idade = idade;
	}

	public String toString()
	{
		String info = "";
		info += (this.getNome() + ";" + this.getNivel() + ";" + this.getIdade()+ ";");
		return info;
	}
}
