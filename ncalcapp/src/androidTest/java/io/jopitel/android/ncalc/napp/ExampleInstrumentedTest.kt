package io.jopitel.android.ncalc.napp

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import io.jopitel.android.ncalc.ncore.hjCalc
import io.jopitel.android.ncalc.ncore.hjCalcEx
import io.jopitel.android.ncalc.nnative.hjCalcNative
import io.jopitel.android.ncalc.nwrap.hjCalcWrapMain
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
  val TAG = "[hjjo]"
  @Test
  fun useAppContext() {
    // Context of the app under test.
    val appContext = InstrumentationRegistry.getTargetContext()
    assertEquals("io.jopitel.android.ncalc.napp", appContext.packageName)

    test_ncalcnative()
    test_ncalccore()
    test_ncalcwrap()
  }

  fun test_ncalcnative() {
    var calc = hjCalcNative()
    Log.d(TAG, calc.stringFrom())
  }

  fun test_ncalccore() {
    val calc = hjCalc<Int>("magmajo", "hello", "world")
    assertEquals(calc.plus(2, 2).toLong(), 4)
    assertEquals(calc.minus(4, 2).toLong(), 2)
    assertEquals(calc.multiple(2, 2).toLong(), 4)
    assertEquals(calc.devide(4, 2).toLong(), 2)

    val calcEx = hjCalcEx<Int>("magmajo")
    assertEquals(calcEx.plus(2, 2).toLong(), 4)
    assertEquals(calcEx.minus(4, 2).toLong(), 2)
    assertEquals(calcEx.multiple(2, 2).toLong(), 4+2)
    assertEquals(calcEx.devide(4, 2).toLong(), 2)
    assertEquals(calcEx.sum(1, 2, 3, 4, 5), 15)
  }

  fun test_ncalcwrap() {
    hjCalcWrapMain.main(arrayOf("hello", "world"))
  }
}