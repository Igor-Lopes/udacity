package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int quantity;
    private boolean whippedCreamTopping;
    private boolean chocolateTopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity = 0;
        whippedCreamTopping = false;
        chocolateTopping = false;

    }

    public String getUserName() {
        EditText editText = (EditText) findViewById(R.id.edit_text);
        return editText.getText().toString();
    }

    public void setWhippedCreamTopping(View view) {
        whippedCreamTopping = (whippedCreamTopping) ? false : true;
    }

    public void setChocolateTopping(View view) {
        chocolateTopping = (chocolateTopping) ? false : true;
    }

    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity > 0)
            quantity--;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayPrice(createOrderSummary(calculatePrice()));
    }

    public int calculatePrice() {
        int unitPrice = 5;
        int whippedCreamPrice = (whippedCreamTopping) ? 1 : 0;
        int chocolatePrice = (chocolateTopping) ? 2 : 0;
        return (unitPrice + whippedCreamPrice + chocolatePrice) * quantity;
    }

    public String createOrderSummary(int price) {
        String userName = getUserName();
        String message = "Costumer: " + userName;
        if (whippedCreamTopping) {
            message += "\nAdd Whipped Cream Topping";
        }
        if (chocolateTopping) {
            message += "\nAdd Chocolate Topping";
        }
        message += "\nQuantity: " + quantity + "\nTotal: $" + price + "\nThank you !";
        return message;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */


    private void displayPrice(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order for " + getUserName());
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        //priceTextView.setText("Your Total: $" + NumberFormat.getCurrencyInstance().format(number));
    }
}