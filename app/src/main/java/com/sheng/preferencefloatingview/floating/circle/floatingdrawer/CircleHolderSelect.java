package com.sheng.preferencefloatingview.floating.circle.floatingdrawer;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qietv on 2018/10/24.
 */
public class CircleHolderSelect {

    List<CircleHolder.Builder> circleHolderList = new ArrayList<>();

    public void initCircleHolder(int width) {

        float percentSpeed = 0.01f;
        float rate = 1f;
        // 设置速度
        CircleHolder.Builder builder1 =   new CircleHolder.Builder()
                .setCx(0.72f * width)
                .setCy(0.4f * width)
                .setRadius(0.24f * width)
                .setPercentSpeed(percentSpeed)
                .setColor(Color.parseColor("#FFBF14"))
                .setName("女排世锦赛")
                .setRate(rate)
                .setSmallColor(Color.parseColor("#FF9B12"));

        CircleHolder.Builder builder2 =  new CircleHolder.Builder()
                .setCx(0.34f * width)
                .setCy(0.95f * width)
                .setRadius(0.18f * width)
                .setPercentSpeed(percentSpeed)
                .setColor(Color.parseColor("#FFBF14"))
                .setName("F1大奖赛")
                .setRate(0.5f)
                .setSmallColor(Color.parseColor("#FF9B12"));

        CircleHolder.Builder builder3 =  new CircleHolder.Builder()
                .setCx(0.2f * width)
                .setCy(0.3f * width)
                .setRadius(0.13f * width)
                .setPercentSpeed(percentSpeed)
                .setColor(Color.parseColor("#FFBF14"))
                .setName("中式八球")
                .setRate(0.5f)
                .setSmallColor(Color.parseColor("#FF9B12"));

        CircleHolder.Builder builder4 =   new CircleHolder.Builder()
                .setCx(0.83f * width)
                .setCy(1.05f * width)
                .setRadius(0.13f * width)
                .setPercentSpeed(percentSpeed)
                .setColor(Color.parseColor("#FFBF14"))
                .setName("武林风")
                .setRate(0.5f)
                .setSmallColor(Color.parseColor("#FF9B12"));

        CircleHolder.Builder builder5 =  new CircleHolder.Builder()
                .setCx(0.64f * width)
                .setCy(0.82f * width)
                .setRadius(0.12f * width)
                .setPercentSpeed(percentSpeed)
                .setColor(Color.parseColor("#FFBF14"))
                .setName("NBA")
                .setRate(0.5f)
                .setSmallColor(Color.parseColor("#FF9B12"));


        CircleHolder.Builder builder6 =  new CircleHolder.Builder()
                .setCx(0.15f * width)
                .setCy(0.6f * width)
                .setRadius(0.11f * width)
                .setPercentSpeed(percentSpeed)
                .setColor(Color.parseColor("#FFBF14"))
                .setName("斗地主")
                .setRate(0.5f)
                .setSmallColor(Color.parseColor("#FF9B12"));


        CircleHolder.Builder builder7 =  new CircleHolder.Builder()
                .setCx(0.43f * width)
                .setCy(0.2f * width)
                .setRadius(0.08f * width)
                .setPercentSpeed(percentSpeed)
                .setColor(Color.parseColor("#FFBF14"))
                .setName("英超")
                .setRate(0.5f)
                .setSmallColor(Color.parseColor("#FF9B12"));


        CircleHolder.Builder builder8 =  new CircleHolder.Builder()
                .setCx(0.38f * width)
                .setCy(0.5f * width)
                .setRadius(0.08f * width)
                .setPercentSpeed(percentSpeed)
                .setColor(Color.parseColor("#FFBF14"))
                .setName("CBA")
                .setRate(0.5f)
                .setSmallColor(Color.parseColor("#FF9B12"));


        CircleHolder.Builder builder9 = new CircleHolder.Builder()
                .setCx(0.85f * width)
                .setCy(0.74f * width)
                .setRadius(0.08f * width)
                .setPercentSpeed(percentSpeed)
                .setColor(Color.parseColor("#FFBF14"))
                .setName("NFL")
                .setRate(0.5f)
                .setSmallColor(Color.parseColor("#FF9B12"));

        circleHolderList.add(builder1);
        circleHolderList.add(builder2);
        circleHolderList.add(builder3);
        circleHolderList.add(builder4);
        circleHolderList.add(builder5);
        circleHolderList.add(builder6);
        circleHolderList.add(builder7);
        circleHolderList.add(builder8);
        circleHolderList.add(builder9);

        setNameAndSpeed(null);
    }

    /**
     * 设置数据Name
     * @param list
     */
    public void setNameAndSpeed(List list) {

    }
}
