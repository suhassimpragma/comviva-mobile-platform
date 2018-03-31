package com.simpragma.comvivamobileplatform.util;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simpragma.comvivamobileplatform.model.Property;
import com.simpragma.comvivamobileplatform.model.Screen;
import com.simpragma.comvivamobileplatform.model.Style;
import com.simpragma.comvivamobileplatform.model.UiElement;

import static com.simpragma.comvivamobileplatform.AppConstants.INPUT_TYPE_NUMBER;
import static com.simpragma.comvivamobileplatform.AppConstants.INPUT_TYPE_PASSWORD;
import static com.simpragma.comvivamobileplatform.AppConstants.LAYOUT;
import static com.simpragma.comvivamobileplatform.AppConstants.WIDGET_BUTTON;
import static com.simpragma.comvivamobileplatform.AppConstants.WIDGET_EDIT_TEXT;
import static com.simpragma.comvivamobileplatform.AppConstants.WIDGET_TEXT_VIEW;

/**
 * Util class that contains helper methods to build UI based on {@link Style} and {@link Screen} classes
 */
public class ViewBuilderUtils {

    /**
     * Adds views to {@link LinearLayout}
     *
     * @param screen       {@link Screen}
     * @param style        {@link Style}
     * @param linearLayout {@link LinearLayout} for which the views will be added to
     * @param context      {@link Context}
     */
    public static void addViewsToLayout(Screen screen, Style style, LinearLayout linearLayout, Context context) {
        if (null != screen.getUiElements()) {
            for (UiElement uiElement : screen.getUiElements()) {
                TextView view;
                if (null != uiElement.getType()) {
                    switch (uiElement.getType()) {
                        case WIDGET_EDIT_TEXT:
                            view = new EditText(context);
                            addViewToLayout(uiElement, style, linearLayout, view);
                            break;
                        case WIDGET_BUTTON:
                            view = new Button(context);
                            addViewToLayout(uiElement, style, linearLayout, view);
                            break;
                        case WIDGET_TEXT_VIEW:
                            view = new TextView(context);
                            addViewToLayout(uiElement, style, linearLayout, view);
                            break;
                    }
                } else {
                    view = new TextView(context);
                    addViewToLayout(uiElement, style, linearLayout, view);
                }
            }
        }
    }

    /**
     * Adds a single view to {@link LinearLayout}
     *
     * @param uiElement    {@link UiElement}
     * @param style        {@link Style}
     * @param linearLayout {@link LinearLayout} for which the view will be added to
     * @param view         {@link TextView}
     */
    public static void addViewToLayout(UiElement uiElement, Style style, LinearLayout linearLayout, TextView view) {
        view.setId(uiElement.getId());
        view.setText(uiElement.getText());
        view.setHint(uiElement.getHint());
        if (null != uiElement.getInputType() && uiElement.getInputType().equalsIgnoreCase(INPUT_TYPE_NUMBER)) {
            view.setInputType(InputType.TYPE_CLASS_NUMBER);
        } else if (null != uiElement.getInputType() && uiElement.getInputType().equalsIgnoreCase(INPUT_TYPE_PASSWORD)) {
            view.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        } else {
            view.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        linearLayout.addView(view);
        applyViewStyle(style, view, uiElement.getType());
    }

    /**
     * Applies UI styles to {@link LinearLayout}
     *
     * @param style        {@link Style}
     * @param linearLayout {@link LinearLayout} for which the styles will be added to
     */
    public static void applyLayoutStyle(Style style, LinearLayout linearLayout) {
        for (Property property : style.getProperties()) {
            if (property.getType().equalsIgnoreCase(LAYOUT)) {
                if (null != property.getBackground()) {
                    linearLayout.setBackgroundColor(Color.parseColor(property.getBackground()));
                }
                linearLayout.setPadding(property.getPadding(), property.getPadding(), property.getPadding(),
                        property.getPadding());
                break;
            }
        }
    }

    /**
     * Applies UI styles to {@link TextView}
     *
     * @param style      {@link Style} to be applied to {@link TextView}
     * @param view       {@link TextView}
     * @param widgetType the type of widget style that needs to be added to {@link TextView}
     */
    public static void applyViewStyle(Style style, TextView view, String widgetType) {
        for (Property property : style.getProperties()) {
            if (property.getType().equalsIgnoreCase(widgetType) && null != property.getBackground()) {
                view.setBackgroundColor(Color.parseColor(property.getBackground()));
                break;
            }
        }
    }
}