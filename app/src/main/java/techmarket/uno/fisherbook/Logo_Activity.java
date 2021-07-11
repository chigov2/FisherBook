package techmarket.uno.fisherbook;


import android.app.Activity;//все новые активити добавлять в манифест
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class Logo_Activity extends Activity {// Ctrl + O - открыть все методы функции этого класса
    private Animation logoAnim, buttonLogoAnim;//две переменные с анимацией

    private Button bAnim;
    private ImageView logoImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//тепеть содать сам экран - > layout
        setContentView(R.layout.logo_activity);
        init();
        startMainActivity();
    }

    public void onClickStart(View view) {
        Intent intent = new Intent(Logo_Activity.this,MainActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();// если финиш не сделать - программа вернется на лого экран
    }
    private void init(){
        logoImage = findViewById(R.id.imageView2);
        bAnim = findViewById(R.id.bAnim);
        // Загружаем анимации в переменные
        //logoAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo_anim);
        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha_anim);
        buttonLogoAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_anim);

        //Запускаем анимацию
        logoImage.startAnimation(logoAnim);
        bAnim.startAnimation(buttonLogoAnim);
    }

    private void startMainActivity(){
        new Thread(new Runnable() {                                        //создание второго потока для предотвращения зависания
            @Override
            public void run() {                                            //обязательно добавить проверку
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Logo_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        }).start();                                                                 //start обязательно


    }
}
