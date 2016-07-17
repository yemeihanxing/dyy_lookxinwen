package com.dyy.lookxinwens.activity;
import java.util.ArrayList;
import java.util.List;

import com.dyy.lookxinwens.R;
import com.dyy.lookxinwens.utils.MyConstants;
import com.dyy.lookxinwens.utils.SpTools;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/** * 
 @author  作者 :dyy
 @date 创建时间：2016年7月17日 上午8:06:02
 @描述 设置向导界面,采用ViewPager界面的切换
  */
public class GuideActivity extends Activity {

	private List<ImageView> guids;
	private ViewPager vp_guids;
	private LinearLayout ll_points;
	private View v_redpoint;
	private int[] pics;
	private Button bt_startExp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guide_xml);
		
		initView();
		
		initData();
		
		initEvent();
	}

	@SuppressWarnings("deprecation")
	private void initEvent() {
		
		
		bt_startExp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//保存设置的状态
				SpTools.setBoolean(getApplicationContext(), MyConstants.ISSETUP, true);
				//进入主界面
				Intent main=new Intent(GuideActivity.this,MainActivity.class);
				startActivity(main);
				//关闭自已
				finish();
			}
		});
		
		vp_guids.setOnPageChangeListener(new OnPageChangeListener() {
			
			
			@Override
			public void onPageSelected(int position) {
				//当前ViewPager显示的页码
				//当前ViewPager滑动到最后一个的时候
				if (position == guids.size()-1) {
					
					bt_startExp.setVisibility(View.VISIBLE);
				}else {
					//当前ViewPager不是最后一个的时候
					bt_startExp.setVisibility(View.GONE);
				}
				
			}
			
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub
				
			}
		});	
	}

	private void initData() {
		
    pics = new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};	
		
	guids = new ArrayList<ImageView>();
	
	for (int i = 0; i < pics.length; i++) {
		
		ImageView view=new ImageView(this);
		view.setBackgroundResource(pics[i]);
		//添加界面的数据
		guids.add(view);
	}
	MyAdapter adapter=new MyAdapter();
	vp_guids.setAdapter(adapter);
	}
	
	private class MyAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return guids.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			
			return arg0==arg1;
		}

	

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {

           container.removeView((View) object);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			
			View child=guids.get(position);
			
			container.addView(child);
			
			return child;
		}
		
	}

	private void initView() {
	vp_guids = (ViewPager) findViewById(R.id.vp_guide_pages);	
	
	ll_points = (LinearLayout) findViewById(R.id.ll_guide_point);
	
	v_redpoint = findViewById(R.id.iv_splash_mainview);	
	
	bt_startExp = (Button) findViewById(R.id.bt_guide_startexp);
	}
	
}
