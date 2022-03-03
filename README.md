# learn-junit
## resource
- [testing code standard: Modern Best Practices for Testing in Java](https://phauer.com/2019/modern-best-practices-testing-java/)
- [video course: Practical Java Unit Testing with JUnit 5](https://www.udemy.com/course/junit5-for-beginners/)

## how to generate a unit test?
intelliJ: alt + enter yout method name ```then your test will be generated```
## sample test method
```java
    /**
     * bad: assertTrue(BMICalculator.isDietRecommended(89.0, 1.72));
     */
    @Test
    void should_ReturnTrue_When_DietRecommended() {
        // given
        double weight = 89.0;
        double height = 1.72;

        // when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        // then
        assertTrue(recommended);
    }
```
## assertSomething
### assertTrue
```java
    @Test
    void should_ReturnTrue_When_DietRecommended() {
        // given
        double weight = 89.0;
        double height = 1.72;

        // when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        // then
        assertTrue(recommended);
    }
```
### assertFalse
```java
    @Test
    void should_ReturnFalse_When_DietNotRecommended() {
        // given
        double weight = 89.0;
        double height = 1.72;

        // when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        // then
        assertFalse(recommended);
    }
```
### assertThrows
```java
    @Test
    void should_ThrowArithmeticException_When_HeightZero() {
        // given
        double weight = 89.0;
        double height = 0.0;

        // when
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

        // then
        assertThrows(ArithmeticException.class, executable);
    }
```
org.junit.jupiter.api.function.Executable
