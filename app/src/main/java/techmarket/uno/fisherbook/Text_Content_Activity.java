package techmarket.uno.fisherbook;


import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;//пришлось добавлять вручную

//////, @Nullable PersistableBundle persistentState)////////////////////важно удалить
//////  , persistentState
public class Text_Content_Activity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
    }
}
