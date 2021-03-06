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
import com.tencent.weibo.oauthv2.OAuthV2;

public class SelectPicPopupWindow extends PopupWindow {


	private Button  btn_cancel;
	private Button  btn_mypic;
	private View mMenuView;

	public SelectPicPopupWindow(final Activity context,OnClickListener itemsOnClick) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.bottomdialog, null);
		
		int h = context.getWindowManager().getDefaultDisplay().getHeight();
		int w = context.getWindowManager().getDefaultDisplay().getWidth();
        btn_mypic = (Button) mMenuView.findViewById(R.id.btn_mypic);
        btn_mypic.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(context, "[OnItemClickListener]点击了我的相册", Toast.LENGTH_SHORT).show();
                //生成一个Intent对象
                Intent intent =new Intent();

                //附加数据Extras
                intent.putExtra("textIntent", "123");

                //Intent请求的是OtherActivity.class
                intent.setClass(context, XiangCheActivity.class);
                context.startActivity(intent);
            }
        });
		btn_cancel = (Button) mMenuView.findViewById(R.id.btn_cancel);
		//ȡ ť
		btn_cancel.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// ٵ  �
				SaveDate.saveDate(context, new OAuthV2()); 
				context.finish();
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
				
				int height = mMenuView.findViewById(R.id.pop_layout).getTop();
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
