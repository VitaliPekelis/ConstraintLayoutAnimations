package com.lpirro.constraintlayoutanimations

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.circuit.*

class CircuitActivity : AppCompatActivity() {

    private var show = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.circuit)

        backgroundImage.setOnClickListener {
            if(show)
                hideComponents() // if the animation is shown, we hide back the views
            else
                showComponents() // if the animation is NOT shown, we animate the views
        }

    }

    private fun showComponents(){
        show = true

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.circuit_detail)

        applyTransition(constraintSet) //here constraint is the name of view to which we are applying the constraintSet
    }

    private fun hideComponents(){
        show = false

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.circuit)

        applyTransition(constraintSet)  //here constraint is the name of view to which we are applying the constraintSet
    }

    private fun applyTransition(constraintSet : ConstraintSet)
    {
        val transition = ChangeBounds()
        //val transition = AutoTransition()
        //val transition = ChangeClipBounds()/*api 21*/
        //transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        //transition.interpolator = AnticipateInterpolator(1.2f)
        transition.interpolator = OvershootInterpolator()
        transition.duration = 1200
        //transition.duration = 1000

        TransitionManager.beginDelayedTransition(constraint, transition)
        constraintSet.applyTo(constraint)
    }
}
