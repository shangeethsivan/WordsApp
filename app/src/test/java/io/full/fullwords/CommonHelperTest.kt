package io.full.fullwords

import android.text.TextUtils
import io.full.fullwords.helper.CommonHelper
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


@RunWith(PowerMockRunner::class)
@PrepareForTest(CommonHelper::class, TextUtils::class)
class CommonHelperTest {

    @Before
    fun setUp() {
        PowerMockito.mockStatic(TextUtils::class.java)
    }

    @Test
    fun isVaildEmailTest_invalidEmail() {
        `when`(TextUtils.isEmpty("")).thenReturn(true)
        assertEquals(false, CommonHelper().validateEmail(""))
    }

    @Test
    fun isVaildEmailTest_validEmail() {
        `when`(TextUtils.isEmpty("")).thenReturn(false)
        assertEquals(true, CommonHelper().validateEmail("test@test.com"))
    }

    @Test
    fun isVaildEmailTest_inValidEmail_2() {
        `when`(TextUtils.isEmpty("")).thenReturn(false)
        assertEquals(false, CommonHelper().validateEmail("testtest.com"))
    }

    @Test
    fun isVaildEmailTest_inValidEmail_3() {
        `when`(TextUtils.isEmpty("")).thenReturn(false)
        assertEquals(false, CommonHelper().validateEmail("test@test"))
    }
}
