
package com.shaheer.xpeldude;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.webkit.*;
import android.widget.*;
import android.content.*;
public class HomeActivity extends Activity
{
	WebView web;
	ProgressBar prog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
		prog = findViewById(R.id.prog);
	     web = findViewById(R.id.web); 



        // loadng http://www.google.com url in the the WebView. 

        



        // this will enable the javascipt. 
		
        web.getSettings().setJavaScriptEnabled(true); 
		web.loadUrl("https://mshaheerz.github.io/webpage/"); 
		web.setWebChromeClient(new WebChromeClient(){
			@Override
		public void onReceivedTitle(WebView View , String title){
			super.onReceivedTitle(View, title);
			setTitle(title);
		}
		
			
				@Override
				public void onProgressChanged(WebView view,int newprogress)
				{
					prog.setProgress(newprogress);
					super.onProgressChanged(view,newprogress);
				}
			});
		web.getSettings().setBuiltInZoomControls(true);
		web.getSettings().setSupportZoom(true);
		web.setWebViewClient(new WebViewClient(){


				@Override
				public void onPageStarted(WebView view,String url,Bitmap favicon)
				{
					prog.setVisibility(view.VISIBLE);
					super.onPageStarted(view,url,favicon);
				}

				@Override
				public void onPageFinished(WebView view,String url)
				{
					prog.setVisibility(view.GONE);
					super.onPageFinished(view,url);

					// WebViewClient allows you to handle  

					// onPageFinished and override Url loading. 





				}});
				
			
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		
		getMenuInflater().inflate(R.menu.homemenu, menu);
		// TODO: Implement this method
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if(item.getItemId() == R.id.backmenu){
			
			if (web.canGoBack()){
				web.goBack();
				// TODO: Implement this method

			} else {
				AlertDialog.Builder myexitdialog= new AlertDialog.Builder(HomeActivity.this);
				myexitdialog.setTitle("exit app");
				myexitdialog.setMessage("do you want exit this app?");
				myexitdialog.setPositiveButton("exit app",new DialogInterface.OnClickListener()
					{

						@Override
						public void onClick(DialogInterface Dialog, int which)
						{
							// TODO: Implement this method
							finish();
							
						}

				
			
			});
			
			myexitdialog.setNegativeButton("stay in app" ,new DialogInterface.OnClickListener()
					{

						@Override
						public void onClick(DialogInterface Dialog, int which)
						{
							Dialog.dismiss();
							
							// TODO: Implement this method
						}

			
			
			});
			myexitdialog.create();
			myexitdialog.show();
			
			
			}
			
		}else if(item.getItemId() == R.id.homemenu){
			
			web.loadUrl("https://google.com"); 
				// TODO: Implement this method

			}
		
		else if(item.getItemId() == R.id.forwardmenu){
			if (web.canGoForward()){
				web.goForward();
				// TODO: Implement this method

			} else {
				Toast.makeText(this,"cant go further", Toast.LENGTH_LONG).show();
			}
			
		}
		
		
		// TODO: Implement this method
		return super.onOptionsItemSelected(item);
	}
	
	
	

	@Override
	public void onBackPressed()
	{
		if (web.canGoBack()){
	       web.goBack();
		// TODO: Implement this method
		
	} else {
		showexitdialog();
	}
	}
	// call shaheerezzzz method
	
	
	public Void showexitdialog(){
		AlertDialog.Builder myexitdialog= new AlertDialog.Builder(HomeActivity.this);
		myexitdialog.setTitle("exit app");
		myexitdialog.setMessage("do you want exit this app?");
		myexitdialog.setPositiveButton("exit app",new DialogInterface.OnClickListener()
			{

				@Override
				public void onClick(DialogInterface Dialog, int which)
				{
					// TODO: Implement this method
					finish();

				}



			});

		myexitdialog.setNegativeButton("stay in app" ,new DialogInterface.OnClickListener()
			{

				@Override
				public void onClick(DialogInterface Dialog, int which)
				{
					Dialog.dismiss();

					// TODO: Implement this method
				}



			});
		myexitdialog.create();
		myexitdialog.show();
		
		
		return null;
	}
	
	}
	

