package sample.reachablility.reachablilitymanager;

import android.Manifest;
import android.content.Context;

import static sample.reachablility.reachablilitymanager.ReachabilityManagerAPIConnectivityResultNotifier.REACHABLE;
import static sample.reachablility.reachablilitymanager.ReachabilityManagerAPIConnectivityResultNotifier.UNREACHABLE;

/**
 * Used to check the reachability of defined network interfaces, which can be extended to support
 * more. Currently Internet reachability support is available.
 */
public class ReachabilityManagerAPI implements ConnectivityResultNotifier {

  private ReachabilityManagerAPIConnectivityResultNotifier
      reachabilityManagerAPIConnectivityResultNotifier;

  /**
   * Checks if the network URL is reachable or not. Requires {@link
   * Manifest.permission#INTERNET} and {@link Manifest.permission#ACCESS_NETWORK_STATE} permission
   * to work. Notifies the result via {@link ConnectivityResultNotifier#onResultPublished(Boolean)}
   *
   * @param url URL as a {@link String}
   */
  public void isInternetUrlReachable(String url, Context context,
      ReachabilityManagerAPIConnectivityResultNotifier reachabilityManagerAPIConnectivityResultNotifier) {
    this.reachabilityManagerAPIConnectivityResultNotifier =
        reachabilityManagerAPIConnectivityResultNotifier;
    if (!url.isEmpty()) {
      InternetReachability internetReachability = new InternetReachability();
      internetReachability.isUrlReachable(url, context, this);
      return;
    } else {
      onResultPublished(false);
    }
    onResultPublished(false);
  }

  /**
   * Publishes the result of connection status.
   *
   * @param result true if the connection is successful
   */
  @Override public void onResultPublished(Boolean result) {
    if (result) {
      reachabilityManagerAPIConnectivityResultNotifier.onConnectivityResultAvailable(
          REACHABLE);
    } else {
      reachabilityManagerAPIConnectivityResultNotifier.onConnectivityResultAvailable(
          UNREACHABLE);
    }
  }
}
