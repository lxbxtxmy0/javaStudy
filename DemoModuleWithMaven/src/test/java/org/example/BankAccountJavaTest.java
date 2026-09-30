package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountJavaTest {

    public BankAccountJava bankAccountJavaA;
    public BankAccountJava bankAccountJavaB;

    @BeforeEach
    void setUp() {
        bankAccountJavaA = new BankAccountJava("custom id", 50);
        bankAccountJavaB = new BankAccountJava();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAccountsCount() {
    }

    @Test
    void getId() {
    }

    @Test
    void getBalance() {
    }

    @Test
    void isActive() {
    }

    @Test
    void setActive() {
    }

    @Test
    void topUpBalance() {
        bankAccountJavaA.topUpBalance(50);
        assertTrue(bankAccountJavaA.isActive());
        assertEquals(100.0,bankAccountJavaA.getBalance());
        assertNotEquals(200.0,bankAccountJavaA.getBalance());
    }

    @Test
    void withdrawFromBalance() {
    }
}