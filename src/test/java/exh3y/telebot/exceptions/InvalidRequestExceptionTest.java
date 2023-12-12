package exh3y.telebot.exceptions;

import static org.junit.Assert.*;

import org.junit.Test;

public class InvalidRequestExceptionTest {

    @Test
    public void testInvalidRequestException() {

        try {

            throw new InvalidRequestException();
        } catch (InvalidRequestException e) {

            assertTrue(true);
        }

        String message = "This is a message!";

        try {

            throw new InvalidRequestException(message);
        } catch (InvalidRequestException e) {

            assertTrue(e.getMessage().equals(message));
        }
    }
}
