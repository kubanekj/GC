package org.grade.calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ViewClassActivity extends Activity {
	private String info="";
	private String [] classInfo;
	private Button exit, show;
	LinearLayout ll;
	private final static int SHOW_CLASSES =0;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewclass);
		ll = (LinearLayout)findViewById(R.id.find);
		show = new Button(this);
		show.setText("Show Classes");
		show.setLayoutParams(new ViewGroup.LayoutParams(200, 80));
		exit = new Button(this);
		exit.setText("Exit");
		exit.setLayoutParams(new ViewGroup.LayoutParams(200, 80));
		ll.addView(show);
		ll.addView(exit);

		show.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//showDialog(SHOW_CLASSES);
			}
		});
		//set listener for exit button
		exit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//Close activity
				finish();
			}
		});
		read();
	}
	public void read(){
		File sdCard = Environment.getExternalStorageDirectory();
		File dir = new File (sdCard.getAbsolutePath() +"/GC/");
		File full = new File(dir.getAbsolutePath() + "/file.txt");

		String temp;
		try{
			if(full.exists()){
				BufferedReader br = new BufferedReader(new InputStreamReader(
						new FileInputStream(full)));
				while ((temp = br.readLine()) != null){
					info.concat(temp);
					Toast.makeText(this, info.toString(), Toast.LENGTH_LONG);
				}
			}
		}catch(IOException ioe){
		}
	}
	public void splitInput(){
		classInfo = info.split("{");
	}
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case SHOW_CLASSES:
			final CharSequence[] items = {classInfo[0].toString()};

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Classes");
			builder.setItems(items, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int item) {
				}
			});
			AlertDialog alert = builder.create();
			return alert;
		}
		return null;
	}
}
