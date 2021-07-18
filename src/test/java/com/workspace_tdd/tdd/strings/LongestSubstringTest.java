package com.workspace_tdd.tdd.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import com.workspace_tdd.strings.LongestSubstring;
import com.workspace_tdd.strings.custom_exceptions.EmptyStringException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class LongestSubstringTest {

    private LongestSubstring longestSubstring;

    // Arrange
    private static Stream<Arguments> inputStrings() {
        return Stream.of(
                arguments("abcabcbb", 3),   //The answer is "abc", with the length of 3.
                arguments("bbbbb", 1),      //The answer is "b", with the length of 1.
                arguments("pwwkew", 3)      //The answer is "wke", with the length of 3
        );
    }

    @BeforeEach
    public void setUp() {
      this.longestSubstring = new LongestSubstring();
    
    }
    @DisplayName("Test if correct length of longest substring is returned")
    @ParameterizedTest
    @MethodSource("inputStrings")
    public void testLongestSubstring_ShouldReturnLongestSubStrLen(String str, int expected) throws EmptyStringException{

        // Act
        int result = longestSubstring.lengthOfLongestSubstring(str);

        // Assert
        Assertions.assertEquals(expected, result);

    }
    
    @DisplayName("Test if correct Exception is thrown")
    @Test
    public void testLongestSubstring_StringIsEmpty_ShouldThrowEmptyStringException() throws EmptyStringException {
        
        Exception exception = assertThrows(EmptyStringException.class, () ->
        longestSubstring.lengthOfLongestSubstring(""));

        assertEquals("You have passed an empty string", exception.getMessage());

      }

    
}
