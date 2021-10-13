package org.integrantes;
import java.io.*;
import java.util.ArrayList;

import org.manager.AluManager;
import org.manager.ProfManager;
import org.manager.TurmManager;

public class Arquivo
{
	//essa clase objetiva realizar as leituras e escritas de arquivo, mas todos no mesmo arquivo
	static String dados[];
	
	public static void escreverEncerramento(ArrayList<Aluno> alunos) throws IOException//o padrão será dividir as info com ';' terão 4 campos
																//na classe cujas informações serão escritas, terá um metodo que juntara tudo em string com ;
	{
		FileWriter arq = new FileWriter("dados.kvk", false);
		PrintWriter escritor = new PrintWriter(arq);
		for(int i = 0; i < alunos.size(); i++)
		{
			escritor.println((alunos.get(i).toString()));
		}
		escritor.close();
	}
	
	public static ArrayList<Aluno> ler() throws IOException  //leitura total para inicio do programa, retorna um array com todos os alunos
	{
		ArrayList<Aluno> alunos = new ArrayList<>();
		FileReader arq = new FileReader("dados.kvk");
		BufferedReader leitor = new BufferedReader(arq);
		
		String linha = leitor.readLine();
		while(linha != null)
		{
			dados = linha.split(";");//nome,   nivel    , idade                     , matricula
			Aluno aluAux = new Aluno(dados[0], dados[1], Integer.parseInt(dados[2]), Integer.parseInt(dados[3]));
			alunos.add(aluAux);
			linha = leitor.readLine();
		}
		
		leitor.close();
		return alunos;
	}

	public static void escreverEncerramentoProfessores(ArrayList<Professor> professores) throws IOException
	{
		FileWriter arq = new FileWriter("professores.kvk", false);
		PrintWriter escritor = new PrintWriter(arq);
		for(Professor professor : professores)
		{
			escritor.println((professor.toString()));
			escritor.flush();
		}
		escritor.close();
	}
	
	public static ArrayList<Professor> lerProfessores() throws IOException  //leitura total para inicio do programa, retorna um array com todos os professores
	{
		ArrayList<Professor> professores = new ArrayList<>();
		FileReader arq = new FileReader("professores.kvk");
		BufferedReader leitor = new BufferedReader(arq);
		
		String linha = leitor.readLine();
		while(linha != null)
		{
			dados = linha.split(";");         //nome,   nivel    , idade                     , salario
			Professor profAux = new Professor(dados[0], dados[1], Integer.parseInt(dados[2]), Float.parseFloat((dados[3])));
			professores.add(profAux);
			linha = leitor.readLine();
		}
		
		leitor.close();
		return professores;
	}
	
	public static void escreverTurmas(ArrayList<Turma> turmas) throws IOException
	{
		FileWriter arq = new FileWriter("turmas.kvk", false);
		PrintWriter escritor = new PrintWriter(arq);
		
		for(Turma turma: turmas)
		{
			escritor.println(turma.toString());
			escritor.flush();
		}
		escritor.close();
		
	}
	
	public static ArrayList<Turma> lerTurmas(ArrayList<Professor> professores, ArrayList<Aluno> alunos) throws IOException
	{
		ArrayList<Turma> turmasAux = new ArrayList<>();
		ArrayList<Aluno> alunosAux = new ArrayList<>();
		FileReader arq = new FileReader("turmas.kvk");
		BufferedReader leitor = new BufferedReader(arq);
		Professor profAux;
		Aluno aluAux;
		String linha;
		String dados[];
		
		while((linha = leitor.readLine()) != null)
		{
			dados = linha.split(";");
			
			//profAux = professores.get(ProfManager.existe(professores, dados[1]));
			
			
			for(int i = 2; i<dados.length-1; i++)  					//pois 0 = numero da turma e 1 = professor // adiciona os alunos à turma
			{
				//aluAux = alunos.get(AluManager.existe(alunos, dados[i]));
				alunosAux.add(alunos.get(AluManager.existe(alunos, dados[i])));
				//TurmManager.adicionarAluno(aluAux, turmaAux);
			}
			Turma turmaAux = new Turma(professores.get(ProfManager.existe(professores, dados[1])), alunosAux);
			turmasAux.add(turmaAux);
		}
		
		return turmasAux;
		
		
	}
}
