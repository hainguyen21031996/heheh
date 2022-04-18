package com.example.signingoogle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class RegisterActivity extends AppCompatActivity {

    TextView dacotaikhoan;
    EditText edtEmail, edtPass, edtRePass;
    Button btnDk;
    ProgressDialog progressDialog;

    private FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Anhxa();
        progressDialog = new ProgressDialog(this);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerforAuth();
            }
        });
    }

    public void Anhxa(){
        dacotaikhoan = findViewById(R.id.dacotaikhoan);
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        edtRePass = findViewById(R.id.edtRePass);
        btnDk = findViewById(R.id.btnDK);
    }

    private void PerforAuth() {
        String email = edtEmail.getText().toString();
        String pass = edtPass.getText().toString();
        String repass = edtRePass.getText().toString();

        if (email.isEmpty()) {
            edtEmail.setError("Email không được để trống");
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString()).matches()){
            //Toast.makeText(RegisterActivity.this, "Vui lòng nhập email hợp lệ", Toast.LENGTH_SHORT).show();
            edtEmail.setError("Email không hợp lệ");
        }
        else if(pass.isEmpty() || pass.length()<6){
            edtPass.setError("Mật khẩu phải nhiều hơn 6 kí tự");
        }
        else if(!pass.equals(repass)){
            edtRePass.setError("Mật khẩu nhập lại không khớp");
        }else {
            progressDialog.setMessage("Đang đăng ký....");
            progressDialog.setTitle("Đăng ký");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        Toast.makeText(RegisterActivity.this, "Vui lòng đăng nhập lại để tiếp tục", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(RegisterActivity.this, "Vui lòng kiểm tra lại email và mật khẩu", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent= new Intent(RegisterActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}