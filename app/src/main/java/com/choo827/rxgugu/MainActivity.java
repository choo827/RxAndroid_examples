package com.choo827.rxgugu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

	Button btn1, btn2, btn3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn1 = findViewById(R.id.btn1);
		btn2 = findViewById(R.id.btn2);
		btn3 = findViewById(R.id.btn3);

		btn1.setOnClickListener(v -> {
			startActivity(new Intent(MainActivity.this, RxViewActivity.class));
		});

		btn2.setOnClickListener(view -> {
			startActivity(new Intent(MainActivity.this, GuguActivity.class));
		});

		btn3.setOnClickListener(v -> {
			startActivity(new Intent(MainActivity.this, LoginActivity.class));
		});
	}
}

/*
	0. 더하기
	1. 구구단 만들기
	2. 색상환 만들기(스펙트럼/ seekbar 3개 [r,g,b] + hex 값) -> 배포
*/
