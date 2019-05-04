package sample.reachablility.internet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import sample.reachablility.reachablilitymanager.ReachabilityManagerAPI;
import sample.reachablility.reachablilitymanager.ReachabilityManagerAPIConnectivityResultNotifier;

public class MainActivity extends AppCompatActivity implements
    ReachabilityManagerAPIConnectivityResultNotifier, View.OnClickListener {

  private EditText editTextUrl;
  private TextView textViewReachabilityResultValue;
  private ReachabilityManagerAPI reachabilityManagerAPI;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initializeViews();
  }

  private void initializeViews() {
    editTextUrl = findViewById(R.id.editTextUrl);
    Button buttonCheckReachability = findViewById(R.id.buttonCheckReachability);
    buttonCheckReachability.setOnClickListener(this);
    textViewReachabilityResultValue = findViewById(R.id.textViewReachabilityResultValue);
  }

  /**
   * Called when the reachability status of the request is available
   *
   * @param reachabilityStatus {@link ReachabilityManagerAPIConnectivityResultNotifier#REACHABLE} or
   * {@link ReachabilityManagerAPIConnectivityResultNotifier#UNREACHABLE}
   */
  @Override public void onConnectivityResultAvailable(String reachabilityStatus) {
    if (reachabilityStatus != null) {
      textViewReachabilityResultValue.setText(reachabilityStatus);
    }
  }

  /**
   * Called when a view has been clicked.
   *
   * @param v The view that was clicked.
   */
  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.buttonCheckReachability:
        textViewReachabilityResultValue.setText("");
        requestReachablitityFromLibrary();
        break;
    }
  }

  private void requestReachablitityFromLibrary() {
    // demo usage of our library
    if (reachabilityManagerAPI == null) {
      reachabilityManagerAPI = new ReachabilityManagerAPI();
    }
    reachabilityManagerAPI.isInternetUrlReachable(editTextUrl.getText().toString(), this, this);
  }
}
