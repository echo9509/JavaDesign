package com.reactor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author sh
 */
public class Test {

//    public static void main(String[] args) throws IOException {
//        final String[] FILE_HEADER = new String[]{"loan_id", "customer_id","mobile"};
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("/Users/sh/Downloads/t_apps_trim.sql"))));
//        CSVFormat format = CSVFormat.DEFAULT.withHeader(FILE_HEADER).withSkipHeaderRecord();
//        writer.write(String.join(",", FILE_HEADER) + ",operator");
//        writer.newLine();
//
//        try(Reader in = new FileReader("/Users/sh/Downloads/mobile.csv")) {
//            Iterable<CSVRecord> records = format.parse(in);
//            for (CSVRecord record : records) {
//                if (isIndosat(record.get(FILE_HEADER[2]))) {
//                    writer.write(record.get(FILE_HEADER[0]) + "," + record.get(FILE_HEADER[1]) + "," + record.get(FILE_HEADER[2]) + ",INDOSAT");
//                } else if (isTelkomsel(record.get(FILE_HEADER[2]))) {
//                    writer.write(record.get(FILE_HEADER[0]) + "," + record.get(FILE_HEADER[1]) + "," + record.get(FILE_HEADER[2]) + ",TELKOMSEL");
//                } else {
//                    writer.write(record.get(FILE_HEADER[0]) + "," + record.get(FILE_HEADER[1]) + "," + record.get(FILE_HEADER[2]) + ",OTHERS");
//                }
//                writer.newLine();
//            }
//        } finally {
//            writer.flush();
//        }
//    }

        public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/sh/Downloads/t_apps_14.sql")));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("/Users/sh/Downloads/t_apps_trim_14.sql"))));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String content = line.toLowerCase().replaceAll("\\s+","");
            writer.write(content);
            writer.newLine();
        }
        writer.flush();
    }

}
