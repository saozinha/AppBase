package br.com.oslourencos.appbase;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
=======
import android.view.Window;
import android.view.WindowManager;
>>>>>>> 5da367c6bfd9e752392e553ac9e5b87045fbe71a

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_splash);

<<<<<<< HEAD
=======
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
>>>>>>> 5da367c6bfd9e752392e553ac9e5b87045fbe71a
        openListClient();
    }

    private void openListClient() {
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
<<<<<<< HEAD
        },2000); // conta 2 segundos
=======
        },4000); // conta 2 segundos
>>>>>>> 5da367c6bfd9e752392e553ac9e5b87045fbe71a
    }
}
