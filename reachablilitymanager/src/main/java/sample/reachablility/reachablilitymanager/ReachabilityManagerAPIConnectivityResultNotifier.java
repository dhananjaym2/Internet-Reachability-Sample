package sample.reachablility.reachablilitymanager;

/**
 * Caller should implement this interface to obtain the result for the requests to {@link
 * ReachabilityManagerAPI}.
 */
public interface ReachabilityManagerAPIConnectivityResultNotifier {

  /**
   * status values
   */
  String UNREACHABLE = "UNREACHABLE";
  String REACHABLE = "REACHABLE";

  /**
   * Called when the reachability status of the request is available.
   *
   * @param reachabilityStatus {@link ReachabilityManagerAPIConnectivityResultNotifier#REACHABLE} or
   * {@link ReachabilityManagerAPIConnectivityResultNotifier#UNREACHABLE}
   */
  void onConnectivityResultAvailable(String reachabilityStatus);
}
