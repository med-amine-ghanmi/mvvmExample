package com.example.mvvmexample.data.model


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("active")
    val active: String?,
    @SerializedName("additional_delivery_times")
    val additionalDeliveryTimes: String?,
    @SerializedName("additional_shipping_cost")
    val additionalShippingCost: String?,
    @SerializedName("advanced_stock_management")
    val advancedStockManagement: String?,
    @SerializedName("associations")
    val associations: Associations?,
    @SerializedName("available_date")
    val availableDate: String?,
    @SerializedName("available_for_order")
    val availableForOrder: String?,
    @SerializedName("available_later")
    val availableLater: List<AvailableLater>?,
    @SerializedName("available_now")
    val availableNow: List<AvailableNow>?,
    @SerializedName("cache_default_attribute")
    val cacheDefaultAttribute: String?,
    @SerializedName("cache_has_attachments")
    val cacheHasAttachments: String?,
    @SerializedName("cache_is_pack")
    val cacheIsPack: String?,
    @SerializedName("condition")
    val condition: String?,
    @SerializedName("customizable")
    val customizable: String?,
    @SerializedName("date_add")
    val dateAdd: String?,
    @SerializedName("date_upd")
    val dateUpd: String?,
    @SerializedName("delivery_in_stock")
    val deliveryInStock: List<DeliveryInStock>?,
    @SerializedName("delivery_out_stock")
    val deliveryOutStock: List<DeliveryOutStock>?,
    @SerializedName("depth")
    val depth: String?,
    @SerializedName("description")
    val description: List<Description>?,
    @SerializedName("description_short")
    val descriptionShort: List<DescriptionShort>?,
    @SerializedName("ean13")
    val ean13: String?,
    @SerializedName("ecotax")
    val ecotax: String?,
    @SerializedName("height")
    val height: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("id_category_default")
    val idCategoryDefault: String?,
    @SerializedName("id_default_combination")
    val idDefaultCombination: Int?,
    @SerializedName("id_default_image")
    val idDefaultImage: String?,
    @SerializedName("id_manufacturer")
    val idManufacturer: String?,
    @SerializedName("id_shop_default")
    val idShopDefault: String?,
    @SerializedName("id_supplier")
    val idSupplier: String?,
    @SerializedName("id_tax_rules_group")
    val idTaxRulesGroup: String?,
    @SerializedName("id_type_redirected")
    val idTypeRedirected: String?,
    @SerializedName("indexed")
    val indexed: String?,
    @SerializedName("is_virtual")
    val isVirtual: String?,
    @SerializedName("isbn")
    val isbn: String?,
    @SerializedName("link_rewrite")
    val linkRewrite: List<LinkRewrite>?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("low_stock_alert")
    val lowStockAlert: String?,
    @SerializedName("low_stock_threshold")
    val lowStockThreshold: Any?,
    @SerializedName("manufacturer_name")
    val manufacturerName: Boolean?,
    @SerializedName("meta_description")
    val metaDescription: List<MetaDescription>?,
    @SerializedName("meta_keywords")
    val metaKeywords: List<MetaKeyword>?,
    @SerializedName("meta_title")
    val metaTitle: List<MetaTitle>?,
    @SerializedName("minimal_quantity")
    val minimalQuantity: String?,
    @SerializedName("name")
    val name: List<Name>?,
    @SerializedName("new")
    val new: Any?,
    @SerializedName("on_sale")
    val onSale: String?,
    @SerializedName("online_only")
    val onlineOnly: String?,
    @SerializedName("pack_stock_type")
    val packStockType: String?,
    @SerializedName("position_in_category")
    val positionInCategory: String?,
    @SerializedName("price")
    val price: String?,
    @SerializedName("quantity")
    val quantity: String?,
    @SerializedName("quantity_discount")
    val quantityDiscount: String?,
    @SerializedName("redirect_type")
    val redirectType: String?,
    @SerializedName("reference")
    val reference: String?,
    @SerializedName("show_condition")
    val showCondition: String?,
    @SerializedName("show_price")
    val showPrice: String?,
    @SerializedName("state")
    val state: String?,
    @SerializedName("supplier_reference")
    val supplierReference: String?,
    @SerializedName("text_fields")
    val textFields: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("unit_price_ratio")
    val unitPriceRatio: String?,
    @SerializedName("unity")
    val unity: String?,
    @SerializedName("upc")
    val upc: String?,
    @SerializedName("uploadable_files")
    val uploadableFiles: String?,
    @SerializedName("visibility")
    val visibility: String?,
    @SerializedName("weight")
    val weight: String?,
    @SerializedName("wholesale_price")
    val wholesalePrice: String?,
    @SerializedName("width")
    val width: String?
)