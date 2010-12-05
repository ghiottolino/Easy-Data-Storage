package com.nicolatesser.android.easydatastorage;

import java.util.List;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class AddRecordActivity extends Activity {

	private EditText editText;

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

	}

}
