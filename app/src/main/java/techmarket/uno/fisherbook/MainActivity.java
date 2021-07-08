package techmarket.uno.fisherbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import techmarket.uno.fisherbook.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private ListView list1;
    private String[] array1;
    private ArrayAdapter<String> adapter1;
    private Toolbar toolbar;
    private ImageView img1;
    private ImageView img2;
    private TextView textBar;


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //toolbar = findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        //toolbar.setTitle(R.string.fish);

        list1 = findViewById(R.id.listView1);
        array1 = getResources().getStringArray(R.array.fish_array);
        //adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,array1);
        //ничего не понятно
        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,new ArrayList<String>(Arrays.asList(array1)));
        list1.setAdapter(adapter1);

        img1 = findViewById(R.id.imageView3);
        img2 = findViewById(R.id.imageView4);
        textBar = findViewById(R.id.textView);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Left button",Toast.LENGTH_SHORT).show();
                //drawer.closeDrawer(GravityCompat.START);
                drawer.openDrawer(GravityCompat.START);
            }
        });


        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Right button",Toast.LENGTH_SHORT).show();
                //drawer.openDrawer(GravityCompat.START);
            }
        });
            //урок 4-4 10.57 time code
        textBar.setText(getText(R.string.fish));
        textBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });


        //DrawerLayout drawer = binding.drawerLayout;
        drawer  =findViewById(R.id.drawer_layout);
        //DrawerLayout drawer  =findViewById(R.id.drawer_layout);
        NavigationView navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);


        //слушатель меню создается здесь!!!
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Text_Content_Activity.class);//создаем сообщение о переходе на другое окно
                startActivity(intent);
            }
        });

    }


       @Override// создание бокового меню drawer
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_fish)
        {
            Toast.makeText(this,"Fish pressed", Toast.LENGTH_SHORT).show();
            // и ничего не происходит - добавлено в строке 49
            array1 = getResources().getStringArray(R.array.fish_array);
            adapter1.clear();
            adapter1.addAll(array1);
            adapter1.notifyDataSetChanged();
            textBar.setText(R.string.fish);
        }
        else if (id ==R.id.nav_na)
        {
            array1 = getResources().getStringArray(R.array.na_array);
            adapter1.clear();
            adapter1.addAll(array1);
            adapter1.notifyDataSetChanged();
            textBar.setText(R.string.na);
        }
        else if (id ==R.id.nav_sna)
        {
            array1 = getResources().getStringArray(R.array.sna_array);
            adapter1.clear();
            adapter1.addAll(array1);
            adapter1.notifyDataSetChanged();
            textBar.setText(R.string.sna);
        }
        else if (id ==R.id.menu_pri)
        {
            array1 = getResources().getStringArray(R.array.menu_pri);
            adapter1.clear();
            adapter1.addAll(array1);
            adapter1.notifyDataSetChanged();
            textBar.setText(R.string.pri);
        }
        else if (id ==R.id.menu_raz)
        {
            array1 = getResources().getStringArray(R.array.menu_raz);
            adapter1.clear();
            adapter1.addAll(array1);
            adapter1.notifyDataSetChanged();
            textBar.setText(R.string.raz);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}