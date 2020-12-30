package com.example.mvvmexample.ui.first.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.mvvmexample.R
import com.example.mvvmexample.data.model.Product
import com.example.mvvmexample.databinding.ItemProductBinding
import com.example.mvvmexample.utils.Constants.Companion.API_KEY
import com.example.mvvmexample.utils.Constants.Companion.API_URL
import com.example.mvvmexample.utils.Constants.Companion.BASE_URL
import com.example.mvvmexample.utils.Util
import com.example.mvvmexample.utils.Util.Companion.convertToEnglishDigits
import okhttp3.internal.notify
import kotlin.collections.ArrayList

class ProductAdapter(private val productList: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int = productList.size


    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        holder.bindItems(product)
    }

    fun updateList(arrayList: ArrayList<Product>) {

        productList.clear()
        productList.addAll(arrayList)
        notifyDataSetChanged()

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageProduct = itemView.findViewById(R.id.product_image_view) as ImageView
        val nameProduct = itemView.findViewById(R.id.name_product) as TextView
        val priceProduct = itemView.findViewById(R.id.price) as TextView
        val condition = itemView.findViewById(R.id.condition) as TextView
        val onSale = itemView.findViewById(R.id.on_sale) as TextView
        val specificPrice = itemView.findViewById(R.id.specific_price) as TextView
        val oldPriceUnit = itemView.findViewById(R.id.firstPriceUnit) as TextView

        val productRowTopContainer =
            itemView?.findViewById(R.id.productRowTopPartContainer) as ConstraintLayout

        val firstPriceUnitTxt = itemView.findViewById(R.id.firstPriceUnit) as TextView
        val priceUnitTxt = itemView.findViewById(R.id.unit) as TextView


        val progress = itemView.findViewById(R.id.progress) as ProgressBar

        fun bindItems(product: Product) =
            with(itemView) {


                priceProduct.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                oldPriceUnit.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

                val priceTxt = convertToEnglishDigits(Util.roundDecimal(product.price!!.toDouble()))
                specificPrice.text = priceTxt
                priceProduct.text = priceTxt

                if (specificPrice.text == priceProduct.text) {
                    oldPriceUnit.visibility = View.INVISIBLE
                    priceProduct.visibility = View.INVISIBLE
                }


                product.condition?.let {
                    condition.text = product.condition
                } ?: kotlin.run {
                    condition.visibility = View.GONE
                }


                val imageUrl =
                    "${API_URL}images/products/${product.id}/${product.idDefaultImage}/medium_default?ws_key=$API_KEY"

                if (imageUrl.isNotEmpty()) {

                    Glide.with(itemView.context)
                        .load(imageUrl)

                        .listener(object : RequestListener<Drawable> {
                            override fun onLoadFailed(
                                e: GlideException?,
                                model: Any?,
                                target: Target<Drawable>?,
                                isFirstResource: Boolean
                            ): Boolean {
                                progress.visibility = View.VISIBLE
                                return false
                            }

                            override fun onResourceReady(
                                resource: Drawable?,
                                model: Any?,
                                target: Target<Drawable>?,
                                dataSource: DataSource?,
                                isFirstResource: Boolean
                            ): Boolean {
                                progress.visibility = View.GONE
                                return false
                            }
                        })
                        .into(imageProduct)
                }


            }


    }

}



