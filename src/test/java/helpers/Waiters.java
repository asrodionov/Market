package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.DataClass.*;

public class Waiters {
    /**
     * Wait for visibility element.
     *
     * @param driver browser driver
     * @param element web element to waiting
     */
    public static void waitUntilElementVisibility(final WebDriver driver,
                                                  final WebElement element) {
        new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for expected number of element element.
     *
     * @param driver browser driver
     * @param xpath element to waiting
     * @param number number element
     */
    public static void waitNumberOfElementsToBeMoreThan(final WebDriver driver,
                                                    final String xpath,
                                                    final int number) {
        new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                .until(ExpectedConditions
                        .numberOfElementsToBeMoreThan(By.xpath(xpath), number));
    }
}
