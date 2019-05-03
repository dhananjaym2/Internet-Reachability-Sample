package sample.reachablility.reachablilitymanager;

import sample.reachablility.reachablilitymanager.constants.AppConstants;

public class ReachabilityManagerAPI {
  public static String isInternetUrlReachable(String url) {
    if (!url.isEmpty()) {
      if (Internet.isUrlReachable(url)) {
        return AppConstants.REACHABLE;
      }
    } else {
      return AppConstants.UNREACHABLE;
    }
    return AppConstants.UNREACHABLE;
  }
}
