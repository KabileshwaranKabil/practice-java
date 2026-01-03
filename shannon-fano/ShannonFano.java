import java.util.Scanner;

public class ShannonFano {
    static class Node {
        char symbol;
        double probability;
        String code = "";
        int symCount;
    }

    Node[] nodes;
    public void initializeNodes() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input text: ");
        String text = input.nextLine();

        input.close();
        // Find unique symbols
        char[] uniqueSymbols = new char[256];
        int[] counts = new int[256];
        int uniqueCount = 0;

        for (char c : text.toCharArray()) {
            boolean found = false;
            for (int i = 0; i < uniqueCount; i++) {
                if (uniqueSymbols[i] == c) {
                    counts[i]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                uniqueSymbols[uniqueCount] = c;
                counts[uniqueCount] = 1;
                uniqueCount++;
            }
        }

        nodes = new Node[uniqueCount];
        int total = text.length();

        // Fill nodes array
        for (int i = 0; i < uniqueCount; i++) {
            nodes[i] = new Node();
            nodes[i].symbol = uniqueSymbols[i];
            nodes[i].probability = (double) counts[i] / total;
            nodes[i].symCount=counts[i];
        }

        // Sort nodes by probability in descending order
        for (int i = 0; i < uniqueCount - 1; i++) {
            for (int j = i + 1; j < uniqueCount; j++) {
                if (nodes[i].probability < nodes[j].probability) {
                    Node temp = nodes[i];
                    nodes[i] = nodes[j];
                    nodes[j] = temp;
                }
            }
        }
    }

    public void shannonFano(int start, int end) {
        if (start >= end)
            return;

        int total = 0;
        for (int i = start; i <= end; i++)
            total += nodes[i].symCount;

        int half = total / 2;
        int sum = 0;
        int partition = start;
        for (int i = start; i <= end; i++) {
            sum += nodes[i].symCount;
            if (sum >= half) {
                partition = i;
                break;
            }
        }

        for (int i = start; i <= partition; i++)
            nodes[i].code += "0";
        for (int i = partition + 1; i <= end; i++)
            nodes[i].code += "1";

        shannonFano(start, partition);
        shannonFano(partition + 1, end);
    }

    public void displayCodes() {
        System.out.println("\nSymbol\tFrequency\tProbability\tCode\tNumber of bits");
        for (Node node : nodes) {
            System.out.printf("%c\t %d\t\t %.2f\t\t %s\t\t%d\n",node.symbol,node.symCount,node.probability,node.code,(node.symCount*node.code.length()));
        }
    }

    public static void main(String[] args) {
        ShannonFano sf = new ShannonFano();
        sf.initializeNodes();
        sf.shannonFano(0, sf.nodes.length - 1);
        sf.displayCodes();
    }
}