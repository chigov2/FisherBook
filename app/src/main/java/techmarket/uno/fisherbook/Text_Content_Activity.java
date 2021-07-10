package techmarket.uno.fisherbook;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;//пришлось добавлять вручную
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

//////, @Nullable PersistableBundle persistentState)////////////////////важно удалить
//////  , persistentStated
public class Text_Content_Activity extends AppCompatActivity {
    private Typeface font_lobster;
    private Typeface font_roboto;
    private Typeface font_rubik;
    private DrawerLayout drawer;
    private ImageView imageContent;
    private TextView textMainContent;
    private ImageView img1;
    private ImageView img2;
    private TextView textBar;
    private int category = 0;
    private int position = 0;
    private int[] getArray_image_fish = {
            R.drawable.swimbait,
            R.drawable.shuca,
            R.drawable.som,
            R.drawable.nalim,
            R.drawable.caras};

    private int[] array_fish =
           {R.string.fish0,
            R.string.fish1,
            R.string.fish2,
            R.string.fish3,
            R.string.fish4};//создаем массив из string.xml
    private int[] array_na =
            {R.string.na0,
             R.string.na1,
             R.string.na2,
             R.string.na3,
             R.string.na4};//создаем массив из string.xml
    private int[] array_sna =
            {R.string.sna0,
             R.string.sna1,
             R.string.sna2,
             R.string.sna3,
             R.string.sna4};//создаем массив из string.xml
    private int[] array_pri =
            {R.string.pri0,
            R.string.pri1,
            R.string.pri2,
            R.string.pri3,
            R.string.pri4};//создаем массив из string.xml
    private int[] array_raz =
            {R.string.raz0,
             R.string.raz1,
             R.string.raz2,
             R.string.raz3,
             R.string.raz4};//создаем массив из string.xml


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        img1 = findViewById(R.id.imageView3);
        img2 = findViewById(R.id.imageView4);
        textBar = findViewById(R.id.textView);
        //textMainContent = findViewById(R.id.textMainContent);   //перенесено в отдельную функцию init
        //imageContent = findViewById(R.id.image_content);
        init();
        receiveIntent();


             }


    //делаем функция для обработки putextra
    private void receiveIntent()
    {
        Intent intent_text = getIntent();//если получим интент - >intent_text
        if(intent_text !=null)
        {
            category = intent_text.getIntExtra("category",0);
            position = intent_text.getIntExtra("position",0);
            //пишем код, который передаст необходимы ресурс на экран
            switch (category)
            {
                case 0:
                    textMainContent.setText(array_fish[position]);
                    imageContent.setImageResource(getArray_image_fish[position]);

                    break;
                case 1:
                    //////////////// создать array
                    textMainContent.setText(array_na[position]);
                    break;
                case 2:
                    //////////////// создать array
                    textMainContent.setText(array_sna[position]);
                    break;
                case 3:
                    //////////////// создать array
                    textMainContent.setText(array_pri[position]);
                    break;
                case 4:
                    //////////////// создать array
                    textMainContent.setText(array_raz[position]);
                    break;
            }

        }



    }

    private void init(){
        textMainContent = findViewById(R.id.textMainContent);   //перенесено в отдельную функцию
        imageContent = findViewById(R.id.image_content);
        //после!!!!
        font_lobster = Typeface.createFromAsset(this.getAssets(),"Fonts/Lobster/Lobster-Regular.ttf");
        font_roboto = Typeface.createFromAsset(this.getAssets(),"Fonts/Roboto_Condensed/RobotoCondensed-Regular.ttf");
        font_rubik = Typeface.createFromAsset(this.getAssets(),"Fonts/Rubik/Rubik-VariableFont_wght.ttf");
        textMainContent.setTypeface(font_lobster);//присваиваем данный шрифт
        //textMainContent.setTypeface(font_roboto);//присваиваем данный шрифт
        //textMainContent.setTypeface(font_rubik);
    }

}
