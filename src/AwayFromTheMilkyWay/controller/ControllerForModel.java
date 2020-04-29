
package AwayFromTheMilkyWay.controller;

import AwayFromTheMilkyWay.model.Model;
import AwayFromTheMilkyWay.view.View;


public class ControllerForModel implements IControllerForModel {
    private static ControllerForModel instance;
    
    
  
    
    public ControllerForModel(){
        
    }
      
           
    public static IControllerForModel getInstance() {
        if(instance == null)
            instance = new ControllerForModel();
        return instance;
    }
    
    
    
   @Override
    public void setSpaceshipCenterX (double x){
        Model.getInstance().getSpaceship().setCenterX(x);
    
    }
    
    @Override
    public void setObs1CenterY (double y){
        Model.getInstance().getOstacoloMobile1().setCenterY(y);
    
    }

    @Override
    public void setSpaceshipCenterY (double y){
        Model.getInstance().getSpaceship().setCenterY(y);
    
    }
    
    @Override
    public void setObs2CenterX (double x){
        Model.getInstance().getOstacoloMobile2().setCenterX(x);
    
    }
    
    @Override
    public double getSpaceshipCenterX (){ 
        return View.getInstance().getSpaceship().getCenterX();
        
    }
    
    @Override
    public double getSpaceshipCenterY (){
        return View.getInstance().getSpaceship().getCenterY();
        
    }
    
    
    
     @Override
    public double getMWCenterX(){
        return View.getInstance().getMilkyWay().getCenterX();
    }
    
    @Override
    public double getMWCenterY(){
        return View.getInstance().getMilkyWay().getCenterY();
    }
    
    @Override
    public double getMWRadius(){
        return View.getInstance().getMilkyWay().getRadius();
    }
    
    @Override
    public void setName(){
        Model.getInstance().setName(View.getInstance().getNome());
    }
    
    
}
