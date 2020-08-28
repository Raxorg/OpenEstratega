package com.frontanilla.estratega;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.frontanilla.estratega.core.EstrategaGame;

public class AndroidLauncher extends AndroidApplication {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new EstrategaGame(), new AndroidApplicationConfiguration());
    }
}
