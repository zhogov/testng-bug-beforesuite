package example;

import org.testng.annotations.BeforeClass;

public class BaseTest {
    boolean called = false;

    @BeforeClass
    private void init() {
        called = true;
    }
}
