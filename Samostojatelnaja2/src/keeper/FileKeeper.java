/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keeper;


import entity.Buyer;
import entity.ShoeModel;
import interfaces.Keeping;
import entity.cash;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Serializable;
/**
 *
 * @author pupil
 */
public class FileKeeper implements Keeping{

    @Override
    public void saveModels(List<ShoeModel> ShoeModels) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("ShoeModels");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(ShoeModels);
            oos.flush();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет файла ShoeModels", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
    }

    @Override
    public List<ShoeModel> loadModels() {
        List<ShoeModel> listModels = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("ShoeModels");
            ois = new ObjectInputStream(fis);
            listModels = (List<ShoeModel>) ois.readObject();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет файла ShoeModels", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return listModels;
    }

    @Override
    public void saveBuyers(List<Buyer> buyers) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("buyers");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(buyers);
            oos.flush();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет файла buyers", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
    }

    @Override
    public List<Buyer> loadBuyers() {
        List<Buyer> buyers = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("buyers");
            ois = new ObjectInputStream(fis);
            buyers = (List<Buyer>) ois.readObject();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет файла buyers", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return buyers;
    }

    @Override
    public void saveCash(float cash) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("cash");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(cash);
            oos.flush();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет файла cash", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
    }

    @Override
    public float LoadCash() {
        float cash = 0;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("cash");
            ois = new ObjectInputStream(fis);
            cash = (float) ois.readObject();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет файла cash", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return cash;
    }
    
}
