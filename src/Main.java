/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Thing[] things = new Thing[1];
        things[0] = new Spin(400, 300, 100,30);
        
        View view = new View(things);
        
        while (true)
        {
            if (view.clicked())
            {
                for (Thing thing: things)
                {
                    if (thing != null)
                    {
                        thing.click(view.getMouseClick());
                    }
                }
                view.unclick();
            }
            
            for (Thing thing: things)
            {
                if (thing != null)
                {
                    if (thing.hasStarted())
                    {
                        thing.go();
                    }
                }
            }
            view.repaint();
            
            try{
                Thread.sleep(1);
            }catch(Exception e){}
        }
        
    }
    
}
