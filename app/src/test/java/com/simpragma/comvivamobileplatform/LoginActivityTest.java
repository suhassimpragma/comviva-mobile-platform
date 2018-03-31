package com.simpragma.comvivamobileplatform;

import android.widget.LinearLayout;

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
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

@RunWith(RobolectricTestRunner.class)
public class LoginActivityTest extends LoginActivity {

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
    public void setViewsForActivity_allViewsAreCorrectlyAdded() throws Exception {
        Screen loginScreen = new Screen();

        UiElement username = new UiElement();
        username.setHint("Enter username");
        username.setId(100);
        username.setSlNo(1);
        username.setType(WIDGET_EDIT_TEXT);

        UiElement password = new UiElement();
        password.setHint("Enter password");
        password.setId(101);
        password.setSlNo(2);
        password.setInputType(INPUT_TYPE_PASSWORD);
        password.setType(WIDGET_EDIT_TEXT);

        UiElement submitButton = new UiElement();
        submitButton.setText("Submit");
        submitButton.setId(100);
        submitButton.setSlNo(1);
        submitButton.setType(WIDGET_BUTTON);

        List<UiElement> uiElements = new ArrayList<>();
        uiElements.add(username);
        uiElements.add(password);
        loginScreen.setUiElements(uiElements);

        activity.setViewsForActivity(style, loginScreen, linearLayout, layoutParams, activity);
        assertNotNull(activity.findViewById(username.getId()));
        assertNotNull(activity.findViewById(password.getId()));
        assertNotNull(activity.findViewById(submitButton.getId()));
    }

    @Test
    public void setViewsForActivity_noViewIsAdded() throws Exception {
        Screen loginScreen = new Screen();
        loginScreen.setUiElements(null);

        activity.setViewsForActivity(style, loginScreen, linearLayout, layoutParams, activity);
        assertNull(activity.findViewById(100));
    }
}