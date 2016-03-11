package com.ces.research;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

/**
 * UIHelper - This Class contains common methods for performing actions on
 * browser .
 * 
 * @author Automation Team
 *
 */

public class UIHelper {
    /**
     * . MINPOLLINGTIME
     */
    public static final int MINPOLLINGTIME = 100;
    /**
     * . MINPOLLINGTIMEX2
     */
    public static final int MINPOLLINGTIMEX2 = 300;
    /**
     * . POLLINGEVERYSECTIME
     */
    public static final int POLLINGEVERYSECTIME = 3;
    /**
     * . MAXPOLLINGTIME
     */
    public static final int MAXPOLLINGTIME = 180;
    /**
     * . MAXPOLLINGTIMELARGE
     */
    public static final int MAXPOLLINGTIMELARGE = 9000000;
    /**
     * . HIGHLIGHTERINT
     */
    public static final int HIGHLIGHTERINT = 5;
    /**
     * . HIGHLIGHTERINTMAX
     */
    public static final int HIGHLIGHTERINTMAX = 10;
    /**
     * . WAITTIMEOUT
     */
    public static final int WAITTIMEOUT = 2000;
    /**
     * . TOTALATTEMPT
     */
    public static final int TOTALATTEMPT = 100000;

    /*
     * Comments by - Srinivasa Vegi Function - Wait for Page to Load
     */

