package com.example.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Asteroides extends Activity {
	private Button bAcercaDe;
	private Button bSalir;
	
	@Override public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		 bAcercaDe =  (Button) findViewById(R.id.button03);
		 bSalir = (Button) findViewById(R.id.button4);
		 
		 bSalir.setOnClickListener(new OnClickListener() {
			 public void onClick(View view){
				 finish();
			 }
		 }
		 );
	        bAcercaDe.setOnClickListener(new OnClickListener() {

	                   public void onClick(View view) {

	                        lanzarAcercaDe(null);

	                  }

	            });
	}


	@Override public boolean onCreateOptionsMenu(Menu menu) {
	       super.onCreateOptionsMenu(menu);
	       MenuInflater inflater = getMenuInflater();
	       inflater.inflate(R.menu.menu, menu);
	       return true; /** true -> el menú ya está visible */
	    }
	   
	    @Override public boolean onOptionsItemSelected(MenuItem item) {
	             switch (item.getItemId()) {
	             case R.id.acercaDe:
	                    lanzarAcercaDe(null);
	                    break;
	             case R.id.config:
	                    lanzarPreferencias(null);
	                    break;
	             }
	             return true; /** true -> consumimos el item, no se propaga*/
	    }
	
	/*public void recur(){
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
	*/
	public void lanzarAcercaDe(View view){
	      Intent i = new Intent(this, AcercaDe.class);
          startActivity(i);
	 }
	public void lanzarPreferencias(View view){
		Intent i = new Intent(this, Preferencias.class);
		startActivity(i);
	 }

}
