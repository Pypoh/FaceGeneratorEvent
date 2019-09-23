package com.example.facegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Face Component
    ImageView headImage;
    ImageView hairImage;
    ImageView eyebrowImage;
    ImageView eyesImage;
    ImageView moustacheImage;
    ImageView beardImage;

    // Editor Component
    CheckBox headCheck;
    CheckBox hairCheck;
    CheckBox eyebrowCheck;
    CheckBox eyesCheck;
    CheckBox moustacheCheck;
    CheckBox beardCheck;

    // State
    boolean headState = true;
    boolean hairState = true;
    boolean eyebrowsState = true;
    boolean eyesState = true;
    boolean moustacheState = true;
    boolean beardState = true;

    // Utils
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupIds();

        // Check Instance
        if (savedInstanceState != null) {
            headState = savedInstanceState.getBoolean("headStatus");
            hairState = savedInstanceState.getBoolean("hairStatus");
            eyebrowsState = savedInstanceState.getBoolean("eyebrowStatus");
            eyesState = savedInstanceState.getBoolean("eyebrowStatus");
            moustacheState = savedInstanceState.getBoolean("moustacheStatus");
            beardState = savedInstanceState.getBoolean("beardStatus");
        }

        refreshState();

        checkOrientation();

    }

    private void checkOrientation() {
        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "Your current screen orientation is Portrait", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Your current screen orientation is Landscape", Toast.LENGTH_SHORT).show();
        }
    }

    private void setupIds() {
        headImage = findViewById(R.id.image_head);
        hairImage = findViewById(R.id.image_hair);
        eyebrowImage = findViewById(R.id.image_eyebrow);
        eyesImage = findViewById(R.id.image_eyes);
        moustacheImage = findViewById(R.id.image_moustache);
        beardImage = findViewById(R.id.image_beard);

        headCheck = findViewById(R.id.check_head);
        hairCheck = findViewById(R.id.check_hair);
        eyebrowCheck = findViewById(R.id.check_eyebrow);
        eyesCheck = findViewById(R.id.check_eyes);
        moustacheCheck = findViewById(R.id.check_moustache);
        beardCheck = findViewById(R.id.check_beard);

        refreshState();

        resetButton = findViewById(R.id.button_reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headState = true;
                hairState = true;
                eyebrowsState = true;
                eyesState = true;
                moustacheState = true;
                beardState = true;
                refreshState();
            }
        });

        headCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    headImage.setVisibility(View.VISIBLE);
                } else {
                    headImage.setVisibility(View.INVISIBLE);
                }
                headState = isChecked;
            }
        });

        hairCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    hairImage.setVisibility(View.VISIBLE);
                } else {
                    hairImage.setVisibility(View.INVISIBLE);
                }
                hairState = isChecked;
            }
        });

        eyebrowCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    eyebrowImage.setVisibility(View.VISIBLE);
                } else {
                    eyebrowImage.setVisibility(View.INVISIBLE);
                }
                eyebrowsState = isChecked;
            }
        });

        eyesCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    eyesImage.setVisibility(View.VISIBLE);
                } else {
                    eyesImage.setVisibility(View.INVISIBLE);
                }
                eyesState = isChecked;
            }
        });

        moustacheCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    moustacheImage.setVisibility(View.VISIBLE);
                } else {
                    moustacheImage.setVisibility(View.INVISIBLE);
                }
                moustacheState = isChecked;
            }
        });

        beardCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    beardImage.setVisibility(View.VISIBLE);
                } else {
                    beardImage.setVisibility(View.INVISIBLE);
                }
                beardState = isChecked;
            }
        });
    }

    private void refreshState() {
        headCheck.setChecked(headState);
        hairCheck.setChecked(hairState);
        eyebrowCheck.setChecked(eyebrowsState);
        eyesCheck.setChecked(eyesState);
        moustacheCheck.setChecked(moustacheState);
        beardCheck.setChecked(beardState);
    }

    private void refreshImageState() {
        if (headState) {
            headImage.setVisibility(View.VISIBLE);
        } else {
            headImage.setVisibility(View.INVISIBLE);
        }
        if (hairState) {
            hairImage.setVisibility(View.VISIBLE);
        } else {
            hairImage.setVisibility(View.INVISIBLE);
        }
        if (eyebrowsState) {
            eyebrowImage.setVisibility(View.VISIBLE);
        } else {
            eyebrowImage.setVisibility(View.INVISIBLE);
        }
        if (eyesState) {
            eyesImage.setVisibility(View.VISIBLE);
        } else {
            eyesImage.setVisibility(View.INVISIBLE);
        }
        if (moustacheState) {
            moustacheImage.setVisibility(View.VISIBLE);
        } else {
            moustacheImage.setVisibility(View.INVISIBLE);
        }
        if (beardState) {
            beardImage.setVisibility(View.VISIBLE);
        } else {
            beardImage.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("headStatus", headState);
        outState.putBoolean("hairStatus", hairState);
        outState.putBoolean("eyebrowStatus", eyebrowsState);
        outState.putBoolean("eyesStatus", eyesState);
        outState.putBoolean("moustacheStatus", moustacheState);
        outState.putBoolean("beardStatus", beardState);
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
        Log.d("status", "headStatus : " + headState);
        Log.d("status", "hairStatus : " + hairState);
        Log.d("status", "eyebrowStatus : " + eyebrowsState);
        Log.d("status", "eyesStatus : " + eyesState);
        Log.d("status", "moustacheStatus : " + moustacheState);
        Log.d("status", "beardStatus : " + beardState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            headState = savedInstanceState.getBoolean("headStatus");
            hairState = savedInstanceState.getBoolean("hairStatus");
            eyebrowsState = savedInstanceState.getBoolean("eyebrowStatus");
            eyesState = savedInstanceState.getBoolean("eyebrowStatus");
            moustacheState = savedInstanceState.getBoolean("moustacheStatus");
            beardState = savedInstanceState.getBoolean("beardStatus");
            Log.d("statusRestore", "Restored");
        }
    }
}
