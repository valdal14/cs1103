import java.util.HashMap;
import java.util.Map;


public class SimpleRandomSentences {
		
	private static Map<String, String[]> DIC = new HashMap<>();
	private static int counter = 0;
	private static String sentence = "This is the ";

	public static void main(String[] args) {
		
		DIC.put("NOUNS", new String[] {"farmer", "rooster", "judge", "man", "maiden", "cow", "dog", "cat", "cheese"});
		DIC.put("VERBS", new String[] {"kept", "waked", "married", "milked", "tossed", "chased", "lay in"});
		DIC.put("MODIFIERS", new String[] {"that crowed in the morn", "sowing his corn", "all shaven and shorn", "all forlorn", "with the crumpled horn"});
		DIC.put("CONJUCTIONS", new String[] {"and", "or", "but", "because"});
		DIC.put("PROPERNOUNS", new String[] {"Fred", "Jane", "Richard Nixon", "Miss America"});
		DIC.put("COMMONNOUNS", new String[] {"man", "woman", "fish", "elephant", "unicorn"});
		DIC.put("DETERMINERS", new String[] {"a", "the", "every", "some"});
		DIC.put("ADJECIVES", new String[] {"big", "tiny", "pretty", "bald"});
		DIC.put("INTRANSITIVEVERBS", new String[] {"runs", "jumps", "talks", "sleeps"});
		DIC.put("TRANSITIVEVERBS", new String[] {"loves", "hates", "sees", "knows", "looks for", "finds"});
		
		while (true) {
			String sentence = buildSentences();
			System.out.print(sentence);
			System.out.println("");
			try {
				Thread.sleep(3000);
				cleanUp();
			}
			catch (InterruptedException e) {
			}
		}		
	}
	
	/**
	 * Return a string from a String[] based on a given index
	 * @param listOfStrings - String[]
	 * @return String
	 */
	private static String randomItem(String[] listOfStrings) {
		int index = (int)(Math.random() * listOfStrings.length);
		return listOfStrings[index];
	}
	
	
	/**
	 * The recursive function that will generate 
	 * random phrases 
	 * @return
	 */
	private static String buildSentences() {
		String key = getDictionaryKey(counter);
		
		if(counter == 7) {
			return sentence;
		} else {
			
			if(key == "NOUNS" || key == "PROPERNOUNS") {
				sentence += randomItem(DIC.get(key)) + " the house that Jack built ";
			} else if (key == "MODIFIERS") {
				sentence += randomItem(DIC.get(key)) + " that ";
			} else {
				sentence += randomItem(DIC.get(key)) + " ";
			}
			
			counter += 1;
			return buildSentences();
		}
	}
	
	/**
	 * Based on the value of the counter assign a value
	 * to the key that will later on retrieve the String[]
	 * @param counter - Integer value
	 * @return String
	 */
	private static String getDictionaryKey(int counter) {
		String key = "";
		
		switch (counter) {
		case 0:
			key = variationChoice(counter);
			break;
		case 1:
			key = "ADJECIVES";
			break;
		case 2:
			key = "MODIFIERS";
			break;
		case 3:
			key = "VERBS";
			break;
		case 4:
			key = "CONJUCTIONS";
			break;
		case 5:
			key = "MODIFIERS";
			break;
		case 6:
			key = "VERBS";
			break;
		}
		
		return key;
	}
	
	/**
	 * Restore the variables counter and sentence to their
	 * default values
	 */
	private static void cleanUp() {
		counter = 0;
		sentence = "This is the ";
	}
	
	/**
	 * Return a variant between NOUNS and PROPERNOUNS
	 * @param counter
	 * @return
	 */
	private static String variationChoice(int counter) {
		return Math.random()< 0.5 ? "NOUNS" : "PROPERNOUNS";
	}

}