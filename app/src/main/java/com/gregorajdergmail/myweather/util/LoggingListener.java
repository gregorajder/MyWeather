package com.gregorajdergmail.myweather.util;

import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;


public class LoggingListener<T, R> implements RequestListener<T, R> {

    @Override
    public boolean onException(Exception e, T model, Target<R> target, boolean isFirstResource) {
        Log.d("glide","Exception=" +e);
        Log.d("glide","T=" +model);
        Log.d("glide","Target<R>=" +target);
        Log.d("glide","isFirstResource=" +isFirstResource);
        return false;
    }

    @Override
    public boolean onResourceReady(R resource, T model, Target<R> target, boolean isFromMemoryCache, boolean isFirstResource) {
       Log.d("glide","resource=" +resource);
       Log.d("glide","model=" +model);
       Log.d("glide","target=" +target);
       Log.d("glide","isFromMemoryCache=" +isFromMemoryCache);
       Log.d("glide","isFirstResource=" +isFirstResource);
        return false;
    }
}