package com.shanegenschaw.cervezacountdown;

import org.joda.time.Duration;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String LOG_TAG = "CERVESA";
	private CountDownTimer timer;
    private TextView headerText1;
    private TextView headerText2;
    private LinearLayout timerLayout;
	private TextView daysValue;
	private TextView hoursValue;
	private TextView minutesValue;
	private TextView secondsValue;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        headerText1 = (TextView) findViewById(R.id.headerText1);
        headerText2 = (TextView) findViewById(R.id.headerText2);
        timerLayout = (LinearLayout) findViewById(R.id.timerLayout);
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
	public boolean onOptionsItemSelected(final MenuItem item) {
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
	public boolean onCreateOptionsMenu(final Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	protected void startTimer() {
		final Duration duration = CountdownFactory.getDuration();
		timer = new CountDownTimer(duration.getMillis(), 1000) {

			@Override
			public void onTick(final long millisUntilFinished) {
                refreshView(Duration.millis(millisUntilFinished));
			}

			@Override
			public void onFinish() {
                onTimerFinish();
			}

		};
		timer.start();
		refreshView(duration);
	}

	protected void refreshView(final Duration d) {
		final Countdown cd = CountdownFactory.durationToCountdown(d);
		daysValue.setText("" + cd.getDays());
		hoursValue.setText("" + cd.getHours());
		minutesValue.setText("" + cd.getMinutes());
		secondsValue.setText("" + cd.getSeconds());
	}

    protected void onTimerFinish() {
        Log.d(LOG_TAG, "onTimerFinish");
        Toast.makeText(this, R.string.welcomeToMexico, Toast.LENGTH_SHORT).show();
        timerLayout.setVisibility(View.GONE);
        headerText1.setText(R.string.welcomeToMexico);
        headerText2.setText(R.string.moreBeerPlease);
    }

	protected void cancelTimer() {
		if (null != timer) {
			timer.cancel();
			timer = null;
		}
	}

}
