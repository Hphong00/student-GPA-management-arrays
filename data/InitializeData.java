package data;

import entity.Student;

import java.io.*;

public class InitializeData {
    public static void writeToFile(Object[] data, String fileName) throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName, true);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(data);
            objectOutputStream.writeObject("\n");
        } catch (IOException e) {
            System.out.println("Error Write file");
        } finally {
            fileOutputStream.close();
            objectOutputStream.close();
        }
    }
    public Object readDataFromFile(String fileName) throws IOException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);

            Student[] students = (Student[]) objectInputStream.readObject();
            System.out.println(students);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
            objectInputStream.close();
        }
        return null;
    }
}
