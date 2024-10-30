package com.techhub.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class MathUtilityTest {

    private static MathUtility mathUtility;

    @BeforeAll
    public static void setup(){
        mathUtility = new MathUtility();
    }

    @ParameterizedTest
    @MethodSource("addTestInputs")
    public void addTest(int a, int b, int result){
        Assertions.assertEquals(result, mathUtility.add(a,b));
    }

    private static Stream<Arguments> addTestInputs(){
        return Stream.of(Arguments.arguments(7,3,10));
    }
}
