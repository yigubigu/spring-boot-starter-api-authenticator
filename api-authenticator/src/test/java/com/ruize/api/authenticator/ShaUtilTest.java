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
        System.out.println(hash);

    }
}
