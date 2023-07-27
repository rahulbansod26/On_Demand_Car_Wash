package com.customer.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalResources {

    public static Logger getLogger(Class classname)
    {
        return LoggerFactory.getLogger(classname);
    }

}
