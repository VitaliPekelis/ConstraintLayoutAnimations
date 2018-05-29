package com.lpirro.constraintlayoutanimations

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.animation.AnticipateOvershootInterpolator
import kotlinx.android.synthetic.main.activity_carusel_of_3_main.*

class CarouselOf3Activity : AppCompatActivity() {
  private var selectedView: View? = null
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_carusel_of_3_main)
    selectedView = null
    left.setOnClickListener {
      if (selectedView != left) {
        updateConstraints(R.layout.activity_carusel_of_3_left)
        selectedView = left
      } else {
        toDefault()
      }
    }
    middle.setOnClickListener {
      if (selectedView != middle) {
        updateConstraints(R.layout.activity_carusel_of_3_middle)
        selectedView = middle
      } else {
        toDefault()
      }
    }
    right.setOnClickListener {
      if (selectedView != right) {
        updateConstraints(R.layout.activity_carusel_of_3_right)
        selectedView = right
      } else {
        toDefault()
      }
    }

    root.setOnClickListener {
      toDefault()
    }
  }

  private fun toDefault() {
    if (selectedView != null) {
      updateConstraints(R.layout.activity_carusel_of_3_main)
      selectedView = null
    }
  }

  private fun updateConstraints(@LayoutRes id: Int)
  {
    val newConstraintSet = ConstraintSet()
    newConstraintSet.clone(this, id)
    newConstraintSet.applyTo(root)
    val transition = ChangeBounds()
    //transition.interpolator = OvershootInterpolator()
    transition.interpolator = AnticipateOvershootInterpolator(2.0f)
    transition.duration = 800
    TransitionManager.beginDelayedTransition(root, transition)
  }
}
