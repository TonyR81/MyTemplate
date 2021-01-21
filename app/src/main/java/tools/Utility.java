package tools;

import android.Manifest;
import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Parcelable;
import android.os.StrictMode;
import android.provider.MediaStore;
import com.tonyhack.haircut.R;
import com.google.android.material.textfield.TextInputLayout;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;
import org.json.JSONObject;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import classes.Requests;
import exceptions.InternetConnectionException;
import exceptions.PasswordLengthException;
import exceptions.PasswordsMatchException;

public class Utility {

    /////////////////////////////
    // Internet
    /**
     * Determines if internet connection is available
     * @param ctx Context
     * @return Boolean
     * @see Utility#isConnected(Context)
     * @deprecated {@link #isConnected(Context)}}
     */
    @Deprecated
    public static boolean isNetworkAvailable(Context ctx) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if ((connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED)
                || (connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState() == NetworkInfo.State.CONNECTED)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Determines if the connection is really active
     * @param context Context
     * @return boolean
     */
    public static boolean hasActiveInternetConnection(Context context) throws InternetConnectionException {
        if (isNetAvailable(context)) {
            if (connectGoogle()) {
                return true;
            } else { //one more try
                return connectGoogle();
            }
        } else {
            throw new InternetConnectionException( context );
        }
    }

    /**
     * Checks if internet is available
     * @param context
     * @return boolean
     */
    public static boolean isNetAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    /**
     * Make a connection to google
     * @return boolean
     */
    public static boolean connectGoogle() {
        try {
            HttpURLConnection urlc = (HttpURLConnection)(new URL("http://www.google.com").openConnection());
            urlc.setRequestProperty("User-Agent", "Test");
            urlc.setRequestProperty("Connection", "close");
            urlc.setConnectTimeout(10000);
            urlc.connect();
            return (urlc.getResponseCode() == 200);
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Determines if the device is connected to internet
     * @return Boolean
     */
    public static Boolean isConnected(Context context) throws InternetConnectionException {
        if (isNetworkAvailable( context )) {
            return true;
        } else {
            throw new InternetConnectionException( context );
        }
    }
    /////////////////////////////

    /////////////////////////////
    // Lists

    /**
     * Check if specified array of int contains the specified value
     * @param array int[]
     * @param value int
     * @return boolean
     */
    public static boolean contains(int[] array, int value) {
        for (int i :
                array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
    /////////////////////////////


    /////////////////////////////
    // Password
    /**
     * Encrypt the specified password
     * @param password String
     * @return String
     */
    public static String EncryptPassword(String password) {
        String res = null;
        try {
            final MessageDigest digest = MessageDigest.getInstance( "SHA-1");
            byte[] result = digest.digest(password.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(  );
            for (byte b : result) {
                sb.append(String.format("%02x", b));
            }
            res = sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {

        }
        return res;
    }

    /**
     * Checks password
     * @param password String
     * @param confirmPassword String
     * @return boolean
     */
    public static boolean checkPassword(Context context, String password, String confirmPassword) throws PasswordsMatchException, PasswordLengthException {
        if (!password.equals( confirmPassword )) {
            throw new PasswordsMatchException( context );
        } else {
            if (password.length() < 8) {
                throw new PasswordLengthException( context );
            } else {
                return true;
            }
        }
    }

    /**
     * Returns random username
     * @return String
     */
    public static String usernameGenerator() {
        Random r = new SecureRandom(  );
        String[] s = {"A",
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}; // "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(  );
        for (int i = 0; i < 8; i++) {
            int idx = r.nextInt( 35 );
            sb.append( s[idx] );
        }
        return sb.toString();
    }
    /////////////////////////////

    /////////////////////////////
    // Maths

    /**
     * Returns the amount with tax
     * @param amount double
     * @param tax double
     * @return double
     */
    public static double getAmountWithTax(double amount, double tax) {
        return amount + (amount * tax / 100);
    }
    /////////////////////////////

    /////////////////////////////
    // Date
    /**
     * Returns a string that represents specified date
     * @param date java.Util.Date
     * @return String
     */
    public static String dateToString(Date date) {
        return new SimpleDateFormat( "yyyy-MM-dd", Locale.getDefault() ).format( date );
    }

    /**
     * Returns a string that represents specified date in long format (yyyy-MM-dd HH:mm:ss)
     * @param date java.util.Date
     * @return String
     */
    public static String dateToLongString(Date date) {
        return new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss", Locale.getDefault() ).format( date );
    }

    /**
     * Returns a string that represents specified date in specified pattern format
     * @param date java.util.Date
     * @param pattern String
     * @return String
     */
    public static String dateToLongString(Date date, String pattern) {
        return new SimpleDateFormat( pattern, Locale.getDefault() ).format( date );
    }

    /**
     * Returns a string that represents specified date
     * @param date java.util.Date
     * @param pattern String
     * @return String
     */
    public static String dateToString(Date date, String pattern) {
        return new SimpleDateFormat( pattern, Locale.getDefault() ).format( date );
    }

    /**
     * Returns a date from specified string
     * @param date String
     * @return java.Util.Date
     */
    public static Date stringToDate(String date) {
        try {
            return new SimpleDateFormat( "yyyy-MM-dd", Locale.getDefault() ).parse( date );
        } catch (ParseException e) {
            return new Date(  );
        }
    }

    /**
     * Returns a date from specified string
     * @param date String
     * @param pattern String
     * @return java.util.Date
     */
    public static Date stringToDate(String date, String pattern) {
        try {
            return new SimpleDateFormat( pattern, Locale.getDefault() ).parse( date );
        } catch (ParseException e) {
            return new Date(  );
        }
    }

    /**
     * Returns a long date (yyyy-MM-dd HH:mm:ss) from specified string
     * @param date String
     * @return java.util.Date
     */
    public static Date stringToLongDate(String date) {
        try {
            return new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss", Locale.getDefault() ).parse( date );
        } catch (ParseException e) {
            return new Date(  );
        }
    }

    /**
     * Gets the pattern to display date
     * @return String
     */
    public static String getLongDisplayPattern() {
        String res = "";
        Locale locale = Locale.getDefault();
        switch (locale.getCountry()) {
            case "US":
                res = "MM/dd/yyyy HH:mm:ss";
                break;
            default:
                res = "dd/MM/yyyy HH:mm:ss";
        }
        return res;
    }

    /**
     * Gets the pattern to display date
     * @return String
     */
    public static String getShortDisplayPattern() {
        String res = "";
        Locale locale = Locale.getDefault();
        switch (locale.getCountry()) {
            case "US":
                res = "MM/dd/yyyy";
                break;
            default:
                res = "dd/MM/yyyy";
        }
        return res;
    }

    /**
     * Returns specified value to currency string
     * @param value BigDecimal
     * @return String
     */
    public static String toCurrency(BigDecimal value) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance( Locale.getDefault() );
        numberFormat.setMaximumFractionDigits( 3 );
        numberFormat.setMinimumFractionDigits( 3 );
        return numberFormat.format( value.doubleValue() );
    }

    /**
     * Returns the amount in the following format: € value
     * @param totalAmount BigDecimal
     * @return String
     */
    public static String toLocalCurrency(BigDecimal totalAmount) {
        String value = toCurrency( totalAmount );

        return String.format( "€ %s", value.substring( 0, value.length() - 2 ) );
    }
    /////////////////////////////

    /////////////////////////////
    // String

    /**
     * Returns a string to query server database given key and a json object that contains parameters
     * @param key String
     * @param json JObject
     * @return String
     */
    public static String jsonToPost(String key, JSONObject json) {
        try {
            return URLEncoder.encode( key, "UTF-8" ) + "=" + URLEncoder.encode( json.toString(), "UTF-8" );
        } catch (UnsupportedEncodingException e) {
            Log.d(String.valueOf(R.string.app_name), "jsonToPost: " + e.getMessage());
            return "";
        }
    }

    /**
     * Returns a string to query server database given key and parameters
     * @param key String
     * @param parameters String
     * @return String
     */
    public static String stringToPost(String key, String parameters) {
        try {
            return URLEncoder.encode( key, "UTF-8" ) + "=" + URLEncoder.encode( parameters, "UTF-8" );
        } catch (Exception e) {
            Log.d(String.valueOf(R.string.app_name), "stringToPost: " + e.getMessage());
            return "";
        }
    }
    /////////////////////////////


    /////////////////////////////
    // Message

    /**
     * Show specified message
     * @param context Context
     * @param message String
     */
    public static void message(Context context, String message) {
        Toast.makeText( context, message, Toast.LENGTH_LONG ).show();
    }
    /////////////////////////////

    /////////////////////////////
    // Menu

    /**
     * Force icons for specified popup menu
     * @param menu PopupMenu
     */
    public static void forceMenuIcons(Context context, PopupMenu menu) {
        try {
            Field[] fields = menu.getClass().getDeclaredFields();
            for (Field field : fields) {
                if ("mPopup".equals(field.getName())) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(menu);
                    Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                    Method setForceIcons = classPopupHelper.getMethod("setForceShowIcon", boolean.class);
                    setForceIcons.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Exception e) {
            message( context, e.getMessage() );
        }
    }

    /**
     * Enable bluetooth
     * @param activity AppCompatActivity
     */
    public static void enableBluetooth(AppCompatActivity activity) {
        Intent enableBt = new Intent( BluetoothAdapter.ACTION_REQUEST_ENABLE );
        activity.startActivityForResult( enableBt, 11 );
    }

    /**
     * Check if device support bluetooth and it is enabled
     * @return boolean
     */
    public static boolean checkBluetooth() throws Exception {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            throw new Exception(  );
        } else {
            return bluetoothAdapter.isEnabled();
        }
    }
    /////////////////////////////

    /////////////////////////////
    // Files

    /**
     * Checks path and creates it if not exists
     * @param context Context
     * @param path String
     * @return boolean
     */
    public static boolean checkPath(Context context, String path) {
        File filePath = new File( context.getExternalFilesDir( null ), path );
        if (filePath.exists()) {
            return true;
        } else {
            return filePath.mkdir();
        }
    }
    /////////////////////////////

    /////////////////////////////
    // Image converter

    /**
     * Casts an image into a byte array
     * @param bitmap The image to convert
     * @return Byte[]
     */
    public static byte[] getBytesFromImage(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream(  );
        bitmap.compress( Bitmap.CompressFormat.PNG, 100, stream );
        return stream.toByteArray();
    }

    /**
     * Casts from an array of bytes into an image
     * @param image Byte[]. The image data
     * @return Bitmap
     */
    public static Bitmap getImage(byte[] image ) {
        return BitmapFactory.decodeByteArray( image, 0, image.length );
    }

    /**
     * Returns a string that represents specified bitmap
     * @param bitmap Bitmap
     * @return String
     */
    public static String bitmapToString(Bitmap bitmap) {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        bitmap.compress( Bitmap.CompressFormat.PNG, 100, bao);
        byte[] ba = bao.toByteArray();
        return Base64.encodeToString( ba, Base64.DEFAULT );
    }

    /**
     * Returns a bitmap from specified bytes array string
     * @param bytesString String
     * @return Bitmap
     */
    public static Bitmap stringToBitmap(String bytesString) {
        byte[] bytes = Base64.decode( bytesString, Base64.DEFAULT );
        return getImage( bytes );
    }

    /**
     * Save specified bitmap into specified destination
     * @param context Context
     * @param bitmap Bitmap
     * @param dest String
     * @return boolean
     */
    public static boolean saveBitmap(Context context, Bitmap bitmap, String dest, String name) {
        try {
            String path = new File( context.getExternalFilesDir( null ), dest ).getPath() + "/" + name;
            return checkPath( context, dest ) && bitmap.compress( Bitmap.CompressFormat.PNG, 100, new FileOutputStream( path ) );
        } catch (FileNotFoundException e) {
            Log.d(String.valueOf(R.string.app_name), "saveBitmap: " + e.getMessage());
            return false;
        }
        /**
        try {
            if (checkPath( context, dest )) {
                FileOutputStream fileOutputStream = new FileOutputStream( dest );
                return bitmap.compress( Bitmap.CompressFormat.PNG, 100, fileOutputStream );
            } else {
                return false;
            }
        } catch (Exception e) {
            Log.d( "TAG", e.getMessage() );
            return false;
        }
        */
    }

    /**
     * Load image from specified path
     * @param path String
     */
    public static Bitmap loadImageResource(String path) {
        Bitmap bitmap = null;
        File imgFile = new File( path );
        if (imgFile.exists()) {
            bitmap = BitmapFactory.decodeFile( imgFile.getAbsolutePath() );
        }
        return bitmap;
    }
    /////////////////////////////

    /////////////////////////////
    // String converter
    /**
     * Create QrCode string of specified text
     * @param text String
     * @return String
     */
    public static String toQrCode(String text) {
        StringBuilder builder = new StringBuilder(  );
        int storeLen = text.length() + 3;
        byte storePl = Byte.parseByte( String.valueOf( storeLen % 256 ) );
        byte storePh = Byte.parseByte( String.valueOf( storeLen / 256 ) );
        String ch = "iso-8859-1";
        try {
            builder.append( new String( new byte[] {29, 40, 107, 4, 0, 49, 65, 50, 0}, ch ) );
            builder.append( new String( new byte[] {29, 40, 107, 3, 0, 49, 67, 8}, ch ) );
            builder.append( new String( new byte[] {29, 40, 107, 3, 0, 49, 69, 48}, ch ) );
            builder.append( new String( new byte[] {29, 40, 107, storePl, storePh, 49, 80, 48}, ch ) );
            builder.append( text );
            builder.append( new String( new byte[] {29, 40, 107, 3, 0, 49, 81, 48}, ch ) );
        } catch (UnsupportedEncodingException e) {
            // TODO: 22/03/2020
        }
        return builder.toString();
    }

    /**
     * Center the specified text
     * @param text String
     * @return String
     */
    public static String centerText(String text) {
        String res = "";
        String lines[] = text.split( "\n" );
        int max = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length() > max) {
                max = lines[i].length();
            }
        }
        for (int i = 0; i < lines.length; i++) {
            int diff = (max - lines[i].length()) / 2;
            StringBuilder builder = new StringBuilder(  );
            for (int j = 0; j < diff; j++) {
                builder.append( " " );
            }
            String line = String.format( "%s%s%s", builder.toString(), lines[i], builder.toString() );
            lines[i] = line;
        }
        StringBuilder b = new StringBuilder(  );
        for (int i = 0; i < lines.length; i++) {
            b.append( String.format( "%s%s", lines[i], '\n' ));
        }
        return b.toString();
    }

    /**
     * Returns the intent to send specified file to specified phone with Whatsapp
     * @param file File
     * @param phone String
     * @return Intent
     */
    public static Intent sendPdfToWhatsApp(File file, String phone) {
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        if (!phone.contains( "+39" )) {
            phone = "+39" + phone;
        }
        phone.replace( "+", phone );
        // Formattare il numero di telefono con il codice internazionale (Italia +39 ma senza il +)
        Intent intent = new Intent(Intent.ACTION_SEND);
        Uri uri = Uri.fromFile(file);
        intent.putExtra( "jid", phone + "@s.whatsapp.net" );
        intent.setType("application/pdf");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.setPackage("com.whatsapp");
        return intent;
    }

    /**
     * Returns intent to send specified message to specified phone number
     * @param context Context
     * @param message String
     * @param phone String
     * @return Intent
     */
    public static Intent sendWhatsAppMessage(Context context, String message, String phone) {
        if (!phone.contains( "+" )) {
            phone = "39" + phone;
        }
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        Intent intent = new Intent( Intent.ACTION_VIEW );
        try {
            String url = "https://api.whatsapp.com/send?phone=" + phone + "&text=" + URLEncoder.encode( message, "UTF-8" );
            intent.setPackage( "com.whatsapp" );
            intent.setData( Uri.parse( url ) );
            return intent;
        } catch (Exception e) {
            Log.d( "TAG", e.getMessage() );
        }
        /**
         * PackageManager packageManager = context.getPackageManager();
         *     Intent i = new Intent(Intent.ACTION_VIEW);
         *
         *     try {
         *         String url = "https://api.whatsapp.com/send?phone="+ phone +"&text=" + URLEncoder.encode(message, "UTF-8");
         *         i.setPackage("com.whatsapp");
         *         i.setData(Uri.parse(url));
         *         if (i.resolveActivity(packageManager) != null) {
         *             context.startActivity(i);
         *         }
         *     } catch (Exception e){
         *         e.printStackTrace();
         *     }
         */
        /**
        Intent res = null;
        try {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            if (phone != null) {
                if (!phone.contains( "+" )) {
                    phone = "+39" + phone;
                }
                // Uri uri = Uri.parse("smsto:" + phone);
                Uri uri = Uri.parse(
                        String.format("https://api.whatsapp.com/send?phone=%s&text=%s",
                                phone, message));
                res = new Intent(Intent.ACTION_SEND, uri);
                // sendIntent.setAction(Intent.ACTION_SEND);
                res.setPackage("com.whatsapp");
                res.putExtra(Intent.EXTRA_TEXT, message);
                res.setType("text/plain");
            }

        } catch (Exception e) {
            Log.d( "TAG", e.getMessage() );
        }
        */
        return intent;
    }
    /////////////////////////////

    /////////////////////////////
    // Animations

    /**
     * Start the blink animation for specified list of edit text
     * @param editTexts EditText
     */
    public static void blinkEditText(final List<EditText> editTexts) {
        for (final EditText editText :
                editTexts) {
            @SuppressLint("ObjectAnimatorBinding") ObjectAnimator animator = ObjectAnimator.ofInt( editText.getParent(), "backgroundColor", Color.WHITE, Color.RED, Color.WHITE );
            animator.setDuration( 800 );
            animator.setEvaluator( new ArgbEvaluator() );
            animator.setRepeatMode( ValueAnimator.REVERSE );
            animator.setRepeatCount( 5 );
            animator.addListener( new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    ((TextInputLayout)editText.getParent().getParent()).setBackgroundColor( Color.TRANSPARENT );
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            } );
            animator.start();
        }
    }

    /**
     * Start the blink animation for specified list of edit text
     * @param editTexts EditText
     */
    public static void blinkEditText(EditText... editTexts) {
        for (EditText editText :
                editTexts) {
            @SuppressLint("ObjectAnimatorBinding") ObjectAnimator animator = ObjectAnimator.ofInt( editText.getParent().getParent(), "backgroundColor", Color.WHITE, Color.RED, Color.WHITE );
            animator.setDuration( 800 );
            animator.setEvaluator( new ArgbEvaluator() );
            animator.setRepeatMode( ValueAnimator.REVERSE );
            animator.setRepeatCount( 5 );
            final EditText finalT = editText;
            animator.addListener( new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    ((TextInputLayout) finalT.getParent().getParent()).setBackgroundColor( Color.TRANSPARENT );
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            } );
            animator.start();
        }
    }

    public static void blinkCard(View view) {
        ObjectAnimator animator = ObjectAnimator.ofInt( view, "backgroundColor", Color.WHITE, Color.RED, Color.WHITE);
        animator.setDuration( 800 );
        animator.setEvaluator( new ArgbEvaluator() );
        animator.setRepeatMode( ValueAnimator.REVERSE );
        animator.setRepeatCount( ValueAnimator.INFINITE );
        animator.start();
    }

    public static ObjectAnimator getAnimator(View view) {
        ObjectAnimator animator = ObjectAnimator.ofInt( view, "backgroundColor", Color.WHITE, Color.RED, Color.WHITE);
        animator.setDuration( 800 );
        animator.setEvaluator( new ArgbEvaluator() );
        animator.setRepeatMode( ValueAnimator.REVERSE );
        animator.setRepeatCount( ValueAnimator.INFINITE );
        return animator;
    }
    /////////////////////////////

    /////////////////////////////
    // Image chooser
    /**
     * Returns the intent to choose image from camera and gallery
     * @param context Context
     * @return Intent
     */
    @SuppressLint("RestrictedApi")
    public static Intent getPickImageIntent(Context context) {
        Intent chooserIntent = null;
        List<Intent> intentList = new ArrayList<>();
        // To choose image from gallery
        Intent loadPicture = new Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        // To choose image from camera
        Intent takePictureIntent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE);
        intentList = addIntentsToList( context, intentList, loadPicture );
        intentList = addIntentsToList( context, intentList, takePictureIntent );


        if (intentList.size() > 0) {
            chooserIntent = Intent.createChooser( intentList.remove( intentList.size() - 1 ), context.getResources().getString( R.string.choose_image ) );
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentList.toArray(new Parcelable[]{}));
        }
        return chooserIntent;
    }

