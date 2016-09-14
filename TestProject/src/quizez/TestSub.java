package quizez;

/**
 * Created by ashsrivast on 05/09/16.
 */
public class TestSub extends TestSuper implements TestInterface {

    @Override
    public void doThis() {
        System.out.println(this.getClass().getSimpleName());
    }

    @Override
    void doForThisMe() {
        super.doForThisMe();
    }
}
