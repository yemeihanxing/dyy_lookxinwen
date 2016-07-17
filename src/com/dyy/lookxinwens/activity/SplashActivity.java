package com.dyy.lookxinwens.activity;



import com.dyy.lookxinwens.R;
import com.dyy.lookxinwens.utils.MyConstants;
import com.dyy.lookxinwens.utils.SpTools;

import android.R.menu;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

/** * 
 @author  作者 :dyy
 @date 创建时间：2016年7月17日 上午7:06:42
 @描述 主要实现了功画的效果
 */
public class SplashActivity extends Activity {

	private ImageView iv_mainview;
	private AnimationSet as;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_xml);

		initView();

		startAnimation();
		
		initEvent();
	}

	private void initEvent() {
	//1.监听动画播完的事件，只是一处用的事件，匿名类对像，多处再声明成员变量	
	as.setAnimationListener(new AnimationListener() {
		
		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
		//监听动画播完的事件执行
		@Override
		public void onAnimationEnd(Animation animation) {
		//判断进入向导界面还是主界面
			if (SpTools.getBoolean(getApplicationContext(), MyConstants.ISSETUP, false)) {
			//true则是设置过了，直接进入主界面
				System.out.println("true");
				Intent intent=new Intent(SplashActivity.this,MainActivity.class);
				startActivity(intent);
			}else {
				//flase则是没有设置过了，直接进入向导界面
				System.out.println("flase");
				
				Intent intent=new Intent(SplashActivity.this,GuideActivity.class);
				startActivity(intent);
				
			}
			finish();
		}
	});	
		
	}

	//开始播放动画，旋转，缩放，渐变
	private void startAnimation() {
		as = new AnimationSet(false);

		//旋转动画，锚点
		RotateAnimation ra=new RotateAnimation(
				0, 360, 
				Animation.RELATIVE_TO_SELF, 0.5f, 
				Animation.RELATIVE_TO_SELF, 0.5f);
		//投置动画的播放时间
		ra.setDuration(2000);	
		ra.setFillAfter(true);//设置播放完之后停留在当前状态
		//添加到动画集
		as.addAnimation(ra);

		//缩放动画
		ScaleAnimation sa=new ScaleAnimation(
				0, 1, 
				0, 1, 
				Animation.RELATIVE_TO_SELF, 0.5f, 
				Animation.RELATIVE_TO_SELF, 0.5f);


		//投置动画的播放时间
		sa.setDuration(2000);	
		sa.setFillAfter(true);//设置播放完之后停留在当前状态
		//添加到动画集
		as.addAnimation(sa);

		//渐变动画
		AlphaAnimation aa=new AlphaAnimation(0, 1);
		//设置动画播放时间
		aa.setDuration(2000);
		aa.setFillAfter(true);

		as.addAnimation(aa);

		iv_mainview.startAnimation(as);
		
		//动画播放完成后判断是进入哪个界面
		
		//1.监听动画播放完的事件
		
		//2.判断进入向导界面还是主界面
	}

	private void initView() {
		//设置背景图片	
		iv_mainview=(ImageView) findViewById(R.id.iv_splash_mainview);	
	}

}
