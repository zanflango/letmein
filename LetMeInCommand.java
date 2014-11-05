/*
 *LetMeIn Command for VampireZ on Hypixel by Tim Nash IGN:zanflango
* this command is to be used by the vampires as an in game purchaseable effect
* it opens any wooden doors within 5 squares. 
*Currently the code also broadcasts a message saying "Won't you invite me in?"
*The intent of the message is to give the players a heads up that the ability has been used.
*if desried this feature could be removed. 
* the area of effect is currently a 5 block square but the size can be modifed by changing the radius variable below.
 */

package zanflango.letmein;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Openable;

/**
 *
 * @author Tim
 */
public class LetMeInCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        //This command can only be executed by players
        if(!(cs instanceof Player)){
            return false;
        }
        Player player = (Player) cs;
         Bukkit.broadcastMessage("Won't you invite me in?"); //lets the playser know it's been used.. but not where.
        Location l= player.getLocation();
        int radius =5;           
        World w = l.getWorld();
        int xCoord = (int) l.getX();
        int zCoord = (int) l.getZ();
        int YCoord = (int) l.getY();
        for (int x = -radius; x <= radius; x++)
            {
            for (int z = -radius; z <= radius; z++)
                {
                for (int y = -radius; y <= radius; y++)
                    {
                    Block blk =  w.getBlockAt( xCoord + x, YCoord + y, zCoord + z);  
                    if (blk.getType()==Material.WOODEN_DOOR)
                        {
                            BlockState state = blk.getState();
                            MaterialData data = state.getData();
                            if (data instanceof Openable) {
                                ((Openable)data).setOpen(true);
                               state.setData(data);
                                state.update();
                            }
                        }
                    }
                }
            }
         
        return true;
    }
    
}
