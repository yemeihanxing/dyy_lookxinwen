package com.dyy.lookxinwens.utils;



import android.content.Context;
import android.content.SharedPreferences;

/** * 
 @author  作者 :dyy
 @date 创建时间：2016年7月17日 上午7:35:52
 @描述 
  */
public class SpTools{

	public static void setBoolean(Context context,String key,boolean value)
	{
		SharedPreferences sp=context.getSharedPreferences(MyConstants.CONFIGFILE, Context.MODE_PRIVATE);
	   //保存并提交值
		sp.edit().putBoolean(key, value).commit();
	}
	public static boolean getBoolean(Context context,String key,boolean devalue){
		SharedPreferences sp=context.getSharedPreferences(MyConstants.CONFIGFILE, Context.MODE_PRIVATE);;
		//返回存储的值，没有则返回devalue
		return sp.getBoolean(key, devalue);
		
	}
	
}
