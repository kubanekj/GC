package org.grade.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GradeCalculatorActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button exitApp = (Button) findViewById(R.id.exit);
		//exitApp.getBackground().setColorFilter(0xFFFFDD22, PorterDuff.Mode.MULTIPLY);
		exitApp.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		final Button addClassAct = (Button) findViewById(R.id.addClass);
		//exitApp.getBackground().setColorFilter(0xFFFFDD22, PorterDuff.Mode.MULTIPLY);
		addClassAct.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent myIntent = new Intent(GradeCalculatorActivity.this, AddClassActivity.class);
				GradeCalculatorActivity.this.startActivity(myIntent);
			}
		});
		final Button viewClassAct = (Button) findViewById(R.id.viewClass);
		//exitApp.getBackground().setColorFilter(0xFFFFDD22, PorterDuff.Mode.MULTIPLY);
		viewClassAct.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent myIntent = new Intent(GradeCalculatorActivity.this, ViewClassActivity.class);
				GradeCalculatorActivity.this.startActivity(myIntent);
			}
		});
    }
}