package FileOperations;

import Classes.Admin;
import Classes.User;
import Manager.MyObjectOutputStream;

import java.io.*;
import java.util.ArrayList;

public class FileOperationsOnAdmin {

    public static void writeToFile(Admin admin){

        try{

            File f = new File("Admin.ser");
            System.out.println(f.getAbsolutePath());
            ObjectOutputStream oos;
            if(f.exists()){

                oos = new MyObjectOutputStream(new FileOutputStream(f,true));

            }
            else{
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(admin);
            oos.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

//    public static void readFromFile(){
//
//        try {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Student.ser"));
//            while(true){
//                Item item = (Item) ois.readObject();
//                System.out.println(item.getName());
//
//            }
//        }
//        catch(ClassNotFoundException e){
//
//        }
//        catch(EOFException e){
//            return;
//        }
//        catch(IOException e){
//
//        }
//    }


    public static boolean searchUsername(String userName){

        ArrayList<Admin> admins = readAllFromFile();
        for(int i = 0; i < admins.size();i++){
            if(userName.equals(admins.get(i).getUserName())){
                return true;
            }
        }
        return false;
    }

    public static boolean searchpassword(String password){

        ArrayList<Admin> admins = readAllFromFile();
        for(int i = 0; i < admins.size();i++){
            if(password.equals(admins.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Admin> readAllFromFile(){

        ArrayList<Admin> list = new ArrayList<Admin>();

        try{
            ObjectInputStream ois  = new ObjectInputStream(new FileInputStream("Admin.ser"));
            while(true){

                Admin admin = (Admin) ois.readObject();
                list.add(admin);

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
