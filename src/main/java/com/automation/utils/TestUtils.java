package com.automation.utils;

import com.automation.utils.web.driver.WebDriverFunctionalProcessor;

public class TestUtils {

    /**
     * @param numberOfAttempts
     * @param processor
     * @throws Exception
     */
    public static void runFunctionIgnoringException(int numberOfAttempts, WebDriverFunctionalProcessor processor) throws Exception {
        int currentAttempt = 1;
        String errorMessage = "";
        while (currentAttempt <= numberOfAttempts) {
            try {
                Thread.sleep(100);
                processor.runFunctionIgnoringException();
                errorMessage = "";
                break;
            } catch (Exception exc) {
                errorMessage = exc.getMessage();

                System.out.println("Error running function ... " + exc.getMessage());
                Thread.sleep(1000);
            }
            currentAttempt = currentAttempt + 1;
        }
        if (errorMessage != "") {
            throw new Exception(errorMessage);
        }
    }

}
