package com.example.signingoogle.HelperClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.signingoogle.R;

public class HuongDanApdater extends BaseAdapter {
    int[] img;
    String[] stt;
    int[] tieude;
    Context context;

    public HuongDanApdater(Context context, String[] stt, int[] tieude, int[] img ) {
        this.img = img;
        this.stt = stt;
        this.tieude = tieude;
        this.context = context;
    }

    @Override
    public int getCount() {
        return tieude.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.huongdan_card_design, parent, false);
        TextView stt1 = (TextView)rowView.findViewById(R.id.stt_hd);
        TextView tieude1 = (TextView) rowView.findViewById(R.id.tieude_hd);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img_hd);



        //lấy Nội dung của Item ra để thiết lập nội dung item cho đúng
        stt1.setText(stt[position]);
        //lấy ImageView ra để thiết lập hình ảnh cho đúng
        tieude1.setText(tieude[position]);

        imageView.setImageResource(img[position]);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked " + stt[position], Toast.LENGTH_LONG).show();
            }
        });
        //trả về View này, tức là trả luôn về các thông số mới mà ta vừa thay đổi
        return rowView;
    }
}
