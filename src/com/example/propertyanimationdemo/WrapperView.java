package com.example.propertyanimationdemo;

import android.view.View;

public class WrapperView {

	private View target;
	
	public WrapperView(View target){
		this.target=target;
	}
	
	public int getWidth(){
		return target.getLayoutParams().width;
	}
	
	public void setWidth(int width){
		target.getLayoutParams().width=width;
		target.requestLayout();
	}
}
