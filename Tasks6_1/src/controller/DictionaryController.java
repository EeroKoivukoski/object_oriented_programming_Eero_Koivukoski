package controller;

import model.Dictionary;

public class DictionaryController {
    private Dictionary dictionary;

    public DictionaryController() {
        dictionary = new Dictionary();
        // Temporary hardcoded words
        dictionary.addWord("java", "A high-level programming language.");
        dictionary.addWord("dictionary", "A collection of words and their meanings.");
        dictionary.addWord("computer", "An electronic device for processing information.");
    }

    public String search(String word) {
        try {
            return dictionary.searchWord(word);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
