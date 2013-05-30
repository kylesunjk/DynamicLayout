package com.example.testfordemibtn;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.testfordemibtn.R.color;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	ArrayList<HashMap<String, String>> mainlist1;
	HashMap<String,String> item1;
	ArrayList<HashMap<String, String>> mainlist2 = new ArrayList<HashMap<String, String>>();
	HashMap<String,String> item2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ArrayList<HashMap<String, String>> mainlist1 = new ArrayList<HashMap<String, String>>();
		final ArrayList<HashMap<String, String>> mainlist2 = new ArrayList<HashMap<String, String>>();
		for (int i=0 ; i<=7 ; i++){
			HashMap<String,String> item1 = new HashMap<String,String>();
			item1.put("id", "1");
			item1.put("color", "prp");
			item1.put("num", String.valueOf(i));
			mainlist1.add(item1);
		}
		for (int j=0 ; j<=10 ; j++){
			HashMap<String,String> item2 = new HashMap<String,String>();
			item2.put("id", "2");
			item2.put("color", "gre");
			item2.put("num", String.valueOf(j));
			mainlist2.add(item2);
		}
		final RelativeLayout re = (RelativeLayout) findViewById(R.id.re1);
		Button gre = (Button) findViewById(R.id.button1);
		Button pur = (Button) findViewById(R.id.button2);
		re.addView(createlayout(getApplicationContext(),mainlist1,mainlist2));
		pur.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				re.removeAllViews();
				re.addView(createlayout(getApplicationContext(),mainlist1,new ArrayList<HashMap<String, String>>()));	
			}
			
		});
		gre.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				re.removeAllViews();
				re.addView(createlayout(getApplicationContext(),new ArrayList<HashMap<String, String>>(),mainlist2));	
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public LinearLayout createlayout (Context act,ArrayList<HashMap<String, String>> mainlist1,ArrayList<HashMap<String, String>> mainlist2){
//		int m = 0;
//		int j = 0 ;
//		int index = 0;
		int biaoji = 0;
		LinearLayout re =  new LinearLayout(act);
		LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		re.setOrientation(LinearLayout.VERTICAL);
		ArrayList<HashMap<String, String>> all = new ArrayList<HashMap<String, String>>();
		for (int i =0; i<=mainlist1.size()-1;i++){
			all.add(mainlist1.get(i));
		}
		for (int j =0 ;j<=mainlist2.size()-1;j++){
			all.add(mainlist2.get(j));
		}
		int c = (mainlist1.size()+mainlist2.size())/3;
		
		
		for(int index = 0 ; index<=c+2.9 ;index++){
			LinearLayout ll = new LinearLayout(act);
			ll.setOrientation(LinearLayout.HORIZONTAL);
			
			for(int i =0 ; i<=2 ;i++){
				HashMap<String,String> d1 = new HashMap<String,String>();
				biaoji ++;
				d1 = all.get(biaoji-1);
				Button b = new Button (act);
				b.setText("id:"+d1.get("id").toString()+"num:"+d1.get("num").toString());
				if(d1.get("id").equalsIgnoreCase("1")){
					b.setBackgroundColor(color.pur);	
				}
				else if (d1.get("id").equalsIgnoreCase("1")){
					b.setBackgroundColor(color.grn);
				}
				
				ll.addView(b);
				if(biaoji == all.size()){
					break;
				}
			}
				
				
				
//			if(mainlist1.size()!=0){
//				for(int i =0 ; i<=2 ;i++){
//					if(j==mainlist1.size()){
//						break;
//					}
//					HashMap<String,String> d1 = new HashMap<String,String>();
//					d1 = mainlist1.get(j);
//					Button b = new Button (act);
//					b.setText("id:"+d1.get("id").toString()+"num:"+d1.get("num").toString());
//					b.setBackgroundColor(color.pur);
//					ll.addView(b);
//					j++;
//				}
//			}

							
							


//			else if(mainlist2.size()!=0&&j==mainlist1.size()){
//					for(int i =0 ; i<=2 ;i++){
//						if(m==mainlist2.size()){
//							break;
//						}
//						HashMap<String,String> d2 = new HashMap<String,String>();
//						d2 = mainlist2.get(m);
//						Button b = new Button (act);
//						b.setText("id:"+d2.get("id").toString()+"num:"+d2.get("num").toString());
//						b.setBackgroundColor(color.grn);
//						ll.addView(b);
//						m++;
//					
//			        }
//				}

				re.addView(ll);
			 if(biaoji == mainlist1.size()+mainlist2.size()){
					break;
				}
			
	}
//        re.setLayoutParams(lp2);
		return re;
	}

}
