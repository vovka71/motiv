package com.automation.utils.web.driver;

@FunctionalInterface
public interface WebDriverFunctionalProcessor {
    void runFunctionIgnoringException() throws Exception;
}
