package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_webview.*

class Webview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)


        //Webview Implementation whenever user clicks on Any News article

        val url :String? = intent.getStringExtra("URL")
        if(url!=null){
            webview.settings.userAgentString = "Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3"
            webview.settings.javaScriptEnabled=true
            webview.settings.setRenderPriority(WebSettings.RenderPriority.HIGH)
            webview.webViewClient= object : WebViewClient (){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    progressBar3.visibility=View.GONE
                    webview.visibility= View.VISIBLE
                }
                
            }

            webview.loadUrl(url)



        }
    }
}