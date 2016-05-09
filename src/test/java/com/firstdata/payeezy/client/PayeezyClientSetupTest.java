package com.firstdata.payeezy.client;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by FA7G14Q on 5/2/2016.
 */
public class PayeezyClientSetupTest {

    private PayeezyClientSetup payeezyClientSetup;

    @Test
    public void testPayeezyClientSetup(){
        payeezyClientSetup = new PayeezyClientSetup();
        Assert.assertNotNull(payeezyClientSetup);
    }
}
