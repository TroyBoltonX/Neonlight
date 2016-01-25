package com.qiushi.troybolton.neonlightapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Runnable {

	// Define 5 TextView Color Value
	private int[] colors = new int[] {0xFFFF0000, 0xFF00FF00, 0xFF0000FF, 0xFFFF00FF, 0xFF00FFFF, 0xFFFFFF00};
	private int[] nextColorPointers = new int[] {1, 2, 3, 4, 5, 0};
	private View[] views;
	private int currentColorPointer = 0;
	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		views = new View[] {findViewById(R.id.textView6), findViewById(R.id.textView5),
							findViewById(R.id.textView4), findViewById(R.id.textView3),
							findViewById(R.id.textView2), findViewById(R.id.textView1)};

		handler = new Handler();
		handler.postDelayed(this, 350);
	}

	@Override
	public void run() {
		int nextColorPointer = currentColorPointer;
		for (int i = views.length - 1; i >= 0; i--) {
			views[i].setBackgroundColor(colors[nextColorPointers[nextColorPointer]]);

			nextColorPointer = nextColorPointers[nextColorPointer];
		}
		currentColorPointer++;
		if (currentColorPointer == 6) {
			currentColorPointer = 0;
		}
		handler.postDelayed(this, 350);
	}
}
