package com.geekbrains.go_car

import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import com.geekbrains.go_car.databinding.FragmentMainBinding
import kotlin.system.exitProcess

class Presenter (private val binding: FragmentMainBinding) {
    fun pressUp() {
        rotation(Go.UP)
        binding.pacman.animate()
            .translationYBy(-MOVE_DISTANCE)
            .setDuration(MOVE_DURATION)
            .setInterpolator(LinearInterpolator())
            .start()
    }

    fun pressLeft() {
        rotation(Go.LEFT)
        binding.pacman.animate()
            .translationXBy(-MOVE_DISTANCE)
            .setDuration(MOVE_DURATION)
            .setInterpolator(LinearInterpolator())
            .start()
    }

    fun pressDown() {
        rotation(Go.DOWN)
        binding.pacman.animate()
            .translationYBy(MOVE_DISTANCE)
            .setDuration(MOVE_DURATION)
            .setInterpolator(LinearInterpolator())
            .start()
    }

    fun pressRight() {
        rotation(Go.RIGHT)
        binding.pacman.animate()
            .translationXBy(MOVE_DISTANCE)
            .setDuration(MOVE_DURATION)
            .setInterpolator(LinearInterpolator())
            .start()
    }

    private fun rotation(go: Go) {
        binding.pacman.animate()
            .rotation(
                when (go) {
                    Go.UP -> 270f
                    Go.LEFT -> 180f
                    Go.DOWN -> 90f
                    Go.RIGHT -> 0f
                }
            )
            .setDuration(10)
            .setInterpolator(OvershootInterpolator())
            .start()
    }

    fun exit() {
        exitProcess(0)
    }

    companion object {
        const val MOVE_DURATION = 1000L
        const val MOVE_DISTANCE = 300f
    }
}