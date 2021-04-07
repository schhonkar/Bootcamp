package com.example.testing

import org.junit.Assert
import org.junit.Test

class EmailUnitTest {

    @Test
    fun testEmailAddress_isCorrect() {
        val emailAddress = "saurabhchhonkar@gmail.com"
        val emailIsCorrect = MainActivity().isEmailValid(emailAddress)
        Assert.assertTrue(emailIsCorrect)
    }

    @Test
    fun testEmailAddressShouldNotBeNull_isCorrect() {
        val emailAddress = ""
        val emailIsCorrect = MainActivity().isEmailValid(emailAddress)
        Assert.assertFalse(emailIsCorrect)
    }

    @Test
    fun testEmailAddressNotContainingDomain_isCorrect(){
        val emailAddress = "saurabh"
        val emailIsCorrect = MainActivity().isEmailValid(emailAddress)
        Assert.assertFalse(emailIsCorrect)

    }

    @Test
    fun testEmailAddressNotStartinWithUnderScore_isCorrect(){
        val emailAddress = "_saurabh@gmail.com"
        val emailIsCorrect = MainActivity().isEmailValid(emailAddress)
        Assert.assertFalse(emailIsCorrect)
    }



}