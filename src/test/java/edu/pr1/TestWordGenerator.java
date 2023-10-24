package edu.pr1;

import edu.pr1.word_generators.IWordGenerator;

public class TestWordGenerator implements IWordGenerator {
    @Override
    public String getWord() {
        return "Abracadabra";
    }
}
