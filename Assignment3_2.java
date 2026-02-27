import java.util.Scanner;

public class Assignment3_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter String: ");
        String input = sc.nextLine();

        int manualCount = countWordsManually(input);
        System.out.println("count (Manual): " + manualCount);

        int builtInCount = countWordsBuiltIn(input);
        System.out.println("count (Built-in): " + builtInCount);
    }

    // --- PART 1: Manual Logic (The logic from your snippet) ---
    public static int countWordsManually(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        char[] text = str.toCharArray();
        int count = 0;
        boolean inWord = false;

        for (int i = 0; i < text.length; i++) {
            if (text[i] != ' ' && !inWord) {
                count++;
                inWord = true; 
            } 
            // If current char IS a space
            else if (text[i] == ' ') {
                inWord = false;
            }
        }
        return count;
    }
    // --- PART 2: Built-in Functions (The shortcut) ---
    public static int countWordsBuiltIn(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        String[] words = str.trim().split("\\s+");
        
        return words.length;
    }
}
