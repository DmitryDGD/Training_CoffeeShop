package android.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int numberOfCoffees = 1;
    int price = 5;
    String priceMessage;
    String newMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("numberOfCoffees", numberOfCoffees);
        outState.putInt("price", price);
        outState.putString("order", createOrderSummary(price));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        numberOfCoffees = savedInstanceState.getInt("numberOfCoffees");
        price = savedInstanceState.getInt("price");

        displayQuantity(numberOfCoffees);
       createOrderSummary(price);
    }

    /**
     * This method is called when the order button is clicked.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

    private void displayMessage2(String message) {
        TextView NewTextView2 = (TextView) findViewById(R.id.new_text_view);
        NewTextView2.setText(message);
        NewTextView2.setVisibility(View.VISIBLE);
    }

     /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText("$" + number);
    }


    public void increment(View view) {
        numberOfCoffees++;
        price = numberOfCoffees * 5;
        TextView NewTextView3 = (TextView) findViewById(R.id.new_text_view);
        NewTextView3.setVisibility(View.INVISIBLE);
        displayQuantity(numberOfCoffees);
        displayPrice(price);
    }

    public void decrement(View view) {
        if (numberOfCoffees > 1) { numberOfCoffees--; price = numberOfCoffees * 5;;} else {  }
        TextView NewTextView3 = (TextView) findViewById(R.id.new_text_view);
        NewTextView3.setVisibility(View.INVISIBLE);
        displayQuantity(numberOfCoffees);
        displayPrice(price);
    }

   private String createOrderSummary(int price) {
        return "Name: " + ((EditText)findViewById(R.id.editTextTextPersonName)).getText()
                + "\n" + "Add whipped cream? " + ((CheckBox)findViewById(R.id.whipped_cream_checkbox)).isChecked()
                + "\n" + "Add chocolate topping? " + ((CheckBox) findViewById(R.id.chocolate_topping_checkbox)).isChecked()
                + "\n" + "Total Item Count: " + numberOfCoffees + " coffees"
                + "\n" + "Price: " + "$" + price
                + "\n" + "Thank you!";
    }

    public void createOrderSummary(View view) {
        TextView order_summary_text_view = (TextView)findViewById(R.id.order_summary_text_view);
        order_summary_text_view.setText(createOrderSummary(price));
    }


}