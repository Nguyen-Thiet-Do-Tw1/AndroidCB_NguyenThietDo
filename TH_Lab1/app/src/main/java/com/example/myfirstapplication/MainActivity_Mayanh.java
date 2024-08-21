    package com.example.myfirstapplication;

    import android.content.Intent;
    import android.content.pm.PackageManager;
    import android.graphics.Bitmap;
    import android.os.Bundle;
    import android.provider.MediaStore;
    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.Manifest;

    import androidx.activity.EdgeToEdge;
    import androidx.annotation.Nullable;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.app.ActivityCompat;
    import androidx.core.content.ContextCompat;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    public class MainActivity_Mayanh extends AppCompatActivity {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

        Button btnCamera;
        ImageView imgPhoto;
        private void initControl(){
            imgPhoto = findViewById(R.id.imageView2);
            btnCamera = findViewById(R.id.button2);
            btnCamera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ContextCompat.checkSelfPermission(MainActivity_Mayanh.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(MainActivity_Mayanh.this, new String[]{Manifest.permission.CAMERA}, 101);
                    } else {
                        openCamera();
                    }
                }
            });
        }

        private void openCamera() {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 100);
        }

        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
            if(requestCode==100 && resultCode==RESULT_OK && data!= null){
                Bitmap bitmap = (Bitmap)data.getExtras().get("data");
                imgPhoto.setImageBitmap(bitmap);
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main_mayanh);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
            initControl();
        }
    }