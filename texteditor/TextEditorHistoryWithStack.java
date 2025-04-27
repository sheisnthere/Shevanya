import java.util.Stack;
import java.util.Scanner;

public class TextEditorHistoryWithStack {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("== Fitur Undo/Redo Dengan Stack ==");

        TextEditorStack textEditor = new TextEditorStack();

        int choice;
        do {

            textEditor.displayText();
            System.out.println("Menu:");
            System.out.println("1. Akses Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            choice = scan.nextInt();
            scan.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> textEditor.accessText();
                case 2 -> textEditor.undo();
                case 3 -> textEditor.redo();
                case 4 -> System.out.println("Keluar...");
                default -> System.out.println("Pilihan tidak valid.");
            }

        } while (choice != 4);
    }
}

class TextEditorStack {
    String currText = "";
    Stack<String> undoStack = new Stack<>();
    Stack<String> redoStack = new Stack<>();
    Scanner scan = new Scanner(System.in);

    public void accessText() {
        System.out.println();
        System.err.println("Ketik sesuatu:");
        String newText = scan.nextLine();

        if (newText.length() < 1) {
            System.out.println("Teks terlalu pendek. Membatalkan...");
            return;
        }

        undoStack.push(currText);
        currText = newText;

        System.out.println();
    }

    public void undo() {
        System.out.println();

        if (undoStack.size() < 1) {
            System.out.println("Tidak ada yang bisa di-undo.");
            return;
        }

        System.out.println("Melakukan Undo...");

        redoStack.push(currText);
        currText = undoStack.pop();

        System.out.println();
    }

    public void redo() {
        System.out.println();

        if (redoStack.size() < 1) {
            System.out.println("Tidak ada yang bisa di-redo.");
            return;
        }

        System.out.println("Melakukan Redo...");

        undoStack.push(currText);
        currText = redoStack.pop();

        System.out.println();
    }

    public void displayText() {
        System.out.println("Text saat ini: \"" + currText + "\"");
    }
}