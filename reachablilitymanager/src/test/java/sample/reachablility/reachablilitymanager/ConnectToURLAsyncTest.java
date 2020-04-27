package sample.reachablility.reachablilitymanager;

import org.junit.Assert;
import org.junit.Test;

public class ConnectToURLAsyncTest implements ConnectivityResultNotifier {

  @Test
  public void doInBackground() {
    String inputTestValue;
    boolean expectedReturnValue;
    ConnectToURLAsync connectToURLAsync = new ConnectToURLAsync(this);
    inputTestValue = "https://google.com/";
    connectToURLAsync.execute(inputTestValue);

    expectedReturnValue = false;
    Assert.assertEquals("Remove curly brackets from the Unicode", expectedReturnValue,
        connectToURLAsync.doInBackground());
  }

  @Test
  public void onPostExecute() {
  }

  /**
   * Publishes the result of connection status.
   *
   * @param result true if the connection is successful
   */
  @Override public void onResultPublished(Boolean result) {
    // TODO
  }
}