package com.example.isweixin;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.R;
import com.example.photo.PhotoActivity;
import com.example.qr_codescan.MaActivity;

public class SelectAddPopupWindow extends PopupWindow {

    private Button  btn_shaomiao;
    private Button  btn_photo;
	private View mMenuView;

	public SelectAddPopupWindow(final Activity context,OnClickListener itemsOnClick) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.addxml, null);
		
		int h = context.getWindowManager().getDefaultDisplay().getHeight();
		int w = context.getWindowManager().getDefaultDisplay().getWidth();

        btn_shaomiao = (Button) mMenuView.findViewById(R.id.btn_shaomiao);
        btn_shaomiao.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(context, "[OnItemClickListener]点击了扫一扫", Toast.LENGTH_SHORT).show();
                //生成一个Intent对象
                Intent intent =new Intent();

                //附加数据Extras
                intent.putExtra("textIntent", "123");

                //Intent请求的是OtherActivity.class
                intent.setClass(context, MaActivity.class);
                context.startActivity(intent);
            }
        });

        btn_photo = (Button) mMenuView.findViewById(R.id.btn_photo);
        btn_photo.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(context, "[OnItemClickListener]点击了照片", Toast.LENGTH_SHORT).show();
                //生成一个Intent对象
                Intent intent =new Intent();

                //附加数据Extras
                intent.putExtra("textIntent", "123");

                //Intent请求的是OtherActivity.class
                intent.setClass(context, PhotoActivity.class);
                context.startActivity(intent);
            }
        });

		// �ð�ť
		//  SelectPicPopupWindow View
		this.setContentView(mMenuView);
		//  SelectPicPopupWindow    Ŀ�
		this.setWidth(w/2+50);
		//  SelectPicPopupWindow    ĸ�
		this.setHeight(LayoutParams.WRAP_CONTENT);
		//  SelectPicPopupWindow    ɵ
		this.setFocusable(true);
		//  SelectPicPopupWindow   �嶯 Ч
		this.setAnimationStyle(R.style.mystyle);
		//ʵ һ ColorDrawable ɫΪ ͸
		ColorDrawable dw = new ColorDrawable(0000000000);
		//  SelectPicPopupWindow    ı �
		this.setBackgroundDrawable(dw);
		//mMenuView �OnTouchListener  �жϻ�ȡ  λ   �ѡ     �ٵ  �
		mMenuView.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				int height = mMenuView.findViewById(R.id.pop_layout2).getTop();
				int y=(int) event.getY();
				if(event.getAction()==MotionEvent.ACTION_UP){
					if(y<height){
						dismiss();
					}
				}				
				return true;
			}
		});

	}

}
