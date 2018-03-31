package com.simpragma.comvivamobileplatform.util;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simpragma.comvivamobileplatform.LoginActivity;
import com.simpragma.comvivamobileplatform.model.Property;
import com.simpragma.comvivamobileplatform.model.Screen;
import com.simpragma.comvivamobileplatform.model.Style;
import com.simpragma.comvivamobileplatform.model.UiElement;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;
import java.util.List;

import static com.simpragma.comvivamobileplatform.AppConstants.INPUT_TYPE_PASSWORD;
import static com.simpragma.comvivamobileplatform.AppConstants.LAYOUT;
import static com.simpragma.comvivamobileplatform.AppConstants.WIDGET_BUTTON;
import static com.simpragma.comvivamobileplatform.AppConstants.WIDGET_EDIT_TEXT;
import static com.simpragma.comvivamobileplatform.AppConstants.WIDGET_TEXT_VIEW;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(RobolectricTestRunner.class)
public class ViewBuilderUtilsTest {

    private LoginActivity activity;
    private LinearLayout.LayoutParams layoutParams;
    private LinearLayout linearLayout;
    private Style style;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(LoginActivity.class);
        layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout = new LinearLayout(activity);

        Property property = new Property();
        property.setPadding(10);
        property.setType(LAYOUT);

        List<Property> properties = new ArrayList<>();
        properties.add(property);

