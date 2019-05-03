package sample.reachablility.reachablilitymanager;

class Internet {

  static boolean isUrlReachable(String url) {
    if (url != null) {
      if (isValidURL(url)) {

        if (isInternetAvailable()) {

          if (connectivityIsSuccessful(url)) {
            return true;
          }
        }

        //
      }
    }
    return false;
  }

  private static boolean connectivityIsSuccessful(String url) {

    // try connecting to the provided URL

    return false;
  }

  private static boolean isInternetAvailable() {

    // check internet connectivity of our application

    return false;
  }

  private static boolean isValidURL(String url) {

    // logic to check if the URL is valid or not

    return false;
  }
}
