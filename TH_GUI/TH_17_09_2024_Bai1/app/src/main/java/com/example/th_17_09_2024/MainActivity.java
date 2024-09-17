package com.example.th_17_09_2024;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText eA,eB;
    TextView result;
    Button plus,minus, multi, divi, Uc, Exit;
    private int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
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
        eA = findViewById(R.id.edtA);
        eB = findViewById(R.id.edtB);
        result = findViewById(R.id.result);
        plus = findViewById(R.id.btnPlus);
        minus = findViewById(R.id.btnMinus);
        multi = findViewById(R.id.btnMulti);
        divi = findViewById(R.id.btnDivision);
        Uc = findViewById(R.id.btnUCLN);
        Exit = findViewById(R.id.btnExit);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eA.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn cần nhập dữ liệu cho số A", Toast.LENGTH_SHORT).show();
                } else if (eB.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn cần nhập dữ liệu cho số B", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int a = Integer.parseInt(eA.getText().toString());
                        int b = Integer.parseInt(eB.getText().toString());
                        double kq = (double) a + b;
                        result.setText(String.valueOf(kq));
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eA.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn cần nhập dữ liệu cho số A", Toast.LENGTH_SHORT).show();
                } else if (eB.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn cần nhập dữ liệu cho số B", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int a = Integer.parseInt(eA.getText().toString());
                        int b = Integer.parseInt(eB.getText().toString());
                        double kq = (double) a - b;
                        result.setText(String.valueOf(kq));
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eA.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn cần nhập dữ liệu cho số A", Toast.LENGTH_SHORT).show();
                } else if (eB.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn cần nhập dữ liệu cho số B", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int a = Integer.parseInt(eA.getText().toString());
                        int b = Integer.parseInt(eB.getText().toString());
                        double kq = (double) a * b;
                        result.setText(String.valueOf(kq));
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eA.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn cần nhập dữ liệu cho số A", Toast.LENGTH_SHORT).show();
                } else if (eB.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn cần nhập dữ liệu cho số B", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int a = Integer.parseInt(eA.getText().toString());
                        int b = Integer.parseInt(eB.getText().toString());
                        if (b == 0) {
                            Toast.makeText(MainActivity.this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show();
                        } else {
                            double kq = (double) a / b;
                            result.setText(String.valueOf(kq));
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Uc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eA.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn cần nhập dữ liệu cho số A", Toast.LENGTH_SHORT).show();
                } else if (eB.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn cần nhập dữ liệu cho số B", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int a = Integer.parseInt(eA.getText().toString());
                        int b = Integer.parseInt(eB.getText().toString());
                        int ucln = findGCD(a, b);
                        result.setText(String.valueOf(ucln));
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}