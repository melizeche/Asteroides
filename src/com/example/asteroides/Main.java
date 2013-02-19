package com.example.asteroides;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void recur(){
		Resources res =getResources();
		//Drawable drawable =res.getDrawable(R.drawable.asteroide);
		String saludo = res.getString(R.string.saludo);
		int color =res.getColor(R.color.verde_opaco);
		float tamanoFuente =res.getDimension(R.dimen.tamano_fuente);
		int maxAsteroides =res.getInteger(R.integer.max_asteroides);
		boolean ilimitados = res.getBoolean(R.bool.misiles_ilimitados);
		String[] diasSemana =res.getStringArray(R.array.dias_semana);
		int[] primoss =res.getIntArray(R.array.primos);
		//TypedArray asteroides =res.obtainTypedArray(R.array.asteroides);
		//Drawable asteroide1 =asteroides.getDrawable(0);
	}

}
