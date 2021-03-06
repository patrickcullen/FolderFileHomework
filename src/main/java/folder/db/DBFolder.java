package folder.db;

import folder.models.File;
import folder.models.Folder;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFolder {

    private static Transaction transaction;
    private static Session session;

    public static List<File> getFilesForFolder(Folder folder){
        session = db.HibernateUtil.getSessionFactory().openSession();
        List<File> results = null;
        try {
            Criteria cr = session.createCriteria(File.class);
            cr.add(Restrictions.eq("folder", folder));
            results = cr.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return results;
    }
}
