package quizez;

/**
 * Created by ashsrivast on 05/09/16.
 */
public class TestSuper {
    static void doForThisMeAsClass() {
        System.out.println("Hello" + new TestSuper().getClass().getSimpleName());
    }

    void doForThisMe() {
        System.out.println("Hello" + new TestSuper().getClass().getSimpleName());
    }
}
