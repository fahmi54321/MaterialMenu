package com.android.a58materialmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.balysv.materialmenu.MaterialMenu;
import com.balysv.materialmenu.MaterialMenuDrawable;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //todo 1
    Toolbar toolbar;
    int actionBarMenuState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo 2
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //todo 3
        MaterialMenuDrawable materialMenuDrawable = new MaterialMenuDrawable(this, Color.WHITE,MaterialMenuDrawable.Stroke.THIN);
        toolbar.setNavigationIcon(materialMenuDrawable);


        //todo 4
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionBarMenuState = generateState(actionBarMenuState);
                getMaterialMenu(toolbar).animateIconState(intToState(actionBarMenuState));
            }
        });
    }

    //todo 6
    private int generateState(int actionBarMenuState) {
        int gen = new Random().nextInt(4);
        return gen != actionBarMenuState?gen:generateState(actionBarMenuState);
    }

    //todo 5
    private MaterialMenuDrawable.IconState intToState(int actionBarMenuState) {
        switch (actionBarMenuState){
            case 0:{
                return MaterialMenuDrawable.IconState.BURGER;
            }
            case 1:{
                return MaterialMenuDrawable.IconState.ARROW;
            }
            case 2:{
                return MaterialMenuDrawable.IconState.CHECK;
            }
            case 3:{
                return MaterialMenuDrawable.IconState.X;
            }
            default:{
                return MaterialMenuDrawable.IconState.BURGER;
            }
        }
    }

    //todo 7
    private MaterialMenu getMaterialMenu(Toolbar toolbar) {
        return (MaterialMenuDrawable)toolbar.getNavigationIcon();
    }
}