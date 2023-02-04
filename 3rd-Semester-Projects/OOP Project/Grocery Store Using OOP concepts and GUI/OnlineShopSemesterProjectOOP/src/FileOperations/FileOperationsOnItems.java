package FileOperations;

import Classes.Item;
import Classes.User;
import Manager.MyObjectOutputStream;

import java.io.*;
import java.util.ArrayList;

public class FileOperationsOnItems {



    public static boolean removeItem(String itemName){
        boolean flag = false;

        ArrayList<Item> items = readAllFromFile();

        for(int i = 0 ; i < items.size();i++){

            if(items.get(i).getName().equals(itemName)){
                flag = true;
                items.remove(i);
                break;
            }
        }
        if(flag) {
            updateFile(items);
        }
        return flag;

    }
    public static boolean updateItems(String itemName,String newName,String newId,String newPrice,String newQuantity,String newLocation){

        boolean flag = false;

        ArrayList<Item> items= readAllFromFile();

        for(int i = 0 ;i < items.size();i++){

            if(items.get(i).getName().equals(itemName)){
                flag = true;
                Item item= items.get(i);

                if(!(newName.equals(""))){
                    item.setName(newName);
                }
                if(!(newPrice.equals(""))){
                        item.setPrice(Integer.parseInt(newPrice));
                }
                if(!(newQuantity.equals(""))){

                    item.setTotalQuantity(Integer.parseInt(newQuantity));
                }
                if(!(newLocation.equals(""))){
                    item.setImageLocation(newLocation);
                }

                break;
            }

        }
        if(flag) {
            updateFile(items);
        }
        return flag;

    }
    public static void writeToFile(Item item){

        try{

            File f = new File("Item.ser");
            System.out.println(f.getAbsolutePath());
            ObjectOutputStream oos;
            if(f.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(f,true));
            }
            else{
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(item);
            oos.close();

        }
        catch(IOException e){
           e.printStackTrace();
        }

    }

    public static void readFromFile(){

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Student.ser"));
            while(true){
                Item item = (Item) ois.readObject();
                System.out.println(item.getName());

            }
        }
        catch(ClassNotFoundException e){

        }
        catch(EOFException e){
            return;
        }
        catch(IOException e){

        }
    }

    public static Item findSpecificItem(String itemName){

        ArrayList<Item> items = readAllFromFile();
        int i;
        for( i= 0 ; i < items.size();i++){
            if(items.get(i).getName().equals(itemName)){
                break;
            }
        }
        return items.get(i);
    }


    public static boolean searchItem(String itemName){

        ArrayList<Item> items = readAllFromFile();
        for(int i = 0; i < items.size();i++){
            if(itemName.equals(items.get(i).getName())){
                return true;
            }
        }
        return false;
    }

    public static  void updateFile(ArrayList<Item> items){


        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Item.ser"));

            for(int i = 0 ; i < items.size();i++){
                oos.writeObject(items.get(i));
            }
            oos.close();
        }
        catch (EOFException e){

        }
        catch(IOException e){

        }
    }


    public static void updateItemsQuantity(ArrayList<Item> itemFromCart){

        ArrayList<Item> items = readAllFromFile();

        for(int j = 0 ;j < itemFromCart.size();j++  ) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getName().equals(itemFromCart.get(j).getName())) {
                    items.get(i).setSoldItems(items.get(i).getSoldItems()+itemFromCart.get(j).getUserQuantity());
                    items.get(i).setTotalQuantity(items.get(i).getTotalQuantity() - itemFromCart.get(j).getUserQuantity());
                    break;
                }
            }
        }

        updateFile(items);

    }



    public static ArrayList<Item> readAllFromFile(){

        ArrayList<Item> list = new ArrayList<Item>();

        try{
            ObjectInputStream ois  = new ObjectInputStream(new FileInputStream("Item.ser"));
            while(true){

                Item item = (Item) ois.readObject();

                System.out.println(item.getName());
                list.add(item);
            }
        }
        catch(ClassNotFoundException e){

        }
        catch(EOFException e){

        }
        catch(IOException e){

        }

        return list;
    }
//
//    public static boolean searchAStudent(String regNo){
//
//        ArrayList<Student> list= readAllFromFile() ;
//
//        for(int i = 0 ; i < list.size();i++){
//            if(list.get(i).getRegNo().equals(regNo)){
//                System.out.println(list.get(i).getEmail());
//                return true;
////                System.out.println("Student Found");
//            }
//
//        }
//        return false;
//    }
//
//    public static void DeleteByRegNo(String regNo){
//
//        ArrayList<Student> list = readAllFromFile();
//
//        for(int i= 0 ; i < list.size();i++){
//            if(list.get(i).getRegNo().equals(regNo)){
//                list.remove(list.get(i));
//                break;
//            }
//        }
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Student.ser"));
//
//            for(int i = 0 ; i < list.size();i++){
//                oos.writeObject(list.get(i));
//            }
//            oos.close();
//        }
//        catch (EOFException e){
//
//        }
//        catch(IOException e){
//
//        }
//    }
//
//    public static void UpdateAStudentEmail(String regNo, String email){
//
//        ArrayList<Student> list = readAllFromFile();
//
//        for(int i = 0 ; i < list.size();i++){
//            if(list.get(i).getRegNo().equals(regNo)){
//                list.get(i).setEmail(email);
//                break;
//            }
//        }
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Student.ser"));
//            for (int i = 0; i < list.size(); i++) {
//
//                oos.writeObject(list.get(i));
//
//            }
//        }
//        catch (EOFException e){
//
//        }
//        catch (IOException e){
//
//        }
//
//
//    }
//
//    public static void UpdateAStudentDepartment(String regNo,String deptName){
//
//        ArrayList<Student> list = readAllFromFile();
//
//        for(int i = 0 ; i < list.size();i++){
//            if(list.get(i).getRegNo().equals(regNo)){
//                list.get(i).getDepartment().setName(deptName);
//                break;
//            }
//        }
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Student.ser"));
//            for (int i = 0; i < list.size(); i++) {
//
//                oos.writeObject(list.get(i));
//
//            }
//        }
//        catch (EOFException e){
//
//        }
//        catch (IOException e){
//
//        }
//
//
//    }
//
//    public static int countAllStudentsOnProb(){
//
//        ArrayList<Student> list = readAllFromFile();
//
//        int count =0;
//        for(int i= 0 ; i < list.size();i++){
//            if(list.get(i).getGPA()<2){
//                count = count+1;
//            }
//        }
//         return count;
//    }
//    public static void displayAllStudentsFromDepartment(String deptName){
//
//        ArrayList<Student> list = readAllFromFile();
//        for(int i = 0 ; i < list.size();i++){
//
//            if( list.get(i).getDepartment().getName().equals(deptName)){
//                System.out.println(list.get(i).getName());
//            }
//        }
//    }
//
//    public  static void deleteFromDepartment(String department){
//
//        ArrayList<Student> list = readAllFromFile();
//
//        for(int i = 0 ; i < list.size();i++){
//            System.out.println(list.get(i).getDepartment().getName());
//            if (list.get(i).getDepartment().getName() == (department)) {
//                list.remove(i);
//            }
//        }
//
//        try{
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Student.ser"));
//
//            for(int i= 0; i < list.size();i++) {
//                oos.writeObject(list.get(i));
//            }
//            oos.close();
//        }
//        catch (EOFException e){
//
//        }
//        catch (IOException e){
//
//        }
//
//
//    }





}
