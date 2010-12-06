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

    	SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(text, text);

		// Commit the edits!
		boolean commit = editor.commit();

		Intent myIntent = new Intent(this, EasyDataStorage.class);
		startActivityForResult(myIntent, 0);

	}

}
