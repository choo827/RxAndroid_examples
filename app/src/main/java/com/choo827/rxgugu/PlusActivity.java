package com.choo827.rxgugu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class PlusActivity extends AppCompatActivity {

	EditText ed1, ed2;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_plus);

		ed1 = findViewById(R.id.ed1);
		ed2 = findViewById(R.id.ed2);
		tv = findViewById(R.id.tv);

	}
}
