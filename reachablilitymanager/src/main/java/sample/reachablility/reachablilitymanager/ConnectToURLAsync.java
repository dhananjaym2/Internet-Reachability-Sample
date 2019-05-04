package sample.reachablility.reachablilitymanager;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Tries to connect with the provided URL as a {@link String}. Notifies the result via {@link
 * ConnectivityResultNotifier#onResultPublished(Boolean)}
 */
class ConnectToURLAsync extends AsyncTask<String, Void, Boolean> {

  private ConnectivityResultNotifier connectivityResultNotifier;

  ConnectToURLAsync(ConnectivityResultNotifier connectivityResultNotifier) {
    this.connectivityResultNotifier = connectivityResultNotifier;
  }

  /**
   * Override this method to perform a computation on a background thread. The
   * specified parameters are the parameters passed to {@link #execute}
   * by the caller of this task.
   *
   * This method can call {@link #publishProgress} to publish updates
   * on the UI thread.
   *
   * @param urls The parameters of the task.
   * @return A result, defined by the subclass of this task.
   * @see #onPreExecute()
   * @see #onPostExecute
   * @see #publishProgress
   */
  @Override protected Boolean doInBackground(String... urls) {
    if (urls.length > 0) {
      return isConnectivityToURLSuccessful(urls[0]);
    }
    return false;
  }

  @Override protected void onPostExecute(Boolean result) {
    super.onPostExecute(result);
    connectivityResultNotifier.onResultPublished(result);
  }

  /**
   * Checks if the connection to the specified url is successful or not
   *
   * @param url URL as a {@link String}
   * @return true if the connection to this url is successful else false
   */
  private boolean isConnectivityToURLSuccessful(String url) {

    try {
      // create a URL from the parameter url
      URL formattedUrl = new URL(url);

      URLConnection urlConnection = formattedUrl.openConnection();

      // GET call to the formatted URL
      urlConnection.connect();

      // receive response as inputStream
      InputStream inputStream = urlConnection.getInputStream();

      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

      if (bufferedReader.readLine() != null) {
        // TODO check HTTP status.
        return true;
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return false;
  }
}