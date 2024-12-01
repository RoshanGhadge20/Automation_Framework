package ScreenRecording;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

public class CaptureVideo {

	public void StartRecording() {
		// start screen recording
		try {
			ScreenRecorderUtil.startRecord("main");
		} catch (Exception e) {
			System.out.println("Unable to start recording " + e.getMessage());
		}
	}

	public void StopRecording() {
		// stop recording
		try {
			ScreenRecorderUtil.stopRecord();
		} catch (Exception e) {
			System.out.println("Unable to stop recording " + e.getMessage());
			e.printStackTrace();
		}

	}
}