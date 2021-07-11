package techmarket.uno.fisherbook.settings;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import techmarket.uno.fisherbook.R;

public class SettingsActivity extends AppCompatActivity {
    private ActionBar actionBar;

    @Override// @org.jetbrains.annotations.Nullable
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar() !=null){ //если actionbar существует
             actionBar = getSupportActionBar();
             actionBar.setDisplayHomeAsUpEnabled(true);
             actionBar.setTitle(getString(R.string.action_settings));
        }
        //getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingFragment()).commit();
    }
}
