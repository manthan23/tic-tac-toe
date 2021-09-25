package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int activePlayer=0;
    int gameState[]={2,2,2,2,2,2,2,2,2};
    int winPos[][]={{0,1,2}, {3,4,5}, {6,7,8,},
                    {0,3,6},{1,4,7},{2,5,8},
                    {0,4,8},{2,4,8}};
    public void PlayerTap(View view) {
        ImageView img=(ImageView) view;
        int tappedImage=Integer.parseInt(img.getTag().toString());
        if(gameState[tappedImage]==2) {
            gameState[tappedImage] = activePlayer;
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer=1;
            }else{
                img.setImageResource(R.drawable.o);
                activePlayer=0;
            }
        }
        for(int i=0;i<winPos.length;i++){
                if(gameState[winPos[i][0]]==gameState[winPos[i][1]]&& gameState[winPos[i][0]]==gameState[winPos[i][2]]){
                    TextView tx=findViewById(R.id.result);
                    if(gameState[winPos[i][0]]==0){
                        tx.setText("X Wins");
                        gameReset(view);
                    }else if(gameState[winPos[i][0]]==1){
                        tx.setText("O Wins");
                        gameReset(view);
                    }
                    break;
                }
        }
    }
    public void gameReset(View view){
     activePlayer=0;
        for(int k=0;k<gameState.length;k++){
            gameState[k]=2;
        }
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}