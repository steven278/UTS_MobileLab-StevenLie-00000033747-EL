package id.ac.umn.stevenlie_00000033738_if570_el_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormInputActivity extends AppCompatActivity {
    Button btnNext;
    EditText etName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_input);
        btnNext = findViewById(R.id.Next);
        etName = findViewById(R.id.inputName);
        getSupportActionBar().hide();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(etName.getText())){
                    etName.setError("Harap Diisi");
                }
                else{
                    Intent LibraryIntent = new Intent(getApplicationContext(), LibraryActivity.class);
                    String username = etName.getText().toString();
                    LibraryIntent.putExtra(LibraryActivity.EXTRA_NAME, username);
                    finish();
                    startActivity(LibraryIntent);
                }
            }
        });
    }
}