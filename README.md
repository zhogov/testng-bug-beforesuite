# Test case for [TestNG issue 2097](https://github.com/cbeust/testng/issues/2097)

### TestNG Version
6.14.3 and 7.0.0-beta3, Java 8 and 11

### Actual behavior
Private `@Before*` methods not called when defined in a base class, but work when defined in same class.

### Expected behavior
Private `@Before*` methods should be called, whether they were inherited or not

### Is the issue reproductible on runner?

- [ ] Shell
- [ ] Maven
- [x] Gradle
- [ ] Ant
- [ ] Eclipse
- [x] IntelliJ
- [ ] NetBeans


### Test case sample
Following test passes - calls `@BeforeMethod`
```
public class NoInheritanceTest {
    boolean called = false;

    @BeforeMethod
    private void init() {
        called = true;
    }

    @Test
    public void testWorks() {
        assertTrue(called, "Should have been set in @Before");
    }
}
```

Following test fails - `@BeforeMethod` is not called:
```
public class ChildTest extends BaseTest {
    @Test
    public void testFails() {
        assertTrue(called, "Should have been set in @Before");
    }
}
```
```
public class BaseTest {
    boolean called = false;

    @BeforeMethod
    private void init() {
        called = true;
    }
}
```

Test case project: https://github.com/zhogov/testng-issue-2097