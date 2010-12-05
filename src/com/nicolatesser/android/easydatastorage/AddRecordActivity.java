package com.nicolatesser.android.easydatastorage;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class AddRecordActivity extends Activity {

	private EditText editText;

	public static final String PREFS_NAME = "EASY_DATA_STORAGE";

	public static final String PREFS_N_KEY = "n";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form);
		editText = (EditText) findViewById(R.id.form_name);
	}

	public void myClickHandler(View view) {
		switch (view.getId()) {
		case R.id.form_save: {
			saveText(editText.getText().toString());
			break;
		}
		}
	}

	protected void saveText(String text) {

		SharedPreferences settings = getPreferences(0);
		String nValue = settings.getString(PREFS_N_KEY, "0");
		int n = Integer.parseInt(nValue);
		n++;
		nValue = Integer.toString(n);

		SharedPreferences.Editor editor = settings.edit();
		editor.putString(nValue, text);
		editor.putString(PREFS_N_KEY, nValue);

		// Commit the edits!
		boolean commit = editor.commit();

		Intent myIntent = new Intent(this, EasyDataStorage.class);
		startActivityForResult(myIntent, 0);

	}

}
