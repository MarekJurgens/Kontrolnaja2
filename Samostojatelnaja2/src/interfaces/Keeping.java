/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Buyer;
import entity.ShoeModel;
import java.util.List;
import programm.App;

/**
 *
 * @author pupil
 */
public interface Keeping {
    public void saveModels(List<ShoeModel> ShoeModels);
    public List<ShoeModel> loadModels();
    public void saveBuyers(List<Buyer> buyers);
    public List<Buyer> loadBuyers();
    public void saveCash(float cash);
    public float LoadCash();
    
}
