# MaiguaPaul_VGameAPI
## LOGIN Development

### LOGIN elements
The first step to making the login is to add these four elements: **Plain Text** (txtUsername), **Password** (txtPassword), **Login** (btnSignIn) and **Text View** (lblLoginResult).
Then, we link them to the java code section using these codes:

```
Button btnLogin = findViewById(R.id.btnLogin);
EditText txtUsername = findViewById(R.id.txtUsername);
EditText txtPassword = findViewById(R.id.txtPassword);
TextView lblLoginResult = findViewById(R.id.lblLoginResult);
```

Finally, we only have to use this single line code to check if the login button works:

`Log.i("Test", "Login correcte");`

The result will be shown in the **logcat**.

We can also use `lblLoginResult.setText("Login correcte");` so the **Text View** shows the text "_Login correcte_".

## LOGIN Design
Next step is the **LOGIN design**.

### ICONS
We start by creating the **email** (ic_email) and **lock** (ic_lock) icons from the **Vector Assets** section.

To add them to the LOGIN we go to the **activity_main.xml** code and add the following lines:
```
android:drawableStart="@drawable/ic_email"
android:drawableStart="@drawable/ic_lock"
```

### PASSWORD
Don't forget to change the txtPassword **text property** to HINT, so it hides the password text.

### FOCUSED STYLE
We also need the text field style to change when the user **focuses** on it.

We do it by creating a **Drawable Resource File** named *custom_input.xml* and adding the following lines of code:

```
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
 
   <item android:state_enabled="true" android:state_focused="true">
       <shape android:shape="rectangle">
           <solid android:color="@color/white"/>
           <corners android:radius="10dp"/>
           <stroke android:color="@color/purple_700" android:width="2dp" />
       </shape>
   </item>


   <item android:state_enabled="true">
       <shape android:shape="rectangle">
           <solid android:color="@color/white"/>
           <corners android:radius="10dp"/>
           <stroke android:color="@color/grey" android:width="2dp" />
       </shape>
   </item>
</selector>
```

The final step is to do the same with the icons.
We only need to copy and paste our **ic_email** (ic_email_focused) and **ic_lock** (ic_lock_focused) files and changing two things:

-Delete the line: `android:tint="?attr/colorControlNormal">`
-Change the line: `android:fillColor="@color/purple_700"` to the focused color.

Also, add a new _Drawable_ (custom_email_icon) with these two items:

```
<item android:state_focused="true"
   android:drawable="@drawable/ic_email_focused" />

<item android:state_focused="false"
   android:drawable="@drawable/ic_email" />
```
This will allow the icon color to change when focused.

Do the same with custom_lock_icon.

Finally, we add them to the **activity_main.xml** file by changing the following line:
`android:drawableStart="@drawable/custom_email_icon"`

