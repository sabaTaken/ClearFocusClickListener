import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class ClearFocusClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        ViewParent parent = view.getParent();
        ViewGroup group = null;
        View child = null;
        while (parent != null) {
            if (parent instanceof ViewGroup) {
                group = (ViewGroup) parent;
                for (int i = 0; i < group.getChildCount(); i++) {
                    child = group.getChildAt(i);
                    if (child != view && child.isFocusable()) {
                        child.requestFocus();
                        break;
                    }
                }
            }
            parent = parent.getParent();
        }

        new Handler().postDelayed(view::requestFocus, 300);
    }
}
