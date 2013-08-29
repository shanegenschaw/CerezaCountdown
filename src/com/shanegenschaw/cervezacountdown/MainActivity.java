package com.shanegenschaw.cervezacountdown;

import org.joda.time.Duration;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String LOG_TAG = "CERVESA";
	private CountDownTimer timer;
	private TextView timerText;
	private TextView daysValue;
	private TextView hoursValue;
	private TextView minutesValue;
	private TextView secondsValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		daysValue = (TextView) findViewById(R.id.daysValue);
		hoursValue = (TextView) findViewById(R.id.hoursValue);
		minutesValue = (TextView) findViewById(R.id.minutesValue);
		secondsValue = (TextView) findViewById(R.id.secondsValue);
		Log.d(LOG_TAG, "onCreate");
	}

	@Override
	protected void onDestroy() {
		Log.d(LOG_TAG, "onDestroy");
		cancelTimer();
		super.onDestroy();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(LOG_TAG, "onResume");
		startTimer();
	}

	@Override
	protected void onStop() {
		Log.d(LOG_TAG, "onStop");
		cancelTimer();
		super.onStop();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			Toast.makeText(this, "Nothing to see here yet...",
					Toast.LENGTH_SHORT).show();
			return true;
		case R.id.action_exit:
			this.finish();
			return true;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	protected void startTimer() {
		long millisUntilMexico = CountdownFactory.getDuration().getMillis();
		timer = new CountDownTimer(millisUntilMexico, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {
				refreshView(millisUntilFinished);
			}

			@Override
			public void onFinish() {
				timerText.setText("We're off...");
			}

		};
		timer.start();
		refreshView(millisUntilMexico);
	}

	protected void refreshView(long millisUntilFinished) {
		Duration d = Duration.millis(millisUntilFinished);
		Countdown cd = CountdownFactory.durationToCountdown(d);
		daysValue.setText("" + cd.getDays());
		hoursValue.setText("" + cd.getHours());
		minutesValue.setText("" + cd.getMinutes());
		secondsValue.setText("" + cd.getSeconds());
	}

	protected void cancelTimer() {
		if (null != timer) {
			timer.cancel();
			timer = null;
		}
	}

}
