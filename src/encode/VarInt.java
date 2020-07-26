package encode;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author sh
 */
public class VarInt {

    public static void writeUnsignedVarint(int value, DataOutput output) throws IOException {
        // value & 0xffffff80 当前字节是否为最后一个字节，不是则执行while
        while ((value & 0xffffff80) != 0) {
            // value & 0x7f保证可以取到整数最低7位
            // | 0x80 填充字节最高位为1，因为当前字节还不是数据的最后一个字节
            byte b = (byte) ((value & 0x7f) | 0x80);
            output.writeByte(b);
            System.out.println(b);
            value >>>= 7 ;
        }
        // 写入最后一个字节
        System.out.println(value);
        output.writeByte(value);
    }

    public static int readUnsignedVarint(ByteBuffer buffer) {
        int value = 0;
        int b;
        int i = 0;
        while (((b = buffer.get()) & 0x80) != 0) {
            value |= (b & 0x7f) << i;
            i += 7;
            if (i >= 28) {
                throw new IllegalArgumentException("illegal varint");
            }
        }
        value |= b << i;
        return value;
    }

    public static void main(String[] args) throws IOException {
        DataOutputStream output = new DataOutputStream(new ByteArrayOutputStream(2));
        writeUnsignedVarint(123456, output);
        System.out.println("encode size:" + output.size());
        System.out.println("-----------");
        byte[] bytes = new byte[]{-64, -60, 7};
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        System.out.println("decode:" + readUnsignedVarint(wrap));
        System.out.println("-----------");
    }
}
