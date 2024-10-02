package CommonUtilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.Base_Test;

public class Testutils extends Base_Test
{	
	public Testutils() throws IOException, FileNotFoundException {
		super();
	
	}

	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
