package id.ac.umn.stevenlie_00000033738_if570_el_uts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    TextView tvRef1, tvRef2, tvRef3, tvRef4, tvRef5, tvRef6, tvRef7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvRef1 = findViewById(R.id.Ref1);
        tvRef1.setMovementMethod(LinkMovementMethod.getInstance());
        tvRef2 = findViewById(R.id.Ref2);
        tvRef2.setMovementMethod(LinkMovementMethod.getInstance());
        tvRef3 = findViewById(R.id.Ref3);
        tvRef3.setMovementMethod(LinkMovementMethod.getInstance());
        tvRef4 = findViewById(R.id.Ref4);
        tvRef4.setMovementMethod(LinkMovementMethod.getInstance());
        tvRef5 = findViewById(R.id.Ref5);
        tvRef5.setMovementMethod(LinkMovementMethod.getInstance());
        tvRef6 = findViewById(R.id.Ref6);
        tvRef6.setMovementMethod(LinkMovementMethod.getInstance());
        tvRef7 = findViewById(R.id.Ref7);
        tvRef7.setMovementMethod(LinkMovementMethod.getInstance());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Profile");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}