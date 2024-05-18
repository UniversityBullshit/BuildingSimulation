package com.universitybusiness.model.client;

import java.io.*;

public class ByteSerializer {
    public static byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bytesOut);

        out.writeObject(object);
        out.flush();

        byte[] bytes = bytesOut.toByteArray();

        out.close();
        bytesOut.close();

        return bytes;
    }

    public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bytesIn = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bytesIn);

        Object object = ois.readObject();

        ois.close();
        bytesIn.close();

        return object;
    }
}
