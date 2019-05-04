package sample.reachablility.internet;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import sample.reachablility.reachablilitymanager.ReachabilityManagerAPI;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String url = "http://www.google.com";
    // demo usage of our library
    ReachabilityManagerAPI reachabilityManagerAPI = new ReachabilityManagerAPI();
    reachabilityManagerAPI.isInternetUrlReachable(url, this);
  }
}
