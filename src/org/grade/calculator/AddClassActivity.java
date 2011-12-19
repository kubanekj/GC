package org.grade.calculator;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class AddClassActivity extends Activity {
	private int numCats = 10;
	private int forms = 0;
	private int selected = 0;
	private LinearLayout ll;
	private Spinner s;
	private TextView[] myTextViews;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addclassview);
		ll = (LinearLayout)findViewById(R.id.linearLayout1);
		s = (Spinner)findViewById(R.id.numGradeCategories);
		selected = 1;
		s.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				createForm();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});
	}
	public void createForm(){

		numCats = s.getSelectedItemPosition() + 1;
		myTextViews = new TextView[numCats]; // create an empty array;
		if(forms == 0){
			if(selected == 0){
				if(numCats>0){
					for (int i = 0; i < numCats; i++) {
						myTextViews[i] = new TextView(this);
						myTextViews[i].setText("Grade Category #" + i);
						ll.addView(myTextViews[i]);
						forms++;
						selected++;
					}
				}
			}else{
				selected--;
			}
		}else{
			for(int i = 0; i < myTextViews.length; i++){
				ll.removeView(myTextViews[i]);
				
				myTextViews[i] = null;
				forms--;
			}
		}
	}

}
