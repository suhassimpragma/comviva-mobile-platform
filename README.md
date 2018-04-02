# Comviva Mobile Platform


This is a sample project which demonstrates Android UI update based on configurations from the cloud.

# Problem statement

The application should be able to read UI configurations from CouchDB and display UI to the user.

# Solution

We have a `Style` document that contains style related information for each element and will
be applied to the whole application.

## Sample Style document

```
{
   "_id":"Style",
   "_rev":"32-c011a98fbf4ed9b332a192afd497862c",
   "type":"style",
   "properties":[
      {
         "type":"layout",
         "background":"#A9D0F5",
         "padding":25
      },
      {
         "type":"edittext"
      },
      {
         "type":"button"
      }
   ]
}
```

We have `Screen` documents that contain the UI elements that should appear on a particular screen.
For our example, we have taken up Login screen.

## Sample Screen document

```
{
   "_id":"LoginScreen",
   "_rev":"11-2c867478544666576ecaad8eea700992",
   "type":"screen",
   "uiElements":[
      {
         "id":100000,
         "slNo":1,
         "type":"EditText",
         "inputType":"text",
         "hint":"Enter username"
      },
      {
         "id":100001,
         "slNo":2,
         "type":"EditText",
         "inputType":"password",
         "hint":"Enter password"
      },
      {
         "id":100002,
         "slNo":3,
         "type":"EditText",
         "inputType":"number",
         "hint":"Enter OTP"
      },
      {
         "id":100003,
         "slNo":4,
         "type":"Button",
         "text":"Submit"
      },
      {
         "id":100004,
         "slNo":5,
         "type":"Button",
         "text":"Sign Up"
      }
   ]
}
```

Based on `Style` and `Screen` documents, the UI is built programmatically and displayed to the user.
Any change on the server is reflected on the next restart of the application.

# Assumptions

We have assumed that the UI elements will be displayed one below the other