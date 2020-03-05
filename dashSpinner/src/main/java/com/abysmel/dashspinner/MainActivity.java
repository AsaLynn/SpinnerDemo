package com.abysmel.dashspinner;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.zxn.spinner.DashSpinner;

public class MainActivity extends Activity implements DashSpinner.OnDownloadIntimationListener {

    protected ImageView ivOk;
    float mnProgress = 0.0f;
    DashSpinner mDashSpinner = null;

    Handler mHandler = new Handler();

    //Run to 100% and then show Success
    Runnable runnableSuccess = new Runnable() {
        @Override
        public void run() {
            setProgress();

            //SUCCESS
            if (mnProgress < 360 * 1) mHandler.postDelayed(this, 10);
            else mDashSpinner.showSuccess();

//			if (mnProgress == 1.0){
//				mDashSpinner.showSuccess();
//			}
        }
    };

    //Run to 50% and show failure
    Runnable runnableFailure = new Runnable() {
        @Override
        public void run() {
            setProgress();
            //FAILURE
            if (mnProgress <= 0.5) mHandler.postDelayed(this, 30);
            else mDashSpinner.showFailure();
        }
    };

    //Show Unknown Error
    Runnable runnableUnknown = new Runnable() {
        @Override
        public void run() {
            //UNKNOWN
            mDashSpinner.showUnknown();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        //iv_ok
        mDashSpinner = (DashSpinner) findViewById(R.id.progress_spinner);
        mDashSpinner.setOnDownloadIntimationListener(this);

        //Success Button
        findViewById(R.id.success_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mDashSpinner.resetValues();
                //mnProgress = 0.0f;
                //mHandler.post(runnableSuccess);
                ivOk.setVisibility(View.INVISIBLE);
                mDashSpinner.start();
            }
        });

        //Failure Button
        findViewById(R.id.failure_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDashSpinner.resetValues();
                mnProgress = 0.0f;
                mHandler.post(runnableFailure);
            }
        });

        //Unknown Error Button
        findViewById(R.id.unknown_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDashSpinner.resetValues();
                mnProgress = 0.0f;
                mHandler.post(runnableUnknown);
            }
        });
        initView();
    }


    private void setProgress() {
        //mnProgress += 0.01;
        mnProgress += 1;
        mDashSpinner.setProgress(mnProgress);
    }

    @Override
    public void onDownloadIntimationDone(DashSpinner.DASH_MODE dashMode) {
        switch (dashMode) {
            case SUCCESS:
                Toast.makeText(this, "Download Successful!", Toast.LENGTH_SHORT).show();
                ivOk.setVisibility(View.VISIBLE);
                //
                ivOk.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.svfade_in_center));
                break;
            case FAILURE:
                Toast.makeText(this, "Download Failed!", Toast.LENGTH_SHORT).show();
                break;
            case UNKNOWN:
                Toast.makeText(this, "Unknown Download Error!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void initView() {
        ivOk = (ImageView) findViewById(R.id.iv_ok);
    }
}
