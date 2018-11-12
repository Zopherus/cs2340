package cs2340.donationtracker.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Anna bonatz
 * @version 1.0
 */
public class AccountTest {
    private Account test1 = new Account("abcd", "1234");
    @Test
    public void checkValidTrue() {
        assertEquals(true, test1.checkValid("abcd", "1234"));
    }

    @Test
    public void checkValidFalseUsername() {
        assertEquals(false, test1.checkValid("hello", "1234"));
    }

    @Test
    public void checkValidFalsePassword() {
        assertEquals(false, test1.checkValid("abcd", "nope"));
    }

    @Test
    public void checkValidFalseBoth() {
        assertEquals(false, test1.checkValid("hello", "yay"));
    }
}