package sample.reachablility.reachablilitymanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.webkit.URLUtil;

/**
 * Contains methods related to the internet network reachability
 */
class InternetReachability implements ConnectivityResultNotifier {

  private ConnectivityResultNotifier connectivityResultNotifier;

  /**
   * Checks if the network URL is reachable or not. Notifies the result via
   * {@link ConnectivityResultNotifier#onResultPublished(Boolean)}
   *
   * @param url URL as a {@link String}
   * @param context {@link Context} reference
   * @param connectivityResultNotifier {@link ConnectivityResultNotifier) reference
   */
  void isUrlReachable(String url, Context context,
      ConnectivityResultNotifier connectivityResultNotifier) {
    this.connectivityResultNotifier = connectivityResultNotifier;
    if (url != null) {

      if (isValidURL(url)) {

        if (isInternetAvailable(context)) {

          ConnectToURLAsync connectToURLAsync = new ConnectToURLAsync(this);
          connectToURLAsync.execute(url);
          return;
        }
      }
    }
    connectivityResultNotifier.onResultPublished(false);
  }

  /**
   * Checks if the current device is connected to network for internet or not
   *
   * @return true if the current device is connected to network else false
   */
  private boolean isInternetAvailable(Context context) {

    // check internet connectivity of our application

    ConnectivityManager connectivityManager =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

    return connectivityManager != null
        && connectivityManager.getActiveNetworkInfo() != null
        && connectivityManager.getActiveNetworkInfo().isConnected();
  }

  /**
   * Checks if the URL is valid or not
   *
   * @param url URL as a {@link String}
   * @return true if the url is valid else false
   */
  private boolean isValidURL(String url) {

    return URLUtil.isValidUrl(url);
  }

  /**
   * Publishes the result of connection status.
   *
   * @param result true if the connection is successful
   */
  @Override public void onResultPublished(Boolean result) {
    connectivityResultNotifier.onResultPublished(result);
  }
}
