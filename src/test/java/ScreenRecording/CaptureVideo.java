package ScreenRecording;

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