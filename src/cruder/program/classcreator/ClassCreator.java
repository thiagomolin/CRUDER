package cruder.program.classcreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassCreator {

	private HashMap<String, String> inputHashMap;

	private List<String> result;

	List<String> privateFields;
	List<String> privateFieldsTypes;

	public ClassCreator(HashMap<String, String> inputHashMap) {
		this.inputHashMap = inputHashMap;
		result = new ArrayList<String>();
		privateFields = new ArrayList<String>();
		privateFieldsTypes = new ArrayList<String>();
	}

	public void createClass() {

		createClassStructure();
		createFields();
		createConstructors();
		createGetters();
		createSetters();
		createToString();

		closeClass();

		printClass();

	}

	private void createClassStructure() {
		result.add("public class " + inputHashMap.get("Tabela") + "{\n\n");
	}

	private void createFields() {

		for (Map.Entry<String, String> entry : inputHashMap.entrySet()) {
			String key = entry.getKey();
			String attType = (String) key.subSequence(0, 2); // get the first two letters of the field to determine type

			if (attType.equals("pk") || attType.equals("fk")) {
				privateFieldsTypes.add("long");
				privateFields.add(key);
				result.add("\tprivate long " + key + ";\n");

			} else if (attType.equals("ds") || attType.equals("nm")) {
				privateFieldsTypes.add("String");
				privateFields.add(key);
				result.add("\tprivate String " + key + ";\n");

			} else if (attType.equals("nr")) {
				privateFieldsTypes.add("int");
				privateFields.add(key);
				result.add("\tprivate int " + key + ";\n");

			} else if (attType.equals("dt")) {
				privateFieldsTypes.add("LocalDate");
				privateFields.add(key);
				result.add("\tprivate LocalDate " + key + ";\n");
			}
		}

	}

	private void createConstructors() {
		// Constructor 1, without pk
		result.add("\n\tpublic " + inputHashMap.get("Tabela") + "(");

		for (int i = 0; i < privateFields.size(); i++) {
			String field = privateFields.get(i);
			String type = privateFieldsTypes.get(i);
			String attType = (String) field.subSequence(0, 2);

			if (attType.equals("pk")) {
				continue;
			}

			if (i == privateFields.size() - 1) {
				result.add(type + " " + field + "){\n");
			} else {
				result.add(type + " " + field + ", ");
			}
		}

		for (int i = 0; i < privateFields.size(); i++) {
			String field = privateFields.get(i);
			String attType = (String) field.subSequence(0, 2);

			if (attType.equals("pk")) {
				continue;
			}

			result.add("\t\tthis." + field + " = " + field + ";\n");

		}
		result.add("\t}\n");

		// Constructor 2, with pk
		result.add("\n\tpublic " + inputHashMap.get("Tabela") + "(");

		for (int i = 0; i < privateFields.size(); i++) {
			String field = privateFields.get(i);
			String type = privateFieldsTypes.get(i);

			if (i == privateFields.size() - 1) {
				result.add(type + " " + field + "){\n");
			} else {
				result.add(type + " " + field + ", ");
			}
		}

		for (int i = 0; i < privateFields.size(); i++) {
			String field = privateFields.get(i);

			result.add("\t\tthis." + field + " = " + field + ";\n");

		}
		result.add("\t}\n\n");

	}

	private void createGetters() {
		for (int i = 0; i < privateFields.size(); i++) {
			String field = privateFields.get(i);
			String type = privateFieldsTypes.get(i);

			result.add("\tpublic " + type + " get" + field + "(){\n");
			result.add("\t\treturn this." + field + ";\n");
			result.add("\t}\n\n");
		}
	}

	private void createSetters() {
		for (int i = 0; i < privateFields.size(); i++) {
			String field = privateFields.get(i);
			String type = privateFieldsTypes.get(i);

			result.add("\tpublic void set" + field + "(" + type + " " + field + "){\n");
			result.add("\t\tthis." + field + " = " + field + ";\n");
			result.add("\t}\n\n");
		}
	}

	private void createToString() {
		String att1 = inputHashMap.get("Tabela");
		String att2 = privateFields.get(0);

		result.add("\tpublic String toString(){\n");
		result.add("\t\treturn \"" + att1 + "\" + \" - \" + this." + att2 + ";\n");
		result.add("\t}");
	}

	private void closeClass() {
		result.add("\n}");

	}

	private void printClass() {
		for (String s : result) {
			System.out.print(s);
		}
	}

}
