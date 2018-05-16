//package folder;
//
//
//import folder.db.DBHelper;
//import folder.models.File;
//import folder.models.Folder;
//
//import java.util.List;
//
//public class Runner1 {
//
//    public static void main(String[] args) {
//
//        Folder folder1 = new Folder("Bicycles");
//        DBHelper.save(folder1);
//        Folder folder2 = new Folder("Cars");
//        DBHelper.save(folder2);
//
//        File file1 = new File("Raleigh", ".txt", 2100, folder1);
//        DBHelper.save(file1);
//        File file2 = new File("Ford", ".txt", 1900, folder2);
//        DBHelper.save(file1);
//        File file3 = new File("Dancelli", ".txt", 1900, folder1);
//        DBHelper.save(file3);
//        File file4 = new File("Specialized", ".txt", 1400, folder1);
//        DBHelper.save(file4);
//        File file5 = new File("Trek", ".txt", 3200, folder1);
//        DBHelper.save(file5);
//        File file6 = new File("Vauxhall", ".txt", 1200, folder2);
//        DBHelper.save(file6);
//        File file7 = new File("Mercedes", ".txt", 1750, folder2);
//        DBHelper.save(file7);
//        File file8 = new File("Vitus", ".txt", 1400, folder1);
//        DBHelper.save(file8);
//
//        List<File> files = DBHelper.getAll(File.class);
//
//        List<Folder> folders = DBHelper.getAll(Folder.class);
//    }
//

//}
