package FileOperations;

import Classes.User;
import Manager.MyObjectOutputStream;

import java.io.*;
import java.util.ArrayList;

public class FileOperationsOnLoginAndSignup {

    public static void writeToFile(User user){

        try{

            File f = new File("Users.ser");
            System.out.println(f.getAbsolutePath());
            ObjectOutputStream oos;
            if(f.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(f,true));
            }
            else{
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(user);
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


    public static User findSpecificUser(String userName){

        ArrayList<User> users = readAllFromFile();
        int i;
        for( i= 0 ; i < users.size();i++){
            if(users.get(i).getUserName().equals(userName)){
                break;
            }
        }
        return users.get(i);
    }

    public static boolean searchUsername(String userName){

        ArrayList<User> users = readAllFromFile();
        for(int i = 0; i < users.size();i++){
            if(userName.equals(users.get(i).getUserName())){
                return true;
            }
        }
        return false;
    }

    public static boolean searchpassword(String password){

        ArrayList<User> users = readAllFromFile();
        for(int i = 0; i < users.size();i++){
            if(password.equals(users.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }

    public static void editPassword(String searchUser,String password){

        ArrayList<User> users = readAllFromFile();
        for(int i = 0; i < users.size();i++){
            if(searchUser.equals(users.get(i).getUserName())){
                users.get(i).setPassword(password);
            }
        }
        writeEditInfoToFile(users);
    }


    public static void editUserName(String searchUser,String UserName){

        ArrayList<User> users = readAllFromFile();
        for(int i = 0; i < users.size();i++){
            if(searchUser.equals(users.get(i).getUserName())){
                users.get(i).setUserName(UserName);
            }
        }
        writeEditInfoToFile(users);
    }


    public static void editName(String searchUser,String Name){

        ArrayList<User> users = readAllFromFile();
        for(int i = 0; i < users.size();i++){
            if(searchUser.equals(users.get(i).getUserName())){
                users.get(i).setName(Name);
            }
        }
        writeEditInfoToFile(users);

    }


    public static void editAddress(String searchUser,String address){

        ArrayList<User> users = readAllFromFile();
        for(int i = 0; i < users.size();i++){
            if(searchUser.equals(users.get(i).getUserName())){
                users.get(i).setAddress(address);
            }
        }
        writeEditInfoToFile(users);
    }


    public static void editGender(String searchUser,String gender){

        ArrayList<User> users = readAllFromFile();
        for(int i = 0; i < users.size();i++){
            if(searchUser.equals(users.get(i).getUserName())){
                users.get(i).setGender(gender);
            }
        }
        writeEditInfoToFile(users);
    }


    public static void editMembership(String searchUser,String Membership){

        ArrayList<User> users = readAllFromFile();
        for(int i = 0; i < users.size();i++){
            if(searchUser.equals(users.get(i).getUserName())){
                users.get(i).setMembershipStatus(Boolean.parseBoolean(Membership));
            }
        }
        writeEditInfoToFile(users);
    }

    public static void updateEntireUser(User user){
        ArrayList<User> users = readAllFromFile();
        System.out.println(users.size());

        for(int i = 0; i < users.size();i++){
//            System.out.println("hi");
            if(user.getUserName().equals(users.get(i).getUserName())){
                users.remove(i);
                users.add(i,user);
            }
        }
        writeEditInfoToFile(users);


    }

    private static void writeEditInfoToFile(ArrayList<User> user){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Users.ser"));

            for(int i = 0 ; i < user.size();i++){
                oos.writeObject(user.get(i));
            }
            oos.close();
        }
        catch (EOFException e){

        }
        catch(IOException e){

        }

    }

    public static ArrayList<User> readAllFromFile(){

        ArrayList<User> list = new ArrayList<User>();

        try{
            ObjectInputStream ois  = new ObjectInputStream(new FileInputStream("Users.ser"));
            while(true){

                User user = (User) ois.readObject();
                list.add(user);

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
