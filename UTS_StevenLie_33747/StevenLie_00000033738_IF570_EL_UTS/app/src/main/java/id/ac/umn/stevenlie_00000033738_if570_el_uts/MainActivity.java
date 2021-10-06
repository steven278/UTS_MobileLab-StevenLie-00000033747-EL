package id.ac.umn.stevenlie_00000033738_if570_el_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button profile,library;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profile = this.findViewById(R.id.btn_profile);
        library = this.findViewById(R.id.btn_library);
        getSupportActionBar().hide();
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(profileIntent);
            }
        });
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent FormInputIntent = new Intent(MainActivity.this, FormInputActivity.class);
                startActivity(FormInputIntent);
            }
        });
    }
}