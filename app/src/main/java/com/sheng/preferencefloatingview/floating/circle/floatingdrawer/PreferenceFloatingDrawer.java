package com.sheng.preferencefloatingview.floating.circle.floatingdrawer;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import com.sheng.preferencefloatingview.floating.BaseDrawer;
import com.sheng.preferencefloatingview.floating.IBaseHolder;
import com.sheng.preferencefloatingview.floating.SportCircleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 添加浮动的小"组件" 处理点击事件
 *
 * @author sheng
 */
public class PreferenceFloatingDrawer extends BaseDrawer {

    private long currentMS;
    private float downX;
    private float downY;
    private float moveX;
    private float moveY;
    private long mLastClickTime;
    private boolean mCanClick;
    private CircleHolderSelect mCircleHolderSelect;
    private List<CircleHolder.Builder> mCircleHolderList;

    public PreferenceFloatingDrawer(Context context) {
        super(context);
        mCircleHolderSelect = new CircleHolderSelect();
    }


    @Override
    protected void setSize(int width, int height) {
        super.setSize(width, height);
        if (holders.size() == 0) {
            //这里你可以添加各种自定义的holder 但是如果你需要点击事件的话  你需要在
            mCircleHolderSelect.initCircleHolder(width);
            mCircleHolderList = mCircleHolderSelect.circleHolderList;
            for (CircleHolder.Builder builder : mCircleHolderList) {

                float dx = (float) ((Math.random()) / 30);

                float dy = (float) ((Math.random()) / 30);

                builder.setDx(dx * width);
                builder.setDy(dy * width);

                addHolder(builder.build());
            }

        }
    }


    @Override
    protected int[] getFloatingBackgroundGradient() {
        return FloatingBackground.TRANS;
    }

    private CircleHolder circleHolder;

    @Override
    protected void onTouch(MotionEvent e) {
        super.onTouch(e);
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = e.getX();
                downY = e.getY();
                moveX = 0;
                moveY = 0;
                currentMS = System.currentTimeMillis();
                if (currentMS - mLastClickTime >= 350) {
                    mCanClick = true;
                }
                mLastClickTime = currentMS;
                break;
            case MotionEvent.ACTION_MOVE:
                /**
                 * X轴距离
                 */
                moveX += Math.abs(e.getX() - downX);
                /**
                 * y轴距离
                 */
                moveY += Math.abs(e.getY() - downY);
                downX = e.getX();
                downY = e.getY();
                break;
            case MotionEvent.ACTION_UP:
                /**
                 * 移动时间
                 */
                long moveTime = System.currentTimeMillis() - currentMS;
                //判断是否继续传递信号
                if (isClick(moveTime) || !mCanClick) {
                    //不再执行后面的事件，在这句前可写要执行的触摸相关代码。点击事件是发生在触摸弹起后

                    break;
                } else {
                    ArrayList<IBaseHolder> iHolders = getIHolders();
                    for (IBaseHolder hold : iHolders) {
                        if (hold instanceof CircleHolder) {
                            CircleHolder holder = ((CircleHolder) hold);
                            //点击位置x坐标与圆心的x坐标的距离
                            int distanceX = (int) Math.abs(holder.isNowBigCircle() ? holder.curCX - downX : holder.curSmallCX - downX);
                            //点击位置y坐标与圆心的y坐标的距离
                            int distanceY = (int) Math.abs(holder.isNowBigCircle() ? holder.curCY - downY : holder.curSmallCY - downY);
                            //点击位置与圆心的直线距离
                            int distanceZ = (int) Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
                            //如果点击位置与圆心的距离大于圆的半径，证明点击位置没有在圆内

                            //                            Log.i("POSTION:", getIHolders().size() +"  distanceZ ==  " + distanceZ + "  holder.radius == " + holder.radius);

//                            if (!holder.isNowBigCircle()) {
//                                holder.circleClick(!holder.isNowBigCircle(), false);
//                                Log.i("POSTION:", " 点击位置没有在圆内  " + !holder.isNowBigCircle());
//                            }
//
                            int index = getIHolders().indexOf(holder);
                            if (distanceZ <= (holder.isNowBigCircle() ? holder.radius : holder.radius * holder.rate)) {
                                 for (IBaseHolder hold1 : iHolders) {
                                     if (hold1 instanceof CircleHolder) {
                                         CircleHolder holder1 = ((CircleHolder) hold1);

                                         if (!holder1.isNowBigCircle()) {
                                             holder1.circleClick(!holder1.isNowBigCircle(), false);
                                         }

                                     }
                                 }
                                circleHolder = holder;
                                Log.i("POSTION:", index + " ***********" + mCircleHolderList.get(index).name);
                                holder.circleClick(!holder.isNowBigCircle(), true);

                            }


                        }
                    }
                }
                mCanClick = false;
                break;
            default:
                break;
        }
    }

    private boolean isClick(long moveTime) {
        return moveTime > ViewConfiguration.getDoubleTapTimeout() || (moveX > 30 || moveY > 30);
    }
}
