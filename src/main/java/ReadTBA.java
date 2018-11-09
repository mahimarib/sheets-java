package main.java;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ReadTBA {
    public static void main(String[] args)
    throws GeneralSecurityException, IOException {
        final String ssID = "1w0F31ObetKyrK8r2JlEsjDWk9NHcqmUsMUJmxhuVZ7o";
        final String range = "Sheet7!A2:K";
        Sheets service = Utils.getSheets();
        ValueRange response = service.spreadsheets().values()
                                     .get(ssID, range)
                                     .execute();
        List<List<Object>> values = response.getValues();
        for (List row : values) {
            System.out.println(row);
        }
    }
}
