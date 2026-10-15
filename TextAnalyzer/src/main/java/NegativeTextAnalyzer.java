final class NegativeTextAnalyzer extends KeywordAnalyzer {
    private final String[] keywords = new String[] {":(", "=(", ":|"};

    public NegativeTextAnalyzer() {}

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

}
