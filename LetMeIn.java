
package zanflango.letmein;

import org.bukkit.plugin.java.JavaPlugin;

public class LetMeIn extends JavaPlugin{
   @Override
   public void onEnable(){
       getCommand("letmein").setExecutor(new LetMeInCommand());
   }
}
