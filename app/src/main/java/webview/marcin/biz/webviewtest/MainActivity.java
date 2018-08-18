package webview.marcin.biz.webviewtest;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    WebView web = (WebView)findViewById(R.id.web);

    web.setBackgroundColor(Color.TRANSPARENT);
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        web.setWebContentsDebuggingEnabled(true);
      }

    web.addJavascriptInterface(new WebAppInterface(this), "Android");

    web.getSettings().setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
      web.getSettings().setAllowUniversalAccessFromFileURLs(true);


    web.getSettings().setDomStorageEnabled(true);

    //web.getSettings().setAppCacheMaxSize(1024*1024*8);
    //web.getSettings().setAppCachePath(getCacheDir().getAbsolutePath());
    //web.getSettings().setAppCacheEnabled(true);
    web.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

    if (savedInstanceState == null) {
      /*

      JSONObject obj = new JSONObject();
      try {
      } catch (JSONException e) {
        if (Logger.enabled) {
          Logger.d(LOG_TAG, e.getMessage());
        }
      }
      LicenseManager lm = LicenseManager.getLicenseManager(AppBase.getAppCtx());

      Map<String, String> mapParams = new HashMap<String, String>();

      mapParams.put("coords_center", obj.toString());
      mapParams.put("email", lm.getLicenseEmail());
      mapParams.put("amlic", lm.getLicenseInfo().getNumber());
      mapParams.put("source", "AM");

      Collection<Map.Entry<String, String>> postData = mapParams.entrySet();
      //webview_ClientPost(web, getBaseUri(), postData);

      StringBuffer sb = new StringBuffer();
      for(Map.Entry<String, String> entry : mapParams.entrySet()) {
        String key = entry.getKey();
        String value = entry.getValue();
        sb.append(key);
        sb.append("=");
        sb.append(value);
        sb.append("&");
      }
      */

      /*
      String url = getBaseUri();
      if (!TextUtils.isEmpty(segmentInfo.getLongtitude()) && !TextUtils.isEmpty(segmentInfo.getLatitude()) && segmentInfo.getCountry() != 0) {
        url = url + "?c="+segmentInfo.getLongtitudeDec()+","+segmentInfo.getLatitudeDec();
      }
      if (Logger.enabled) {
        Logger.d(LOG_TAG, "Voice url is: "+url);
      }
      */

      web.loadUrl("https://am.targeo.pl/index.php");

      // For testing
      //web.loadData("", "text/html", null);
      //web.loadUrl("javascript:alert(android.onError('Test123'))");

      //Utility.setProxy(web, "192.168.1.169", 8887);
    }

  }

  private class WebAppInterface {
    public WebAppInterface(MainActivity mainActivity) {
    }
  }
}
