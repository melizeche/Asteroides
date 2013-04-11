package com.example.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
//Utilizar otro tipo de sensor y derregistrar los sensores no está hecho
public class Asteroides extends Activity {
	//Creamos algunas variables como botones y el almacen de puntuaciones
	private Button bAcercaDe;
	private Button bSalir;
	public static AlmacenPuntuaciones almacen = new AlmacenPuntuacionesArray();
	public MediaPlayer mp;
	@Override public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//asignamos los botones a los objetos creados
		 bAcercaDe =  (Button) findViewById(R.id.button03);
		 bSalir = (Button) findViewById(R.id.button4);
		 
		 //Creamos el listener, equivalente al onClick del xml
		 bSalir.setOnClickListener(new OnClickListener() {
			 public void onClick(View view){
				 //finish();
				 lanzarPuntuaciones(view);
			 }
		 }
		 );
	        bAcercaDe.setOnClickListener(new OnClickListener() {

	                   public void onClick(View view) {

	                        lanzarAcercaDe(null);

	                  }

	            });
	        mp = MediaPlayer.create(this, R.raw.audio);
	        mp.start();
	}


	@Override public boolean onCreateOptionsMenu(Menu menu) {
	       super.onCreateOptionsMenu(menu);
	       MenuInflater inflater = getMenuInflater();
	       inflater.inflate(R.menu.menu, menu);
	       Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
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
	
//que hacen los botones
	public void lanzarAcercaDe(View view){
	      Intent i = new Intent(this, AcercaDe.class);
          startActivity(i);
	 }
	public void lanzarPreferencias(View view){
		Intent i = new Intent(this, Preferencias.class);
		startActivity(i);
	 }
	public void lanzarPuntuaciones(View view) {
		Intent i = new Intent(this, Puntuaciones.class);
		startActivity(i);
		}
	public void lanzarJuego(View view) {
		Intent i = new Intent(this, Juego.class);
		startActivity(i);
		}
	@Override protected void onStart() {
		   super.onStart();
		   Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
		}
		 
		@Override protected void onResume() {
		   super.onResume();
		   mp.start();
		   Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
		}
		 
		@Override protected void onPause() {
		   Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
		   //mp.pause();
		   super.onPause();
		}
		 
		@Override protected void onStop() {
		   Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
		   mp.pause();
		   super.onStop();
		}
		 
		@Override protected void onRestart() {
		   super.onRestart();
		   Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
		}
		 
		@Override protected void onDestroy() {
		   Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
		   super.onDestroy();
		}
		@Override
		   protected void onSaveInstanceState(Bundle estadoGuardado){
		          super.onSaveInstanceState(estadoGuardado);
		          if (mp != null) {
		                 int pos = mp.getCurrentPosition();
		                 estadoGuardado.putInt("posicion", pos);
		          }
		   }
		 
		   @Override
		   protected void onRestoreInstanceState(Bundle estadoGuardado){
		          super.onRestoreInstanceState(estadoGuardado);
		          if (estadoGuardado != null && mp != null) {
		                 int pos = estadoGuardado.getInt("posicion");
		                 mp.seekTo(pos);
		          }
		   }
}
