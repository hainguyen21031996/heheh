package com.example.signingoogle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnGG, btnGH, btnFb;
    private TextView dangkytaikhoan;
    private Button btnLogin;
    EditText edtEmail, edtPass;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        /*Intent intent = new Intent(MainActivity.this, PushNotificationService.class);
        startService(intent);*/
        //FirebaseMessaging.getInstance().subscribeToTopic("Notification");

        Anhxa();

        progressDialog = new ProgressDialog(this);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        btnGG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GoogleSignInActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        btnGH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GithubAuthActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FacebookAuthActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        dangkytaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perforLogin();
            }
        });
    }

    public void Anhxa(){
        //Anh xa
        btnGG = findViewById(R.id.btnGG);
        btnGH = findViewById(R.id.btnghup);
        btnFb = findViewById(R.id.btnFb);
        btnLogin = findViewById(R.id.btnLogin);
        edtPass = findViewById(R.id.edtPassword);
        edtEmail = findViewById(R.id.edtUsername);
        dangkytaikhoan = findViewById(R.id.tvdk);
    }

    private void perforLogin() {
        String email = edtEmail.getText().toString();
        String pass = edtPass.getText().toString();
        if (email.isEmpty()) {
            edtEmail.setError("Email không được để trống");
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString()).matches()){
            //Toast.makeText(RegisterActivity.this, "Vui lòng nhập email hợp lệ", Toast.LENGTH_SHORT).show();
            edtEmail.setError("Email không hợp lệ");
        }
        else if(pass.isEmpty() || pass.length()<6){
            edtPass.setError("Mật khẩu không đúng");
        } else {
            progressDialog.setMessage("Đang đăng nhập....");
            progressDialog.setTitle("Đăng Nhập");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void sendUserToNextActivity() {
        Intent intent= new Intent(MainActivity.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}