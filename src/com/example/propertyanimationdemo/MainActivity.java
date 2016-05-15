package com.example.propertyanimationdemo;



import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	Button btn5;
	Button btn6;
	Button btn7;
	ImageView iv;
	ImageView iv2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}
	
	private void initView(){

		btn1=(Button)findViewById(R.id.button1);
		btn2=(Button)findViewById(R.id.button2);
		btn3=(Button)findViewById(R.id.button3);
		btn4=(Button)findViewById(R.id.button4);
		btn5=(Button)findViewById(R.id.button5);
		btn6=(Button)findViewById(R.id.button6);
		btn7=(Button)findViewById(R.id.button7);
		iv=(ImageView)findViewById(R.id.imageView1);
		iv2=(ImageView)findViewById(R.id.imageView2);
		iv2.setVisibility(View.GONE);
		
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ObjectAnimator.ofFloat(iv, "alpha", 0f, 1f)
				.setDuration(5000)
				.start();
			}
		});
		

		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ObjectAnimator.ofFloat(iv, "scaleX", 1f, 3f)
				.setDuration(5000)
				.start();
			}
		});
		
        btn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ObjectAnimator.ofFloat(iv, "translationX", 500)
				.setDuration(5000)
				.start();
			}
		});
 
        btn4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ObjectAnimator.ofFloat(iv, "rotationX", 0f, 360f)
				.setDuration(5000)
				.start();
			}
		});
        

        btn5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});

        btn5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PropertyValuesHolder  pv1=PropertyValuesHolder.ofFloat("alpha", 0f, 1f);
				PropertyValuesHolder  pv2=PropertyValuesHolder.ofFloat("scaleX", 0f, 1f);
				PropertyValuesHolder  pv3=PropertyValuesHolder.ofFloat("scaleY", 0f, 1f);
				ObjectAnimator.ofPropertyValuesHolder(iv, pv1,pv2,pv3)
				.setDuration(5000)
				.start();
			
			}
		});

        btn6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(iv, "translationX", 500);
				ObjectAnimator objectAnimator2=ObjectAnimator.ofFloat(iv, "rotationX", 0f, 360f);
				AnimatorSet set=new AnimatorSet();
				set.playTogether(objectAnimator1,objectAnimator2);
				set.setDuration(5000);
				set.start();
				
			}
		});
        
        btn7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*WrapperView view=new WrapperView(iv);
				ObjectAnimator.ofInt(view, "width",0, 600)
				.setDuration(5000)
				.start();*/
				if(iv2.getVisibility()==View.GONE){
					open(iv2);
				}
				else{
					close(iv2);
				}
				
			}
		});
		
	}
	
	
	private ValueAnimator createAnimator(final View view, int start, int end){
		ValueAnimator animator=ValueAnimator.ofInt(start, end);
		animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				// TODO Auto-generated method stub
				int value=(Integer)animation.getAnimatedValue();
				ViewGroup.LayoutParams  params=view.getLayoutParams();
				params.height=value;
				view.setLayoutParams(params);
			}
		});
		return animator;
	}
	
	private void open(View view){
		int height=(int)(getResources().getDisplayMetrics().density*60+0.5);
		view.setVisibility(View.VISIBLE);
		ValueAnimator animator=createAnimator(view, 0, height);
		animator.setDuration(5000);
		animator.start();
	}
	
	private void close(final View view){
		int height=view.getHeight();
		ValueAnimator animator=createAnimator(view, height, 0);
		animator.addListener(new AnimatorListenerAdapter() {
			
			public void onAnimationEnd(Animation animation){
				view.setVisibility(View.GONE);
			}
		});
		animator.setDuration(5000);
		animator.start();
	}
}