    /**
     * Retrieve image from camera and return intent
     * @param context Context
     * @return intent
     */
    public static Intent getFromCamera(Context context) {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From your Camera");
        Uri imageUri = context.getContentResolver().insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        // startActivityForResult(intent, PICTURE_RESULT);
        return intent;
    }

    /**
     * Returns a list of intent
     * @param context Context
     * @param list List<Intent>
     * @param intent Intent
     * @return List<Intent>
     */
    private static List<Intent> addIntentsToList(Context context, List<Intent> list, Intent intent) {
        List<ResolveInfo> resInfo = context.getPackageManager().queryIntentActivities(intent, 0);
        for (ResolveInfo resolveInfo : resInfo) {
            String packageName = resolveInfo.activityInfo.packageName;
            Intent targetedIntent = new Intent(intent);
            targetedIntent.setPackage(packageName);
            list.add(targetedIntent);
        }
        return list;
    }

    public static void hideKeyboard(Activity activity, String query) {
        if (query.isEmpty()) {
            try {
                InputMethodManager inputManager = (InputMethodManager) activity.getApplicationContext().getSystemService( Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow( activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS );
            } catch (Exception e) {
                Log.d( "TAG", e.getMessage() );
            }

        }
    }

    public static Intent CallPhone(Context context, FragmentActivity activity, String phone) {
        Intent intent = new Intent( Intent.ACTION_CALL );
        intent.setData(Uri.parse( "tel:" + phone));
        if (ActivityCompat.checkSelfPermission( context,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.CALL_PHONE}, Requests.PHONE_CALL );
            return null;
        } else {
            return intent;
        }
    }

    /**
     * Play the notification sound
     * @param context Context
     */
    public static void playNotificationSound(Context context) {
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(context, notification);
            r.play();
        } catch (Exception e) {
            Log.d(String.valueOf(R.string.app_name), "playNotificationSound: " + e.getMessage());
        }
    }

    /////////////////////////////

}
