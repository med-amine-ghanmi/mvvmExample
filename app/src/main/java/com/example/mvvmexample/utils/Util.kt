package com.example.mvvmexample.utils




class Util {

    companion object {

        var parentCategoryID = 0


        val subCategoryUrl = "categories?output_format=JSON&display=full&filter[id-parent]=$parentCategoryID&&ws_key=1EH5I3G9GN12RCL1MDT6WY6DWJSWBP29"

        fun roundDecimal(price: Double): String {
            return "%.2f".format(price).replace(",", ".")
        }

        fun convertToEnglishDigits(value: String): String {
            return value.replace("١", "1").replace("٢", "2").replace("٣", "3").replace("٤", "4").replace("٥", "5")
                    .replace("٦", "6").replace("٧", "7").replace("٨", "8").replace("٩", "9").replace("٠", "0")
                    .trim().replace("٫", ".")
            //"%.2f".format(newValue)
        }

    }
}


