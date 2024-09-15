package com.example.th_lab2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mainLayout;
    private RelativeLayout loadingLayout;
    private ImageView AnimalView;
    Random random = new Random();
    private int[] AnimalArray= {R.drawable.ic1, R.drawable.ic2, R.drawable.ic3,R.drawable.ic4,R.drawable.ic5,R.drawable.ic6,R.drawable.ic7,R.drawable.ic8};
    private int[] BackgroundArray = {R.color.green,R.color.gray,R.color.gray_2,R.color.orange,R.color.orange_2,R.color.white};
    private void imgrandom(){
        AnimalView = findViewById(R.id.imgview);
        random = new Random();
        int randomAnimalIndex = random.nextInt(AnimalArray.length);
        AnimalView.setImageResource(AnimalArray[randomAnimalIndex]);

        LinearLayout linearLayout = findViewById(R.id.main);
        int randomBackgroundIndex = random.nextInt(BackgroundArray.length);
        linearLayout.setBackgroundColor(BackgroundArray[randomBackgroundIndex]);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mainLayout = findViewById(R.id.main);
        loadingLayout = findViewById(R.id.layout_loading);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingLayout.setVisibility(View.GONE); // Ẩn layout loading
            }
        }, 2000);
        imgrandom();
    }
}