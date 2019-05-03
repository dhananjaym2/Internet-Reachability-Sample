package sample.reachablility.reachablilitymanager;

import android.content.Context;
import sample.reachablility.reachablilitymanager.constants.AppConstants;

public class ReachabilityManagerAPI {
  public static String isInternetUrlReachable(String url, Context context) {
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
