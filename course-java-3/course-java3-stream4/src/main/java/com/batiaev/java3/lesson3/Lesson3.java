package com.batiaev.java3.lesson3;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Lesson3
 *
 * @author anton
 * @since 26/08/19
 */
public class Lesson3 implements Serializable {
    public static void main(String[] args) throws IOException {

        File file = new File("./test");

//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getCanonicalPath());
//        System.out.println(file.getPath());


//        file();
//        byteArrayStream();
//        fileStream();
//        pipedStream();
//        sequenceStream();
//        dataStream();
//        bufferedStream();
//        objectStream();
    }

    private static void file() {
        File testFile = new File("/Users/anton/1.txt");
        Path path = testFile.toPath();
        try {
            FileInputStream source = new FileInputStream(testFile);
            Scanner scanner = new Scanner(source);
            String line = scanner.nextLine();
            System.out.println("Line contain: " + line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//
//
//        File file = new File("/etc");
//        file.mkdir();
//        System.out.format("%s, is directory: %s",
//                file.getAbsoluteFile(), file.isDirectory());
//
//        String[] list = file.list();
//        for (String s : list) {
//            System.out.println(s);
//        }
//
        //example 2

//        File test = new File("~/./././test.txt");
//        System.out.println(test.getAbsolutePath());
//        try {
//            System.out.println(test.getCanonicalPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static void objectStream() {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            Integer integerSave = new Integer(155);

            oos.writeObject(integerSave);
            byte[] arr = os.toByteArray();
            os.close();
            oos.close();
            ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(is);
            Integer integerRead = (Integer) ois.readObject();
            ois.readLong();
            is.close();
            ois.close();
            System.out.println("Writed: " + integerSave + ", Readed: " + integerRead);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void dataStream() {
        try {
            DataOutputStream out = new DataOutputStream(
                    new FileOutputStream("file.txt"));
            out.writeUTF("Hello world");
            out.writeInt(128);
            out.writeLong(128);
//            out.write
            out.close();
            DataInputStream in = new DataInputStream(
                    new FileInputStream("file.txt"));
            System.out.println(in.readInt());
            System.out.println(in.readLong());
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void byteArrayStream() {
        String name = "Anton";
        byte[] bytes = name.getBytes();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            stream.write(bytes);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


        byte[] arr = {100, 25, 50};
        ByteArrayInputStream in = new ByteArrayInputStream(arr);
        process(in);
        int x;
        while ((x = in.read()) != -1) {
            System.out.print(x + " ");
        }
    }

    private static void process(final InputStream stream) {
//        stream.read();
    }

    private static void fileStream() {
        byte[] bw = {10, 20, 30};
        byte[] br = new byte[20];

        FileInputStream in = null;
        try (FileOutputStream out = new FileOutputStream("12345.txt");
             FileInputStream into = new FileInputStream("12345.txt")) {

            int read = into.read();
            out.write(bw);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            in = new FileInputStream("12345.txt");
            in.skip(5);
            int count = in.read(br);
            System.out.println("Прочитано " + count + " байт");
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void pipedStream() {
        PipedInputStream in = null;
        PipedOutputStream out = null;
        try {
            in = new PipedInputStream();
            out = new PipedOutputStream();
            out.connect(in);
            out.flush();
            for (int i = 0; i < 100; i++) {
                out.write(i);
            }
            int x;
            while ((x = in.read()) != -1) {
                System.out.print(x + " ");
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void sequenceStream() {
        FileInputStream in1 = null, in2 = null;
        SequenceInputStream seq = null;
        FileOutputStream out = null;
        try {
            in1 = new FileInputStream("1.txt");
            in2 = new FileInputStream("2.txt");
            seq = new SequenceInputStream(in1, in2);
            seq.read();

            try (DataInputStream dataInputStream = new DataInputStream(
                    new BufferedInputStream(
                            seq))) {
                float readFloat = dataInputStream.readFloat();
            } catch (Exception e) {

            }


            out = new FileOutputStream("3.txt");
            int rb = seq.read();
            while (rb != -1) {
                out.write(rb);
                rb = seq.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                seq.close();
            } catch (IOException e) {
            }
            try {
                out.close();
            } catch (IOException e) {
            }
        }
    }

    private static void bufferedStream() {
        try {
            File f = new File("file.txt");
            OutputStream out = new BufferedOutputStream(
                    new FileOutputStream("file.txt"));

            for (int i = 0; i < 1000000; i++) {
                out.write(i);
                System.out.println(f.length());
            }
            out.flush();
            out.close();

            InputStream in = new BufferedInputStream(
                    new FileInputStream("file.txt"));
            while (in.read() != -1) {
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}