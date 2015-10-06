/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checksum;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author bitxnor
 */
public class CRC32 {

    public static long getCRC32Checksum(java.util.zip.Checksum checksum, String fname) throws FileNotFoundException, IOException {

        BufferedInputStream is = new BufferedInputStream(
                new FileInputStream(fname));
        byte[] bytes = new byte[1024];
        int len = 0;

        while ((len = is.read(bytes)) >= 0) {
            checksum.update(bytes, 0, len);
        }
        is.close();

        return checksum.getValue();
    }

}
