package com.example.appgreenflowgroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail, edtPassword;
    private Button btnLogin;

    private final String VALID_EMAIL = "nguyenvana@gmail.com";
    private final String VALID_PASSWORD = "12345";

    @Override
    protected void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.login_main);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if(email.equals(VALID_EMAIL) && password.equals(VALID_PASSWORD)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                    //gữi dữ liệu của nhân viên qua MainActivity
                    intent.putExtra("USER_NAME", getPackageName());
                    intent.putExtra("USER_EMAIL", email);

                    startActivity(intent);
                    finish();
                } else{
                    Toast.makeText(LoginActivity.this, "Email hoặc mật khẩu của bạn không đúng! VUI LÒNG NHẬP LẠI !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
