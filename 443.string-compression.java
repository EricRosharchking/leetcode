import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        int toWrite = 1;
        char key = chars[0];
        int val = 1;
        for (int toRead = 1; toRead < chars.length; toRead++) {
            char c = chars[toRead];
            if (c == key) {
                val++;
            } else {
                key = c;
                if (val > 1) {
                    char[] valChar = String.valueOf(val).toCharArray();
                    for (int i = 0; i < valChar.length; i++) {
                        chars[toWrite++] = valChar[i];
                    }
                }
                val = 1;
                chars[toWrite++] = chars[toRead];
            }
        }
        if (val > 1) {
            char[] valChar = String.valueOf(val).toCharArray();
            for (int i = 0; i < valChar.length; i++) {
                chars[toWrite++] = valChar[i];
            }
        }
        // System.out.println(Arrays.toString(Arrays.copyOfRange(chars, 0, toWrite)));
        return toWrite;
    }
}
