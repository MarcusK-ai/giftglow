package com.focusedapps.gifts;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.net.Uri;
import java.io.InputStream;
import java.io.IOException;

public class MainActivity extends Activity {
 private WebView web;
 @Override public void onCreate(Bundle state){super.onCreate(state);web=new WebView(this);setContentView(web);WebSettings s=web.getSettings();s.setJavaScriptEnabled(true);s.setDomStorageEnabled(true);s.setAllowFileAccess(false);s.setAllowContentAccess(false);s.setMixedContentMode(WebSettings.MIXED_CONTENT_NEVER_ALLOW);web.setWebChromeClient(new WebChromeClient());web.setWebViewClient(new WebViewClient(){@Override public WebResourceResponse shouldInterceptRequest(WebView view,WebResourceRequest req){Uri uri=req.getUrl();if(!"appassets.androidplatform.net".equals(uri.getHost()))return null;String file=uri.getPath().replaceFirst("^/","");if(file.isEmpty())file="index.html";if(file.contains(".."))return null;try{InputStream in=getAssets().open("www/"+file);String mime=file.endsWith(".js")?"text/javascript":file.endsWith(".css")?"text/css":file.endsWith(".svg")?"image/svg+xml":file.endsWith(".png")?"image/png":file.endsWith(".json")||file.endsWith(".webmanifest")?"application/json":"text/html";return new WebResourceResponse(mime,"UTF-8",in);}catch(IOException e){return null;}}});web.loadUrl("https://appassets.androidplatform.net/index.html");}
 @Override public void onBackPressed(){if(web.canGoBack())web.goBack();else super.onBackPressed();}
 @Override protected void onDestroy(){web.destroy();super.onDestroy();}
}
