package com.sheng.preferencefloatingview;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.sheng.preferencefloatingview.floating.SportCircleView;
import com.sheng.preferencefloatingview.floating.ContainerView;
import com.sheng.preferencefloatingview.floating.TaskModel;
import com.sheng.preferencefloatingview.floating.circle.floatingdrawer.PreferenceFloatingDrawer;
import com.sheng.preferencefloatingview.floating.circle.splashdrawer.RotationSweepView;

import java.util.ArrayList;

/**
 * @author sheng
 */
public class MainActivity extends Activity implements View.OnClickListener{

    private ContainerView containerView;
    private RotationSweepView rotationView;
    private SportCircleView sportCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        findViewById(R.id.close).setOnClickListener(this);
        findViewById(R.id.save).setOnClickListener(this);

        containerView = (ContainerView) findViewById(R.id.floatingView);
//        sportCircleView = (SportCircleView) findViewById(R.id.ball_view);
//        ViewGroup.LayoutParams params = containerView.getLayoutParams();
//        int width = params.width=getMetricsWidth(this)*7/5;
//        containerView.setLayoutParams(params);






//        rotationView = (RotationSweepView) findViewById(R.id.rotationView);
//        rotationView.setIOnAnimEndListener(new IOnAnimEndListener() {
//            @Override
//            public void onAnimEnd() {
//                animStart();
//            }
//        });
//        rotationView.setDistanceXYR(0,0.35f*width,0.5f*width,0.11f*width);
//        rotationView.setDistanceXYR(1,0.75f*width,0.52f*width,0.105f*width);
//        rotationView.setDistanceXYR(2,0.25f*width,0.77f*width,0.14f*width);
//        rotationView.setDistanceXYR(3,0.68f*width,0.95f*width,0.12f*width);
//        rotationView.setDistanceXYR(4,0.42f*width,1.0f*width,0.1f*width);
//        rotationView.setDistanceXYR(5,0.57f*width,0.7f*width,0.13f*width);
//        rotationView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                int width = rotationView.getWidth();
//                int height = rotationView.getHeight();
//                rotationView.setCenterXY(width/2,height/2);
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                    rotationView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//                }
//                containerView.start();
//            }
//        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

//        int measuredHeight = containerView.getMeasuredHeight();
//        int measuredWidth = containerView.getMeasuredWidth();
//        Log.i("yd","measuredHeight == " + measuredHeight + " measuredWidth  ==  " + measuredWidth );
//
//        ArrayList<TaskModel> datas = new ArrayList<>();
//        for (int i = 0 ; i <5 ; i++ ) {
//            TaskModel taskModel  = new TaskModel();
//            taskModel.setId(i+"");
//            taskModel.setName(i+"");
//
//            taskModel.setDifficultyLevel(i+"");
//            datas.add(taskModel);
//        }
//        sportCircleView.setData(datas);
//        sportCircleView.requestLayout();

        containerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        containerView.setDrawer(new PreferenceFloatingDrawer(this));
        containerView.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                containerView.setDrawerStop(false);
            }
        }, 100);

    }

    private void animStart(){
        ValueAnimator animator = ValueAnimator.ofFloat(255,0);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                rotationView.setAlpha((Float) animation.getAnimatedValue());
                if(((Float) animation.getAnimatedValue())==0){
                    rotationView.setVisibility(View.GONE);
                    containerView.setDrawerStop(false);
                }
            }
        });
        animator.setDuration(500);
        animator.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        containerView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        containerView.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        containerView.onDestroy();
    }

    public static int getMetricsWidth(Context context)
    {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.close:
                finish();
                break;
            case R.id.save:
                finish();
                break;
            default:
                break;
        }
    }
}
