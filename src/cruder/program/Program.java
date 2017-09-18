package cruder.program;

import java.util.HashMap;

import cruder.program.classcreator.ClassCreator;
import cruder.program.daocreator.DAOCreator;

public class Program {
		
	private HashMap<String, String> inputHashMap;
	
	private String[] fields;
	
	private String input;
	
	public Program () {
		
		input = readInput();		
		inputHashMap =  inputToHashMap();	
		
		ClassCreator c = new ClassCreator(inputHashMap);
		c.createClass();
		DAOCreator d = new DAOCreator(inputHashMap);
		d.createDAO();
	}
	
	private String readInput() {
		return "Tabela;Cliente;" + 
				"pk_cliente;Bigint;" + 
				"nm_cliente;Varchar;" + 
				"fk_pais;Bigint;" + 
				"fk_estado;Bigint;" + 
				"fk_cidade;Bigint;" + 
				"ds_telefone;Varchar;" + 
				"nr_dependentes;Varchar;" + 
				"dt_nascimento;Varchar;" + 
				"ds_endereco;Varchar;";
	}
	
	private HashMap<String, String> inputToHashMap() {
		HashMap<String, String> inputHashMap = new HashMap<String, String>();
				
		fields = input.split(";");		
		inputHashMap = new HashMap<String, String>();
				
		for(int i = 0 ; i < fields.length -1 ; i+=2) {
			inputHashMap.put(fields[i], fields[i+1]);

		}
		
		return inputHashMap;		
	}

	
}
