package hendrawd.autospacedigitedittext

import android.text.Editable
import android.text.TextWatcher

/**
 * @author hendrawd on 21/08/18
 */
class AutoSpaceAdderTextWatcher(var spaceChar: Char = ' ',
                                var autoSpaceEvery: Int = 4) : TextWatcher {

    override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) {}

    override fun beforeTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {}

    override fun afterTextChanged(editable: Editable) {
        if (!removeLastSpaceChar(editable)) {
            insertSpaceChar(editable)
        }
    }

    private fun insertSpaceChar(editable: Editable) {
        if (editable.isNotEmpty() && editable.length % (autoSpaceEvery + 1) == 0) {
            val lastIndex = editable.length - 1
            val spaceString = spaceChar.toString()
            editable.insert(lastIndex, spaceString)
        }
    }

    /**
     * @return Boolean indicating remove success or failed
     */
    private fun removeLastSpaceChar(editable: Editable): Boolean {
        if (editable.isNotEmpty()) {
            val lastIndex = editable.length - 1
            val lastChar = editable[lastIndex]
            if (spaceChar == lastChar) {
                editable.delete(lastIndex, editable.length)
                return true
            }
        }
        return false
    }
}