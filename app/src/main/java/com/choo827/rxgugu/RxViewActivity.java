package com.choo827.rxgugu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import io.reactivex.Observable;


public class RxViewActivity extends AppCompatActivity {
	EditText ed;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rx_view);

		ed = findViewById(R.id.ed);
		tv = findViewById(R.id.tv);

		ed.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
				Observable.just(ed.getText().toString())
						.doOnNext(data -> Log.d("onNext()", data))
						.subscribe(text -> tv.setText(text));
			}

			@Override
			public void afterTextChanged(Editable editable) {

			}
		});

	}

}
