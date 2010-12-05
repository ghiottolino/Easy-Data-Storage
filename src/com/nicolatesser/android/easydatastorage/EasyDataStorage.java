package com.nicolatesser.android.easydatastorage;

import java.util.List;
import java.util.Vector;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class EasyDataStorage extends Activity {
	
    private TextView mTextView;
    private ListView mListView;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // gui elements
        
        mTextView = (TextView) findViewById(R.id.text);
        mListView = (ListView) findViewById(R.id.list);

    }
    
    protected List<String> getData()
    {
    	List<String> data = new Vector<String>();
    	data.add("test");
    	return data;
    }
    
    protected void showData(final List<String> data)
    {
    	int size = data.size();
    	
    	if (size==0)
    	{
    		mTextView.setText("No records are present. Click on the menu button and then click on add to add some records.");
    	}
    	else
    	{
    		mTextView.setText("Displaying '"+size+" 'records.");
    		
    		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.data,R.id.value, data);
    		
    		mListView.setAdapter(adapter);
    		
    		OnItemClickListener listener = new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					copyTextToClipboard(data,(int)arg2);					
				}
			};;;
			mListView.setOnItemClickListener(listener );
    	}
    }
    
	
	protected void copyTextToClipboard(List<String> data, int id)
	{
		String textToCopy = data.get(id).toString();
		showTextToClipboardNotification(textToCopy);
		ClipboardManager clipboard = 
		      (ClipboardManager) getSystemService(CLIPBOARD_SERVICE); 
		clipboard.setText(textToCopy);
		
	}
	
	
	protected void showTextToClipboardNotification(String copiedText)
	{
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		String text = "The text '"+copiedText+"' has been copied to the clipboard.";
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
		
	}
}