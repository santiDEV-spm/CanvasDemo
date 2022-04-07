package com.santidev.canvasdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //La inicializacion de la zona de dibujo...
        ImageView myImageView  = (ImageView) findViewById(R.id.imageView);
        Bitmap bitmap = Bitmap.createBitmap(750, 1500, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        canvas.drawColor(Color.BLACK);
        paint.setColor(Color.argb(255,255,10,10));

        Random random = new Random();
        for (int i = 0; i < 800; i++){
            int x = random.nextInt(750);
            int y = random.nextInt(1500);
            //diujamos puntos aleatorios
            canvas.drawPoint(x,y,paint);
        }

        //dibujamos linea
        canvas.drawLine(0,0, 750, 1500, paint);
        //canviar colo del pincel
        paint.setColor(Color.argb(255,0,255,50));
        //cambiar tamanio de texto y escribir un texto
        paint.setTextSize(100f);
        canvas.drawText("Hola Canvas!!", 10, 50, paint);

        //pintar circulo
        canvas.drawCircle(500, 500, 120, paint);

        paint.setColor(Color.argb(255,40,40,255));
        //pintar rectangulo
        canvas.drawRect(500,10,200,200, paint);

        //cuando hemos pintado lo que queremos, hay que llevar el bitmap a la image view
        myImageView.setImageBitmap(bitmap);

    }
}