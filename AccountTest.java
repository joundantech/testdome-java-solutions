/**
 * Problème : Gestion de Compte Bancaire (TestDome)
 * Règles :
 * 1. La limite de découvert ne peut pas être négative
 * 2. Dépôts/retraits doivent être des montants positifs
 * 3. Un retrait ne peut dépasser le solde + limite de découvert
 */

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private static final double EPSILON = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);
        Assert.assertEquals(0d, account.getOverdraftLimit(), EPSILON); // Vérifie que la limite négative est ramenée à 0
    }

    @Test
    public void depositAndWithdrawShouldNotBeNegative() {
        Account account = new Account(100);
        Assert.assertFalse("Dépôt négatif doit échouer", account.deposit(-20));
        Assert.assertFalse("Retrait négatif doit échouer", account.withdraw(-20));
    }

    @Test
    public void accountCannotStepOverdraftLimit() {
        Account account = new Account(100);
        Assert.assertFalse("Retrait > solde + limite doit échouer", account.withdraw(151));
    }

    @Test
    public void depositAmountToAccountCorrect() {
        Account account = new Account(100);
        Assert.assertTrue("Dépôt valide doit réussir", account.deposit(50));
        Assert.assertEquals("Solde après dépôt incorrect", 50d, account.getBalance(), EPSILON);
    }

    @Test
    public void withdrawAmountToAccountCorrect() {
        Account account = new Account(100);
        account.deposit(100);
        Assert.assertTrue("Retrait valide doit réussir", account.withdraw(50));
        Assert.assertEquals("Solde après retrait incorrect", 50d, account.getBalance(), EPSILON);
    }
}
