package com.shanegenschaw.cervezacountdown;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		refresh();
	}

	@Override
	protected void onResume() {
		super.onResume();
		refresh();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_refresh:
			this.refresh();
			return true;
		case R.id.action_settings:
			Toast.makeText(this, "Nothing to see here yet...", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.action_exit:
			this.finish();
			return true;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	protected void refresh() {
		Countdown countdown = CountdownFactory.get();
		TextView daysValue = (TextView) findViewById(R.id.daysValue);
		daysValue.setText("" + countdown.getDays());

		TextView hoursValue = (TextView) findViewById(R.id.hoursValue);
		hoursValue.setText("" + countdown.getHours());

		TextView minutesValue = (TextView) findViewById(R.id.minutesValue);
		minutesValue.setText("" + countdown.getMinutes());

		TextView secondsValue = (TextView) findViewById(R.id.secondsValue);
		secondsValue.setText("" + countdown.getSeconds());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
