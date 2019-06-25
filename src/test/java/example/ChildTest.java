package example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ChildTest extends BaseTest {
    @Test
    public void testFails() {
        assertTrue(called, "Should have been set in @Before");
    }
}
