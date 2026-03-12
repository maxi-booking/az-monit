package extensions;

import annotations.RetryWithDelay;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class RetryDelayExtension implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext ctx, Throwable t) throws Throwable {
        RetryWithDelay annotation = ctx.getRequiredTestClass()
                .getAnnotation(RetryWithDelay.class);

        if (annotation != null) {
            Thread.sleep(annotation.delayMs());
        }
        throw t;
    }
}