        style = new Style();
        style.setProperties(properties);
    }

    @Test
    public void applyLayoutStyle_isPaddingApplied() throws Exception {
        Property property = new Property();
        property.setPadding(10);
        property.setType(LAYOUT);

        List<Property> properties = new ArrayList<>();
        properties.add(property);

        Style style = new Style();
        style.setProperties(properties);

        ViewBuilderUtils.applyLayoutStyle(style, linearLayout);

        assertEquals(property.getPadding(), linearLayout.getPaddingLeft());
        assertEquals(property.getPadding(), linearLayout.getPaddingTop());
        assertEquals(property.getPadding(), linearLayout.getPaddingRight());
        assertEquals(property.getPadding(), linearLayout.getPaddingBottom());
    }

    @Test
    public void addViewsToLayout_isEditTextAdded() throws Exception {
        Screen loginScreen = new Screen();

        UiElement uiElement1 = new UiElement();
        uiElement1.setHint("Enter username");
        uiElement1.setText("Suhas");
        uiElement1.setId(100);
        uiElement1.setSlNo(1);
        uiElement1.setType(WIDGET_EDIT_TEXT);

        UiElement uiElement2 = new UiElement();
        uiElement2.setHint("Enter password");
        uiElement2.setText("Password");
        uiElement2.setId(101);
        uiElement2.setSlNo(2);
        uiElement2.setInputType(INPUT_TYPE_PASSWORD);
        uiElement2.setType(WIDGET_EDIT_TEXT);

        List<UiElement> uiElements = new ArrayList<>();
        uiElements.add(uiElement1);
        uiElements.add(uiElement2);
        loginScreen.setUiElements(uiElements);

        ViewBuilderUtils.addViewsToLayout(loginScreen, style, linearLayout, activity);

        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View view = linearLayout.getChildAt(i);
            assertThat(view, is(instanceOf(EditText.class)));

            EditText editText = ((EditText) view);
            UiElement uiElement = view.getId() == uiElement1.getId() ? uiElement1 : uiElement2;
            assertEquals("EditText text value should match", editText.getText().toString(), uiElement.getText());
            assertEquals("EditText hint value should match", editText.getHint().toString(), uiElement.getHint());
        }
    }

    @Test
    public void addViewsToLayout_addEditTextWhenTextAndHintAreNull() throws Exception {
        Screen loginScreen = new Screen();

        UiElement uiElement = new UiElement();
        uiElement.setId(101);
        uiElement.setSlNo(2);
        uiElement.setInputType(INPUT_TYPE_PASSWORD);
        uiElement.setType(WIDGET_EDIT_TEXT);

        List<UiElement> uiElements = new ArrayList<>();
        uiElements.add(uiElement);
        loginScreen.setUiElements(uiElements);

        ViewBuilderUtils.addViewsToLayout(loginScreen, style, linearLayout, activity);

        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View view = linearLayout.getChildAt(i);
            assertThat(view, is(instanceOf(EditText.class)));

            EditText editText = ((EditText) view);
            assertEquals("EditText text value should be null", editText.getText().toString(), "");
            assertNull("EditText hint value should be null", editText.getHint());
        }
    }

    @Test
    public void addViewsToLayout_isButtonAdded() throws Exception {
        Screen loginScreen = new Screen();

        UiElement uiElement1 = new UiElement();
        uiElement1.setText("Submit");
        uiElement1.setId(100);
        uiElement1.setSlNo(1);
        uiElement1.setType(WIDGET_BUTTON);

        List<UiElement> uiElements = new ArrayList<>();
        uiElements.add(uiElement1);
        loginScreen.setUiElements(uiElements);

        ViewBuilderUtils.addViewsToLayout(loginScreen, style, linearLayout, activity);

        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View view = linearLayout.getChildAt(i);
            assertThat(view, is(instanceOf(Button.class)));

            Button button = ((Button) view);
            assertEquals("Button IDs should match", button.getId(), uiElement1.getId());
            assertEquals("Button text should match", button.getText().toString(), uiElement1.getText());
        }
    }

    @Test
    public void addViewsToLayout_isTextViewAdded() throws Exception {
        Screen loginScreen = new Screen();

        UiElement uiElement1 = new UiElement();
        uiElement1.setText("Login");
        uiElement1.setId(100);
        uiElement1.setSlNo(1);
        uiElement1.setType(WIDGET_TEXT_VIEW);

        List<UiElement> uiElements = new ArrayList<>();
        uiElements.add(uiElement1);
        loginScreen.setUiElements(uiElements);

        ViewBuilderUtils.addViewsToLayout(loginScreen, style, linearLayout, activity);

        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View view = linearLayout.getChildAt(i);
            assertThat(view, is(instanceOf(TextView.class)));

            TextView textView = ((TextView) view);
            assertEquals("TextView IDs should match", textView.getId(), uiElement1.getId());
            assertEquals("TextView text value should match", textView.getText().toString(),
                    uiElement1.getText());
        }
    }

    @Test
    public void addViewsToLayout_isTextViewAddedWhenNoTypeIsMentioned() throws Exception {
        Screen loginScreen = new Screen();

        UiElement uiElement1 = new UiElement();
        uiElement1.setText("Login");
        uiElement1.setId(100);
        uiElement1.setSlNo(1);
        uiElement1.setType(WIDGET_TEXT_VIEW);

        List<UiElement> uiElements = new ArrayList<>();
        uiElements.add(uiElement1);
        loginScreen.setUiElements(uiElements);

        ViewBuilderUtils.addViewsToLayout(loginScreen, style, linearLayout, activity);

        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View view = linearLayout.getChildAt(i);
            assertThat(view, is(instanceOf(TextView.class)));

            TextView textView = ((TextView) view);
            assertEquals("TextView IDs should match", textView.getId(), uiElement1.getId());
            assertEquals("TextView text value should match", textView.getText().toString(),
                    uiElement1.getText());
        }
    }

    @Test
    public void addViewsToLayout_isMultipleWidgetsAdded() throws Exception {
        Screen loginScreen = new Screen();

        UiElement uiElement1 = new UiElement();
        uiElement1.setText("Login");
        uiElement1.setId(100);
        uiElement1.setSlNo(1);
        uiElement1.setType(WIDGET_TEXT_VIEW);

        UiElement uiElement2 = new UiElement();
        uiElement2.setText("Submit");
        uiElement2.setId(101);
        uiElement2.setSlNo(2);
        uiElement2.setType(WIDGET_BUTTON);

        UiElement uiElement3 = new UiElement();
        uiElement3.setHint("Enter username");
        uiElement3.setText("Suhas");
        uiElement3.setId(102);
        uiElement3.setSlNo(3);
        uiElement3.setType(WIDGET_EDIT_TEXT);

        List<UiElement> uiElements = new ArrayList<>();
        uiElements.add(uiElement1);
        uiElements.add(uiElement2);
        uiElements.add(uiElement3);
        loginScreen.setUiElements(uiElements);

        ViewBuilderUtils.addViewsToLayout(loginScreen, style, linearLayout, activity);

        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            assertThat(linearLayout.getChildAt(i), anyOf(instanceOf(TextView.class), instanceOf(Button.class),
                    instanceOf(EditText.class)));

            View view = linearLayout.getChildAt(i);
            if (view instanceof Button) {
                Button button = ((Button) view);
                assertEquals("Button IDs should match", button.getId(), uiElement2.getId());
                assertEquals("Button text should match", button.getText().toString(), uiElement2.getText());
            } else if (view instanceof EditText) {
                EditText editText = (EditText) view;
                assertEquals("EditText IDs should match", editText.getId(), uiElement3.getId());
                assertEquals("EditText text value should match", editText.getText().toString(),
                        uiElement3.getText());
                assertEquals("EditText hint value should match", editText.getHint().toString(),
                        uiElement3.getHint());
            } else if (view instanceof TextView) {
                TextView textView = ((TextView) view);
                assertEquals("TextView IDs should match", textView.getId(), uiElement1.getId());
                assertEquals("TextView text value should match", textView.getText().toString(),
                        uiElement1.getText());
            }
        }
    }
}