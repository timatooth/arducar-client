package com.timatooth.carclient;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tim
 */
public class NetWriteThread extends Thread {
    
    private final Map<String, Boolean> actions;
    private boolean keepRunning;
    private final CarConnection con;
    
    public NetWriteThread(Map<String, Boolean> actions, CarConnection con) {
        this.actions = actions;
        keepRunning = true;
        this.con = con;
    }
    
    public synchronized void setRunning(boolean state) {
        this.keepRunning = state;
    }
    
    @Override
    public void run() {
        
        while (keepRunning) {
            try {
                if (actions.get("forward")) {
                    if (actions.get("left")) {
                        con.send("G");
                    } else if (actions.get("right")) {
                        con.send("D");
                    } else {
                        con.send("F");
                    }
                } else if (actions.get("backward")) {
                    if (actions.get("left")) {
                        con.send("V");
                    } else if(actions.get("right")){
                        con.send("N");
                    } else {
                        con.send("B");
                    }
                } else if(actions.get("left")){
                    con.send("L");
                } else if(actions.get("right")){
                    con.send("R");
                }
                if(actions.get("horn")){
                    con.send("H");
                }
                
            } catch (IOException ioe) {
                
            }
            
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(NetWriteThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
