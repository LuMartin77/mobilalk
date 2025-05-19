package com.example.pcwebshop;

import com.example.pcwebshop.CartManager;
import com.example.pcwebshop.Item;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class BrowseProductsActivity extends AppCompatActivity {

    private LinearLayout productsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_products);

        productsContainer = findViewById(R.id.productsContainer);

        List<Item> itemList = getSampleItems();

        for (Item item : itemList) {
            LinearLayout productLayout = new LinearLayout(this);
            productLayout.setOrientation(LinearLayout.HORIZONTAL);
            productLayout.setPadding(16, 16, 16, 16);
            productLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));

            ImageView productImage = new ImageView(this);
            int imageResId = getResources().getIdentifier(item.getImageUrl(), "drawable", getPackageName());
            productImage.setImageResource(imageResId);
            LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(200, 200);
            imgParams.setMargins(0, 0, 16, 0);
            productImage.setLayoutParams(imgParams);

            LinearLayout infoLayout = new LinearLayout(this);
            infoLayout.setOrientation(LinearLayout.VERTICAL);
            infoLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1f
            ));

            TextView productName = new TextView(this);
            productName.setText(item.getName());
            productName.setTextSize(18);
            productName.setTypeface(null, Typeface.BOLD);

            TextView productPrice = new TextView(this);
            productPrice.setText(String.format("%.0f Ft", item.getPrice()));
            productPrice.setTextSize(16);

            TextView productInfo = new TextView(this);
            productInfo.setText(item.getDescription());
            productName.setTextSize(16);

            infoLayout.addView(productName);
            infoLayout.addView(productPrice);
            infoLayout.addView(productInfo);

            Button addToCartBtn = new Button(this);
            addToCartBtn.setText("Add to cart");
            addToCartBtn.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));

            addToCartBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(BrowseProductsActivity.this,
                            item.getName() + " added to cart",
                            Toast.LENGTH_SHORT).show();
                    CartManager.getInstance().addToCart(item);
                }
            });

            productLayout.addView(productImage);
            productLayout.addView(infoLayout);
            productLayout.addView(addToCartBtn);

            productsContainer.addView(productLayout);
        }
    }

    private List<Item> getSampleItems() {
        List<Item> items = new ArrayList<>();

        items.add(new Item("1", "Mouse", "Comfy office mouse", 4990, 10, "eger", "periféria", "Black, 1600 DPI"));
        items.add(new Item("2", "RGB Keyboard", "lit up mechanical keyboard", 12990, 5, "keyboard", "periféria", "Red switch, RGB"));
        items.add(new Item("3", "Monitor", "24 inch full HD monitor", 49990, 3, "monitor", "kijelző", "IPS panel, 75Hz"));
        items.add(new Item("4", "RTX 5090", "Runs everything but catches on fire", 400000, 1, "gpu", "gpu", "32GB GDDR8, 8000Mhz"));

        return items;
    }
}
