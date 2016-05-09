package com.firstdata.payeezy.client;

import java.io.File;

public class PayeezyConfiguration {

    private static final String PAYEEZY_SDK_CONFIG = ".payeezy.properties";
    private static final String PAYEEZY_CFG_DIR = "PAYEEZY_CFG_DIR";

    public File load() {
        File file = new File(System.getProperty("user.home") + File.separator + PAYEEZY_SDK_CONFIG);
        if(System.getProperty("java.specification.version").equals("1.6")) {
            if(System.getProperty(PAYEEZY_CFG_DIR) != null) {
                file = new File(System.getProperty(PAYEEZY_CFG_DIR) + File.separator + PAYEEZY_SDK_CONFIG);
            }
        }
        else {
            if(System.getenv(PAYEEZY_CFG_DIR) != null) {
                if(System.getenv(PAYEEZY_CFG_DIR).equals("classpath:" + PAYEEZY_SDK_CONFIG)) {
                    if (getClass().getClassLoader().getResource(PAYEEZY_SDK_CONFIG) != null) {
                        String filePath = getClass().getClassLoader().getResource(PAYEEZY_SDK_CONFIG).getPath();
                        file = new File(filePath);
                    }
                }
                else {
                    file = new File(System.getenv(PAYEEZY_CFG_DIR) + File.separator + PAYEEZY_SDK_CONFIG);
                }
            }
        }
        return file;
    }

}
