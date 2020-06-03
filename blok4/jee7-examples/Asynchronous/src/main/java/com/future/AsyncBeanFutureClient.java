package com.future;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AsyncBeanFutureClient {

    @EJB
    AsyncBeanFutureService asyncBeanFutureService;

    public AsyncBeanFutureService getAsyncBeanFutureService() {
        return asyncBeanFutureService;
    }
}
