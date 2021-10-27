/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programm;

import entity.Buyer;
import entity.ShoeModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import keeper.FileKeeper;

public class App {
    Scanner scanner = new Scanner(System.in);
    List<ShoeModel> ShoeModels = new ArrayList<>();
    List<Buyer> buyers = new ArrayList<>();
    float cash;
    FileKeeper fileKeeper = new FileKeeper();
    
    public App(){
       ShoeModels = fileKeeper.loadModels();
    }


public void run(){
        String repeat = "y";
        do{
            System.out.println("Выберите задачу: ");
            System.out.println("0: Закончить программу");
            System.out.println("1: Добавить модель обуви");
            System.out.println("2: Список продаваемых моделей");
            System.out.println("3: Добавить покупателя");
            System.out.println("4: Список зарегестрированных покупателей");
            System.out.println("5: Купить");
            System.out.println("6: Доход магазина за всё время");
            System.out.println("7: Добавить денег покупателю");
            
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0: 
                    repeat="q";
                    fileKeeper.saveModels(ShoeModels);
                    System.out.println("Программа закончена");
                    break;
                case 1:
                    System.out.println("Добавление модели");
                    ShoeModels.add(addModel());
                    break;
                case 2:
                    System.out.println("Список моделей: ");
                    for (int i = 0; i < ShoeModels.size(); i++) {
                        if(ShoeModels.get(i) != null){
                            System.out.println(ShoeModels.get(i).toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Добавление покупателя");
                    buyers.add(addBuyer());
                    break;
                case 4:
                    System.out.println("Список читателей: ");
                    for (int i = 0; i < buyers.size(); i++) {
                        if(buyers.get(i) != null){
                            System.out.println(buyers.get(i).toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Происходит покупка ");
                    buyShoe(buyers,ShoeModels);
                    break;
                case 6:
                    System.out.println("Всего заработанно: " + cash);
                    break;
                case 7:
                    System.out.println("Добавление денег покупателю");
                    addMoney(buyers);
                    break;
            }
        }while("y".equals(repeat));
}



    private ShoeModel addModel(){
        ShoeModel shoemodel = new ShoeModel();
        System.out.print("Введите название модели: ");
        shoemodel.setModelName(scanner.nextLine());
        System.out.print("Введите цену модели: ");
        shoemodel.setPrice(scanner.nextFloat());
        scanner.nextLine();
        
        return shoemodel;
    }
    
    private Buyer addBuyer(){
        Buyer TheBuyer = new Buyer();
        System.out.println("Введите имя покупателя: ");
        TheBuyer.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию покупателя: ");
        TheBuyer.setLastname(scanner.nextLine());
        System.out.print("Введите телефон покупателя: ");
        TheBuyer.setPhone(scanner.nextLine());
        
        return TheBuyer;
    }
    
    private void addMoney(List<Buyer> buyers){
        System.out.println("Введите телефон покупателя: ");
        String buyerPhone = scanner.nextLine();
        System.out.print("Введите сколько денег добавить покупателю: ");
        float money = (scanner.nextFloat());
        scanner.nextLine();
        for (int i = 0; i < buyers.size(); i++) {
                        if(buyers.get(i) != null){
                            if(buyerPhone.equals(buyers.get(i).getPhone())){
                                buyers.get(i).setMoney(buyers.get(i).getMoney()+money);
                                System.out.println("Деньги добавленны!");
                            }
                            else{
                                System.out.println("Пользователя с таким телефоном не существует!");
                            }
                        }
                    }
        
        
    }
    
    private void buyShoe(List<Buyer> buyers, List<ShoeModel> models){
        System.out.println("Введите телефон покупателя, покупающего обувь: ");
        String buyerPhone = scanner.nextLine();
        System.out.println("Список моделей: ");
                    for (int i = 0; i < ShoeModels.size(); i++) {
                        if(ShoeModels.get(i) != null){
                            System.out.println(ShoeModels.get(i).toString());
                        }
                    }
        System.out.println("Какую модель покупает покупатель? ");
        String buyerModel = scanner.nextLine();
        for (int i = 0; i < buyers.size(); i++){
            if(buyers.get(i) != null){
                if(buyerPhone.equals(buyers.get(i).getPhone())){
                    for (int x = 0; x < models.size(); x++){
                        if(buyerModel.equals(models.get(x).getModelName())){
                            buyers.get(i).setMoney(buyers.get(i).getMoney()-models.get(x).getPrice());
                            cash = cash + models.get(x).getPrice();
                        }
                        else{
                            System.out.println("Такой модели не существует!");
                        }
                    }
                }
                else{
                    System.out.println("Пользователя с таким телефоном не существует!");
                }
                System.out.println("Покупка совершена!");
            }
        }
        
        
    }
    
}