package com.example.pcwebshop;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private LinearLayout cartContainer;
    private TextView totalPriceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartContainer = findViewById(R.id.cartContainer);
        totalPriceText = findViewById(R.id.totalPriceText);

        loadCartItems();
    }

    private void loadCartItems() {
        List<Item> cartItems = CartManager.getInstance().getCartItems();
        cartContainer.removeAllViews();

        double total = 0;

        for (Item item : cartItems) {
            View itemView = getLayoutInflater().inflate(R.layout.cart_item_layout, null);

            ImageView itemImage = itemView.findViewById(R.id.itemImage);
            TextView itemName = itemView.findViewById(R.id.itemName);
            TextView itemPrice = itemView.findViewById(R.id.itemPrice);
            Button removeBtn = itemView.findViewById(R.id.removeButton);

            int imageRes = getResources().getIdentifier(item.getImageUrl(), "drawable", getPackageName());
            if (imageRes != 0) {
                itemImage.setImageResource(imageRes);
            }

            itemName.setText(item.getName());
            itemPrice.setText(item.getPrice() + " Ft");

            total += item.getPrice();

            removeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CartManager.getInstance().removeItem(item);
                    Toast.makeText(CartActivity.this, "Item removed from cart", Toast.LENGTH_SHORT).show();
                    loadCartItems();
                }
            });

            cartContainer.addView(itemView);
        }

        if (cartItems.isEmpty()) {
            TextView emptyText = new TextView(this);
            emptyText.setText("Your cart is empty");
            emptyText.setTextSize(18);
            emptyText.setPadding(16, 32, 16, 16);
            cartContainer.addView(emptyText);
        }

        totalPriceText.setText("Sum of items in your cart: " + total + " Ft");
    }
}