    /**
     * .
     * 
     * @param driver
     *            FIFA
     */
    public static void waitForPageToLoad(final WebDriver driver) {
        try {
            (new WebDriverWait(driver, MINPOLLINGTIME))
                    .until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(final WebDriver d) {
                            return (((org.openqa.selenium.JavascriptExecutor) driver)
                                    .executeScript("return document.readyState")
                                    .equals("complete"));
                        }
                    });
        } catch (Exception e) {

        }
    }

    /*
     * Comments by - Srinivasa Vegi Function - Select from Dropdown Listbox
     * multiple times on a condition Purpose - Select multiple values from
     * Dropdown Listbox list box
     */
    /**
     * .
     * 
     * @param driver
     *            FIFA
     * @param element
     *            FIFA
     * @param someText
     *            FIFA
     * @param clickThisElement
     *            FIFA
     */
    public static void selectMultipleOnCondition(final WebDriver driver,
            final WebElement element, final ArrayList<String> someText,
            final WebElement clickThisElement) {

        ArrayList<String> someTextList = new ArrayList<String>();

        try {

            Select clickThis = new Select(element);

            List<WebElement> selectOptions = clickThis.getOptions();

            for (WebElement temp : selectOptions) {

                for (String some : someText) {

                    if (temp.getText().equalsIgnoreCase(some.toString().trim())) {

                        someTextList.add(temp.getText().toString().trim());

                    }

                }
            }

            for (String some : someTextList) {

                if (some.length() > 0) {

                    clickThis.selectByVisibleText(some);

                }
                highlightElement(driver, clickThisElement);
                clickThisElement.click();
            }
        } catch (Exception e) {

        }
    }

    /*
     * Comments by - Srinivasa Vegi Function - Select from Dropdown Listbox
     * multiple times Purpose - Select multiple values from Dropdown Listbox
     * list box
     */

    /**
     * .
     * 
     * @param driver
     *            FIFA
     * @param element
     *            FIFA
     * @param someText
     *            FIFA
     * @param clickThisElement
     *            FIFA
     */

    public static void selectMultipleFromDropdownList(final WebDriver driver,
            final WebElement element, final ArrayList<String> someText,
            final WebElement clickThisElement) {

        try {

            Select clickThis = new Select(element);

            for (String some : someText) {
                if (some.length() > 0) {

                    clickThis.selectByVisibleText(some);

                }
                highlightElement(driver, clickThisElement);
                clickThisElement.click();

            }
        } catch (Exception e) {

        }

    }

    /**
     * .
     * 
     * @param myELT
     *            FIFA
     * @param getAllOptions
     *            FIFA
     */

    public static void getAllAvailableOptions(final WebElement myELT,
            final ArrayList<String> getAllOptions) {

        try {
            Select selectBox = new Select(myELT);

            List<WebElement> selectOptions = selectBox.getOptions();

            for (WebElement temp : selectOptions) {

                getAllOptions.add(temp.getText());

            }
        } catch (Exception e) {

        }
    }

    /*
     * Comments by - Srinivasa Vegi Function - Add Elements Purpose - Add
     * Element's getText to ArrayList for Iteration
     */
    /**
     * .
     * 
     * @param driver
     *            FIFA
     * @param xpath
     *            FIFA
     * @param someStringSet
     *            FIFA
     */
    public static void findandAddElementsToaList(final WebDriver driver,
            final String xpath, final ArrayList<String> someStringSet) {

        try {

            List<WebElement> getArrayMembers = driver.findElements(By
                    .xpath(xpath));

            for (WebElement listData : getArrayMembers) {
                someStringSet.add(listData.getText());
            }
        } catch (Exception e) {

        }
    }

    /*
     * Comments by - Srinivasa Vegi Function - Scroll Purpose - Advanced User
     * Interactions, SCroll to an element
     */

    /**
     * .
     * 
     * @param element
     *            FIFA
     */
    public static void scrollToAnElement(final WebElement element) {

        try {

            Coordinates coordinate = ((Locatable) element).getCoordinates();
            coordinate.onPage();
            coordinate.inViewPort();
        } catch (Exception e) {

        }
    }

    /*
     * Comments by - Srinivasa Vegi Function - Highlighter Purpose - Used for
     * highlighting an element in UI Can be useful and gives a lot of clarity to
     * the Users
     */
    /**
     * .
     * 
     * @param driver
     *            FIFA
     * @param element
     *            FIFA
     */
    public static void highlightElement(final WebDriver driver,
            final WebElement element) {

        try {

            for (int i = 0; i < HIGHLIGHTERINT; i++) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript(
                        "arguments[0].setAttribute('style', arguments[1]);",
                        element, "color: #800000; border: 2px solid blue;");
            }
        } catch (Exception e) {

        }
    }

    /*
     * Comments by - Srinivasa Vegi Function - Compare Values and return True or
     * False
     */

    /**
     * .
     * 
     * @param element
     *            FIFA
     * @param expectedVal
     *            FIFA
     * @return FIFA
     */
    public static boolean compareListValue(final WebElement element,
            final String expectedVal) {
        try {
            boolean flagSection = false;
            Select optionSection = new Select(element);
            List<WebElement> viewSection = optionSection.getOptions();
            for (WebElement ele : viewSection) {
                if (ele.getText().equals(expectedVal)) {
                    new Select(element).selectByVisibleText(expectedVal);
                    Select section = new Select(element);
                    if (section.getFirstSelectedOption().getText()
                            .equalsIgnoreCase(expectedVal)) {
                        flagSection = true;
                        break;
                    }
                }
            }
            return flagSection;
        } catch (Exception e) {

            // e.printStackTrace();
            return false;
        }
    }

    /*
     * Comments by - Srinivasa Vegi Function - Handle Alerts Purpose - click OK
     * in Alerts
     */

    /**
     * .
     * 
     * @param driver
     *            FIFA
     */
    public static void processalert(final WebDriver driver) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, HIGHLIGHTERINT);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {

        }
    }

    /*
     * Comments by - Srinivasa Vegi Function - Process Alert for Import
     */
    /**
     * .
     * 
     * @param driver
     *            FIFA
     * @return FIFA
     */
    public static boolean isDisplayedAlertMessage(final WebDriver driver) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, HIGHLIGHTERINTMAX);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            driver.switchTo().defaultContent();
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Comments by - Srinivasa Vegi Function - Wait
     */

    /**
     * .
     * 
     * @param driver
     *            FIFA
     * @param ajaxElementxpath
     *            FIFA
     */
    public static void waitForInvisibilityOfAjaxImgByXpath(
            final WebDriver driver, final String ajaxElementxpath) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, MINPOLLINGTIMEX2);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By
                    .xpath(ajaxElementxpath)));
        } catch (Exception e) {

        }
    }

    /*
     * Comments by - Naveen Duvvuru
     * 
     * Function - Fluent Wait method for wait for visibility of elements
     */
    public static void waitForVisibilityOfEleByXpath(final WebDriver driver,
            String elementXpath) {

        FluentWait<By> fluentWait = new FluentWait<By>(By.xpath(elementXpath));
        fluentWait.pollingEvery(100, TimeUnit.MILLISECONDS);
        fluentWait.withTimeout(13, TimeUnit.SECONDS);
        fluentWait.until(new Predicate<By>() {
            public boolean apply(final By by) {
                try {

                    return driver.findElement(by).isDisplayed();
                } catch (Exception ex) {

                    return false;
                }
            }
        });
    }

    /*
     * Comments by - Srinivasa Vegi Function - Remove Duplicates from an
     * ArrayList without changing the order
     */

    /**
     * .
     * 
     * @param arraytoRemDuplicates
     *            FIFA
     */
    public static void removeDuplicatesFromArrayList(
            final ArrayList<String> arraytoRemDuplicates) {

        try {

            Set<String> set = new LinkedHashSet<>(arraytoRemDuplicates);

            set.addAll(arraytoRemDuplicates);
            arraytoRemDuplicates.clear();
            arraytoRemDuplicates.addAll(set);

        } catch (Exception e) {

        }
    }

    /*
     * Comments by - Srinivasa Vegi Function - Hover an Element Purpose - Can be
     * used to hover and highlight the presence of an element
     */
    /**
     * .
     * 
     * @param driver
     *            FIFA
     * @param element1
     *            FIFA
     */
    public static void mouseOveranElement(final WebDriver driver,
            final WebElement element1) {

        try {

            Actions action = new Actions(driver);
            UIHelper.highlightElement(driver, element1);

            action.moveToElement(element1).build().perform();

        } catch (Exception e) {

        }
    }

    /*
     * Comments by - Srinivasa Vegi Function - Hover and Click Purpose - Hover
     * an Element and Click on an Element using Action Class
     */
    /**
     * .
     * 
     * @param driver
     *            FIFA
     * @param element1
     *            FIFA
     */
    public static void mouseOverandclickanElement(final WebDriver driver,
            final WebElement element1) {

        try {
            if (element1.isDisplayed()) {
                Actions action = new Actions(driver);
                action.moveToElement(element1).click().build().perform();
            }
        } catch (Exception e) {

        }
    }

    /*
     * Comments by - Srinivasa Vegi Function - Double Click Purpose - Can be
     * used to hover and double click an element
     */

    /**
     * .
     * 
     * @param driver
     *            FIFA
     * @param element1
     *            FIFA
     */
    public static void mouseOverandElementdoubleClick(final WebDriver driver,
            final WebElement element1) {

        try {

            Actions action = new Actions(driver);
            UIHelper.highlightElement(driver, element1);

            action.moveToElement(element1).doubleClick().build().perform();

        } catch (Exception e) {

        }
    }
}
