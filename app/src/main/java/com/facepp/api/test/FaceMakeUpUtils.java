package com.facepp.api.test;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.megvii.facepp.api.bean.Face;

/*
 * @auther:peanut
 * @finish time:2019.4.18
 * notation:人脸妆扮处理集
 */
public class FaceMakeUpUtils {
    //人脸关键部位上色：眉型效果
    public Bitmap eyebrowRendering(Bitmap bm, Face face){
        Bitmap bmp = bm.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bmp);
        //coding......
        return bmp;
    }
    //人脸关键部位勾勒：眉毛
    public Bitmap drawEyebrowPoint(Bitmap bm,Face face){
        Bitmap bmp = bm.copy(Bitmap.Config.ARGB_8888, true);
        //画布和笔
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);//笔色
        paint.setStrokeWidth(10);//笔宽
        //左眉毛点集
        float lpoints[] = {
                face.getLandmark().getLeft_eyebrow_left_corner().getX(),face.getLandmark().getLeft_eyebrow_left_corner().getY(),
                face.getLandmark().getLeft_eyebrow_upper_left_quarter().getX(),face.getLandmark().getLeft_eyebrow_upper_left_quarter().getY(),
                face.getLandmark().getLeft_eyebrow_upper_middle().getX(),face.getLandmark().getLeft_eyebrow_upper_middle().getY(),
                face.getLandmark().getLeft_eyebrow_upper_right_quarter().getX(),face.getLandmark().getLeft_eyebrow_upper_right_quarter().getY(),
                face.getLandmark().getLeft_eyebrow_upper_right_corner().getX(),face.getLandmark().getLeft_eyebrow_upper_right_corner().getY(),
                face.getLandmark().getLeft_eyebrow_lower_right_corner().getX(),face.getLandmark().getLeft_eyebrow_lower_right_corner().getY(),
                face.getLandmark().getLeft_eyebrow_lower_right_quarter().getX(),face.getLandmark().getLeft_eyebrow_lower_right_quarter().getY(),
                face.getLandmark().getLeft_eyebrow_lower_middle().getX(),face.getLandmark().getLeft_eyebrow_lower_middle().getY(),
                face.getLandmark().getLeft_eyebrow_lower_left_quarter().getX(),face.getLandmark().getLeft_eyebrow_lower_left_quarter().getY()
        };
        //右眉毛点集
        float rpoints[] = {
                face.getLandmark().getRight_eyebrow_right_corner().getX(),face.getLandmark().getRight_eyebrow_right_corner().getY(),
                face.getLandmark().getRight_eyebrow_upper_right_quarter().getX(),face.getLandmark().getRight_eyebrow_upper_right_quarter().getY(),
                face.getLandmark().getRight_eyebrow_upper_middle().getX(),face.getLandmark().getRight_eyebrow_upper_middle().getY(),
                face.getLandmark().getRight_eyebrow_upper_left_quarter().getX(),face.getLandmark().getRight_eyebrow_upper_left_quarter().getY(),
                face.getLandmark().getRight_eyebrow_upper_left_corner().getX(),face.getLandmark().getRight_eyebrow_upper_left_corner().getY(),
                face.getLandmark().getRight_eyebrow_lower_left_corner().getX(),face.getLandmark().getRight_eyebrow_lower_left_corner().getY(),
                face.getLandmark().getRight_eyebrow_lower_left_quarter().getX(),face.getLandmark().getRight_eyebrow_lower_left_quarter().getY(),
                face.getLandmark().getRight_eyebrow_lower_middle().getX(),face.getLandmark().getRight_eyebrow_lower_middle().getY(),
                face.getLandmark().getRight_eyebrow_lower_right_quarter().getX(),face.getLandmark().getRight_eyebrow_lower_right_quarter().getY()
        };
        //像素适应
        for (int i=0;i<17;i=i+2){
            lpoints[i] = (lpoints[i])*bm.getWidth()/960;
            lpoints[i+1] = (lpoints[i+1])*bm.getHeight()/960;
            rpoints[i] = (rpoints[i])*bm.getWidth()/960;
            rpoints[i+1] = (rpoints[i+1])*bm.getHeight()/960;
        }
        //描点
        canvas.drawPoints(lpoints,paint);
        canvas.drawPoints(rpoints,paint);
        //连线
        for(int i=0;i<15;i+=2){
            canvas.drawLine(lpoints[i],lpoints[i+1],lpoints[i+2],lpoints[i+3],paint);
            canvas.drawLine(rpoints[i],rpoints[i+1],rpoints[i+2],rpoints[i+3],paint);
        }
        canvas.drawLine(lpoints[0],lpoints[1],lpoints[16],lpoints[17],paint);
        canvas.drawLine(rpoints[0],rpoints[1],rpoints[16],rpoints[17],paint);
        return bmp;
    }
    //人脸关键部位上色：眼影效果
    public Bitmap eyeRendering(Bitmap bm, Face face){
        Bitmap bmp = bm.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bmp);
        //coding......
        return bmp;
    }
    //人脸关键部位勾勒：眼睛
    public Bitmap drawEyePoint(Bitmap bm,Face face){
        Bitmap bmp = bm.copy(Bitmap.Config.ARGB_8888, true);
        //画布和笔
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);//笔色
        paint.setStrokeWidth(10);//笔宽
        //左眼点集
        float lpoints[] = {
                face.getLandmark().getLeft_eye_left_corner().getX(),face.getLandmark().getLeft_eye_left_corner().getY(),
                face.getLandmark().getLeft_eye_upper_left_quarter().getX(),face.getLandmark().getLeft_eye_upper_left_quarter().getY(),
                face.getLandmark().getLeft_eye_top().getX(),face.getLandmark().getLeft_eye_top().getY(),
                face.getLandmark().getLeft_eye_upper_right_quarter().getX(),face.getLandmark().getLeft_eye_upper_right_quarter().getY(),
                face.getLandmark().getLeft_eye_right_corner().getX(),face.getLandmark().getLeft_eye_right_corner().getY(),
                face.getLandmark().getLeft_eye_lower_right_quarter().getX(),face.getLandmark().getLeft_eye_lower_right_quarter().getY(),
                face.getLandmark().getLeft_eye_bottom().getX(),face.getLandmark().getLeft_eye_bottom().getY(),
                face.getLandmark().getLeft_eye_lower_left_quarter().getX(),face.getLandmark().getLeft_eye_lower_left_quarter().getY()
        };
        //右眼点集
        float rpoints[] = {
                face.getLandmark().getRight_eye_left_corner().getX(),face.getLandmark().getRight_eye_left_corner().getY(),
                face.getLandmark().getRight_eye_upper_left_quarter().getX(),face.getLandmark().getRight_eye_upper_left_quarter().getY(),
                face.getLandmark().getRight_eye_top().getX(),face.getLandmark().getRight_eye_top().getY(),
                face.getLandmark().getRight_eye_upper_right_quarter().getX(),face.getLandmark().getRight_eye_upper_right_quarter().getY(),
                face.getLandmark().getRight_eye_right_corner().getX(),face.getLandmark().getRight_eye_right_corner().getY(),
                face.getLandmark().getRight_eye_lower_right_quarter().getX(),face.getLandmark().getRight_eye_lower_right_quarter().getY(),
                face.getLandmark().getRight_eye_bottom().getX(),face.getLandmark().getRight_eye_bottom().getY(),
                face.getLandmark().getRight_eye_lower_left_quarter().getX(),face.getLandmark().getRight_eye_lower_left_quarter().getY()
        };
        //像素适应
        for (int i=0;i<15;i=i+2){
            lpoints[i] = (lpoints[i])*bm.getWidth()/960;
            lpoints[i+1] = (lpoints[i+1])*bm.getHeight()/960;
            rpoints[i] = (rpoints[i])*bm.getWidth()/960;
            rpoints[i+1] = (rpoints[i+1])*bm.getHeight()/960;
        }
        //描点
        canvas.drawPoints(lpoints,paint);
        canvas.drawPoints(rpoints,paint);
        //连线
        for(int i=0;i<13;i+=2){
            canvas.drawLine(lpoints[i],lpoints[i+1],lpoints[i+2],lpoints[i+3],paint);
            canvas.drawLine(rpoints[i],rpoints[i+1],rpoints[i+2],rpoints[i+3],paint);
        }
        canvas.drawLine(lpoints[0],lpoints[1],lpoints[14],lpoints[15],paint);
        canvas.drawLine(rpoints[0],rpoints[1],rpoints[14],rpoints[15],paint);
        return bmp;
    }

    //人脸关键部位上色：口红效果
    public Bitmap mouthRendering(Bitmap bm, Face face){
        Bitmap bmp = bm.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(20);//笔宽
        //上色_上嘴唇
        Path patha = new Path();
        paint.setARGB(100,190,3,14);
        patha.moveTo(face.getLandmark().getMouth_left_corner().getX()*bm.getWidth()/960,face.getLandmark().getMouth_left_corner().getY()*bm.getHeight()/960);
        patha.lineTo(face.getLandmark().getMouth_upper_lip_left_contour2().getX()*bm.getWidth()/960,face.getLandmark().getMouth_upper_lip_left_contour2().getY()*bm.getHeight()/960);
        patha.lineTo(face.getLandmark().getMouth_upper_lip_left_contour1().getX()*bm.getWidth()/960,face.getLandmark().getMouth_upper_lip_left_contour1().getY()*bm.getHeight()/960);
        patha.lineTo(face.getLandmark().getMouth_upper_lip_top().getX()*bm.getWidth()/960,face.getLandmark().getMouth_upper_lip_top().getY()*bm.getHeight()/960);
        patha.lineTo(face.getLandmark().getMouth_upper_lip_right_contour1().getX()*bm.getWidth()/960,face.getLandmark().getMouth_upper_lip_right_contour1().getY()*bm.getHeight()/960);
        patha.lineTo(face.getLandmark().getMouth_upper_lip_right_contour2().getX()*bm.getWidth()/960,face.getLandmark().getMouth_upper_lip_right_contour2().getY()*bm.getHeight()/960);
        patha.lineTo(face.getLandmark().getMouth_right_corner().getX()*bm.getWidth()/960,face.getLandmark().getMouth_right_corner().getY()*bm.getHeight()/960);
        patha.lineTo(face.getLandmark().getMouth_upper_lip_right_contour3().getX()*bm.getWidth()/960,face.getLandmark().getMouth_upper_lip_right_contour3().getY()*bm.getHeight()/960);
        patha.lineTo(face.getLandmark().getMouth_upper_lip_bottom().getX()*bm.getWidth()/960,face.getLandmark().getMouth_upper_lip_bottom().getY()*bm.getHeight()/960);
        patha.lineTo(face.getLandmark().getMouth_upper_lip_left_contour3().getX()*bm.getWidth()/960,face.getLandmark().getMouth_upper_lip_left_contour3().getY()*bm.getHeight()/960);
        patha.close();
        canvas.drawPath(patha,paint);
        //下嘴唇
        Path pathb = new Path();
        pathb.moveTo(face.getLandmark().getMouth_left_corner().getX()*bm.getWidth()/960,face.getLandmark().getMouth_left_corner().getY()*bm.getHeight()/960);
        pathb.lineTo(face.getLandmark().getMouth_lower_lip_left_contour1().getX()*bm.getWidth()/960,face.getLandmark().getMouth_lower_lip_left_contour1().getY()*bm.getHeight()/960);
        pathb.lineTo(face.getLandmark().getMouth_lower_lip_top().getX()*bm.getWidth()/960,face.getLandmark().getMouth_lower_lip_top().getY()*bm.getHeight()/960);
        pathb.lineTo(face.getLandmark().getMouth_lower_lip_right_contour1().getX()*bm.getWidth()/960,face.getLandmark().getMouth_lower_lip_right_contour1().getY()*bm.getHeight()/960);
        pathb.lineTo(face.getLandmark().getMouth_right_corner().getX()*bm.getWidth()/960,face.getLandmark().getMouth_right_corner().getY()*bm.getHeight()/960);
        pathb.lineTo(face.getLandmark().getMouth_lower_lip_right_contour2().getX()*bm.getWidth()/960,face.getLandmark().getMouth_lower_lip_right_contour2().getY()*bm.getHeight()/960);
        pathb.lineTo( face.getLandmark().getMouth_lower_lip_right_contour3().getX()*bm.getWidth()/960,face.getLandmark().getMouth_lower_lip_right_contour3().getY()*bm.getHeight()/960);
        pathb.lineTo(face.getLandmark().getMouth_lower_lip_bottom().getX()*bm.getWidth()/960,face.getLandmark().getMouth_lower_lip_bottom().getY()*bm.getHeight()/960);
        pathb.lineTo(face.getLandmark().getMouth_lower_lip_left_contour3().getX()*bm.getWidth()/960,face.getLandmark().getMouth_lower_lip_left_contour3().getY()*bm.getHeight()/960);
        pathb.lineTo(face.getLandmark().getMouth_lower_lip_left_contour2().getX()*bm.getWidth()/960,face.getLandmark().getMouth_lower_lip_left_contour2().getY()*bm.getHeight()/960);
        pathb.close();
        canvas.drawPath(pathb,paint);
        return bmp;
    }
    //人脸关键部位勾勒：嘴唇
    public Bitmap drawMouthPoint(Bitmap bm,Face face){
        Bitmap bmp = bm.copy(Bitmap.Config.ARGB_8888, true);
        //画布和笔
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);//笔色
        paint.setStrokeWidth(20);//笔宽
        //取出人脸关键点的坐标数据
        float point[] = {
                face.getLandmark().getMouth_left_corner().getX(),face.getLandmark().getMouth_left_corner().getY(),
                face.getLandmark().getMouth_upper_lip_left_contour2().getX(),face.getLandmark().getMouth_upper_lip_left_contour2().getY(),
                face.getLandmark().getMouth_upper_lip_left_contour1().getX(),face.getLandmark().getMouth_upper_lip_left_contour1().getY(),
                face.getLandmark().getMouth_upper_lip_top().getX(),face.getLandmark().getMouth_upper_lip_top().getY(),
                face.getLandmark().getMouth_upper_lip_right_contour1().getX(),face.getLandmark().getMouth_upper_lip_right_contour1().getY(),
                face.getLandmark().getMouth_upper_lip_right_contour2().getX(),face.getLandmark().getMouth_upper_lip_right_contour2().getY(),
                face.getLandmark().getMouth_right_corner().getX(),face.getLandmark().getMouth_right_corner().getY(),
                face.getLandmark().getMouth_lower_lip_right_contour2().getX(),face.getLandmark().getMouth_lower_lip_right_contour2().getY(),
                face.getLandmark().getMouth_lower_lip_right_contour3().getX(),face.getLandmark().getMouth_lower_lip_right_contour3().getY(),
                face.getLandmark().getMouth_lower_lip_bottom().getX(),face.getLandmark().getMouth_lower_lip_bottom().getY(),
                face.getLandmark().getMouth_lower_lip_left_contour3().getX(),face.getLandmark().getMouth_lower_lip_left_contour3().getY(),
                face.getLandmark().getMouth_lower_lip_left_contour2().getX(),face.getLandmark().getMouth_lower_lip_left_contour2().getY(),
                face.getLandmark().getMouth_lower_lip_left_contour1().getX(),face.getLandmark().getMouth_lower_lip_left_contour1().getY(),
                face.getLandmark().getMouth_upper_lip_left_contour3().getX(),face.getLandmark().getMouth_upper_lip_left_contour3().getY(),
                face.getLandmark().getMouth_lower_lip_top().getX(),face.getLandmark().getMouth_lower_lip_top().getY(),
                face.getLandmark().getMouth_upper_lip_bottom().getX(),face.getLandmark().getMouth_upper_lip_bottom().getY(),
                face.getLandmark().getMouth_upper_lip_right_contour3().getX(),face.getLandmark().getMouth_upper_lip_right_contour3().getY(),
                face.getLandmark().getMouth_lower_lip_right_contour1().getX(),face.getLandmark().getMouth_lower_lip_right_contour1().getY(),
        };
        //根据像素进行Bitmap的大小适应
        for (int i=0;i<36;i=i+2){
            point[i] = (point[i])*bm.getWidth()/960;
            point[i+1] = (point[i+1])*bm.getHeight()/960;
            System.out.println(point[i]);
        }
        //描点
        canvas.drawPoints(point,paint);
        paint.setStrokeWidth(10);
        //连线
        for(int i=0;i<33;i+=2){
            if(i!=22)
                canvas.drawLine(point[i],point[i+1],point[i+2],point[i+3],paint);
        }
        canvas.drawLine(point[0],point[1],point[24],point[25],paint);
        canvas.drawLine(point[22],point[23],point[0],point[1],paint);
        canvas.drawLine(point[34],point[35],point[12],point[13],paint);
        return bmp;
    }
}
