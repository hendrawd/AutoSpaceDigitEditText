package hendrawd.autospacedigitedittext

import android.content.Context
import android.support.v7.appcompat.R
import android.support.v7.widget.AppCompatEditText
import android.text.InputType
import android.util.AttributeSet

/**
 * @author hendrawd on 21/08/18
 */
class AutoSpaceDigitEditText
@JvmOverloads constructor(
        context: Context,
        attributeSet: AttributeSet? = null,
        defStyleAttr: Int = R.attr.editTextStyle
) : AppCompatEditText(context, attributeSet, defStyleAttr) {

    var spaceChar = ' '
        set(value) {
            autoSpaceAdderTextWatcher.spaceChar = value
            allowDigitAndSpaceInputFilter.spaceChar = value
            field = value
        }
    var autoSpaceEvery = 4
        set(value) {
            autoSpaceAdderTextWatcher.autoSpaceEvery = value
            field = value
        }
    private val autoSpaceAdderTextWatcher = AutoSpaceAdderTextWatcher(spaceChar, autoSpaceEvery)
    private val allowDigitAndSpaceInputFilter = AllowDigitAndSpaceInputFilter(spaceChar)

    init {
        filters = arrayOf(allowDigitAndSpaceInputFilter)
        addTextChangedListener(autoSpaceAdderTextWatcher)
        inputType = InputType.TYPE_CLASS_DATETIME
    }
}