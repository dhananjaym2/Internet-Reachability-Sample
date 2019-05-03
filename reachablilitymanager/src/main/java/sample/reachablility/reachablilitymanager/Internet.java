package sample.reachablility.reachablilitymanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.webkit.URLUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

class Internet {

  /**
   * Checks if the URL is reachable or not
   *
   * @param url URL as a {@link String}
   * @return true if the url is valid else false
   */
  static boolean isUrlReachable(String url, Context context) {
    if (url != null) {

      if (isValidURL(url)) {

        if (isInternetAvailable(context)) {

          return isConnectivityToURLSuccessful(url);
        }
      }
    }
    return false;
  }

  /**
   * Checks if the connection to the specified url is successful or not
   *
   * @param url URL as a {@link String}
   * @return true if the connection to this url is successful else false
   */
  private static boolean isConnectivityToURLSuccessful(String url) {

    try {
      // create a URL from the parameter url
      URL formattedUrl = new URL(url);

      URLConnection urlConnection = formattedUrl.openConnection();

      // GET call to the formatted URL
      urlConnection.connect();

      // receive response as inputStream
      InputStream inputStream = urlConnection.getInputStream();

      // convert inputstream to string
      if (inputStream != null) {
        //return convertInputStreamToString(inputStream) != null;// TODO
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return false;
  }

  /**
   * Checks if the current device is connected to network for internet or not
   *
   * @return true if the current device is connected to network else false
   */
  private static boolean isInternetAvailable(Context context) {

    // check internet connectivity of our application

    ConnectivityManager connectivityManager =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

    return connectivityManager != null && connectivityManager.getActiveNetworkInfo()
        .isConnected();
  }

  /**
   * Checks if the URL is valid or not
   *
   * @param url URL as a {@link String}
   * @return true if the url is valid else false
   */
  private static boolean isValidURL(String url) {

    return URLUtil.isValidUrl(url);
  }
}
