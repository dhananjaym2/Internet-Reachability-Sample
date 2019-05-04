package sample.reachablility.reachablilitymanager;

interface ConnectivityResultNotifier {

  /**
   * Publishes the result of connection status.
   *
   * @param result true if the connection is successful
   */
  void onResultPublished(Boolean result);
}
