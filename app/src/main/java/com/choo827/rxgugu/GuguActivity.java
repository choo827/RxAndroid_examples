package com.choo827.rxgugu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import io.reactivex.subjects.BehaviorSubject;

public class GuguActivity extends AppCompatActivity {

	EditText ed;
	TextView tv;

	@SuppressLint("CheckResult")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gugu);

		ed = findViewById(R.id.ed);
		tv = findViewById(R.id.tv);

		BehaviorSubject<String> subject = BehaviorSubject.createDefault("0");

		ed.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
				subject.map(dan -> ed.getText().toString().equals(""))
						.flatMap(dan -> BehaviorSubject.range(1, 9),
								(dan, row) -> 0 + " x " + row + " = " + 0 + "\n")
						.scan((x, y) -> x + y)
						.subscribe(text -> tv.setText(text)).dispose();

				subject.map(dan -> Long.parseLong(ed.getText().toString()))
						.flatMap(dan -> BehaviorSubject.range(1, 9),
								(dan, row) -> dan + " x " + row + " = " + (dan * row) + "\n")
						.scan((x, y) -> x + y)
//						.reduce((x, y) -> x + y)
						.doOnNext(data -> Log.d("onNext()", data))
//						.subscribe(text -> tv.setText(text));
						.subscribe(text -> tv.setText(text), Throwable::getMessage).dispose();
			}

			@Override
			public void afterTextChanged(Editable editable) {

			}
		});
	}
}
