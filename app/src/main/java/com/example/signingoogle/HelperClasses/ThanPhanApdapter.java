package com.example.signingoogle.HelperClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.signingoogle.R;

public class ThanPhanApdapter extends BaseAdapter {
    String[] thanhphan;
    String[] soluong;
    Context context;

    public ThanPhanApdapter(Context context, String[] thanhphan, String[] soluong) {
        this.thanhphan = thanhphan;
        this.soluong = soluong;
        this.context = context;
    }

    @Override
    public int getCount() {
        return thanhphan.length;
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
        View rowView = inflater.inflate(R.layout.rowview_thanhphan, parent, false);

        TextView tvThanhPhan = (TextView)rowView.findViewById(R.id.tv1_rvthanhphan);
        TextView tvSoluong= (TextView) rowView.findViewById(R.id.tvsoluong);


        //lấy Nội dung của Item ra để thiết lập nội dung item cho đúng
        tvThanhPhan.setText(thanhphan[position]);
        //lấy ImageView ra để thiết lập hình ảnh cho đúng
        tvSoluong.setText(soluong[position]);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked " + soluong[position], Toast.LENGTH_LONG).show();
            }
        });
        //trả về View này, tức là trả luôn về các thông số mới mà ta vừa thay đổi
        return rowView;
    }
}
