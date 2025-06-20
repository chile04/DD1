package com.example.lethilinhchi_2122110399;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;

    // Constructor
    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    // Tạo ViewHolder từ layout item_product.xml
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    // Gán dữ liệu vào các View trong mỗi item
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product p = productList.get(position);
        holder.txtProductName.setText(p.getName());
        holder.txtProductPrice.setText(p.getPrice() + "đ");
        holder.imgProduct.setImageResource(p.getImageResId());
    }

    // Trả về số lượng sản phẩm
    @Override
    public int getItemCount() {
        return productList.size();
    }

    // ViewHolder để ánh xạ View
    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView txtProductName, txtProductPrice;
        ImageView imgProduct;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtProductName = itemView.findViewById(R.id.txtProductName);
            txtProductPrice = itemView.findViewById(R.id.txtProductPrice);
            imgProduct = itemView.findViewById(R.id.imgProduct);
        }
    }
}
