package org.grade.calculator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class AddClassActivity extends Activity {
	//Holds the number of categories selected by the user
	private int numCats;
	//Layout to add items to
	private LinearLayout ll;
	//Spinner holding potential number of grading categories
	private Spinner s;
	//Array of text view holding the string "Grade Category #" and
	//the number of categories
	private TextView[] gradeCats;
	//Array of text fields to get the category names
	private EditText[] catName;
	//Array of text field to get the percent of the grade for each
	//category
	private EditText[] catPercent;
	//Arrays of text fields to display "Category Name" and 
	//"Percent of Grade" respectively
	private TextView []categoryName, percent;
	//Buttons allowing the user to exit and clear the form, respectively
	private Button exit,clear;

	/**********************************************
	 *  Called when the activity is first created. 
	 **********************************************/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addclassview);
		//Get the layout so more GUI items can be added in createForm()
		ll = (LinearLayout)findViewById(R.id.linearLayout1);
		//Get the spinner so that the user selection can be retrieved
		s = (Spinner)findViewById(R.id.numGradeCategories);
		s.setOnItemSelectedListener(new OnItemSelectedListener(){
			/*********************************************************
			 * When an item is selected from the spinner, createForm()
			 * is called creating a form based on the user's selection.
			 *********************************************************/
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				createForm();
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
	}
	/**************************************************************************************************
	 * This method creates a form semi-dynamically (Class name, number of grading categories, and their
	 * respective text views are created via addclassview.xml for simplicity. Allows a user to specify
	 * numbing of grading categories for the class they are adding. based on the selection of the user,
	 * the appropriate number of text views and text boxes are created.
	 **************************************************************************************************/
	public void createForm(){
		//Get number of grade categories
		numCats = s.getSelectedItemPosition();
		//Create text views
		gradeCats = new TextView[numCats];
		//Create text fields
		catName = new EditText[numCats];
		//Create text fields
		catPercent = new EditText[numCats];
		//Create text views
		categoryName = new TextView[numCats];
		//Create text views
		percent = new TextView[numCats];
		//Create clear button
		clear = new Button(this);
		clear.setText("Clear Form");
		clear.setLayoutParams(new ViewGroup.LayoutParams(200, 80));
		//Create "Add Class" button
		exit = new Button(this);
		exit.setText("Add Class");
		exit.setLayoutParams(new ViewGroup.LayoutParams(200, 80));
		if(numCats>0){
			for (int i = 0; i < numCats; i++) {
				//Create "Grade Category" text view
				gradeCats[i] = new TextView(this);
				gradeCats[i].setText("Grade Category #" + (i+1));
				//Add "Grade Category #i" text views
				ll.addView(gradeCats[i]);
				//Create "Category Name" text views
				categoryName[i] = new TextView(this);
				categoryName[i].setText("Category Name");
				//Add "Category Name" text view
				ll.addView(categoryName[i]);
				//Create category name text field
				catName[i] = new EditText(this);
				catName[i].setLayoutParams(new ViewGroup.LayoutParams(200, LayoutParams.WRAP_CONTENT));
				//Add category name text fields
				ll.addView(catName[i]);
				//Create "Percent of Grade" text views
				percent[i] = new TextView(this);
				percent[i].setText("Percent of Grade");
				//Add "Percent of Grade" text views
				ll.addView(percent[i]);
				//Create percent of grade text fields
				catPercent[i] = new EditText(this);
				catPercent[i].setLayoutParams(new ViewGroup.LayoutParams(200, LayoutParams.WRAP_CONTENT));
				//Add percent of grade text fields
				ll.addView(catPercent[i]);
			}
			//Add "Clear Form" button
			ll.addView(clear);
			//Add "Add Class" button
			ll.addView(exit);
			//set listener for clear button
			clear.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					ll.removeViewsInLayout(4, (ll.getChildCount()-4));
				}
			});
			//set listener for exit button
			exit.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					//Close activity
					finish();
				}
			});
		}
	}
	public void write(String information){
		OutputStream os = null;
		BufferedOutputStream bos;
		File f = getExternalFilesDir(null); 
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			os = new FileOutputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bos = new BufferedOutputStream(os);
	}
}
