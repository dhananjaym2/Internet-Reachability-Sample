package sample.reachablility.reachablilitymanager;

import android.content.Context;
import sample.reachablility.reachablilitymanager.constants.AppConstants;

public class ReachabilityManagerAPI {

  /**
   * Checks if the Internet network URL is reachable or not
   *
   * @param url URL as a {@link String}
   * @return true if the url is reachable else false
   */
  public String isInternetUrlReachable(String url, Context context) {
    if (!url.isEmpty()) {
      if (Internet.isUrlReachable(url, context)) {
        return AppConstants.REACHABLE;
      }
    } else {
      return AppConstants.UNREACHABLE;
    }
    return AppConstants.UNREACHABLE;
  }
}
