package com.choo827.rxgugu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.widget.RxTextView;

public class RxViewActivity extends AppCompatActivity {
	EditText ed;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rx_view);

		ed = findViewById(R.id.ed);
		tv = findViewById(R.id.tv);

//		disposable = RxTextView.textChanges(ed)
//				.subscribe(text -> {
//			tv.setText(text);
//		});

		RxTextView.textChanges(ed)
				.subscribe(text -> {
					tv.setText(text);
				});
	}

}

/*
	0. 더하기
	1. 구구단 만들기
	2. 색상환 만들기(스펙트럼/ seekbar 3개 [r,g,b] + hex 값) -> 배포
*/
