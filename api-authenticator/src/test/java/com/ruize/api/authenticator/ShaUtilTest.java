package com.ruize.api.authenticator;

import com.ruize.api.authenticator.util.SHAUtil;
import org.junit.Assert;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

public class ShaUtilTest {

    @Test
    public void verifySha() throws NoSuchAlgorithmException {
        String orginalString = "fdsafdsafdsaf&fdsaf&fdasfdas";
        String hash = SHAUtil.SHA(orginalString);
        String expectedString = "sA0FQ0Sh1no6C+a8BH/z24tancTF5N3blGzOTEqG5rA=";
        Assert.assertTrue(hash.equals(expectedString));

    }
}
