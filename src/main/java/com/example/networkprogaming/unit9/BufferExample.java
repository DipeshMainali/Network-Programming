package com.example.networkprogaming.unit9;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-06-09
 **/
public class BufferExample {
    public static void main(String[] args) {
        // A. Creating Buffer
        // 1. Allocation
        ByteBuffer buffer1 = ByteBuffer.allocate(100);
        IntBuffer buffer2 = IntBuffer.allocate(100);
        // to fetch data from buffer
        byte[] data1 = buffer1.array();
        int[] data2 = buffer2.array();

        // 2. Direct Allocation
        ByteBuffer buffer3 = ByteBuffer.allocateDirect(100);

        // 3. Wrapping
        byte[] data = "Some data".getBytes(StandardCharsets.UTF_8);
        ByteBuffer buffer4 = ByteBuffer.wrap(data);
        char[] text = "Some data".toCharArray();
        CharBuffer buffer5 = CharBuffer.wrap(text);


        // B. Filling and Draining
        // 1. Filling
        CharBuffer buffer = CharBuffer.allocate(12);
        buffer.put('H');
        buffer.put('e');
        buffer.put('l');
        buffer.put('l');
        buffer.put('o');

        buffer.flip();
        // 2. Draining
        String result = "";
        while (buffer.hasRemaining()) {
            result += buffer.get();
        }

        // 3. Absolute Method
        buffer.put(0, 'H');
        buffer.put(1, 'e');
        buffer.put(2, 'l');
        buffer.put(3, 'l');
        buffer.put(4, 'o');


        // C. Bulk Methods
//        public ByteBuffer get(byte[] dst, int offset, int length)
//        public ByteBuffer get(byte[] dst)
//        public ByteBuffer put(byte[] array, int offset, int length)
//        public ByteBuffer put(byte[] array)


        // D. Data Conversion
//        getChar()
//        putChar(char value)
//        getChar(int index)
//        putChar(int index, char value)
//        getShort()
//        putShort(short value)
//        getShort(int index)
//        putShort(int index, short value)
//        getInt()
//        putInt(int value)
//        getInt(int index)
//        putInt(int index, int value)
//        getLong()
//        putLong(long value)
//        getLong(int index)
//        putLong(int index, long value)
//        getFloat()
//        putFloat(float value)
//        getFloat(int index)
//        putFloat(int index, float value)
//        getDouble()
//        putDouble(double value)
//        getDouble(int index)
//        putDouble(int index, double value)

        // E. View Buffers
//        asShortBuffer()
//        asCharBuffer()
//        asIntBuffer()
//        asLongBuffer()
//        asFloatBuffer()
//        asDoubleBuffer()

        // F. Compacting Buffer
//         compact()
        buffer.compact();

        // G. Duplicating Buffers
//        duplicate()

        // H. Slicing Buffers
//        slice()

        // I. Marking and Resetting
//        public final Buffer mark()
//        public final Buffer reset()

        // J. Object Methods

//        Two buffers are considered to be equal if:
//            • They have the same type.
//            • They have the same number of elements remaining in the buffer.
//            • The remaining elements at the same relative positions are equal to each other.
        CharBuffer buffer12 = CharBuffer.wrap("12345678");
        CharBuffer buffer21 = CharBuffer.wrap("5678");
        buffer12.get();
        buffer12.get();
        buffer12.get();
        buffer12.get();
        System.out.println(buffer12.equals(buffer21));


    }
}
