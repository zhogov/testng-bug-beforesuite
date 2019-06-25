package example;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NoInheritanceTest {
    boolean called = false;

    @BeforeClass
    private void init() {
        called = true;
    }

    @Test
    public void testWorks() {
        assertTrue(called, "Should have been set in @Before");
    }
}
