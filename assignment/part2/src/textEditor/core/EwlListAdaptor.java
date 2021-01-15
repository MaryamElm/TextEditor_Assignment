package textEditor.core;

import textEditor.core.structures.NodeList;


/**
 * This is an adaptor to the array list exposing few of its functionality for the purpose of
 * adding and searching for words in the EWL
 */
public class EwlListAdaptor extends EwlStructureAdaptor{
	
	// Our structure of choice. Not exactly the ideal solution :(
	private NodeList<String> list = new NodeList<String>();
	
	@Override
	protected void addWord(String word) {
		list.addLast(word);
	}

	@Override
	public boolean wordExists(String word) {
		word = word.toLowerCase();
		return list.contains(word);
	}

	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	

}
