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
import java.util.List;

import techmarket.uno.fisherbook.databinding.ActivityMainBinding;
import techmarket.uno.fisherbook.utils.customArrayAdapter;
import techmarket.uno.fisherbook.utils.listItemClass;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private ListView list1;
    private String[] array1,arraySec_name;
    //private ArrayAdapter<String> adapter1;
    private customArrayAdapter adapter1;
    private Toolbar toolbar;
    private ImageView img1;
    private ImageView img2;
    private TextView textBar;
    private int category_index;
    private int[] array_fish_color = new int[] {R.color.red,R.color.yellow,R.color.green,R.color.blue,R.color.black};
    private List<listItemClass> listItemMain;//массив из структур
    private listItemClass listItem;



    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //toolbar.setTitle(R.string.fish);

        list1 = findViewById(R.id.listView1);
        array1 = getResources().getStringArray(R.array.fish_array);
        arraySec_name = getResources().getStringArray(R.array.fish_array_2);

        listItemMain = new ArrayList<>();// ArrayList() - встроенная функция!!!
        //заполнение
       for (int i = 0; i < array1.length; i++){
           listItem = new listItemClass();
           listItem.setName(array1[i]);
           listItem.setSecond_name(arraySec_name[i]);
           listItem.setImage_id(array_fish_color[i]);
           listItemMain.add(listItem);
       }


        //adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array1)));// adapter принимает только ArraysList, поэтому необходимо преобразовать

        //необходимо моздать класс, который будет хранить данные

        adapter1 = new customArrayAdapter(this,R.layout.list_view_item_1,listItemMain,getLayoutInflater());


        list1.setAdapter(adapter1);

        img1 = findViewById(R.id.imageView3);
        img2 = findViewById(R.id.buttonSettings);
        textBar = findViewById(R.id.textActionBar);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Left button", Toast.LENGTH_SHORT).show();
                //drawer.closeDrawer(GravityCompat.START);
                drawer.openDrawer(GravityCompat.START);
            }
        });


        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Right button", Toast.LENGTH_SHORT).show();
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
        drawer = findViewById(R.id.drawer_layout);
        //DrawerLayout drawer  =findViewById(R.id.drawer_layout);
        NavigationView navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);


        //слушатель меню создается здесь!!!
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Text_Content_Activity.class);//создаем сообщение о переходе на другое окно
                // и еще передаем на другое активини информацию
                //name должно совпасть с именем, когда получаю информацию
                intent.putExtra("category", category_index);
                intent.putExtra("position", position);
                //буду знать, на какую категорию и и какой элементи из listview1 нажали
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

    @Override// выбор в боковом меню
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_fish) {
            Toast.makeText(this, "Fish pressed", Toast.LENGTH_SHORT).show();
            // и ничего не происходит - добавлено в строке 49
            fillArray(R.array.fish_array, R.string.fish, 0);
        } else if (id == R.id.nav_na) {
            fillArray(R.array.na_array, R.string.na, 1);
        } else if (id == R.id.nav_sna) {
            fillArray(R.array.sna_array, R.string.sna, 2);
        } else if (id == R.id.menu_pri) {
            fillArray(R.array.menu_pri, R.string.pri, 3);
        } else if (id == R.id.menu_raz) {
            fillArray(R.array.menu_raz, R.string.raz, 4);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void fillArray(int arrayList, int textTop, int index) {
        array1 = getResources().getStringArray(arrayList);
        adapter1.clear();
        //adapter1.addAll(array1);
        adapter1.notifyDataSetChanged();
        textBar.setText(textTop);
        category_index = index;
    }

}