package br.com.isilanguage.main;

import java.util.Scanner;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.com.isilanguage.exceptions.IsiSemanticException;
import br.com.isilanguage.parser.IsiLangLexer;
import br.com.isilanguage.parser.IsiLangParser;

/* esta é a classe que é responsável por criar a interação com o usuário
 * instanciando nosso parser e apontando para o arquivo fonte
 * 
 * Arquivo fonte: extensao .isi
 * 
 */
public class MainClass {
	public static void main(String[] args) {
		try {
			IsiLangLexer lexer;
			IsiLangParser parser;
			
			
			Scanner scan =  new Scanner(System.in);
			String file  = scan.next();
			
			if(!file.endsWith(".isi")) {
				file = file + ".isi";
				
			}
			
			// leio o arquivo "input.isi" e isso é entrada para o Analisador Lexico
			lexer = new IsiLangLexer(CharStreams.fromFileName(file));
			
			// crio um "fluxo de tokens" para passar para o PARSER
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			// crio meu parser a partir desse tokenStream
			parser = new IsiLangParser(tokenStream);
			
			parser.prog();
			
			System.out.println("Compila��o bem sucedida");
			long initial = System.currentTimeMillis();
			
			parser.exibeComandos();
			
			parser.generateCode();
			
			long fim = System.currentTimeMillis();
			long delay = (fim - initial);
			System.out.printf("O programa foi compilado em "+delay+"ms");
			
		}
		catch(IsiSemanticException ex) {
			System.err.println("Semantic error - "+ex.getMessage());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.err.println("ERROR "+ex.getMessage());
		}
		
	}

}
