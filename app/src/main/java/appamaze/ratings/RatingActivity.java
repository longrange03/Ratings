package appamaze.ratings;

//functions...

import java.text.DecimalFormat;
import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class RatingActivity extends Activity implements
        OnRatingBarChangeListener {
    RatingBar getRatingBar;
    RatingBar setRatingBar;
    TextView countText;
    TextView averageText;
    int count;
    float curRate;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        findViewsById();

        setRatingBar.setRating(curRate);
        getRatingBar.setOnRatingBarChangeListener(this);
    }

    private void findViewsById() {
        getRatingBar = (RatingBar) findViewById(R.id.getRating);
        setRatingBar = (RatingBar) findViewById(R.id.setRating);
        countText = (TextView) findViewById(R.id.countText);
        averageText = (TextView) findViewById(R.id.average);
    }

    public void onRatingChanged(RatingBar rateBar, float rating,
                                boolean fromUser) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        curRate = Float.valueOf(decimalFormat.format((curRate * count + rating)
                / ++count));
        Toast.makeText(RatingActivity.this,
                "New Rating: " + curRate, Toast.LENGTH_SHORT).show();
        setRatingBar.setRating(curRate);
        countText.setText(count + " Ratings");
    }
}