package id.ac.umn.stevenlie_00000033738_if570_el_uts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {
    public static final String EXTRA_NAME ="name";
    RecyclerView rvSound;
    ListSoundAdapter mAdapter;
    ArrayList<SFX> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        Toast.makeText(getApplicationContext(), "Selamat Datang, " + name, Toast.LENGTH_LONG).show();
        getSupportActionBar().setTitle(name);

        isiDaftarSound();
        rvSound = findViewById(R.id.rv_sfx);// recyclerview
        mAdapter = new ListSoundAdapter(this, list);
        rvSound.setAdapter(mAdapter);
        rvSound.setLayoutManager(new LinearLayoutManager(this));
        rvSound.setHasFixedSize(true);
    }
    public void isiDaftarSound(){
        list.add(new SFX("we_will_get_there","Accoustic", "android.resource://" + getPackageName() + "/"+ R.raw.we_will_get_there));
        list.add(new SFX("laid_back","Rock", "android.resource://" + getPackageName() + "/"+ R.raw.laid_back));
        list.add(new SFX("rancid_life","Rock", "android.resource://" + getPackageName() + "/"+ R.raw.rancid_life));
        list.add(new SFX("new_world","Indie", "android.resource://" + getPackageName() + "/"+ R.raw.new_world));
        list.add(new SFX("japanika","Accoustic", "android.resource://" + getPackageName() + "/"+ R.raw.japanika));
        list.add(new SFX("clear_sky","Indie", "android.resource://" + getPackageName() + "/"+ R.raw.clear_sky));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.goToProfile:
                Intent profileIntent = new Intent(LibraryActivity.this, ProfileActivity.class);
                finish();
                startActivity(profileIntent);
                return true;
            case R.id.goToMainMenu:
                Intent mainMenuIntent = new Intent(LibraryActivity.this, MainActivity.class);
                finish();
                startActivity(mainMenuIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}