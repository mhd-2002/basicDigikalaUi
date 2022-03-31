package com.example.digikala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digikala.adaptor.amazing.AmazingAdapter
import com.example.digikala.adaptor.amazing.AmazingModel
import com.example.digikala.adaptor.category.CategoryAdapter
import com.example.digikala.adaptor.category.CategoryModel
import com.example.digikala.databinding.ActivityMainBinding

lateinit var blinding : ActivityMainBinding
lateinit var categoryAdapter: CategoryAdapter
lateinit var layoutManager: LinearLayoutManager
lateinit var amazingAdapter: AmazingAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        blinding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(blinding.root)
        initAmazing()
        slider()
        initCategory()


    }
    private fun slider(){

        val sliderItem = listOf(
            "https://dkstatics-public.digikala.com/digikala-products/3711756e9865f2c5a8e2d055225fc58d888d212f_1619606648.jpg?x-oss-process=image/resize,m_lfit,h_300,w_300/quality,q_80",
            "https://dkstatics-public.digikala.com/digikala-products/47e477e92721e12b67cb9b1929ed333d9dbbe065_1639315168.jpg?x-oss-process=image/resize,m_lfit,h_300,w_300/quality,q_80",
            "https://dkstatics-public.digikala.com/digikala-products/15d8c6c97fb05ef73bc13295c675e0c71f4d662c_1647114128.jpg?x-oss-process=image/resize,m_lfit,h_300,w_300/quality,q_80",
            "https://dkstatics-public.digikala.com/digikala-products/0bfd415bdd43c163aca3d729d56a8826d62a488b_1638959475.jpg?x-oss-process=image/resize,m_lfit,h_300,w_300/quality,q_80")

        blinding.slider.setItems(sliderItem)
        blinding.slider.addTimerToSlide(2000)

    }

    private fun initCategory(){
         val categoryList = ArrayList<CategoryModel>()

        for(i in 0..10) {
            categoryList.add(
                CategoryModel("https://dkstatics-public.digikala.com/digikala-products/15d8c6c97fb05ef73bc13295c675e0c71f4d662c_1647114128.jpg?x-oss-process=image/resize,m_lfit,h_300,w_300/quality,q_80", "دسته بندی $i")
            )
        }
    categoryAdapter = CategoryAdapter(this , categoryList)
    layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        blinding.rvCategory.layoutManager = layoutManager
        blinding.rvCategory.adapter= categoryAdapter
        categoryAdapter.notifyDataSetChanged()

    }

    private fun initAmazing() {
        val amazingList = ArrayList<AmazingModel>()

        for (i in 0..10){
            amazingList.add(
                AmazingModel(
                    "https://dkstatics-public.digikala.com/digikala-products/15d8c6c97fb05ef73bc13295c675e0c71f4d662c_1647114128.jpg?x-oss-process=image/resize,m_lfit,h_300,w_300/quality,q_80",
                    "کالای شماره $i",
                    "${i}0 %",
                    "3${i}0.000",
                    "3${i+1}0.000",
                    i+2
                )
            )
    }

        amazingAdapter = AmazingAdapter(this, amazingList)
        layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        blinding.rvAmazing.layoutManager = layoutManager
        blinding.rvAmazing.adapter = amazingAdapter
        amazingAdapter.notifyDataSetChanged()

    }
}