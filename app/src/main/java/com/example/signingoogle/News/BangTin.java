package com.example.signingoogle.News;

import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.signingoogle.HelperClasses.HuongDanApdater;
import com.example.signingoogle.HelperClasses.ThanPhanApdapter;
import com.example.signingoogle.R;

public class BangTin extends AppCompatActivity {
    public static String[] tvthanhphan= {" ", "Xương bò", "Thịt bò","Lá sách bò","Thịt bò","Gừng", "Hành tây", "Hoa hồi", "Thanh quế",
            "Đinh hương", "Hạt thì là", "Ngò gai", "Ngò rí", "Hành lá", "Xà lách", "Húng quế", "Tương ớt" };
    public static String[] tvsoluong = {"Khẩu phần 4 người","300 Gr", "200 Gr", "200 Gr", "2 Gr", "1 Củ", "1.5 củ", "5 Cái", "10 Gr", "1/3 Muõng cà phê",
            "1 Muỗng cà phê", "10 Cây", "5 Muỗng canh", "10 Nhánh", "4 Cây", "10 Cây", "4 Chén"};
    ListView lv_pho, lv_hd;

    public static String[] tvstt ={"Bước 1","Bước 2","Bước 3","Bước 4","Bước 5","Bước 6","Bước 7","Bước 8"};
    //public static String[] tvtieude ={"1","2","3","4","5","6","7","8"};
    public static int[] tvtieude = {R.string.hd1, R.string.hd2,R.string.h3,R.string.h4,R.string.h5,R.string.h6,R.string.h7, R.string.h8};
    public static int[] imgAvatar = {R.drawable.hd1, R.drawable.hd3, R.drawable.hd4, R.drawable.hd5, R.drawable.hd5, R.drawable.hd7,
            R.drawable.hd8, R.drawable.hd1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_tin);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setTitle("Activity 2");

        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);

        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        lv_pho = (ListView) findViewById(R.id.lv_pho);
        lv_hd = (ListView) findViewById(R.id.lv_hd);

        lv_pho.setAdapter(new ThanPhanApdapter(BangTin.this, tvthanhphan, tvsoluong));
        lv_hd.setAdapter(new HuongDanApdater(BangTin.this, tvstt, tvtieude, imgAvatar));
    }
}