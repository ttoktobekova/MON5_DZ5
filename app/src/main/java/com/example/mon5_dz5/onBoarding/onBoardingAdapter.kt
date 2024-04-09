package com.example.mon5_dz5.onBoarding


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mon5_dz5.EXT.loadImg
import com.example.mon5_dz5.data.Pref
import com.example.mon5_dz5.databinding.ItemOnboardingBinding
import kotlin.reflect.KProperty0

class onBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<onBoardingAdapter.OnViewHolder>() {

    val list = arrayListOf(
        onBoardingModel("Название1", "Значение1", "https://i.pinimg.com/564x/a2/70/88/a27088ae2de11fb8ba532831f952a8c7.jpg"),
        onBoardingModel("Название2", "Значение2", "https://i.pinimg.com/564x/45/27/78/45277890077d4a6639c1948acc98df4d.jpg"),
        onBoardingModel("Название3", "Значение3", "https://i.pinimg.com/564x/e3/9d/b4/e39db4add53f298ca2d21fa7fbae2661.jpg"),
        onBoardingModel("Название4","Значение4","https://pfs-education.ru/wp-content/uploads/2021/01/Harvard-Online-Course.jpg")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnViewHolder {
        return OnViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoardingModel: onBoardingModel) {
            binding.apply {

                tvTitle.text = onBoardingModel.title
                tvDesc.text = onBoardingModel.desc

                tvSkip.isVisible = adapterPosition != list.lastIndex
                btnStarted.isVisible = adapterPosition == list.lastIndex
                //click
                btnStarted.setOnClickListener {
                    onClick() }
                tvSkip.setOnClickListener {
                    onClick() }
                //img
                imgBoard.loadImg(onBoardingModel.image.toString())
            }
        }
    }
}