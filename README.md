# learn-junit

<!-- TOC -->

- [learn-junit](#learn-junit)
    - [resource](#resource)
    - [how to generate a unit test?](#how-to-generate-a-unit-test)
    - [sample test method](#sample-test-method)
    - [assertSomething](#assertsomething)
        - [assertTrue](#asserttrue)
        - [assertFalse](#assertfalse)
        - [assertThrows](#assertthrows)
        - [assertAll](#assertall)
        - [assertNull](#assertnull)

<!-- /TOC -->

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
`org.junit.jupiter.api.function.Executable` for Executable above

### assertAll
```java
   @Test
    void should_ReturnCoderWithWorstBMI_WhenCoderListNotEmpty() {
        // given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));

        // when
        Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        // then
        assertAll(
            () -> assertEquals(1.82, coderWithWorstBMI.getHeight()),
            () -> assertEquals(98.0, coderWithWorstBMI.getWeight())
        );
    }
```
if you have multiple assertion, make sure they are in `assertAll(...);` otherwise, former assertion failure will hide following assertions

### assertNull
```java
    @Test
    void should_ReturnNullWorstBMI_WhenCoderListEmpty() {
        // given
        List<Coder> coders = new ArrayList<>();

        // when
        Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        // then
        assertNull(coderWithWorstBMI);
    }
```

