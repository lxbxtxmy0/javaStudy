public class AsciiCharSequence implements CharSequence {
    private final byte[] byteArray;

    public AsciiCharSequence(byte[] byteArray) {
        this.byteArray = byteArray;
    }

    @Override
    public int length() {
        return byteArray.length;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index >= length()) {
            return '\0';
        }
        return (char) byteArray[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (start < 0 || end < 0 || start > end || end > length()) {
            return new AsciiCharSequence(new byte[0]);
        }

        byte[] result = new byte[end - start];

        for (int i = start; i < end; i++) {
            result[i - start] = byteArray[i];
        }

        return new AsciiCharSequence(result);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length(); i++) {
            result.append(charAt(i));
        }
        return result.toString();
    }
}
