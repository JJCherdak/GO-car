package com.geekbrains.go_car

import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import com.geekbrains.go_car.databinding.FragmentMainBinding
import java.util.zip.GZIPOutputStream

class Presenter (private val binding: FragmentMainBinding) {
    fun pressUp() {
        binding.up.setOnClickListener {
            rotation(Go.UP)
            binding.car.animate()
                .translationYBy(-MOVE_DISTANCE)
                .setDuration(MOVE_DURATION)
                .setInterpolator(LinearInterpolator())
                .start()
        }
    }

    fun pressLeft() {
        binding.left.setOnClickListener {
            rotation(Go.LEFT)
            binding.car.animate()
                .translationXBy(-MOVE_DISTANCE)
                .setDuration(MOVE_DURATION)
                .setInterpolator(LinearInterpolator())
                .start()
        }
    }

    fun pressDown() {
        binding.down.setOnClickListener {
            rotation(Go.DOWN)
            binding.car.animate()
                .translationXBy(MOVE_DISTANCE)
                .setDuration(MOVE_DURATION)
                .setInterpolator(LinearInterpolator())
                .start()
        }
    }

    fun pressRight() {
        binding.right.setOnClickListener {
            rotation(Go.RIGHT)
            binding.car.animate()
                .translationXBy(MOVE_DISTANCE)
                .setDuration(MOVE_DURATION)
                .setInterpolator(LinearInterpolator())
                .start()
        }
    }

    private fun rotation(way: Go) {
        binding.Go.animate()
            .rotation(
                when (way) {
                    Go.UP -> 180f
                    Go.LEFT -> 90f
                    Go.DOWN -> 0f
                    Go.RIGHT -> 270f
                }
            )
            .setDuration(500)
            .setInterpolator(OvershootInterpolator())
            .start()
    }

    companion object {
        const val MOVE_DURATION = 1000L
        const val MOVE_DISTANCE = 200f
    }
}