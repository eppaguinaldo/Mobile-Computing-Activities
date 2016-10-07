package com.example.earl.firstandroidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Earl on 06/10/2016.
 */
public class OnTouch extends AppCompatActivity {
    TextView p1Text, p2Text, diffText, motText, quadText;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ontouch);

        p1Text = (TextView) findViewById(R.id.p1TextView);
        p2Text = (TextView) findViewById(R.id.p2TextView);
        diffText = (TextView) findViewById(R.id.difeTextView);
        motText = (TextView) findViewById(R.id.motiTextView);
        quadText = (TextView) findViewById(R.id.quadraTextView);

        image = (ImageView) findViewById(R.id.item);

        image.setOnTouchListener(new View.OnTouchListener() {
            float initialX, initialY, finalX, finalY, difX, difY;
            String coo1, coo2, diff, q1, q2, q3, q4;
            int tap;

            @Override
            public boolean onTouch(View view, MotionEvent event){
                int action = event.getAction();
                switch(action) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = event.getX();
                        initialY = event.getY();
                        coo1 = "" + initialX + "&" + initialY;
                        p1Text.setText(coo1);
                        return true;

                    case MotionEvent.ACTION_UP:
                        finalX = event.getX();
                        finalY = event.getY();
                        coo2 = "" + finalX + "&" + finalY;
                        if(initialX>finalX) {
                            difX = initialX-finalX;
                        }
                        else if(finalX>initialX){
                            difX = finalX-initialX;
                        }
                        else{
                            difX = finalX - initialX;
                        }
                        if(initialY>finalY){
                            difY = initialY - finalY;
                        }
                        else if(finalY>initialY){
                            difY = finalY - initialY;
                        }
                        else{
                            difY = finalY - initialY;
                        }
                        diff = "" + difX + "&" + difY;
                        p2Text.setText(coo2);
                        diffText.setText(diff);
                        String x=String.valueOf(difX);
                        String y=String.valueOf(difY);

                        q1 = "Quadrant 1";
                        q2 = "Quadrant 2";
                        q3 = "Quadrant 3";
                        q4 = "Quadrant 4";

                        if(difX < 0.01 && difY < 0.01){
                            motText.setText("No Motion done");
                            quadText.setText("");
                        }
                        else {

                            if (initialX < finalX && initialY > finalY) {
                                motText.setText("Left to Right, Down to Up");
                                quadText.setText(q1);
                            }
                            if (initialX > finalX && initialY > finalY) {
                                motText.setText("Right to Left, Down to Up");
                                quadText.setText(q2);


                            }
                            if (initialX < finalX && initialY < finalY) {
                                motText.setText("Left to Right, Up to Down");
                                quadText.setText(q4);


                            }
                            if (initialX > finalX && initialY < finalY) {
                                motText.setText("Right to Left, Up to Down");
                                quadText.setText(q3);
                            }
                        }

                        return true;
                }
                return false;
            }

        });
    }
}
