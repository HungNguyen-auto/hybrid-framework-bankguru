package commons;

import java.io.File;

public class GlobalConstants {
    public  static  final String APP_URL = "https://demo.nopcommerce.com/";

    public  static  final long SHORT_TIMEOUT = 5;
    public  static  final long LONG_TIMEOUT = 30;

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.pathSeparator + "uploadFiles";
    public static final String DOWNLOAD_FOLDER_PATH = PROJECT_PATH + File.pathSeparator + "downloadFiles";
}
