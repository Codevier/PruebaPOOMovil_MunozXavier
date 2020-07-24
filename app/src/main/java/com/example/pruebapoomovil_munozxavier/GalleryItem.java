package com.example.pruebapoomovil_munozxavier;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.mindorks.placeholderview.Animation;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.squareup.picasso.Picasso;

@Animate(Animation.CARD_LEFT_IN_DESC)
@NonReusable
@Layout(R.layout.gallery_item)
public class GalleryItem {

    @View(R.id.imageView)
    private ImageView imageView;

    private Drawable mDrawable;

    public GalleryItem(String url) {
        //Picasso.with(context).load("http://example.com/image.jpg").into(imageView);
        //Drawable myDrawable = imageView.getDrawable();
        Picasso.get().load("http://www.geognos.com/api/en/countries/flag/"+url+".png").into(imageView);
        //mDrawable = drawable;
    }

    @Resolve
    private void onResolved() {
        imageView.setImageDrawable(mDrawable);
    }
}