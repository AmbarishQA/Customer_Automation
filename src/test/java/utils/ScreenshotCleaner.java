//package utils;
//
//import java.io.File;
//
//public class ScreenshotCleaner {
//
//    // Method to delete screenshots in the given folder
//    public static void deleteScreenshots(String folderPath) {
//        File folder = new File(folderPath);
//
//        // Check if the folder exists
//        if (folder.exists() && folder.isDirectory()) {
//            try {
//                // List all files in the folder
//                File[] files = folder.listFiles();
//
//                if (files != null) {
//                    for (File file : files) {
//                        // Check if it's a file and ends with common screenshot extensions
//                        if (file.isFile() && (file.getName().toLowerCase().endsWith(".png") ||
//                                file.getName().toLowerCase().endsWith(".jpg") ||
//                                file.getName().toLowerCase().endsWith(".jpeg") ||
//                                file.getName().toLowerCase().endsWith(".bmp") ||
//                                file.getName().toLowerCase().endsWith(".gif"))) {
//                            // Delete the file
//                            if (file.delete()) {
//                                System.out.println("Deleted screenshot: " + file.getName());
//                            } else {
//                                System.out.println("Failed to delete: " + file.getName());
//                            }
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                System.out.println("An error occurred while deleting files: " + e.getMessage());
//            }
//        } else {
//            System.out.println("Folder not found or is not a valid directory: " + folderPath);
//        }
//    }
//
//    public static void main(String[] args) {
//        // Specify the folder containing screenshots
//        String screenshotFolderPath = "D:\\Automation_Gokhana\\src\\screenshots";
//
//        // Simulate tests being completed (You can replace this with actual logic)
//        System.out.println("Test execution completed, cleaning up screenshots...");
//
//        // Call the method to delete screenshots
//        deleteScreenshots(screenshotFolderPath);
//    }
//}
