package com.example.asteroides;

import android.app.Activity;
import android.os.Bundle;

public class Juego extends Activity {
	private VistaJuego vistaJuego;


	   @Override public void onCreate(Bundle savedInstanceState) {
	          super.onCreate(savedInstanceState);
	          setContentView(R.layout.juego);
	          vistaJuego = (VistaJuego) findViewById(R.id.VistaJuego);
	   }
	   @Override protected void onPause() {
		   super.onPause();
		   //vistaJuego.mSensorManager.unregisterListener(vistaJuego);
		   vistaJuego.getThread().pausar();

		}
		 
		@Override protected void onResume() {
		   super.onResume();
		 //  vistaJuego.mSensorManager.registerListener(vistaJuego, vistaJuego.mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		   vistaJuego.getThread().reanudar();

		}
		 
		@Override protected void onDestroy() {
		   vistaJuego.getThread().detener();
		   super.onDestroy();
		}
	}
