package main.java;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String... args)
    throws IOException, GeneralSecurityException {
        Sheets service = Utils.getSheets();
        String ssID = "1vnnirg2W_QnRa8Se_yxe1ytj3lHRXkR58LpNCfZcXg8";
        String range = "Sheet1!A1:C";
        List<List<Object>> writeData = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Object> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                row.add(Math.round(Math.random() * 10));
            }
            writeData.add(row);
        }
        ValueRange vr = new ValueRange().setValues(writeData).setMajorDimension("ROWS");
        service.spreadsheets().values()
               .update(ssID, range, vr)
               .setValueInputOption("RAW")
               .execute();
    }
}