import java.util.Stack;

/**
 * The challenge is to move three discs one at a time from tower A to tower C.
 * A larger disc can never be placed on top of a smaller disc.
 */
public class Hanoi {

    /**
     * Define the towers as Stack objects and fill the first one with disks
     */
    private final int numDiscs;
    public final Stack<Integer> tonerA = new Stack<>();
    public final Stack<Integer> tonerB = new Stack<>();
    public final Stack<Integer> tonerC = new Stack<>();

    public Hanoi(int discs) {
        numDiscs = discs;
        for (int i = 0; i <= discs; i++) {
            tonerA.push(i);
        }
    }

    private void move(Stack<Integer> begin,
                      Stack<Integer> end,
                      Stack<Integer> temp,
                      int n) {
        if (n == 1) {
            end.push(begin.pop());
        } else {
            move(begin, temp, end, n - 1);
            move(begin, end, temp, 1);
            move(temp, end, begin, n - 1);
        }
    }

    public void solve() {
        move(tonerA, tonerC, tonerB, numDiscs);
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi(3);
        hanoi.solve();
        System.out.println(hanoi.tonerA);
        System.out.println(hanoi.tonerB);
        System.out.println(hanoi.tonerC);
    }
}
