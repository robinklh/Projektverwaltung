package database;

public final class Session
{

   private static Object clipboard;

   private static Session session;

   private Session()
   {
      // Hier gibt es nichts zu sehen
   }

   public static Session getInstance()
   {
      if (session == null)
      {
         session = new Session();
      }
      return session;
   }

   public Object getClipboard()
   {
      return clipboard;
   }

   public void removeClipboard()
   {
      clipboard = null;
   }

   public void setClipboard(Object newClipboard)
   {
      clipboard = newClipboard;
   }

}
